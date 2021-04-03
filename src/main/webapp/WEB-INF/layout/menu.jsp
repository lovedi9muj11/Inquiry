<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%-- <jsp:include page="${contextPath}/commons/includes.jsp"></jsp:include> --%>
<%-- <jsp:include page1="../commons/sMainStyles.jsp"></jsp:include> --%>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<script>var ctx = "${pageContext.request.contextPath}"</script>

<link href="${contextPath}/resources/css/styles/bootstrap/css/bootstrap.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/font-awesome-4.7.0/css/font-awesome.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/jquery-ui-1.11.4.custom/jquery-ui.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/style-menu.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/bootstrap-modify.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/bootstrap-fileinput/css/fileinput.min.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/style.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/dashboard.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/display-tag.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/styles/welcome.css" rel="stylesheet" media="screen" type="text/css">
<link href="${contextPath}/resources/css/HoldOn.css" rel="stylesheet">

<script src="${contextPath}/resources/lib/sweetalert.min.js"></script>

<!-- sidebar -->
<div id="wrapper">
	<div id="sidebar-wrapper">
		<nav class="navbar navbar-default sidebar" role="navigation">
			<div class="collapse navbar-collapse"
				id="bs-sidebar-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li class=""><a href="${contextPath}">หน้าจอหลัก <span
							style="font-size: 18px;"
							class="pull-right hidden-xs showopacity fa fa-home"> </span>
					</a></li>
					<sec:authorize access="hasAuthority('ADMIN') or hasAuthority('SUPERVISOR')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Manage <span class="caret"></span> <span
								style="font-size: 18px;"
								class="pull-right hidden-xs showopacity fa fa-file-text-o"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/userManageMent">จัดการข้อมูล User</a></li>
								<li><a href="${contextPath}/masterData">จัดการข้อมูล Master Data</a></li>
							</ul></li>
					</sec:authorize>
					<sec:authorize access="hasAuthority('USER') or hasAuthority('SUPERVISOR')">
<%-- 						<sec:authorize access="hasAuthority('USER')"> --%>
<!-- 							<li class="dropdown"><a href="#" class="dropdown-toggle" -->
<!-- 								data-toggle="dropdown">Page1 <span class="caret"></span> -->
<!-- 									<span style="font-size: 18px;" -->
<!-- 									class="pull-right hidden-xs glyphicon glyphicon-usd"></span> -->
<!-- 							</a> -->
<!-- 								<ul class="dropdown-menu forAnimate" role="menu"> -->
<%-- 									<li><a href="${contextPath}/page1">xxx</a> --%>
<!-- 									</li> -->
<!-- 								</ul></li> -->
<%-- 						</sec:authorize> --%>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">แบบสอบถาม <span
								class="caret"></span> <span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-copyright-mark"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/question">แบบสอบถาม</a>
								</li>
							</ul>
						</li>
							
					</sec:authorize>
					<sec:authorize access="hasAuthority('REPORTER') or hasAuthority('SUPERVISOR')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Page1 <span class="caret"></span>
								<span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-usd"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/page1">xxx</a>
								</li>
							</ul></li>
							
					</sec:authorize>
				</ul>
			</div>
		</nav>
	</div>
</div>