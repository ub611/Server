<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!-- bootStrap -->
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<jsp:include page="/WEB-INF/jsp/menu.jsp" />

<!------ Include the above in your HEAD tag ---------->

<br><br> <p></p>

&nbsp;&nbsp;&nbsp;&nbsp;

<button type="button" onclick="location.href='/myPageItem?u_idx=${u_idx}'" class="btn btn-outline-warning slidetopright">&nbsp;&nbsp;Item&nbsp;&nbsp; </button>
&nbsp;<button type="button" onclick="location.href='/chat.do'" class="btn btn-outline-warning slidetopright"> Chatting </button>
&nbsp;&nbsp;
<button type="button" onclick="location.href='/signoff.do'" class="btn btn-outline-danger slideleft"> Logout </button>



<meta name="viewport" content="width=device-width, initial-scale=1">

<style type="text/css">
body {
	font-family: "Open Sans", sans-serif;
}

h2 {
	color: #000;
	font-size: 26px;
	font-weight: 300;
	text-align: center;
	text-transform: uppercase;
	position: relative;
	margin: 30px 0 80px;
}

h2 b {
	color: #ffc000;
}

h2::after {
	content: "";
	width: 100px;
	position: absolute;
	margin: 0 auto;
	height: 4px;
	background: rgba(0, 0, 0, 0.2);
	left: 0;
	right: 0;
	bottom: -20px;
}

.carousel {
	margin: 50px auto;
	padding: 0 70px;
}

.carousel .item {
	min-height: 330px;
	text-align: center;
	overflow: hidden;
}

.carousel .item .img-box {
	height: 160px;
	width: 100%;
	position: relative;
}

.carousel .item img {
	max-width: 100%;
	max-height: 100%;
	display: inline-block;
	position: absolute;
	bottom: 0;
	margin: 0 auto;
	left: 0;
	right: 0;
}

.carousel .item h4 {
	font-size: 18px;
	margin: 10px 0;
}

.carousel .item .btn {
	color: #333;
	border-radius: 0;
	font-size: 11px;
	text-transform: uppercase;
	font-weight: bold;
	background: none;
	border: 1px solid #ccc;
	padding: 5px 10px;
	margin-top: 5px;
	line-height: 16px;
}

.carousel .item .btn:hover, .carousel .item .btn:focus {
	color: #fff;
	background: #000;
	border-color: #000;
	box-shadow: none;
}

.carousel .item .btn i {
	font-size: 14px;
	font-weight: bold;
	margin-left: 5px;
}

.carousel .thumb-wrapper {
	text-align: center;
}

.carousel .thumb-content {
	padding: 15px;
}

.carousel .carousel-control {
	height: 100px;
	width: 40px;
	background: none;
	margin: auto 0;
	background: rgba(0, 0, 0, 0.2);
}

.carousel .carousel-control i {
	font-size: 30px;
	position: absolute;
	top: 50%;
	display: inline-block;
	margin: -16px 0 0 0;
	z-index: 5;
	left: 0;
	right: 0;
	color: rgba(0, 0, 0, 0.8);
	text-shadow: none;
	font-weight: bold;
}

.carousel .item-price {
	font-size: 13px;
	padding: 2px 0;
}

.carousel .item-price strike {
	color: #999;
	margin-right: 5px;
}

.carousel .item-price span {
	color: #86bd57;
	font-size: 110%;
}

.carousel .carousel-control.left i {
	margin-left: -3px;
}

.carousel .carousel-control.left i {
	margin-right: -3px;
}

.carousel .carousel-indicators {
	bottom: -50px;
}

.carousel-indicators li, .carousel-indicators li.active {
	width: 10px;
	height: 10px;
	margin: 4px;
	border-radius: 50%;
	border-color: transparent;
}

.carousel-indicators li {
	background: rgba(0, 0, 0, 0.2);
}

.carousel-indicators li.active {
	background: rgba(0, 0, 0, 0.6);
}

.star-rating li {
	padding: 0;
}

.star-rating i {
	font-size: 14px;
	color: #ffc000;
}
</style>
</head>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>
					List Of <b> Pets</b>
				</h2>
				<div id="myCarousel" class="carousel slide" data-ride="carousel"
					data-interval="0">
					<!-- Carousel indicators -->

					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<c:set var="size" value="${fn:length(petList)}" />	<!-- 21 -->
						
						<c:forEach var="i" begin="1" end="${size/4}" varStatus="status">
							<li data-target="#myCarousel" data-slide-to="${i}"></li>
						</c:forEach>

					</ol>
				<div class="carousel-inner">
					<div class="item carousel-item active">
						<div class="row">
							<c:forEach var="item" items="${petList}" begin="0" end="3">
							<div class="col-sm-3">
								<div class="thumb-wrapper">
									<div class="thumb-content">
									<br><br><br>
										<h4>${item.p_name}</h4>
										<p class="item-price"><span>${item.p_gender}살</span></p>
										<p>${item.p_age}</p>
										<p>${item.c_name}</p>
										<a href="/petEdit?p_idx=${item.p_idx}" class="btn btn-primary">GO TO DETAIL</a>
									</div>						
								</div>
							</div>
							</c:forEach>
						</div>
					</div>
					<c:forEach var="item" items="${petList}" begin="4" end="${size}" varStatus="status">
						<c:if test="${status.index % 4 == 3}">
							<div class="item carousel-item">
								<div class="row">
									<c:set var="idx" value="${status.index}" />	<!-- 21 -->
									 <c:forEach var="item" items="${petList}" begin="${idx-3}" end="${idx}">
										<div class="col-sm-3">
											<div class="thumb-wrapper">
												<div class="thumb-content">
													<br><br><br>
													<h4>${item.p_name}</h4>
													<p class="item-price"><span>${item.p_gender}살</span></p>
													<p>${item.p_age}</p>
													<p>${item.c_name}</p>
													<a href="/petEdit?p_idx=${item.p_idx}" class="btn btn-primary">GO TO DETAIL</a>
												</div>						
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</c:forEach>
						<!-- Carousel controls -->
						<a class="carousel-control left carousel-control-prev"
							href="#myCarousel" data-slide="prev"> <i
							class="fa fa-angle-left"></i>
						</a> <a class="carousel-control right carousel-control-next"
							href="#myCarousel" data-slide="next"> <i
							class="fa fa-angle-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
		<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h2>
					List Of <b> Adopts</b>
				</h2>
				<div id="myCarousel2" class="carousel slide" data-ride="carousel"
					data-interval="0">
					<!-- Carousel indicators -->

					<ol class="carousel-indicators">
						<li data-target="#myCarousel2" data-slide-to="0" class="active"></li>
						<c:set var="size" value="${fn:length(adoptList)}" />	
						<c:forEach var="i" begin="1" end="${size/4}" varStatus="status">
							<li data-target="#myCarousel2" data-slide-to="${i}"></li>
						</c:forEach>

					</ol>
				<div class="carousel2-inner">
					<div class="item carousel-item active">
						<div class="row">
							<c:forEach var="item" items="${adoptList}" begin="0" end="3">
							<div class="col-sm-3">
								<div class="thumb-wrapper">
									<div class="thumb-content">
									<br><br><br>
										<h4>${item.p_name}</h4>
										<p class="item-price"><span>${item.p_age}살</span></p>
										<p>${item.p_gender}</p>
										<p>${item.a_date}</p>
										<a href="/adoptDetail.do?a_idx${item.a_idx}" class="btn btn-primary">GO TO DETAIL</a>
									</div>						
								</div>
							</div>
							</c:forEach>
						</div>
					</div>
					<c:forEach var="item" items="${adoptList}" begin="4" end="${size}" varStatus="status">
						<c:if test="${status.index % 4 == 3}">
							<div class="item carousel-item">
								<div class="row">
									<c:set var="idx" value="${status.index}" />	<!-- 21 -->
									 <c:forEach var="item" items="${adoptList}" begin="${idx-3}" end="${idx}">
										<div class="col-sm-3">
											<div class="thumb-wrapper">
												<div class="thumb-content">
												<br><br><br>
													<h4>${item.p_name}</h4>
													<p class="item-price"><span>${item.p_age}살</span></p>
													<p>${item.p_gender}</p>
													<p>${item.a_date}</p>
													<a href="#" class="btn btn-primary">GO TO DETAIL</a>
												</div>							
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</c:if>
					</c:forEach>
						<!-- Carousel controls -->
						<a class="carousel-control left carousel-control-prev"
							href="#myCarousel2" data-slide="prev"> <i
							class="fa fa-angle-left"></i>
						</a> <a class="carousel-control right carousel-control-next"
							href="#myCarousel2" data-slide="next"> <i
							class="fa fa-angle-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>