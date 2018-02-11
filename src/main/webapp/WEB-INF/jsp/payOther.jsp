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
	
		<br />
		<div class="row">
		
            <div class="col-md-12 col-sm-12">
						<div class="form-group" >
							<div class="col-md-12 col-sm-12">
								 <ol class="breadcrumb">
                <li><i>รับชำระอื่นๆ</i></li>
                <li class="active">เพิ่มข้อมูลการรับชำระอื่นๆ</li>
            </ol>
							</div>
						</div>
					</div>
					<div class="col-md-12 col-sm-12">
						<div class="form-group" align="right">
							<div class="col-md-12 col-sm-12">
			<ul class="list-inline pull-right list-menu-set">
				<li><a id="buttonCreatePaymentAndPrint" class="btn btn-link"><span
						class="glyphicon glyphicon-print"></span> บันทึกและพิมพ์</a></li>
				<li><a id="buttonCancelPayment" class="btn btn-link"><span
						class="glyphicon glyphicon-remove-circle"></span> ยกเลิกรายการ</a></li>
			</ul>
			</div>
			</div>
			</div>
            
					<!-- <div class="col-md-12 col-sm-12">
						<div class="form-group" align="right">
							<div class="col-md-12 col-sm-12">
								<a><span class="glyphicon glyphicon-share">ดำเนินการรับชำระ</span></a>
							</div>
						</div>
					</div> -->
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
                                            <div class="col-sm-2"><input id="inputCustomerBillNo" class="form-control"></div>
                                            <label class="control-label col-sm-2">ชื่อลูกค้า :</label>
                                            <div class="col-sm-5"><input id="inputCustomerName" class="form-control" ></div>
                                            <input type="hidden" id="inputCustomerType">
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-sm-2">Tax ID :</label>
                                            <div class="col-sm-2"><input id="inputCustomerTaxNo" maxlength="13" class="form-control" ></div>
                                            <label class="control-label col-sm-2">สาขา :</label>
                                            <div class="col-sm-2"><input id="inputCustomerBranch" maxlength="5" class="form-control" ></div>
                                        </div>

                                        <div class="form-group">
                                            <label class="control-label col-sm-2">กลุ่มผู้ใช้บริการ :</label>
                                            <div class="col-sm-2">
                                                <select class="form-control" id="inputCustomerSegment" ></select>
                                            </div>
                                            <label class="control-label col-sm-2">VAT Rate :</label>
                                            <div class="col-sm-2">
                                                <select id="inputCustomerVatRate" class="form-control" >
                                                    <option>7</option>
                                                    <option>0</option>
                                                    <option>Non VAT</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-sm-2">ที่อยู่ :</label>
                                            <div class="col-sm-6"><textarea id="inputCustomerAddress" class="form-control" ></textarea></div>
                                            
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
                                    <div class="col-sm-2" ><input id="inputServiceAmount" class="form-control"></div>
                                    <label class="control-label col-sm-2">หน่วยงานรับรายได้ :</label>
                                    <div class="col-sm-2" >
                                        <input id="inputServiceAmount" class="form-control">
                                    </div>
                                    <label class="control-label col-sm-2">เงินส่วนลดก่อน VAT :</label>
                                    <div class="col-sm-2"><input id="inputServiceDiscount" class="form-control text-right"></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2">ชื่อบริการ :</label>
                                    <div class="col-sm-2" ><input id="inputServiceAmount" class="form-control"></div>
                                    <label class="control-label col-sm-2">จำนวนรายการ :</label>
                                    <div class="col-sm-2"><input id="inputServiceMoreData" class="form-control text-right"></div>
                                    <div class="col-sm-1"><select id="inputServiceUnit" class="form-control"></select></div>
                                    <label class="control-label col-sm-1"><input type="checkbox" hidden="hidden" name="checkboxAdditionalDiscount"><span class="glyphicon glyphicon-lock"></span>&nbsp;ส่วนลดพิเศษ :</label>
                                    <div class="col-sm-2"><input id="inputSpecialDiscount" class="form-control text-right" ></div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2">จำนวนเงินต่อหน่วย :</label>
                                    <div class="col-sm-2"><input id="inputServiceAmount" class="form-control"></div>
                                    <label class="control-label col-sm-2">ภาษีหัก ณ ที่จ่าย :</label>
                                    <div class="col-sm-2"><input id="inputServiceDeduction" class="form-control text-right"></div>
                                    <div class="col-sm-1 "><a id="#" class="btn btn-primary">คำนวน</a></div>
                                    <div class="col-sm-2 col-sm-offset-1"><a id="buttonAddBillingList" class="btn btn-primary"> <span class="glyphicon glyphicon-plus-sign"></span> เพิ่มรายการรับชำระ</a></div>
                                </div>
                                <div class="form-group">
                                    <div class="radio col-sm-2 col-sm-offset-2">
                                        <label><input type="radio" name="vatRadio" value="exclude" checked><b>ก่อน vat</b></label>
                                        <label><input type="radio" name="vatRadio" value="include"><b>หลัง vat</b> </label>
                                    </div>
                                    <label class="control-label col-sm-2">ประเภทสกุลเงิน :</label>
                                    <div class="col-sm-1"><select id="inputServiceUnit" class="form-control"></select></div>
                                </div>
                            </div>
                            <br /> <br />

                            <table id="tableBillingList" data-row-style="rowStyle" data-toggle="table"
                                   data-classes="table table-hover table-striped">
                                <thead>
                                <tr>
                                    <th data-align="center" data-field="id" data-formatter="runningFormatter">#</th>
                                    <th data-field="serviceType">ประเภทบริการ</th>
                                    <th data-field="serviceName" data-formatter="stringInputFormatter">ชื่อบริการ</th>
                                    <th data-field="serviceMoreData" data-align="right">จำนวนรายการ</th>
                                    <th data-field="serviceAmount" data-align="right" data-formatter="numberFormatter">จำนวนเงินต่อหน่วย (ก่อน Vat)</th>
                                    <th data-field="serviceDiscount" data-align="right" data-formatter="numberFormatter">เงินส่วนลด</th>
                                    <th data-field="serviceVat" data-align="right" data-formatter="numberFormatterForVat">ภาษีมูลค่าเพิ่ม</th>
                                    <th data-field="serviceDeduction" data-align="right" data-formatter="numberFormatter">ภาษีหัก ณ ที่จ่าย</th>
                                    <th data-field="serviceTotalCharge" data-align="right" data-formatter="numberFormatter">ยอดเงินรวม</th>
                                    <th data-field="serviceSpecialDiscount" data-align="right" data-formatter="numberInputAuthenFormatter">ส่วนลดพิเศษ</th>
                                    <th data-align="center" data-formatter="operateButtonFormatter"></th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                        
                    </div>
                </div>
				

			<div class="row">
			
				<div class="col-md-5">
					<div class="panel">
					<div class="panel-heading">รายการหัก
						<select class="form-control" style="display: inline;width: 30%;padding-left: 20px">
							<option>ภาษีหัก ณ ที่จ่าย</option>
						</select>					
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
					<div class="panel">
						<div class="panel-heading">วิธีการรับชำระเงิน				
							<select class="form-control" style="display: inline;width: 20%;padding-left: 20px">
								<option>เงินสด</option>
								<option>เช็ค</option>
								<option>บัตรเครดิต</option>
							</select>	
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-12">
									<!-- <div class="form-horizontal">
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
										
									</div> -->
									<div role="tabpanel"  id="payType1">
								<div class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-sm-8">จำนวนเงิน :</label>
										<div class="col-sm-4">
											<input id="payCashAmount" class="form-control text-right">
										</div>
									</div>
								</div>
								<a class="btn btn-warning pull-right" id="payChqSubmit"><span
									class="glyphicon glyphicon-plus-sign"></span> เพิ่มรายการเงินสด</a>
							</div>
							<div role="tabpanel" class="tab-pane hide" id="payType2">
								<div class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-sm-2">รหัสธนาคาร :</label>
										<div class="col-sm-4">
											<input class="form-control" id="#" >
										</div>
										<label class="control-label col-sm-2">เลขที่เช็ค :</label>
										<!-- ICE FIXED CODE no.152 length chq = 7 -->
										<div class="col-sm-4">
											<input class="form-control" id="payChqNo" maxlength="7">
										</div>
										<!-- end ICE FIXED CODE no.152 length chq = 7 -->
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">ชื่อธนาคาร :</label>
										<div class="col-sm-4">
											<input class="form-control" id="#" >
										</div>
										<label class="control-label col-sm-2">วันที่หน้าเช็ค
											:</label>
										<div class="col-sm-4">
											<div class="input-group input-append date"
												data-provide="datepicker" data-date-format="dd/mm/yyyy">
												<input class="form-control" id="payChqDate"
													placeholder="dd/MM/yyyy" maxlength="10"> <span
													class="input-group-addon add-on"><span
													class="glyphicon glyphicon-calendar"></span></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-sm-2">สาขา :</label>
										<div class="col-sm-4">
											<input class="form-control" id="payChqBranch">
										</div>
										<label class="control-label col-sm-2">จำนวนเงิน :</label>
										<div class="col-sm-4">
											<input class="form-control text-right" id="payChqAmount">
										</div>
									</div>
								</div>
								<a class="btn btn-warning pull-right" id="payChqSubmit"><span
									class="glyphicon glyphicon-plus-sign"></span> เพิ่มรายการเช็ค</a>
								<table id="payChqList" class="table">
									<thead>
										<tr>
											<th data-align="center" data-running-no="true">#</th>
											<th>รหัสธนาคาร</th>
											<th>ชื่อธนาคาร</th>
											<th>สาขา</th>
											<th>เลขที่เช็ค</th>
											<th>วันที่หน้าเช็ค</th>
											<th data-align="right" data-number-format="true">จำนวนเงิน</th>
											<th></th>
										</tr>
									</thead>
								</table>
							</div>
							<div role="tabpanel" class="tab-pane hide" id="payType3">
								<div class="form-horizontal">
									<div class="form-group">
										<label class="control-label col-sm-3">ประเภทบัตรเครดิต
											:</label>
										<div class="col-sm-3">
											<input class="form-control text-right" id="#">
										</div>
										<label class="control-label col-sm-3">เลขที่บัตร :</label>
										<!-- ICE FIXED CODE no.153 length  = 16 -->
										<div class="col-sm-3">
											<input class="form-control" id="payCCNo" maxlength="16">
										</div>
										<!-- end ICE FIXED CODE no.153 length  = 16 -->
									</div>
									<div class="form-group">
										<label class="control-label col-sm-3">ธนาคารเจ้าของเครื่อง
											(EDC) :</label>
										<div class="col-sm-3">
											<input class="form-control text-right" id="#">
										</div>
										<label class="control-label col-sm-3">จำนวนเงิน :</label>
										<div class="col-sm-3">
											<input class="form-control text-right" id="payCCAmount">
										</div>
									</div>
								</div>
								<a class="btn btn-warning pull-right" id="payCCSubmit"><span
									class="glyphicon glyphicon-plus-sign"></span>
									เพิ่มรายการบัตรเครดิต</a>
								<table id="payCCList" class="table">
									<thead>
										<tr>
											<th data-align="center" data-running-no="true">#</th>
											<th>ประเภทบัตรเครดิต</th>
											<th>เลขที่บัตร</th>
											<th>EDC</th>
											<th data-align="right" data-number-format="true">จำนวนเงิน</th>
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
			</div>

			<div class="row">
			
				<div class="col-md-5">
					<div class="panel">
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
					<div class="panel">
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
								<label class="control-label col-sm-10">ยอดเงินที่ต้องชำระก่อนภาษีมูลค่าเพิ่ม
									:</label>
								<div class="col-sm-2">
									<input id="charge" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10">ภาษีมูลค่าเพิ่ม
									:</label>
								<div class="col-sm-2">
									<input id="vat" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10">ยอดเงินที่ต้องชำระรวมภาษีมูลค่าเพิ่ม
									:</label>
								<div class="col-sm-2">
									<input id="totalCharge" class="form-control text-right"
										disabled="disabled">
								</div>
							</div>
							<div class="form-group">
								<label class="control-label col-sm-10">ภาษีหัก ณ
									ที่จ่าย :</label>
								<div class="col-sm-2">
									<input id="deduct" class="form-control text-right" disabled>
								</div>
							</div>
							
							<div class="form-group">
								<label class="control-label col-sm-10">ยอดเงินที่ต้องชำระ
									:</label>
								<div class="col-sm-2">
									<input id="balanceDue" class="form-control text-right" disabled>
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
