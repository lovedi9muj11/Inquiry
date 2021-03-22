<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login with your account</title>

<%--     <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet"> --%>
    <link href="${contextPath}/resources/login/css/style.css" rel="stylesheet">
<%--     <link href="${contextPath}/resources/css/common.css" rel="stylesheet"> --%>
    
    <script src="${contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<%--     <script src="${contextPath}/resources/js/bootstrap.min.js"></script> --%>
    
</head>

<body class="img js-fullheight">

<section class="ftco-section">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-5">
				<h2 class="heading-section">Login #Inquiry</h2>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-4">
				<div class="login-wrap p-0">
	      	<h3 class="mb-4 text-center">แบบสอบถาม</h3>
	      	<form method="POST" action="${contextPath}/login" class="signin-form">
	      		<div class="form-group">
<!-- 		      			<input type="text" class="form-control" placeholder="Username" required> -->
					<span>${message}</span>
	      			<input type="text" class="form-control" placeholder="Username" name="username" autofocus="true" required/>
	      		</div>
            <div class="form-group">
<!-- 	              <input id="password" type="password" class="form-control" placeholder="Password" required> -->
              <input id="password" type="password" class="form-control" placeholder="Password" name="password" required/>
              <span toggle="#password" class="fa fa-fw fa-eye field-icon toggle-password"></span>
              <span>${error}</span>
            </div>
            <div class="form-group">
            	<button type="submit" class="form-control btn btn-primary submit px-3">Sign In</button>
            </div>
          </form>
	      </div>
			</div>
		</div>
	</div>
</section>

<!-- <div class="container"> -->

<%--     <form method="POST" action="${contextPath}/login" class="form-signin"> --%>
<!--         <h2 class="form-heading text-center">แบบสอบถาม</h2> -->

<%--         <div class="form-group ${error != null ? 'has-error' : ''}"> --%>
<%--             <span>${message}</span> --%>
<!--             <input name="username" type="text" class="form-control" placeholder="Username" autofocus="true"/> -->
<!--             <input name="password" type="password" class="form-control" placeholder="Password"/> -->
<%--             <span>${error}</span> --%>
<%--             <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>

<!--             <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button> -->
<!--         </div> -->
<%--     </form> --%>

<!-- </div> -->

<script src="${contextPath}/resources/login/js/jquery.min.js"></script>
<script src="${contextPath}/resources/login/js/popper.js"></script>
<script src="${contextPath}/resources/login/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/login/js/main.js"></script>

</body>
</html>
