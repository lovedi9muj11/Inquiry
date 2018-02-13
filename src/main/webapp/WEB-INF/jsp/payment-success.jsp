<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp"></jsp:include>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<script src="lib/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<title>Menu</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<header class="header_page"></header>

	<form name="paymentFrom" method="post" action="paymentService">
		<div id="page-content-wrapper">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li ><a href="#">รับชำระค่าบริการ ></a></li>
						<li class="active"><a href="#">ผลการรับชำระ </a></li>
					</ul>
				</div>
			</nav>
			<div id="" class="row">
				<div class="col-lg-12">
					<div class="col-md-12">
						<font color="black">Success</font>
					</div>
				</div>
			</div>
			
		</div>
	</form>
</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>
