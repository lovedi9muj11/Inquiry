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

	var markup = "<tr><td>"
			+ count
			+ "</td><td>"
			+ "test1"
			+ "</td><td>"
			+ docDed
			+ "</td><td>"
			+ radioResult
			+ "</td><td>"
			+ moneyDed
			+ "</td><td><a onclick='myDeleteFunction()'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";

	$("#deductibleTable").find('tbody').append(markup);
};

function myDeleteFunction() {
	var table = document.getElementById("deductibleTable");
	if (table.rows.length > 0) {
		table.deleteRow(1);
	}
}

function addDataTableDed(){
	var oTable = document.getElementById('deductibleTable');
	var table = document.getElementById("sumDeductibleTable");
	
	//gets rows of table
	var rowLength = oTable.rows.length;

	//loops through rows    
	for (i = 1; i < rowLength; i++){

	   //gets cells of current row
	   var oCells = oTable.rows.item(i).cells;

		$("#sumDeductibleTable").find('tbody').append(oCells);
		$("#sumDeductibleTable").find('tbody').append(oCells[0]).append("ภาษีหัก ณ ที่จ่าย");
		
	}
}




