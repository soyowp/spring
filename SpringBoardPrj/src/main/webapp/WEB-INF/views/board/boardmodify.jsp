<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글 수정하기</h1>
		글번호 : ${param.bno }
		페이지 : ${param.page }
		키워드 : ${param.keyword }
	<form action="/board/modify" method="post">
		글번호<input type="text" name="bno" value="${vo.bno }" readonly="readonly" /><br />
		글제목<input type="text" name="title" value="${vo.title }" /><br />
		글내용<textarea rows="10" cols="50" name="content">${vo.content }</textarea><br />
		<input type="text" name="writer" value="${vo.writer }" readonly="readonly" /><br />
		
		<input type="hidden" name="bno" value="${detail.bno }">
		<input type="hidden" name="page" value="${param.page }">
		<input type="hidden" name="keyword" value="${param.keyword }">
		<input type="submit" value="수정하기">
	</form>
</body>
</html>