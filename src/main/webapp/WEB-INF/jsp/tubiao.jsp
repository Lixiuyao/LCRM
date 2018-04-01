<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../common/header.jsp"%>
<!DOCTYPE html>
<html>
    <head>
         <meta charset="utf-8" />
         <title></title>
          <!-- 引入 echarts.js -->
         <script type="text/javascript" src="${ctx}/static/lib/Echarts/echarts.js" ></script>
    </head>
    <body>
          <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
     <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript" src="${ctx}/static/lib/Echarts/echarts.js"></script>
    <script type="text/javascript">
       $(function() {
            // 基于准备好的dom，初始化echarts实例
           var myChart = echarts.init(document.getElementById('main'));
           $.ajax({
               url : '${ctx}/customerGx/getCountUser.action',
               type : 'POST',
               dataType : 'json',
               success : function(jsonObj) {
                  if(jsonObj.code == util.SUCCESS) {
                      var data = jsonObj.data;
                      var xArrayData = new Array();//x轴放分类的name
                      var yArrayData = new Array();//y轴放分类的count
                      for(var i = 0; i < data.length; i++) {
                          xArrayData.push(data[i].level);
                          yArrayData.push(data[i].count);
                      }
                      // 指定图表的配置项和数据
                       var option = {
                           title: {
                               text: '客户构成分类'
                           },
                           tooltip: {},
                           legend: {
                               data:['销量']
                           },
                           xAxis: {
                               data: xArrayData
                           },
                           yAxis: {},
                           series: [{
                               name: '销量',
                               type: 'bar',
                               data: yArrayData
                           }]
                       };
                       // 使用刚指定的配置项和数据显示图表。
                       myChart.setOption(option);
                  }
               }
           });
       });
    </script>
    </body>
</html>