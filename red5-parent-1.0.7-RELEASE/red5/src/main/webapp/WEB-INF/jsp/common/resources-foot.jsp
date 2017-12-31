<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2017/12/10
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<template id="loginDiv">
    <div class="login-tab">
        <ul class="login-tab-title">
            <li class="login-this">登录</li>
            <li>注册</li>
        </ul>
        <div class="login-tab-content">
            <div class="login-tab-item login-show">
                <form>
                    <div class="form-group">
                        <label for="loginName">用户名</label>
                        <input type="text" class="form-control" name="loginName" id="loginName" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label for="password">密码</label>
                        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
                    </div>
                    <button type="submit" class="btn btn-default" id="login">Submit</button>
                </form>
            </div>
            <div class="login-tab-item">
                <form>
                    <div class="form-group">
                        <label>用户名</label>
                        <input type="text" class="form-control" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label>昵称</label>
                        <input type="text" class="form-control" placeholder="username">
                    </div>
                    <div class="form-group">
                        <label>密码</label>
                        <input type="password" class="form-control" placeholder="Password">
                    </div>
                    <div class="form-group">
                        <label>确认密码</label>
                        <input type="password" class="form-control" placeholder="Password">
                    </div>
                    <button type="button" class="btn btn-default" id="register">Submit</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script src="/static/js/plugins/html5shiv.min.js"></script>
<script src="/static/js/plugins/popper.min.js"></script>
<script src="/static/plugins/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
<script src="/static/plugins/layer/layer.js"></script>
<script src="/static/js/user/common.js"></script>
