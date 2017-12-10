<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <%@ include file="../common/resources.jsp"%>
    <style>
        *
        {
            margin: 0;
            padding: 0;
        }

        #main
        {
            width: 90%;
            margin: 0 auto;
        }

        .index-main
        {
            padding-top: 20px;
        }

        #playBody
        {
            display: inline-block;
            margin-right: 5px;
        }

        #showNav
        {
            border-radius: 7px;
            display: inline-block;
            vertical-align: top;
            margin-top: 0px;
            height: 460px;
            background: rgba(121, 121, 121, 1);
        }

        .divs
        {
            transition: all 0.5s;
            position: relative;
            margin: 0 auto;
            height: 109px;
            margin-top: 5px;
            width: 94%;
        }

        #showNav div img
        {
            cursor: pointer;
            width: 100%;
            height: 100%;
        }

        #showNav div div
        {
            display: inline-block;
            position: absolute;
            top: 50%;
            left: -15px;
            /*transform: translate(0, -50%);*/
            transform: translateY(-50%);
        }

        #showNav div div span
        {
            display: none;
            color: red;
            font-size: 20px;
            z-index: 1000;
        }

        #footRec
        {
            width: 90%;
            height: 400px;
            background-color: #F2F2F2;
            margin: 0 auto;
            margin-top: 10px;
        }

        .footDivBig
        {
            overflow: hidden;
            display: inline-block;
            vertical-align: top;
            width: 32%;
            /*height: 380px;*/
            margin-bottom: 5px;
            padding-left: 2%;
            padding-right: 2%;
            padding-bottom: 20px;
            background-color: #ffffff;
        }

        .footDivBig:nth-child(2)
        {
            margin-left: 10px;
            margin-right: 10px;
        }

        a, a:hover, a:active, a:visited
        {
            text-decoration: none;
        }

        .footDivBig h3 a,
        .footDivBig h3 a:hover,
        .footDivBig h3 a:active,
        .footDivBig h3 a:visited
        {
            text-decoration: none;
        }

        .showVideo
        {
            overflow: hidden;
            position: relative;
            border-radius: 10px;
            width: 48%;
            height: 130px;
            display: inline-block;
            vertical-align: top;
            background-color: red;
            margin-top: 15px;
        }

        .showVideo:nth-child(2n-1)
        {
            margin-right: 1%;
        }

        .imgStyle
        {
            width: 100%;
            height: 100%;
            z-index: -1;
        }

        .textDiv
        {
            position: absolute;
            bottom: 0px;
            width: 100%;
            height: 30px;
            line-height: 30px;
            text-align: center;
            background: rgba(0, 0, 0, 0.5);
            color: white;
        }

        .playIcon
        {
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            width: 100%;
            height: 40px;
            display: none;
        }
    </style>
    <script type="text/javascript" src="/play/js/swfobject.js"></script>
</head>
<body style="background-color: #F2F2F2">
<jsp:include page="../common/topNav.jsp"></jsp:include>
    <div class="container-fluid live-container">
        <div class="row">
            <div class="col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10">
                <div class="index-main">
                    <div id="main">
                        <div id="playBody">
                            <div class="video" id="CuPlayer">
                                <b> <img src="/play/images/loading.gif"/> 网页视频播放器加载中，请稍后...</b>
                            </div>
                        </div>
                        <div id="showNav">
                            <div class="divs" name="${recoRoom[1].streamCode}"><img src="${recoRoom[1].photo}" alt="">
                                <div><span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span></div>
                            </div>
                            <div class="divs" name="${recoRoom[2].streamCode}"><img src="${recoRoom[2].photo}" alt="">
                                <div>
                                    <span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span>
                                </div>
                            </div>
                            <div class="divs" name="${recoRoom[3].streamCode}"><img src="${recoRoom[3].photo}" alt="">
                                <div><span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span></div>
                            </div>
                            <div class="divs" name="${recoRoom[4].streamCode}"><img src="${recoRoom[4].photo}" alt="">
                                <div><span class="glyphicon glyphicon-triangle-left" aria-hidden="true"></span></div>
                            </div>
                        </div>
                    </div>
                    <div id="footRec">
                        <div class="footDivBig">
                            <h3>
                                <a href="" name="tagA" style="color: black">
                                    <i><img src="/static/img/indexClassIcon.png" alt=""></i>
                                    <span>${modules[0].name}</span>
                                </a>
                            </h3>
                            <hr style="color: #F3F4F8">
                            <div style="width: 100%; margin-top: -15px">
                                <c:forEach var="room" items="${reco1}">
                                    <div class="showVideo"><img class="imgStyle" src="${room.photo}" alt="">
                                        <div class="playIcon">
                                            <div style="width: 40px;margin: 0 auto;">
                                                <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                                            </div>
                                        </div>
                                        <div class="textDiv">${room.name}</div>
                                    </div>
                                </c:forEach>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                            </div>
                        </div>
                        <div class="footDivBig">
                            <h3>
                                <a href="" name="tagA" style="color: black">
                                    <i><img src="/static/img/indexClassIcon.png" alt=""></i>
                                    <span>${modules[1].name}</span>
                                </a>
                            </h3>
                            <hr style="color: #F3F4F8">
                            <div style="width: 100%; margin-top: -15px">
                                <c:forEach var="room" items="${reco2}">
                                    <div class="showVideo"><img class="imgStyle" src="${room.photo}" alt="">
                                        <div class="playIcon">
                                            <div style="width: 40px;margin: 0 auto;">
                                                <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                                            </div>
                                        </div>
                                        <div class="textDiv">${room.name}</div>
                                    </div>
                                </c:forEach>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                            </div>
                        </div>
                        <div class="footDivBig">
                            <h3>
                                <a href="" name="tagA" style="color: black">
                                    <i><img src="/static/img/indexClassIcon.png" alt=""></i>
                                    <span>${modules[2].name}</span>
                                </a>
                            </h3>
                            <hr style="color: #F3F4F8">
                            <div style="width: 100%; margin-top: -15px">
                                <c:forEach var="room" items="${reco3}">
                                    <div class="showVideo"><img class="imgStyle" src="${room.photo}" alt="">
                                        <div class="playIcon">
                                            <div style="width: 40px;margin: 0 auto;">
                                                <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                                            </div>
                                        </div>
                                        <div class="textDiv">${room.name}</div>
                                    </div>
                                </c:forEach>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                                <%--<div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">--%>
                                    <%--<div class="playIcon">--%>
                                        <%--<div style="width: 40px;margin: 0 auto;">--%>
                                            <%--<img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">--%>
                                        <%--</div>--%>
                                    <%--</div>--%>
                                    <%--<div class="textDiv">xxx</div>--%>
                                <%--</div>--%>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script type="text/javascript" src="/static/js/config/rtmpConfig.js"></script>
<script>
    var fatherWidth = $("#main").width();
    var playBody = fatherWidth * 0.8;
    var _width = playBody + ""; //播放器属性
    var _height = playBody / 1.65;
    var _stream = "${recoRoom[0].streamCode}";
    $("#showNav").css("height", _height + "px");
    $("#showNav").children("div").css("height", (_height - 25) / 4 + "px");
    /**
     * 设置基本框架
     *
     */
    $("#playBody").css("width", playBody);
    $("#CuPlayer").css("width", playBody);
    /**
     *自适应右边宽度的宽度
     */
    var fWidth = $("#main").width();
    var lWidth = $("#playBody").width();
    $("#showNav").css("width", fWidth - lWidth - 10 + 'px');
    function createFlash(width, height, stream, rtmpIp)
    {
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
    window.onresize = function()
    {
        var fatherWidth = $("#main").width();
        var playBody = fatherWidth * 0.8;
        var _width = playBody + ""; //播放器属性
        var _height = playBody / 1.65;
        var _stream = "cat";
        $("#showNav").css("height", _height + "px");
        $("#showNav").children("div").css("height", (_height - 25) / 4 + "px");
        /**
         * 设置基本框架
         *
         */
        $("#playBody").css("width", playBody);
        $("#CuPlayer").css("width", playBody);
        /**
         *自适应右边宽度的宽度
         */
        var fWidth = $("#main").width();
        var lWidth = $("#playBody").width();
        $("#showNav").css("width", fWidth - lWidth - 10 + 'px');
        createFlash(_width, _height, _stream, _rtmpIp);

        /**
         * 调整下面三部分的长宽
         * 及
         * 视频的长宽
         **/
        var footRecWidth = $("#footRec").width();
        $(".footDivBig").css("width", (footRecWidth - 30) / 3 + "px");
        var showVideoWidth = $(".showVideo").width();
        $(".showVideo").css("height", showVideoWidth / 1.65 + "px");
    }
    /**
     *右侧视频里表边框
     * @type {number}
     */
    var num = 0;
    $(".divs").mouseover(function()
    {
        $(this).css("border", "solid 2px #FF7701");
        $(this).children("div").children("span").css("display", "block");
    });
    $(".divs").mouseleave(function()
    {
        if($(this).attr('name') != num)
        {
            $(this).children("div").children("span").css("display", "none");
            $(this).css("border", "none");
        }
    })
    $(".divs").click(function()
    {
        num = $(this).attr('name');
        clearBorder();
        $(this).css("border", "solid 2px #FF7701");
        $(this).children("div").children("span").css("display", "block");

        createFlash(_width, _height, $(this).attr("name"), _rtmpIp);
    })
    function clearBorder()
    {
        $("#showNav").children("div").css("border", "none");
        $("#showNav").children("div").children("div").children("span").css("display", "none");
    }
</script>
<script>
    //    控制play图标
    $(".showVideo").hover(function()
    {
        $(this).children(".playIcon").fadeIn(500);
    })
    $(".showVideo").mouseleave(function()
    {
        $(this).children(".playIcon").fadeOut(500);
    })

    var footRecWidth = $("#footRec").width();
    $(".footDivBig").css("width", (footRecWidth - 30) / 3 + "px");
    var showVideoWidth = $(".showVideo").width();
    $(".showVideo").css("height", showVideoWidth / 1.65 + "px");
</script>
</body>
</html>
