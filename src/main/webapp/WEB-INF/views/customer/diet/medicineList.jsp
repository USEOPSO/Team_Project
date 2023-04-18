<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>의약품정보</title>

<!-- css -->
<link rel = "stylesheet" href = "${path}/resources/css/bootstrap.min.css">
<link rel = "stylesheet" href = "${path}/resources/css/style4.css">
<link rel = "stylesheet" href = "${path}/resources/css/jquery.mCustomScrollbar.min.css">

<!-- js -->
<link rel = "stylesheet" href = "${path}/resources/js/bootstrap.min.js">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#searchResult tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

</script>

<style>
.paging a{
	font-size:20px;
	padding:5px;
}
</style>

</head>
<body>
<div class="wrapper">
	<!-- laftbar start -->
	<%@include file = "/WEB-INF/views/common/leftbar.jsp" %>
	<!-- laftbar end -->
	
	<!-- Page Content  -->
    <div id="content">
	        
		<!-- header start -->
		<%@include file = "/WEB-INF/views/common/header.jsp" %>
		<!-- header end -->
		
		<!-- 의약품정보 시작 -->
		<div class="jumbotron">
			<div class="container">
				<h4 class="display-4">의약품정보</h4>
			</div>
		</div>
	
		<div class="container">
			<div class="row">
				<table width="100%">
					<tr>
						<td align="left">
							<div class="input-group sm-3">
							  <input type="text" id="myInput" placeholder="Search..." width="200px">
							  <div class="input-group-append">
								<input type="button" name="button" id="search" class="btn btn-primary" value="검색">
							  	<hr>
							  </div>
							</div>
						</td>
						<td align="right" style="width:800px;">
						</td>
					</tr>
				</table>

				
			   <!-- 테이블 내용 시작 -->      
	           <table class="table table-hover">
	                 <tr class="info">
	                    <th class="text-center" width="5%">번호</th>
	                    <th class="text-center" width="25%">사진</th>
	                    <th class="text-center" width="15%">이름</th>
	                    <th class="text-center" width="55%">설명</th>	                 
	                 </tr>			
				</table>  
				
				<!-- 검색 목록을 출력할 영역 -->
				<div id="searchResult">
	          		<table class="table table-hover">   
						<c:forEach var="medicine" items="${mlist}">
							<c:if test="${mlist.isEmpty()}">
								<h2>항목이 존재하지 않습니다.</h2>
							</c:if>
							
							<c:if test="${!mlist.isEmpty()}">
							<tr>
								<td align="center">${medicine.medicineNo}</td>			
								<td align="center"><img src="${medicine.img}" id="img"></td>					
								<td align="center">${medicine.name}</td>
								<td align="center">${medicine.content1}</td>
							</tr>
							</c:if>
						</c:forEach>
					</table>
				</div>				
				<!-- 테이블 내용 끝 -->				
			</div>		

			<hr class="featurette-divider">				
		</div>
		<!-- footer start -->	
		<%@include file = "/WEB-INF/views/common/footer.jsp" %>
		<!-- footer end -->	
	 </div>
</div>
</body>
</html>