<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
	font-family: Arial;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.container {
	text-align: center;
}

.form-container {
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

.changepd-form input, .login-form button {
	width: calc(100% - 50px);
	margin-bottom: 10px;
	padding: 12px 10px;
	margin: 15px;
	border-radius: 5px;
	font-size: 14px;
	border: 1px solid #ccc;
}

.changepd-form button {
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

.changepd-form button:hover {
	background-color: #ffff;
	color: #000;
	border: 1px solid #000;
}

.changepd-form .forgetTxt{
	padding-bottom: 20px; 
}

.changepd-form .op8{
	opacity: 0.8;
}
</style>
<body>
	<div class="container">
		<div class="form-container">
			<div class="header-form">
				<h3 class="heading">Đổi mật khẩu</h3>
			</div>
			<p>${error}</p>
			<p>${success}</p>
			<form class="changepd-form" action="change-password.htm" method="post">
				<input type="text" name="username" placeholder="Nhập tài khoản..." />
				<input type="password" name="oPassword"
					placeholder="Nhập mật khẩu cũ..." />
				<input type="password" name="new-password"
					placeholder="Nhập mật khẩu mới..." />
				<input type="password" name="confirm-password"
					placeholder="Xác nhận mật khẩu..." />
				<button type="submit">Gửi</button>
				<div>
					<h4 class="op8">
						<a href="login.htm">Đăng nhập</a>
					</h4>
				</div>
			</form>
		</div>
	</div>
</body>
</html>