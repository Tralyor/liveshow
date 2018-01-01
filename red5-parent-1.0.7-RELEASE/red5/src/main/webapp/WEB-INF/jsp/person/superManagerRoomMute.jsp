<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" reason="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" reason="ie=edge">
    <title>超管相关 - 主播封禁</title>
    <%@ include file="../common/resources.jsp"%>
    <link rel="stylesheet" href="/static/css/user/user.css" />
</head>

<body>
<jsp:include page="../common/topNav.jsp"></jsp:include>
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
                            <c:choose>
                                <c:when test="${sessionScope.user.type == 2}">
                                    <li>
                                        <a href="#">
                                            <i class="fa fa-tv fa-fw"></i> &nbsp;超管相关
                                            <i class="live-caret"></i>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/person/managerApplication" class="li-children">
                                            <i class="fa fa-fw"></i> &nbsp;申请管理
                                        </a>
                                    </li>
                                    <li>
                                        <a href="/person/managerRoomMute" class="li-children">
                                            <i class="fa fa-fw"></i> &nbsp;主播封禁
                                        </a>
                                    </li>
                                </c:when>
                                <c:otherwise>
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
                                        <a href="/person/liveRecord" class="li-children">
                                            <i class="fa fa-fw"></i> &nbsp;直播记录
                                        </a>
                                    </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-10 col-md-10">
                    <div class="user-body">
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-tv fa-fw"></i> &nbsp;
                                <a href="#">超管相关</a>
                            </li>
                            <li class="active">主播封禁</li>
                        </ol>
                        <table class="table table-bordered">
                            <thead>
                            <tr class="active">
                                <td>封禁主播</td>
                                <td style="width: 230px;">封禁理由</td>
                                <td style="width: 150px;">封禁时间</td>
                                <td style="width: 100px;">封禁时长</td>
                                <td>图片证据</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${empty darkroomRoom}">
                                    <tr>
                                        <td colspan="7" style="text-align: center;">
                                            暂无封禁记录
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${darkroomRoom}" var="room">
                                        <tr>
                                            <td style="vertical-align: middle;">${room.nickName}</td>
                                            <td style="vertical-align: middle;">${room.reason}</td>
                                            <td style="vertical-align: middle;">${room.time}</td>
                                            <td style="vertical-align: middle;">${room.hours}</td>
                                            <td>
                                                <button class="btn btn-info btn-xs" name="photo" data-photo="${room.photo}">查看</button>
                                            </td>
                                            <td>
                                                <button class="btn btn-defaule btn-xs" name="undo" darkRoomId="${room.id}">解封</button>
                                            </td>
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
</body>
<template id="showPic">
    <div class="col-lg-10 col-lg-offset-1" style="text-align: center;">
        <img src="" id="photo"/>
    </div>
</template>
<%@ include file="../common/resources-foot.jsp" %>
<script type="text/javascript" src="/static/js/user/common.js"></script>
<script type="text/javascript">
    $("button[name='photo']").click(function() {
        layer.open({
            title: "查看图片证据",
            content: $("#showPic").html(),
            btn: [],
            area: "500px",
            offset: "200px"
        });

        $("#photo").attr("src", $(this).attr("data-photo"));
    });

    $(document).on("click", "button[name='undo']", function () {
        var darkroomId = $(this).attr("darkRoomId");

        $.ajax({
            url: "/person/undoDarkRoom",
            type: "post",
            data: "id=" + darkroomId,
            dataType: "json",
            success: function (show) {
                layerMsg(show, flush);
            }
        })
    });
</script>
</html>

