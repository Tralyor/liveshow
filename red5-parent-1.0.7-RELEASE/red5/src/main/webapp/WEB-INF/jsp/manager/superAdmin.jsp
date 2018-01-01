<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>super-admin-management</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/blockade.css"/>
    <link rel="stylesheet" type="text/css" href="/static/plugins/bootstrap/css/bootstrap-select.css">
    <script src="/static/plugins/bootstrap/js/bootstrap-select.js"></script>
</head>
<body>
<!--头部和侧边固定导航栏-->
<%@ include file="common/topNavAndSide.jsp"%>
<div id="main">
    <div id="title">
        <blockquote>
            <p>超管管理</p>
        </blockquote>
    </div>
    <div id="reason">                                                          <!--筛选框-->
        <form class="form-inline" id="choice">                                  <!--筛选框-版块选择-->
            <div class="form-group-sm">
                <label>选择模块</label>
                    <select class="form-control" id="boardId" name="boards" style="width: 68%">
                        <option></option>
                        <c:forEach items="${moduleList}" var="module">
                            <option value="${module.id}">${module.name}</option>
                        </c:forEach>
                    </select>
            </div>
            <button type="button" class="btn btn-success" id="searchBtn">确定</button>
        </form>
        <div style="height: 75px;line-height: 75px;">
            <button type="button" class="btn btn-primary" style="width: 100px;height: 30px" data-toggle="modal" data-target="#myModal1">添加超管</button>
            <%--<button type="button" class="btn btn-primary" style="width: 100px;height: 30px" id="addSuperManager">添加超管</button>--%>
        </div>
        <table class="layui-table" lay-data="{id:'test', page:true}" lay-filter="test">                <!--表格-->
            <thead>
            <tr>
                <%--<th lay-data="{field:'managerId'}"></th>--%>
                <th lay-data="{field:'loginName'}">账号</th>
                <th lay-data="{field:'realName', width: 100}">超管姓名</th>
                <th lay-data="{field:'idNum'}">身份证号码</th>
                <th lay-data="{field:'tel', width: 150}">联系方式</th>
                <%--<th lay-data="{field:'address'}">家庭住址</th>--%>
                <th lay-data="{field:'name', width: 110}">管理板块</th>
                <th lay-data="{field:'roomNum', width: 130, sort: true}">封禁直播间数</th>
                <th lay-data="{field:'falseProportion', width: 130, sort: true}">直播间误封率</th>
                <th lay-data="{field:'operate', width: 130, toolbar: '#tool', fixed: 'right'}">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${superManagerDTOList}" var="superManager" varStatus="i">
                <tr>
                    <%--<td>${superManager.managerId}</td>--%>
                    <td>${superManager.loginName}</td>
                    <td>${superManager.realName}</td>
                    <td>${superManager.idNum}</td>
                    <td>${superManager.tel}</td>
                    <%--<td>${superManager.address}</td>--%>
                    <td>${superManager.moduleName}</td>
                    <td>${superManager.roomNum}</td>
                    <td>${superManager.falseProportion}</td>
                    <td>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>

<!-- 点击添加超管弹出的模态框（Modal） -->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel1" style="text-align: center">添加超级管理员</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group" id="special">
                        <label class="col-sm-4 control-label">选择用户账号</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="loginNameInput" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-4 control-label">选择管理模块</label>
                        <div class="col-sm-8">
                            <select class="form-control" id="moduleIdSelect" name="boards">
                                <option></option>
                                <c:forEach items="${moduleList}" var="module">
                                    <option value="${module.id}">${module.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer" style="text-align: center">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                <%--<button type="button" class="btn btn-primary" style="width: 50px" data-dismiss="modal" data-toggle="modal" data-target="#myModal2">下一步</button>--%>
                <button type="button" class="btn btn-primary" style="width: 50px" id="addSubmit">确定</button>
            </div>
        </div><!-- /.moreasontent -->
    </div><!-- /.modal -->
</div>
<!-- 点击下一步弹出的模态框（Modal） -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2" style="text-align: center">详细信息</h4>
            </div>
            <div class="modal-body pop-up">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">账号</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="modalLoginName">001</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <p class="form-control-static" id="modalRealName">田泽</p>
                        </div>
                    </div>
                    <div class="form-group">
                        <label  class="col-sm-2 control-label">管理模块</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="changeModuleIdSelect" name="boards">
                                <option></option>
                                <c:forEach items="${moduleList}" var="module">
                                    <option value="${module.id}">${module.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer" style="text-align: center">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                <button type="button" class="btn btn-primary" id="changeSubmit" style="width: 50px">确定</button>
            </div>
        </div><!-- /.moreasontent -->
    </div><!-- /.modal -->
</div>

<!-- 点击取消弹出的模态框（Modal） -->
<div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel4" style="text-align: center">是否取消该超管身份</h4>
            </div>
            <!--<div class="modal-body">在这里添加一些文本</div>-->
            <div class="modal-footer" style="text-align: center">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">否</button>
                <button type="button" class="btn btn-primary" id="canelSubmit" style="width: 50px">是</button>
            </div>
        </div><!-- /.moreasontent -->
    </div><!-- /.modal -->
</div>
<template id="tool">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal3" lay-event="edit" style="width: 50px">编辑</button>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal4" lay-event="canel" style="width: 50px">取消</button>
</template>
</body>
</html>
<script src="/static/js/manager/managerCommon.js"></script>
<script type="text/javascript">
    layui.use(['table', 'layer'], function()
    {
        var table = layui.table;
        var layer = layui.layer;

        $("#searchBtn").click(function()
        {
            var searchModuleId = $("#boardId").val();
            if(searchModuleId == "" && searchModuleId.length == 0)
            {
                searchModuleId = 0;
            }
            table.reload('test', {
                url: "searchSuperManager",
                method: 'post',
                response: {
                    statusName: 'state',
                    statusCode: 1,
                    msgName: 'message',
                    countName: '',
                    dataName: 'data'
                },
                where: {
                    "moduleId": searchModuleId
                }
            });
        });

        table.on('tool(test)', function(obj)
        {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent == 'canel')
            {
                $("#canelSubmit").click(function()
                {
                    $.ajax({
                        url: "cancelManager",
                        type: "post",
                        data: {
                            "loginName": data.loginName
                        },
                        dataType: "json",
                        success: function(show)
                        {
                            if(show.state == 1)
                            {
                                obj.del();
                            }
                            layerMsg(show, nothingDoFun, nothingDoFun);
                        }
                    })
                });
            }
            else if(layEvent == 'edit')
            {
                $("#modalLoginName").text(data.loginName);
                $("#modalRealName").text(data.realName);

                $("#changeSubmit").click(function()
                {
                    var $changeModuleIdSelect = $("#changeModuleIdSelect");
                    var changeModuleId = $changeModuleIdSelect.val();
                    if(changeModuleId == "" && changeModuleId.length == 0)
                    {
                        $changeModuleIdSelect.focus();
                        return ;
                    }

                    $.ajax({
                        url: "changeManager",
                        type: "post",
                        data: {
                            "loginName": data.loginName,
                            "moduleId": changeModuleId,
                        },
                        dataType: "json",
                        success: function(show)
                        {
                            layerMsg(show, flush, nothingDoFun);
                        }
                    })
                })
            }
        });

        $("#addSubmit").click(function()
        {
            var $loginNameInput = $("#loginNameInput");
            var $moduleIdSelect = $("#moduleIdSelect");

            var loginName = $loginNameInput.val()
            if(loginName == "" && loginName.length == 0)
            {
                $loginNameInput.focus();
                return ;
            }

            var moduleId = $moduleIdSelect.val();
            if(moduleId == "" && moduleId.length == 0)
            {
                $moduleIdSelect.focus();
                return ;
            }

            $.ajax({
                url: "addSuperManager",
                type: "post",
                data: {
                    "loginName": loginName,
                    "moduleId": moduleId
                },
                dataType: "json",
                success: function(show)
                {
                    layerMsg(show, flush, nothingDoFun);
                }
            })
        })
    });

    $(function() {
        $('#side-menu').metisMenu();
    });
    $('.form_time').datetimepicker({
        format: 'hh:ii',
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
</script>
