<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="/static/plugins/bootstrap/css/bootstrap.min.css">
    <script type="text/javascript" src="static/js/plugins/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="static/plugins/bootstrap/js/bootstrap.js"></script>
    <style>

        body{
            background-color: #F5F5F5;
        }
        #mainBody {
            width: 1000px;
            margin: 0 auto;
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
        .unit{
            display: inline-block;
            margin-left: 12px;
            width: 135px;
            height: 210px;
            background-color: white;
            overflow: hidden;
        }
        .unit img{
            width: 100%;
            height: 188px;
        }
        .unit:hover{
            background-color: rgba(247,247,247,1);
            border-bottom: solid 1px #D2D2D2;
        }
    </style>
</head>

<body>
<div id="mainBody">
   <div  style="width:1000px;border-bottom: solid 1px #dddddd;margin-bottom: 15px">
       <h1 style="display: inline-block">全部分类</h1>
       <ul class="headUl">
           <li class="liStyle" ><a href="#">全部</a></li>
           <li class="liStyle" ><a href="#">全部</a></li>
           <li class="liStyle" ><a href="#">全部</a></li>
           <li class="liStyle" ><a href="#">全部</a></li>
           <li class="liStyle" ><a href="#">全部</a></li>
           <li class="liStyle" ><a href="#">全部</a></li>
           <li class="liStyle" ><a href="#">全部</a></li>
           <li class="liStyle" ><a href="#">全部</a></li>
       </ul>
   </div>
    
    <div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        <div class="unit">
            <div><img src="/static/img/class.jpg" alt=""></div>
            <div style="text-align: center;color: #7E7E7E"><span>荒岛行动</span></div>
        </div>
        
    </div>
</div>
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
</body>
</html>