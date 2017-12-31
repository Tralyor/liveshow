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
    layui.use(['layer', function() {
        var layer = layui.layer;
        layer.open({
            title: "",
            content: $("#login").html(),

        })
    }])
}
