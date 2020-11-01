let ZMessageUtil = {
    template: `
        <template>
            <transition name="msg-box-fade">
                <div v-show="visible" class="z-dialog-cover">
                    <div class="z-dialog-wrap" :style="'width:'+width+'px'">
                        <div class="z-dialog-header" v-show="title">{{title}}</div>
                        <div class="z-dialog-body">{{content}}</div>
                        <div class="z-dialog-action" v-show="showConfirmButton == true || showCancelButton == true">
                            <button type="button" @click="handleAction('confirm')" v-show="showConfirmButton">{{confirmButtonText?confirmButtonText:'确认'}}</button>
                            <button type="button" @click="handleAction('cancel')" v-show="showCancelButton">{{cancelButtonText?cancelButtonText:'取消'}}</button>
                      </div>
                    </div>
                </div>
            </transition>
        </template>`,
    props: {
        //宽度
        width: {
            type: Number,
            default: 300,
            required: false
        }
    },
    methods: {
        handleAction(action) {
            this.action = action;
            this.doClose();
        },
        doClose() {
            if (!this.visible) {
                return;
            }
            this.visible = false;
            setTimeout(() => {
                if (this.action) {
                    this.callback(this.action, this);
                }
            });
        },
        startTimer() {
            console.log('-> ' + this.type)
            if (this.duration > 0 && this.type === 'toast') {
                this.timer = setTimeout(() => {
                    if (this.visible) {
                        this.doClose();
                    }
                }, this.duration);
            }
        }
    },
    created() {
        this.$nextTick(() => {
            this.startTimer();
            /*if (this.closeOnHashChange) {
                window.addEventListener('hashchange', this.close);
            }*/
        });
    },
    beforeDestroy() {
        /*if (this.closeOnHashChange) {
            window.removeEventListener('hashchange', this.close);
        }*/
    },
    data() {
        return {
            uid: 1,
            duration: 3000,
            timer: null,
            visible: false,
            title: undefined,
            content: '',
            type: '',
            showConfirmButton: true,
            showCancelButton: false,
            confirmButtonText: '',
            cancelButtonText: '',
            beforeClose: null,
            callback: null
        };
    }
};
//------------------------------------------------------------------------------------
const zMsgUtilConstructor = Vue.extend(ZMessageUtil);
let zCurrentMsg;
let instance;
let msgQueue = [];
const defaults = {
    duration: 3000,
    visible: false,
    title: undefined,
    content: '',
    type: '',
    showConfirmButton: true,
    showCancelButton: false,
    confirmButtonText: '',
    cancelButtonText: '',
    beforeClose: null,
    callback: null
};
//默认回调函数
const zDefaultCallback = action => {
    if (zCurrentMsg) {
        let callback = zCurrentMsg.callback;
        if (typeof callback === 'function') {
            callback(action);
        }
        if (zCurrentMsg.resolve) {
            if (action === 'confirm') {
                zCurrentMsg.resolve();
            } else if (zCurrentMsg.reject && (action === 'cancel' || action === 'close')) {
                zCurrentMsg.reject();
            }
        }
    }
};
//创建实例
const zCreateInstance = () => {
    instance = new zMsgUtilConstructor({
        el: document.createElement('div')
    });
    instance.callback = zDefaultCallback;
};

//判断是否VNode
function isVNode(node) {
    return node !== null && typeof node === 'object' && Object.prototype.hasOwnProperty.call(node, 'componentOptions');
}

//合并对象
function merge(target) {
    for (let i = 1, j = arguments.length; i < j; i++) {
        let source = arguments[i] || {};
        for (let prop in source) {
            if (source.hasOwnProperty(prop)) {
                let value = source[prop];
                if (value !== undefined) {
                    target[prop] = value;
                }
            }
        }
    }
    return target;
}

const showNextMsg = () => {
    if (!instance) {
        zCreateInstance();
    }
    instance.action = '';
    if (!instance.visible && msgQueue.length > 0) {
        zCurrentMsg = msgQueue.shift();
        let options = zCurrentMsg.options;
        for (let prop in options) {
            if (options.hasOwnProperty(prop)) {
                instance[prop] = options[prop];
            }
        }
        if (options.callback === undefined || options.callback === null) {
            instance.callback = zDefaultCallback;
        }
        let oldCb = instance.callback;
        instance.callback = (action, instance) => {
            oldCb(action, instance);
            showNextMsg();
        };
        if (isVNode(instance.content)) {
            instance.$slots.default = [instance.content];
            instance.content = null;
        } else {
            delete instance.$slots.default;
        }
        document.body.appendChild(instance.$el);
        Vue.nextTick(() => instance.visible = true);
    }
};
const MessageBox = function (options, callback) {
    if (typeof options === 'string' || isVNode(options)) {
        options = {
            content: options
        };
        if (typeof arguments[1] === 'string') {
            options.title = arguments[1];
        }
    } else if (options.callback && !callback) {
        callback = options.callback;
    }
    if (typeof Promise !== 'undefined') {
        return new Promise((resolve, reject) => {
            msgQueue.push({
                options: merge({}, defaults, MessageBox.defaults, options),
                callback: callback,
                resolve: resolve,
                reject: reject
            });
            showNextMsg();
        });
    } else {
        msgQueue.push({
            options: merge({}, defaults, MessageBox.defaults, options),
            callback: callback
        });
        showNextMsg();
    }
};
MessageBox.close = () => {
    instance.doClose();
    instance.visible = false;
    instance.timer = null;
    msgQueue = [];
    zCurrentMsg = null;
};
MessageBox.setDefaults = defaults => {
    MessageBox.defaults = defaults;
};
MessageBox.alert = (content, title, options) => {
    if (typeof title === 'object') {
        options = title;
        title = '';
    } else if (title === undefined) {
        title = '';
    }
    return MessageBox(merge({
        title: title,
        content: content,
        type: 'alert',
        showConfirmButton: true,
        showCancelButton: false,
    }, options));
};
MessageBox.confirm = (content, title, options) => {
    if (typeof title === 'object') {
        options = title;
        title = '';
    } else if (title === undefined) {
        title = '';
    }
    return MessageBox(merge({
        title: title,
        content: content,
        type: 'confirm',
        showConfirmButton: true,
        showCancelButton: true,
    }, options));
};
MessageBox.toast = (content) => {
    return MessageBox(merge({
        title: undefined,
        content: content,
        type: 'toast',
        showConfirmButton: false,
        showCancelButton: false,
    }));
};
Vue.component(MessageBox);