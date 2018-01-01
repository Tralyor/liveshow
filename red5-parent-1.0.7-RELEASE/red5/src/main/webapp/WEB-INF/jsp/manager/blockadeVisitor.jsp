<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>blockade-visitor</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/blockade.css"/>
</head>
<body>
<%@ include file="common/topNavAndSide.jsp"%>
<div id="main">
    <div id="title">
        <blockquote>
            <p>观众封禁</p>
        </blockquote>
    </div>
    <div id="reason">
        <form class="form-inline" id="choice">                          <!--筛选框-->
            <div class="form-group-sm">                                 <!--筛选框-版块选择-->
                <label>选择版块</label>
                <select class="form-control" id="boardId" name="boards" style="width: 65%">
                    <option value="0"></option>
                    <c:forEach items="${moduleList}" var="module">
                        <option value="${module.id}">${module.name}</option>
                    </c:forEach>
                </select>
            </div>
            <%--<div class="form-group-sm">                                 <!--筛选框-房间选择-->--%>
                <%--<label>房间号</label>--%>
                <%--<select class="form-control" name="boards" style="width: 65%">--%>
                    <%--<option>XX房间</option>--%>
                <%--</select>--%>
            <%--</div>--%>
            <div class="form-group-sm">
                <label>是否过期</label>
                <label class="radio-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="true">是
                </label>
                <label class="radio-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="false" checked>否
                </label>
            </div>
            <button type="button" class="btn btn-success" id="searchBtn">确定</button>
        </form>
        <table class="layui-table" id="darkRoomDanmaId" lay-data="{id:'darkRoomDanmaId', page:true}" lay-filter="darkRoomDanmaId">                <!--表格-->
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<th lay-data="{field:'loginName'}">账号</th>--%>
                <%--<th lay-data="{field:'nickName'}">游客昵称</th>--%>
                <%--<th lay-data="{field:'roomId'}">房间号</th>--%>
                <%--<th lay-data="{field:'name'}">板块名称</th>--%>
                <%--<th lay-data="{field:'danmaContent'}">弹幕内容</th>--%>
                <%--<th lay-data="{field:'startTime'}">封禁开始时间</th>--%>
                <%--<th lay-data="{field:'endTime'}">封禁结束时间</th>--%>
                <%--&lt;%&ndash;<th lay-data="{field:'value'}">已被封禁次数</th>&ndash;%&gt;--%>
                <%--<th lay-data="{field:'state'}">状态</th>--%>
                <%--<th lay-data="{field:'operate', toolbar: '#tool', fixed: 'right'}">操作</th>--%>
            <%--</tr>--%>
            <%--</thead>--%>
            <%--<tbody id="mainTbody">--%>
            <%--<c:forEach items="${muteDTOList}" var="mute" varStatus="i">--%>
                <%--<tr>--%>
                    <%--<td>${mute.loginName}</td>--%>
                    <%--<td>${mute.nickName}</td>--%>
                    <%--<td>${mute.roomId}</td>--%>
                    <%--<td>${mute.name}</td>--%>
                    <%--<td>${mute.danmaContent}</td>--%>
                    <%--<td>${mute.startTime}</td>--%>
                    <%--<td>${mute.endTime}</td>--%>
                        <%--&lt;%&ndash;<td>1</td>&ndash;%&gt;--%>
                    <%--<td>${mute.state}</td>--%>
                    <%--<td muteId="${mute.darkRoomDanmaId}">--%>
                    <%--</td>--%>
                <%--</tr>--%>
            <%--</c:forEach>--%>
            <%--</tbody>--%>
        </table>
    </div>
</div>
<!-- 点击解封弹出的模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel" style="text-align: center">是否确定解封该游客</h4>
            </div>
            <div class="modal-footer" style="text-align: center">
                <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                <button type="button" class="btn btn-primary" id="cancelSubmit" style="width: 50px">确定</button>
            </div>
        </div><!-- /.moreasontent -->
    </div><!-- /.modal -->
</div>

<script type="text/html" id="tool">
    {{# if(d.state == 0 && (new Date(d.endTime) > new Date())) { }}
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" lay-event="cancel" style="width: 50px">解封</button>
    {{# } }}
</script>
</body>
</html>
<script src="/static/js/manager/managerCommon.js"></script>
<script type="text/javascript">
    layui.use(['table', 'layer'], function()
    {
        var table = layui.table;

        var tableIns = table.render({
            id: "darkRoomDanmaId",
            url: "searchMute",
            method: "post",
            response: {
                statusName: 'state',
                statusCode: 1,
                msgName: 'message',
                countName: '',
                dataName: 'data'
            },
            elem: "#darkRoomDanmaId",
            cols: [[
                {field:'loginName', title:'账号'},
                {field:'nickName', title:'昵称'},
                {field:'roomId', title:'房间号'},
                {field:'moduleName', title:'所属板块'},
                {field:'danmaContent', title:'弹幕内容'},
                {field:'startTime', title:'开始时间'},
                {field:'endTime', title:'结束时间'},
//                {field:'state', title:'状态'},
                {field:'operate', title:'操作' , toolbar: '#tool', fixed: 'right'}
            ]],
            page: true,
            where: {
                "moduleId": 0,
                "state": false
            }
        });

        $("#searchBtn").click(function()
        {
            var searchModuleId = $("#boardId").val();
            tableIns.reload({
                where: {
                    "moduleId": searchModuleId,
                    "state": $("input[name='optionsRadiosinline']:checked").val()
                }
            });
        });

        table.on('tool(darkRoomDanmaId)', function(obj)
        {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent == 'cancel')
            {
                $("#cancelSubmit").click(function()
                {
                    $.ajax({
                        url: "cancelMute",
                        type: "post",
                        data: {
                            "muteId": data.darkRoomDanmaId
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

                console.log(data);
            }
        });
    });

    $(function() {
        $('#side-menu').metisMenu();
    });
//    $('.form_date').datetimepicker({
//        format: 'yyyy-mm-dd',
//        language:  'zh-CN',
//        weekStart: 1,
//        todayBtn:  1,
//        autoclose: 1,
//        todayHighlight: 1,
//        startView: 2,
//        minView: 2,
//        forceParse: 0
//    });
</script>
