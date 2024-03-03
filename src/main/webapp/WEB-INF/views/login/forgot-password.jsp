<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<style>
body {
	font-family: Arial;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

form {
	text-align: center;
	width: 430px;
	border: 1px solid #ccc;
	border-radius: 6px;
}

.header-form {
	margin-bottom: 20px;
	font-size: 30px;
	border-top-left-radius: 6px;
	border-top-right-radius: 6px;
	background-color: #2f2e68;
}

.header-form h4 {
	padding: 18px 0;
	margin: 0;
	color: #ffff;
}

.txtForget{
	display: flex;
	margin-left: 30px;
}

input, button {
	width: calc(100% - 50px);
	margin-bottom: 10px;
	padding: 12px 10px;
	margin: 15px;
	border-radius: 5px;
	font-size: 14px;
	border: 1px solid #ccc;
}

button[type="submit"] {
	width: calc(100% - 29px);
	padding: 10px;
	border-radius: 5px;
	border: none;
	background-color: #2f2e68;
	color: #fff;
	cursor: pointer;
	font-size: 20px;
	border: 1px solid #2f2e68;
}

button[type="submit"]:hover {
	background-color: #ffff;
	color: #000;
	border: 1px solid #000;
}

.op8 {
	opacity: 0.8;
	margin: 0;
}
</style>
</head>
<body>
	<form class="forgotForm" action="forgot-password.htm" method="post">
		<div class="header-form">
			<h4 class="heading">Quên mật khẩu</h4>
		</div>
		<div class="txtForget">
			<h5 class="pd-usern">${message} </h5>
			<h5 class="password">${password}</h5>
		</div>
		<input type="text" id="username" name="username"
			placeholder="Nhập tài khoản của bạn..." required><br>
		<div>
			<h4 class="op8">
				<a href="login.htm">Đăng nhập</a>
			</h4>
		</div>
		<button type="submit">Gửi</button>
	</form>
</body>
</html>
