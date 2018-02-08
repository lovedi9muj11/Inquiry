$(document).ready(function() {
	findTypePayment();
	findBank();
	findBankNo();
});

function findTypePayment() {
	var result = document.getElementById("typePayment").value;
	var credit = document.getElementById("credit");
	var check = document.getElementById("check");
	var money = document.getElementById("money");
	if (result == 'credit') {
		credit.style.display = "block";
		check.style.display = "none";
		money.style.display = "none";
	} else if (result == 'money') {
		credit.style.display = "none";
		check.style.display = "none";
		money.style.display = "block";
	} else if (result == 'check') {
		credit.style.display = "none";
		check.style.display = "block";
		money.style.display = "none";
	}
}

function findBank(){
	var bankNo = document.getElementById("bankNo").value;
	var bankName = document.getElementById("bankName").value;
	if(bankNo == "001"){
		$('#bankName').val("ktb");
	}else if(bankNo == "002"){
		$('#bankName').val("scb");
	}else if(bankNo == "003"){
		$('#bankName').val("kbk");
	}
}

function findBankNo(){
	var bankNo = document.getElementById("bankNo").value;
	var bankName = document.getElementById("bankName").value;
	if(bankName == "ktb"){
		$('#bankNo').val("001");
	}else if(bankName == "scb"){
		$('#bankNo').val("002");
	}else if(bankName == "kbk"){
		$('#bankNo').val("003");
	}
}

function addRow() {
	var table = document.getElementById("deductibleTable").rows.length;
	var radioButtons = document.getElementsByName("radioDed");
	var radioResult = "";
	for (var x = 0; x < radioButtons.length; x++) {
		if (radioButtons[x].checked) {
			radioResult = radioButtons[x].value;
		}
	}

	var docDed = $("#docDed").val();
	var moneyDed = $("#moneyDed").val();
	var count = 1;

	for (count; count < table; count++) {
		count + table;
	}
	var markup = "<tr><td>"+ count+ "</td><td>"	+ "test1"+ "</td><td>"+ docDed+ "</td><td>"	+ radioResult+ "</td><td>"	+ moneyDed+ "</td><td><a onclick='myDeleteFunction()'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";

	$("#deductibleTable").find('tbody').append(markup);
	var docDed = $("#docDed").val("");
	var moneyDed = $("#moneyDed").val("");
};

function myDeleteFunction() {
	var table = document.getElementById("deductibleTable");
	if (table.rows.length > 0) {
		table.deleteRow(1);
	}
}
function myDeleteDed() {
	var tableDed = document.getElementById("showDeductibleTable");
	if(tableDed.rows.length > 0){
		tableDed.deleteRow(1);
	}
}


function addDataTableDed(){
	var oTable = document.getElementById('deductibleTable');
	var result = [];
	var deduction = $("#deduction").val();
	var rowLength = oTable.rows.length; 
	for (i = 1; i < rowLength; i++){
	   var oCells = oTable.rows.item(i).cells;
	   for(var fs =0; fs< oCells.length; fs++){
		   result.push(oCells[fs].innerHTML);
	   }

	   var markup = "<tr><td>"+ i+ "</td><td>"+ "ภาษีหัก ณ ที่จ่าย" + "</td><td>"+ result[4]+ "</td><td><a onclick='myDeleteDed()'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
	   $("#showDeductibleTable").find('tbody').append(markup);
	   var markup1 = "<tr><td>"+ i+ "</td><td>"+ deduction + "</td><td>"+ result[1]+ "</td><td>"+ result[2]+ "</td><td>"+ result[3]+ "</td><td>"+ result[4]+ "</td></tr>";
	   $("#sumDeductibleTable").find('tbody').append(markup1);
	}
	for(var i = document.getElementById("deductibleTable").rows.length; i > 1;i--){
	document.getElementById("deductibleTable").deleteRow(i -1);	}
}

function addDataTableMoneyTranPrice(){
	var table = document.getElementById("showTotalPriceTable").rows.length;
	var money = $("#moneyTran").val();
	var nameMode = "เงินสด";
	var count = parseInt(1);
	for (count; count < table; count++) {
		count
	}
	
	var markup = "<tr><td>"+ count + "</td><td>"+ nameMode + "</td><td>"+ money+ "</td><td><a onclick='myDeleteSumCreditTranPrice("+count+")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
	$("#showTotalPriceTable").find('tbody').append(markup);
	var markup1 = "<tr><td>"+ count+ "</td><td>"+ nameMode + "</td><td>"+ money+ "</td></tr>";
	$("#sumTotalPriceTable").find('tbody').append(markup1);
	
	$("#moneyTran").val("");
}

function addDataSumCreditTranPrice(){
	var table = document.getElementById("showTotalPriceTable").rows.length;
	var oTable = document.getElementById('creditTable');
	var result = [];
	var nameMode = "บัตรเครดิต";
	var rowLength = oTable.rows.length; 
	var count = parseInt(0);
	for (count; count < table; count++) {
		count
	}
	for (i = 1; i < rowLength; i++){
		   var oCells = oTable.rows.item(i).cells;
		   for(var fs =0; fs< oCells.length; fs++){
			   result.push(oCells[fs].innerHTML);
		   }

		   var markup = "<tr><td>"+ count+ "</td><td>"+ nameMode + "</td><td>"+ result[4]+ "</td><td><a onclick='myDeleteSumCreditTranPrice("+count+")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		   $("#showTotalPriceTable").find('tbody').append(markup);
		   var markup1 = "<tr><td>"+ i+ "</td><td>"+ nameMode + "</td><td>"+ result[1]+ "</td><td>"+ result[1]+ "</td><td>"+ result[2]+ "</td><td>"+ result[3]+ "</td><td>"+ result[4]+ "</td></tr>";
		   $("#sumTotalPriceTable").find('tbody').append(markup1);
		}
	for(var i = document.getElementById("creditTable").rows.length; i > 1;i--){
		document.getElementById("creditTable").deleteRow(i -1);	}
}

function addDataSumCheckTranPrice(){
	var table = document.getElementById("showTotalPriceTable").rows.length;
	var oTable = document.getElementById('checkTable');
	var result = [];
	var nameMode = "เช็ค";
	var rowLength = oTable.rows.length; 
	var count = parseInt(0);
	for (count; count < table; count++) {
		count
	}
	for (i = 1; i < rowLength; i++){
		   var oCells = oTable.rows.item(i).cells;
		   for(var fs =0; fs< oCells.length; fs++){
			   result.push(oCells[fs].innerHTML);
		   }

		   var markup = "<tr><td>"+ count+ "</td><td>"+ nameMode + "</td><td>"+ result[6]+ "</td><td><a onclick='myDeleteSumCreditTranPrice("+count+")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		   $("#showTotalPriceTable").find('tbody').append(markup);
		   var markup1 = "<tr><td>"+ i+ "</td><td>"+ nameMode + "</td><td>"+ result[1]+ "</td><td>"+ result[2]+ "</td><td>"+ result[3]+ "</td><td>"+ result[4]+ "</td><td>"+ result[5]+ "</td><td>"+ result[6]+ "</td></tr>";
		   $("#sumTotalPriceTable").find('tbody').append(markup1);
		}
	for(var i = document.getElementById("checkTable").rows.length; i > 1;i--){
		document.getElementById("checkTable").deleteRow(i -1);	}
}

function addDataTablecreditTranPrice(){
	var table = document.getElementById("creditTable").rows.length;
	var creditType = document.getElementById("creditType").value;
	var edcType = document.getElementById("edcType").value;
	var creditNo = $("#creditNo").val();
	var creditPrice = $("#creditPrice").val();
	var nameMode = "บัตรเครดิต";
	var count = parseInt(1);
	for (count; count < table; count++) {
		count
	}
	var markup = "<tr><td>"+ count + "</td><td>"+ creditType + "</td><td>"+ creditNo+ "</td><td>"+ edcType+ "</td><td>"+ creditPrice+ "</td><td><a onclick='myDeletecreditTranPrice("+count+")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
	$("#creditTable").find('tbody').append(markup);
	
	$("#creditNo").val("");
	$("#creditPrice").val("");
	$("#edcType").val("");
	$("#creditType").val("");
}

function sumTranPrice(){
	var result = document.getElementById("typePayment").value;
	if (result == 'credit') {
		addDataSumCreditTranPrice();
	} else if (result == 'money') {
		addDataTableMoneyTranPrice();
	} else if (result == 'check') {
		addDataSumCheckTranPrice();
	}
}
function myDeletecreditTranPrice(count) {
	var tablesumTotal = document.getElementById("creditTable");
	if(tablesumTotal.rows.length > 0){
		tablesumTotal.deleteRow(count);
	}
}
function myDeleteSumCreditTranPrice(count) {
	var tablesumTotals = document.getElementById("showTotalPriceTable");
	if(tablesumTotals.rows.length > 0){
		tablesumTotals.deleteRow(count);
	}
}

function addDataTableCheck(){
	
	var table = document.getElementById("checkTable").rows.length;
	var bankNo = document.getElementById("bankNo").value;
	var bankName = document.getElementById("bankName").value;
	var checkNo = $("#checkNo").val();
	var branchCheck = $("#branchCheck").val();
	var moneyCheck = $("#moneyCheck").val();
	var dateCheck = $("#dateCheck").val();
	
	var count = parseInt(1);
	for (count; count < table; count++) {
		count
	}
	var markup = "<tr><td>"+ count + "</td><td>"+ bankNo + "</td><td>"+ bankName+ "</td><td>"+ branchCheck+ "</td><td>"+ dateCheck+ "</td><td>"+ moneyCheck+ "</td><td><a onclick='myDeleteCheckTranPrice("+count+")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
	$("#checkTable").find('tbody').append(markup);
	
	$("#checkNo").val("");
	$("#branchCheck").val("");
	$("#moneyCheck").val("");
	$("#dateCheck").val("");
	$('#bankNo').val("");
	$('#bankName').val("");
}


function myDeleteCheckTranPrice(count) {
	var tablesumTotal = document.getElementById("checkTable");
	if(tablesumTotal.rows.length > 0){
		tablesumTotal.deleteRow(count);
	}
}

