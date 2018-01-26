<html>
<head>
    <title>Welcome</title>
    <link href="css/custom.css"
        rel="stylesheet">
        
        <script src="js/custom.js"></script>
        <script src="lib/jquery-3.3.1.min.js"></script>
</head>
<body>
    <div class="form-group">
        <div><input type="button" value="All" onclick="selectAll()"></div>
    </div>
    
    <div class="form-group">
		<div class="col-sm-12">
			<div class="table-responsive">
			<table id="table_user" class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th class="center" width="5%">xxx</th>
						<th class="center" width="75%">name</th>
						<th class="center" width="30%">surName</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			</div>
		</div>
	</div>
    
    <div class="form-group"><input type="text" class="form-control" id="name" value=""></div>
</body>
</html>