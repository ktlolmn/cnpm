<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
<style>
body {
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

.login-form input, .login-form button {
	width: calc(100% - 50px);
	margin-bottom: 10px;
	padding: 12px 10px;
	margin: 15px;
	border-radius: 5px;
	font-size: 14px;
	border: 1px solid #ccc;
}

.login-form button {
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

.login-form button:hover {
	background-color: #ffff;
	color: #000;
	border: 1px solid #000;
}

.login-form .forgetTxt{
	padding-bottom: 20px; 
}


.forgetTxt a{
	color: #000;
}

.login-form .op8{
	opacity: 0.8;
}
</style>
</head>
<body>
	<div class="container">
		<div class="form-container">
			<div class="header-form">
				<h3 class="heading">Login</h3>
			</div>
			<form class="login-form" action="/cnpm/login.htm" method="post">
				<input type="text" name="username" placeholder="Enter username..." />
				<input type="password" name="password"
					placeholder="Enter password..." />
				<button type="submit">Log in</button>
				<div>
					<h4 class="op8">
						Need an account <a href="">Sign Up</a>
					</h4>
				</div>
				<div class="forgetTxt op8">
					<a href="">Forget Password?</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
