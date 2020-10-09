let main = {
    data() {
        return {
            pageUrl: '/a/i/article',
            pageParam: {
                pageNum: 1,
                type: '',
                title: '',
                status: '',
                category: ''
            },
            pageInfo: {}
        };
    },
    mounted: function () {
        this.getData(1);
    },
    methods: {
        //获取文章分页数据
        getData(pageNum = 1) {
            console.log('-> ', '获取文章分页数据, pagNum: ', pageNum);
            let $vm = this;
            $vm.pageParam.pageNum = pageNum;
            blog.get({
                url: $vm.pageUrl,
                data: $vm.pageParam,
                success: (r) => {
                    console.log('-> ', '成功');
                    console.log(r);
                    $vm.pageInfo = r.data;
                },
                error: (e) => {
                    console.log('-> ', '失败');
                    console.log(e);
                }
            });
        },
    }
};