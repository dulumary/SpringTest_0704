<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>


<body>

	<div class="container">
		<h1>즐겨 찾기 추가하기</h1>
		<label>제목</label>
		<input type="text" class="form-control" id="nameInput">
		<label class="mt-3">주소</label>
		
		<div class="d-flex">
			<input type="text" class="form-control" id="urlInput">
			<button type="button" class="btn btn-success" id="duplicateBtn">중복확인</button>
		</div>
		<div class="small text-success d-none" id="availableUrlText">저장 가능한 url 입니다.</div>
		<div class="small text-danger d-none" id="duplicateUrlText">중복된 url 입니다.</div>
		
		<button type="button" id="addBtn" class="btn btn-success btn-block mt-3">추가</button>
	</div>
	
	 <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	 
	 <script>
	 
	 	$(document).ready(function() {
	 		
	 		var checkedDuplicate = false;
	 		var isDuplicateUrl = true;
	 		
	 		$("#urlInput").on("input", function() {
	 			// 중복확인과 관련된 모든 처리를 초기화 
	 			checkedDuplicate = false;
	 			isDuplicateUrl = true;
	 			
	 			$("#availableUrlText").addClass("d-none");
	 			$("#duplicateUrlText").addClass("d-none");
	 			
	 		});
	 		
	 		$("#duplicateBtn").on("click", function() {
	 			let url = $("#urlInput").val();
	 			
	 			if(url == "") {
	 				alert("url을 입력하세요");
	 				return ;
	 			}
	 			
	 			// http:// 시작하지 않고,  https:// 시작하지 않으면
	 			if(!url.startsWith("http://") && !url.startsWith("https://")) {
	 				alert("주소형식을 확인해 주세요");
	 				return ;
	 			}
	 			
	 			
	 			$.ajax({
	 				type:"post"
	 				, url:"/ajax/favorite/url_confirm"
	 				, data:{"url":url}
	 				, success:function(data) {
	 					checkedDuplicate = true;
	 					// 중복됨 : {"isDuplicate":true}
	 					// 중복되지 않음 : {"isDuplicate":false}
	 					if(data.isDuplicate) {
	 						isDuplicateUrl = true;
	 						$("#duplicateUrlText").removeClass("d-none");
	 						$("#availableUrlText").addClass("d-none");
	 					} else {
	 						isDuplicateUrl = false;
	 						$("#availableUrlText").removeClass("d-none");
	 						$("#duplicateUrlText").addClass("d-none");
	 					}
	 				
	 				
	 				}
	 				, error:function() {
	 					alert("중복확인 에러");
	 				}
	 			});
	 			
	 			
	 		});
	 		
	 		$("#addBtn").on("click", function() {
	 			// 입력한 내용을 기반으로 add API로 데이터 저장
	 			let name = $("#nameInput").val();
	 			let url = $("#urlInput").val();
	 			
	 			if(name == "") {
	 				alert("이름을 입력하세요");
	 				return;
	 			}
	 			
	 			if(url == "") {
	 				alert("url을 입력하세요");
	 				return ;
	 			}
	 			
	 			// http:// 시작하지 않고,  https:// 시작하지 않으면
	 			if(!url.startsWith("http://") && !url.startsWith("https://")) {
	 				alert("주소형식을 확인해 주세요");
	 				return ;
	 			}
	 			
	 			// 중복체크 안 한경우 
	 			if(checkedDuplicate == false) {
	 				alert("url 중복확인을 하세요");
	 				return ;
	 			}
	 			
	 			// 중복된 경우 
	 			if(isDuplicateUrl) {
	 				alert("url이 중복되었습니다.");
	 				return ;
	 			}
	 			
	 			
	 			
	 			$.ajax({
	 				type:"post"
	 				, url:"/ajax/favorite/add"
	 				, data:{"name":name, "url":url}
	 				, success:function(data) {
	 					// 성공 : {"result":"success"}
	 					// 실패 : {"result":"fail"}
	 					if(data.result == "success") {
	 						// 리스트 페이지 이동
	 						location.href = "/ajax/favorite/list";
	 					} else {
	 						alert("추가 실패!");
	 					}
	 					
	 				}
	 				, error:function() {
	 					alert("추가 에러!!");
	 				}
	 			});
	 			
	 			
	 			
	 			
	 			
	 			
	 		});
	 		
	 		
	 	});
	 	
	 
	 </script>
</body>
</html>