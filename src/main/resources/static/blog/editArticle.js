$(function () {
    var textarea = document.getElementById('articleContentEditor');
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
    });

    $('#addArticleBtn').on('click', function () {
        saveArticle()
    })

    function saveArticle() {
        $.ajax({
            url: "updateArticle",
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