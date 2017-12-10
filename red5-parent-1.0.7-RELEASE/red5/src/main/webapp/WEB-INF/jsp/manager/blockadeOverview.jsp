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
<nav class="navbar navbar-default navbar-static-top">
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse">
            <ul class="nav" id="side-menu">
                <li>
                    <a><span class="glyphicon glyphicon-asterisk"></span>&nbsp;&nbsp;&nbsp;&nbsp;概览</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-duplicate"></span>&nbsp;&nbsp;&nbsp;&nbsp;板块管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="">设置板块</a>
                        </li>
                        <li>
                            <a href="">首页板块</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;&nbsp;&nbsp;封禁管理</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="blockadeHost.jsp">主播封禁</a>
                        </li>
                        <li>
                            <a href="blockadeVisitor.jsp">游客封禁</a>
                        </li>
                        <li>
                            <a href="blockadeOverview.jsp">封禁概览</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="superAdmin.jsp"><span class="glyphicon glyphicon-star"></span>&nbsp;&nbsp;&nbsp;&nbsp;超管管理</a>
                </li>
                <li>
                    <a href="#"><span class="glyphicon glyphicon-align-left"></span>&nbsp;&nbsp;&nbsp;&nbsp;绩效</a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="">板块绩效</a>
                        </li>
                        <li>
                            <a href="">主播个人绩效</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="main">
    <div id="title">
        <blockquote>
            <p>封禁概览</p>
        </blockquote>
    </div>
    <div id="content">
        <div id="chart1"></div>
        <div id="chart2"></div>
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
        option = {
    //        backgroundColor: '#2c343c',
            backgroundColor:'#ffffff',

            title: {
                text: '各个板块封禁房间数比例饼图',
                left: 'center'
//                top: 20,
//                textStyle: {
//                    color: '#000000'
//                }
            },

            tooltip : {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },

            visualMap: {
                show: false,
                min: 0,
                max: 100,
                inRange: {
                    colorLightness: [0, 1]
                }
            },
            series : [
                {
                    name:'封禁房间数',
                    type:'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value:12, name:'A版块'},
                        {value:17, name:'B版块'},
                        {value:33, name:'C版块'},
                        {value:8, name:'D版块'},
                        {value:25, name:'E版块'}
                    ].sort(function (a, b) { return a.value - b.value; }),
                    roseType: 'radius',
                    label: {
                        normal: {
                            textStyle: {
                                color: 'rgb(0, 0, 0)'
                            }
                        }
                    },
                    labelLine: {
                        normal: {
                            lineStyle: {
                                color: 'rgba(0, 0, 0, 0.3)'
                            },
                            smooth: 0.2,
                            length: 10,
                            length2: 20
                        }
                    },
                    itemStyle: {
                        normal: {
                            color: '#46A3FF',
                            shadowBlur: 10,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    },

                    animationType: 'scale',
                    animationEasing: 'elasticOut',
                    animationDelay: function (idx) {
                        return Math.random() * 200;
                    }
                }
            ]
        };;
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    });

//    各个板块封禁游客数比例饼图
    $(function () {
        var dom = document.getElementById("chart2");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        option = {
            title : {
                text: '各个板块封禁游客数比例饼图',
//            subtext: '纯属虚构',
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
                data: ['A版块','B版块','C版块','D版块','E版块']
            },
            series : [
                {
                    name: '封禁游客人数',
                    type: 'pie',
                    radius : '55%',
                    center: ['50%', '60%'],
                    data:[
                        {value:335, name:'A版块'},
                        {value:310, name:'B版块'},
                        {value:234, name:'C版块'},
                        {value:135, name:'D版块'},
                        {value:1548, name:'E版块'}
                    ],
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
    });

//  封禁趋势
    $(function () {
        var dom = document.getElementById("chart3");
        var myChart = echarts.init(dom);
        var app = {};
        option = null;
        option = {
            title: {
                text: '封禁趋势',
//                subtext: '纯属虚构'
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
                data: ['周一','周二','周三','周四','周五','周六','周日']
            },
            yAxis: {
                type: 'value',
                axisLabel: {
//                    formatter: '{value} °C'
                    formatter: '{value} '
                }
            },
            series: [
                {
                    name:'房间封禁数',
                    type:'line',
                    data:[11, 11, 15, 13, 12, 13, 10],
//                    markPoint: {
//                        data: [
//                            {type: 'max', name: '最大值'},
//                            {type: 'min', name: '最小值'}
//                        ]
//                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
                        ]
                    }
                },
                {
                    name:'游客封禁数',
                    type:'line',
                    data:[1, 0, 2, 5, 3, 2, 0],
//                    markPoint: {
//                        data: [
////                            {name: '周最低', value: 0, xAxis: 1, yAxis: 0}
//                            {type:'max',name:'最大值'},
//                            {type:'max',name:'最小值'}
//                        ]
//                    },
                    markLine: {
                        data: [
                            {type: 'average', name: '平均值'}
//                            [{
//                                symbol: 'none',
//                                x: '90%',
//                                yAxis: 'max'
//                            }, {
//                                symbol: 'circle',
//                                label: {
//                                    normal: {
//                                        position: 'start',
//                                        formatter: '最大值'
//                                    }
//                                },
//                                type: 'max',
//                                name: '最高点'
//                            }]
                        ]
                    }
                }
            ]
        };
        if (option && typeof option === "object") {
            myChart.setOption(option, true);
        }
    })


</script>
