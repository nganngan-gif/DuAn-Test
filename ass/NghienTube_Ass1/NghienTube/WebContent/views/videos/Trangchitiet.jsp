<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Nghiện Tube - Video</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
<style>
body {
	font-family: Roboto, Arial, sans-serif;
	background-color: #181818;
}

.col-8 {
	width: 68%;
	padding: 0px;
	margin-right: 5px;
}

.col-4 {
	width: 30%;
	padding: 0px;
	background-color: #212121 !important;
}

.video {
	width: 100%;
	height: 570px;
	margin: 0;
}

.row {
	width: 98%;
	margin-top: 30px;
	margin-left: 20px;
}

.titlevideo {
	font-size: 150%;
	margin-top: 5px;
	color: white;
}

.c {
	margin-bottom: 10px;
	height: 120px;
	color: white;
}

.c, p {
	margin-top: 10px;
}

.img-content {
	width: 200px;
	height: 120px;
	display: inline;
	padding-left: 0px;
}

.titleother {
	display: inline;
	color: black;
}

.d {
	text-decoration: none;
}

.d:hover {
	font-weight: bold;
}

.like {
	margin-right: 20px;
}

.btn-lns {
	text-align: right !important;
}

.ngan {
	width: 65%
}

.footer {
	height: 50px;
	margin-top: 20px;
	line-height: 50px;
	width: 100%;
	background-color: #212121 !important;
	text-align: center;
	color: white;
	line-height: 50px;
}

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

.description {
	width: 100%;
	color: white;
}

----------------------------------------------------------
.dropbtn1 {
	background-color: #4CAF50 !important;
	color: white !important;
	padding: 16px !important;
	font-size: 16px !important;
	border: none !important;
	cursor: pointer !important;
	border-radius: 5px !important;
	width: 100px !important;
}

.dropdown {
	position: relative !important;
	display: inline-block !important;
	margin-right: 50px;
}

.dropdown-content {
	display: none !important;
	position: absolute !important;
	background-color: #f9f9f9 !important;
	min-width: 200px !important;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2) !important;
	z-index: 1 !important;
}

.dropdown-content a {
	color: black !important;
	padding: 12px 16px !important;
	text-decoration: none !important;
	display: block !important;
}

.dropdown-content a:hover {
	background-color: #f1f1f1 !important;
}

.dropdown:hover .dropdown-content {
	display: block !important;
}

.dropdown:hover .dropbtn1 {
	background-color: #3e8e41 !important;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand"
				href="/NghienTube/user/index?page=0"> <img
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
						href="/NghienTube/user/index?page=0">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="/NghienTube/user/likedVideo">Favorite</a></li>
				</ul>
			</div>
			<div class="dropdown">
					<button class="dropbtn1"
						style="width: 100px; color: white; background-color: #04AA6D;">User</button>
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
		<div class="col-8">
			<div class="video">

				<iframe width="100%" height="100%" src="${video.poster}"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen></iframe>
			</div>
			<div class="titlevideo">
				<p>${video.title}</p>

			</div>
			<div style="display: flex;">
				<p style="color: #8b9392 !important; width: 15%;">${video.views} lượt xem</p>
				<div class="ngan"></div>
				
			</div>
			<div class="description">
				<h5>Mô tả:</h5>
				<p>${video.description}</p>
			</div>

		</div>
		<div class="col-4 bg-light">
		<c:forEach var="item" items="${videoRD}">
			<a class="d" href="/NghienTube/user/chitiet?idVideo=${item.videoID}">
				<div class="c">
					<iframe width="200" class="img-content" height="120"
										src="${item.poster}"
										title="YouTube video player" frameborder="0"
										allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
										allowfullscreen
										style="pointer-events:none;"
									    align="left" hspace="20"></iframe>
					<p>${item.title}</p>
				</div>
			</a> 
			</c:forEach>
<!--  -->

		</div>
	</div>
	</div>
	<div class="footer">Hi cả nhà</div>
</body>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Share Video</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<input class="form-control" type="text" placeholder="Share To">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Share</button>
			</div>
		</div>
	</div>
</div>
</html>