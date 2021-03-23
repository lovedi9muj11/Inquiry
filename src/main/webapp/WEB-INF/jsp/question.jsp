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
<script src="${contextPath}/resources/js/question.js"></script>
<script src="${contextPath}/resources/js/HoldOn.js"></script>
<link href="${contextPath}/resources/css/styles/style.css" rel="stylesheet">

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
		<div class="panel-heading bHead" style="background-color: #2BB2B6;">แบบสอบถาม</div>
		<div class="panel" style="padding: 10px">
		<br />
			<div class="row">
				<div class="col-md-12 col-sm-12">
					<div class="panel panel-default glasshd">
						<div class="panel-body">
							<div class="row">
								<label class="col-md-1 control-label">ประเภท : </label>
								<div class="col-md-3">
									<select class="groupType form-control col-md-6" name="groupType" id="groupType" list="groupTypeDropdown" listKey="value" listValue="name">
									</select>
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
															<th rowspan="2" style="text-align: center;" width="5%">ข้อ</th>
															<th rowspan="2" style="text-align: center;" width="20%">ประเด็นหลักการวิเคราะห์</th>
															<th colspan="5" style="text-align: center;" width="50%">ระดับความสำคัญในการพิจารณาสินเชื่อ</th>
														</tr>
														<tr>
															<th style="text-align: center;" width="5%">มากที่สุด</th>
															<th style="text-align: center;" width="5%">มาก</th>
															<th style="text-align: center;" width="5%">ปานกลาง</th>
															<th style="text-align: center;" width="5%">น้อย</th>
															<th style="text-align: center;" width="5%">น้อยที่สุด</th>
														</tr>
													</thead>
													<tbody>
														<tr>
															<td colspan="7">1.ด้านการวิเคราะห์คุณลักษณะของผู้ขอสินเชื่อ (Character)</td>
														</tr>
														<tr>
															<td style="text-align: center;">1.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านพื้นฐานครอบครัว</td>
															<td style="text-align: center;">
																<input type="radio" name="q1" id="q15" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q1" id="q14" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q1" id="q13" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q1" id="q12" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q1" id="q11" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">2.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านการศึกษา</td>
															<td style="text-align: center;">
																<input type="radio" name="q2" id="q25" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q2" id="q24" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q2" id="q23" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q2" id="q22" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q2" id="q21" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">3.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านฐานะทางสังคม</td>
															<td style="text-align: center;">
																<input type="radio" name="q3" id="q35" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q3" id="q34" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q3" id="q33" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q3" id="q32" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q3" id="q31" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">4.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านประสบการณ์</td>
															<td style="text-align: center;">
																<input type="radio" name="q4" id="q45" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q4" id="q44" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q4" id="q43" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q4" id="q42" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q4" id="q41" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">5.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านความรับผิดชอบและซื่อสัตย์</td>
															<td style="text-align: center;">
																<input type="radio" name="q5" id="q55" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q5" id="q54" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q5" id="q53" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q5" id="q52" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q5" id="q51" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">6.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านอารมณ์</td>
															<td style="text-align: center;">
																<input type="radio" name="q6" id="q65" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q6" id="q64" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q6" id="q63" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q6" id="q62" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q6" id="q61" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">7.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านข้อมูลอ้างอิงจากแหล่งอื่น</td>
															<td style="text-align: center;">
																<input type="radio" name="q7" id="q75" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q7" id="q74" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q7" id="q73" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q7" id="q72" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q7" id="q71" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">8.</td>
															<td style="text-align: center;">การตรวจสอบคุณสมบัติของผู้กู้ด้านความสามารถพิเศษ</td>
															<td style="text-align: center;">
																<input type="radio" name="q8" id="q85" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q8" id="q84" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q8" id="q83" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q8" id="q82" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q8" id="q81" value="1">
															</td>
														</tr>
														<tr>
															<td colspan="7">2.ด้านการวิเคราะห์ความสามารถในการชำระหนี้ (Capacity)</td>
														</tr>
														<tr>
															<td style="text-align: center;">1.</td>
															<td style="text-align: center;">การตรวจสอบความสามารถของผู้กู้ด้านรายได้</td>
															<td style="text-align: center;">
																<input type="radio" name="q9" id="q95" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q9" id="q94" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q9" id="q93" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q9" id="q92" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q9" id="q91" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">2.</td>
															<td style="text-align: center;">การตรวจสอบประวัติการชำระหนี้ที่ผ่านมา</td>
															<td style="text-align: center;">
																<input type="radio" name="q10" id="q105" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q10" id="q104" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q10" id="q103" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q10" id="q102" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q10" id="q101" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">3.</td>
															<td style="text-align: center;">การตรวจสอบความสามารถในการหารายได้อื่น นอกจากรายได้หลัก</td>
															<td style="text-align: center;">
																<input type="radio" name="q11" id="q115" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q11" id="q114" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q11" id="q113" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q11" id="q112" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q11" id="q111" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">4.</td>
															<td style="text-align: center;">การตรวจสอบความสามารถของผู้กู้เกี่ยวกับแนวโน้มทางการเงินในอนาคต</td>
															<td style="text-align: center;">
																<input type="radio" name="q12" id="q125" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q12" id="q124" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q12" id="q123" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q12" id="q122" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q12" id="q121" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">5.</td>
															<td style="text-align: center;">การตรวจสอบข้อมูลค่าใช้จ่ายอื่นที่มีผลต่อรายได้การวิเคราะห์ส่วนของทุน</td>
															<td style="text-align: center;">
																<input type="radio" name="q13" id="q135" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q13" id="q134" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q13" id="q133" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q13" id="q132" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q13" id="q131" value="1">
															</td>
														</tr>
														<tr>
															<td colspan="7">3.ด้านการวิเคราะห์ส่วนของทุน (Capital)</td>
														</tr>
														<tr>
															<td style="text-align: center;">1.</td>
															<td style="text-align: center;">การตรวจสอบความพอเพียงส่วนเงินทุนของผู้ขอสินเชื่อที่มีในการดำเนินงาน</td>
															<td style="text-align: center;">
																<input type="radio" name="q14" id="q145" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q14" id="q144" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q14" id="q143" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q14" id="q142" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q14" id="q141" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">2.</td>
															<td style="text-align: center;">การตรวจสอบความสามารถของผู้ขอสินเชื่อในการจัดหาทุนเพิ่ม กรณีที่ต้องการทุนเพิ่ม</td>
															<td style="text-align: center;">
																<input type="radio" name="q15" id="q155" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q15" id="q154" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q15" id="q153" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q15" id="q152" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q15" id="q151" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">3.</td>
															<td style="text-align: center;">การตรวจสอบทรัพย์สินอื่น นอกจากที่ผู้ขอสินเชื่อใช้เป็นทุนในกิจการ</td>
															<td style="text-align: center;">
																<input type="radio" name="q16" id="q165" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q16" id="q164" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q16" id="q163" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q16" id="q162" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q16" id="q161" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">4.</td>
															<td style="text-align: center;">การตรวจสอบโครงสร้างเงินทุนของผู้กู้ยืม</td>
															<td style="text-align: center;">
																<input type="radio" name="q17" id="q175" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q17" id="q174" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q17" id="q173" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q17" id="q172" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q17" id="q171" value="1">
															</td>
														</tr>
														<tr>
															<td colspan="7">4.ด้านการวิเคราะห์หลักประกันสินเชื่อ (Collateral)</td>
														</tr>
														<tr>
															<td style="text-align: center;">1.</td>
															<td style="text-align: center;">การตรวจสอบสภาพคล่องของหลักประกัน</td>
															<td style="text-align: center;">
																<input type="radio" name="q18" id="q185" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q18" id="q184" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q18" id="q183" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q18" id="q182" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q18" id="q181" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">2.</td>
															<td style="text-align: center;">การตรวจสอบเกี่ยวกับความพอเพียงของหลักประกัน หรือการค้ำประกัน</td>
															<td style="text-align: center;">
																<input type="radio" name="q19" id="q195" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q19" id="q194" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q19" id="q193" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q19" id="q192" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q19" id="q191" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">3.</td>
															<td style="text-align: center;">ความสำคัญเกี่ยวกับมูลค่าของหลักประกันต่อสินเชื่อ</td>
															<td style="text-align: center;">
																<input type="radio" name="q20" id="q205" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q20" id="q204" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q20" id="q203" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q20" id="q202" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q20" id="q201" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">4.</td>
															<td style="text-align: center;">การตรวจสอบหลักทรัพย์อื่นที่ผู้ขอสินเชื่อไม่ได้นำมาเป็นหลักประกัน</td>
															<td style="text-align: center;">
																<input type="radio" name="q21" id="q215" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q21" id="q214" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q21" id="q213" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q21" id="q212" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q21" id="q211" value="1">
															</td>
														</tr>
														<tr>
															<td colspan="7">5.ด้านสภาพผลกระทบจากเศรษฐกิจโดยทั่ว ๆ ไป (Condition)</td>
														</tr>
														<tr>
															<td style="text-align: center;">1.</td>
															<td style="text-align: center;">การตรวจสอบข้อมูลด้านนโยบายของรัฐบาล</td>
															<td style="text-align: center;">
																<input type="radio" name="q22" id="q225" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q22" id="q224" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q22" id="q223" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q22" id="q222" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q22" id="q221" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">2.</td>
															<td style="text-align: center;">การตรวจสอบข้อมูลด้านสภาพทางการเมือง</td>
															<td style="text-align: center;">
																<input type="radio" name="q23" id="q235" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q23" id="q234" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q23" id="q233" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q23" id="q232" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q23" id="q231" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">3.</td>
															<td style="text-align: center;">การตรวจสอบข้อมูลด้านสภาวะทางด้านแรงงาน</td>
															<td style="text-align: center;">
																<input type="radio" name="q24" id="q245" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q24" id="q244" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q24" id="q243" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q24" id="q242" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q24" id="q241" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">4.</td>
															<td style="text-align: center;">การตรวจสอบข้อมูลด้านการเงิน</td>
															<td style="text-align: center;">
																<input type="radio" name="q25" id="q255" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q25" id="q254" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q25" id="q253" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q25" id="q252" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q25" id="q251" value="1">
															</td>
														</tr>
														<tr>
															<td style="text-align: center;">5.</td>
															<td style="text-align: center;">การตรวจสอบข้อมูลด้านการคลังที่มีผลต่อการชำระหนี้ของลูกค้า</td>
															<td style="text-align: center;">
																<input type="radio" name="q26" id="q265" value="5">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q26" id="q264" value="4">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q26" id="q263" value="3">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q26" id="q262" value="2">
															</td>
															<td style="text-align: center;">
																<input type="radio" name="q26" id="q261" value="1">
															</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div class="col-md-12 mt-4 center">
									<button type="button" id="search" class="btn btn-primary btn3d" onclick="save()"><span id="icon" class="fa fa-save"></span> บันทึก</button>
									<button type="button" id="search" class="btn btn-danger btn3d" onclick="cancel()"><span id="icon" class="fa fa-plus"></span> ยกเลิก</button>
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

</body>
<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>