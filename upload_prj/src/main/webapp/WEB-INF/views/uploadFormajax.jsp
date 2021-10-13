<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
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
			
				alert("uploaded");
				
			}
		});
	});
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
	<button id="uploadBtnajax">Upload</button>
</body>
</html>