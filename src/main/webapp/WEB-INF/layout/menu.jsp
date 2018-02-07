<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../commons/includes.jsp"></jsp:include>
<jsp:include page="../commons/sMainStyles.jsp"></jsp:include>

		<!-- sidebar -->
		<div id="wrapper">
			<div id="sidebar-wrapper">
				<nav class="navbar navbar-default sidebar" role="navigation">
				<div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
			      <ul class="nav navbar-nav">

			        <li class="active"><a href="/">หน้าจอหลัก<span style="font-size:18px;" class="pull-right hidden-xs showopacity fa fa-home">
			        </span></a></li>

					<li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage<span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs showopacity fa fa-file-text-o"></span></a>
			          <ul class="dropdown-menu forAnimate" role="menu">
			            <li><a href="/userManageMent">UsermanageMent</a></li>
			          </ul>
			        </li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">ชำระค่าบริการ<span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs glyphicon glyphicon-usd"></span></a>
			          <ul class="dropdown-menu forAnimate" role="menu">
			            <li><a href="/gotoPayment">ชำระค่าบริการ</a></li>
			            <li><a href="/payOther">ชำระค่าบริการอื่นๆ</a></li>
			          </ul>
			        </li>
			        <li class="dropdown">
			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">ยกเลิกชำระค่าบริการ<span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs glyphicon glyphicon-usd"></span></a>
			          <ul class="dropdown-menu forAnimate" role="menu">
			            <li><a href="/cancalPayment">ยกเลิกชำระค่าบริการ</a></li>
			          </ul>
			        </li>

<!-- 			        <li class="dropdown"> -->
<!-- 			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">ใบกำกับการขน <span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs showopacity fa fa-truck"></span></a> -->
<!-- 			          <ul class="dropdown-menu forAnimate" role="menu"> -->
<!-- 			            <li><a href="tp01/tp10001-init.html">แบบที่ 1</a></li> -->
<!-- 						<li><a href="tp02/tp20001-init.html">แบบที่ 2</a></li> -->
<!-- 			          </ul> -->
<!-- 			        </li> -->

<!-- 			        <li class="dropdown"> -->
<!-- 			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">งบเดือน <span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs showopacity fa fa-money"></span></a> -->
<!-- 			          <ul class="dropdown-menu forAnimate" role="menu"> -->
<!-- 			            <li><a href="sk04/sk40001-init.html">ผู้ผลิต</a></li> -->
<!-- 						<li><a href="sk04/sk40005-init.html">ผู้นำเข้า</a></li> -->
<!-- 						<li><a href="sk04/sk40009-init.html">ตัวแทน</a></li> -->
<!-- 						<li><a href="sk04/sk40013-init.html">ผู้ใช้</a></li> -->
<!-- 			          </ul> -->
<!-- 			        </li> -->

<!-- 			        <li class="dropdown"> -->
<!-- 			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">จัดการกิจการ <span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs showopacity fa fa-industry"></span></a> -->
<!-- 			          <ul class="dropdown-menu forAnimate" role="menu"> -->
<!-- 			            <li><a href="manage/mn10001-init.html">ยกเลิกกิจการ</a></li>	 -->
<!-- 						<li><a href="manage/mn10005-init.html">โอนกิจการ</a></li> -->
<!-- 						<li><a href="manage/mn10009-init.html">ย้ายกิจการ</a></li>								 -->
<!-- 						<li><a href="manage/mn10013-init.html">ควบกิจการ</a></li> -->
<!-- 			          </ul> -->
<!-- 			        </li> -->

<!-- 			        <li class="dropdown"> -->
<!-- 			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">ข้อมูลพื้นฐาน <span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs showopacity fa fa-address-card-o"></span></a> -->
<!-- 			          <ul class="dropdown-menu forAnimate" role="menu"> -->
<!-- 			            <li><a href="master/ms10001-init.html">ผู้ประกอบการ</a></li> -->
<!-- 						<li><a href="master/ms10005-init.html">ชนิดสารละลาย</a></li> -->
<!-- 						<li><a href="master/ms10009-init.html">วัตถุประสงค์การใช้สารละลาย</a></li> -->
<!-- 						<li><a href="master/ms10013-init.html">สถานที่เก็บสารละลาย</a></li> -->
<!-- 			          </ul> -->
<!-- 			        </li> -->

<!-- 			        <li class="dropdown"> -->
<!-- 			          <a href="#" class="dropdown-toggle" data-toggle="dropdown">รายงาน <span class="caret"></span><span style="font-size:18px;" class="pull-right hidden-xs showopacity fa fa-print"></span></a> -->
<!-- 			          <ul class="dropdown-menu forAnimate" role="menu"> -->
<!-- 			            <li><a href="#">ระบบการขออนุญาต</a></li> -->
<!-- 						<li><a href="#">ระบบบริหารสินค้า</a></li> -->
<!-- 						<li><a href="#">ระบบการติดตาม</a></li> -->
<!-- 						<li><a href="#">ระบบตรวจสอบและแจ้งเตือน</a></li> -->
<!-- 			          </ul> -->
<!-- 			        </li> -->
			      </ul>
			    </div>	
				</nav>
			</div>
			<!-- /#sidebar -->	
		</div>