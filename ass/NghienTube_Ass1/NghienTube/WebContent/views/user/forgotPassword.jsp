<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nghiện Tube - Login</title>
<!-- Import Boostrap css, js, font awesome here -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/
	bootstrap.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.4/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
	
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Lab2</title>
<style>
.container {
	margin-right: auto;
	margin-left: auto;
	margin-top: 20px;
	width: 550px;
	border: 2px solid powderblue;
	border-radius: 15px;
	background-color: #212121;
}

h1 {
	font-weight: bold;
	text-align: center;
}

body{
	background-color: #181818;
	color: white;
	font-family: Roboto, Arial, sans-serif;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Đăng Nhập</h1>
		<form action="" method="post">
			<div class="form-group from-control">
				<label>Tên đăng nhập:</label> <input type="text" name="username"
					class="form-control" value="" size="20">
			</div>
			<div class="form-group">
				<label>Mật khẩu:</label> <input type="password" name="password"
					class="form-control" value="" size="20">
			</div>
			<div class="form-group"> 
				<input style="margin-left: 20px" type="checkbox" name="remember" value="true" size="5"> Remember me?
			</div>
			<div>
				<button name="dangnhap" class="btn btn-primary btn-brand btn-block mb-4">Đăng Nhập</button>
			</div>
		</form>
		<form action="" method="post">
			<div>
				<button name="fogot-password" class="btn danger btn-brand btn-block mb-4">Quên mật khẩu</button>
			</div>
		</form>
	</div>
</body>
</html>