<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	일반 컨트롤러
	<form action="uploadFormAction" method="post"
	enctype="multipart/form-data">
	<input type="file" name="uploadFile" multiple>
	<button id="uploadBtn">Submit</button>
	</form>
	
</body>
</html>