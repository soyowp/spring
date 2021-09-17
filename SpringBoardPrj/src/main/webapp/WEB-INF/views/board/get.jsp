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
	<h1>상세페이지</h1>
	글 번호 : ${detail.bno}
	<br /> 글 제목 : ${detail.title }
	<br /> 글 내용 : ${detail.content }
	<br /> 글쓴이 : ${detail.writer }
	<br /> 쓴날짜 : ${detail.regdate } / 최종수정일 : ${detail.updatedate }
	<br />
	<a href="/board/list"><button>목록으로 돌아가기</button></a>
	<form action="/board/remove" method="post">
		<input type="hidden" name="bno" value=${detail.bno }> <input
			type="submit" value="글 삭제">
	</form>
	<form action="/board/boardmodify" method="post">
		<input type="hidden" name="bno" value=${detail.bno }>
		<input type="submit" value="글 수정">
	</form>
</body>
</html>