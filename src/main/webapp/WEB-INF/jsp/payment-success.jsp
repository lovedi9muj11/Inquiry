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
	<link href="css/payment.css" rel="stylesheet">
<script src="js/payment.js"></script>

</head>
<body>
	<header class="header_page"></header>

	<form name="paymentFrom" method="post" action="paymentService">
		<div id="page-content-wrapper">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li><a href="#">รับชำระค่าบริการ ></a></li>
						<li class="active"><a href="#">ผลการรับชำระ </a></li>
					</ul>
				</div>
			</nav>
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="form-group" align="right">
						<div class="col-md-12 col-sm-12">
							<button name="submitFormPayment" type="button" class="btn btn-danger btn-lg" onclick="backPayment()">
								<span class="glyphicon glyphicon-chevron-left"> กลับไปยังหน้าชำระ</span>
							</button>
						</div>
					</div>
				</div>
			</div>
			<!-- panel รายการหัก -->
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="form-group">
						<div class="col-md-12 col-sm-12">
							<div class="panel">
								<div class="panel-heading" style="background-color: #ee7600;">สรุปรายการหัก</div>
								<div class="panel-body">
									<div style="display: none">
										<table id="sumDeductibleTable">
											<thead>
												<tr></tr>
											</thead>
											<tbody></tbody>
										</table>
									</div>
									<table class="table" id="showResultTable">
										<thead>
											<tr align="center">
												<th></th>
												<th>#</th>
												<th>เลขที่ลูกค้า</th>
												<th>ชื่อลูกค้า</th>
												<th>เลขที่ใบเสร็จรับเงิน/ใบกำกับภาษี</th>
												<th>จำนวนเงินที่ชำระ</th>
												<th>สถานะการรับชำระ</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
									<table class="table hidden" id="showResultTableRQ">
										<thead>
											<tr align="center">
												<th>เลขที่ใบแจ้งค่าใช้บริการ</th>
												<th>วันที่จัดทำใบแจ้งค่าใช้บริการ</th>
												<th>วันที่ครบกำหนด</th>
												<th>ยอดก่อนภาษี</th>
												<th>ภาษีมูลค่าเพิ่ม</th>
												<th>ยอดเงินรวมภาษี</th>
												<th>บอดชำระ</th>
												<th>ภาษีหัก ณ ที่จ่าย</th>
												<th>จำนวนเงินคงค้าง</th>
												<th>รอบการใช้งาน</th>
											</tr>
										</thead>
										<tbody>

										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
	</form>
</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>
