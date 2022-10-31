<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Board</title>
</head>
<style>
	table{
		border-collapse: collapse;
	}
	td{
		border: 1px solid black;
	}
</style>
</head>
<body>
<a href="selectAll">�������� ����</a>
	<form method="post" action="insertBoard">
	<table>
		<tr>
			<td>����</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>�۾���</td>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>��й�ȣ</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2">����</td>			
		</tr>
		<tr>			
			<td colspan="2"><textarea name="content"></textarea></td>
		</tr>
		<tr>			
			<td colspan="2"><input type="submit" value="�Է�"></td>
		</tr>
	</table>
	<input type="hidden" name="regdate">
	</form>
		
	<h2>�Խ��� ���</h2><br>
	<c:forEach var="i" items="${list}">
	<a href="deleteBoard?idx=${i.idx}">${i.idx}</a>/
	<a href="selectOneBoard?idx=${i.idx}">${i.title}</a>/
	 ${i.writer}/${i.pw}/${i.content}
	 <br>
	</c:forEach>
	
	
</body>
</html>