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
	<form action="insert" method="post">
		���̵�<input type="text" name="id"><br>
		��й�ȣ<input type="text" name="pw"><br>
		�̸�<input type="text" name="name"><br>
		<input type="submit" value="�߰�">
	</form>	
	
	<a href="board">�Խ��� �̵�</a>	
	
	<hr>
	
	<c:forEach var="i" items="${list}">
		<a href="delete?idx=${i.idx}">${i.idx}</a>/
		<a href="selectOne?idx=${i.idx}">${i.id}</a>/
		${i.pw}/
		${i.name}<br>
	</c:forEach>
	
	
</body>
</html>






