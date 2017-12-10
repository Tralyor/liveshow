<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/8
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nav</title>
    <link rel="stylesheet" type="text/css" href="../../../static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="../../../static/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="../../../static/plugins/metisMenu/metisMenu.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/tz/nav.css">
    <link rel="stylesheet" type="text/css" href="../../../static/css/tz/performancecss.css">
    <script type="text/javascript" src="../../../static/js/plugins/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../../../static/js/plugins/echarts.min.js"></script>
    <script type="text/javascript" src="../../../static/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../../../static/plugins/metisMenu/metisMenu.min.js"></script>
    <link href="../../../static/plugins/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
    <script src="../../../static/plugins/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
    <script src="../../../static/plugins/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js" charset="UTF-8"></script>
</head>
<body>
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
                    <a href="#"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;&nbsp;&nbsp;禁封管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="">主播禁封</a>
                        </li>
                        <li>
                            <a href="">游客禁封</a>
                        </li>
                        <li>
                            <a href="">禁封概览</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a><span class="glyphicon glyphicon-star"></span>&nbsp;&nbsp;&nbsp;&nbsp;超管管理</a>
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
<div class="container">
    <div class="row" id="title">
        <div class="col-md-5 col-md-offset-3">
            <blockquote>
                <p>板块绩效</p>
            </blockquote>
        </div>
    </div>
    <div class="row">
        <div class='col-md-2 col-md-offset-5'>
            <div class="form-group">
                <label>选择开始时间：</label>
                <div class='input-group date' id='datetimepicker1'>
                    <input type='text' class="form-control" id="text1" />
                    <span class="input-group-addon">
		                    <span class="glyphicon glyphicon-calendar"></span>
		                </span>
                </div>
            </div>
        </div>
        <div class='col-md-2'>
            <div class="form-group">
                <label>选择结束时间：</label>
                <div class="input-group date" id="datetimepicker2">
                    <input type='text' class="form-control" id="text2" />
                    <span class="input-group-addon">
		                    <span class="glyphicon glyphicon-calendar"></span>
		                </span>
                </div>
            </div>
        </div>
        <div class="col-md-1">
            <button onclick="setData()" class="btn btn-default">确认查看</button>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-3">
            <div class="row">
                <div class="col-md-10 col-md-offset-1 chartdiv">
                    <div id="chart">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="../../../static/js/tz/performance.js"></script>