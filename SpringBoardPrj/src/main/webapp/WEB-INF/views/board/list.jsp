<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">

<head>

	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous">
	</script>
	<script>
		//부트스트랩 번들 추가해야 모달 사용 가능.
		//컨트롤러에서 remove로직의 결과로 success로 넘어오는 자료를 확인
		window.onload = function () {
			var result = "${success}";
			var bno = "${bno}";
			//모달 변수 선언
			var myModal = new bootstrap.Modal(document.getElementById('myModal'),
				focus);
			//js코드가 상단에 있다보니 아래쪽 myModal부분 html이 로딩되기도 전에 먼저 찾아서 발생하는 에러입니다.
			// window.onload 설정을 해서 아래쪽 html코드가 전부 로딩되고나서 js코드가 실행되게 해주셔야 합니다.

			console.log(myModal);

			if (result === "success") {
				alert(bno + "번 글이 삭제되었습니다.");
			} else if (result === "register") {
				myModal.show();
			}
			console.log(result);
		}
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
						<c:forEach var="board" items="${list }">
							<tr>
								<td>${board.bno }</td>
								<td><a
										href="/board/get?bno=${board.bno}&page=${btnMaker.cri.pageNum}&keyword=${btnMaker.cri.keyword}&searchType=${btnMaker.cri.searchType}">${board.title}</a>
								</td>
								<td>${board.writer }</td>
								<td>${board.regdate}</td>
							</tr>
						</c:forEach>
					</table>
					${btnMaker }
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<c:if test="${btnMaker.prev }">
								<li class="page-item"><a class="page-link"
										href="/board/list?pageNum=${btnMaker.startPage - 1}">
										Previous </a></li>
							</c:if>

							<c:forEach begin="${btnMaker.startPage}" end="${btnMaker.endPage}" var="pageNum">
								<li class="page-item ${btnMaker.cri.pageNum == pageNum ? 'active' : '' }">
									<a class="page-link"
										href="/board/list?pageNum=${pageNum }&searchType=${btnMaker.cri.searchType}&keyword=${btnMaker.cri.keyword}">
										${pageNum} </a>
								</li>
							</c:forEach>

							<c:if test="${btnMaker.next }">
								<li class="page-item"><a class="page-link"
										href="/board/list?pageNum=${btnMaker.endPage + 1}">Next</a></li>
							</c:if>
						</ul>
					</nav>
				</div>

				<a href="/board/register"><button>글쓰기</button></a>


				<form action="/board/list" method="get">

					<select name="searchType">

						<option value="n" <c:out value="${cri.searchType == null ? 'selected' : '' }" />>
						-
						</option>
						<option value="t" <c:out value="${cri.searchType eq 't' ? 'selected' : '' }" />>
						제목
						</option>
						<option value="c" <c:out value="${cri.searchType eq 'c' ? 'selected' : '' }" />>
						본문
						</option>
						<option value="w" <c:out value="${cri.searchType eq 'w' ? 'selected' : '' }" />>
						글쓴이
						</option>
						<option value="tc" <c:out value="${cri.searchType eq 'tc' ? 'selected' : '' }" />selected>
						제목+본문
						</option>

					</select>
					<input type="text" name="keyword" placeholder="검색어입력" value="${btnMaker.cri.keyword }"> <button
						id="searchBtn">Search</button>
				</form>

				<!-- 모달 코드는 작성이 안 되어있는게 아니고 작성했지만 css의 display를 none으로 평상시에 두고 특정 조건을 만족했을때 display되게 설계됨 -->
				<div class="modal" id="myModal" tabindex="-1">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title">글 작성 완료</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body">
								<p>${bno }번글을작성했습니다.</p>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
							</div>
						</div>
					</div>
				</div>

			</div>

		</main>
		<footer>
			<div class="row"></div>
		</footer>
	</div>
</body>

</html>