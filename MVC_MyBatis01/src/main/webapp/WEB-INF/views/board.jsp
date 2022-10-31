<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="boardInsert" method="post">
		아이디<input type="text" name="id">
		제목<input type="text" name="title">
		내용<input type="text" name="content">
		<input type="submit" value="작성완료">
	</form>
	<hr>
	
<c:forEach var="i" items="${list}">
		<a href="delete?idx=${i.idx}">${i.idx}</a>/
		<a href="selectOne?idx=${i.idx}">${i.id}</a>/
		${i.pw}/
		${i.name}<br>
	</c:forEach>

</body>
</html>