<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		let bno = 29652;

		function getAllList() {
			$
					.getJSON(
							"/replies/all/" + bno,
							function(data) {
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

	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Ajax 테스트</h2>

	<div>
		REPLYER<input type="text" name="replyer" id="newReplyWriter">
	</div>
	<div>
		REPLY<input type="text" name="reply" id="newReply">
	</div>
	<button id="replyAddBtn">ADD REPLY</button>

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