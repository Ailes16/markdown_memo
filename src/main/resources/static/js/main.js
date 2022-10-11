$(function(){
    // memo-listのトグル
    $(".directory-name").click(function(){
        $(this).next(".memo-list").slideToggle("fast");
    });

    // memo-name押下時の処理
    $(".memo-name").click(function(){
        const targetMemo = memoList.find((v) => v.id == $(this).attr("id"));
        $("#memo-content").html(marked.parse(targetMemo.content));
        hljs.initHighlightingOnLoad();
    });

    // preview機能
    $("#contentInput").on("input",function(){
        $("#preview").html(marked.parse($("#contentInput").val()));
        hljs.initHighlightingOnLoad();
    });
});