<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" reason="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" reason="ie=edge">
    <title>template</title>
    <%@ include file="../common/resources.jsp" %>
    <link rel="stylesheet" href="/static/css/user/user.css"/>
</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top live-shadow" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <!-- <a class="navbar-brand" href="#">菜鸟教程</a> -->
                    <div style="line-height: 50px;">
                        <img src="../../static/img/tmp.png" alt="">
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
                            <img src="../../static/img/logo.jpg" alt="">
                            <div class="live-nav">
                                <div class="live-shadow live-border live-border-radius">
                                    <div class="anim">
                                        <div class="user-main">
                                            <div class="user-out">
                                                <a href="#">退出</a>
                                            </div>
                                            <div class="user-pic">
                                                <img src="../../static/img/logo.jpg" alt="">
                                            </div>
                                            <div class="user-btns">
                                                <button class="btn btn-large btn-primary btn-block" type="button">个人中心
                                                </button>
                                                <button class="btn btn-large btn-primary btn-block" type="button">我的关注
                                                </button>
                                                <button class="btn btn-large btn-primary btn-block" type="button">直播设置
                                                </button>
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
<div class="container live-container">
    <div class="row">
        <div class="col-lg-offset-1 col-lg-10 col-md-offset-1 col-md-10">
            <div class="row">
                <div class="col-lg-12 col-md-12">
                    <div class="page-header">
                        <div>个人中心</div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-2 col-md-2">
                    <div class="user-side">
                        <ul class="user-side-ul">
                            <li>
                                <a href="/person/">
                                    <i class="fa fa-vcard fa-fw"></i> &nbsp;个人资料
                                </a>
                            </li>
                            <li>
                                <a href="/person/following">
                                    <i class="fa fa-user-o fa-fw"></i> &nbsp;我的关注
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-tv fa-fw"></i> &nbsp;直播相关
                                    <i class="live-caret"></i>
                                </a>
                            </li>
                            <li>
                                <a href="/person/application" class="li-children">
                                    <i class="fa fa-fw"></i> &nbsp;直播申请
                                </a>
                            </li>
                            <li>
                                <a href="/person/liveSetting" class="li-children">
                                    <i class="fa fa-fw"></i> &nbsp;直播设置
                                </a>
                            </li>
                            <li>
                                <a href="/person/liveRecord" class="li-children clicked">
                                    <i class="fa fa-fw"></i> &nbsp;直播记录
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-10 col-md-10">
                    <div class="user-body">
                        <ol class="breadcrumb">
                            <i class="fa fa-tv fa-fw"></i> &nbsp;
                            <li class="active">直播记录</li>
                        </ol>
                        <form class="form-inline" style="margin-bottom: 20px;">
                            <div class="form-group">
                                <div class="input-group date" id="startTimeDiv">
                                    <input type="text" class="form-control" id="startTime" readonly>
                                    <span class="input-group-addon">
                                            <span class="add-on">
                                                <i class="glyphicon glyphicon-remove"></i>
                                            </span>
                                        </span>
                                    <span class="input-group-addon">
                                            <span class="add-on">
                                                <i class="glyphicon glyphicon-calendar"></i>
                                            </span>
                                        </span>
                                </div>
                            </div>
                            至
                            <div class="form-group">
                                <div class="input-group date" id="endTimeDiv">
                                    <input type="text" class="form-control" id="endTime" readonly>
                                    <span class="input-group-addon">
                                            <span class="add-on">
                                                <i class="glyphicon glyphicon-remove"></i>
                                            </span>
                                        </span>
                                    <span class="input-group-addon">
                                            <span class="add-on">
                                                <i class="glyphicon glyphicon-calendar"></i>
                                            </span>
                                        </span>
                                </div>
                            </div>
                            <button type="button" class="btn btn-default" id="iquire">查询</button>
                        </form>
                        <div class="table-responsive">
                            <table class="table table-bordered" style="text-align: center;">
                                <thead>
                                <tr class="active">
                                    <td>直播时间</td>
                                    <td>直播时长</td>
                                </tr>
                                </thead>
                                <tbody id="liveRecord">
                                <c:choose>
                                    <c:when test="${empty personalLiveRecordDTOList}">
                                        <tr>
                                            <td colspan="2" style="text-align: center;">
                                                暂无直播记录，快去<a href="#" style="color: red;">直播</a>吧！
                                            </td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach items="${personalLiveRecordDTOList}" var="liveRecord">
                                            <tr>
                                                <td>${liveRecord.startTime}&nbsp;&nbsp;---&nbsp;&nbsp;${liveRecord.endTime}</td>
                                                <td style="width: 164px;">${liveRecord.endTime}分钟</td>
                                            </tr>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@ include file="../common/resources-foot.jsp" %>
<script>
    $("#startTimeDiv").datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        todayHighlight: true,
        minView: 2,
        autoclose: true,
        endDate: new Date(),
    });
    $("#endTimeDiv").datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh-CN',
        todayHighlight: true,
        minView: 2,
        autoclose: true,
        endDate: new Date(),
    });
    //查询某时间段内的直播记录
    $("#iquire").click(function()
    {
        var $startTime = $("#startTime");
        var $endTime = $("#endTime");
//        console.log($startTime.val() + ", " + $endTime.val());
        $.ajax({
            url: "liveRecordByTime",
            type: "post",
            data: "startTime=" + $startTime.val() + "&endTime=" + $endTime.val(),
            dataType: "json",
            success: function(show)
            {
                if(show.state == 1)
                {
                    var list = show.data;
//                    console.log(list.length);
                    var $liveRecordTbody = $("#liveRecord");
                    if(list.length == 0)
                    {
                        $liveRecordTbody.html(
                            `<tr>
                                <td colspan="2" style="text-align: center;">
                                    无直播记录
                                </td>
                            </tr>`
                        );
                    }
                    else
                    {
                        $liveRecordTbody.html("");
                        for(var i = 0; i < list.length; i++)
                        {
                            var tmp = list[i];
                            console.log(tmp.startTime);
                            $liveRecordTbody.append(
                                "<tr>" +
                                "<td>" + tmp.startTime + "&nbsp;&nbsp;---&nbsp;&nbsp;" + tmp.endTime + "</td>" +
                                "<td style=\"width: 164px;\">" + tmp.endTime + "分钟</td>" +
                                "</tr>"
                            );
                        }
                    }

                    layer.msg(show.message, {
                        icon: 1,
                        time: 2000
                    });
                }
                else
                {
                    layer.msg(show.message, {
                        icon: 2,
                        time: 2000
                    }, function()
                    {
//                        location = location;
                    });
                }
            },
            error: function(re)
            {
                console.log(re);
//                layer.msg("未知错误", {
//                    icon: 2,
//                    time: 2000
//                }, function(){
////                    location = location;
//                });
            }
        })
    })
</script>

</html>
