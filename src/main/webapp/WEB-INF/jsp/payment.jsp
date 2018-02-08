<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp"></jsp:include>

<html>
<head>
<script src="lib/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<title>Payment</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="css/payment.css" rel="stylesheet">
<script src="js/payment.js"></script>
</head>
<body>
	<div class="container-fluid">

		<form name="paymentFrom" method="post" action="#">
			<div id="page-content-wrapper">
				<nav class="navbar navbar-default">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">รับชำระค่าบริการ ></a></li>
						<li><a href="#">ผลการรับชำระ </a></li>
					</ul>
				</div>
				</nav>
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<div class="form-group" align="right">
							<div class="col-md-12 col-sm-12">
								<a><span class="glyphicon glyphicon-share">ดำเนินการรับชำระ</span></a>
							</div>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: 20px;" >
					<div class="col-md-12 col-sm-12">
						<div class="form-group">
							<div class="col-md-12 col-sm-12">
								<div class="panel">
									<div class="panel-heading">เพิ่มใบเสร็จ

									</div>
									<div class="panel-body">
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ชื่อ:</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="ชื่อ">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">เลขที่ลูกค้า :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="เลขที่ลูกค้า">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">Tax No :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="Tax No">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ที่อยู่ :</label>
												<div class="col-sm-7">
													<textarea class="form-control" rows="3"></textarea>
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">สาขา :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="สาขา">

												</div>
												<div class="col-sm-4"></div>
												<div class="col-sm-4"></div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">กลุ่มผู้ใช้บริการ :</label>
												<div class="col-sm-3">
													<select class="form-control">
														<option>ธุรกิจทั่วไป</option>
														<option>บุคคลธรรดา</option>
														<option>เจ้าของธุรกิจ</option>
													</select>
												</div>
											</div>

										</div>
										<div class="row"></div>
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">เลขที่ใบแจ้ง :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="เลขที่ใบแจ้ง">

												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">หมายเลขบริการ :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="หมายเลขบริการ">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ยอดก่อนภาษี :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="ยอดก่อนภาษี ">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ภาษีมูลค่าเพิ่ม :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="ภาษีมูลค่าเพิ่ม">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">จำนวนเงินรวมภาษี :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="สาขา">

												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ยอดชำระ :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="ยอดชำระ">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">รอบการใช้งาน :</label>
												<div class="col-sm-3">
													<input class="form-control" type="date">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">รอบการใช้งานสิ้นสุด :</label>
												<div class="col-sm-3">
													<input class="form-control" type="date">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">วันครบกำหนด :</label>
												<div class="col-sm-3">
													<input class="form-control" type="date">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">วันจัดทำใบแจ้งค่าใช้บริการ
													:</label>
												<div class="col-sm-3">
													<input class="form-control" type="date">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">สถานะลูกค้า :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="ปกติ"
														readonly="readonly">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">VAT RATE :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="formGroupInputLarge" placeholder="7"
														readonly="readonly">
												</div>
											</div>
										</div>


									</div>
								</div>
							</div>

						</div>
					</div>

				</div>
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="form-group">
							<div class="col-md-12 col-sm-12">
								<div class="panel">
									<div class="panel-heading" > รายการหัก													
										<select class="form-control" style="display: inline;width: 30%;padding-left: 20px">
												<option>ภาษีหัก ณ ที่จ่าย</option>
										</select>																		
									</div>
									<div class="panel-body">
										<div class="row">
											<div class="form-group">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">ประเภทภาษีหัก ณ ที่จ่าย :</label>
												<div class="col-sm-6">
													<label> <input type="radio" name="radioDed"
														id="radioDedCD" value="CD" checked> 69 ทวิ
													</label> <label> <input type="radio" name="radioDed"
														id="radioDedCC" value="CC"> 3 เดรส
													</label> <label> <input type="radio" name="radioDed"
														id="radioDedCT" value="CT"> 69 ดริ
													</label>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group ">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">เลขที่เอกสาร :</label>
												<div class="col-sm-6">
													<input class="form-control" type="text" id="docDed"
														placeholder="เลขที่เอกสาร">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group ">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">จำนวนเงิน :</label>
												<div class="col-sm-6">
													<input class="form-control" type="text" id="moneyDed"
														placeholder="จำนวนเงิน">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<div class="col-sm-10 right">
													<a onclick="addRow()" id="addRow"><span
														class="glyphicon glyphicon-th-large">เพิ่มรายการภาษีหัก
															ณ ที่จ่าย</span></a>
												</div>

											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<div class="col-sm-12">
													<table class="table table-striped" id="deductibleTable" >
														<thead>
															<tr>
																<th>#</th>
																<th>เลขที่ใบแจ้งค่าใช้บริการ</th>
																<th>เลขที่เอกสาร</th>
																<th>ประเภทหัก ณ ที่จ่าย</th>
																<th>จำนวนเงิน</th>
															</tr>
														</thead>
														<tbody>

														</tbody>
													</table>
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<div class="col-sm-12 right">
													<button type="button" class="btn btn-primary"
														onclick="addDataTableDed()">
														<span class="glyphicon glyphicon-plus">เพิ่มรายการหัก</span>
													</button>
												</div>
											</div>
										</div>



									</div>
								</div>
							</div>


						</div>
					</div>
					<div class="col-md-6 col-sm-6">
						<div class="form-group">
							<div class="col-md-12 col-sm-12">
								<div class="panel">
									<div class="panel-heading">วิธีการรับชำระ
										<select class="form-control" id="typePayment" onchange="findTypePayment()" style="display: inline;width: 30%;padding-left: 20px">
												<option value="money">เงินสด</option>
												<option value="credit">บัตรเครดิต</option>
												<option value="check">เช็ค</option>
										</select>
									</div>
									<div class="panel-body">
										<div id="money">
											<div class="row">
												<div class="form-group">
													<label class="col-sm-8 control-label right"
														for="formGroupInputLarge">จำนวนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text"
															id="formGroupInputLarge" placeholder="จำนวนเงิน">
													</div>

												</div>
											</div>
										</div>
										<div id="credit">
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ประเภทของบัตรเครดิต:</label>
													<div class="col-sm-4">
														<select class="form-control">
															<option>กรุณาเลือก</option>
															<option>VISA</option>
															<option>MASTER-CARD</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">เลขที่บัตร:</label>
													<div class="col-sm-4">
														<input class="form-control" type="text"
															id="formGroupInputLarge" placeholder="เลขที่บัตร">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ธนาคารเจ้าของเครื่อง
														(EDC):</label>
													<div class="col-sm-4">
														<select class="form-control">
															<option>กรุณาเลือก</option>
															<option>VISA</option>
															<option>MASTER-CARD</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวเนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text"
															id="formGroupInputLarge" placeholder="จำนวเนเงิน">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12 right">
														<button type="button" class="btn btn-warning">
															<span class="glyphicon glyphicon-plus">เพิ่มรายการบัตรเครดิต</span>
														</button>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12">
														<table class="table">
															<thead>
																<tr>
																	<th>#</th>
																	<th>ประเภทบัตรเครดิต</th>
																	<th>เลขที่บัตร</th>
																	<th>EDC</th>
																	<th>จำนวนเงิน</th>
																</tr>
															</thead>
															<tbody>
																<tr></tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>

										<div id="check">
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">รหัสธนาคาร:</label>
													<div class="col-sm-4">
														<select class="form-control">
															<option>กรุณาเลือก</option>
															<option>001</option>
															<option>002</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">เลขที่เช็ค:</label>
													<div class="col-sm-4">
														<input class="form-control" type="text"
															id="formGroupInputLarge" placeholder="เลขที่เช็ค">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ชื่อธนาคาร :</label>
													<div class="col-sm-4">
														<select class="form-control">
															<option>กรุณาเลือก</option>
															<option>ธนาคารกรุงไทย</option>
															<option>ธนาคารไทยพานิชย์</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">วันที่หน้าเช็ค :</label>
													<div class="col-sm-4">
														<input class="form-control" type="date">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">สาขา :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text"
															id="formGroupInputLarge" placeholder="สาขา">
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text"
															id="formGroupInputLarge" placeholder="จำนวนเงิน">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12 right">
														<button type="button" class="btn btn-warning">
															<span class="glyphicon glyphicon-plus">เพิ่มรายการเช็ค</span>
														</button>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12">
														<table class="table">
															<thead>
																<tr>
																	<th>#</th>
																	<th>รหัสธนาคาร</th>
																	<th>ชื่อธนาคาร</th>
																	<th>สาขา</th>
																	<th>เลขที่เช็ค</th>
																	<th>วันที่หน้าเช็ค</th>
																	<th>จำนวนเงิน</th>
																</tr>
															</thead>
															<tbody>
																<tr></tr>
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>




										<div class="row">
											<div class="form-group">
												<div class="col-sm-12 right">
													<button type="button" class="btn btn-primary">
														<span class="glyphicon glyphicon-plus">เพิ่มวิธีการรับชำระ</span>
													</button>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>


						</div>
					</div>
				</div>
				<!-- panel รายการหัก -->
				<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="form-group">
							<div class="col-md-12 col-sm-12">
								<div class="panel">
									<div class="panel-heading" style="background-color: #ee7600;">สรุปรายการหัก</div>
									<div class="panel-body">
									<div style="display:none">
									<table id="sumDeductibleTable"></table>
									</div>
										<table class="table" id="showDeductibleTable">
											<thead>
												<tr align="center">
													<th>#</th>
													<th>รายการหัก</th>
													<th>จำนวนเงิน</th>
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
					<div class="col-md-6 col-sm-6">
						<div class="form-group">
							<div class="col-md-12 col-sm-12">
								<div class="panel">
									<div class="panel-heading" style="background-color: #ee7600;">สรุปวิธีกาชำระเงิน</div>
									<div class="panel-body">
										<table class="table">
											<thead>
												<tr>
													<th>#</th>
													<th>วิธีการชำระเงิน</th>
													<th>จำนวนเงิน</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<tr></tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>

		</form>
	</div>

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>