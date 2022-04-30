<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기업 이미지 동적으로 교체하기</title>
<script>
	var imgs = new Array();
	
	imgs.push("./images/img1.jpg");
	imgs.push("./images/img2.jpg");
	imgs.push("./images/img3.jpg");
	imgs.push("./images/img4.jpg");
	
	var index = 0;
	
	window.onload = function(){
		setInterval("imageChange()", 2000);   //2초 마다 imageChange() 함수 호출
	}
	function imageChange() {
		//var currentDate = new Date();
		var img = document.getElementById("img");
		//img.src = imgs[currentDate.getSeconds()%4];
		
		img.src = imgs[index];
		index++;
		
		if(index == imgs.length) {
			index = 0;
		}		
	}
</script>
</head>
<body>
	<center>
		<h1>(주)휴먼 소프트웨어 기업 이미지 동적 교체</h1>
		<img id="img"/>
	</center>
</body>
</html>