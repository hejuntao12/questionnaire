$.ajax({
    url: '/score',
    type: 'get',
    data: {
        "username": getQueryString("username")
    },
    success: function (res) {
        var scoreJson = JSON.parse(res);
        loadChart1(scoreJson.anxious);
        loadChart2(scoreJson.depressed);
    }
});

function loadChart1(scoreJson){
    var xData = new Array(scoreJson.length);
    var scoreData = new Array(scoreJson.length);
    for(i = 0; i < scoreJson.length; i++){
        xData[i] = scoreJson[i].ord;
        scoreData[i] = scoreJson[i].score;
    }

    var dom = document.getElementById("container1");
    var myChart = echarts.init(dom);
    var app = {};
    app.title = '测试结果-折线图';
    option = {
        title: {
            text: '“总体焦虑水平及干扰程度”进展记录图',
            x:'center',
            y: 'bottom'
        },
        xAxis: {
            name : '周',
            type: 'category',
            data: xData
        },
        yAxis: {
            name : '总体焦虑水平及\n\n干扰程度量表得分',
            nameTextStyle:{
                align: 'left',
            },
            type: 'value',
            max: '20'
        },
        series: [{
            data: scoreData,
            type: 'line',
            itemStyle: {
                normal: {
                    label:{
                        show: true
                    }
                }
            }
        }]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
    window.onresize = function () {
        myChart.resize(); //使第一个图表适应
    }
}

function loadChart2(scoreJson){
    var xData = new Array(scoreJson.length);
    var scoreData = new Array(scoreJson.length);
    for(i = 0; i < scoreJson.length; i++){
        xData[i] = scoreJson[i].ord;
        scoreData[i] = scoreJson[i].score;
    }

    var dom = document.getElementById("container2");
    var myChart = echarts.init(dom);
    var app = {};
    app.title = '测试结果-折线图';
    option = {
        title: {
            text: '“总体抑郁水平及干扰程度”进展记录图',
            x:'center',
            y: 'bottom'
        },
        xAxis: {
            name : '周',
            type: 'category',
            data: xData
        },
        yAxis: {
            name : '总体抑郁水平及\n\n干扰程度量表得分',
            nameTextStyle:{
                align: 'left',
            },
            type: 'value',
            max: '20'
        },
        series: [{
            data: scoreData,
            type: 'line',
            itemStyle: {
                normal: {
                    label:{
                        show: true
                    }
                }
            }
        }]
    };
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
    window.onresize = function () {
        myChart.resize(); //使第一个图表适应
    }
}