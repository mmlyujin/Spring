<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<a href="board">�Խ��� �̵�</a>
	<form action="insertData" method="post">
		id : <input type="text" name="id"><br>
		pw : <input type="password" name="pw"><br>
		content : <textarea name="content"></textarea><br>
		<input type="submit" value="�Է�">
	</form>
	
	<br><hr><br>
	
	<h2>�о�� ������</h2><br>
	<c:forEach var="i" items="${list}">
	 <a href="deleteData?idx=${i.idx}">${i.idx}</a>/
	 <a href="selectOne?idx=${i.idx}">${i.id}</a>/
	 ${i.pw}/${i.content} <br>
	</c:forEach>

</body>
</html>