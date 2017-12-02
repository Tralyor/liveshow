<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <%@ include file="../common/resources.jsp"%>
    <style>

        body
        {
            background-color: #F5F5F5;
        }
        #mainBody {
            /*margin: 0 auto;*/
        }
        .headUl{
            list-style: none;
            display: inline-block;
            vertical-align: middle;
            height: 39px;
        }
        .liStyle{
            display: inline-block;
            width: 60px;
            text-align: center;
            margin-left:20px;
            border-radius: 5px;
            border:solid 1px #D7D7D7;
            float: left;
        }

        .liStyle a,
        .liStyle a:hover ,
        .liStyle a:active,
        .liStyle a:visited{
            text-decoration: none;
            color: black;
        }


        .liStyle:hover{
            cursor: pointer;
            border: solid 1px #ff6600;
        }
        .liStyle:hover > a{
            color: #ff6600;
        }
        
        .footDivBig h3 a,
        .footDivBig h3 a:hover ,
        .footDivBig h3 a:active,
        .footDivBig h3 a:visited{
            text-decoration: none;
        }

        .showVideo{
            overflow: hidden;
            position: relative;
            width: 220px;
            height: 170px;
            display: inline-block;
            vertical-align: top;
            margin-left: 20px;
            margin-top: 15px;
        }
        .showVideo:hover{
            border-bottom: solid 2px #D2D2D2;
        }

        .imgStyle{
            width: 100%;
            height: 70%%;
            z-index: -1;
        }
        .textDiv{
            width: 100%;
            height: 50px;
            background: white;
            color: black;
        }
        
        .textDiv ul {
            list-style: none;
            padding-top: 5px;
            /*margin-left: -25px;*/
        }

        .textDiv ul li
        {
            padding-left: 10px;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

        .playIcon{
            position: absolute;
            bottom: -90px;
            width:100%;
            height: 40px;
            display: none;
        }
    </style>
</head>

<body>
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
<div class="live-side">
    <div class="live-side-scroll">
        <div class="live-viewport">
            <!-- 按钮区域 -->
            <div class="live-side-btns">
                <button class="btn btn-large btn-primary btn-block" type="button">全部直播</button>
                <button class="btn btn-large btn-primary btn-block" type="button">全部分类</button>
            </div>

            <!-- 游戏推荐区域 -->
            <div class="live-side-recommend">
                <div class="live-side-title">
                    <ul>
                        <li>栏目</li>
                    </ul>
                </div>
                <div class="list-wrap">
                    <div>
                        <i></i>
                        <span>热门游戏</span>
                    </div>
                    <ul class="live-btns">
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                    </ul>
                </div>
                <div class="list-wrap">
                    <div>
                        <i></i>
                        <span>热门游戏</span>
                    </div>
                    <ul class="live-btns">
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                    </ul>
                </div>
                <div class="list-wrap">
                    <div>
                        <i></i>
                        <span>热门游戏</span>
                    </div>
                    <ul class="live-btns">
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                    </ul>
                </div>
                <div class="list-wrap">
                    <div>
                        <i></i>
                        <span>热门游戏</span>
                    </div>
                    <ul class="live-btns">
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                        <li>
                            <a href="#">某某板块</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="live-body">
    <div style="padding: 15px;">
        <div id="mainBody">
            <div  style="width:1000px;border-bottom: solid 1px #dddddd;margin-bottom: 15px;padding-left: 12px;">
                <h1 style="display: inline-block">全部分类</h1>
                <ul class="headUl">
                    <li class="liStyle" ><a href="#">全部</a></li>
                    <li class="liStyle" ><a href="#">全部</a></li>
                    <li class="liStyle" ><a href="#">全部</a></li>
                    <li class="liStyle" ><a href="#">全部</a></li>
                    <li class="liStyle" ><a href="#">全部</a></li>
                    <li class="liStyle" ><a href="#">全部</a></li>
                    <li class="liStyle" ><a href="#">全部</a></li>
                    <li class="liStyle" ><a href="#">全部</a></li>
                </ul>
            </div>

            <div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
                <div class="showVideo"><img class="imgStyle" src="/static/img/test2.png" alt="">
                    <div class="playIcon">
                        <div style="width: 40px;margin: 0 auto;">
                            <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                        </div>
                    </div>
                    <div class="textDiv">
                        <ul>
                            <li>欢迎收听你的月亮我的心</li>
                            <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span> 主播xxx&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-fire" aria-hidden="true"></span>1.4w</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<%--<div style="width: 1000px;height: 500px;background-color: gainsboro">--%>
    <%--<c:forEach var="room" items="${room}" varStatus="idx">--%>
        <%--<tr>--%>
            <%--<td><c:out value="${room.id}"></c:out></td>--%>
            <%--<td><c:out value="${roomPopularity.roomIdAndPopularity[idx.index].populartyNow}"></c:out></td>1--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</div>--%>
<script>
    function clearTagCss() {
        var tag = $(".liStyle");

        for (var i = 0;i < tag.length;i++){
            tag.eq(i).css("background-color","");
            tag.eq(i).children("a").css("color","black");
        }
    }



    $(".liStyle").click(function () {
        clearTagCss();
        $(this).css("background-color","#ff6600");
        $(this).children("a").css("color","white");
    })


</script>
<script>
    //    控制play图标
    $(".showVideo").hover(function () {
        $(this).children(".textDiv").children("ul").children("li").eq(0).css("color","#FF7700");
        $(this).children(".playIcon").css("bottom","90px");
        $(this).children(".playIcon").fadeIn(500);
    })

    $(".showVideo").mouseleave(function () {
        $(this).children(".textDiv").children("ul").children("li").eq(0).css("color","black");
        $(this).children(".playIcon").css("bottom","-90px");
        $(this).children(".playIcon").fadeOut(500);
    })
</script>

</body>
</html>
