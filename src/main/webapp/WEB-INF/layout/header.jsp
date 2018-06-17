<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div id="wrapper">
	<nav class="navbar navbar-inverse top-bar navbar-fixed-top"
		style="background-color: #ee7600;">
		<div class="container-fluid">
			<div class="navbar-header">
				<i class="fa fa-bullseye"></i> Offline
			</div>
			<div class="navbar-right">
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST" action="${contextPath}/logout">
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
				</c:if>
				<h4>${pageContext.request.userPrincipal.name}
					| <a onclick="document.forms['logoutForm'].submit()">Logout</a> <i
						class="fa fa-sign-out"></i>
				</h4>
			</div>
		</div>
	</nav>
</div>