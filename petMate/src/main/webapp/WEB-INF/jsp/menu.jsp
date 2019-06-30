<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Welcome to PetMate</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom fonts for this template -->
  <link href="https://fonts.googleapis.com/css?family=Saira+Extra+Condensed:500,700" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Muli:400,400i,800,800i" rel="stylesheet">
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/resume.min.css" rel="stylesheet">

</head>

<%! String sessionhref; %>		<!-- For isLogin -->
<%
	if(session.getAttribute("u_idx") != null)		//if userLogin
		sessionhref = "/signup.do";			//goto myPage
  else
	  sessionhref = "/signinForm.do";		//or goto SignIn
%>

  <nav class="navbar navbar-expand-lg navbar-dark bg-primary fixed-top" id="sideNav" >
    <a class="navbar-brand js-scroll-trigger" href=<%=sessionhref%> >		<!-- login으로 -->
      <span class="d-block d-lg-none" ><br>Pet Mate</span>
      <span class="d-none d-lg-block" >
        <img class="img-fluid img-profile rounded-circle mx-auto mb-2" src="https://sopt2.s3.ap-northeast-2.amazonaws.com/pet/KakaoTalk_Photo_2019-06-21-01-30-44.png" alt="">
      </span>
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/petList.do">Home</a>
        </li>
         <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href=<%=sessionhref%>>MyPage</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/viewCart.do">Cart</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/adoptList.do">Adopt</a>
        </li>
        <li class="nav-item">
          <a class="nav-link js-scroll-trigger" href="/items.do?sort=0">Item</a>
        </li>
      </ul>
    </div>
  </nav>
