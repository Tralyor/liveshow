<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/11
  Time: 15:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <%@ include file="common/resoures.jsp"%>
    <style type="text/css">
        .container {
            width: 100%;
        }
        #formdiv {
            width: 25%;
            height:40%;
            border:1px solid #BEBEBE;
            box-shadow: 5px 5px 5px  	#F0F0F0;
            position: absolute;
            top: 50%;
            left: 50%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
        .btn {
            width: 100%;
            font-family: '微软雅黑';
        }
        .col-md-8 {
            margin-top: 5%
        }
        .col-md-4 {
            margin-top: 6%;
        }
        #login {
            margin-top: 12%;
            font-family: '微软雅黑';
            text-align: center;
            font-size: 35px;
            color: gray;
        }
        #logo {
            width: 10%;
            height: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <img src="/static/img/logo/logo-0.png" id="logo">
    <div id="formdiv" class="row">
        <form>
            <div class="row" id="login">
                <span>Login</span>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="input-group">
							<span class="input-group-addon">
			                    <span class="glyphicon glyphicon-user"></span>
			                </span>
                        <input type="text" name="loginName" class="form-control">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 col-md-offset-2">
                    <div class="input-group">
							<span class="input-group-addon">
			                    <span class=" glyphicon glyphicon-lock"></span>
			                </span>
                        <input type="password" name="password" class="form-control">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <input type="button" class="btn btn-default" onclick="dologin()" name="submit" value="登录">
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    function dologin() {
        var loginName = document.getElementsByTagName("input")[0].value;
        var password = document.getElementsByTagName("input")[1].value;
        $.ajax({
            type : "post",
            url : "/admin/doLogin",
            dataType:"json",
            data : {
                "loginName" : loginName,
                "password" : password
            },
            success : function(data){
                if(data.state == 0){
                    layer.msg(data.message);
                }else{
                    window.location.href="/admin/overview";
                }
            }
        });
    }
</script>