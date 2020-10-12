let main = {
    data() {
        return {
            edit: false,
            url: '/a/i/meta',
            formData: {},
            pageParam: {title: '', type: ''},
            pageInfo: {list: []}
        };
    },
    created: function () {
        this.getData();
    },
    methods: {
        //获取数据
        getData() {
            console.log('-> 获取数据列表');
            let $vm = this;
            blog.get({
                url: $vm.url,
                data: $vm.pageParam,
                success: (r) => {
                    console.log('-> ', '成功');
                    console.log(r);
                    $vm.pageInfo.list = r.data;
                    console.log($vm.pageInfo.list);
                },
                error: (e) => {
                    console.log('-> ', '失败');
                    console.log(e);
                }
            });
        },
        getDetail(mid) {
            console.log('-> 获取数据项');
            let $vm = this;
            return blog.get({
                url: $vm.url + '/' + mid,
                success: (r) => {
                    $vm.formData = r.data;
                    console.log($vm.formData);
                },
                error: (e) => {
                    console.log('-> ', '失败');
                    console.log(e);
                }
            });
        },
        editHandle(mid) {
            console.log('-> 编辑数据');
            let $vm = this;
            $vm.getDetail(mid).then(function () {
                $vm.edit = true;
            });
        },
        submitHandle() {
            console.log('-> 提交数据');
            let $vm = this;
            return blog.post({
                url: $vm.url,
                data: $vm.formData,
                success: (r) => {
                    console.log(r);
                },
                error: (e) => {
                    console.log('-> ', '失败');
                    console.log(e);
                }
            });
        },
        deleteHandle(mid) {

        },
    }
};