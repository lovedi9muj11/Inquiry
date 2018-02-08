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
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/maximus.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"></script>
	
<script src="js/histrory-payment.js" type="text/javascript"></script>
<title>Menu</title>

</head>
<body>
	<header class="header_page"></header>
	<!-- main panel -->
	<div  style="padding: 30px 10px 50px 50px">
		<h1 class="page-header"></h1>
		<div class="panel" id="criteriaHistroryPM">
			<div class="panel-heading">ค้นหาข้อมูล</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-4 control-label text-right">เลขที่ลูกค้า(Billing Account)]</label>
						<div class="col-md-4">
							<input type="text" id="billNumber" class="form-control text-left">
						</div>
					</div>
				</div>

			</div>
			
			<div class="box-footer">
				<div class="row" style="padding-bottom:10px">
					<!-- Button -->
					<div class="col-md-12 text-center">
						<button id="search" name="search" class="btn btn-primary">Search</button>
						<button id="clear" name="clear" class="btn btn-danger">Clear</button>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<div class="panel" id="dataHistroryPM">
			<div class="panel-heading">ข้อมูลลูกค้า</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">เลขที่ลูกค้า : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-8">
						<label class="col-md-4 control-label text-right">ชื่อลูกค้า : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">Tax ID : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">สาขา : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">หน่วยงานติดตามหนี้ : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">กลุ่มผู้ใช้บริการ : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">เลขที่ e-GP : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">ยอดค้างชำระ (รวม  VAT) : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">Billing Group : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">เลขที่สัญญษ (บช.1) : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">ยอดชำระล่วงหน้า: </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">สถานะลูกค้า : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
					<div class="form-group col-md-4">
			
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">สกุลเงิน : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
				</div>
				
				<div class="row">
					<div class="form-group col-md-4">						
					</div>
					<div class="form-group col-md-4">
					</div>
					<div class="form-group col-md-4">
						<label class="col-md-4 control-label text-right">VAT Rate : </label>
						<div class="col-md-8">
							<input type="text" id="billNumber" class="form-control text-left" disabled>
						</div>
					</div>
				</div>

			</div>
		</div>
		
		<div class="panel" id="addressCustomerPM">
			<div class="panel-heading">ที่อยู่ลูกค้า</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-12">
						<textarea class="form-control" id="addressCustomer" rows="3" disabled></textarea>
					</div>
				</div>
			</div>
		</div>
		
		<div class="panel" id="addressCustomerPM">
			<div class="panel-heading">ประวัติการชำระ</div>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="box box-solid">
						<!--<div class="box-header"></div>
						 /.box-header -->
						<div class="box-body">
							<table id="histroryPaymentTB" class="table table-bordered" cellspacing="0" width="100%">
						    <thead>
						        <tr>
						         	<th style="text-align: center;">#</th>  				                         
					                <th style="text-align: center;">วันที่ทำรายการ</th>
					                <th style="text-align: center;">วันที่ออกใบเสร็จรับเงิน</th>
					                <th style="text-align: center;">เลขที่ใบเสร็๗รับเงิน</th>
					                <th style="text-align: center;">สถานที่รับชำระ</th>
					                <th style="text-align: center;">ผู้รับชำระ</th>
					                <th style="text-align: center;">เลขที่ใบแจ้งค่าใช้บริการ</th>
					                <th style="text-align: center;">รอบการใช้งาน</th>
					                <th style="text-align: center;">ยอดเงินตามใบแจ้งค่าบริการ</th>
					                <th style="text-align: center;">วิธีการรับชำระ</th>
					                <th style="text-align: center;">ประเภทการรับชำระ</th>
					                <th style="text-align: center;">ยอดชำระ</th>
					                <th style="text-align: center;">ภาษีมูลค่าเพิ่มจากการรับชำระ</th>
					                <th style="text-align: center;">สถานนะ</th>
					                <th style="text-align: center;">หมายเหตุ</th>
					                
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
