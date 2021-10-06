<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
#modDiv {
	width: 300px;
	height: 100px;
	background-color: green;
	position: absolute;
	top: 50%;
	left: 50%;
	margin-TOP: -50px;
	margin-left: -150px;
	padding: 10px;
	z-index: 1000;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	window.onload = function() {

		let bno = ${detail.bno};

		function getAllList() {$.getJSON("/replies/all/" + bno,	function(data) {
								console.log(data.length)

								let str = "";

								//str = "<li>여기다가 리플 받아옵시다</li>";

								$(data)
										.each(
												function() {
													str += "<li data-rno='" + this.rno + "' class='replyLi'>"
															+ this.rno
															+ ":"
															+ this.reply
															+ "<button>수정/삭제</button></li>";
												});

								$('#replies').html(str);
							});

		}
	getAllList();
	
	$("#replyAddBtn").on("click", function() {
		let replyer = $("#newReplyWriter").val();
		let reply = $("#newReply").val();

		$.ajax({
			type : 'post',
			url : '/replies/',
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},

			dataType : 'text',
			data : JSON.stringify({
				bno : bno,
				replyer : replyer,
				reply : reply
			}),
			success : function(result) {
				if (result === 'SUCCESS') {
					alert("등록되었습니다.");
					//댓글 등록 후 새로 동작
					getAllList();
				}
			}
		});
	});

	// 이벤트 위임
	// 내가 현재 이벤트를 걸려는 집단 (button)을 포함하면서 범위가 제일 좁은 #replies를 시작조건으로 지정
	// .on("click", "목적지 태그까지 요소들", fuction(){실행문})
	// 위와 같이 위임시는 파라미터가 3개 요구
	$("#replies").on("click", ".replyLi button", function() {
		let reply = $(this).parent();// 여기 이미 같은이름으로 선언되어서 그렇습니다

		let rno = reply.attr("data-rno");
		reply = reply.text(); //html내부 글씨만 얻기 방금 변수명이 replys여서 일치하지 않아 안떳스빈다. let으로 하니까 오류가 나가지구요

		$(".modal-title").html(rno);
		$("#replytext").val(reply);
		$("#modDiv").show("slow");
	})
	//삭제로직
	$("#replyDelBtn").on("click", function() {
		let rno = $(".modal-title").html();

		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			success : function(result) {
				if (result === 'SUCCESS') {
					alert(rno + "번 댓글이 삭제되었습니다.");
					$("#modDiv").hide("slow");
					getAllList();
				}
			}
		});
	});

	//수정로직
	$("#replyModBtn").on("click", function() {
		let rno = $(".modal-title").html();
		let reply = $("#replytext").val();

		$.ajax({
			type : 'patch',
			url : '/replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PATCH"
			},
			dataType : 'text',
			data : JSON.stringify({
				reply : reply
			}),
			success : function(result) {
				if (result == 'SUCCESS') {
					alert(rno + "번 댓글이 수정되었습니다.");
					$("#modDiv").hide("slow");
					getAllList();
				}
			}
		})
	});
}
</script>
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
	<br /> 글번호 : ${param.bno }
	<br> 페이지 : ${param.page }
	<br> 검색어 : ${param.keyword }
	<br>
	<a
		href="/board/list?bno=${param.bno}&page=${param.page}&keyword=${param.keyword}"><button>목록으로
			돌아가기</button></a>
	<form action="/board/remove" method="post">
		<input type="hidden" name="bno" value=${detail.bno }> <input
			type="hidden" name="bno" value="${detail.bno }"> <input
			type="hidden" name="page" value="${param.page }"> <input
			type="hidden" name="keyword" value="${param.keyword }"> <input
			type="submit" value="글 삭제">
	</form>
	<form action="/board/boardmodify" method="post">
		<input type="hidden" name="bno" value=${detail.bno }> <input
			type="hidden" name="bno" value="${detail.bno }"> <input
			type="hidden" name="page" value="${param.page }"> <input
			type="hidden" name="keyword" value="${param.keyword }"> <input
			type="submit" value="글 수정">
	</form>
	<hr>
	<h2>댓글</h2>
	
	<ul id="replies">
	</ul>
		<div id="modDiv" style="display: none;">
		<div class="modal-title"></div>
		<div>
			<input type="text" id="replytext">
		</div>
		<div>
			<button type="button" id="replyModBtn">Modify</button>
			<button type="button" id="replyDelBtn">Delete</button>
			<button type="button" id="closeBtn">Close</button>
		</div>
	</div>
</body>
</html>