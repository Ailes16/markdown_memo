$(function(){
    // memo-listのトグル
    $(".directory-name").click(function(){
        $(this).next(".memo-list").slideToggle("fast");
    });

    // $("#memo-content").html(marked.parse(content));

    // highlight.jsの呼び出し
    hljs.initHighlightingOnLoad();

    // preview機能
    $("#contentInput").on("input",function(){
        $("#preview").html(marked.parse($("#contentInput").val()));
        hljs.initHighlightingOnLoad();
    });
    // markdown memoの表示 TODO: 修正
    // function showContent(){
    //     $("#memo-content").html(marked.parse(content));
    //     hljs.initHighlightingOnLoad();
    // }
});