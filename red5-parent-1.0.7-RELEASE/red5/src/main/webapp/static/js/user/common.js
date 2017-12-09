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
        }, function(){
            fun();
        });
    }
    else
    {
        layer.msg(show.message, {
            icon: 2,
            time: 2000
        }, function(){
            fun();
        });
    }
}
