<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script>
   $(document).ready(function(){
      $("#id").keyup(function() {
         //var inputdata = $("#id").val();
         var form = {                
                id: $("#id").val()
           }         
         
           $.ajax({
               url: "ajax",
               type: "POST",
               data: JSON.stringify(form),
               contentType: "application/json; charset=utf-8;",
               dataType: "json",
               success: function(data){
                   $('#res').text(data.res);
               },
               error: function(request,status){
                   $("#error").html("code:"+request.status+"<br>"+request.responseText+"<br>");                   
               }
           });
       });
   });
      
   </script>


<body>
	<form action="insert" method="post">
		아이디<input type="text" name="id" id="id"><span id="res"></span><br>
		비밀번호<input type="password" name="pw"><br>
		이름<input type="text" name="name"><br>
		<input type="submit" value="가입">
	</form>
	<hr>
	<c:forEach var="i" items="${list}">
		<a href="delete?idx=${i.idx}">${i.idx}</a>/
		<a href="selectOne?idx=${i.idx}">${i.id}</a>/${i.pw}/${i.name}<br>
	</c:forEach>
</body>
</html>



