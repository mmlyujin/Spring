<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>board update</title>
</head>
<body>
		<form action="updateBoard" method="post">
			idx : <input type="text" name="idx" value="${bdto.idx}" readonly><br>
			Title : <input type="text" name="title" value="${bdto.title}"><br>
			Writer : <input type="text" name="writer" value="${bdto.writer}"><br>
			Pw : <input type="password" name="pw" value="${bdto.pw}"><br>
			Content : <textarea name="content" value="${bdto.content}"></textarea><br>
		<input type="submit" value="수정">
	</form>
</body>
</html>