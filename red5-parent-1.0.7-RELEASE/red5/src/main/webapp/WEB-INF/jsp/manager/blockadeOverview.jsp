<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ include file="../common/header.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>blockade-overview</title>
    <%@ include file="common/resoures.jsp"%>
    <link rel="stylesheet" type="text/css" href="/static/css/manager/blockade.css"/>
</head>
<body>
<!--头部和侧边固定导航栏-->
<%@ include file="common/topNavAndSide.jsp"%>
<div id="main">
    <div id="title">
        <blockquote>
            <p>封禁概览</p>
        </blockquote>
    </div>
    <div id="content">
        <div id="chart1"></div>
        <div id="chart2" style="height:300px; width: 45%;"></div>
        <div id="chart3"></div>
    </div>

</div>
</body>
</html>
<script type="text/javascript">
    $(function() {
        $('#side-menu').metisMenu();
    });

//  各个板块封禁房间数比例饼图
    $(function () {
        var dom = document.getElementById("chart1");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;

        $.ajax({
            url: "getRoomMuteByModule",
            type:"get",
            dataType:"json",
            success: function(show)
            {
                console.log(show);
                var roomMuteArray = show.data;
                var moduleArray = [];
                for(var i = 0; i < roomMuteArray.length; i++)
                {
                    moduleArray.push(roomMuteArray[i].name);
                }

                option = {
                    title : {
                        text: '各个板块封禁主播数比例饼图',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        top:'10%',
                        data: moduleArray
                    },
                    series : [
                        {
                            name: '封禁游客人数',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:roomMuteArray,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };

                if (option && typeof option === "object") {
                    myChart.setOption(option, true);
                }
            }
        });
    });

//    各个板块封禁游客数比例饼图
    $(function () {
        var dom = document.getElementById("chart2");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;

        $.ajax({
            url:"getDanmaMuteByModule",
            type:"get",
            dataType: "json",
            success: function(show)
            {
                console.log(show);
                if(show.state == 1)
                {
                    var danmaMuteArray = show.data;
                    var moduleArray = [];
                    for(var i = 0; i < danmaMuteArray.length; i++)
                    {
                        moduleArray.push(danmaMuteArray[i].name);
                    }

                    option = {
                        title : {
                            text: '各个板块封禁游客数比例饼图',
                            x:'center'
                        },
                        tooltip : {
                            trigger: 'item',
                            formatter: "{a} <br/>{b} : {c} ({d}%)"
                        },
                        legend: {
                            orient: 'vertical',
                            left: 'left',
                            top:'10%',
                            data: moduleArray
                        },
                        series : [
                            {
                                name: '封禁游客人数',
                                type: 'pie',
                                radius : '55%',
                                center: ['50%', '60%'],
                                data:danmaMuteArray,
                                itemStyle: {
                                    emphasis: {
                                        shadowBlur: 10,
                                        shadowOffsetX: 0,
                                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                                    }
                                }
                            }
                        ]
                    };
                    if (option && typeof option === "object") {
                        myChart.setOption(option, true);
                    }
                }
            }
        });
    });

//  封禁趋势
    $(function () {
        var dom = document.getElementById("chart3");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;

        $.ajax({
            url: "getMuteByDate",
            type: "get",
            dataType: "json",
            success: function(show)
            {
                console.log(show);
                var roomList = show.data.roomList;
                var danmaList = show.data.danmaList;

                var dateList = [];
                var roomNumList = [];
                var danmaNumList = [];
                for(var i = 0; i < roomList.length; i++)
                {
                    dateList.push(roomList[i].date);
                    roomNumList.push(roomList[i].num);
                    danmaNumList.push(danmaList[i].num);
                }
                console.log(dateList);
                console.log(roomNumList);
                console.log(danmaNumList);

                option = {
                    title: {
                        text: '封禁趋势',
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data:['房间封禁数','游客封禁数']
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            dataZoom: {
                                yAxisIndex: 'none'
                            },
                            dataView: {readOnly: false},
                            magicType: {type: ['line', 'bar']},
                            restore: {},
                            saveAsImage: {}
                        }
                    },
                    xAxis:  {
                        type: 'category',
                        boundaryGap: false,
                        data: dateList
                    },
                    yAxis: {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value} '
                        }
                    },
                    series: [
                        {
                            name:'房间封禁数',
                            type:'line',
                            data:roomNumList,
                            markLine: {
                                data: [
                                    {type: 'average', name: '平均值'}
                                ]
                            }
                        },
                        {
                            name:'游客封禁数',
                            type:'line',
                            data:danmaNumList,
                            markLine: {
                                data: [
                                    {type: 'average', name: '平均值'}
                                ]
                            }
                        }
                    ]
                };

                if (option && typeof option === "object") {
                    myChart.setOption(option, true);
                }
            }
        });
    })


</script>
