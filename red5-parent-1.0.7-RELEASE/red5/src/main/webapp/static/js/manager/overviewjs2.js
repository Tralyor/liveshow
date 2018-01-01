$(function() {
    $('#side-menu').metisMenu();
})

var echart1 = echarts.init(document.getElementById('chart1'));

var data = [];

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
        name: '人数',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: data
    }]
};

echart1.setOption(option);

setInterval(function () {

	var cache = {
		name: getTime(),
    	value: [
        	getTime(),
        	Math.random() * 999
    	]
	}

    if(data.length < 61){
    	data.push(cache);
    }else{
    	data.shift();
    	data.push(cache);
    }

    echart1.setOption({
        series: [{
            data: data
        }]
    });
}, 1000);


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
	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	        }
	    },
	    
	    xAxis : [
	        {
	            type : 'category',
	            data : ['主播1号','主播2号','主播3号','主播4号','主播5号','主播6号','主播7号'],
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
	            data:[10, 52, 200, 334, 390, 330, 220]
	        }
	    ]
	};

	echart2.setOption(option);


//表3
var echart3 = echarts.init(document.getElementById('chart3'));

var data1 = [];
var data2 = [];

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
        text:'各个板块的客流量',
        left: 'center'
    },
    legend:{
    	left:'left',
    	data:['游戏区','颜值区']
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
        name: '游戏区',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: data
    },
    {
        name: '颜值区',
        type: 'line',
        showSymbol: false,
        hoverAnimation: false,
        data: data
    }]
};

echart3.setOption(option);

setInterval(function () {

	var cache1 = {
		name: getTime(),
    	value: [
        	getTime(),
        	Math.random() * 999
    	]
	}

	var cache2 = {
		name: getTime(),
    	value: [
        	getTime(),
        	Math.random() * 999
    	]
	}

    if(data1.length < 61){
    	data1.push(cache1);
    }else{
    	data1.shift();
    	data1.push(cache1);
    }

    if(data2.length < 61){
    	data2.push(cache2);
    }else{
    	data2.shift();
    	data2.push(cache2);
    }

    echart3.setOption({
        series: [{
            data: data1
        },
        {
            data: data2
        }]
    });
}, 1000);