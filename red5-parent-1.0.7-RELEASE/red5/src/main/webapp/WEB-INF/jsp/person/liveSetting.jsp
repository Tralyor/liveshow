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
                                    <a href="/person/liveSetting" class="li-children clicked">
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
                                <li class="active">直播设置</li>
                            </ol>
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">房间ID：</label>
                                    <div class="col-sm-2">
                                        <p class="form-control-static">${personalLiveSettingDTO.roomId}</p>
                                    </div>
                                    <div class="col-sm-3">
                                        <a href="/liveShow/index/${personalLiveSettingDTO.roomId}" class="btn btn-default">进入直播间</a>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">房间标题：</label>
                                    <div class="col-sm-5">
                                        <input type="text" class="form-control" name="room" id="roomName" placeholder="房间标题" value="${personalLiveSettingDTO.roomName}">
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" id="changeName" class="btn btn-default" role="button" disabled>修改</button>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">房间公告：</label>
                                    <div class="col-sm-9">
                                        <textarea class="form-control" name="room" id="notice" rows="4">${personalLiveSettingDTO.notice}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-offset-2 col-sm-10">
                                        <button type="button" id="changeNotice" class="btn btn-default" disabled>修改</button>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">直播封面：</label>
                                    <div class="col-sm-6">
                                        <img src="${personalLiveSettingDTO.photo}" alt="">
                                    </div>
                                    <div class="col-sm-2">
                                        <button type="button" class="btn btn-default" role="button">修改</button>
                                    </div>
                                </div>

                                <!-- 开始直播才有 -->
                                <c:if test="${personalLiveSettingDTO.liveState}">
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">rtmp地址：</label>
                                        <div class="col-sm-5">
                                            <input type="text" id="rtmp" class="form-control" value="rtmp://send3.douyu.com/live">
                                        </div>
                                        <div class="col-sm-3">
                                            <button type="button" class="btn btn-default">复制</button>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-2 control-label">直播码：</label>
                                        <div class="col-sm-7">
                                            <input type="text" id="liveNum" class="form-control" value="${personalLiveSettingDTO.streamCode}">
                                        </div>
                                        <div class="col-sm-3">
                                            <button class="btn btn-default">复制</button>
                                        </div>
                                    </div>
                                </c:if>


                                <div class="form-group">
                                    <label class="col-sm-2 control-label">房间设置：</label>
                                    <div class="col-sm-10">
                                        <!-- <a href="#" class="btn btn-default">管理员</a> -->
                                        <a href="mute" target="_blank" class="btn btn-default">禁言名单</a>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 control-label">直播分类：</label>
                                    <div class="col-sm-4">
                                        <ol class="class-detail form-control-static">
                                            <li id="partLi">${personalLiveSettingDTO.partName}</li>
                                            <li id="moduleLi">${personalLiveSettingDTO.moduleName}</li>
                                        </ol>
                                    </div>
                                    <div class="col-sm-3">
                                        <button type="button" class="btn btn-default" role="button" id="changeType">修改</button>
                                    </div>
                                </div>
                                <c:choose>
                                    <c:when test="${personalLiveSettingDTO.liveState}">
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="button" class="btn btn-primary">关闭直播</button>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="button" class="btn btn-primary">开始直播</button>
                                            </div>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 弹出层 -->
    <template id="changeTypeContext">
        <form action="#" class="form-inline">
            <div class="form-group">
                <div class="col-lg-12">
                    <select class="form-control" name="part" id="part">
                        <c:forEach items="${personalLiveSettingPartDTOList}" var="part">
                            <c:choose>
                                <c:when test="${part.partId == personalLiveSettingDTO.partId}">
                                    <option value="${part.partId}" selected>${part.partName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${part.partId}">${part.partName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            -
            <div class="form-group">
                <div class="col-lg-12">
                    <select class="form-control" name="module" id="module">
                        <c:forEach items="${personalLiveSettingPartDTOList}" var="part">
                            <c:if test="${part.partId == personalLiveSettingDTO.partId}">
                                <c:forEach items="${part.moduleDTOList}" var="module">
                                    <c:choose>
                                        <c:when test="${module.moduleId == personalLiveSettingDTO.moduleId}">
                                            <option value="${module.moduleId}" selected>${module.moduleName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${module.moduleId}">${module.moduleName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
            </div>
        </form>
    </template>
</body>
<%@ include file="../common/resources-foot.jsp" %>
<script type="text/javascript" src="/static/js/user/common.js"></script>
<script>
    $("#changeType").click(function () {
        layer.open({
            title: '',
            content: $("#changeTypeContext").html(),
            area: ['400px'],
            btnAlign: 'c',
            yes: function (index, layero) {
                var newPartName = $("#part").find("option:selected").text();
                var newModuleId = $("#module").val();
                var newModuleName = $("#module").find("option:selected").text();
                room.moduleId = newModuleId;

                $("#moduleLi").text(newModuleName);
                $("#partLi").text(newPartName);
                ajaxRoom(nothingDoFun);

                delete room["moduleId"];
            }
        });

        var partList = ${personalLiveSettingPartDTOListJson};
        console.log(partList);
        $("select#part").change(function()
        {
            var partId = $(this).val();
            for(var i = 0; i < partList.length; i++)
            {
                var part = partList[i];
                if(partId == part.partId)
                {
                    var moduleList = part.moduleDTOList;
                    var $moduleSelect = $("select#module");
                    $moduleSelect.html("");
                    for(var i = 0; i < moduleList.length; i++)
                    {
                        var module = moduleList[i];
                        $moduleSelect.append(
                            "<option value='" + module.moduleId + "'>" + module.moduleName + "</option>"
                        );
                    }

                    break;
                }
            }
        })
    });

    var room = {
        roomId: ${personalLiveSettingDTO.roomId}
    };

    function ajaxRoom(fun)
    {
        $.ajax({
            url: "updateLiveSetting",
            type: "post",
            contentType: "application/json",
            data: JSON.stringify(room),
            dataType: "json",
            success: function(show)
            {
                layerMsg(show, fun);
            },
            error: function(re)
            {
                layer.msg("未知错误", {
                    icon: 2,
                    time: 2000
                });
            }
        });
    }
    /**
     * onpropertychange的话，
     * 只要当前对象属性发生改变，
     * 都会触发事件，
     * 但是它是IE专属的；
     * oninput是onpropertychange的非IE浏览器版本，
     * 支持firefox和opera等浏览器，
     * 但有一点不同，它绑定于对象时，
     * 并非该对象所有属性改变都能触发事件，
     * 它只在对象value值发生改变时奏效。
     */

    //房间名
    $("#roomName").bind('input propertychange', function()
    {
        var tmp = $("#changeName");
        var old = "${personalLiveSettingDTO.roomName}";
        if(old != $(this).val())
        {
            tmp.removeAttr("disabled");
        }
        else
        {
            tmp.attr("disabled", true);
        }
    });

    $("#changeName").click(function()
    {
        var newName = $("#roomName").val();
        room.roomName = newName;

        ajaxRoom(flush);

        delete room["roomName"];
        console.log(room);
    });

    //房间公告
    $("#notice").bind('input propertychange', function()
    {
        var tmp = $("#changeNotice");
        var old = ${personalLiveSettingDTO.notice};
        if(old != $(this).val())
        {
            tmp.removeAttr("disabled");
        }
        else
        {
            tmp.attr("disabled", true);
        }
    });

    $("#changeNotice").click(function()
    {
        var newNotice = $("#notice").val();
        room.notice = newNotice;

        ajaxRoom(flush);

        delete room["notice"];
    });
</script>

</html>
