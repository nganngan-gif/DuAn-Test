<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>

<title></title>
<style>
.container {
	margin-right: auto !important;
	margin-left: auto !important;
	margin-top: 20px !important;
	width: 550px !important;
	border: 2px solid powderblue !important;
	border-radius: 15px !important;
	background-color: #212121 !important;
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
		<h1>Đăng Nhập</h1>
		<form action="account" method="post">
			<div class="form-group ">
				<label>Tên đăng nhập:</label> <input type="text" name="username"
					class="form-control" value="" size="20">
			</div>
			<div class="form-group">
				<label>Mật khẩu:</label> <input type="password" name="password"
					class="form-control" value="" size="20">
			</div>
			<div class="form-group">
				<input style="margin-left: 20px" type="checkbox" name="remember"
					value="true" size="5"> Remember me?
			</div>
			<div class="col">
				<c:if test="${not empty message}">
					<div class="alert alert-success">${message}</div>
				</c:if>
			</div>
				<div>
					<button formaction="/NghienTube/account/sign-in"
						class="btn btn-primary btn-brand btn-block mb-4">Đăng
						Nhập</button>
				</div>
		</form>
		<div>
			<button name="fogot-password"
				class="btn btn-primary btn-brand btn-block mb-4" type="submit"
				data-bs-toggle="modal" data-bs-target="#exampleModal">Quên
				mật khẩu</button>
		</div>
	</div>
</body>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel"
					style="color: black !important;">Forgot Password</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<input class="form-control" type="text" placeholder="User Name?"><br>
				<input class="form-control" type="email" placeholder="Email?">
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
				<form action="account">

					<button formaction="/NghienTube/account/forget-pass"
						class="btn btn-primary">Send</button>
				</form>
			</div>
		</div>
	</div>
</div>
</html>