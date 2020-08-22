try {
    window.axios.defaults.headers.common = {
        //'X-CSRF-TOKEN': document.head.querySelector("[name=csrf_token]").content,
        'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
        'X-Requested-With': 'XMLHttpRequest'
    };
} catch (e) {
    console.log(e);
}
tale = {
    get: function (options) {
        axios.get(options.url, {
            params: options.data || {}
        }).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            options.error && options.error(error);
        });
    },
    post: function (options) {
        axios.post(options.url, options.data || {}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            options.error && options.error(error);
        });
    },
    del: function (options) {
        axios.delete(options.url, options.data || {}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            options.error && options.error(error);
        });
    },
    put: function (options) {
        axios.put(options.url, options.data || {}).then((response) => {
            options.success && options.success(response.data);
        }).catch((error) => {
            options.error && options.error(error);
        });
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

function subComment() {
    //let data = new FormData();
    let data = new URLSearchParams();
    data.append('aid', document.getElementById('aid').value);
    data.append('author', document.getElementById('author').value);
    data.append('mail', document.getElementById('mail').value);
    data.append('url', document.getElementById('url').value);
    data.append('content', document.getElementById('content').value);

    console.log(document.getElementById('aid').value);

    tale.post({
        url: '/a/comment',
        data: data,
        success: function (result) {
            if (Number(result.code) === 0) {
                alert('评论成功');
                //location.reload();
            } else {
                alert('评论失败, ' + result.msg);
            }
        },
        error: function (error) {
            console.log(error);
            alert('评论失败');
        }
    });
}

//代码高亮
function codeHighlight() {
    document.querySelectorAll('pre code').forEach((i) => {
        hljs.highlightBlock(i);
    });
}

function cancelReply() {
    let commentCancelBtn = document.getElementById('commentCancelBtn');
    commentCancelBtn.style.display = 'none';
    let respond = document.getElementById('respond');
    respond.remove();
    let commentsContainer = document.getElementById('comments');
    commentsContainer.append(respond);
    document.getElementById('cid').value = '';
    document.getElementById('content').value = '';
}

window.onload = () => {
    //代码高亮
    codeHighlight();
    //
    /*document.getElementById('showBar').addEventListener('click', function () {
        document.getElementById('mobileBar').style.display;
        let mobileBar = document.getElementById('mobileBar');
        let status = mobileBar.style.display;
        if (status === 'none') {
            mobileBar.style.display = '';
            mobileBar.classList.remove('scale-out-ver-top');
            mobileBar.classList.add('scale-in-ver-top');
        } else {
            mobileBar.classList.remove('scale-in-ver-top');
            mobileBar.classList.add('scale-out-ver-top');
            setTimeout(function () {
                mobileBar.style.display = 'none';
            }, 500);
        }
    });*/
    //捐赠按钮事件
    let donate = document.getElementById('donate');
    if (donate) {
        donate.addEventListener('click', () => {
            let QR_display = document.getElementById('QR').style.display;
            if (QR_display === 'flex') {
                document.getElementById('QR').style.display = 'none';
            } else {
                document.getElementById('QR').style.display = 'flex';
            }
        });
    }
    //评论按钮事件
    let replyBtnList = document.querySelectorAll('.comment-reply-button');
    if (replyBtnList) {
        replyBtnList.forEach(i => {
            i.addEventListener('click', () => {
                let respondContainerId = i.getAttribute('respond_container_id');
                let respond = document.getElementById('respond');
                //显示取消按钮
                document.getElementById('commentCancelBtn').style.display = 'block';
                //删除底部评论from
                respond.remove();
                //
                document.getElementById(respondContainerId).innerHTML = respond.outerHTML;
                //
                document.getElementById('coid').value = i.getAttribute('coid');
            });
        });
    }
};