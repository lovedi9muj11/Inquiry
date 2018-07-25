<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../commons/includes.jsp"></jsp:include>
<jsp:include page="../commons/sMainStyles.jsp"></jsp:include>
<html lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- sidebar -->
<div id="wrapper">
	<div id="sidebar-wrapper">
		<nav class="navbar navbar-default sidebar" role="navigation">
			<div class="collapse navbar-collapse"
				id="bs-sidebar-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li class=""><a href="/">หน้าจอหลัก <span
							style="font-size: 18px;"
							class="pull-right hidden-xs showopacity fa fa-home"> </span>
					</a></li>
					<sec:authorize access="hasAuthority('ADMIN')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Manage <span class="caret"></span> <span
								style="font-size: 18px;"
								class="pull-right hidden-xs showopacity fa fa-file-text-o"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/userManageMent">Sync Data</a></li>
								<li><a href="${contextPath}/masterData">Master Data</a></li>
								<li><a href="${contextPath}/insertBatch">Set Batch</a></li>
							</ul></li>
					</sec:authorize>
					<sec:authorize access="hasAuthority('USER') or hasAuthority('SUP')">
						<sec:authorize access="hasAuthority('USER')">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">ชำระค่าบริการ <span class="caret"></span>
									<span style="font-size: 18px;"
									class="pull-right hidden-xs glyphicon glyphicon-usd"></span>
							</a>
								<ul class="dropdown-menu forAnimate" role="menu">
									<li><a href="${contextPath}/gotoPayment">ชำระค่าบริการ</a>
									</li>
									<li><a href="${contextPath}/payOther">ชำระค่าบริการอื่นๆ</a>
									</li>
								</ul></li>
						</sec:authorize>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">ยกเลิกชำระค่าบริการ <span
								class="caret"></span> <span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-copyright-mark"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/cancalPayment">ยกเลิกชำระค่าบริการ</a>
								</li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">ประวัติการชำระค่าบริการ <span
								class="caret"> </span> <span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-list-alt"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/gotoHistroryPayment">ประวัติการชำระค่าบริการ</a>
								</li>
							</ul>
													<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/gotoHistroryPaymentother">ประวัติการชำระค่าบริการอื่น</a>
								</li>
							</ul>
							</li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">รายงานชำระเงิน <span class="caret"></span>
								<span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-file"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/reportPayment">รายงานการรับชำระ</a>
								</li>
								<li><a href="${contextPath}/reportPaymentTax">รายงานภาษีขายแบบย่อ/แบบเต็ม</a>
								</li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">ส่งหักล้าง <span class="caret"></span>
								<span style="font-size: 18px;"
								class="pull-right hidden-xs glyphicon glyphicon-road"></span>
						</a>
							<ul class="dropdown-menu forAnimate" role="menu">
								<li><a href="${contextPath}/minusOnline">ส่งหักล้าง</a></li>
							</ul></li>
					</sec:authorize>
				</ul>
			</div>
		</nav>
	</div>
</div>