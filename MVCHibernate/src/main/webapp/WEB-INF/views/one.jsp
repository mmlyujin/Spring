<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="updateData" method="post">
		idx :<input type="text" name="idx"  value="${dto.idx}" readonly><br>
		id : <input type="text" name="id"  value="${dto.id}"><br>
		pw : <input type="password" name="pw"  value="${dto.pw}"><br>
		content : <textarea name="content" value="${dto.content}"></textarea><br>
		<input type="submit" value="����">
	</form>
</body>
</html>