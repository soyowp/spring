<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글 작성하기</h1>
<form action="/board/register" method="post"> 
글제목<input type="text" name="title"/> <br/>
글내용<textarea rows="10" name="content"></textarea> <br/>
글쓴이<input type="text" name="writer"/> <br/>
<input type="submit" value="글 등록하기"/>
</form>


</body>
</html>