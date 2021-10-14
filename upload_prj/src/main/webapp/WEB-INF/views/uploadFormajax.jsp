<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.uploadResult{
width:100%;
background-color: gray; 
}
.uploadResult ul{
display:flex;;
flex-flow:row;
justify-content: center;
align-items:center;
}
.uploadResult ul li{
list-style: none;
padding:10px;
}
.uploadResult ul li img{
width:20px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script>
$(document).ready(function(){
	
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	let maxSize = 5242880;
	
	function checkExtension(fileName, fileSize){
		
	if(fileSize >= maxSize){
		alert("파일 사이즈 초과");
		return false;
	}
	
	if(regex.test(fileName)){
		alert("업로드가 불가한 형식의 확장자입니다.");
		return false;
	}
	return true;
}
	let cloneObj = $(".uploadDiv").clone();
	
		$('#uploadBtnajax').on("click", function(e){
			let formData = new FormData();
			let inputFile = $("input[name='uploadFileajax']");
			console.log(inputFile)
			let files = inputFile[0].files;
			console.log(files);
			
			for(let i=0; i< files.length; i++){
				if(!checkExtension(files[i].name, files[i].size)){
					return false;
				}
				
			formData.append("uploadFile", files[i]);
			
			}
		$.ajax({
			url: '/uploadAjaxAction',
			processData: false,
			contentType: false,
			data : formData,
			type: 'POST',
			success : function(result){
				
				console.log(result);
				
				showUploadedFile(result);
				
				$(".uploadDiv").html(cloneObj.html());
				
			}
		});
		
		$(".uploadResult").on("click", "span", function(e){
			
			let targetFile = $(this).data("file") ;
			let type = $(this).data("type");
			let targetLi = $(this).closest("li");
			
			$.ajax({
				url: '/deleteFile',
				data: {fileName: targetFile, type:type},
				dataType : 'text',
				type:'POST',
				success: function(result){
					alert(result);
					targetLi.remove();
				}
			
			});
		});
	});
		
		let uploadResult = $(".uploadResult ul");
		
		function showUploadedFile(uploadResultArr){
			let str="";
			
			$(uploadResultArr).each(function(i, obj){
				
				if(!obj.image){
					str += "<li><img src='/resources/attach.jpg'>"
						+ obj.fileName +"</li>";
				} else{
				//str += "<li>" + obj.fileName + "</li>";
				let fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
				str += "<li><a href='/download?fileName="+fileCallPath+"'>"+"<img src='/display?fileName="+fileCallPath+"'>"
						+"<img src='/resources/attachicon.png'>"+"obj.fileName"+"</a>"
						+"<span data-file=\'"+fileCallPath + "\' data-type='image'> X <\span>"
						+"</li>";
				}
			});
			uploadResult.append(str);
		}
		
});
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	AJAX컨트롤러
	<div class="uploadDiv">
	<input type="file" name="uploadFileajax" multiple>
	</div>
	<div class="uploadResult">
	<ul>
	<!-- 업로드파일 자리 -->
	</ul>
	</div>
	<button id="uploadBtnajax">Upload</button>
</body>
</html>