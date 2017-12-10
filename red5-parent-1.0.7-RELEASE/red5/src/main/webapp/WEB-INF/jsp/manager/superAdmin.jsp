<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>super-admin-management</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/blockade.css"/>
    <script src="/static/plugins/bootstrap/js/bootstrap-select.js"></script>
</head>
<body>
<!--头部和侧边固定导航栏-->
<nav class="navbar navbar-default navbar-static-top">
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a><span class="glyphicon glyphicon-asterisk"></span>&nbsp;&nbsp;&nbsp;&nbsp;概览</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-duplicate"></span>&nbsp;&nbsp;&nbsp;&nbsp;板块管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="">设置板块</a>
                        </li>
                        <li>
                            <a href="">首页板块</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;&nbsp;&nbsp;封禁管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="blockadeHost.jsp">主播封禁</a>
                        </li>
                        <li>
                            <a href="blockadeVisitor.jsp">游客封禁</a>
                        </li>
                        <li>
                            <a href="blockadeOverview.jsp">封禁概览</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="superAdmin.jsp"><span class="glyphicon glyphicon-star"></span>&nbsp;&nbsp;&nbsp;&nbsp;超管管理</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-align-left"></span>&nbsp;&nbsp;&nbsp;&nbsp;绩效</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="">板块绩效</a>
                        </li>
                        <li>
                            <a href="">主播个人绩效</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="main">
    <div id="title">
        <blockquote>
            <p>超管管理</p>
        </blockquote>
    </div>
    <div id="content">                                                          <!--筛选框-->
        <form class="form-inline" id="choice">                                  <!--筛选框-版块选择-->
            <div class="form-group-sm">
                <label>选择模块</label>
                    <select class="form-control" name="boards" style="width: 68%">
                        <option>XX模块</option>
                    </select>
            </div>
            <!--<div class="form-group-sm">                                         &lt;!&ndash;筛选框-封禁时间选择&ndash;&gt;-->
                <!--<label>开始时间</label>-->
                <!--&lt;!&ndash;<label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>&ndash;&gt;-->
                <!--<div style="width: 70%" class="input-group date form_time " data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">-->
                    <!--<input class="form-control" size="16" type="text" value=""  style="background-color: #ffffff">-->
                    <!--&lt;!&ndash;<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>&ndash;&gt;-->
                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>-->
                <!--</div>-->
                <!--<input type="hidden" id="dtp_input1" value="" /><br/>-->
            <!--</div>-->
            <!--<div class="form-group-sm">-->
                <!--<label>结束时间</label>-->
                <!--&lt;!&ndash;<label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>&ndash;&gt;-->
                <!--<div style="width: 70%" class="input-group date form_time " data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">-->
                    <!--<input class="form-control" size="16" type="text" value=""  style="background-color: #ffffff">-->
                    <!--&lt;!&ndash;<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>&ndash;&gt;-->
                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>-->
                <!--</div>-->
                <!--<input type="hidden" id="dtp_input2" value="" /><br/>-->
            <!--</div>-->
            <button type="button" class="btn btn-success">确定</button>
        </form>
        <div style="float: left;height: 75px;line-height: 75px;">
            <button type="button" class="btn btn-primary" style="width: 100px;height: 30px" data-toggle="modal" data-target="#myModal1">添加超管</button>
        </div>
        <nav aria-label="Page navigation" style="background-color: #ffffff;float: right">                   <!--页码-->
            <ul class="pagination pagination-sm">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
        <div style="float: right;height: 75px;line-height: 75px;margin-right: 50px">共 1 页 1 条记录</div>                           <!--数据记录-->
        <table class="table table-bordered" style="width: 100%;">                <!--表格-->
            <tr style="background-color: #f5f5f5;">
                <th>账号</th>
                <th>超管姓名</th>
                <!--<th>工作时间段</th>-->
                <!--<th>近一个月工作时间</th>-->
                <!--<th>理应工作时间</th>-->
                <th>封禁直播间数</th>
                <th>封禁账号数</th>
                <th>直播间误封率</th>
                <th>游客误封率</th>
                <th>操作</th>
            </tr>
            <tr>
                <td>001</td>
                <td>田泽</td>
                <!--<td>12:00-18:00</td>-->
                <!--<td>50h</td>-->
                <!--<td>70h</td>-->
                <td>5</td>
                <td>15</td>
                <td>20%</td>
                <td>10%</td>
                <td>
                    <!--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2" style="width: 50px">编辑</button>-->
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal3" style="width: 50px">查看</button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal4" style="width: 50px">取消</button>
                </td>
            </tr>
        </table>
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
                            <!--<div class="form-group">-->
                                <!--<label for="superAccount" class="col-sm-2 control-label">超管账号</label>-->
                                <!--<div class="col-sm-10">-->
                                    <!--<input type="email" class="form-control" id="superAccount" >-->
                                <!--</div>-->
                            <!--</div>-->
                            <div class="form-group" id="special">
                                <label class="col-sm-2 control-label" style="width: 30%">选择用户账号</label>
                                <div class="col-sm-10" style="width: 60%">
                                    <select id="basic" class="selectpicker show-tick form-control" data-live-search="true">
                                        <option>001</option>
                                    </select>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer" style="text-align: center">
                        <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                        <button type="button" class="btn btn-primary" style="width: 50px" data-dismiss="modal" data-toggle="modal" data-target="#myModal2">下一步</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        <!-- 点击下一步弹出的模态框（Modal） -->
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel2" style="text-align: center">详细信息</h4>
                    </div>
                    <div class="modal-body pop-up">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">田泽</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">账号</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">001</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">身份证号</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">330000000000000000</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">15000000000</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">家庭住址</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">朝阳区xxxxxxxxxxxxxx</p>
                                </div>
                            </div>
                            <!--<div class="form-group">-->
                                <!--<label class="col-sm-2 control-label">开始时间</label>-->
                                <!--&lt;!&ndash;<label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>&ndash;&gt;-->
                                <!--<div class="input-group date form_time " data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">-->
                                    <!--<input class="form-control" size="16" type="text" value="" readonly style="background-color: #ffffff;">-->
                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>-->
                                <!--</div>-->
                                <!--<input type="hidden" id="dtp_input4" value="" /><br/>-->
                            <!--</div>-->
                            <!--<div class="form-group">-->
                                <!--<label class="col-sm-2 control-label">结束时间</label>-->
                                <!--&lt;!&ndash;<label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>&ndash;&gt;-->
                                <!--<div  class="input-group date form_time " data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">-->
                                    <!--<input class="form-control" size="16" type="text" value="" readonly style="background-color: #ffffff;">-->
                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>-->
                                    <!--<span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>-->
                                <!--</div>-->
                                <!--<input type="hidden" id="dtp_input5" value="" /><br/>-->
                            <!--</div>-->
                        </form>
                    </div>
                    <div class="modal-footer" style="text-align: center">
                        <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                        <button type="button" class="btn btn-primary" style="width: 50px">确定</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
        <!-- 点击查看弹出的模态框（Modal） -->
        <div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel3" style="text-align: center">查看</h4>
                    </div>
                    <div class="modal-body pop-up">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">田泽</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">账号</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">001</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">身份证号</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">330000000000000000</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">联系电话</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">15000000000</p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">家庭住址</label>
                                <div class="col-sm-10">
                                    <p class="form-control-static">朝阳区xxxxxxxxxxxxxx</p>
                                </div>
                            </div>
                            <!--<div class="form-group">-->
                                <!--<label class="col-sm-2 control-label">开始时间</label>-->
                                <!--&lt;!&ndash;<label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>&ndash;&gt;-->
                                <!--<div class="col-sm-10">-->
                                    <!--<p class="form-control-static">12:00</p>-->
                                <!--</div>-->
                            <!--</div>-->
                            <!--<div class="form-group">-->
                                <!--<label class="col-sm-2 control-label">结束时间</label>-->
                                <!--&lt;!&ndash;<label for="dtp_input2" class="col-md-2 control-label">Date Picking</label>&ndash;&gt;-->
                                <!--<div class="col-sm-10">-->
                                    <!--<p class="form-control-static">18:00</p>-->
                                <!--</div>-->
                            <!--</div>-->
                        </form>
                    </div>
                    <div class="modal-footer" style="text-align: center">
                        <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                        <button type="button" class="btn btn-primary" style="width: 50px">确定</button>
                    </div>
                </div><!-- /.modal-content -->
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
                        <button type="button" class="btn btn-primary" style="width: 50px">是</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </div>

</div>
</body>
</html>
<script type="text/javascript">
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
