<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" reason="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" reason="ie=edge">
    <title>个人资料 - 修改密码</title>
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
                                    <a href="/person/" class="clicked">
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
                                    <i class="fa fa-vcard"></i> &nbsp;
                                    <a href="/person/">个人资料</a>
                                </li>
                                <li class="active">修改密码</li>
                            </ol>
                            <div class="user-info">
                                <form class="form-horizontal">
                                    <div class="form-group">
                                        <label for="oldPass" class="col-sm-2 control-label">旧密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="oldPass" name="oldPass" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="newPass" class="col-sm-2 control-label">新密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="newPass" name="newPass" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="confirmPass" class="col-sm-2 control-label">确认密码：</label>
                                        <div class="col-sm-10">
                                            <input type="password" class="form-control" id="confirmPass" name="confirmPass" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="button" id="changePassBtn" class="btn btn-default">提交修改</button>
                                        </div>
                                    </div>
                                </form>
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
<script>
    $("#changePassBtn").click(function()
    {
        var $oldPassInput = $("#oldPass");
        var $newPassInput = $("#newPass");
        var $confirmPassInput = $("#confirmPass");

        function isEmpty(input)
        {
            if(input.val() != "" && input.val().length != 0)
            {
                return true;
            }
            else
            {
                input.focus();
                return false;
            }
        }

        if(isEmpty($oldPassInput) && isEmpty($newPassInput) && isEmpty($confirmPassInput))
        {
            $.ajax({
                url: "changePass",
                type: "post",
                contentType: "application/json",
                data: JSON.stringify({
                    "oldPass": $("#oldPass").val(),
                    "newPass": $("#newPass").val(),
                    "confirmPass": $("#confirmPass").val()
                }),
                dataType: "json",
                success: function(show)
                {
                    layerMsg(show, locationToIndex);
                }
            });
        }
    })
</script>
</html>
