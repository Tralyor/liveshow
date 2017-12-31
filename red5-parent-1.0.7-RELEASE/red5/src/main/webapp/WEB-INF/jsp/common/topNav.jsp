<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2017/12/4
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp"%>
<nav class="navbar navbar-inverse navbar-fixed-top live-shadow" role="navigation">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="navbar-header">
                    <!-- <a class="navbar-brand" href="#">菜鸟教程</a> -->
                    <div style="line-height: 50px;">
                        <img src="../static/img/tmp.png" alt="">
                    </div>
                </div>

                <!-- 左边部分 -->
                <ul class="nav navbar-nav live-left">
                    <li class="">
                        <a href="/">首页</a>
                    </li>
                    <li>
                        <a href="/directory/part">
                            分类
                            <b class="live-caret"></b>
                        </a>
                        <div class="live-nav">
                            <div class="live-shadow live-border live-border-radius">
                                <div class="anim">
                                    <div class="class-main">
                                        <div class="list-wrap">
                                            <h4>热门分类</h4>
                                            <ul class="live-btns">
                                                <c:forEach var="modules" items="${modules}">
                                                    <c:if test="${modules.type == true}">
                                                        <li>
                                                            <a href="/directory/module/${modules.id}"><c:out value="${modules.name}"></c:out></a>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                            <h4>热门分类</h4>
                                            <ul class="live-btns">
                                                <c:forEach var="modules" items="${modules}">
                                                    <c:if test="${modules.type == false}">
                                                        <li>
                                                            <a href="/directory/module/${modules.id}"><c:out value="${modules.name}"></c:out></a>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                    <li>
                        <a href="#">直播</a>
                    </li>
                </ul>

                <!-- 右边部分 -->
                <c:choose>
                    <c:when test="${empty sessionScope.user}">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="javascript:;" id="loginA">
                                    <span class="glyphicon glyphicon-log-in"></span> 登录
                                </a>
                            </li>
                            <li>
                                <a href="javascript:;" id="registerA">
                                    <span class="glyphicon glyphicon-user"></span> 注册
                                </a>
                            </li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <div class="nav navbar-nav navbar-right">
                            <div class="live-user">
                                <div class="live-user-img">
                                    <img src="../static/img/logo.jpg" alt="">
                                    <div class="live-nav">
                                        <div class="live-shadow live-border live-border-radius">
                                            <div class="anim">
                                                <div class="user-main">
                                                    <div class="user-out">
                                                        <a href="/user/logout">退出</a>
                                                    </div>
                                                    <div class="user-pic">
                                                        <img src="../static/img/logo.jpg" alt="">
                                                    </div>
                                                    <div class="user-btns">
                                                        <a class="btn btn-large btn-primary btn-block" href="/person/">个人中心</a>
                                                        <a class="btn btn-large btn-primary btn-block" href="/person/following">我的关注</a>
                                                        <a class="btn btn-large btn-primary btn-block" href="/person/liveSetting">直播设置</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
        </div>
    </div>
</nav>
