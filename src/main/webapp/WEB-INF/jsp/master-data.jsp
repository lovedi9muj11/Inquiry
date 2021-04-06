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
<script src="${contextPath}/resources/js/master-data.js"></script>
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
					<div class="panel-heading bHead" style="background-color: #2BB2B6;">จัดการข้อมูล</div>
					<div class="panel">
						<br />
						
						<div class="row">
							<div class="col-md-12 col-sm-12">
								<div class="panel panel-default glasshd">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse1">Master Data Group</a>
										</h4>
									</div>
									<div id="collapse1" class="panel-collapse collapse">
										<div class="panel-body">
<!-- 												<div class="form-group"> -->
<!-- 													<label class="col-md-2 control-label right">Group Code : </label> -->
<!-- 													<div class="col-md-3 right"> -->
<!-- 														<input type="text" id="name" class="form-control"></input> -->
<!-- 													</div> -->
<!-- 													<div class="col-md-2 left"> -->
<!-- 														<button type="button" id="search" class="btn btn-primary btn3d" onclick="searchClick()">ค้นหา</button> -->
<!-- 														<button type="button" id="search" class="btn btn-success btn3d" onclick="addUser()"><span id="icon" class="fa fa-plus"></span>เพิ่มข้อมูล</button> -->
<!-- 													</div> -->
<!-- 												</div> -->
												<div class="row">
													<div class="col-md-12 ml-2">
														<button type="button" id="search" class="btn btn-success btn3d" onclick="addGroup()"><span id="icon" class="fa fa-plus"></span>เพิ่มข้อมูล</button>
													</div>
													<div class="col-md-12 col-sm-12">
														<div class="glass">
															<div class="">
																<div class="table-responsive">
																	<table id="masterGroupList" class="table table-striped table-hover">
																		<thead>
																			<tr>
																				<th style="text-align: center;" width="10%">#</th>
																				<th style="text-align: center;" width="30%">Group Code</th>
																				<th style="text-align: center;" width="40%">Group Name</th>
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

						<div class="row">
							<div class="col-md-12 col-sm-12">
								<div class="panel panel-default glasshd">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse2">Master Data</a>
										</h4>
									</div>
									<div id="collapse2" class="panel-collapse collapse in">
										<div class="panel-body">
<!-- 												<div class="form-group"> -->
<!-- 													<label class="col-md-2 control-label right">Group Code : </label> -->
<!-- 													<div class="col-md-3 right"> -->
<!-- 														<input type="text" id="name" class="form-control"></input> -->
<!-- 													</div> -->
<!-- 													<div class="col-md-2 left"> -->
<!-- 														<button type="button" id="search" class="btn btn-primary btn3d" onclick="searchClick()">ค้นหา</button> -->
<!-- 														<button type="button" id="search" class="btn btn-success btn3d" onclick="addUser()"><span id="icon" class="fa fa-plus"></span>เพิ่มข้อมูล</button> -->
<!-- 													</div> -->
<!-- 												</div> -->
												<div class="row">
													<div class="col-md-12 ml-2">
														<button type="button" id="search2" class="btn btn-success btn3d" onclick="addData()"><span id="icon" class="fa fa-plus"></span>เพิ่มข้อมูล</button>
													</div>
													<div class="col-md-12 col-sm-12">
														<div class="glass">
															<div class="">
																<div class="table-responsive">
																	<table id="masterList" class="table table-striped table-hover">
																		<thead>
																			<tr>
																				<th style="text-align: center;" width="10%">#</th>
																				<th style="text-align: center;" width="20%">Group Code</th>
																				<th style="text-align: center;" width="20%">Code</th>
																				<th style="text-align: center;" width="20%">Name</th>
																				<th style="text-align: center;" width="20%">คะแนน</th>
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
						
						<div class="row">
							<div class="col-md-12 col-sm-12">
								<div class="panel panel-default glasshd">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" href="#collapse3">แบบสอบถาม</a>
										</h4>
									</div>
									<div id="collapse3" class="panel-collapse collapse in">
										<div class="panel-body">
												<div class="form-group">
													<label class="col-md-2 control-label right">ประเภทแบบสอบถาม : </label>
													<div class="col-md-3 right">
														<select class="groupType form-control col-md-6" name="questions" id="questions" onchange="searchQuestion()">
														</select>
													</div>
													<div class="col-md-2 left">
														<button type="button" id="search3" class="btn btn-success btn3d" onclick="addQuestion()"><span id="icon" class="fa fa-plus"></span>เพิ่มข้อมูล</button>
													</div>
												</div>
												<div class="row">
													<div class="col-md-12 col-sm-12">
														<div class="glass">
															<div class="">
																<div class="table-responsive">
																	<table id="questionList" class="table table-striped table-hover">
																		<thead>
																			<tr>
																				<th style="text-align: center;" width="10%">#</th>
																				<th style="text-align: center;" width="20%">Code</th>
																				<th style="text-align: center;" width="20%">Name</th>
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
	
	<div class="modal fade"  role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="addDataGroup" >
	  <div class="modal-dialog modal-sm" style="width:650px">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">ข้อมูล</h4>
	      </div>
		<div class="modal-body">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label text-right">Group Name<span style="color: red"> *</span></label>
					<div class="col-md-9">
						<input type="text" name="groupName" id="groupName" class="form-control text-left">
						<p id="sgroupName" style="color: red; display: none">คุณยังไม่ได้กรอก Group Name</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label text-right">Group Code<span style="color: red"> *</span></label>
					<div class="col-md-9">
						<input type="text" name="groupCode" id="groupCode" class="form-control text-left">
						<p id="sgroupCode" style="color: red; display: none">คุณยังไม่ได้กรอก Group Code</p>
					</div>
				</div>
			</div>
	    	</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success btn3d" id="modal-btn-add-yes" onclick="modalConfirmAddGroup(true)">บักทึก</button>
	        <button type="button" class="btn btn-danger btn3d" id="modal-btn-add-no" onclick="modalConfirmAddGroup(false)">ยกเลิก</button>
	      </div>
	    </div>
	  </div>
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
					<label class="col-md-3 control-label text-right">Group<span style="color: red"> *</span></label>
					<div class="col-sm-9">
						<select class="groupType form-control col-md-6" name="groups" id="groups">
						</select>
						<p id="sgroups" style="color: red; display: none">กรุณาเลือก Group</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label text-right">Code<span style="color: red"> *</span></label>
					<div class="col-md-9">
						<input type="text" name="msCode" id="msCode" class="form-control text-left">
						<p id="smsCode" style="color: red; display: none">คุณยังไม่ได้กรอก Code</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label text-right">Name<span style="color: red"> *</span></label>
					<div class="col-md-9">
						<input type="text" name="msName" id="msName" class="form-control text-left">
						<p id="smsName" style="color: red; display: none">คุณยังไม่ได้กรอก Name</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label text-right">คะแนน<span style="color: red"> *</span></label>
					<div class="col-md-9">
						<input type="text" name="msScore" id="msScore" class="form-control text-left">
						<p id="smsScore" style="color: red; display: none">คุณยังไม่ได้กรอก คะแนน</p>
					</div>
				</div>
			</div>
	    	</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success btn3d" id="modal-btn-add-yes" onclick="modalConfirmAdd(true)">บักทึก</button>
	        <button type="button" class="btn btn-danger btn3d" id="modal-btn-add-no" onclick="modalConfirmAdd(false)">ยกเลิก</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<div class="modal fade"  role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="addQuestion" >
	  <div class="modal-dialog modal-sm" style="width:650px">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">ข้อมูล</h4>
	      </div>
		<div class="modal-body">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label text-right">Code<span style="color: red"> *</span></label>
					<div class="col-md-9">
						<input type="text" name="qCode" id="qCode" class="form-control text-left">
						<p id="sqCode" style="color: red; display: none">คุณยังไม่ได้กรอก Code</p>
					</div>
				</div>
				<div class="form-group col-md-12">
					<label class="col-md-3 control-label text-right">Name<span style="color: red"> *</span></label>
					<div class="col-md-9">
						<input type="text" name="qName" id="qName" class="form-control text-left">
						<p id="sqName" style="color: red; display: none">คุณยังไม่ได้กรอก Name</p>
					</div>
				</div>
			</div>
	    	</div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-success btn3d" id="modal-btn-add-yes" onclick="modalConfirmQuestion(true)">บักทึก</button>
	        <button type="button" class="btn btn-danger btn3d" id="modal-btn-add-no" onclick="modalConfirmQuestion(false)">ยกเลิก</button>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>