<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/12/10
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" %>
<nav class="navbar navbar-default navbar-static-top">
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a href="/admin/overview"><span class="glyphicon glyphicon-asterisk"></span>&nbsp;&nbsp;&nbsp;&nbsp;概览</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-duplicate"></span>&nbsp;&nbsp;&nbsp;&nbsp;板块管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/admin/manager">设置板块</a>
                        </li>
                        <li>
                            <a href="/admin/homepart">首页板块</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;&nbsp;&nbsp;封禁管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/admin/blockadeHost">主播禁封</a>
                        </li>
                        <li>
                            <a href="/admin/blockadeVisitor">游客禁封</a>
                        </li>
                        <li>
                            <a href="/admin/blockadeOverview">禁封概览</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/admin/superAdmin"><span class="glyphicon glyphicon-star"></span>&nbsp;&nbsp;&nbsp;&nbsp;超管管理</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-align-left"></span>&nbsp;&nbsp;&nbsp;&nbsp;绩效</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/admin/performance/part">板块绩效</a>
                        </li>
                        <li>
                            <a href="/admin/performance/anchor">主播个人绩效</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
