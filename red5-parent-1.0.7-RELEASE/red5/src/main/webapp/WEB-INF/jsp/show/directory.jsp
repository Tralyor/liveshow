<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          reason="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" reason="ie=edge">
    <title>分类</title>
    <%@ include file="../common/resources.jsp"%>
    <style>

        body
        {
            background-color: #F5F5F5;
        }

        #mainBody
        {
            /*margin: 0 auto;*/
        }

        .headUl
        {
            list-style: none;
            display: inline-block;
            vertical-align: middle;
            height: 39px;
        }

        .liStyle
        {
            display: inline-block;
            width: 60px;
            text-align: center;
            margin-left: 20px;
            border-radius: 5px;
            border: solid 1px #D7D7D7;
            float: left;
        }

        .liStyle a,
        .liStyle a:hover,
        .liStyle a:active,
        .liStyle a:visited
        {
            text-decoration: none;
            color: black;
        }

        .liStyle:hover
        {
            cursor: pointer;
            border: solid 1px #ff6600;
        }

        .liStyle:hover > a
        {
            color: #ff6600;
        }

        .unit
        {
            display: inline-block;
            margin-left: 12px;
            width: 135px;
            height: 220px;
            background-color: white;
            overflow: hidden;
        }

        .unit img
        {
            width: 100%;
            height: 188px;
        }

        .unit .unit-span
        {
            padding-top: 5px;
            padding-bottom: 5px;
        }

        .unit:hover
        {
            background-color: rgba(247, 247, 247, 1);
            border-bottom: solid 1px #D2D2D2;
        }
    </style>
</head>

<body>
<jsp:include page="../common/topNav.jsp"></jsp:include>
<jsp:include page="../common/leftNav.jsp"></jsp:include>

<div class="live-body">
    <div style="padding: 15px;">
        <div id="mainBody">
            <div style="width:1000px;border-bottom: solid 1px #dddddd;margin-bottom: 15px;padding-left: 12px;">
                <h1 style="display: inline-block">全部分类</h1>
                <ul class="headUl">
                    <li class="liStyle" name="0"><a href="#">全部</a></li>
                    <c:forEach var="part" items="${parts}">
                        <li class="liStyle" name="${part.id}"><a href="#">${part.name}</a></li>
                    </c:forEach>
                </ul>
            </div>

            <div id="reason">
                <c:forEach items="${allModules}" var="module" >
                    <a href="/directory/module/${module.id}">
                    <div class="unit">
                        <div><img src="${module.photo}" alt=""></div>
                        <div class="unit-span" style="text-align: center;color: #7E7E7E"><span>${module.name}</span></div>
                    </div>
                    </a>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<%@ include file="../common/resources-foot.jsp"%>
<script>
    function clearTagCss()
    {
        var tag = $(".liStyle");
        for(var i = 0; i < tag.length; i++)
        {
            tag.eq(i).css("background-color", "");
            tag.eq(i).children("a").css("color", "black");
        }
    }
    $(".liStyle").click(function()
    {
        clearTagCss();
        $(this).css("background-color", "#ff6600");
        $(this).children("a").css("color", "white");
    })


</script>

<script>
    $(".liStyle").click(function () {
        $.ajax({
            type: "POST",
            url: "/directory/partClass",
            dataType:"json",
            data: "typeNum=" + parseInt($(this).attr("name")),
            success: function(data){
               $("#reason").empty();
               for(var i = 0 ; i < data.length ; i++){
                    var str = "<div class=\"unit\"> <div><img src=\"" + data[i]["photo"]+  "\" alt=\"\"></div> <div class=\"unit-span\" style=\"text-align: center;color: #7E7E7E\"><span>" + data[i]["name"] + "</span></div> </div>";
                   $("#reason") .append(str);
               }
            }
        });
    })
</script>
</body>
</html>
