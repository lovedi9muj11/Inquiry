<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<script src="${contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/resources/lib/select2.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
<script src="${contextPath}/resources/js/score.js"></script>
<script src="${contextPath}/resources/js/HoldOn.js"></script>
<title>Menu</title>

<script type="text/javascript">
var PLS_SELECT = 'กรุณาเลือก';
</script>

<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/select2.min.css" rel="stylesheet">

</head>
<body>
	<div id="wrapper">
		<jsp:include page="../layout/header.jsp"></jsp:include>
		<jsp:include page="../layout/menu.jsp"></jsp:include>
		<header class="header_page"></header>

		<form id="masterFrom" method="post" class="form-horizontal" role="form">
			<div id="page-content-wrapper">
				<br />
				<div class="container-fluid">
					<div class="panel-heading bHead">จัดการข้อมูล</div>
					<div class="panel">
						<br />
						
						<div class="row">
							<div class="col-md-12 col-sm-12">
								<div class="panel panel-default glasshd">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse1">จัดการคะแนน แบบสอบถาม</a>
										</h4>
									</div>
									<div id="collapse1" class="panel-collapse collapse in">
										<div class="panel-body">
												<div class="row">
													<div class="col-md-12 ml-2">
														<button type="button" id="search" class="btn btn-success btn3d" onclick="addScore()"><span id="icon" class="fa fa-plus"></span>เพิ่มข้อมูล</button>
													</div>
													<div class="col-md-12 col-sm-12">
														<div class="glass">
															<div class="">
																<div class="table-responsive">
																	<table id="scoreList" class="table table-striped table-hover">
																		<thead>
																			<tr>
																				<th rowspan="2" style="text-align: center;" width="5%">#</th>
																				<th rowspan="2" style="text-align: center;" width="10%">กลุ่ม</th>
																				<th rowspan="2" style="text-align: center;" width="20%">แบบสอบถาม</th>
																				<th rowspan="2" style="text-align: center;" width="30%">แบบสอบถาม (คำถาม)</th>
																				<th colspan="5" style="text-align: center;" width="25%">ระดับคะแนน</th>
																			</tr>
																			
																			<tr>
																				<th style="text-align: center;" width="5%">มากที่สุด</th>
																				<th style="text-align: center;" width="5%">มาก</th>
																				<th style="text-align: center;" width="5%">ปานกลาง</th>
																				<th style="text-align: center;" width="5%">น้อย</th>
																				<th style="text-align: center;" width="5%">น้อยที่สุด</th>
																				<th style="text-align: center;" width="2%"></th>
																				<th style="text-align: center;" width="2%"></th>
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
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</form>
	</div>
	
	<div class="modal fade"  role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="addData" >
	  <div class="modal-dialog modal-sm" style="width:650px">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">ข้อมูล</h4>
	      </div>
		<div class="modal-body">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">กลุ่ม<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<select class="groupType form-control col-md-6" name="groups" id="groups">
						</select>
						<p id="sgroups" style="color: red; display: none">คุณยังไม่ได้เลือก กลุ่ม</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">แบบสอบถาม<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<select class="groupType form-control col-md-6" name="questions" id="questions" onchange="getQuestionByGroup()">
						</select>
						<p id="squestions" style="color: red; display: none">คุณยังไม่ได้เลือก แบบสอบถาม</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">แบบสอบถาม (คำถาม)<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<select class="groupType form-control col-md-6" name="questions2" id="questions2">
						</select>
						<p id="squestions2" style="color: red; display: none">คุณยังไม่ได้เลือก แบบสอบถาม (คำถาม)</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">คะแนน (มากที่สุด)<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<input type="text" name="score5" id="score5" class="form-control text-left">
						<p id="sscore5" style="color: red; display: none">คุณยังไม่ได้กรอก คะแนน (มากที่สุด)</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">คะแนน (มาก)<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<input type="text" name="score4" id="score4" class="form-control text-left">
						<p id="sscore4" style="color: red; display: none">คุณยังไม่ได้กรอก คะแนน (มาก)</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">คะแนน (ปานกลาง)<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<input type="text" name="score3" id="score3" class="form-control text-left">
						<p id="sscore3" style="color: red; display: none">คุณยังไม่ได้กรอก คะแนน (ปานกลาง)</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">คะแนน (น้อย)<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<input type="text" name="score2" id="score2" class="form-control text-left">
						<p id="sscore2" style="color: red; display: none">คุณยังไม่ได้กรอก คะแนน (น้อย)</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-4 control-label text-right">คะแนน (น้อยที่สุด)<span style="color: red"> *</span></label>
					<div class="col-md-8">
						<input type="text" name="score1" id="score1" class="form-control text-left">
						<p id="sscore1" style="color: red; display: none">คุณยังไม่ได้กรอก คะแนน (น้ยอที่สุด)</p>
					</div>
				</div>
			</div>
	    	</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success btn3d" id="modal-btn-add-yes" onclick="modalConfirmAddScore(true)">บันทึก</button>
	        <button type="button" class="btn btn-danger btn3d" id="modal-btn-add-no" onclick="modalConfirmAddScore(false)">ยกเลิก</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>