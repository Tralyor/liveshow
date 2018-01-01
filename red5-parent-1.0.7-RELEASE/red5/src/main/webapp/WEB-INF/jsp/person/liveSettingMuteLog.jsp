<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" reason="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" reason="ie=edge">
    <title>直播设置 - 禁言记录</title>
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
                                    <a href="#">直播设置</a>
                                </li>
                                <li class="active">禁言</li>
                            </ol>
                            <ul class="nav nav-tabs">
                                <li>
                                    <a href="mute">
                                        禁言名单
                                    </a>
                                </li>
                                <li class="active">
                                    <a href="#">
                                        禁言记录
                                    </a>
                                </li>
                            </ul>
                            <div class="tab-reason">
                                <div class="tab-pane fade in active">
                                    <div class="user-header">
                                    </div>
                                    <div class="table-responsive">
                                        <table class="table table-bordered">
                                            <thead>
                                                <tr class="active">
                                                    <td>封禁用户</td>
                                                    <td style="width: 250px;">弹幕内容</td>
                                                    <td style="width: 150px;">封禁时间</td>
                                                    <td style="width: 100px;">封禁时长</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:choose>
                                                <c:when test="${empty personalMuteDTOList}">
                                                    <tr>
                                                        <td colspan="5" style="text-align: center;">
                                                            暂无禁言记录
                                                        </td>
                                                    </tr>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${personalMuteDTOList}" var="mute">
                                                        <tr>
                                                            <td>${mute.muteName}</td>
                                                            <td>${mute.danmaContent}</td>
                                                            <td>${mute.time}</td>
                                                            <td>${mute.hours}</td>
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
        </div>
    </div>
</body>
<%@ include file="../common/resources-foot.jsp" %>
<script type="text/javascript" src="/static/js/user/common.js"></script>

</html>
