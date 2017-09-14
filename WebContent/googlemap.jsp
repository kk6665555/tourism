<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet type="text/css" href="googlemap/css/googlemap.css">


<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

<title>Insert title here</title>
<script
    src="http://maps.googleapis.com/maps/api/js?&key=AIzaSyA6gcpi9-EnxyDjXeWzkU9DHpyB5iyEUvY"></script>
<script>

	var initialLocation;
	var taipei = new google.maps.LatLng(25.09108, 121.5598);
	var browserSupportFlag =  new Boolean();
	
	function initialize() {
	  var myOptions = {
	    zoom: 10,
	    mapTypeId: google.maps.MapTypeId.ROADMAP
	  };
	  var map = new google.maps.Map(document.getElementById("map-canvas"), myOptions);
	  
	  // Try W3C Geolocation (Preferred)
	  if(navigator.geolocation) {
	    browserSupportFlag = true;
	    navigator.geolocation.getCurrentPosition(function(position) {
	      initialLocation = new google.maps.LatLng(position.coords.latitude,position.coords.longitude); 
	      map.setCenter(initialLocation);
	  	  //圖標
		  var marker = new google.maps.Marker({
	          position:initialLocation,
	          animation: google.maps.Animation.BOUNCE
	          });

	  	  marker.setMap(map);
	      
	    }, function() {
	      handleNoGeolocation(browserSupportFlag);
	    });
	  }
	  // Browser doesn't support Geolocation
	  else {
	    browserSupportFlag = false;
	    handleNoGeolocation(browserSupportFlag);
	  }
	 
	  function handleNoGeolocation(errorFlag) {
	    if (errorFlag == true) {
	      alert("地圖定位失敗");
	    } else {
	      alert("您的瀏覽器不支援定位服務");
	    }
		initialLocation = taipei;
	    map.setCenter(initialLocation);
	  }
	
	  
	}



	function initMap() {
	  var myLatLng = {lat: -25.363, lng: 131.044};

	  var map = new google.maps.Map(document.getElementById('map-canvas'), {
	    zoom: 4,
	    center: myLatLng
	  });

	  var marker = new google.maps.Marker({
	    position: myLatLng,
	    map: map,
	    title: 'Hello World!'
	  });
	}
   
	
	
</script>
</head>
<body onload="initialize()">
		
		<div id="map-canvas">
			1111111
		</div>	  
		
		
		

		
</body>
</html>