<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
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
	<form method="post" action="insertProc">
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<td>글쓴이</td>
			<td><input type="text" name="writer"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="pw"></td>
		</tr>
		<tr>
			<td colspan="2">내용</td>			
		</tr>
		<tr>			
			<td colspan="2"><textarea name="content"></textarea></td>
		</tr>
		<tr>			
			<td colspan="2"><input type="submit" value="입력"></td>
		</tr>
	</table>
	<input type="hidden" name="regdate">
	</form>
</body>
</html>