/*window.axios.defaults.headers.common = {
    //'X-CSRF-TOKEN': document.head.querySelector("[name=csrf_token]").content,
    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
    'X-Requested-With': 'XMLHttpRequest'
};*/
const request = axios.create({
    baseURL: '/',
    timeout: 10000,
    headers: {}
});
/** axios 拦截器 */
request.interceptors.request.use(config => {
    blog.loadingProgress();
    return config;
}, err => {
    console.log(err);
    blog.loadingProgress('hide');
    return Promise.reject(err);
});
request.interceptors.response.use(response => {
    blog.loadingProgress('hide');
    return response;
}, function (err) {
    blog.loadingProgress('hide');
    return Promise.reject(err);
});
//
let blog = {
    loadingProgress: function (model) {
        /*if (!model) {
            document.getElementById('loadingProgress').style.display = 'block';
        } else {
            document.getElementById('loadingProgress').style.display = 'none';
        }*/
    },
    get: function (option) {
        option.data = option.data || {};
        option.data._t = Date.now();
        return request({
            url: option.url,
            method: 'get',
            params: option.data
        }).then((response) => {
            option.success && option.success(response.data);
        }).catch((error) => {
            console.log('base -> get -> error:\n');
            console.log(error);
            option.error && option.error(error);
        });
    },
    post: function (option) {
        option.data = option.data || {};
        option.data._t = Date.now();
        return request({
            url: option.url,
            method: 'post',
            params: option.data
        }).then((response) => {
            option.success && option.success(response.data);
        }).catch((error) => {
            console.log('base -> get -> error:\n');
            console.log(error);
            option.error && option.error(error);
        });
    },
    /*delete: function (options) {
        return axios.delete(options.url, {data: options.data || {}}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            console.log('base -> delete -> error:\n');
            console.log(error);
            options.error && options.error(error);
        });
    },
    put: function (options) {
        return axios.put(options.url, options.data || {}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            console.log('base -> put -> error:\n');
            console.log(error);
            options.error && options.error(error);
        });
    },*/
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
/** Vue 全局 */
Vue.filter('formatUnix', function (value, pattern) {
    if (value) {
        // return moment.unix(value).format(pattern || 'YYYY-MM-DD HH:mm:ss')
        return value;
    }
    return ''
});
Vue.filter('truncate', function (value, size = 10, append = '...') {
    if (value && value.length >= size) {
        // return value.substring(0, size) + append;
        return;
    }
    return value;
});