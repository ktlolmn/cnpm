<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
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

.header-form h3{
	padding: 18px 0;
	margin: 0;
	color: #ffff;
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

.op8{
	opacity: 0.8;
}
</style>
</head>
<body>
	<form class="registerForm" action="/cnpm/register.htm" method="post">
		<div class="header-form">
			<h3 class="heading">Đăng ký tài khoản</h3>
		</div>
		<p>${error}</p>
		<input type="text" id="username" name="username" placeholder="Nhập tên tài khoản..." required><br> 
		<input type="password" id="password" name="password" placeholder="Nhập mật khẩu..." required><br> 
		<input type="email" id="email" name="email" placeholder="Nhập email..." required><br> 
		<div>
			<h4 class="op8">
				Bạn đã có tài khoản? <a href="login.htm">Đăng nhập</a>
			</h4>
		</div>
		<button type="submit">Đăng ký</button>
	</form>
</body>
</html>
