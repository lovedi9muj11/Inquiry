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
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="${contextPath}/resources/css/maximus.css" rel="stylesheet">
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
	
<script src="${contextPath}/resources/js/other_customer.js" type="text/javascript"></script>
<script src="${contextPath}/resources/js/utils.js" type="text/javascript"></script>
<script src="${contextPath}/resources/lib/autoNumeric-1.7.4.js"></script>

<title>ลูกค้าขาจร</title>

</head>
<body>
	<header class="header_page"></header>
	<!-- main panel -->
	<div  style="padding: 30px 10px 50px 50px">
		<h1 class="page-header"></h1>
		<div class="panel">
			<div class="panel-heading">ค้นหาข้อมูล</div>
			<div class="panel-body">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-3 control-label text-right">ชื่อลูกค้า</label>
						<div class="col-md-3">
							<input type="text" id="nameCust" name="nameCust" class="form-control text-left">
						</div>
						<label class="col-md-1 control-label text-right">Tax ID</label>
						<div class="col-md-3">
							<input type="text" id="taxId" name="taxId" class="form-control text-left">
						</div>
					</div>
				</div>

			</div>
			
			<div class="box-footer">
				<div class="row" style="padding-bottom:10px">
					<!-- Button -->
					<div class="col-md-12 text-center">
						<button id="searchCriteria" name="searchCriteria" class="btn btn-primary" onclick="search()" style="width: 7%">ค้นหา</button>
						<button id="clearCriteria" name="clearCriteria" class="btn btn-danger" style="width: 7%">ลบ</button>
					</div>
				</div>
			</div>
		</div>
		
		
		<div class="panel">
			<div class="panel-heading">ข้อมูลลูกค้าขาจร</div>
			<div class="panel-body">
				<div class="col-md-12">
					<div class="box box-solid">
						<div class="box-body">
							<table id="otherCustomerTB" class="table table-bordered">
						    <thead>
						        <tr>
									<th style="text-align: center;" width="5%">#</th>
									<th style="text-align: center;" width="10%">ชื่อลูกค้า</th>
									<th style="text-align: center;" width="10%">TAX ID</th>
									<th style="text-align: center;" width="40%">ที่อยู่</th>
									<th style="text-align: center;" width="10%"></th>
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
