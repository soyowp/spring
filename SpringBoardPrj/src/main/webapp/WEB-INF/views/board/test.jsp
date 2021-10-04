<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script>
		window.onload = function() {
			let bno = 29652;

			$getJSON("/replies/all/" + bno, function(data){
				console.log(data.length);
				
				var str = "";

				str = "<li>replis</li>";

				$('#replies').html(str);
				
			});

			//위와같이 함수를 변수에 저장하면
			// 호출구문을 한 번 더 써줘야 실행됩니다.
		}
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Ajax 테스트</h2>
	
	<ul id = "replies">
	
	</ul>


</body>
</html>