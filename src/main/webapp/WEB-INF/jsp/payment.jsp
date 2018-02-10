<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp"></jsp:include>

<html>
<head>
<script src="lib/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<title>Payment</title>
<script type="text/javascript" src="js/typeahead.bundle.js"></script>
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

				<div class="row" style="margin-top: 20px;">
					<div class="col-md-12 col-sm-12">
						<div class="form-group">
							<div class="col-md-12 col-sm-12">
								<div class="panel">
									<div class="panel-heading">เพิ่มใบรับชำระค่าบริการ</div>
									<div class="panel-body">
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ชื่อ:</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="custName" name="custName" placeholder="ชื่อ">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">เลขที่ลูกค้า :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="custNo" name="custNo" placeholder="เลขที่ลูกค้า">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">Tax ID :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="taxId" name="taxId" placeholder="Tax ID">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ที่อยู่ :</label>
												<div class="col-sm-7">
													<textarea class="form-control" rows="3" id="custAddress" name="custAddress"></textarea>
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">สาขา :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="custBrach" name="custBrach" placeholder="สาขา">

												</div>
												<div class="col-sm-4"></div>
												<div class="col-sm-4"></div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">กลุ่มผู้ใช้บริการ :</label>
												<div class="col-sm-3">
													<select class="form-control" id="userGroup" name="userGroup">
														<option>== เลือก ==</option>
														<option>ธุรกิจทั่วไป</option>
														<option>บุคคลธรรดา</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
													</select>
												</div>
											</div>

										</div>
										<div class="row">
											<div class="form-group left">
												<div class="col-sm-8"></div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">หน่วยงานติดตามหนี้ :</label>
												<div class="col-sm-3">
													<input type="text" id="typeahead" class="form-control"
														style="width: 235%;" placeholder="หน่วยงานติดตามหนี้" name="debtCollection ">

												</div>
											</div>
										</div>
										<hr>
										<div class="row">
										<div class="col-sm-4"></div>
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">เลขที่ใบแจ้ง :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="invoiceNo" name="invoiceNo" placeholder="เลขที่ใบแจ้ง">

												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">หมายเลขบริการ :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="serviceNo" name="serviceNo" placeholder="หมายเลขบริการ">
												</div>

											</div>
										</div>
										<div class="row">
										<div class="col-sm-4"></div>
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">รอบการใช้งานเริ่มต้น :</label>
												<div class="col-sm-3">
													<input class="form-control" type="date" id="startupDate" name="startupDate">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">รอบการใช้งานสิ้นสุด :</label>
												<div class="col-sm-3">
													<input class="form-control" type="date" id="endDate" name="endDate">
												</div>
											</div>
										</div>
										<div class="row">
										<div class="col-sm-4"></div>
											<div class="form-group">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">วันครบกำหนด :</label>
												<div class="col-sm-3">
													<input class="form-control" type="date" id="deadlines" name="deadlines">
												</div>
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">วันจัดทำใบแจ้งค่าใช้บริการ
													:</label>
												<div class="col-sm-3">
													<input class="form-control" type="date" id="invoiceDate" name="invoiceDate">
												</div>
											</div>
										</div>
										<div class="row">
										<div class="col-sm-4"></div>
											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">สถานะลูกค้า :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="custStatus" name="custStatus" placeholder="ปกติ"
														readonly="readonly">
												</div>
											</div>
										</div>
										<hr>
										<div class="row">
										<div class="col-sm-8"></div>
											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">VAT RATE :</label>
												<div class="col-sm-3">
													<select class="form-control" id="vatrate" name="vatrate">
														<option value="">0%</option>
														<option value="7">7%</option>
														<option value="8">8%</option>
														<option value="9">9%</option>
														<option value="10">10%</option>
													</select>
												</div>
											</div>
										</div>
										<div class="row">
										<div class="col-sm-8"></div>
											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ยอดก่อนภาษี :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="balanceBeforeTax" name="balanceBeforeTax" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
										<div class="col-sm-8"></div>
											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ภาษีมูลค่าเพิ่ม :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="vat" name="vat" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
										<div class="col-sm-8"></div>
											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">จำนวนเงินรวมภาษี :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="balanceOfTax" name="balanceOfTax" readonly="">

												</div>
											</div>
										</div>
										<div class="row">
										<div class="col-sm-8"></div>
											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">ยอดชำระ :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text"
														id="balanceSummary" name="balanceSummary" readonly="">
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
									<div class="panel-heading">
										รายการหัก <select class="form-control"
											style="display: inline; width: 30%; padding-left: 20px">
											<option>ภาษีหัก ณ ที่จ่าย</option>
										</select>
									</div>
									<div class="panel-body">
									<input name="paymentTax.invoiceNo" id="invoiceNoTax" type="hidden">
										<div class="row">
											<div class="form-group">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">ประเภทภาษีหัก ณ ที่จ่าย :</label>
												<div class="col-sm-6">
													<label> <input type="radio" name="paymentTax.radioDed"
														id="radioDedCD" value="CD" checked> 69 ทวิ
													</label> <label> <input type="radio" name="paymentTax.radioDed"
														id="radioDedCC" value="CC"> 3 เดรส
													</label> <label> <input type="radio" name="paymentTax.radioDed"
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
													<input class="form-control" type="text" id="docDed" name="paymentTax.docDed"
														placeholder="เลขที่เอกสาร">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group ">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">จำนวนเงิน :</label>
												<div class="col-sm-6">
													<input class="form-control" type="text" id="moneyDed" name="paymentTax.moneyDed"
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
													<table class="table table-striped" id="deductibleTable">
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
									<div class="panel-heading">
										วิธีการรับชำระ <select class="form-control" id="typePayment" name="typePayment"
											onchange="findTypePayment()"
											style="display: inline; width: 30%; padding-left: 20px">
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
															placeholder="จำนวนเงิน" id="moneyTran" name="moneyTran">
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
														<select class="form-control" id="creditType" 
															name="creditType">
															<option value="">กรุณาเลือก</option>
															<option value="visa">VISA</option>
															<option value="masterCard">MASTER-CARD</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">เลขที่บัตร:</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="creditNo"
															name="creditNo" placeholder="เลขที่บัตร">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ธนาคารเจ้าของเครื่อง
														(EDC):</label>
													<div class="col-sm-4">
														<select class="form-control" id="edcType" name="edcType">
															<option value="">กรุณาเลือก</option>
															<option value="paypal">Paypal</option>
															<option value="7Eleven">7-Eleven</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวเนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="creditPrice"
															name="creditPrice" placeholder="จำนวเนเงิน">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12 right">
														<button type="button" class="btn btn-warning"
															onclick="addDataTablecreditTranPrice()">
															<span class="glyphicon glyphicon-plus">เพิ่มรายการบัตรเครดิต</span>
														</button>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12">
														<table class="table" id="creditTable">
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
														<select class="form-control" id="bankNo" name="bankNo"
															onchange="findBank()">
															<option value="">กรุณาเลือก</option>
															<option value="001">001</option>
															<option value="002">002</option>
															<option value="003">003</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">เลขที่เช็ค:</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="checkNo"
															name="checkNo" placeholder="เลขที่เช็ค">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ชื่อธนาคาร :</label>
													<div class="col-sm-4">
														<select class="form-control" id="bankName" name="bankName"
															onchange="findBankNo()">
															<option value="">กรุณาเลือก</option>
															<option value="ktb">ธนาคารกรุงไทย</option>
															<option value="scb">ธนาคารไทยพานิชย์</option>
															<option value="kbk">ธนาคารกสิกรไทย</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">วันที่หน้าเช็ค :</label>
													<div class="col-sm-4">
														<input class="form-control" type="date" id="dateCheck" name="dateCheck">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">สาขา :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="branchCheck"
															name="branchCheck" placeholder="สาขา">
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="moneyCheck" name="moneyCheck"
															placeholder="จำนวนเงิน">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12 right">
														<button type="button" class="btn btn-warning"
															onclick="addDataTableCheck()">
															<span class="glyphicon glyphicon-plus">เพิ่มรายการเช็ค</span>
														</button>
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<div class="col-sm-12">
														<table class="table" id="checkTable">
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
															</tbody>
														</table>
													</div>
												</div>
											</div>
										</div>




										<div class="row">
											<div class="form-group">
												<div class="col-sm-12 right">
													<button type="button" class="btn btn-primary"
														onclick="sumTranPrice()">
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
										<div style="display: none">
											<table id="sumDeductibleTable">
												<tbody></tbody>
											</table>
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
										<div style="display: none">
											<table id="sumTotalPriceTable">
												<tbody></tbody>
											</table>
										</div>
										<table class="table" id="showTotalPriceTable">

											<thead>
												<tr>
													<th>#</th>
													<th>วิธีการชำระเงิน</th>
													<th>จำนวนเงิน</th>
													<th></th>
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

			</div>

		</form>
	</div>

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>