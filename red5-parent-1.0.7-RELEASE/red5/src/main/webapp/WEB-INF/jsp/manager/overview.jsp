<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/8
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nav</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/overviewcss.css">
</head>
<body>
<div>
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
</div>
<div class="container">
    <div class="row" id="title">
        <div class="col-md-5 col-md-offset-3">
            <blockquote>
                <p>概览</p>
            </blockquote>
        </div>
    </div>
    <div class="row" id="chartpart1">
        <div class="col-md-3"></div>
        <div class="col-md-9" style="margin-top: -20px">
            <div class="row">
                <div class="col-md-10">
                    <div class="col-md-6 chartdiv">
                        <div class="row">
                            <div id="chart1">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-1"></div>
                    <div class="col-md-5 chartdiv">
                        <div class="row">
                            <div id="chart2">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-2"></div>
            </div>
        </div>
    </div>
    <div class="row" id="chartpart2">
        <div class="col-md-3"></div>
        <div class="col-md-9">
            <div class="col-md-10 chartdiv">
                <div class="row">
                    <div id="chart3">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="/static/js/manager/overviewjs.js"></script>
