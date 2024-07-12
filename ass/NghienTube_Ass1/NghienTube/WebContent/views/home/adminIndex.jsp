<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>NghienTube - Admin</title>
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
<style type="text/css">
.navbar {
	margin-bottom: 20px;
	background-color: #212121 !important;
	color: white;
}

.nav-link {
	color: white !important;
	font-size: large !important;
}

.nav-item {
	margin-right: 30px !important;
}

.nav-item:hover {
	font-weight: bold;
}

.nav-link:active {
	font-weight: bold;
}

body {
	background-color: #181818;
	color: white;
	font-family: Roboto, Arial, sans-serif;
}

.col img {
	widows: 100%;
	height: 70%;
}

.p-3 {
	text-align: center;
	background-color: #212121 !important
}

.p-3 p {
	text-align: left;
}

.btn-lns {
	text-align: right
}

.col-3 {
	background-color: #212121 !important;
}

.dieuhuong {
	text-align: center;
	margin-top: 30px;
	margin-bottom: 100px;
	margin-top: 30px;
}

.dieuhuong .btn {
	width: 150px;
	margin-right: 20px;
}

.footer {
	height: 50px;
	line-height: 50px;
	width: 100%;
	background-color: #212121 !important;
	text-align: center;
	color: white;
}
.img_nav{
	height: 70px;
	width: 70px;
	padding: 0px 0px;
	
}

<!--
-----------------------------------------------------------------
-->
.dropbtn1{
	background-color: #4CAF50!important;
	color: white!important;
	padding: 16px!important;
	font-size: 16px!important;
	border: none!important;
	cursor: pointer!important;
	border-radius: 5px!important;
	width: 100px!important;
}

.dropdown {
	position: relative!important;
	display: inline-block!important;
}

.dropdown-content {
	display: none!important;
	position: absolute!important;
	background-color: #f9f9f9!important;
	min-width: 200px!important;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2)!important;
	z-index: 1!important;
}

.dropdown-content a {
	color: black!important;
	padding: 12px 16px!important;
	text-decoration: none!important;
	display: block!important;
}

.dropdown-content a:hover {
	background-color: #f1f1f1!important;
}

.dropdown:hover .dropdown-content {
	display: block!important;
}

.dropdown:hover .dropbtn1 {
	background-color: #3e8e41!important;
}
</style>
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand"
					href="/NghienTube/admin/index?page=0">
					<img
					src="https://2.pik.vn/2022353ec35d-7b33-4d27-94ee-34a2fcd8cd14.png"
					width="100px" height="100px" />
				</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link active"
							aria-current="page"
							href="/NghienTube/admin/index?page=0">HOME</a></li>
						<li class="nav-item"><a class="nav-link" href="#">VIDEOS</a></li>
						<li class="nav-item"><a class="nav-link" href="/NghienTube/admin/edit-user/update">USERS</a></li>
						<li class="nav-item"><a class="nav-link" href="#">REPORTS</a></li>
					</ul>
				</div>
				<div class="dropdown">
					<button class="dropbtn1"
						style="width: 100px; color: white; background-color: #04AA6D;">Admin</button>
					<div class="dropdown-content">
						<a href="/NghienTube/account/sign-in">Login</a> 
						<a href="#">Forgot Password</a> 
						<a href="/NghienTube/account/sign-up">Registration</a>
						<a href="#">Logoff</a> 
						<a href="/NghienTube/account/change-pass">Change Password</a> 
						<a href="/NghienTube/account/edit-profile">EditProfile</a>
					</div>
				</div>
			</div>
		</nav>
		<div class="row">
			<div class="">
				<div class="row row-cols-3 row-cols-lg-3 g-3 g-lg-3">
					<c:forEach var="item" items="${video}">
					<div class="col">
						<div class="p-3 border bg-light" style="height: 362px">
							<a
								href="/NghienTube/user/chitiet?idVideo=${item.videoID}">
								<div>
									<iframe width="380" height="244"
										src="${item.poster}"
										title="YouTube video player" frameborder="0"
										allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
										allowfullscreen
										style="pointer-events:none;"></iframe>
									<p>${item.title}</p>
								</div>
							</a>
						</div>
						
						<!--  -->
					</div>
					</c:forEach>
					<!--  -->
				</div>
				<div class="dieuhuong">
					<form action="" method="post">
					<button class="btn btn-primary" formaction="/NghienTube/admin/index?page=0">First</button>
					<button class="btn btn-primary" formaction="/NghienTube/admin/index?page=${page - 1}">Previous</button>
					<button class="btn btn-primary" formaction="/NghienTube/admin/index?page=${page + 1}">Next</button>
					<button class="btn btn-primary" formaction="/NghienTube/admin/index?page=${s}">Last</button>
				</form>

				</div>
			</div>

		</div>
	</div>
	<div class="footer">Hi cả nhà</div>
</body>

</html>