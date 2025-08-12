<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet">
<link href="<c:url value='/css/sb-admin-2.min.css'/>" rel="stylesheet">
<body class="bg-gradient-primary">

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                            </div>
                            <form id="registerForm" method="post" action="/member/join" enctype="multipart/form-data">
							  <div class="form-group row">
							    <div class="col-sm-6 mb-3 mb-sm-0">
							      <input type="text" class="form-control form-control-user" id="firstName" name="firstName" placeholder="First Name">
							    </div>
							    <div class="col-sm-6">
							      <input type="text" class="form-control form-control-user" id="lastName" name="lastName" placeholder="Last Name">
							    </div>
							  </div>
							
							  <input type="hidden" name="username" id="username">
							
							  <div class="form-group">
							    <input type="email" class="form-control form-control-user" name="email" id="email" placeholder="Email Address">
							  </div>
							
							  <div class="form-group row">
							    <div class="col-sm-6 mb-3 mb-sm-0">
							      <input type="password" name="password" class="form-control form-control-user" id="password" placeholder="Password">
							    </div>
							    <div class="col-sm-6">
							      <input type="password" name="passwordConfirm" class="form-control form-control-user" id="passwordConfirm" placeholder="Repeat Password">
							    </div>
							  </div>
							
							  <!-- 프로필 파일 받으려면 추가 -->
							  <input type="file" name="profile" class="form-control">
							
							  <button type="submit" class="btn btn-primary btn-user btn-block">Register Account</button>
							</form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="forgot-password.html">Forgot Password?</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="login.html">Already have an account? Login!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/vendor/jquery/jquery.min.js'/>"></script>
    <script src="<c:url value='/vendor/bootstrap/js/bootstrap.bundle.min.js'/>"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/vendor/jquery-easing/jquery.easing.min.js'/>"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/js/sb-admin-2.min.js'/>"></script>
    <script type="text/javascript" src="/js/members/member_id.js"></script>
</body>
</html>