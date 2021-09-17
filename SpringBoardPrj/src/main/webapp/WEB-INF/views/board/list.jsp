<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//컨트롤러에서 remove로직의 결과로 success로 넘어오는 자료를 확인
	var result = "${success}";
	var bno = "${bno}";
	if (result === "success") {
		alert(bno + "번 글이 삭제되었습니다.");
	}
	console.log(result);
</script>
<style>
body {
	margin: 10px;
}

a {
	text-decoration: none;
	color: orange;
}
</style>

</head>
<body>
	<div class="container">
		<header>
			<div class="row"></div>

		</header>

		<main>
			<figure class="text-center">
				<blockquote class="blockquote">
					<h1>게시판</h1>
				</blockquote>
				<figcaption class="blockquote-footer">
					<cite title="Source Title">자 이제 서로 죽여라</cite>
				</figcaption>
			</figure>

			<div class="row">
				<div class="col-sm-12">
					<table class="table table-light table-hover">
						<tr>
							<td>글 번호</td>
							<td>글 제목</td>
							<td>작성자</td>
							<td>작성일</td>
						</tr>
						<c:forEach var="boardl" items="${list }">
							<tr>
								<td>${boardl.bno }</td>
								<td><a href="/board/get?bno=${boardl.bno}">${boardl.title }</a></td>
								<td>${boardl.writer }</td>
								<td>${boardl.regdate}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			
				<a href="/board/register"><button>글쓰기</button></a>
			
				<form action="/board/list" method="get">
				<input type="text"
				name="keyword"
				placeholder="검색어입력"
				value="${keyword }">							
				<input type="submit" value="검색">
				</form>
				
				
				</div>

		</main>
		<footer>
			<div class="row"></div>
		</footer>
	</div>
</body>
</html>