$(function () {

        //写文章 mditor
        var mditor = Mditor.fromTextarea(document.getElementById('articleContentEditor'));

        //是否打开分屏
        mditor.split = true;    //打开
        //是否打开预览
        mditor.preivew = true;  //打开
        //是否全屏
        mditor.fullscreen = false;  //关闭
        //获取或设置编辑器的值
        mditor.on('ready', function () {
            mditor.value = '# ';
        });
        hljs.initHighlightingOnLoad();
        //源码高亮
        $('pre code').each(function (i, block) {
            hljs.highlightBlock(block);
        });


        $('#addArticleBtn').on('click', function () {
            saveArticle()
        })

        function saveArticle() {
            $.ajax({
                url: "saveArticle",
                data: $('#addArticleForm').serialize(),
                type: "POST",
                async: false,
                success: function (resp) {
                    if (resp) {
                        saveArticleSuccess(resp)
                    } else {
                        saveArticleFail()
                    }
                },
                error: function () {
                    saveArticleFail()
                }
            })
        }

        function saveArticleSuccess(resp) {
            alert('保存成功: ' + JSON.stringify(resp))
            window.open('detailArticleView?id=' + resp.id)
        }

        function saveArticleFail() {
            alert("保存失败！")
        }


})
