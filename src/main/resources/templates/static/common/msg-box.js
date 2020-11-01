let msgBox = {
    template: `
            <template>
                <div v-show="visible" class="z-dialog-cover">
                    <div class="z-dialog-wrap" :style="'width:' + width + 'px'">
                        <div class="z-dialog-header">
                            <span>{{title}}</span>
                            <img v-show="showClose" @click="edit = false" src="/admin/static/img/icon-close.svg">
                        </div>
                        <div class="z-dialog-body">
                            {{content}}
                        </div>
                        <div class="z-dialog-action">
                            <button type="button" class="b-a p-x-1">确认</button>
                            <button type="button" class="b-a p-x-1">取消</button>
                        </div>
                    </div>
                </div>
            </template>`,
    props: {
        //是否显示左上角关闭按钮
        showClose: {
            type: Boolean,
            default: false,
            required: false
        },
        width: {
            type: Number,
            default: 500,
            required: false
        }
    },
    components: {
        //ElInput, ElButton
    },
    computed: {},
    methods: {
        getSafeClose() {
            const currentId = this.uid;
            return () => {
                this.$nextTick(() => {
                    if (currentId === this.uid) {
                        this.doClose();
                    }
                });
            };
        },
        handleAction(action) {
            this.action = action;
            if (typeof this.beforeClose === 'function') {
                this.close = this.getSafeClose();
                this.beforeClose(action, this, this.close);
            } else {
                this.doClose();
            }
        },
        handleClose() {
            this.handleAction('close');
        },
        doClose() {
            if (!this.visible) {
                return;
            }
            this.visible = false;
            setTimeout(() => {
                if (this.action) {
                    this.callback(this.action, this)
                }
            });
        }
    },
    watch: {
        visible(val) {
            if (val) {
                this.uid++;
            }
        }
    },
    mounted() {
        this.$nextTick(() => {
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
            visible: false,
            uid: 1,
            title: undefined,
            message: '',
            type: '',
            showConfirmButton: true,
            showCancelButton: false,
            action: '',
            confirmButtonText: '',
            cancelButtonText: '',
            callback: null
        };
    }
};
//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------
//------------------------------------------------------------------------------------
const MessageBoxConstructor = Vue.extend(msgBox);
let currentMsg, instance;
let msgQueue = [];
const defaults = {
    title: null,
    message: '',
    type: '',
    showClose: true,
    modalFade: true,
    closeOnHashChange: true,
    showConfirmButton: true,
    showCancelButton: false,
    confirmButtonPosition: 'right',
    confirmButtonHighlight: false,
    cancelButtonHighlight: false,
    confirmButtonText: '',
    cancelButtonText: '',
    beforeClose: null,
};
//默认回调函数
const defaultCallback = action => {
    if (currentMsg) {
        let callback = currentMsg.callback;
        if (typeof callback === 'function') {
            callback(action);
        }
        if (currentMsg.resolve) {
            if (action === 'confirm') {
                currentMsg.resolve(action);
            } else if (currentMsg.reject && (action === 'cancel' || action === 'close')) {
                currentMsg.reject(action);
            }
        }
    }
};
const initInstance = () => {
    instance = new MessageBoxConstructor({
        el: document.createElement('div')
    });
    instance.callback = defaultCallback;
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
        initInstance();
    }
    instance.action = '';
    if (!instance.visible && msgQueue.length > 0) {
        currentMsg = msgQueue.shift();
        let options = currentMsg.options;
        for (let prop in options) {
            if (options.hasOwnProperty(prop)) {
                instance[prop] = options[prop];
            }
        }
        if (options.callback === undefined) {
            instance.callback = defaultCallback;
        }
        let oldCb = instance.callback;
        instance.callback = (action, instance) => {
            oldCb(action, instance);
            showNextMsg();
        };
        if (isVNode(instance.message)) {
            instance.$slots.default = [instance.message];
            instance.message = null;
        } else {
            delete instance.$slots.default;
        }
        ['modal', 'showClose', 'closeOnHashChange'].forEach(prop => {
            if (instance[prop] === undefined) {
                instance[prop] = true;
            }
        });
        document.body.appendChild(instance.$el);
        Vue.nextTick(() => {
            instance.visible = true;
        });
    }
};
const MessageBox = function (options, callback) {
    if (typeof options === 'string' || isVNode(options)) {
        options = {
            message: options
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
        $type: 'alert'
    }, options));
};
MessageBox.close = () => {
    instance.doClose();
    instance.visible = false;
    msgQueue = [];
    currentMsg = null;
};
Vue.component(MessageBox);