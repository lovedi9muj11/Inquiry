<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../layout/header.jsp"></jsp:include>
<jsp:include page="../layout/menu.jsp"></jsp:include>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<script src="${contextPath}/resources/lib/jquery-3.3.1.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/maximus.css" rel="stylesheet">
<script type="text/javascript"
	src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
<script src="${contextPath}/resources/js/questionReport.js"></script>
<title>รานงานแบบสอบถาม</title>

</head>

<body>
	<header class="header_page"></header>
	<!-- main panel -->
	<div style="padding: 30px 10px 50px 50px">
		<h1 class="page-header"></h1>
		<div class="panel" id="panel1">
			
				<div class="panel-heading bHead" >รายงานแบบสอบถาม</div>
				<input type="hidden" name="userName" id="userName" value="${pageContext.request.userPrincipal.name}" />
				<div class="panel-body">
				<form name="reportForm" id="reportForm"  class="form-horizontal" role="form">
				<input name="rptCode" id="rptCode" value="RPT_CODE" type="hidden">
<!-- 					<div class="row"> -->
<!-- 						<div class="form-group col-md-6"> -->
<!-- 							<label class="col-md-2 control-label text-right">วันที่ -->
<!-- 								:</label> -->
<!-- 							<div class="col-md-10"> -->
<!-- 								<div class='col-md-6'> -->
<!-- 									<input type='date' class="form-control" id="dateFrom" -->
<!-- 										name="dateFrom" /> -->
<!-- 								</div> -->

<!-- 							</div> -->
<!-- 						</div> -->

<!-- 						<div class="form-group col-md-6"> -->
<!-- 							<label class="col-md-2 control-label text-right">ถึงวันที่ -->
<!-- 								:</label> -->
<!-- 							<div class="col-md-10"> -->
<!-- 								<div class='col-md-6'> -->
<!-- 									<input type='date' class="form-control" id="dateTo" -->
<!-- 										name="dateTo" /> -->
<!-- 								</div> -->

<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
				</form>
<!-- 					<div class="box-footer" style="padding-bottom: 20px"> -->
<!-- 						<div class="row"> -->
<!-- 							<div class="col-md-12 text-center"> -->
<!-- 								<button id="search" name="search" class="btn btn-primary" onclick="search()" style="width: 7%">ค้นหา</button> -->
<!-- 								<button id="clear" name="clear" class="btn btn-danger" style="width: 7%">ลบ</button> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="row" style="padding-bottom: 10px; padding-right: 2px">
						<div class="col-md-3 text-right mt-2">
							<label class="control-label">ดาวน์โหลดรายงาน (คำนวณคะแนนแบบสอบถาม) : </label>
						</div>
						<div class="col-md-9 text-left">
							<button id="excel" name="excel" onclick="reportExcel()" class="btn btn-success glyphicon glyphicon-print" style="width: 7%" > Excel</button>
						</div>
					</div>

<!-- 					<div class="row"> -->
<!-- 						<div class="col-md-12"> -->
<!-- 							<div class="box box-solid"> -->
<!-- 								<div class="box-body"> -->
<!-- 									<table id="report" class="table table-bordered"> -->
<!-- 										<thead> -->
<!-- 											<tr> -->
<!-- 												<th style="text-align: center;">ลำดับที่</th> -->
<!-- 											</tr> -->
<!-- 										</thead> -->
<!-- 									</table> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->

				</div>
		</div>
	</div>
</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>
