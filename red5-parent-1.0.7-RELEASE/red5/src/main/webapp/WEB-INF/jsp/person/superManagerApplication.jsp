<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" reason="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" reason="ie=edge">
    <title>template</title>
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
                            <c:if test="${sessionScope.user.type == 2}">
                                <li>
                                    <a href="#">
                                        <i class="fa fa-tv fa-fw"></i> &nbsp;超管相关
                                        <i class="live-caret"></i>
                                    </a>
                                </li>
                                <li>
                                    <a href="/person/managerApplication" class="li-children clicked">
                                        <i class="fa fa-fw"></i> &nbsp;申请管理
                                    </a>
                                </li>
                                <li>
                                    <a href="/person/managerRoomMute" class="li-children">
                                        <i class="fa fa-fw"></i> &nbsp;主播封禁
                                    </a>
                                </li>
                            </c:if>
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
                            <li class="active">申请管理</li>
                        </ol>
                        <table class="table table-bordered">
                            <thead>
                            <tr class="active">
                                <td>用户昵称</td>
                                <td style="width: 100px;">真实姓名</td>
                                <td style="width: 180px;">身份证号码</td>
                                <td style="width: 150px;">申请时间</td>
                                <td>身份证图片</td>
                                <td>操作</td>
                            </tr>
                            </thead>
                            <tbody>
                            <c:choose>
                                <c:when test="${empty applications}">
                                    <tr>
                                        <td colspan="6" style="text-align: center;">
                                            暂无申请记录
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${applications}" var="application">
                                        <tr>
                                            <td style="vertical-align: middle;">${application.nickName}</td>
                                            <td style="vertical-align: middle;">${application.realName}</td>
                                            <td style="vertical-align: middle;">${application.idcardId}</td>
                                            <td style="vertical-align: middle;">
                                                    ${application.applyTime}
                                            </td>
                                            <td>
                                                <button class="btn btn-info btn-xs" name="watch" headheldPassport="${application.headheldPassport}"
                                                        passportFront="${application.passportFront}" passportBack="${application.passportBack}">查看</button>
                                            </td>
                                            <td>
                                                <button class="btn btn-default btn-xs" name="check" passState="true" id="${application.id}">通过</button>
                                                <button class="btn btn-warning btn-xs" name="check" passState="false" id="${application.id}">不通过</button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            </tbody>
                        </table>
                        <%--<div class="tab-reason">--%>
                            <%--<div class="tab-pane fade in active">--%>
                                <%--<div class="user-header">--%>
                                <%--</div>--%>
                                <%--<div class="table-responsive">--%>
                                    <%----%>
                                <%--</div>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<template id="showPic">
    <div class="col-lg-4">
        <div class="thumbnail" style="border: none;">
            <img src="" id="headheldPassport"/>
            <div class="caption">
                手持证件照
            </div>
        </div>
    </div>
    <div class="col-lg-4">
        <div class="thumbnail" style="border: none;">
            <img src="" id="passportFront"/>
            <div class="caption">
                证件照正面
            </div>
        </div>
    </div>
    <div class="col-lg-4">
        <div class="thumbnail" style="border: none;">
            <img src="" id="passportBack"/>
            <div class="caption">
                证件照背面
            </div>
        </div>
    </div>
</template>
<%@ include file="../common/resources-foot.jsp" %>
<script type="text/javascript" src="/static/js/user/common.js"></script>
<script type="text/javascript">
    $("button[name='watch']").click(function() {
        layer.open({
            title: "查看身份证图片",
            content: $("#showPic").html(),
            btn: [],
            area: "1200px"
        });

        $("#headheldPassport").attr("src", $(this).attr("headheldPassport"));
        $("#passportFront").attr("src", $(this).attr("passportFront"));
        $("#passportBack").attr("src", $(this).attr("passportBack"));
    });

    $("button[name='check']").click(function() {
        $.ajax({
            url: "checkApplication",
            type: "post",
            data: "id=" + $(this).attr("id") + "&passState=" + $(this).attr("passState"),
            dataType: "json",
            success: function(show) {
                layerMsg(show, flush);
            }
        })
    });
</script>
</html>
