<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<script src="${contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
<script src="${contextPath}/resources/js/userMgt.js"></script>
<script src="${contextPath}/resources/js/HoldOn.js"></script>

<script type="text/javascript">
var PLS_SELECT = 'กรุณาเลือก';
</script>

<title>Menu</title>

<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div id="wrapper">
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp"></jsp:include>
	<header class="header_page"></header>

<form id="reportFrom" method="post" class="form-horizontal" role="form" >
	<div id="page-content-wrapper">
	<input name="rptCode" id="rptCode" value="${paymentResultReq.rptCode}" type="hidden">
		<br />
		<div class="container-fluid">
		<div class="panel-heading bHead" style="background-color: #2BB2B6;">จัดการข้อมูล</div>
		<div class="panel" style="padding: 10px">
		<br />
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="panel panel-default glasshd">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" href="#collapse2">User Data</a>
							</h4>
						</div>
						<div id="collapse2" class="panel-collapse collapse in">
							<div class="panel-body">
<!-- 								<div class="glass"> -->
									<div class="form-group">
										<label class="col-md-2 control-label right">ชื่อ : </label>
										<div class="col-md-3 right">
											<input type="text" id="name" class="form-control"></input>
										</div>
										<div class="col-md-2 left">
											<button type="button" id="search" class="btn btn-primary btn3d" onclick="searchClick()">ค้นหา</button>
											<button type="button" id="search" class="btn btn-success btn3d" onclick="addUser()"><span id="icon" class="fa fa-plus"></span>เพิ่มผู้ใช้งาน</button>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12 col-sm-12">
											<div class="glass">
												<div class="">
													<div class="table-responsive">
														<table id="masterList" class="table table-striped table-hover">
															<thead>
																<tr>
																	<th style="text-align: center;" width="10%">#</th>
																	<th style="text-align: center;" width="20%">ชื่อ</th>
																	<th style="text-align: center;" width="20%">นามสกุล</th>
																	<th style="text-align: center;" width="20%">Role</th>
																	<th style="text-align: center;" width="20%">UserName</th>
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
<!-- 								</div> -->
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

<div class="modal fade"  role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true" id="addUser" >
  <div class="modal-dialog modal-sm" style="width:650px">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">ผู้ใช้งาน</h4>
      </div>
	<div class="modal-body">
		<div class="row">
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label text-right">ชื่อ<span style="color: red"> *</span></label>
				<div class="col-md-9">
					<input type="text" name="fname" id="fname" class="form-control text-left">
					<p id="sfname" style="color: red; display: none">คุณยังไม่ได้กรอก ชื่อ</p>
				</div>
			</div>
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label text-right">นามสกุล<span style="color: red"> *</span></label>
				<div class="col-md-9">
					<input type="text" name="surname" id="surname" class="form-control text-left">
					<p id="ssurname" style="color: red; display: none">คุณยังไม่ได้กรอก นามสกุล</p>
				</div>
			</div>
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label text-right">Role<span style="color: red"> *</span></label>
				<div class="col-sm-9">
					<select class="groupType form-control col-md-6" name="roles" id="roles">
					</select>
					<p id="sroles" style="color: red; display: none">กรุณาเลือก Role</p>
				</div>
			</div>
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label text-right">ชื่อผู้ใช้<span style="color: red"> *</span></label>
				<div class="col-md-9">
					<input type="text" name="username" id="username" class="form-control text-left">
					<p id="susername" style="color: red; display: none">คุณยังไม่ได้กรอก ชื่อผู้ใช้</p>
				</div>
			</div>
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label text-right" id="password1">รหัสผ่าน<span style="color: red"> *</span></label>
				<div class="col-md-9">
					<input type="password" name="password" id="password" class="form-control text-left">
					<p id="spassword" style="color: red; display: none">คุณยังไม่ได้กรอก รหัสผ่าน</p>
				</div>
			</div>
			<div class="form-group col-md-12">
				<label class="col-md-3 control-label text-right" id="cpassword1">ยืนยันรหัสผ่าน<span style="color: red"> *</span></label>
				<div class="col-md-9">
					<input type="password" name="cpassword" id="cpassword" class="form-control text-left">
					<p id="scpassword" style="color: red; display: none">คุณยังไม่ได้กรอก ยืนยันรหัสผ่าน</p>
					<p id="chkPass2" style="color: red; display: none">รหัสผ่าน และ ยืนยันรหัสผ่าน ไม่ตรงกัน</p>
				</div>
			</div>
		</div>
    	</div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success btn3d" id="modal-btn-add-yes" onclick="modalConfirmAddUser(true)">บักทึก</button>
        <button type="button" class="btn btn-danger btn3d" id="modal-btn-add-no" onclick="modalConfirmAddUser(false)">ยกเลิก</button>
      </div>
    </div>
  </div>
</div>
</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>