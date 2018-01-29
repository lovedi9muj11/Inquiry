<html>
<head>
	<jsp:include page="../layout/header.jsp"></jsp:include>
    <title>Welcome</title>
    <link href="css/custom.css" rel="stylesheet">
        
     <script src="js/custom.js"></script>
     <script src="lib/jquery-3.3.1.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="form-group">
			<div class="col-sm-12">
				<label class="col-sm-4 control-label" style="text-align: right;"><font color="red">Login</font> : </label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="user" name="" value="" maxlength="10"/>
				</div>
			</div>
		</div>
		<br />
		<div class="form-group">
			<div class="col-sm-12">
				<label class="col-sm-4 control-label" style="text-align: right;"><font color="red">Password</font> : </label>
				<div class="col-sm-4">
					<input type="password" class="form-control" id="password" name="" value="" maxlength="10"/>
				</div>
			</div>
		</div>
		<br /><div class="form-group"></div>
		<div class="form-group">
			<div class="col-sm-12 center split">
				<div class="col-sm-7"></div>
				<div class="col-sm-5">
					<button type="button" id="saveBtn" class="btn btn-success btn3d"><i class="fa fa-fw fa-save"></i> Login </button>
				</div>
			</div>
		</div>
	</div>
</body>
	<jsp:include page="../layout/footer.jsp"></jsp:include>
</html>