<%@ page language="java" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/user/liveshow.css">
    <link rel="stylesheet" type="text/css" href="/static/barrage/static/css/style.css"/>
    <link rel="stylesheet" type="text/css" href="/static/barrage/dist/css/barrager.css">
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        a, a:hover, a:active, a:visited {
            text-decoration: none;
        }

        textarea {
            resize: none;
            overflow: hidden;
        }

    </style>

</head>
<body>
<script type="text/javascript" src="play/js/swfobject.js"></script>

<div id="main">
    <div id="controlBar" style="width: 100%;height: 60px;margin-bottom: 10px">
        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
        <span>串流码</span>
        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
        <span>关闭直播/开启直播</span>
    </div>
    <div id="playBody">
        <div id="playTitle">
            <div id="headPic">
                <img src="static/img/cute.png" alt="">
            </div>
            <div id="headContent">
                <div style="height: 32%;"><h4>这里是标题</h4></div>
                <div style="height: 30%;color: #838C9A">xxx板块 <span class="glyphicon glyphicon-triangle-right"
                                                                    aria-hidden="true"></span> xxx模块
                </div>
                <div style="height:20%;">主播名 <span class="glyphicon glyphicon-fire" style="color: #FF7676"
                                                   aria-hidden="true"></span> 人数
                </div>
                <div id="care">
                    <div id="careButton"
                         style="text-align: center;height:30px;line-height:30px;overflow:hidden;background-color:#FF7700;;border-radius: 15px 0 0 15px ;">
                        <a href="" style="color: white">
                                <span class="glyphicon glyphicon-heart" aria-hidden="true" style="color: #FCB87D">
                                </span>
                            <span>关注</span>
                        </a>
                    </div>
                    <div id="careNum"
                         style="text-align: center;height:30px;line-height:30px;overflow:hidden;background-color: #ffffff;margin-left:-5px;border-radius:  0 15px 15px 0 ;border:solid 1px #E5E4E4;">
                        12222
                    </div>
                </div>
                <div id="manageButton">
                    <div id="seal" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">封禁</div>
                    <div id="recommend">推荐</div>
                </div>
            </div>
        </div>
        <div class="video" id="CuPlayer">
            <b> <img src="play/images/loading.gif"/> 网页视频播放器加载中，请稍后...</b>
        </div>
    </div>
    <div id="chatBox">
        <div id="chatView">
            <ul class="ulDanmaku">
                <li class="danmakuUser">
                    <p><span>userName</span>&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;主播玩的真棒</p>
                </li>
            </ul>
        </div>
        <div id="chatSend">
            <textarea id="sendContent" placeholder="试着和大家聊天吧"></textarea>
            <div id="sendButton">发送</div>
        </div>
    </div>
    <div id="notif"
         style="border: solid 1px #E5E4E4; height: 150px;border-radius:1%;width: 80%; margin: 0 auto;margin-top: 15px">
        <h3 style="text-align: center">直播公告</h3>
        <div style="text-align: center;width: 80%;height: 80px;line-height:80px; margin: 0 auto">
            <span>xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx</span>
        </div>
    </div>
</div>
<!--拟态框-->


<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="exampleModalLabel">举报内容</h4>
            </div>
            <div class="modal-body">
                <form enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="recipient-name" class="control-label">举报名</label>
                        <input type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="form-group">
                        <label for="message-text" class="control-label">Message:</label>
                        <textarea class="form-control" id="message-text"></textarea>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputFile">File input</label>
                        <input type="file" id="exampleInputFile">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Send message</button>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript" src="/static/barrage/static/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/static/barrage/static/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/static/barrage/static/js/tinycolor-0.9.15.min.js"></script>
<script type="text/javascript" src="/static/barrage/dist/js/jquery.barrager.js"></script>

<script type="text/javascript" src="/static/js/config/rtmpConfig.js"></script>
<script>
    var fatherWidth = $("#main").width();
    var playBody = fatherWidth * 0.7;
    var _width = playBody + ""; //播放器属性
    var _height = "460";
    var _stream = "cat";

    /**
     * 设置基本框架
     *
     */
    $("#controlBar").css("width", fatherWidth - 45);
    $("#playBody").css("width", playBody);
    $("#CuPlayer").css("width", playBody);

    /**
     *自适应聊天框的宽度
     */
    var fWidth = $("#main").width();
    var lWidth = $("#playBody").width();
    $("#chatBox").css("width", fWidth - lWidth - 50 + 'px');

    /**
     * 自适应头部信息
     */
    var fatherWidth = $("#playBody").width();
    $("#headContent").css("width", fatherWidth - 110 + 'px');


    function createFlash(width, height, stream, rtmpIp) {
        var so = new SWFObject("play/player.swf", "ply", width, height, "9", "#000000");
        so.addParam("allowfullscreen", "true");
        so.addParam("allowscriptaccess", "always");
        so.addParam("wmode", "opaque");
        so.addParam("quality", "high");
        so.addParam("salign", "lt");
        <!-- HTML代码参数/Begin -->
        so.addVariable("JcScpServer", rtmpIp); //您的rtmp流媒体服务器地址 
        so.addVariable("JcScpVideoPath", stream); //流名称
        so.addVariable("JcScpImg", "play/images/startpic.jpg"); //视频缩略图
        so.addVariable("JcScpFile", "play/CuSunV4set.xml"); //配置文件
        <!-- HTML代码参数/End -->
        so.write("CuPlayer");
    }

    createFlash(_width, _height, _stream, _rtmpIp);

    window.onresize = function () {
        var fatherWidth = $("#main").width();
        var playBody = fatherWidth * 0.7;
        var _width = playBody + ""; //播放器属性
        var _height = "460";

        /**
         * 设置基本框架
         *
         */
        $("#controlBar").css("width", fatherWidth - 45);
        $("#playBody").css("width", playBody);
        $("#CuPlayer").css("width", playBody);

        /**
         *自适应聊天框的宽度
         */
        var fWidth = $("#main").width();
        var lWidth = $("#playBody").width();
        $("#chatBox").css("width", fWidth - lWidth - 50 + 'px');

        /**
         * 自适应头部信息
         */
        var fatherWidth = $("#playBody").width();
        $("#headContent").css("width", fatherWidth - 110 + 'px');

        createFlash(_width, _height, _stream, _rtmpIp);

    }


</script>

<script>
    //    发送弹幕
    var item = {
        img: 'static/img/cute.png', //图片 
        info: '弹幕文字信息', //文字 
        href: '#', //链接 
        close: true, //显示关闭按钮 
        speed: 6, //延迟,单位秒,默认6 
        bottom: 0, //距离底部高度,单位px,默认随机 
        color: '#fff', //颜色,默认白色 
        old_ie_color: '#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
    }
    $('#CuPlayer').barrager(item);
</script>

<script>
    /**
     * 控制弹窗
     */
    $('#exampleModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var recipient = button.data('whatever') // Extract info from data-* attributes
        // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
        // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
//        var modal = $(this)
//        modal.find('.modal-title').text('New message to ' + recipient)
//        modal.find('.modal-body input').val(recipient)
    })

</script>


<script>
//    聊天部分
    function chatMessage(userName,message){
        var liDom = "<li class=\"danmakuUser\"><p><span>"  + userName+ "</span>&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;"+message+"</p> </li>";
        $(".ulDanmaku").append(liDom);
    }
   
    chatMessage("xxxx","Xxxxxxxxxxxxxxxxx");
    
    //    websocket实现部分
//    var userAndRoom = {
//        "user": [
//            {
//                "id": 1,
//                "password": "123",
//                "loginName": "123",
//                "nickName": "小甜甜",
//                "type": 1
//            }
//        ],
//        "roomId": "1"
//    }


    var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8080/danmakuChat/" + 1); //房间号 
    }
    else {
        alert('Not support websocket');
    }

    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("error");
    };

    //连接成功建立的回调方法
    websocket.onopen = function (event) {
        setMessageInnerHTML("open");
    };

    //接收到消息的回调方法
    websocket.onmessage = function () {
        setMessageInnerHTML(event.data);
    };

    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("close");
    };

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        websocket.close();
    };

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('message').innerHTML += innerHTML + '<br/>';
    }

    //关闭连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        websocket.send(message);
    }

</script>
</body>
</html>
