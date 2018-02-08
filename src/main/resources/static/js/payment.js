$(document).ready(function() {
	findTypePayment();
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
	   var markup1 = "<tr><td>"+ i+ "</td><td>"+ deduction + "</td><td>"+ result[1]+ "</td><td>"+ result[1]+ "</td><td>"+ result[2]+ "</td><td>"+ result[3]+ "</td><td>"+ result[4]+ "</td></tr>";
	   $("#sumDeductibleTable").find('tbody').append(markup1);
	}
	for(var i = document.getElementById("deductibleTable").rows.length; i > 1;i--){
	document.getElementById("deductibleTable").deleteRow(i -1);	}
	var table = document.getElementById("sumDeductibleTable");
}

function addDataTableMoneyTranPrice(){
	var table = document.getElementById("sumTotalPriceTable").rows.length;
	var money = $("#moneyTran").val();
	var nameMode = "เงินสด";
	var count = parseInt(2);
	var count2 = parseInt(1);
	for (count; count < table; count2++) {
		count++;
		count2;
	}
	
	var markup = "<tr><td>"+ count2 + "</td><td>"+ nameMode + "</td><td>"+ money+ "</td><td><a onclick='myDeleteSumPrice(" + count +")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
	$("#sumTotalPriceTable").find('tbody').append(markup);
	
	$("#moneyTran").val("");
}


function sumTranPrice(){
	var result = document.getElementById("typePayment").value;
	if (result == 'credit') {
		
	} else if (result == 'money') {
		addDataTableMoneyTranPrice();
	} else if (result == 'check') {

	}
}
function myDeleteSumPrice(count) {
	var tablesumTotal = document.getElementById("sumTotalPriceTable");
	if(tablesumTotal.rows.length > 0){
		tablesumTotal.deleteRow(count);
	}
}

