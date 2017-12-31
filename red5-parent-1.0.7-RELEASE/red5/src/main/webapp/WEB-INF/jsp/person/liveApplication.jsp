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
                                    <a href="/person/application" class="li-children clicked">
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
                                        <a href="/person/managerApplication" class="li-children">
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
                                <i class="fa fa-tv fa-fw"></i> &nbsp;
                                <li class="active">直播申请</li>
                            </ol>
                            <c:choose>
                                <c:when test="${empty personalApplicationDTO}">
                                    <form id="application" action="#" method="post" class="form-horizontal" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label for="realName" class="col-sm-2 control-label">真实姓名：</label>
                                            <div class="col-sm-10">
                                                <input id="realName" name="realName" type="text" required class="form-control" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">证件类型：</label>
                                            <div class="col-sm-10">
                                                <select class="form-control" name="passportType">
                                                    <option>身份证</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="idcardId" class="col-sm-2 control-label">证件号码：</label>
                                            <div class="col-sm-10">
                                                <input id="idcardId" name="idcardId" required type="text" class="form-control" />
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-lg-4">
                                                <div class="thumbnail" style="border: none;">
                                                    <img src="/static/img/img1.png" id="headheldPassport">
                                                    <div class="caption">
                                                        <span style="line-height: 34px;">手持证件照（2M内）</span>
                                                        <label class="btn btn-default pt-r" for="headheldPassportInput">点击上传</label>
                                                        <input type="file" required name="headheldPassport" id="headheldPassportInput" accept="image/png, image/jpeg, image/gif, image/jpg" style="display:none;">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="thumbnail" style="border: none;">
                                                    <img src="/static/img/img3.png" id="passportFront">
                                                    <div class="caption">
                                                        <span style="line-height: 34px;">证件正面照（2M内）</span>
                                                        <label class="btn btn-default pt-r" for="passportFrontInput">点击上传</label>
                                                        <input type="file" required name="passportFront" id="passportFrontInput" accept="image/png, image/jpeg, image/gif, image/jpg" style="display:none;">
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-4">
                                                <div class="thumbnail" style="border: none;">
                                                    <img src="/static/img/img2.png" id="passportBack">
                                                    <div class="caption">
                                                        <span style="line-height: 34px;">证件背面照（2M内）</span>
                                                        <label class="btn btn-default pt-r" for="passportBackInput">点击上传</label>
                                                        <input type="file" required name="passportBack" id="passportBackInput" accept="image/png, image/jpeg, image/jpg" style="display:none;">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group" style="text-align: center;">
                                            <button type="button" id="ajaxSubmit" class="btn btn-default">提交</button>
                                        </div>
                                    </form>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${empty personalApplicationDTO.passState}">
                                            <div style="text-align: center;color: orange;">
                                                <i class="fa fa-exclamation-circle fa-3x" style="vertical-align: middle;"></i>
                                                <span style="line-height: 3em;display: inline-block;position:relative;">正在审核</span>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${personalApplicationDTO.passState}">
                                                    <div style="text-align: center;color: green;">
                                                        <i class="fa fa-check-circle-o fa-3x" style="vertical-align: middle;"></i>
                                                        <span style="line-height: 3em;display: inline-block;position:relative;">已认证</span>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="panel panel-default">
                                                        <div class="panel-body bg-danger">
                                                            认证失败
                                                        </div>
                                                    </div>
                                                    <form id="application" action="#" method="post" class="form-horizontal" enctype="multipart/form-data">
                                                        <div class="form-group">
                                                            <label for="realName" class="col-sm-2 control-label">真实姓名：</label>
                                                            <div class="col-sm-10">
                                                                <input id="realName" name="realName" type="text" required class="form-control" />
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-2 control-label">证件类型：</label>
                                                            <div class="col-sm-10">
                                                                <select class="form-control" name="passportType">
                                                                    <option>身份证</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label for="idcardId" class="col-sm-2 control-label">证件号码：</label>
                                                            <div class="col-sm-10">
                                                                <input id="idcardId" name="idcardId" required type="text" class="form-control" />
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <div class="col-lg-4">
                                                                <div class="thumbnail" style="border: none;">
                                                                    <img src="/static/img/img1.png" id="headheldPassport">
                                                                    <div class="caption">
                                                                        <span style="line-height: 34px;">手持证件照（2M内）</span>
                                                                        <label class="btn btn-default pt-r" for="headheldPassportInput">点击上传</label>
                                                                        <input type="file" required name="headheldPassport" id="headheldPassportInput" accept="image/png, image/jpeg, image/gif, image/jpg" style="display:none;">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-4">
                                                                <div class="thumbnail" style="border: none;">
                                                                    <img src="/static/img/img3.png" id="passportFront">
                                                                    <div class="caption">
                                                                        <span style="line-height: 34px;">证件正面照（2M内）</span>
                                                                        <label class="btn btn-default pt-r" for="passportFrontInput">点击上传</label>
                                                                        <input type="file" required name="passportFront" id="passportFrontInput" accept="image/png, image/jpeg, image/gif, image/jpg" style="display:none;">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-4">
                                                                <div class="thumbnail" style="border: none;">
                                                                    <img src="/static/img/img2.png" id="passportBack">
                                                                    <div class="caption">
                                                                        <span style="line-height: 34px;">证件背面照（2M内）</span>
                                                                        <label class="btn btn-default pt-r" for="passportBackInput">点击上传</label>
                                                                        <input type="file" required name="passportBack" id="passportBackInput" accept="image/png, image/jpeg, image/jpg" style="display:none;">
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group" style="text-align: center;">
                                                            <button type="button" id="ajaxSubmit" class="btn btn-default">提交</button>
                                                        </div>
                                                    </form>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
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
    $("#headheldPassportInput").change(function()
    {
        preview(this, "headheldPassport");
    });

    $("#passportFrontInput").change(function()
    {
        preview(this, "passportFront");
    });

    $("#passportBackInput").change(function()
    {
        preview(this, "passportBack");
    });

    $("#ajaxSubmit").one("click", function() {
        layer.msg('上传中，请稍等', {
            icon: 16
            ,shade: 0.01
        });

        var options = {
            url: "submitApplication",
            type: "post",
            dataType: "json",
            success: function(show) {
                layer.closeAll('loading');
                layerMsg(show, flush);
            }
        };


        $("#application").ajaxSubmit(options);
    })
</script>
</html>
