$(function() {
    $('#side-menu').metisMenu();
})


var echart1 = echarts.init(document.getElementById('chart1'));

var datainfo = [];

function getTime(){
	var date = new Date();
	var month, day, hour, mintue, second;
	if (date.getMonth() < 10) {
		month = "0" + date.getMonth();
	}else{
		month = date.getMonth();
	}

	if (date.getDate() < 10) {
		day = "0" + date.getDate();
	}else{
		day = date.getDate();
	}

	if (date.getHours() < 10) {
		hour = "0" + date.getHours();
	}else{
		hour = date.getHours();
	}

	if (date.getMinutes() < 10) {
		mintue = "0" + date.getMinutes();
	}else{
		mintue = date.getMinutes();
	}

	if (date.getSeconds() < 10) {
		second = "0" + date.getSeconds();
	}else{
		second = date.getSeconds();
	}

	return date.getFullYear() + "/" + month + "/" + day + " " + hour + ":" + mintue + ":" + second;
}

option = {
    title:{
        text:'实时客流量',
        left: 'center'
    },
    tooltip: {
        trigger: 'axis',
        formatter: function (params) {
            params = params[0];
            var date = new Date(params.name);
            return date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds() + '   ' + params.value[1];
        },
        axisPointer: {
            animation: false
        }
    },
    xAxis: {
        type: 'time',
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%'],
        splitLine: {
            show: false
        }
    },
    series: [{
        name: '模拟数据',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: []
    }]
};

echart1.setOption(option);


//表2
var echart2 = echarts.init(document.getElementById('chart2'));

	option = {
        title:{
            text:'人气最高的七个主播',
            left: 'center'
        },
	    color: ['#3398DB'],
	    tooltip : {
	        trigger: 'axis',
	        axisPointer : {
	            type : 'shadow'
	        }
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
	            type : 'value'
	        }
	    ],
	    series : [
	        {
	            name:'人数',
	            type:'bar',
	            barWidth: '60%',
	            data:[]
	        }
	    ]
	};

	echart2.setOption(option);


//表3
var echart3 = echarts.init(document.getElementById('chart3'));

var data1 = [];
var data2 = [];

option = {
    title:{
        text:'各个板块的客流量',
        left: 'center'
    },
    legend:{
    	left:'left',
    	data:[]
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            animation: false
        }
    },
    xAxis: {
        type: 'time',
        splitLine: {
            show: false
        }
    },
    yAxis: {
        type: 'value',
        boundaryGap: [0, '100%'],
        splitLine: {
            show: false
        }
    },
    series: [{
        name: '某某板块1',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: []
    },
    {
        name: '某某板块2',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: []
    }]
};

echart3.setOption(option);

var datainfo2 = new Array();
var dataall = new Array();

$.ajax({
    type : "post",
    url : "/overview/chartsinfo",
    dataType:"json",
    success : function(data) {
    	for(var i = 0;i < data.data.partName.length;i++){
    		dataall[i] = new Array();
		}
    }
});

setInterval(function () {

    $.ajax({
        type : "post",
        url : "/overview/chartsinfo",
        dataType:"json",
        success : function(data){
            var cache = {
                name: getTime(),
                value: [
                    getTime(),
                    data.data.population
                ]
            }
            if(datainfo.length < 61){
                datainfo.push(cache);
            }else{
                datainfo.shift();
                datainfo.push(cache);
            }
            echart1.setOption({
                series: [{
                    data: datainfo
                }]
            });

            echart2.setOption({
                xAxis : [
                    {
                        type : 'category',
                        data : data.data.anchorName,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                series : [
                    {
                        name:'人数',
                        type:'bar',
                        barWidth: '60%',
                        data:data.data.roomPopulation
                    }
                ]
            });

            for(var i = 0;i < data.data.partPopulation.length;i++){
                var cache = {
                    name: getTime(),
                    value: [
                        getTime(),
                        data.data.partPopulation[i]
                    ]
                }
                if(dataall[i].length < 61){
                    dataall[i].push(cache);
                }else{
                    dataall[i].shift();
                    dataall[i].push(cache);
                }
                datainfo2[i] = {
                    name: data.data.partName[i],
                    type: 'line',
                    showSymbol: false,
                    hoverAnimation: false,
                    data: dataall[i]
                };
            }

            echart3.setOption({
                legend:{
                    left:'left',
                    data:data.data.partName
                },
                series : datainfo2
            });
        }
    });

}, 1000);