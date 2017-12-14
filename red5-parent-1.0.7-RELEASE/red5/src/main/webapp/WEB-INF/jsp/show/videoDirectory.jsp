<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          reason="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" reason="ie=edge">
    <title>Document</title>
    <%@ include file="../common/resources.jsp"%>
    <style>

        body
        {
            background-color: #F5F5F5;
        }
        #mainBody {
            /*margin: 0 auto;*/
        }
        .headUl{
            list-style: none;
            display: inline-block;
            vertical-align: middle;
            height: 39px;
        }
        .liStyle{
            display: inline-block;
            width: 60px;
            text-align: center;
            margin-left:20px;
            border-radius: 5px;
            border:solid 1px #D7D7D7;
            float: left;
        }

        .liStyle a,
        .liStyle a:hover ,
        .liStyle a:active,
        .liStyle a:visited{
            text-decoration: none;
            color: black;
        }


        .liStyle:hover{
            cursor: pointer;
            border: solid 1px #ff6600;
        }
        .liStyle:hover > a{
            color: #ff6600;
        }
        
        .footDivBig h3 a,
        .footDivBig h3 a:hover ,
        .footDivBig h3 a:active,
        .footDivBig h3 a:visited{
            text-decoration: none;
        }

        .showVideo{
            overflow: hidden;
            position: relative;
            width: 220px;
            height: 170px;
            display: inline-block;
            vertical-align: top;
            margin-left: 20px;
            margin-top: 15px;
        }
        .showVideo:hover{
            border-bottom: solid 2px #D2D2D2;
        }

        .imgStyle{
            width: 100%;
            height: 70%;
            z-index: -1;
        }
        .textDiv{
            width: 100%;
            height: 50px;
            background: white;
            color: black;
        }
        
        .textDiv ul {
            list-style: none;
            padding-top: 5px;
            /*margin-left: -25px;*/
        }

        .textDiv ul li
        {
            padding-left: 10px;
            white-space: nowrap;
            text-overflow: ellipsis;
        }

        .playIcon{
            position: absolute;
            bottom: -90px;
            width:100%;
            height: 40px;
            display: none;
        }
        .textDiv ul li span{
            display: inline-block;
        }
    </style>
</head>

<body>
<jsp:include page="../common/topNav.jsp"></jsp:include>
<jsp:include page="../common/leftNav.jsp"></jsp:include>
<div class="live-body">
    <div style="padding: 15px;">
        <div id="mainBody">
            <div  style="width:1000px;border-bottom: solid 1px #dddddd;margin-bottom: 15px;padding-left: 12px;">
                <h1 style="display: inline-block">直播修场</h1>
               
            </div>

            <div>
                
                <c:forEach var="room" items="${room}">
                    <div class="showVideo"><img class="imgStyle" src="${room.photo}" alt="">
                        <div class="playIcon">
                            <div style="width: 40px;margin: 0 auto;">
                                <img src="/static/img/play.png" style="height: 100%;width: 100%" alt="">
                            </div>
                        </div>
                        <div class="textDiv">
                            <ul >
                                <li>${room.name}</li>
                                <li style="color: #AEAEAE;font-size: 10px;margin-top: 5px"><span class="glyphicon glyphicon-user" aria-hidden="true" ></span><span style="margin-right: 70px;">${room.nickName}</span> <span  class="glyphicon glyphicon-fire"  aria-hidden="true" ></span>1.4w</li>
                            </ul>
                        </div>
                    </div>
                </c:forEach>
               
             
            </div>
        </div>
    </div>
</div>



<%--<div style="width: 1000px;height: 500px;background-color: gainsboro">--%>
    <%--<c:forEach var="room" items="${room}" varStatus="idx">--%>
        <%--<tr>--%>
            <%--<td><c:out value="${room.id}"></c:out></td>--%>
            <%--<td><c:out value="${roomPopularity.roomIdAndPopularity[idx.index].populartyNow}"></c:out></td>1--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
<%--</div>--%>
<script>
    function clearTagCss() {
        var tag = $(".liStyle");

        for (var i = 0;i < tag.length;i++){
            tag.eq(i).css("background-color","");
            tag.eq(i).children("a").css("color","black");
        }
    }



    $(".liStyle").click(function () {
        clearTagCss();
        $(this).css("background-color","#ff6600");
        $(this).children("a").css("color","white");
    })


</script>
<script>
    //    控制play图标
    $(".showVideo").hover(function () {
        $(this).children(".textDiv").children("ul").children("li").eq(0).css("color","#FF7700");
        $(this).children(".playIcon").css("bottom","90px");
        $(this).children(".playIcon").fadeIn(500);
    })

    $(".showVideo").mouseleave(function () {
        $(this).children(".textDiv").children("ul").children("li").eq(0).css("color","black");
        $(this).children(".playIcon").css("bottom","-90px");
        $(this).children(".playIcon").fadeOut(500);
    })
</script>

</body>
</html>
