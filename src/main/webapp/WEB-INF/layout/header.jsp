<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../commons/sMainStyles.jsp"></jsp:include>

<div id="wrapper">
	<nav class="navbar navbar-inverse top-bar navbar-fixed-top">
	    <div class="container-fluid">
			<div class="navbar-header">	
				<i class="fa fa-bullseye"></i> Offline 
			</div>
		<div class="navbar-right">
<!-- 				<div class="row"> -->
<!-- 					<div class="col-md-12 tab-modefile"> -->
				   	<c:if test="${pageContext.request.userPrincipal.name != null}">
				<form id="logoutForm" method="POST" action="${contextPath}/logout">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
				</c:if>
<!-- 					</div> -->
<!-- 				</div> -->
	      	 <h4>${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h4>
		</div>
	    </div>		   
	</nav>
</div>
