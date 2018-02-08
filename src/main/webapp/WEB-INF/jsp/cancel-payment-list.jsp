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
	
<script type="text/javascript"
	src="${contextPath}/resources/js/cancel-payment.js"></script>
<title>Menu</title>

</head>
<body>
	<header class="header_page"></header>
	<!-- main panel -->
	<div  style="padding: 30px 10px 50px 50px">
		<h1 class="page-header"></h1>
		<ul class="list-inline">
			<li id="li1">ค้นหาข้อมูลการชำระบริการ</li> >>
			<li id="li2">ระบุเหตุผลการยกเลิกชำระ</li> >>
			<li id="li3">สรุปการยกเลิกชำระ</li> >>
			<li id="li4">ผลการยกเลิกการชำระ</li>
		</ul>
		<div class="panel" id="panel1">
			<div class="panel-heading">ค้นหาข้อมูล</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-6">
						<label class="col-md-4 control-label text-right">เลขที่ใบแจ้งค่าบริการ</label>
						<div class="col-md-6">
							<input type="text" id="billNumber" class="form-control text-left">
						</div>
					</div>
					<div class="form-group col-md-6">
						<label class="col-md-4 control-label text-right">เลขที่ใบเสร็จรับเงิน</label>
						<div class="col-md-6">
							<input type="text" id="receiptNumber" class="form-control">
						</div>
					</div>
				</div>

			</div>
			
			<div class="box-footer">
				<div class="row">
					<!-- Button -->
					<div class="col-md-12 text-center">
						<button id="search" name="search" class="btn btn-primary">Search</button>
						<button id="clear" name="clear" class="btn btn-danger">Clear</button>
					</div>
				</div>
			</div>
			
			
			<div class="row">
				<div class="col-md-12">
					<div class="box box-solid">
						<!--<div class="box-header"></div>
						 /.box-header -->
						<div class="box-body">
							<table id="example" class="table table-bordered" cellspacing="0" width="100%">
						        <tr>
						    <thead>
						         	<th style="text-align: center;">#</th>  				                         
					                <th style="text-align: center;">เลขที่ใบเสร็จรับเงิน</th>
					                <th style="text-align: center;">วันที่ออกใบเสร็จ</th>
					                <th style="text-align: center;">วันที่ทำรายการ</th>
					                <th style="text-align: center;">เลขที่ลูกค้า</th>
					                <th style="text-align: center;">ชื่อลูกค้า</th>
					                <th style="text-align: center;">วิธีการชำระ</th>
					                <th style="text-align: center;">จำนวนเงิน</th>
					                <th style="text-align: center;">สถานที่รับชำระ</th>
					                <th style="text-align: center;">ผู้รับชำระ</th>
					                <th style="text-align: center;">สถานนะ</th>
					                <th style="text-align: center;"></th>
					                
						        </tr>
						    </thead>
						</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-primary" id="panel2">
			<div class="panel-heading">ระบุเหตุผลการยกเลิกชำระ</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-5">
						<label class="col-md-4 control-label text-right">เลขที่ใบแจ้งค่าบริการ</label>
						<div class="col-md-8">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group col-md-5">
						<label class="col-md-4 control-label text-right">เลขที่ใบแจ้งค่าบริการ</label>
						<div class="col-md-8">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group col-md-2">
						<button id="search" name="search" class="btn btn-primary">Search</button>
						<button id="clear" name="clear" class="btn btn-danger">Clear</button>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-primary" id="panel3">
			<div class="panel-heading">สรุปการยกเลิกชำระ</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-5">
						<label class="col-md-4 control-label text-right">เลขที่ใบแจ้งค่าบริการ</label>
						<div class="col-md-8">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group col-md-5">
						<label class="col-md-4 control-label text-right">เลขที่ใบแจ้งค่าบริการ</label>
						<div class="col-md-8">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group col-md-2">
						<button id="search" name="search" class="btn btn-primary">Search</button>
						<button id="clear" name="clear" class="btn btn-danger">Clear</button>
					</div>
				</div>
			</div>
		</div>

		<div class="panel panel-primary" id="panel4">
			<div class="panel-heading">ผลการยกเลิกการชำระ</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-5">
						<label class="col-md-4 control-label text-right">เลขที่ใบแจ้งค่าบริการ</label>
						<div class="col-md-8">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group col-md-5">
						<label class="col-md-4 control-label text-right">เลขที่ใบแจ้งค่าบริการ</label>
						<div class="col-md-8">
							<input type="text" class="form-control">
						</div>
					</div>
					<div class="form-group col-md-2">
						<button id="search" name="search" class="btn btn-primary">Search</button>
						<button id="clear" name="clear" class="btn btn-danger">Clear</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>
