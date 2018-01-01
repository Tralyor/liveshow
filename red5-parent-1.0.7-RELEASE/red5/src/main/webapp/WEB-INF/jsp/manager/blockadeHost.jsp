<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>blockade-host</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/blockade.css"/>
</head>
<body>
<!--头部和侧边固定导航栏-->
<%@ include file="common/topNavAndSide.jsp"%>
<div id="main">
    <div id="title">
        <blockquote>
            <p>主播封禁</p>
        </blockquote>
    </div>
    <div id="reason">
        <form class="form-inline" id="choice">
            <div class="form-group-sm">                                     <!--筛选框-版块选择-->
                <label>选择版块</label>
                <select class="form-control" id="boardId" name="boards" style="width: 65%">
                    <option value="0"></option>
                    <c:forEach items="${moduleList}" var="module">
                        <option value="${module.id}">${module.name}</option>
                    </c:forEach>
                </select>
            </div>
            <!--筛选框-->
            <div class="form-group-sm">                                     <!--筛选框-开始时间选择-->
                <label>开始时间</label>
                <div style="width: 65%" class="input-group date form_date " data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input1" data-link-format="yyyy-mm-dd">
                    <input class="form-control" id="startTimeInput" size="16" type="text" value="" style="background-color: #ffffff">
                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <input type="hidden" id="dtp_input1" value="" /><br/>
            </div>
            <div class="form-group-sm">                                     <!--筛选框-结束时间选择-->
                <label>结束时间</label>
                <div style="width: 65%" class="input-group date form_date " data-date="" data-date-format="dd MM yyyy" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                    <input class="form-control" id="endTimeInput" size="16" type="text" value="" style="background-color: #ffffff">
                    <span class="input-group-addon" ><span class="glyphicon glyphicon-calendar"></span></span>
                </div>
                <input type="hidden" id="dtp_input2" value="" /><br/>
            </div>
            <div class="form-group-sm">
                <label>是否过期</label>
                <label class="radio-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="true" >是
                </label>
                <label class="radio-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="false" checked>否
                </label>
            </div>

            <button type="button" id="searchBtn" class="btn btn-success">确定</button>
        </form>
        <%--<nav aria-label="Page navigation" style="background-color: #ffffff;float: right">   <!--页码-->--%>
            <%--<ul class="pagination pagination-sm">--%>
                <%--<li>--%>
                    <%--<a href="#" aria-label="Previous">--%>
                        <%--<span aria-hidden="true">&laquo;</span>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li><a href="#">1</a></li>--%>
                <%--<li>--%>
                    <%--<a href="#" aria-label="Next">--%>
                        <%--<span aria-hidden="true">&raquo;</span>--%>
                    <%--</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
        <%--</nav>--%>
        <%--<div style="float: right;height: 75px;line-height: 75px;margin-right: 50px">共 1 页 1 条记录</div>   <!--数据总数-->--%>
        <table class="layui-table" id="darkroomRoomId" lay-filter="darkroomRoomId">           <!--表格-->
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th lay-data="{field:'id', width:50}"></th>--%>
                <%--<th lay-data="{field:'nickName'}">主播昵称</th>--%>
                <%--<th lay-data="{field:'realName'}">主播姓名</th>--%>
                <%--<th lay-data="{field:'roomId'}">房间号</th>--%>
                <%--<th lay-data="{field:'name'}">所属板块</th>--%>
                <%--<th lay-data="{field:'reason'}">封禁理由</th>--%>
                <%--<th lay-data="{field:'photo'}">封禁证据</th>--%>
                <%--<th lay-data="{field:'startTime'}">封禁开始时间</th>--%>
                <%--<th lay-data="{field:'endTime'}">封禁结束时间</th>--%>
                <%--<th lay-data="{field:'state'}">状态</th>--%>
                <%--<th lay-data="{field:'operate'}">操作</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody>--%>
            <%--<tr>--%>
                <%--<td>1</td>--%>
                <%--<td>爸爸就是田泽</td>--%>
                <%--<td>田泽</td>--%>
                <%--<td>001</td>--%>
                <%--<td>手机游戏</td>--%>
                <%--<td>涉黄</td>--%>
                <%--<td>--%>
                    <%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2" style="width: 50px;">查看</button>--%>
                <%--</td>--%>
                <%--<td>2017-11-24</td>--%>
                <%--<td>2017-11-26</td>--%>
                <%--<td>过期</td>--%>
                <%--<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="width: 50px;">解封</button></td>--%>
            <%--</tr>--%>
            <%--</tbody>--%>
        </table>
    </div>
</div>
</body>
<!-- 点击取消弹出的模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel" style="text-align: center">是否确定解封该主播</h4>
            </div>
            <!--<div class="modal-body">在这里添加一些文本</div>-->
            <div class="modal-footer" style="text-align: center">
                <button type="button" class="btn btn-default" data-dismiss="modal"  id="close" style="width: 50px">取消</button>
                <button type="button" class="btn btn-primary" id="cancelSubmit" style="width: 50px">确定</button>
            </div>
        </div><!-- /.moreasontent -->
    </div><!-- /.modal -->
</div>
<!-- 点击查看弹出的模态框（Modal） -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel2" style="text-align: center">封禁证据</h4>
            </div>
            <div class="modal-body">                                   <!-- 证据：图片形式 -->
                <img src="../static/img/chichichi.jpg" class="img-responsive" alt="Responsive image">
            </div>
            <div class="modal-footer" style="text-align: center">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                <button type="button" class="btn btn-primary" style="width: 50px" >确定</button>
            </div>
        </div><!-- /.moreasontent -->
    </div><!-- /.modal -->
</div>
</html>
<template id="tool">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" lay-event="cancel" style="width: 50px;">解封</button>
</template>
<template id="picBtn">
    <button type="button" class="btn btn-primary" data-photo="{{d.photo}}" name="show" style="width: 50px;">查看</button>
</template>
<template id="showPic">
    <div class="col-lg-10 col-lg-offset-1">
        <img src="" id="photo"/>
    </div>
</template>
<script src="/static/js/manager/managerCommon.js"></script>
<script type="text/javascript">
    layui.use(['table', 'layer'], function()
    {
        var table = layui.table;
        var layer = layui.layer;

        var tableIns = table.render({
            id: "darkroomRoomId",
            url: "searchRoomMute",
            method: "post",
            response: {
                statusName: 'state',
                statusCode: 1,
                msgName: 'message',
                countName: '',
                dataName: 'data'
            },
            elem: "#darkroomRoomId",
            cols: [[
                {field:'nickName', title:'主播昵称'},
                {field:'realName', title:'主播姓名'},
                {field:'roomId', title:'房间号'},
                {field:'moduleName', title:'所属板块'},
                {field:'reason', title:'封禁理由'},
                {field:'photo', title:'封禁证据', templet:'#picBtn'},
                {field:'startTime', title:'开始时间'},
                {field:'endTime', title:'结束时间'},
//                {field:'state', title:'状态'},
                {field:'operate', title:'操作' , toolbar: '#tool', fixed: 'right'}
            ]],
            page: true,
            where: {
                "moduleId": 0,
                "startTime": null,
                "endTime": null,
                "state": false
            }
        });

        $("#searchBtn").click(function()
        {
            var searchModuleId = $("#boardId").val();
            tableIns.reload({
                where: {
                    "moduleId": searchModuleId,
                    "startTime": $("#startTimeInput").val(),
                    "endTime": $("#endTimeInput").val(),
                    "state": $("input[name='optionsRadiosinline']:checked").val()
                }
            });
        });

        $(document).on("click", "button[name='show']", function(){
            layer.open({
                title: "查看图片证据",
                content: $("#showPic").html(),
                btn: [],
                area: "800px",
                offset: "200px"
            });

            $("#photo").attr("src", $(this).attr("data-photo"));
        });

        table.on('tool(darkroomRoomId)', function(obj)
        {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent == 'cancel')
            {
                console.log($("#cancelSubmit"));
                $("#cancelSubmit").click(function()
                {
                    $.ajax({
                        url: "/admin/cancelRoomMute",
                        type: "post",
                        data: {
                            "id": data.roomMuteId
                        },
                        dataType: "json",
                        success: function(show)
                        {
                            if(show.state == 1)
                            {
                                obj.del();
                            }
                            layerMsg(show, nothingDoFun, nothingDoFun);
                            $("#close").click();
                        }
                    })
                });

                console.log(data);
            }
        });
    });

    $(function() {
        $('#side-menu').metisMenu();
    });
    $('.form_date').datetimepicker({
        format: 'yyyy-mm-dd',
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
</script>
