function nothingDoFun()
{
}

function flush()
{
    location = location;
}

function layerMsg(show, fun1, fun2)
{
    if(show.state == 1)
    {
        layer.msg(show.message, {
            icon: 1,
            time: 2000
        }, function()
        {
            fun1();
        });
    }
    else
    {
        layer.msg(show.message, {
            icon: 2,
            time: 2000
        }, function()
        {
            fun2();
        });
    }
}
