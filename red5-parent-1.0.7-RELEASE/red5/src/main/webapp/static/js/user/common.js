/**
 * Created by asus on 2017/12/9.
 */
function nothingDoFun()
{
}
function flush()
{
    location = location;
}
function locationToIndex()
{
    location = "/person/";
}
function layerMsg(show, fun)
{
    if(show.state == 1)
    {
        layer.msg(show.message, {
            icon: 1,
            time: 2000
        }, function()
        {
            fun();
        });
    }
    else
    {
        layer.msg(show.message, {
            icon: 2,
            time: 2000
        }, function()
        {
            fun();
        });
    }
}
//图片上传预览
function preview(file, id)
{
    var picImg = document.getElementById(id);
    if(file.files && file.files[0])
    {
        console.log(file.files);
        var reader = new FileReader();
        reader.onload = function(evt)
        {
            picImg.src = evt.target.result;
        };
        reader.readAsDataURL(file.files[0]);
    } else
    {
        picImg.style =
            "filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'";
    }
}

//显示登录框
function showLogin()
{
    layer.open({
        title: "",
        content: $("#loginDiv").html(),
        area: ['500px', '500px'],
        btn: [],
    })
}

$(document).on("click", "ul.login-tab-title li", function() {
    //第几个li
    var index = $("ul.login-tab-title li").index(this);
    //击中的选项卡添加class
    $(this).addClass("login-this").siblings().removeClass("login-this");
    //显示对应的内容
    $(".login-tab-content").children(".login-tab-item").eq(index).addClass("login-show").siblings().removeClass("login-show");
});

$(document).on("click", "#loginA", function() {
    showLogin();
});

$(document).on("click", "#registerA", function() {
    showLogin();
    $("ul.login-tab-title li").eq(1).click();
});

$(document).on("click", "#login", function() {
    var loginName = $("#loginName").val();
    var password = $("#password").val();

    $.ajax({
        url: "/user/login",
        type: "post",
        data: "loginName=" + loginName + "&password=" + password,
        dataType: "json",
        success: function(show) {
            if(show.status == 0)
            {
                layerMsg(show, nothingDoFun);
            }
            else
            {
                layerMsg(show, flush);
            }
        }
    });

    return false;
});

$(document).on("click", "#register", function() {
    var loginName = $("#registerLoginName").val();
    var password = $("#registerPassword").val();
    var nickName = $("#registerNickName").val();

    $.ajax({
        url: "/user/register",
        type: "post",
        data: "loginName=" + loginName + "&password=" + password + "&nickName=" + nickName,
        dataType: "json",
        success: function(show) {
            if(show.status == 0)
            {
                layerMsg(show, nothingDoFun);
            }
            else
            {
                layerMsg(show, flush);
            }
        }
    });

    return false;
});
