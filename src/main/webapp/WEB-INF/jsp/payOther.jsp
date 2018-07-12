<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="th.co.maximus.bean.MasterDataBean"%>
<%@ page import="th.co.maximus.bean.MapGLBean"%>
<%@ page import="java.util.List"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp"></jsp:include>

<html>
<head>
<script src="${contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<title>Payment</title>
<script type="text/javascript"
	src="${contextPath}/resources/js/typeahead.bundle.js"></script>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/payment.css" rel="stylesheet">
<script src="${contextPath}/resources/js/utils.js"></script>
<script src="${contextPath}/resources/js/paymentother.js"></script>
<script src="${contextPath}/resources/lib/autoNumeric-1.7.4.js"></script>

<%
	List<MasterDataBean> masterBankCode = null;
	List<MasterDataBean> masterBankName = null;
	List<MapGLBean> masterServicetype = null;
	List<MasterDataBean> masterServiceDepartment = null;
	List<MapGLBean> mapGLServiceName = null;
	List<MasterDataBean> masterCategory = null;
%>
<%
	masterBankCode = (List<MasterDataBean>) request.getAttribute("bankCode");
	masterBankName = (List<MasterDataBean>) request.getAttribute("bankName");
	masterServicetype = (List<MapGLBean>) request.getAttribute("serviceType");
	masterServiceDepartment = (List<MasterDataBean>) request.getAttribute("serviceDepartment");
	mapGLServiceName = (List<MapGLBean>) request.getAttribute("serviceName");
	masterCategory = (List<MasterDataBean>) request.getAttribute("category");
%>

</head>
<body>
	<div class="container-fluid">

		<form name="paymentFrom" method="post" action="#" id="paymentFrom"
			class="form-horizontal">
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
								<button name="submitFormPayment" type="button"
									id="submitFormPayment" class="btn btn-success btn-lg"
									onclick="submitForm()">
									<span class="glyphicon glyphicon-share"> บันทึกและพิมพ์</span>
								</button>
							</div>
						</div>
					</div>
				</div>

				<div class="row" style="margin-top: 20px;">
					<input type="hidden" id="userName1" name="userName1"
						value="${pageContext.request.userPrincipal.name}">
					<!-- <div class="col-md-12 col-sm-12"> -->
					<!-- <div class="form-group"> -->
					<div class="col-md-12 col-sm-12">
						<div class="panel">
							<div class="panel-heading">เพิ่มใบรับชำระค่าบริการ</div>
							<div class="panel-body">
								<div class="form-horizontal">
									<input type="hidden" name="balanceSummary" id="balanceSummary">
									<input type="hidden" name="balanceBeforeTax"
										id="balanceBeforeTax"> <input type="hidden" name="vat"
										id="vat">
									<div class="form-group">
										<label class="col-sm-2 control-label right" for="custNo">เลขที่ลูกค้า
											:<span style="color: red; ">*</span>
										</label>
										<div class="col-sm-2">
											<input class="form-control" type="text" id="custNo"
												name="custNo" placeholder="เลขที่ลูกค้า">
											<p id="sCustNo" style="color: red; display: none">คุณยังไม่ได้กรอก
												เลขที่ลูกค้า</p>
										</div>
										<label class="col-sm-2 control-label right" for="custName">ชื่อ:</label>
										<div class="col-sm-2">
											<input class="form-control" type="text" id="custName"
												name="custName" placeholder="ชื่อ">
											<p id="sCustName" style="color: red; display: none">
												คุณยังไม่ได้กรอกชื่อ</p>
										</div>

										<label class="col-sm-2 control-label right"
											for="formGroupInputLarge">Tax ID :</label>
										<div class="col-sm-2">
											<input class="form-control" type="text" id="taxId"
												name="taxId" placeholder="Tax ID" maxlength="13">
											<p id="staxId" style="color: red; display: none"">คุณยังไม่ได้กรอก TAX
												ID</p>
										</div>
									</div>
								</div>
								<div class="form-horizontal">
									<div class="form-group left">
										<label class="col-sm-2 control-label right"
											for="formGroupInputLarge">กลุ่มผู้ใช้บริการ :<span
											style="color: red;">*</span></label>
										<div class="col-sm-2">
											<select class="form-control" id="userGroup" name="userGroup"
												onchange="autoSelect()">
												<option value="">-- กรุณาเลือก --</option>
												<option value="1">ธุรกิจทั่วไป</option>
												<option value="2">หน่วยงานรัฐ</option>
												<option value="3">บุคคลทั่วไป</option>
												<option value="4">Carrier/Operator/NON POTs</option>
												<option value="5">Mkt.Arm</option>
												<option value="6">ISP</option>
												<option value="7">Reseller/Agent</option>
												<option value="8">ธุรกิจ กสท</option>
												<option value="9">สถานฑูต/องค์กรระหว่างประเทศ</option>
											</select>
										</div>
										<p id="suserGroup" style="color: red; display: none">คุณยังไม่ได้เลือก
											กลุ่มผู้ใช้บริการ</p>

										<label class="col-sm-2 control-label right"
											for="formGroupInputLarge">สาขา :</label>
										<div class="col-sm-2">
											<input class="form-control" id="custBrach" name="custBrach"
												type="text" maxlength="5">
											<p id="scustBrach" style="color: red; display: none">คุณยังไม่ได้กรอก
												สาขา</p>
										</div>
										<label class="col-sm-2 control-label right"
											for="formGroupInputLarge">VAT RATE :</label>
										<div class="col-sm-2">
											<select class="form-control" id="vatrate" name="vatrate">
												<option value="7">7%</option>
												<option value="0">0%</option>
												<option value="0">Non VAT</option>

											</select>
										</div>
									</div>
								</div>
								<div class="form-horizontal">
									<div class="form-group">
										<label class="col-sm-2 control-label right"
											for="formGroupInputLarge">ที่อยู่ :</label>
										<div class="col-sm-6">
											<textarea class="form-control" rows="3" id="custAddress"
												name="custAddress"></textarea>
											<p id="scustAddress" style="color: red; display: none">
												คุณยังไม่ได้กรอก ที่อยู่</p>
										</div>
									</div>

								</div>

							</div>
						</div>
					</div>

					<!-- </div> -->
					<!-- </div> -->

				</div>
				<div class="panel ">
					<div class="panel-heading">รายการรับชำระ</div>
					<div class="panel-body">
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="tab_1">
								<div class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-sm-2">ประเภทรายได้ :<span
											style="color: red;">*</span></label>
										<div class="col-sm-2">
											<select id="inputServiceType" name="inputServiceType"
												class="form-control">
												<option value="">-- กรุณาเลือก --</option>
												<%
													for (int i = 0; i < masterServicetype.size(); i++) {
												%>
												<option
													value="<%=masterServicetype.get(i).getRevenueTypeCode()%>"><%=masterServicetype.get(i).getRevenueTypeName()%></option>
												<%
													}
												%>
											</select>
											<p id="sinputServiceType" style="color: red; display: none"">
												คุณยังไม่ได้เลือก ประเภทรายได้</p>
										</div>
										<label class="control-label col-sm-2">หน่วยงานรับรายได้
											:<span style="color: red;">*</span>
										</label>
										<div class="col-sm-2">
											<select id="inputServiceDepartment"
												name="inputServiceDepartment" class="form-control">
												<option value="">-- กรุณาเลือก --</option>
												<%
													for (int i = 0; i < masterServiceDepartment.size(); i++) {
												%>
												<option
													value="<%=masterServiceDepartment.get(i).getText()%>"><%=masterServiceDepartment.get(i).getText()%></option>
												<%
													}
												%>
											</select>
											<p id="sinputServiceDepartment" style="color: red; display: none"">
												คุณยังไม่ได้เลือก หน่วยงานรับรายได้</p>
										</div>
										<label class="control-label col-sm-2">เงินส่วนลดก่อน
											VAT :</label>
										<div class="col-sm-2">
											<div class="input-group">
												<div class="input-group-addon">฿</div>
												<input id="inputServiceDiscount" name="inputServiceDiscount"
													class="form-control right numeric2point" />
											</div>

										</div>

									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">ชื่อบริการ :<span
											style="color: red;">*</span></label>
										<div class="col-sm-2">
											<select class="form-control" id="inputServiceName"
												name="inputServiceName">
												<option value="">-- กรุณาเลือก --</option>
												<%
													for (int i = 0; i < mapGLServiceName.size(); i++) {
												%>
												<option
													value="<%=mapGLServiceName.get(i).getServiceCode()%>"><%=mapGLServiceName.get(i).getServiceName()%></option>
												<%
													}
												%>
											</select>
											<p id="sinputServiceName" style="color: red; display: none"">
												คุณยังไม่ได้เลือก ชื่อบริการ</p>
										</div>
										<label class="control-label col-sm-2">จำนวนรายการ :<span
											style="color: red; ">*</span></label>
										<div class="col-sm-2">
											<input id="inputServiceMoreData" name="inputServiceMoreData"
												class="form-control" value="1">
											<p id="sinputServiceMoreData" style="color: red; display: none"">
												คุณยังไม่ได้กรอก จำนวนรายการ</p>
										</div>
										<div class="col-sm-1">
											<select class="form-control">
												<%
													for (int i = 0; i < masterCategory.size(); i++) {
												%>
												<option value="<%=masterCategory.get(i).getText()%>"><%=masterCategory.get(i).getText()%></option>
												<%
													}
												%>
											</select>
										</div>
										<div class="control-label col-sm-1">
											<i id="rbSpecialDiscount" class="glyphicon glyphicon-lock"></i>
											<label class="control-label ">ส่วนลดพิเศษ :</label>
										</div>

										<div class="col-sm-2">
											<div class="input-group">
												<div class="input-group-addon">฿</div>
												<input id="inputSpecialDiscount" name="inputSpecialDiscount"
													class="form-control right numeric2point" />
											</div>
										</div>


									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">จำนวนเงินต่อหน่วย
											ก่อน vat :<span style="color: red;" >*</span>
										</label>
										<div class="col-sm-2">
											<input id="inputServiceAmount" name="inputServiceAmount"
												class="form-control numeric2point right">
											<p id="sinputServiceAmount" style="color: red; display: none"">
												คุณยังไม่ได้กรอก จำนวนเงินต่อหน่วย ก่อน vat</p>
										</div>
										<label class="control-label col-sm-2">ภาษีหัก ณ
											ที่จ่าย :</label>
										<div class="col-sm-2">
											<div class="input-group">
												<div class="input-group-addon">฿</div>
												<input id="moneyDed1" name="moneyDed1"
													class="form-control numeric2point right">
											</div>
										</div>

										<div class="col-sm-1">
											<a class="btn btn-info" onclick="calVat()" id="calVat">คำนวณ</a>
										</div>
										<div class="col-sm-2 col-sm-offset-1">
											<a id="buttonAddBillingList" onclick="buttonAddBillingList()"
												class="btn btn-info"> <span
												class="glyphicon glyphicon-plus-sign"></span>
												เพิ่มรายการรับชำระ
											</a> <a id="buttonAddBillingListDis" disabled="disabled"
												class="btn btn-info"> <span
												class="glyphicon glyphicon-plus-sign"></span>
												เพิ่มรายการรับชำระ
											</a>
										</div>
									</div>

									<div class="form-group">

										<div class="col-sm-3" align="right">
											<input type="radio" name="radiovat" value="beforvat" checked>ก่อน
											vat <input type="radio" name="radiovat" value="aftervat">หลัง
											vat
										</div>




									</div>

								</div>
								<br /> <br />
								<div class="form-horizontal">
									<div class="form-group">
										<div style="display: none">
											<table id="sumtableBillingListdata">
												<thead>
													<tr></tr>
												</thead>
												<tbody></tbody>
											</table>
										</div>
										<div class="col-sm-12">
											<table id="sumtableBillingList" class="table table-striped">
												<thead>
													<tr>
														<th>#</th>
														<th>ประเภทบริการ</th>
														<th>ชื่อบริการ</th>
														<th>จำนวนรายการ</th>
														<th>จำนวนเงินต่อหน่วย (ก่อน vat)</th>
														<th>เงินส่วนลดก่อน VAT</th>
														<th>ส่วนลดพิเศษ</th>
														<th>ภาษีมูลค่าเพิ่ม</th>
														<th>ภาษีหัก ณ ที่จ่าย</th>
														<th>ยอดเงินรวม</th>
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

				<div class="form-horizontal">
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
														id="radioDedCD" value="01" checked> 69 ทวิ
													</label> <label> <input type="radio" name="radioDed"
														id="radioDedCC" value="02"> 3 เตรส
													</label> <label> <input type="radio" name="radioDed"
														id="radioDedCT" value="03"> 69 ตรี
													</label>
												</div>
											</div>
										</div>
										<div class="form-horizontal ">
											<div class="form-group ">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">เลขที่เอกสาร :</label>
												<div class="col-sm-6">
													<input class="form-control" type="text" id="docDed"
														name="paymentTax.docDed" placeholder="เลขที่เอกสาร">
												</div>
											</div>
										</div>
										<div class="form-horizontal">

											<div class="form-group ">
												<label class="col-sm-4 control-label right"
													for="formGroupInputLarge">จำนวนเงิน :</label>
												<div class="col-sm-6">
													<input class="form-control numeric2point right" type="text"
														id="moneyDed" name="paymentTax.moneyDed"
														placeholder="จำนวนเงิน">
													<p id="moneyDedTxt" style="color: red; display: none"">คุณยังไม่ได้กรอก
														จำนวนเงิน</p>
												</div>
											</div>
										</div>
										<div class="form-horizontal">
											<div class="form-group">
												<div class="col-sm-10 right">
													<a onclick="addRow()" id="addRow" name="addRow"
														class="btn btn-warning"><span
														class="glyphicon glyphicon-plus">เพิ่มรายการภาษีหัก
															ณ ที่จ่าย</span></a>
													<button onclick="addRow()" id="addRowShow"
														disabled="disabled" name="addRowShow"
														class="btn btn-warning">
														<span class="glyphicon glyphicon-plus">เพิ่มรายการภาษีหัก
															ณ ที่จ่าย</span>
													</button>
												</div>

											</div>
										</div>
										<div class="form-horizontal">
											<div class="form-group">
												<div class="col-sm-12">
													<table class="table table-striped" id="deductibleTable">
														<thead>
															<tr>
																<th>#</th>
																<th>เลขที่ลูกค้า</th>
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
										<div class="form-horizontal">
											<div class="form-group">
												<div class="col-sm-12 right">
													<button type="button" class="btn btn-primary"
														onclick="addDataTableDed()" id="addDataTableDedShow">
														<span class="glyphicon glyphicon-plus">เพิ่มรายการหัก</span>
													</button>
													<button type="button" class="btn btn-primary"
														id="addDataTableDedDis" disabled="disabled">
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
											<div class="form-horizontal">
												<div class="form-group">
													<label class="col-sm-8 control-label right"
														for="formGroupInputLarge">จำนวนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control numeric2point right"
															type="text" placeholder="จำนวนเงิน" id="moneyTran"
															name="paymentTranPrice.moneyTran">
														<p id="moneyTranTxt" style="color: red; display: none"">คุณยังไม่ได้กรอก
															จำนวนเงิน</p>
													</div>

												</div>
											</div>
										</div>

										<div id="credit">
											<div class="form-horizontal">
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
														<p id="creditTypeTxt" style="color: red; display: none"">คุณยังไม่ได้เลือก
															ประเภทของบัตรเครดิต</p>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">เลขที่บัตร:</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="creditNo"
															maxlength="16" name="paymentTranPrice.creditNo"
															placeholder="เลขที่บัตร">
														<p id="creditNoTxt" style="color: red; display: none"">คุณยังไม่ได้กรอก
															เลขที่บัตร</p>
													</div>
												</div>
											</div>
											<div class="form-horizontal">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ธนาคารเจ้าของเครื่อง
														(EDC):</label>
													<div class="col-sm-4">
														<select class="form-control" id="edcType"
															name="paymentTranPrice.edcType">
															<option value="">กรุณาเลือก</option>
															<%
																for (int i = 0; i < masterBankName.size(); i++) {
															%>
															<option value="<%=masterBankName.get(i).getValue()%>"><%=masterBankName.get(i).getText()%></option>
															<%
																}
															%>
														</select>
														<p id="edcTypeTxt" style="color: red; display: none"">คุณยังไม่ได้เลือก
															ธนาคารเจ้าของเครื่อง (EDC)</p>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control numeric2point right"
															type="text" id="creditPrice"
															name="paymentTranPrice.creditPrice"
															placeholder="จำนวนเงิน">
														<p id="creditPriceTxt" style="color: red; display: none"">คุณยังไม่ได้กรอก
															จำนวนเงิน</p>
													</div>
												</div>
											</div>
											<div class="form-horizontal">
												<div class="form-group">
													<div class="col-sm-12 right">
														<button type="button" class="btn btn-warning"
															onclick="addDataTablecreditTranPrice()">
															<span class="glyphicon glyphicon-plus">เพิ่มรายการบัตรเครดิต</span>
														</button>
													</div>
												</div>
											</div>
											<div class="form-horizontal">
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
											<div class="form-horizontal">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">รหัสธนาคาร:</label>
													<div class="col-sm-4">
														<select class="form-control" id="bankNo"
															name="paymentTranPrice.bankNo" onchange="findBank()">
															<option value="">กรุณาเลือก</option>
															<%
																for (int i = 0; i < masterBankCode.size(); i++) {
															%>
															<option value="<%=masterBankCode.get(i).getValue()%>"><%=masterBankCode.get(i).getText()%></option>
															<%
																}
															%>
														</select>
														<p id="bankNoTxt" style="color: red; display: none"">คุณยังไม่ได้เลือก
															รหัสธนาคาร</p>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">เลขที่เช็ค:</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="checkNo"
															maxlength="7" name="paymentTranPrice.checkNo"
															placeholder="เลขที่เช็ค">
													</div>
												</div>
											</div>
											<div class="form-horizontal">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">ชื่อธนาคาร :</label>
													<div class="col-sm-4">
														<select class="form-control" id="bankName"
															name="paymentTranPrice.bankName" onchange="findBankNo()">
															<option value="">กรุณาเลือก</option>
															<%
																for (int i = 0; i < masterBankName.size(); i++) {
															%>
															<option id="nameBank"
																value="<%=masterBankName.get(i).getValue()%>"><%=masterBankName.get(i).getText()%></option>
															<%
																}
															%>
														</select>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">วันที่หน้าเช็ค :</label>
													<div class="col-sm-4">
														<input class="form-control" type="date" id="dateCheck"
															name="paymentTranPrice.dateCheck">
														<p id="dateCheckTxt" style="color: red; display: none"">คุณยังไม่ได้เลือก
															วันที่หน้าเช็ค</p>
													</div>
												</div>
											</div>
											<div class="form-horizontal">
												<div class="form-group">
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">สาขา :</label>
													<div class="col-sm-4">
														<input class="form-control" type="text" id="branchCheck"
															name="paymentTranPrice.branchCheck" placeholder="สาขา">
														<p id="branchCheckTxt" style="color: red; display: none"">คุณยังไม่ได้กรอก
															สาขา</p>
													</div>
													<label class="col-sm-2 control-label right"
														for="formGroupInputLarge">จำนวนเงิน :</label>
													<div class="col-sm-4">
														<input class="form-control numeric2point right"
															type="text" id="moneyCheck"
															name="paymentTranPrice.moneyCheck"
															placeholder="จำนวนเงิน">
														<p id="moneyCheckTxt" style="color: red; display: none"">คุณยังไม่ได้กรอก
															จำนวนเงิน</p>
													</div>
												</div>
											</div>
											<div class="form-horizontal">
												<div class="form-group">
													<div class="col-sm-12 right">
														<button type="button" class="btn btn-warning"
															onclick="addDataTableCheck()">
															<span class="glyphicon glyphicon-plus">เพิ่มรายการเช็ค</span>
														</button>
													</div>
												</div>
											</div>
											<div class="form-horizontal">
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




										<div class="form-horizontal">
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
				<div class="row col-sm-12">
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
									<div class="panel-heading" style="background-color: #ee7600;">สรุปวิธีการชำระเงิน</div>
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
					<!-- Summary  -->
					<div class="col-md-12 col-sm-12">
						<div class="form-group">
							<div class="col-md-12 col-sm-12">
								<div class="panel">
									<div class="panel-heading" style="background-color: #ee7600;">สรุปยอดเงินที่ต้องชำระ</div>
									<div class="panel-body">
										<div class="row">

											<div class="form-group ">
												<label class="col-sm-1 control-label right"
													for="formGroupInputLarge">เพิ่มเติม :</label>
												<div class="col-sm-3">
													<input class="form-control" type="text" id="remark"
														name="remark">
												</div>
												<div class="col-sm-3"></div>
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ยอดเงินที่ต้องชำระก่อนส่วนลด
													:</label>
												<div class="col-sm-3">
													<input class="form-control right" type="hidden"
														id="beforeSale" readonly="">
												</div>
												<div class="col-sm-3">
													<input class="form-control numeric2point right" type="text"
														id="beforeSaleShow" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ส่วนลด :</label>
												<!-- 												<div class="col-sm-3"> -->
												<!-- 													<input class="form-control numeric2point" type="text" id="sales" -->
												<!-- 														readonly="" > -->
												<!-- 												</div> -->
												<div class="col-sm-3">
													<input class="form-control numeric2point right "
														type="text" id="sale" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ส่วนลดพิเศษ :</label>
												<!-- 												<div class="col-sm-3"> -->
												<!-- 													<input class="form-control numeric2point" type="text" id="salespacials" -->
												<!-- 														readonly=""  > -->
												<!-- 												</div> -->
												<div class="col-sm-3">
													<input class="form-control numeric2point right" type="text"
														id="salespacial" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ยอดเงินที่ต้องชำระก่อนภาษีมูลค่าเพิ่ม
													:</label>
												<div class="col-sm-3">
													<input class="form-control right" type="hidden"
														id="balanceBeforeTaxs" readonly="">
												</div>
												<div class="col-sm-3">
													<input class="form-control numeric2point right" type="text"
														id="balanceBeforeTaxsShow" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ภาษีมูลค่าเพิ่ม :</label>
												<div class="col-sm-3">
													<input class="form-control right" type="hidden" id="vats"
														readonly=""> <input
														class="form-control numeric2point right" type="text"
														id="vatsShow" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ยอดเงินที่ต้องชำระรวมภาษีมูลค่าเพิ่ม
													:</label>
												<div class="col-sm-3">
													<input class="form-control right" type="hidden"
														id="balanceOfTaxs" readonly=""> <input
														class="form-control numeric2point right" type="text"
														id="balanceOfTaxsShow" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ภาษีหัก ณ ที่จ่าย :</label>
												<div class="col-sm-3">
													<input class="form-control right" type="text"
														id="summaryTax" name="summaryTax" readonly="">
												</div>
											</div>
										</div>

										<!-- 										<div class="row" style="display: none;"> -->

										<!-- 											<div class="form-group "> -->
										<!-- 												<div class="col-sm-7"></div> -->
										<!-- 												<div class="col-sm-1" align="right"> -->
										<!-- 													<input type="radio" id="radioButton" readonly=""> -->
										<!-- 													รับภาระภาษีเต็มจำนวน -->
										<!-- 												</div> -->
										<!-- 												<div class="col-sm-1" align="right"> -->
										<!-- 													<input type="radio" id="radioButtons" readonly=""> -->
										<!-- 													รับภาระภาษีบางส่วน -->
										<!-- 												</div> -->
										<!-- 												<div class="col-sm-3"> -->
										<!-- 													<input class="form-control" type="text" id="" name="" -->
										<!-- 														value="0.00" readonly=""> -->
										<!-- 												</div> -->
										<!-- 											</div> -->
										<!-- 										</div> -->
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ยอดเงินที่ต้องชำระ :</label>
												<div class="col-sm-3">
													<input class="form-control right" type="hidden"
														id="balanceSummarys" readonly=""> <input
														class="form-control numeric2point right" type="text"
														id="balanceSummaryShow" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">ยอดเงินรับมา :</label>
												<div class="col-sm-3">
													<input class="form-control right " type="hidden"
														id="balanceSum" readonly=""> <input
														class="form-control numeric2point right" type="text"
														id="balanceSumShow" readonly="">
												</div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-7"></div>
											<div class="form-group ">
												<label class="col-sm-2 control-label right"
													for="formGroupInputLarge">เงินทอน :</label>
												<div class="col-sm-3">
													<input class="form-control right" type="text" id="change"
														readonly="">
												</div>
											</div>
										</div>
										<div class="row" style="display: none;">

											<div class="form-group ">
												<div class="col-sm-6"></div>
												<div class="col-sm-1" align="right">
													<input type="radio" id="radioButton1" readonly="">
													รายได้อื่นที่ไม่มีภาษี
												</div>
												<div class="col-sm-1" align="right">
													<input type="radio" id="radioButton2" readonly="">
													รายได้อื่นมีภาษี
												</div>
												<div class="col-sm-1" align="right">
													<input type="radio" id="radioButton3" readonly="">
													รับชำระล่วงหน้า
												</div>
												<div class="col-sm-3">
													<input class="form-control right" type="text" id="" name=""
														value="0.00" readonly="">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>

			<div class="modal fade" role="dialog"
				aria-labelledby="mySmallModalLabel" aria-hidden="true" id="mi-modal">
				<div class="modal-dialog modal-sm" style="width: 450px">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">Authentication</h4>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-3 control-label">user name</label>
									<div class="col-md-9">
										<input type="text" id="userName" name="userName"
											class="form-control">
									</div>
								</div>
								<div class="form-group col-md-12">
									<label class="col-md-3 control-label">password</label>
									<div class="col-md-9">
										<input type="password" id="password" name="password"
											class="form-control">
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="modal-btn-si">ตกลง</button>
							<button type="button" class="btn btn-danger" id="modal-btn-no">ยกเลิก</button>
						</div>
					</div>
				</div>
			</div>
			<div class="modal fade" role="dialog"
				aria-labelledby="mySmallModalLabel" aria-hidden="true"
				id="mi-modal-notauthen">
				<div class="modal-dialog modal-sm" style="width: 450px">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title" id="myModalLabel">Authentication</h4>
						</div>
						<div class="modal-body">

							<div class="row">
								<div class="form-group col-md-12">
									<label class="col-md-9 control-label">กรุณาตรวจสอบข้อมูลของท่านใหม่</label>

								</div>

							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" id="modal-btn-ok">ตกลง</button>
						</div>
					</div>
				</div>
			</div>


		</form>
	</div>

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>