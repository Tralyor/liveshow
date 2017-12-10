$(function() {
    $('#side-menu').metisMenu();
});

$(function () {  
    var picker1 = $('#datetimepicker1').datetimepicker({  
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        todayBtn:  1,
        autoclose: 1
    });  
    var picker2 = $('#datetimepicker2').datetimepicker({ 
        minView: "month",
        language:  'zh-CN',
        format: 'yyyy-mm-dd',
        todayBtn:  1,
        autoclose: 1
    });
});

var echart = echarts.init(document.getElementById('chart'));

var datetime = new Array();
var info = new Array();
var partname = new Array();
$.ajax({
    type : "post",
    url : "/recommend/getPartAndModule",
    dataType:"json",
    success : function(data){
        for(var i = 0;i < data.data.part.length;i++){
            partname[i] = data.data.part[i].name;
        }
    }
});
for(var i = 0;i < partname.length;i++){
    info[i] = {
        name : partname[i],
        type : 'line',
        data : new Array()
    };
}
option = {
    title:{
        text: '各板块流量',
        left: 'center'
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            animation: false
        }
    },
    legend: {
        data: partname,
        left: 'left'
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
     yAxis : [
        {
             type: 'value'
        },
    ],
    series: info
};

function handleDate() {
    var timestampone = Date.parse(new Date(document.getElementById("text1").value + " 00:00:00"));
    var timestamptwo = Date.parse(new Date(document.getElementById("text2").value + " 00:00:00"));
    if(document.getElementById("text1").value == "" || document.getElementById("text2").value == ""){
        layer.msg("开始日期或结束日期不能为空");
    }else if (timestampone >= timestamptwo){
        layer.msg("结束日期不能早于开始日期");
    }else {
        setData();
    }
}

function setData() {
    var timestamp1 = Date.parse(new Date(document.getElementById("text1").value + " 00:00:00"));
    var timestamp2 = Date.parse(new Date(document.getElementById("text2").value + " 00:00:00"));
    var count = (timestamp2 - timestamp1) / 86400000;
    for(var i = 0;i < count;i++){
        var timestamp = timestamp1 + (i * 86400000);
        var date = new Date();
        date.setTime(timestamp);
        var str = (date.getMonth() + 1) + "." + date.getDate();
        datetime[i] = str;
    }
    var startTime = timestamp1 / 1000;
    var endTime = timestamp2 / 1000;
    $.ajax({
        type : "post",
        url : "/performance/part",
        dataType:"json",
        data : {
            "startTime" : startTime,
            "endTime" : endTime
        },
        success : function(datainfo){
            if(datainfo.state == 1){
                for(var i = 0;i < datainfo.data.part.length;i++){
                    partname[i] = datainfo.data.part[i].name;
                    for(var n = 0;n < partname.length;n++){
                        if (datainfo.data.part[i].name == partname[n]){
                            // console.log(info[i]["data"]);
                            // info[i].data = datainfo.data["颜值"];
                            info[i] = {
                                name : partname[n],
                                type : 'line',
                                data : datainfo.data[partname[n]]
                            };
                        }
                    }
                }
                echart.setOption({
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: {
                            animation: false
                        }
                    },
                    legend: {
                        data: partname,
                        left: 'left'
                    },
                    series: info,
                    xAxis : [
                        {
                            type : 'category',
                            data : datetime,
                            axisTick: {
                                alignWithLabel: true
                            }
                        }
                    ],
                });
            }
        }
    });
}
echart.setOption(option);