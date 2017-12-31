<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <%@ include file="../common/resources.jsp"%>
    <link rel="stylesheet" href="/static/css/user/liveshow.css">
    <link rel="stylesheet" href="/static/barrage/static/css/style.css"/>
    <link rel="stylesheet" href="/static/barrage/dist/css/barrager.css">
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
        #careButton{
            cursor: pointer;
        }
    </style>

</head>
<body>
<script type="text/javascript" src="/play/js/swfobject.js"></script>
<nav class="navbar navbar-inverse navbar-fixed-top live-shadow" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <!-- <a class="navbar-brand" href="#">菜鸟教程</a> -->
                    <div style="line-height: 50px;">
                        <img src="../static/img/tmp.png" alt="">
                    </div>
                </div>

                <!-- 左边部分 -->
                <ul class="nav navbar-nav live-left">
                    <li class="">
                        <a href="#">首页</a>
                    </li>
                    <li>
                        <a href="#">
                            分类
                            <b class="live-caret"></b>
                        </a>
                        <div class="live-nav">
                            <div class="live-shadow live-border live-border-radius">
                                <div class="anim">
                                    <div class="class-main">
                                        <div class="list-wrap">
                                            <h4>热门分类</h4>
                                            <ul class="live-btns">
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="list-wrap">
                                            <h4>热门分类</h4>
                                            <ul class="live-btns">
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                                <li>
                                                    <a href="#">主机游戏</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a href="#">直播</a>
                    </li>
                </ul>

                <!-- 右边部分 -->
                <!-- <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#">
                            <span class="glyphicon glyphicon-user"></span> 注册
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <span class="glyphicon glyphicon-log-in"></span> 登录
                        </a>
                    </li>
                </ul> -->
                <div class="nav navbar-nav navbar-right">
                    <div class="live-user">
                        <div class="live-user-img">
                            <img src="../static/img/logo.jpg" alt="">
                            <div class="live-nav">
                                <div class="live-shadow live-border live-border-radius">
                                    <div class="anim">
                                        <div class="user-main">
                                            <div class="user-out">
                                                <a href="#">退出</a>
                                            </div>
                                            <div class="user-pic">
                                                <img src="../static/img/logo.jpg" alt="">
                                            </div>
                                            <div class="user-btns">
                                                <button class="btn btn-large btn-primary btn-block" type="button">个人中心</button>
                                                <button class="btn btn-large btn-primary btn-block" type="button">我的关注</button>
                                                <button class="btn btn-large btn-primary btn-block" type="button">直播设置</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
        </div>
    </div>
</nav>
<jsp:include page="../common/topNav.jsp"></jsp:include>
<jsp:include page="../common/leftNav.jsp"></jsp:include>
<div id="main">
    <div id="controlBar" style="width: 100%;height: 60px;margin-bottom: 10px">
        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
        <span>${room.streamCode}</span>
        <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
        <button type="button" class="btn btn-info" id="sbt">开启</button>
        <button type="button" class="btn btn-warning" id="ebt">关闭</button>
    </div>
    <div id="playBody">
        <div id="playTitle">
            <div id="headPic">
                <img src="${room.photo}" alt="">
            </div>
            <div id="headContent">
                <div style="height: 32%;"><h4>${room.name}</h4></div>
                <div style="height: 30%;color: #838C9A">${part.name} <span class="glyphicon glyphicon-triangle-right"
                                                                    aria-hidden="true"></span> ${module.name}
                </div>
                <div style="height:20%;">${room.nickName} <span class="glyphicon glyphicon-fire" style="color: #FF7676"
                                                                aria-hidden="true"></span> <span>${onlinePeople}</span>
               
                    <span>状态：</span><span id="state">正在直播</span>
                </div>
                <div id="care">
                    <div id="careButton"
                         style="text-align: center;height:30px;line-height:30px;overflow:hidden;background-color:#FF7700;border-radius: 15px 0 0 15px ;">
                        <a style="color: white">
                                <span class="glyphicon glyphicon-heart" aria-hidden="true" style="color: #FCB87D">
                                </span>
                            <span>关注</span>
                        </a>
                    </div>
                    <div id="careNum"
                         style="text-align: center;height:30px;line-height:30px;overflow:hidden;background-color: #ffffff;margin-left:-5px;border-radius:  0 15px 15px 0 ;border:solid 1px #E5E4E4;">
                        ${careNum}
                    </div>
                </div>
                <div id="manageButton">
                    <div id="seal">封禁</div>
                    <div id="recommend">推荐</div>
                </div>
            </div>
        </div>
        <div class="video" id="CuPlayer">
            <b> <img src="/play/images/loading.gif"/> 网页视频播放器加载中，请稍后...</b>
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
            <span>${room.notice}</span>
        </div>
    </div>
</div>

<!--拟态框-->

<template id="managerBan">
    <form id="formData" enctype="multipart/form-data">
        <div class="form-group">
            <label for="roomId" class="control-label">房间号</label>
            <input type="text" name="roomId" class="form-control" id="roomId" readonly="readonly" value="${room.id}">
        </div>
        <div class="form-group">
            <label for="reason" class="control-label">Reason:</label>
            <textarea name="reason" class="form-control"  id="reason" name="reason"></textarea>
        </div>
        <div class="form-group">
            <label class="control-label">封禁时间(小时)</label>
            <select class="form-control" name="hours">
                <option>1</option>
                <option>24</option>
                <option>48</option>
                <option>720</option>
                <option>100000000000000</option>
            </select>
        </div>
        <div class="form-group">
            <label for="file">File input</label>
            <input type="file" id="file" name="file">
        </div>
        
    </form>
</template>

<template id="anchorBan">
    <form enctype="multipart/form-data;charset=utf-8">
        <div class="form-group">
            <label  class="control-label">用户编号</label>
            <input type="text" name="danmakuId" readonly="readonly">
        </div>
        <div class="form-group">
            <label class="control-label">用户昵称</label>
            <input type="text" name="nickName" readonly="readonly">
        </div>
        <div class="form-group">
            <label class="control-label">封禁时间(小时)</label>
            <select class="form-control" id="timeF">
                <option>1</option>
                <option>24</option>
                <option>48</option>
                <option>720</option>
                <option>100000000000000</option>
            </select>
        </div>
    </form>
</template>







<script type="text/javascript" src="/static/barrage/static/js/tinycolor-0.9.15.min.js"></script>
<script type="text/javascript" src="/static/barrage/dist/js/jquery.barrager.js"></script>
<script type="text/javascript" src="/static/js/config/rtmpConfig.js"></script>
<script type="text/javascript" src="/static/plugins/layer/layer.js"></script>
<script>

    var type = "${sessionScope.user.type}";
    if(type =="1" && "${sessionScope.user.id}" != "${room.userId}"){
        type = "0";
    }
    
    console.log(type);
    var isDark = ${isDark};
    var isCare = ${isCare};
    var state = ${room.switchJudge};
    var roomIsDark= ${isDarkRoom}
    
    
    var fatherWidth = $("#main").width();
    var playBody = (fatherWidth) * 0.7;
    var _width = playBody + ""; //播放器属性
    var _height = playBody / 1.65;
    var _stream = "${room.streamCode}";
    
    if(state == true){
        createFlash(_width, _height, _stream, _rtmpIp);
    }else{
        createFlash(_width, _height, null, _rtmpIp);
    }
    

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
    $("#chatBox").height($("#playBody").height() + "px");
    console.log($("#playBody").height());

    /**
     * 自适应头部信息
     */
    var fatherWidth = $("#playBody").width();
    $("#headContent").css("width", fatherWidth - 110 + 'px');


    function createFlash(width, height, stream, rtmpIp) {
        var so = new SWFObject("/play/player.swf", "ply", width, height, "9", "#000000");
        so.addParam("allowfullscreen", "true");
        so.addParam("allowscriptaccess", "always");
        so.addParam("wmode", "opaque");
        so.addParam("quality", "high");
        so.addParam("salign", "lt");
        <!-- HTML代码参数/Begin -->
        so.addVariable("JcScpServer", rtmpIp); //您的rtmp流媒体服务器地址 
        so.addVariable("JcScpVideoPath", stream); //流名称
        so.addVariable("JcScpImg", "/play/images/startpic.jpg"); //视频缩略图
        so.addVariable("JcScpFile", "/play/CuSunV4set.xml"); //配置文件
        <!-- HTML代码参数/End -->
        so.write("CuPlayer");
    }

    window.onresize = function () {
        var fatherWidth = $("#main").width();
        var playBody = fatherWidth * 0.7;
        var _width = playBody + ""; //播放器属性
        var _height = playBody / 1.65;

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

        if(state == true){
            createFlash(_width, _height, _stream, _rtmpIp);
        }else{
            createFlash(_width, _height, null, _rtmpIp);
        }
    }


</script>
<%--控制是否关注--%>
<%--控制组件显示--%>
<%--直播状态--%>
<script>
    if (state == true){
        $("#state").html("正在直播");
        
    }else{
        $("#state").html("主播不在家");
    }
    
    
    
    if(type == "0" || type == ""){
        $("#controlBar").css("display","none");
        $("#manageButton").css("display","none");
    }else if (type == "1" ){
        $("#manageButton").css("display","none");
    }else if(type == "2"){
        $("#controlBar").css("display","none");
    }
    
    function care(isCare){
        
        if(isCare == 1){
            $("#careButton").css("background-color","gray");
            $("#careButton").empty();
            var str =  "<span style=\'color:white\'>已关注</span>";
            $("#careButton").append(str);
            
        }else{
            $("#careButton").css("background-color","#FF7700");
            $("#careButton").empty();
            var str = " <a style=\"color: white\"><span class=\"glyphicon glyphicon-heart\" aria-hidden=\"true\" style=\"color: #FCB87D\"></span><span>关注</span></a>";
            $("#careButton").append(str);
        }
    }
    care(isCare);
</script>
<%--发送弹幕--%>
<script>
    //    发送弹幕
     function sendBarrage(danmakuId,nickName,content,userId){
         var item = {
            // img: '/static/img/cute.png', //图片
             userId:userId,
             danmakuId:danmakuId,
             nickName:nickName,
             info: content, //文字
             href: '#', //链接 
             close: false, //显示关闭按钮 
             speed: 6, //延迟,单位秒,默认6 
             bottom: 0, //距离底部高度,单位px,默认随机 
             color: '#fff', //颜色,默认白色 
             old_ie_color: '#000000', //ie低版兼容色,不能与网页背景相同,默认黑色 
         }
         $('#CuPlayer').barrager(item);
     }
    
   
</script>

<%--弹窗--%>
<script>
    /**
     * 控制弹窗
     */
    $("#seal").click(function () {
        layer.open({
            title: "managerBan",
            content: $("#managerBan").html(),
            yes: function(index, layero){
                fsubmit();
                websocket.send(JSON.stringify(createDarkRoom()));
                layer.close(index); //如果设定了yes回调，需进行手工关闭
            }
        });
    });
    
    $(".video").on('click','div[id^=barrage_]',function () {
        var str = $(this).attr("name");
        var dataInfo = JSON.parse(str.toString());
        if(type == "1"){
            layer.open({
                title: "弹幕封禁",
                content: $("#anchorBan").html(),
                success:function(layero, index){
                    $('input[name="nickName"]').val(dataInfo.nickName);
                    $("input[name='danmakuId']").val(dataInfo.danmakuId);
                },
                yes: function(index, layero){
                    websocket.send(JSON.stringify(createDarkDanmaku(dataInfo.danmakuId,$("#timeF").val(),dataInfo.userId)));
                    layer.close(index); //如果设定了yes回调，需进行手工关闭
                }
            });
            
            
            
        }
    })
    
    
</script>

<%--请求--%>
<script>
    
//    关注
    $("#careButton").click(function(){
        var url;
        if(isCare == 1){
            url = "/liveShow/deleteCare";
        }else{
            url = "/liveShow/addCare";
        }
        $.ajax({
            type: "POST",
            url: url,
            dataType:"json",
            data: "roomId=${room.id}",
            success: function(data){
                if(data.state == 0){
                    alert(data.message);
                }else{
                    if(isCare == 1){
                        isCare=0;
                        var careNum = $("#careNum").html();
                        careNum = parseInt(careNum);
                        careNum--;
                        $("#careNum").html(careNum);
                    }else{
                        isCare = 1;
                        var careNum = $("#careNum").html();
                        careNum = parseInt(careNum);
                        careNum++;
                        $("#careNum").html(careNum);
                    }
                    care(isCare);
                }
             
            }
        });
    })
    
    
//    改变直播状态

$("button").click(function(){
    var s;
    if($(this).attr("id") == "ebt"){
        s = 0;
        $("#state").html("主播不在家");
    }else if($(this).attr("id") == "sbt"){
        s = 1;
        $("#state").html("正在直播");
    }
    
    if("${room.userId}" == "${sessionScope.user.id}" ){
        $.ajax({
            type: "POST",
            url: "/anchor/change",
            dataType:"json",
            data: "roomId=${room.id}&state="+s,
            success: function(data){
                websocket.send(JSON.stringify(createChatMsg(s)));
            }
        });
    }
})

//超管推荐
$("#recommend").click(function(){
    $.ajax({
        type: "POST",
        url: "/supermanager/recoRoom",
        dataType:"json",
        data: "roomId=${room.id}&managerId=${sessionScope.user.id}",
        success: function(data){
            alert(data.message);
        }
    });
})
    


</script>
<%--chat--%>
<script>
//    聊天部分
    function chatMessage(userName,message){
        var liDom = "<li class=\"danmakuUser\"><p><span>"  + userName+ "</span>&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp;&nbsp;"+message+"</p> </li>";
        $(".ulDanmaku").append(liDom);
    }

    
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
        websocket = new WebSocket("ws://"+webIp+":8080/WebScoket/" + ${room.id}); //房间号
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
        console.log("open");
    };

    //接收到消息的回调方法
    websocket.onmessage = function () {
        var msg = JSON.parse(event.data);
        console.log(msg);
        if(msg.type == "chat"){
            chatMessage(msg.content.nickName,msg.content.content);
            sendBarrage(msg.content.id,msg.content.nickName,msg.content.content,msg.content.userId);
        }else if(msg.type == "darkDanmaku"){
            isDark = 1;
            alert("你已经被主播封印了");
        }else if(msg.type=="darkRoom"){
            createFlash(_width, _height, null, _rtmpIp);
            alert("该直播间已经被封");
        }else if (msg.type == 'showState'){
            if(msg.content.state == 0){
                $("#state").html("主播不在家");
            }else if (msg.content.state == 1){
                $("#state").html("正在直播");
            }
        }
        
    };

    //连接关闭的回调方法
    websocket.onclose = function () {
       console.log("close");
    };

    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        websocket.close();
    };


    //关闭连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    $("#sendButton").click(function(){
        var str = $("#sendContent").val();
        $("#sendContent").val("");
        if(type ==""){
            alert("请先登录");
        }
        else if(isDark  == 1){
            alert("已经被主播封印");
        }else if(str==""){
            alert("请不要发空信息")
        }else{
            websocket.send(JSON.stringify(createChatMsg(str)));
        }
        
    })

   

    function createChatMsg(content){
        var message = {
            type:"chat",
            content:{
                id:null,
                userId:"${sessionScope.user.id}",
                roomId:"${room.id}",
                content:content,
                nickName:"${sessionScope.user.nickName}"
            }
        }
        return message;
    }
    
    function createDarkDanmaku(id,hours,userId){
        var message = {
            type:"darkDanmaku",
            content:{
                userId:userId,
                danmakuId:id,
                hours:hours
            }
        }
        return message;
    }
    
    function createDarkRoom(){
        var message = {
            type:"darkRoom",
            content:{
                id:"${room.id}"
            }
        }
        return message;
    }

    function showState(state){
        var message = {
            type:"showState",
            content:{
                state:state
            }
        }
        return message;
    }


    
function fsubmit(){
    var data = new FormData($('#formData')[0]);
    $.ajax({
        url: '/supermanager/closure',
        type: 'POST',
        data: data,
        dataType: 'JSON',
        cache: false,
        processData: false,
        contentType: false
    }).done(function(ret){
        $.ajax({
            type: "POST",
            url: "/anchor/change",
            dataType:"json",
            data: "roomId=${room.id}&state="+0,
            success: function(data){
                alert(data.message);
            }
        });
        
    });
    return false;
}
</script>
</body>
</html>
