<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../commons/includes.jsp"></jsp:include>
<jsp:include page="../commons/sMainStyles.jsp"></jsp:include>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!-- sidebar -->
<div id="wrapper">
	<div id="sidebar-wrapper">
		<nav class="navbar navbar-default sidebar" role="navigation">
			<div class="collapse navbar-collapse"
				id="bs-sidebar-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li class=""><a href="/">หน้าจอหลัก<span
							style="font-size: 18px;"
							class="pull-right hidden-xs showopacity fa fa-home"> </span></a></li>

					<c:if test="${pageContext.request.userPrincipal.name == 'admins'}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Manage<span class="caret"></span><span
								style="font-size: 18px;"
								class="pull-right hidden-xs showopacity fa fa-file-text-o"></span></a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/userManageMent">Sync Data</a></li>
								<li><a href="${contextPath}/masterData">Master Data</a></li>
							</ul></li>
					</c:if>

					<c:if test="${pageContext.request.userPrincipal.name != 'admins'}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">ชำระค่าบริการ <span class="caret"></span>
								<span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-usd"></span></a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/gotoPayment">ชำระค่าบริการ</a></li>
								<li><a href="${contextPath}/payOther">ชำระค่าบริการอื่นๆ</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">ยกเลิกชำระค่าบริการ <span
								class="caret"></span> <span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-copyright-mark"></span></a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/cancalPayment">ยกเลิกชำระค่าบริการ</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">ประวัติการชำระค่าบริการ <span
								class="caret"> </span><span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-list-alt"></span></a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/gotoHistroryPayment">ประวัติการชำระค่าบริการ</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">รายงานชำระเงิน <span class="caret"></span>
								<span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-file"></span></a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/reportPayment">รายการชำระ</a></li>
								<li><a href="${contextPath}/reportPaymentTax">รายการภาษีขายแบบย่อ/แบบเต็ม</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">MinusOnline <span class="caret"></span>
								<span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-road"></span></a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/minusOnline">ส่งหักล้าง</a></li>
							</ul></li>
					</c:if>

				</ul>
			</div>
		</nav>
	</div>
</div>

