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
<title>Menu</title>

<script type="text/javascript">
	var PLS_SELECT = 'กรุณาเลือก';
	var RPT_CODE = 'report1';
</script>

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

		<form id="masterFrom" method="post" class="form-horizontal"
			role="form">
			<div id="page-content-wrapper">
				<br />
				<div class="container-fluid">
					<div class="panel-heading bHead">ข้อมูล</div>
					<div class="panel" id="report">
					
<!-- 						<div class='tableauPlaceholder' id='viz1618389936412' style='position: relative'> -->
<!-- 							<noscript> -->
<!-- 								<a href='#'> -->
<!-- 									<img alt='Sheet 2 ' src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;Bo&#47;Book1_16179876732140&#47;Sheet2&#47;1_rss.png' style='border: none' /> -->
<!-- 								</a> -->
<!-- 							</noscript> -->
<!-- 							<object class='tableauViz'  style='display:none;'> -->
<!-- 								<param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F' /> -->
<!-- 								<param name='embed_code_version' value='3' /> -->
<!-- 								<param name='site_root' value='' /> -->
<!-- 								<param name='name' value='Book1_16179876732140&#47;Sheet2' /> -->
<!-- 								<param name='tabs' value='no' /> -->
<!-- 								<param name='toolbar' value='yes' /> -->
<!-- 								<param name='static_image' value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;Bo&#47;Book1_16179876732140&#47;Sheet2&#47;1.png' /> -->
<!-- 								<param name='animate_transition' value='yes' /> -->
<!-- 								<param name='display_static_image' value='yes' /> -->
<!-- 								<param name='display_spinner' value='yes' /> -->
<!-- 								<param name='display_overlay' value='yes' /> -->
<!-- 								<param name='display_count' value='yes' /> -->
<!-- 								<param name='language' value='en' /> -->
<!-- 								<param name='filter' value='publish=yes' /> -->
<!-- 							</object> -->
<!-- 						</div> -->
					
					</div>
				</div>
			</div>
		</form>
	</div>

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>