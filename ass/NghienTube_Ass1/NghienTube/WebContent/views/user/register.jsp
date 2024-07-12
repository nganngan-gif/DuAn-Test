<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nghiện Tube - Register</title>
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

body {
	background-color: #181818;
	color: white;
	font-family: Roboto, Arial, sans-serif;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Đăng ký</h1>
		<form action="" method="post">
			<div class="form-group from-control">
				<label>Tên đăng nhập:</label> <input type="text" name="usersID"
					class="form-control" value="" size="20">
			</div>
			<div class="form-group">
				<label>Mật khẩu:</label> <input type="password" name="pass"
					class="form-control" value="" size="20">
			</div>
			<div class="form-group">
				<label>Xác nhận mật khẩu:</label> <input type="password"
					name="confirm-password" class="form-control" value="" size="20">
			</div>
			<div class="form-group">
				<label>Họ và tên:</label> <input type="text" name="fullName"
					class="form-control" value="" size="70">
			</div>

			<div class="form-group">
				<label>Email:</label> <input type="email" name="email"
					class="form-control" value="" size="50">
			</div>
			<div class="form-check form-check-inline">
				<label>Role:&nbsp;&nbsp;&nbsp;</label> <label class="ml-2"><input
					type="radio" class="form-check-input" name="admin" value="true"
					${user.admin ? 'checked' : ''} />Admin </label> <label class="ml-2"><input
					type="radio" class="form-check-input" name="admin" value="false"
					${!user.admin ? 'checked' : ''} />User </label>
			</div>
			<c:if test="${not empty message}">
					<div class="alert alert-success">${message}</div>
			</c:if>
			<hr>
			<div>
				<button name="dangky"
					class="btn btn-primary btn-brand btn-block mb-4" formaction="/NghienTube/account/sign-up">Đăng Ký</button>
			</div>
		</form>
	</div>
</body>
</html>