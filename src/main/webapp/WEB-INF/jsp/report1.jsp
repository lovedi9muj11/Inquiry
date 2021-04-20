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
<script type="text/javascript"
	src="${contextPath}/resources/css/styles/DataTables/datatables.min.js"></script>
<script type="text/javascript"
	src="${contextPath}/resources/css/styles/DataTables/DataTables-1.10.15/js/dataTables.bootstrap.js"></script>
<script src="${contextPath}/resources/js/report1.js"></script>
<script src="${contextPath}/resources/js/HoldOn.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
<title>Menu</title>

<script type="text/javascript">
	var PLS_SELECT = 'กรุณาเลือก';
	var RPT_CODE = 'report1';
</script>

<%
	String rptCode = "";
%>
<%
	rptCode = (String) request.getAttribute("rptCode");
%>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/select2.min.css"
	rel="stylesheet">

</head>
<body>
	<div id="wrapper">
		<jsp:include page="../layout/header.jsp"></jsp:include>
		<jsp:include page="../layout/menu.jsp"></jsp:include>
		<header class="header_page"></header>

		<form id="reportFrom" method="post" class="form-horizontal" role="form">
			<input name="rptCode" id="rptCode" value="<%=rptCode%>" type="hidden">
			<div id="page-content-wrapper">
				<br />
				<div class="container-fluid">
					<div class="panel-heading bHead">ข้อมูล</div>
					<div class="row">
<!-- 						<div class="col-md-12 ml-2 mt-3 mb-3 text-right"> -->
<!-- 							<div class="col-md-12"> -->
<!-- 								<button type="button" class="btn btn-info btn3d" onclick="printReport()"><span id="icon" class="fa fa-print"></span>เพิ่มข้อมูล</button> -->
<!-- 							</div> -->
<!-- 						</div> -->
					</div>
					<div class="panel" id="report">
					</div>
<!-- 					<div id="editor"></div> -->
				</div>
			</div>
		</form>
	</div>

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>