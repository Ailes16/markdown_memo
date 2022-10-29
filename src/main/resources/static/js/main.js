$(function(){
    // memo-listのトグル
    $(".directory-name").click(function(){
        $(this).next(".memo-list").slideToggle("fast");
    });

    // memo-name押下時の処理
    $(".memo-name").click(function(){
        const targetMemo = memoList.find((v) => v.memoId == $(this).attr("id"));
        $("#memo-content").html(marked.parse(targetMemo.content));
        hljs.initHighlightingOnLoad();
        $(".edit-wrapper").addClass("active");
        $(".edit-menu").find("#update-memoId").val(targetMemo.memoId);
        $(".edit-menu").find("#delete-memoId").val(targetMemo.memoId);
    });

    // delete-btn押下時の処理
    $("#delete-btn").click(function(){
        if(!confirm("削除してもよろしいですか？")) {
            return false;
        }
    });

    // preview機能
    $("#contentInput").on("input",function(){
        $("#preview").html(marked.parse($("#contentInput").val()));
        hljs.initHighlightingOnLoad();
    });

    // login formの処理
    const formInput = $(".formInput");
    formInput.focus(function(){
        $(this).parent().children(".formLabel").addClass("formTop");
        $(".form-logo").addClass("logo-active");
    });
    formInput.focusout(function(){
        if ($(this).val().length == 0){
            $(this).parent().children(".formLabel").removeClass("formTop");
        }
        $(".form-logo").removeClass("logo-active");
    });
    $(".formLabel").click(function(){
        $(this).parent().children(".formInput").focus();
    });

    // password確認
    function eyeslashClick(){
        $(".fa-eye-slash").click(function(){
            $(".fa-eye-slash").off("click"); // 重複対策
            $(this).parents(".form-item").children(".formInput").attr("type", "text");
            $(this).removeClass();
            $(this).addClass("fa-solid fa-eye");
            eyeClick(); // click eventの追加
        });
    };
    function eyeClick(){
        $(".fa-eye").click(function(){
            $(".fa-eye").off("click"); // 重複対策
            $(this).parents(".form-item").children(".formInput").attr("type", "password");
            $(this).removeClass();
            $(this).addClass("fa-solid fa-eye-slash");
            eyeslashClick(); // click eventの追加
        });
    };
    $(".passwordCheck").click(function(){
        $(this).parent().children(".formInput").focus();
    });
    eyeslashClick();
    eyeClick();
});