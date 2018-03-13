<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp"></jsp:include>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/maximus.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></script>
<script src="js/report-payment.js"></script>
<title>รานงานการชำระ</title>

</head>

<body>
	<header class="header_page"></header>
		
		<!-- main panel -->
		<div style="padding: 30px 10px 50px 50px">
			<h1 class="page-header"></h1>
			<div class="panel" id="panel1">
				<div class="panel-heading">ค้นหาการงานการชำระเงิน</div>
				<input type="hidden" name="userName" id="userName" value="${pageContext.request.userPrincipal.name}"/>
				<div class="panel-body">
					<div class="row">
						<div class="form-group col-md-6">
							<label class="col-md-2 control-label text-right">วันที่ชำระ :</label>
							<div class="col-md-10">
								<div class='col-md-6'>
									<input type='date' class="form-control" id="dateFrom" name="dateFrom"/>
								</div>
								<div class="col-md-3">
									<select class="form-control" name="dateFromHour" id="dateFromHour">
										<option value="00">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
									</select>
									
								</div>
								<div class="col-md-3">
									<select class="form-control" name="dateFromMinute" id="dateFromMinute">
										<option value="00">00</option>
										<option value="15">15</option>
										<option value="30">30</option>
										<option value="45">45</option>
										<option value="59">59</option>
									</select>
								</div>
								
							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="col-md-2 control-label text-right">ถึงวันที่ :</label>
							<div class="col-md-10">
								<div class='col-md-6'>
									<input type='date' class="form-control" id="dateTo" name="dateTo"/>
								</div>
								<div class="col-md-3">
									<select class="form-control" name="dateToHour" id="dateToHour">
										<option value="00">00</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
										<option value="13">13</option>
										<option value="14">14</option>
										<option value="15">15</option>
										<option value="16">16</option>
										<option value="17">17</option>
										<option value="18">18</option>
										<option value="19">19</option>
										<option value="20">20</option>
										<option value="21">21</option>
										<option value="22">22</option>
										<option value="23">23</option>
									</select>
								</div>
								<div class="col-md-3">
									<select class="form-control" name="dateToMinute" id="dateToMinute">
										<option value="00">00</option>
										<option value="15">15</option>
										<option value="30">30</option>
										<option value="45">45</option>
										<option value="59">59</option>
									</select>
								</div>
								
							</div>
						</div>
	
					</div>
					<div class="row">
						<div class="form-group col-md-6">
							<label class="col-md-2 control-label text-right">รหัสบัญชี:</label>
							<div class="col-md-10">
								<input type="text" id="accountId" name="accountId" value="${pageContext.request.userPrincipal.name}" class="form-control" disabled/>
							</div>

						</div>
						<div class="form-group col-md-6">
							<div class="col-md-6">
								<label class="col-md-4 control-label text-right">Vat Rate:</label>
								<div class="col-md-8">
									<select class="form-control" id="vat" name="vat">
										<option value="">-- กรุณาเลือก --</option>
										<option value="0">0%</option>
										<option value="7">3%</option>
										<option value="3">7%</option>
									</select>
								</div>
							</div>
							<div class="col-md-6">
								<label class="col-md-5 control-label text-right">ประเภทการรับชำระ:</label>
								<div class="col-md-7">
									<select class="form-control" id="serviceType" name="serviceType">
										<option value="">-- กรุณาเลือก  --</option>
										<option value="IBASS">ค่าบริหาร (Billing)</option>
										<option value="etc">ค่าบริการอื่น ๆ</option>
									</select>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-6">
							<label class="col-md-2 control-label text-right">เครื่องที่รับชำระ:</label>
							<div class="col-md-10">
								<input type="text" id="machinePaymentName" name="machinePaymentName" value="ศูนย์บริการลูกค้า นนทบุรี" class="form-control" disabled/>
							</div>
						</div>
						
						<div class="form-group col-md-6">
							<label class="col-md-2 control-label text-right">เจ้าหน้าที่:</label>
							<div class="col-md-10">
								<input type="text" id="authorities" name="authorities" value="${pageContext.request.userPrincipal.name}" class="form-control" disabled/>
							</div>
						</div>
					</div>
				</div>
	
				<div class="box-footer" style="padding-bottom: 20px">
					<div class="row">
						<!-- Button -->
						<div class="col-md-12 text-center">
							<button id="search" name="search" class="btn btn-primary" style="width: 7%" onclick="search()">ค้นหา</button>
	
							<button id="clear" name="clear" class="btn btn-danger" style="width: 7%" onclick="clearCriteria()">ลบ</button>
						</div>
					</div>
				</div>
				<form id="paymentFrom" method="post" class="form-horizontal" role="form">
					<input type="hidden" name="dateFromHidden" id="dateFromHidden">
					<input type="hidden" name="dateToHidden" id="dateToHidden">
					<input type="hidden" name="machinePaymentNameHidden" id="machinePaymentNameHidden">
					<input type="hidden" name="accountIdHidden" id="accountIdHidden">
					<input type="hidden" name="authoritiesHidden" id="authoritiesHidden">
					<div class="row" style="padding-bottom: 10px;padding-right: 2px">
						<div class="col-md-12 text-right">
							<button  class="btn btn-warning glyphicon glyphicon-print" style="width: 7%" onclick="printReportPDF()"> PDF</button>
							<button  class="btn btn-success glyphicon glyphicon-print" style="width: 7%" onclick="printReport()"> Excel</button>
						</div>
					</div>
				</form>
	
	
				<div class="row">
					<div class="col-md-12">
						<div class="box box-solid">
							<!--<div class="box-header"></div>
							 /.box-header -->
							<div class="box-body">
								<table id="reportPaymentTb" class="table table-bordered" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th style="text-align: center;">ลำดับที่</th>
											<th style="text-align: center;">ประเภทค่าบริการ</th>
											<th style="text-align: center;">เลขที่ใบเสร็จ/ใบกำกับภาษี</th>
											<th style="text-align: center;">เลขที่สัญญา</th>
											<th style="text-align: center;">ชื่อผู้ซื้อสินค้า/ผู้รับบริการ</th>
											<th style="text-align: center;">หน่วยติดตามหนี้</th>
											<th style="text-align: center;">เลขที่ใบแจ้งค่าบริการ/ชื่อบริการ</th>
											<th style="text-align: center;">ชำระโดย</th>
											<th style="text-align: center;">เลขที่อ้างอิง</th>
											<th style="text-align: center;">ยอดเงินก่อนภาษี</th>
											<th style="text-align: center;">ภาษีมูลค่าเพิ่ม</th>
											<th style="text-align: center;">จำนวนเงินรวม</th>
											<th style="text-align: center;">สถานะ</th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	


</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>
