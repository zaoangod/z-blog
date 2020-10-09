let main = {
    data() {
        return {
            pageUrl: '/a/i/article',
            editor: null,
            article: {
                content: '## 只求极致\n' +
                    '[ **M** ] arkdown + E [ **ditor** ] = **Mditor**  \n' +
                    '> Mditor 是一个简洁、易于集成、方便扩展、期望舒服的编写 markdown 的编辑器，仅此而已...',
            }
        };
    },
    mounted: function () {
    },
    created: function () {
    },
    mounted: function () {
        this.createEditor();
    },
    methods: {
        createEditor() {
            let $vm = this;
            $vm.editor = Mditor.fromTextarea($vm.$refs.editor);
        }
    }
};

/*
var textarea = document.getElementById('editor');
var mditor = Mditor.fromTextarea(textarea);
mditor.on('ready', function () {
    console.log('mditor', mditor);
    console.log('toolbar', mditor.toolbar);
    mditor.on('changed', function () {
        //console.log('changed',mditor.value);
    });
    mditor.editor.on('drop', function (event) {
        console.log('drop', event);
    });
    mditor.editor.on('paste', function (event) {
        console.log('paste', event.clipboardData.types);
    });
    mditor.on('head-dblclick', function () {
        console.log('head-dblclick');
    });
});*/
