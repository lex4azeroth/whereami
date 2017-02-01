<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setAttribute("home", path);
%>
<!doctype html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/bmap.css"/>
<script type="text/javascript">
function showMap() {
var map = new BMap.Map("container",{mapType: BMAP_NORMAL_MAP});      //设置卫星图为底图
var point = new BMap.Point(121.48,31.22);    // 创建点坐标
map.centerAndZoom(point,12);                     // 初始化地图,设置中心点坐标和地图级别。

//map.addControl(new BMap.MapTypeControl());
map.addControl(new BMap.NavigationControl());
map.enableScrollWheelZoom();                  // 启用滚轮放大缩小。
//map.enableKeyboard();                         // 启用键盘操作。  
//map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
var marker = new BMap.Marker(point);
	map.addOverlay(marker);               // 将标注添加到地图中
	marker.setAnimation(BMAP_ANIMATION_BOUNCE); //跳动的动画
map.addOverlay(marker); 
}

function postData() {
    alert("${home}");
    
    var jsondata = 
        [
            {"androidID":"7bbd793805f2ba1d","date":"2016-12-29 09:12:51","latitude":"31.216138333333333","longitude":"121.49172166666668"},
            {"androidID":"7bbd793805f2ba1d","date":"2016-12-29 09:12:48","latitude":"31.216138333333333","longitude":"121.49172166666668"},
            {"androidID":"7bbd793805f2ba1d","date":"2016-12-29 09:12:46","latitude":"31.216138333333333","longitude":"121.49172166666668"},
            {"androidID":"7bbd793805f2ba1d","date":"2016-12-29 09:12:44","latitude":"31.216138333333333","longitude":"121.49172166666668"}]
    ;

    var jsondata2 = {

        "androidID":"7bbd793805f2ba1d",
        "date":"2016-12-29 09:12:51",
        "latitude":"31.216138333333333",
        "longitude":"121.49172166666668"
        
    }

    alert(jsondata2)
    $.ajax({
		type: "POST",
		url: "mylocation",
        data:JSON.stringify(jsondata),
		async: true,
		contentType: "application/json",
        cache:false,
		success: function(data) {
			alert(data);
		}
	});
}
</script>
<title>PostLocationTester</title>
</head>
<body>
    
    <button onclick="postData()">Post</button>
    <p/>
    <button onclick="showMap()">ShowMap</button>
    <div style="width:1000px;height:500px;border:1px solid gray" id="container"></div>

<!-- jQuery 2.2.0 -->
<!--<script type="text/javascript" src='<c:url value="/WEB-INF/plugins/jQuery/jQuery-2.2.0.min.js"></c:url>'></script>-->
<script type="text/javascript" src="${home}/js/jQuery-2.2.0.min.js"></script>
<script type="text/javascript" src="${home}/js/json2.js"></script>
<script type="text/javascript" src="${home}/js/apiv1.3.min.js"></script>
<!--<script type="text/javascript" src='<c:url value="/plugins/jQuery/jQuery-2.2.0.min.js"></c:url>'></script>-->
<!--<script type="text/javascript" src='<c:url value="/js/jQuery-2.2.0.min.js"></c:url>'></script>-->

</body>
</html>