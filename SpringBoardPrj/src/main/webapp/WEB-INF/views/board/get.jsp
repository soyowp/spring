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
	<!-- list에서 넘어오는 파라미터 확인 디버깅
	get.jsp에서 바로 받아오도록 만들어주기 -->
	<br/>
	글번호 : ${param.bno }<br>
	페이지 : ${param.page }<br>
	검색어 : ${param.keyword }<br>
	<a href="/board/list?bno=${param.bno}&page=${param.page}&keyword=${param.keyword}"><button>목록으로 돌아가기</button></a>
	<form action="/board/remove" method="post">
		<input type="hidden" name="bno" value=${detail.bno }>
		<input type="hidden" name="bno" value="${detail.bno }">
		<input type="hidden" name="page" value="${param.page }">
		<input type="hidden" name="keyword" value="${param.keyword }">
		<input type="submit" value="글 삭제">
	</form>
	<form action="/board/boardmodify" method="post">
		<input type="hidden" name="bno" value=${detail.bno }>
		<input type="hidden" name="bno" value="${detail.bno }">
		<input type="hidden" name="page" value="${param.page }">
		<input type="hidden" name="keyword" value="${param.keyword }">
		<input type="submit" value="글 수정">
	</form>
</body>
</html>