<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/4
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>nav</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/homepartcss.css">
</head>
<body onload="init()">
<div>
    <%@ include file="common/topNavAndSide.jsp"%>
</div>
<div class="container">
    <div class="row" id="title">
        <div class="col-md-5 col-md-offset-3">
            <blockquote>
                <p>首页板块</p>
            </blockquote>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-3" id="choosediv">
            <div class="row divrow">
                <div class="row">
                    <div class="col-md-8 col-md-offset-1" id="headtip">
                        <h3><strong>热门推荐模块</strong></h3>
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块一：</strong></h4>
                    </div>
                    <form name="form1" id="form1">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,1)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(1)">
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块二：</strong></h4>
                    </div>
                    <form name="form2" id="form2">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,2)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(2)">
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块三：</strong></h4>
                    </div>
                    <form name="form3" id="form3">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,3)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(3)">
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块四：</strong></h4>
                    </div>
                    <form name="form4" id="form4">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,4)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(4)">
                    </div>
                </div>
            </div>

            <div class="row divrow">
                <div class="row">
                    <div class="col-md-8 col-md-offset-1" id="headtip2">
                        <h3><strong>玩家推荐模块</strong></h3>
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块一：</strong></h4>
                    </div>
                    <form name="form5" id="form5">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,5)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(5)">
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块二：</strong></h4>
                    </div>
                    <form name="form6" id="form6">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,6)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(6)">
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块三：</strong></h4>
                    </div>
                    <form name="form7" id="form7">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,7)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(7)">
                    </div>
                </div>
                <div class="row partrow">
                    <div class="col-md-1 col-md-offset-3">
                        <h4><strong>模块四：</strong></h4>
                    </div>
                    <form name="form8" id="form8">
                        <div class="col-md-2">
                            <select class="form-control" name="part" onchange="select_change(this.selectedIndex,8)"></select>
                        </div>
                        <div class="col-md-2">
                            <select class="form-control" name="module"></select>
                        </div>
                    </form>
                    <div class="col-md-2">
                        <input type="submit" name="submit" value="确认" class="btn btn-default" onclick="handleInfo(8)">
                    </div>
                </div>
            </div>

            <h5 class="page-header"></h5>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript" src="/static/js/manager/homepartjs.js"></script>