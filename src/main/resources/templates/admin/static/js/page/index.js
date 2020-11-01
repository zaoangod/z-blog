let main = {
    data() {
        return {
            edit: false,
        };
    },
    created: function () {
    },
    methods: {
        //获取数据
        showA(mid) {
            /*MessageBox.alert('这是一段内容1', '标题名称').then(function () {
                console.log('-> 确认');
            }).catch(function () {
                console.log('-> 取消');
            });*/
            MessageBox.alert('这是一段内容').then(function () {
                console.log('-> 确认');
            }).catch(function () {
                console.log('-> 取消');
            });
        },
    }
};