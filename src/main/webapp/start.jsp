<%--
  ~ 版权所有 (c) 2015 。 李倍存 （iPso）。
  ~ 所有者对该文件所包含的代码的正确性、执行效率等任何方面不作任何保证。
  ~ 所有个人和组织均可不受约束地将该文件所包含的代码用于非商业用途。若需要将其用于商业软件的开发，请首先联系所有者以取得许可。
  --%>

<%--
  Created by IntelliJ IDEA.
  User: lbc
  Date: 2015/11/2
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title></title>
    <style>

        .bar1 {
            fill: orange;
        }
        .bar2 {
            fill: green;
        }
        .bar3 {
            fill: pink;
        }
        .bar1:hover {
            fill: black;
        }
        .bar2:hover {
            fill: black;
        }
        .bar3:hover {
            fill: black;
        }
        .me{
            fill:red;
            background-color: red;
        }
        .axis {
            font: 10px sans-serif;
        }

        .axis path,
        .axis line {
            fill: none;
            stroke: #000;
            shape-rendering: crispEdges;
        }

        .x.axis path {
            display: none;
        }
        .text{
            background-color: blue;
        }
    </style>
</head>
<body>
    <script src="resource/js/json2.js" type="text/javascript"></script>
    <script src="resource/js/prototype-1.6.0.3.js" type="text/javascript"></script>
    <script src="resource/js/ipso-common.js" type="text/javascript"></script>
    <script src="resource/js/d3.min.js" type="text/javascript"></script>
<body>


<div id="statics"  style="left: 0%;top: 0%;width: 50%;height: 100%;position: absolute;z-index: 1"></div>
<div id="show-weekly-summary-info" style="left: 55%;top: 0%;width: 45%;height: 100%;position: absolute;z-index: 1">
    <shiro:guest>
        <h1 style="width: 100%;text-align: center">请登录以便为您显示摘要信息。</h1>
    </shiro:guest>
</div>

</body>
<shiro:user>
    <script type="text/javascript">
        function getName(name1,name2){
            if (name1.match(name2)){
                return "【我】";
            }
            return name1;
        }
        function getCss(name1,name2,css){
            if (name1.match(name2)){
                return "me";
            }
            return css;
        }
    </script>
</shiro:user>
<shiro:guest>
    <script type="text/javascript">
        function getName(name1,name2){
            return name1;
        }
        function getCss(name1,name2,css){
            return css;
        }
    </script>
</shiro:guest>
<script type="text/javascript">
    function processUpdateStatics(response){
        var res = JSON.parse(response.responseText);
        var ofAll = res["summariesOfAll"];
        var namesOfAll = [];
        for (var i = 0;i<ofAll.length;i++){
            namesOfAll[i] = ofAll[i]["name"];
        }
        var classes = {"2013":"bar1","2014":"bar2","2015":"bar3","博士":"bar3"};
        var width = "100%";
        var margin = {top: 20, right: 20, bottom: 30, left: 40};
        var height = 225*10;
        var barHeight = 16;
        var barSpace = 2;

        var x = d3.scale.linear()
                .range([0, width]);
        var y = d3.scale.ordinal();
        var xAxis = d3.svg.axis()
                .scale(x)
                .orient("top");
        var yAxis = d3.svg.axis()
                .scale(y)
                .orient("left");
        var svg = d3.select("div").append("svg")
                        .attr("width", width )
                        .attr("height", height)
                        .append("g")
                ;

        y.domain([1, ofAll.length]).range(namesOfAll);
        x.domain([0, d3.max(ofAll, function(d){
            return d["totalTime"];
        })]);

        var entity = svg.append("g")
                        .attr("class", "y axis")
                        .call(yAxis)
                        .attr("y",margin.top)
                        .attr("x",margin.left)
                        .text("姓名")
                ;
        svg.append("g")
                .attr("class", "x axis")
                .attr("x",margin.left)
                .attr("y",margin.top)
                .call(xAxis);
        svg.selectAll("svg")
                .data(ofAll)
                .enter().append("rect")
                .attr("class",function(d){
                    var css = classes[d["grade"]];
                    return getCss(d["name"],res["name"],css);
                })
                .attr("width", function(d) {
                    return x(d["totalTime"] - margin.left);
                })
                .attr("height", barHeight)
                .attr("x",margin.left)
                .attr("y", function(d, i){
                    var y = i*(barHeight + barSpace);
                    var name = d["name"];
                    name = getName(d["name"],res["name"]);
                    entity.append("text").attr("style","color:red;").attr("x",0).attr("y",y+12).text(name);
                    return y;
                })
                .on("mouseover",function(d, i){
                    d3.select(this).append("title")
                            .text(d["name"] + ""+d["totalTime"]+"分钟")
                            .style("background-color","0072c6")
                            .style("color","#ffffff");
                })
        ;
    }
    var url2 = '/resse-1.1/ajax_use_json/showWeeklySummaryInfoStatics.action';
    var myAjax = new Ajax.Request(url2,
            {
                method: 'post',
                parameters: [],
                onComplete: processUpdateStatics,
                asynchronous: true
            });
</script>
<shiro:user>
    <script type="text/javascript">
        function processUpdate(request) {
            var res = JSON.parse(request.responseText);
            iPsoCommon.updateTable(res["lessonRecords"],"lesson-records","课程登记记录",["姓名","分钟数","迟到次数","更新时间"],["name","minutesToAdd","lateTimesToSubtract","updateTime"],4,"show-weekly-summary-info","100%");
            var t = [res["summary"]];
            iPsoCommon.updateTable(t,"summary","周汇总",["姓名","刷脸时间","完成度","迟到次数","刷脸次数"],["name","totalTime","percentage","lateCount","checkoutCount"],5,"show-weekly-summary-info","100%");
            iPsoCommon.updateTable(res["cardTimeRecords"],"card-time-records","刷脸记录",["姓名","刷脸时间"],["name","cardTime"],2,"show-weekly-summary-info","100%");
            iPsoCommon.updateTable(res["dayOffRecords"],"day-off-records","请假登记",["姓名","开始时间","结束时间","理由"],["name","startTime","endTime","reason"],4,"show-weekly-summary-info","100%");
            iPsoCommon.updateTable(res["businessTripRecords"],"business-trip-records","出差登记",["姓名","开始时间","结束时间"],["name","startTime","endTime"],3,"show-weekly-summary-info","100%");
        }
        var url1 = '/resse-1.1/ajax_use_json/showWeeklySummaryInfo.action';
        var myAjax = new Ajax.Request(url1,
                {
                    method: 'post',
                    parameters: [],
                    onComplete: processUpdate,
                    asynchronous: true
                });
    </script>
</shiro:user>
</html>
