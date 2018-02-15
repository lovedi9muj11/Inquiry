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
<title>PaymentOther</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="css/payment.css" rel="stylesheet">
<script src="js/paymentother.js"></script>

</head>
<body>
	<header class="header_page"></header>

	<!-- main panel -->
	
	 <div id="page-content-wrapper"> 
	
		<br />
		<div class="row">
		
           <nav class="navbar navbar-default">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">รับชำระค่าบริการอื่นๆ ></a></li>
						<li><a href="#">ผลการรับชำระ </a></li>
					</ul>
				</div>
				</nav>
				<div class="row">
					<div class="col-md-12 col-sm-12">
						<div class="form-group" align="right">
							<div class="col-md-12 col-sm-12">
								<button name="submitFormPayment" type="button"
									id="submitFormPayment" class="btn btn-success btn-lg"
									onclick="submitForm()">
									<span class="glyphicon glyphicon-share"> บันทึกและพิมพ์</span>
								</button>
							</div>
						</div>
					</div>
				</div>
				</div>
				<br/>
		 <div class="container-fluid">
		 
				<div class="panel">
				<div class="panel-heading">ข้อมูลลูกค้า</div>
					<div class="panel-body">
						<div class="row">
                                <div class="col-md-12">
                                    <div class="form-horizontal">
                                        <div class="form-group">
                                            <label class="control-label col-sm-2">เลขที่ลูกค้า :</label>
                                            <div class="col-sm-2"><input id="inputCustomerBillNo" class="form-control" placeholder="เลขที่ลูกค้า"></div>
                                            <label class="control-label col-sm-2">ชื่อลูกค้า :</label>
                                            <div class="col-sm-5"><input id="inputCustomerName" class="form-control" placeholder="ชื่อลูกค้า"></div>
                                            <input type="hidden" id="inputCustomerType">
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-sm-2">Tax ID :</label>
                                            <div class="col-sm-2"><input id="inputCustomerTaxNo" maxlength="13" class="form-control" placeholder="Tax Id"></div>
                                            <label class="control-label col-sm-2">สาขา :</label>
                                            <div class="col-sm-2"><input id="inputCustomerBranch" maxlength="5" class="form-control" placeholder="สาขา"></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-sm-2">กลุ่มผู้ใช้บริการ :</label>
                                            <div class="col-sm-2">
                                                <select class="form-control" id="userGroup"
														name="userGroup">
														<option value="">== เลือก ==</option>
														<option value="01">ธุรกิจทั่วไป</option>
														<option value="02">บุคคลธรรดา</option>
														<option value="03">เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
														<option>เจ้าของธุรกิจ</option>
													</select>
                                            </div>
                                            <label class="control-label col-sm-2">VAT Rate :</label>
                                            <div class="col-sm-1">
                                                <select id="vatrate" class="form-control" >
                                                    <option>7</option>
                                                    <option>3</option>
                                                    <option>0</option>
                                                    <option>Non VAT</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2">ที่อยู่ :</label>
                                            <div class="col-sm-6"><textarea id="inputCustomerAddress" class="form-control" placeholder="ที่อยู่"></textarea></div>
                                            
                                        </div>
                                    </div>
                                </div>
                        
    </div>
					</div>
				</div>
				
				
            <div class="panel">
				<div class="panel-heading">รายการรับชำระ</div>
					<div class="panel-body">
                        <div role="tabpanel" class="tab-pane active" id="tab_1">
                            <div class="form-horizontal">
                                <div class="form-group">
                                    <label class="control-label col-sm-2">ประเภทรายได้ :</label>
                                    <div class="col-sm-2" ><select id="inputCategory" class="form-control"></select></div>
                                    <label class="control-label col-sm-2">หน่วยงานรับรายได้ :</label>
                                    <div class="col-sm-2" >
                                        <select id="inputAgency" class="form-control"></select>
                                    </div>
                                    <label class="control-label col-sm-2">เงินส่วนลดก่อน VAT :</label>
                                    <div class="col-sm-2"><input id="inputDiscount" class="form-control "placeholder="เงินส่วนลดก่อน VAT"></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2">ชื่อบริการ :</label>
                                    <div class="col-sm-2" ><select id="inputServiceName" class="form-control"></select></div>
                                    <label class="control-label col-sm-2">จำนวนรายการ :</label>
                                    <div class="col-sm-2"><input id="inputServiceMoreData" class="form-control "placeholder="จำนวนรายการ"></div>
                                    <div class="col-sm-1"><input id="inputServiceUnit" class="form-control"placeholder=""></div>
                                    <label class="control-label col-sm-1"><input type="checkbox" hidden="hidden" name="checkboxAdditionalDiscount"><span class="glyphicon glyphicon-lock"></span>&nbsp;ส่วนลดพิเศษ :</label>
                                    <div class="col-sm-2"><input id="inputSpecialDiscount" class="form-control " placeholder="ส่วนลดพิเศษ"></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2">จำนวนเงินต่อหน่วย :</label>
                                    <div class="col-sm-2"><input id="inputMoneypreunit" class="form-control"placeholder="จำนวนเงินต่อหน่วย"></div>
                                    <label class="control-label col-sm-2">ภาษีหัก ณ ที่จ่าย :</label>
                                    <div class="col-sm-2"><input id="inputWithholdingtax" class="form-control"placeholder="ภาษีหัก ณ ที่จ่าย"></div>
                                    <div class="col-sm-1 "><a id="#" class="btn btn-primary">คำนวน</a></div>
                                    <div class="col-sm-2 col-sm-offset-1"><a id="addCharnel" onclick="addCharnel" class="btn btn-primary"> <span class="glyphicon glyphicon-plus-sign"></span> เพิ่มรายการรับชำระ</a></div>
                                </div>
                                <div class="form-group">
                                    <div class="radio col-sm-2 col-sm-offset-2">
                                        <label><input type="radio" name="vatRadio" value="exclude" checked><b>ก่อน vat</b></label>
                                        <label><input type="radio" name="vatRadio" value="include"><b>หลัง vat</b> </label>
                                    </div>
                                    
                                </div>
                            </div>
                            <br /> <br />
                            <div class="row">
											<div class="form-group">
												<div class="col-sm-12">
													<table class="table table-striped" id="tableBillingList">
														<thead>
															<tr>
																<th>#</th>
                                   								<th>ประเภทบริการ</th>
                                    							<th>ชื่อบริการ</th>
                                    							<th>จำนวนรายการ</th>
                                    							<th>จำนวนเงินต่อหน่วย (ก่อน Vat)</th>
                                   					 			<th>เงินส่วนลด</th>
                                    							<th>ภาษีมูลค่าเพิ่ม</th>
                                    							<th>ภาษีหัก ณ ที่จ่าย</th>
                                    							<th>ยอดเงินรวม</th>
                                    							<th>ส่วนลดพิเศษ</th>
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
										<input name="paymentTax.invoiceNo" id="invoiceNoTax"
											type="hidden">
										<div class="row">
											<div class="form-group">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">ประเภทภาษีหัก ณ ที่จ่าย :</label>
												<div class="col-sm-6">
													<label> <input type="radio" name="radioDed"
														id="radioDedCD" value="69tv" checked> 69 ทวิ
													</label> <label> <input type="radio" name="radioDed"
														id="radioDedCC" value="3d"> 3 เดรส
													</label> <label> <input type="radio" name="radioDed"
														id="radioDedCT" value="39tr"> 69 ดริ
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
														name="paymentTax.docDed" placeholder="เลขที่เอกสาร">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group ">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">จำนวนเงิน :</label>
												<div class="col-sm-6">
													<input class="form-control" type="text" id="moneyDed"
														name="paymentTax.moneyDed" placeholder="จำนวนเงิน">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="form-group">
												<div class="col-sm-10 right">
													<a onclick="addRow()" id="addRow" class="btn btn-warning"><span
														class="glyphicon glyphicon-plus">เพิ่มรายการภาษีหัก
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
										วิธีการรับชำระ <select class="form-control" id="typePayment"
											name="paymentTranPrice.typePayment"
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
															placeholder="จำนวนเงิน" id="moneyTran"
															name="paymentTranPrice.moneyTran">
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
															name="paymentTranPrice.creditType">
															<option value="">กรุณาเลือก</option>
															<option value="visa">VISA</option>
															<option value="masterCard">MASTER-CARD</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">เลขที่บัตร:</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="creditNo"
															name="paymentTranPrice.creditNo" placeholder="เลขที่บัตร">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ธนาคารเจ้าของเครื่อง
														(EDC):</label>
													<div class="col-sm-4">
														<select class="form-control" id="edcType"
															name="paymentTranPrice.edcType">
															<option value="">กรุณาเลือก</option>
															<option value="paypal">Paypal</option>
															<option value="7Eleven">7-Eleven</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวเนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="creditPrice"
															name="paymentTranPrice.creditPrice"
															placeholder="จำนวเนเงิน">
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
														<select class="form-control" id="bankNo"
															name="paymentTranPrice.bankNo" onchange="findBank()">
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
															name="paymentTranPrice.checkNo" placeholder="เลขที่เช็ค">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ชื่อธนาคาร :</label>
													<div class="col-sm-4">
														<select class="form-control" id="bankName"
															name="paymentTranPrice.bankName" onchange="findBankNo()">
															<option value="">กรุณาเลือก</option>
															<option value="ktb">ธนาคารกรุงไทย</option>
															<option value="scb">ธนาคารไทยพานิชย์</option>
															<option value="kbk">ธนาคารกสิกรไทย</option>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">วันที่หน้าเช็ค :</label>
													<div class="col-sm-4">
														<input class="form-control" type="date" id="dateCheck"
															name="paymentTranPrice.dateCheck">
													</div>
												</div>
											</div>
											<div class="row">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">สาขา :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="branchCheck"
															name="paymentTranPrice.branchCheck" placeholder="สาขา">
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="moneyCheck"
															name="paymentTranPrice.moneyCheck"
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

			<div class="row">
					<div class="col-md-6 col-sm-6">
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
												<thead>
													<tr></tr>
												</thead>
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
		
		 <div class="row">
			<div class="col-md-12">
				<div class="panel">
					<div class="panel-heading">สรุปยอดเงินที่ต้องชำระ</div>
					<div class="panel-body">
						<div class="form-horizontal">

							<div class="form-group">
								<label class="control-label col-sm-10">ยอดเงินก่อนหักส่วนลด
									:</label>
								<div class="col-sm-2">
									<input id="preItemsDiscount" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10">ส่วนลด :</label>
								<div class="col-sm-2">
									<input id="itemsDiscount" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10">ส่วนลดพิเศษ :</label>
								<div class="col-sm-2">
									<input id="discount" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-10" for="formGroupInputLarge">ยอดเงินที่ต้องชำระก่อนภาษีมูลค่าเพิ่ม
									:</label>
								<div class="col-sm-2">
									<input class="form-control" type="text"
														id="balanceBeforeTaxs" readonly="">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10" for="formGroupInputLarge">ภาษีมูลค่าเพิ่ม
									:</label>
								<div class="col-sm-2">
									<input class="form-control" type="text" id="vats"
														readonly="">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10" for="formGroupInputLarge">ยอดเงินที่ต้องชำระรวมภาษีมูลค่าเพิ่ม
									:</label>
								<div class="col-sm-2">
									<input class="form-control" type="text" id="balanceOfTaxs"
														readonly="">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10" for="formGroupInputLarge">ภาษีหัก ณ
									ที่จ่าย :</label>
								<div class="col-sm-2">
									<input class="form-control" type="text" id="summaryTax"
														name="summaryTax" readonly="">
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-10" for="formGroupInputLarge">ยอดเงินที่ต้องชำระ
									:</label>
								<div class="col-sm-2">
									<input class="form-control" type="text"
														id="balanceSummarys" readonly="">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10">ยอดเงินรับมา :</label>
								<div class="col-sm-2">
									<input id="inputReceived" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10">เงินทอน :</label>
								<div class="col-sm-2">
									<input id="change" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<div class="control-label col-sm-10">
									<label class="strong"><input type="radio"
										name="specialOptions" value="1">
										รายได้อื่นที่ไม่มีภาษี</label>&nbsp;&nbsp;&nbsp;&nbsp; <label
										class="strong"><input type="radio"
										name="specialOptions" value="2"> รายได้อื่นมีภาษี</label>&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div class="col-sm-2">
									<input id="inputAdvanced" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
                            <label class="control-label col-sm-2">ข้อความเพิ่มเติมในใบเสร็จ :</label>
                            <div class="col-sm-5"><input id="inputAdditionalRemark" class="form-control"></div>
                        </div>
						</div>
					</div>
				</div>
			</div>
		</div> 
		
		
		</div>
		</div>
</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>