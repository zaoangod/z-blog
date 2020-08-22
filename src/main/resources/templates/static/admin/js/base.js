window.axios.defaults.headers.common = {
    //'X-CSRF-TOKEN': document.head.querySelector("[name=csrf_token]").content,
    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
    'X-Requested-With': 'XMLHttpRequest'
};
tale = {
    loadingProgress: function (model) {
        /*if (!model) {
            document.getElementById('loadingProgress').style.display = 'block';
        } else {
            document.getElementById('loadingProgress').style.display = 'none';
        }*/
    },
    get: function (options) {
        axios.get(options.url, {
            params: options.data || {}
        }).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            console.log('base -> get -> error:\n');
            console.log(error);
            options.error && options.error(error);
        });
    },
    post: function (options) {
        axios.post(options.url, options.data || {}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            console.log('base -> post -> error:\n');
            console.log(error);
            options.error && options.error(error);
        });
    },
    delete: function (options) {
        axios.delete(options.url, {data: options.data || {}}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            console.log('base -> delete -> error:\n');
            console.log(error);
            options.error && options.error(error);
        });
    },
    put: function (options) {
        axios.put(options.url, options.data || {}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            console.log('base -> put -> error:\n');
            console.log(error);
            options.error && options.error(error);
        });
    },
    maxFiles: function () {
        return 10;
    },
    copy: function (src) {
        let dst = {};
        for (let prop in src) {
            if (src.hasOwnProperty(prop)) {
                dst[prop] = src[prop];
            }
        }
        return dst;
    }
};
/** axios 拦截器 */
axios.interceptors.request.use(config => {
    tale.loadingProgress();
    return config;
}, err => {
    console.log(err);
    tale.loadingProgress('hide');
    return Promise.reject(err);
});
axios.interceptors.response.use(response => {
    tale.loadingProgress('hide');
    return response;
}, function (err) {
    tale.loadingProgress('hide');
    return Promise.reject(err);
});
/** Vue 全局 */
Vue.filter('formatUnix', function (value, pattern) {
    if (value) {
        return moment.unix(value).format(pattern || 'YYYY-MM-DD HH:mm:ss')
    }
    return ''
});
Vue.filter('truncate', function (value, size = 10, append = '...') {
    if (value && value.length >= size) {
        return value.substring(0, size) + append;
    }
    return value;
});