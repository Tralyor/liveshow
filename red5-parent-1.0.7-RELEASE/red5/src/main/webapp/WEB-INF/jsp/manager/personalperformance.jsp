<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/8
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>主播个人绩效查询</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/personalperformancecss.css">
</head>
<body>
<%@ include file="common/topNavAndSide.jsp"%>
<div class="container">
    <div class="row" id="title">
        <div class="col-md-5 col-md-offset-3">
            <blockquote>
                <p>主播个人绩效</p>
            </blockquote>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-8 col-md-offset-3">
            <div class="row partdiv">
                <div class="row">
                    <div class="col-md-2"><h5><strong>主播名称</strong></h5></div>
                    <div class="col-md-3" style="margin-left: -30px;"><input type="text" id="username" name="name" class="form-control"></div>
                    <div class="col-md-2"><button class="btn btn-default" onclick="getInfo()">搜索</button></div>
                </div>
                <div class="row">
                    <table class="table table-bordered table-hover">
                        <tr>
                            <th>主播名称</th>
                            <th>主播房间号</th>
                            <th>真实姓名</th>
                            <th>身份证号码</th>
                            <th>联系方式</th>
                        </tr>
                        <tr id="info1">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
                <div class="row">
                    <table class="table table-bordered table-hover">
                        <tr>
                            <th>最高人气</th>
                            <th>直播总时长（分）</th>
                            <th>直播次数</th>
                            <th>弹幕总数</th>
                        </tr>
                        <tr id="info2">
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="row chartdiv">
                <div id="chart">
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="/static/js/manager/personalperformancejs.js"></script>
