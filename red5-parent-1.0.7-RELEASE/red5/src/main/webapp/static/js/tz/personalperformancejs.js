$(function() {
    $('#side-menu').metisMenu();
})

var echart = echarts.init(document.getElementById('chart'));

option = {
    title: {
        text: '人气时长记录表',
        left: 'center'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            animation: false
        }
    },
    legend: {
        data:['时长', '人气'],
        left: 'left'
    },
    grid: {
        top: 70,
        bottom: 50
    },
    xAxis : [
        {
            type : 'category',
            data : [],
            axisTick: {
                alignWithLabel: true
            }
        }
    ],
     yAxis : [
        {
             type: 'value',
             name: '时长',
             position: 'left',
                axisLabel: {
                    formatter: '{value} （分）'
                }
        },
        {
            type: 'value',
            name: '人气',
            position: 'right',
            axisLabel: {
                formatter: '{value} （人）'
            }
        },
    ],
    series: [
        {
            name:'时长',
            type:'line',
            data:[]
        },
        {
            name:'人气',
            type:'line',
            yAxisIndex: 1,
            data:[]
        }
    ]
};

echart.setOption(option);

var durationList = new Array();
var populationList = new Array();
function getInfo() {
    var date = new Date();
    date.setHours(0, 0, 0, 0);
    var timestamp1 = Date.parse(date);
    var endTime = timestamp1 / 1000;
    var startTime = endTime - (86400 * 15);
    var datetime = new Array();
    var timestamp2 = timestamp1 - (86400000 * 15);
    for(var i = 0; i < 15;i++){
        var timestamp = timestamp2 + (i * 86400000);
        var date = new Date();
        date.setTime(timestamp);
        var str = (date.getMonth() + 1) + "." + date.getDate();
        datetime[i] = str;
    }
    var username = document.getElementById("username").value;
    $.ajax({
        type : "post",
        url : "/performance/anchorinfo",
        dataType:"json",
        data : {
            "userName" : username
        },
        success : function(datainfo){
            if(datainfo.state == 1){
                var tdList1 = document.getElementById("info1").getElementsByTagName("td");
                var tdList2 = document.getElementById("info2").getElementsByTagName("td");
                tdList1[0].innerHTML = datainfo.data.userName;
                tdList1[1].innerHTML = datainfo.data.roomId;
                tdList1[2].innerHTML = datainfo.data.realName;
                tdList1[3].innerHTML = datainfo.data.cardId;
                tdList1[4].innerHTML = datainfo.data.telephone;
                tdList2[0].innerHTML = datainfo.data.highestPopulation;
                tdList2[1].innerHTML = parseInt(datainfo.data.wholeDuration / 60) + 1;
                tdList2[2].innerHTML = datainfo.data.times;
                tdList2[3].innerHTML = datainfo.data.danmakuNumber;
                setChart(username, startTime, endTime, datetime);
            }else{
                layer.msg(datainfo.message);
            }
        }
    });
}

function setChart(username, startTime, endTime, datetime) {
    $.ajax({
        type : "post",
        url : "/performance/chartinfo",
        dataType:"json",
        data : {
            "userName" : username,
            "startTime" : startTime,
            "endTime" : endTime
        },
        success : function(datainfo2){
            if(datainfo2.state == 1){
                durationList = datainfo2.data["duration"];
                populationList = datainfo2.data["population"];
            }
            echart.setOption({
                legend: {
                    data:['时长', '人气'],
                    left: 'left'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        animation: false
                    }
                },
                xAxis : [
                    {
                        type : 'category',
                        data : datetime,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series: [
                    {
                        name:'时长',
                        type:'line',
                        data:durationList
                    },
                    {
                        name:'人气',
                        type:'line',
                        yAxisIndex: 1,
                        data:populationList
                    }
                ]
            });
        }
    });
}