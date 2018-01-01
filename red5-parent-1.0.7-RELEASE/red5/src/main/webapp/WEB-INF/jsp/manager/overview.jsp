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
    <title>概览</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/overviewcss.css">
</head>
<body>
<%@ include file="common/topNavAndSide.jsp"%>
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
<script type="text/javascript" src="/static/js/manager/overviewjs2.js"></script>
