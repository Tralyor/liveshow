<%--
  Created by IntelliJ IDEA.
  User: Zzzz
  Date: 2017/12/7
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>板块管理</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/partmangercss.css">
</head>
<body onload="init()">
<%@ include file="common/topNavAndSide.jsp"%>
<div class="container">
    <div class="row" id="title">
        <div class="col-md-5 col-md-offset-3">
            <blockquote>
                <p>板块管理</p>
            </blockquote>
        </div>
    </div>
    <div class="row">
        <div class="col-md-8 col-md-offset-3 colorrow">
            <div class="col-md-12">
                <div id="manangediv">
                    <c:forEach var="part" items="${partList}">
                        <div class="row rowall">
                            <div class="col-md-2 col-md-offset-1">
                                <button class="btn btn-default btnpart" id="partButton<c:out value="${part.id}"/>" onclick="managepart(<c:out value="${part.id}"/>)">
                                    <c:out value="${part.name}"/>
                                </button>
                            </div>
                            <div class="col-md-8 module">
                                <div id="part<c:out value="${part.id}"/>">
                                    <c:forEach var="module" items="${moduleList}">
                                        <c:if test="${part.id == module.partId}">
                                            <div class="col-md-2">
                                                <button class="btn btn-default" id="module<c:out value="${module.id}"/>" onclick="managemodule(<c:out value="${part.id}"/>,<c:out value="${module.id}"/>)">
                                                    <c:out value="${module.name}"/>
                                                </button>
                                            </div>
                                        </c:if>
                                    </c:forEach>
                                </div>
                                <div class="col-md-2"><button class="btn btn-default newone" onclick="addmodule(<c:out value="${part.id}"/>)">新添</button></div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div class="row">
                    <div class="col-md-3 col-md-offset-4">
                        <button class="btn btn-default newpart" onclick="addpart()">添加板块</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<template id="addpart">
    <div style="width: 500px;margin-left: -20px;margin-top: 25px;position: absolute;top: 0px;" class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4"><h3 style="text-align: center;"><strong>新添板块</strong></h3></div>
        </div>
        <form>
            <div class="row" style="margin-top: 20px;">
                <div class="col-md-3 col-md-offset-1">
                    <h4 style="text-align: right;"><strong>板块名称：</strong></h4>
                </div>
                <div class="col-md-5">
                    <input id="addPartName" type="text" name="name" style="width: 100%;margin-top: 1px;margin-top: 3px;padding: 2px;border-radius: 2px">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="col-md-8 col-md-offset-2">
                        <input type="button" id="addPartButtom" name="submit" class="btn btn-default confirmbtn" style="width: 100%;margin-top: 35px;" value="确定">
                    </div>
                </div>
            </div>
        </form>
    </div>
</template>
<template id="managepart">
    <div style="width: 500px;margin-left: 0px;margin-top: 25px;position: absolute;top: 0px;" class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4"><h3 style="text-align: center;"><strong>管理板块</strong></h3></div>
        </div>
        <form>
            <div class="row" style="margin-top: 20px;">
                <div class="col-md-3 col-md-offset-1">
                    <h4 style="text-align: right;"><strong>板块名称：</strong></h4>
                </div>
                <div class="col-md-5">
                    <input type="text" id="managepartname" name="name" style="width: 100%;margin-top: 1px;margin-top: 3px;padding: 2px;border-radius: 2px">
                </div>
            </div>
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="col-md-4 col-md-offset-2">
                        <input type="button" name="submit" id="updatePartBtn" class="btn btn-default managebtn" style="width: 100%;margin-top: 35px;" value="确认修改">
                    </div>
                    <div class="col-md-4">
                        <input type="button" name="move" id="movePartBtn" class="btn btn-default movebtn" style="width: 100%;margin-top: 35px;" value="移除板块">
                    </div>
                </div>
            </div>
        </form>
    </div>
</template>
<template id="managemodule">
    <div style="width: 500px;margin-left: 0px;margin-top: 25px;position: absolute;top: 0px;" class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4"><h3 style="text-align: center;"><strong>管理模块</strong></h3></div>
        </div>
        <div class="row" style="margin-top: 20px;">
            <div class="col-md-3 col-md-offset-1">
                <h4 style="text-align: right;"><strong>板块名称：</strong></h4>
            </div>
            <div class="col-md-5">
                <h4><strong id="managemodulePartName"></strong></h4>
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-md-3 col-md-offset-1">
                <h4 style="text-align: right;"><strong>模块名称：</strong></h4>
            </div>
            <div class="col-md-5">
                <input type="text" name="name" id="changename" style="width: 100%;margin-top: 1px;margin-top: 3px;padding: 2px;border-radius: 2px">
            </div>
            <div class="col-md-2">
                <input type="button" id="namebutton" class="btn btn-default" style="width: 100%; margin-top: 2px" value="确认">
            </div>
        </div>
        <div class="row" style="margin-top: 20px">
            <div class="col-md-3 col-md-offset-1">
                <h4 style="text-align: right;"><strong>模块描述：</strong></h4>
            </div>
            <div class="col-md-5">
                <textarea name="description" id="changedescription" style="height: 80px;width: 100%;margin-top: 1px;margin-top: 3px;padding: 2px;border-radius: 2px"></textarea>
            </div>
            <div class="col-md-2">
                <input type="button" id="descriptionbutton" class="btn btn-default" style="width: 100%; margin-top: 2px" value="确认">
            </div>
        </div>
       <form id="changephotoForm">
           <div class="row" style="margin-top: 20px">
               <div class="col-md-3 col-md-offset-1">
                   <h4 style="text-align: right;"><strong>模块图片：</strong></h4>
               </div>
               <div class="col-md-5">
                   <input type="hidden" id="hiddenModuleId" name="id">
                   <input type="file" name="file" style="width: 100%;margin-top: 5px;padding: 2px;border-radius: 2px">
               </div>
               <div class="col-md-2">
                   <input type="button" id="changephotoButton" class="btn btn-default" style="width: 100%; margin-top: 2px" value="上传">
               </div>
           </div>
       </form>
        <div class="row">
            <div class="col-md-10 col-md-offset-1">
                <div class="col-md-4 col-md-offset-2">
                    <input type="button" name="submit" class="btn btn-default managebtn" style="width: 100%;margin-top: 35px;" value="预览图片" id="picbutton">
                </div>
                <div class="col-md-4">
                    <input type="button" name="move" class="btn btn-default movebtn" style="width: 100%;margin-top: 35px;" value="移除板块" id="movemodulebutton">
                </div>
            </div>
        </div>
    </div>
</template>
<template id="addmodule">
    <div style="width: 500px;margin-left: -20px;margin-top: 25px;position: absolute;top: 0px;" class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4"><h3 style="text-align: center;"><strong>新添模块</strong></h3></div>
        </div>
        <form id="addmoduleForm">
            <div class="row" style="margin-top: 20px;">
                <div class="col-md-3 col-md-offset-2">
                    <h4 style="text-align: right;"><strong>板块名称：</strong></h4>
                </div>
                <div class="col-md-5">
                    <h4><strong id="partName"></strong></h4>
                    <input type="hidden" id="partId" name="partId">
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-3 col-md-offset-2">
                    <h4 style="text-align: right;"><strong>模块名称：</strong></h4>
                </div>
                <div class="col-md-5">
                    <input type="text" id="addmoduleName" name="name" style="width: 100%;margin-top: 1px;margin-top: 3px;padding: 2px;border-radius: 2px">
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-3 col-md-offset-2">
                    <h4 style="text-align: right;"><strong>模块描述：</strong></h4>
                </div>
                <div class="col-md-5">
                    <textarea name="description" style="height: 80px;width: 100%;margin-top: 1px;margin-top: 3px;padding: 2px;border-radius: 2px"></textarea>
                </div>
            </div>
            <div class="row" style="margin-top: 20px">
                <div class="col-md-3 col-md-offset-2">
                    <h4 style="text-align: right;"><strong>模块图片：</strong></h4>
                </div>
                <div class="col-md-5">
                    <input type="file" name="file" style="width: 100%;margin-top: 5px;padding: 2px;border-radius: 2px">
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <div class="col-md-8 col-md-offset-2">
                        <input type="button" id="addmoduleButton" class="btn btn-default confirmbtn" style="width: 100%;margin-top: 35px;" value="确定">
                    </div>
                </div>
            </div>
        </form>
    </div>
</template>
<script type="text/javascript" src="/static/js/manager/partmanagerjs.js"></script>
