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
<script type="text/javascript"
	src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
<script src="js/userMgt.js"></script>
<title>Menu</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<header class="header_page"></header>

	<!-- main panel -->
	
	 <div id="page-content-wrapper"> 
		<!-- 		<div id="header-wrapper"> -->
		<br />
		
		 <div class="container-fluid">
		 <ul class="list-inline pull-right">
        <li><a href="#"><span class="glyphicon glyphicon-edit"></span> การรับชำระ</a></li>
    	</ul>
				<div class="panel panel-primary ">
				<div class="panel-heading">เพิ่มใบเสร็จ1</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-sm-2">ชื่อ:</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>
										<label class="control-label col-sm-2">เลขที่ลูกค้า :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>
										<label class="control-label col-sm-2">TaxNo :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>

									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">ที่อยู่ :</label>
										<div class="col-sm-6">
											<textarea id="#" class="form-control text-right"></textarea>
										</div>
										<label class="control-label col-sm-2">สาขา :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>
										<label class="control-label col-sm-2">กลุ่มผู้ใช้บริการ
											:</label>
										<div class="col-sm-2" id="serviceDepartmentDiv" style="margin-top: 10px;">
											<select id="#" class="form-control"></select>
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">เลขที่ใบแจ้ง:</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>
										<label class="control-label col-sm-2">หมายเลขบริการ :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>
										<label class="control-label col-sm-2">ยอดก่อนภาษี :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>

									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">ภาษามูลค่าเพิ่ม
											:</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>
										<label class="control-label col-sm-2">จำนวนเงินรวมภาษี
											:</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>
										<label class="control-label col-sm-2">ยอดชำระ :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right">
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">รอบการใช้งานเพิ่ม
											:</label>
										<div class="col-sm-2">
											<input type="date" class="form-control ">
										</div>
										<label class="control-label col-sm-2">รอบการใช้งานสิ้นสุด
											:</label>
										<div class="col-sm-2">
											<input type="date" class="form-control ">
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">วันครบกำหนด :</label>
										<div class="col-sm-2">
											<input type="date" class="form-control ">
										</div>
										<label class="control-label col-sm-2">วันจัดทำใบแจ้งค่าบริการ
											:</label>
										<div class="col-sm-2">
											<input type="date" class="form-control ">
										</div>

									</div>

									<div class="form-group">
										<label class="control-label col-sm-2">สถานะ :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right" disabled>
										</div>
										<label class="control-label col-sm-2">Vat Rate :</label>
										<div class="col-sm-2">
											<input id="#" class="form-control text-right" disabled>
										</div>

									</div>

								</div>
							</div>
						</div>
					</div>
				</div>

			<div class="row">
			
				<div class="col-md-5">
					<div class="panel panel-primary ">
					<div class="panel-heading">รายการหัก
					<div id=# class="btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<span class="selection">ภาษีหัก ณ ที่จ่าย</span> <span
							class="caret"></span>
					</button>
					<ul class="dropdown-menu" id='#'>
						<li><a href="#">ภาษีหัก ณ ที่จ่าย</a></li>
						<!-- GFMIS -->
						<li><a href="#">ค่าธรรมเนียม</a></li>
						<li><a href="#">ค่าปรับ</a></li>
						<li><a href="#">เงินประกันผลงาน</a></li>
						<li><a href="#">ค่าตอบแทนการรับชำระเงิน</a></li>
					</ul>
				</div>
								
					</ul>
					</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-horizontal">
										<div class="form-group">
										<label class="control-label col-sm-6">ประเภทภาษีหัก ณ
											ที่จ่าย :</label>
										<div class="col-sm-6">
											<label class="radio-inline"><input type="radio"
												name="withholdingTaxType" data-label="69 ทวิ"
												data-type="69BIS" id="69tvi"><b> 69 ทวิ</b></label>&nbsp;&nbsp;
											<label class="radio-inline"><input type="radio"
												name="withholdingTaxType" data-label="3 เตรส"
												data-type="3TREDECIM" id="3trs"><b> 3 เตรส</b></label>&nbsp;&nbsp;
											<label class="radio-inline"><input type="radio"
												name="withholdingTaxType" data-label="69 ตรี"
												data-type="69TRE" id="69tri"><b> 69 ตรี</b></label>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-6">เลขที่เอกสาร :</label>
										<div class="col-sm-5">
											<input id="#" type="text" class="form-control">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-6">จำนวนเงิน :</label>
										<div class="col-sm-5">
											<input id="#" class="form-control text-right">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-6"></label>
										<div class="col-sm-5">
											<a id="#" class="btn btn-link"><span
												class="glyphicon glyphicon-th-list"></span>
												เพิ่มรายการภาษีหัก ณ ที่จ่าย</a>
										</div>
									</div>

									</div>
									<table id="#" class="table table-hover">
									<thead>
										<tr>
											<th data-running-no="true">#</th>
											<th>เลขที่ใบแจ้งค่าใช้บริการ</th>
											<th>เลขที่เอกสาร</th>
											<th>ประเภทหัก ณ ที่จ่าย</th>
											<th data-align="right" data-number-format="true">จำนวนเงิน</th>
											<th></th>
										</tr>
									</thead>
								</table>
								<a class="btn btn-primary pull-right" id="addPayType"
								style="margin-top: 1em"><span
								class="glyphicon glyphicon-plus-sign"></span>
								เพิ่มรายการหัก</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-md-7">
					
					<div class="panel panel-primary ">
					<div class="panel-heading">วิธีการรับชำระเงิน
					<div id="#" class=" btn-group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<span class="selection">เงินสด</span> <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" id='#'>
						<li><a href="#">เงินสด</a></li>
						<li><a href="#">เช็ค</a></li>
						<li><a href="#">บัตรเครดิต</a></li>
						<li><a href="#">ธนาณัติ</a></li>
						<li><a href="#">ตั๋วแลกเงิน</a></li>
						<li><a href="#">คูปอง</a></li>
						<li><a href="#">เงินโอนในประเทศ</a></li>
						<li><a href="#">offset</a></li>
						<li><a href="#">เงินโอนต่างประเทศ</a></li>
						<li><a href="#">อื่น ๆ</a></li>
						<li><a href="#">GFMIS</a></li>
					</ul>
				</div>
					</ul>
					</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<div class="form-horizontal">
										<div class="form-group">
											<label class="control-label col-sm-8">จำนวนเงิน :</label>
											<div class="col-sm-4">
												<input id="#" class="form-control text-right">
											</div>
										</div>
										
										
										<a class="btn btn-primary pull-right" id="addPayType"
								style="margin-top: 1em"><span
								class="glyphicon glyphicon-plus-sign"></span>
								เพิ่มวิธีการรับชำระ</a>
										
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
			
				<div class="col-md-5">
					<div class="panel panel-primary">
						<div class="panel-heading">สรุปรายการหัก</div>
						<div class="panel-body">
							<table id="deductionList" class="table table-hover">
								<thead>
									<tr>
										<th data-running-no="true">#</th>
										<th>รายการหัก</th>
										<th data-align="right" data-number-format="true"
											class="text-right">จำนวนเงิน</th>
										<th></th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</div>
				
				<div class='col-md-7'>
					<div class="panel panel-primary">
						<div class="panel-heading">สรุปวิธีการรับชำระ</div>
						<div class="panel-body">
							<table id="payTypeList" class="table table-hover">
								<thead>
									<tr>
										<th data-running-no="true">#</th>
										<th>วิธีการรับชำระ</th>
										<th data-align="right" data-number-format="true"
											class="text-right">จำนวนเงิน</th>
										<th></th>
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
