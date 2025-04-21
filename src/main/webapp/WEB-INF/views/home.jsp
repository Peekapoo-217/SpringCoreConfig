<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	margin-top: 50px;
}

.btn {
	display: inline-block;
	padding: 10px 20px;
	font-size: 16px;
	text-decoration: none;
	background-color: #007bff;
	color: white;
	border-radius: 5px;
	border: none;
	cursor: pointer;
}

.btn:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<h1>Home Page</h1>
	<form action="/simple-social-network/auth/login" method="get">
		<button type="submit" class=" btn">Login</button>
	</form>
</body>
</html>
 --%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Upload</title></head>
<body>
    <form action="order/upload" method="post" enctype="multipart/form-data">
        <input type="file" name="image" accept="image/*" required />
        <button type="submit">Xử lý ảnh</button>
    </form>
</body>
</html>

