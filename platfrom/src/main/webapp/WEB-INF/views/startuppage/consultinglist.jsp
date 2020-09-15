<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />


<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lora:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/animate.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/magnific-popup.css">
    <style>
        .table{
            margin-top: 20px;
            margin-bottom: -30px;
            text-align: center;
        }
        body > div.row.mt-5 > div > div > ul{
            margin-bottom: 150px;
        }
        #thead-c{
            background-color:#95adbe;
            
            color: white;
        }
        body > div > a{
           float : right;
        }
        .container{
         margin-bottom: 80px;
        }
        
    </style>
		<script>
	function del(no) {
		var chk = confirm("철회하시겠습니까?");
		if (chk) {
			location.href="${contextPath}/startuppage/conlist_del.do?no="+no;
			
		}
	}	
</script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="${contextPath}/resources/css/flaticon.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/style.css">
    
<title>스타트업 페이지 컨설팅 견적 현황</title>
</head>

<body>
   
   <div class="container">
   <h3>대기중인 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>제조업체명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="consulting" begin="0" end="2" items="${w_conlist}" > 
          	 
               <tr align="center">
               <td><a href="#">${consulting.expname}</a></td>
               <td><fmt:formatDate value="${consulting.reqdate}" pattern="yy-MM-dd  kk:MM"/></td>
               <td><button type="button" class="btn btn-outline-secondary" onclick="del(${consulting.no})">철회</button></td>
               <td><a href= "${contextPath}/startuppage/conupdatestatus_y.do?status=${consulting.status}&no=${consulting.no}">수락버튼</a></td>
               <td><a href= "${contextPath}/startuppage/conupdatestatus_n.do?status=${consulting.status}&no=${consulting.no}">거절버튼</a></td>
                   
          </tr>
        </c:forEach>
   </table>
 	<a href = "${contextPath}/startuppage/consulting_more_w.do">더보기</a>
</div>
   <div class="container">
   <h3>진행중인 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>전문가명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="consulting" begin="0" end="2" items="${i_conlist}" >     
               <tr align="center">
               <td>${consulting.expname}</td>
               <td><fmt:formatDate value="${consulting.reqdate}" pattern="yy-MM-dd  kk:MM"/></td>
                <td><button type="button" class="btn btn-outline-secondary" onclick="del(${consulting.no})">철회</button></td>
                <td><a href= "${contextPath}/startuppage/conupdatestatus_y.do?status=${consulting.status}&no=${consulting.no}">완료버튼</a></td>
          </tr>
        </c:forEach>   
   </table>
	<a href = "${contextPath}/startuppage/consulting_more_i.do">더보기</a>
</div>
   <div class="container">
   <h3>거절된 견적</h3>
      <table class="table">
          <thead id="thead-c">
            <tr>        
                <th>전문가명</th>
                <th>견적 신청 날짜</th>
                <th></th>
            </tr>
          </thead>

       <tbody>
          <c:forEach var="consulting" begin="0" end="2" items="${d_conlist}" >     
               <tr align="center">
               <td>${consulting.expname}</td>
               <td><fmt:formatDate value="${consulting.reqdate}" pattern="yy-MM-dd  kk:MM"/></td>
                <td><button type="button" class="btn btn-outline-secondary" onclick="del(${consulting.no})">삭제</button></td>
          </tr>
        </c:forEach>   
   </table>
	<a href = "${contextPath}/startuppage/consulting_more_d.do">더보기</a>
</div>
     <script src="${contextPath}/resources/js/jquery.min.js"></script>
       <script src="${contextPath}/resources/js/jquery-migrate-3.0.1.min.js"></script>
       <script src="${contextPath}/resources/js/popper.min.js"></script>
     <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
     <script src="${contextPath}/resources/js/jquery.easing.1.3.js"></script>
     <script src="${contextPath}/resources/js/jquery.waypoints.min.js"></script>
     <script src="${contextPath}/resources/js/jquery.stellar.min.js"></script>
     <script src="${contextPath}/resources/js/owl.carousel.min.js"></script>
     <script src="${contextPath}/resources/js/jquery.magnific-popup.min.js"></script>
     <script src="${contextPath}/resources/js/jquery.animateNumber.min.js"></script>
     <script src="${contextPath}/resources/js/scrollax.min.js"></script>
     <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
     <script src="${contextPath}/resources/js/google-map.js"></script>
     <script src="${contextPath}/resources/js/main.js"></script>
</body>
</html>