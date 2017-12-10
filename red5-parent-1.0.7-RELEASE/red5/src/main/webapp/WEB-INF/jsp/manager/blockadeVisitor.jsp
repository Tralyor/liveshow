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
            <p>观众封禁</p>
        </blockquote>
    </div>
    <div id="content">
        <form class="form-inline" id="choice">                          <!--筛选框-->
            <div class="form-group-sm">                                 <!--筛选框-版块选择-->
                <label>选择版块</label>
                <select class="form-control" name="boards" style="width: 65%">
                    <option>XX版块</option>
                </select>
            </div>
            <div class="form-group-sm">                                 <!--筛选框-房间选择-->
                <label>房间号</label>
                <select class="form-control" name="boards" style="width: 65%">
                    <option>XX房间</option>
                </select>
            </div>
            <div class="form-group-sm">
                <label>是否过期</label>
                <label class="radio-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked>是
                </label>
                <label class="radio-inline">
                    <input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2">否
                </label>
            </div>
            <button type="button" class="btn btn-success">确定</button>
        </form>
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
                <th>游客昵称</th>
                <th>房间号</th>
                <th>封禁理由</th>
                <th>封禁证据</th>
                <th>封禁开始时间</th>
                <th>封禁结束时间</th>
                <th>已被封禁次数</th>
                <th>操作</th>
            </tr>
            <tr>
                <td>001</td>
                <td>田泽</td>
                <td>001</td>
                <td>涉黄</td>
                <td data-toggle="modal" data-target="#myModal2" style="cursor: pointer">查看</td>
                <td>2017-11-24</td>
                <td>2017-11-26</td>
                <td>1</td>
                <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="width: 50px">解封</button></td>
            </tr>
        </table>
        <!-- 点击解封弹出的模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel" style="text-align: center">是否确定解封该游客</h4>
                    </div>
                    <!--<div class="modal-body">在这里添加一些文本</div>-->
                    <div class="modal-footer" style="text-align: center">
                        <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                        <button type="button" class="btn btn-primary" style="width: 50px">确定</button>
                    </div>
                </div><!-- /.modal-content -->
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
                    <div class="modal-body">                        <!--证据：图片形式-->
                        <img src="../static/img/chichichi.jpg" class="img-responsive" alt="Responsive image">
                    </div>
                    <div class="modal-footer" style="text-align: center">
                        <button type="button" class="btn btn-default" data-dismiss="modal" style="width: 50px">取消</button>
                        <button type="button" class="btn btn-primary" style="width: 50px">确定</button>
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
