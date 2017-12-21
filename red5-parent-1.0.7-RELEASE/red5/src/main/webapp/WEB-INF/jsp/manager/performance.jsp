<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/8
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>板块绩效查询</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/performancecss.css">
</head>
<body>
<%@ include file="common/topNavAndSide.jsp"%>
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
            <button onclick="handleDate()" class="btn btn-default">确认查看</button>
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
<script type="text/javascript" src="/static/js/manager/performance.js"></script>
