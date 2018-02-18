$(document).ready(
		function() {		
			findTypePayment();
			findBank();
			findBankNo();
			summaryTax();
			hideShowdat();
			disBtn();
			var cars = [ 'ทต.', 'ตร.', 'ปง.','กม.' ];

			// Constructing the suggestion engine
			var cars = new Bloodhound({
				datumTokenizer : Bloodhound.tokenizers.whitespace,
				queryTokenizer : Bloodhound.tokenizers.whitespace,
				local : cars
			});

			// Initializing the typeahead
			$('#typeahead').typeahead({
				hint : true,
				highlight : true, /* Enable substring highlighting */
				minLength : 1
			/* Specify minimum characters required for showing result */
			}, {
				name : 'cars',
				source : cars
			});
			$("#balanceSummary").keyup(function() {
			    // keydown code
				var result = $("#balanceSummary").val();
				var vatRQ = $("#vatrate").val();
				var beforeVat = parseFloat(0);
				var vat = parseFloat(0);
				var summary = parseFloat(0);
				var summaryT = parseFloat(0);
				var vatCo = parseFloat(107);
				var vatRq = parseFloat(0);
				
				summaryT = parseFloat(result * parseFloat(vatRQ));
				vat = parseFloat(summaryT / vatCo);
				
				
				beforeVat = parseFloat(result - vat);
				summary = parseFloat(beforeVat + vat);
				$("#balanceBeforeTax").val(beforeVat.toFixed(2));
				$("#vat").val(vat.toFixed(2));
				$("#balanceOfTax").val(summary.toFixed(2));
				// Summary
				$("#balanceSummarys").val( parseFloat(result).toFixed(2));
				$("#balanceBeforeTaxs").val(beforeVat.toFixed(2));
				$("#vats").val(vat.toFixed(2));
				$("#balanceOfTaxs").val(summary.toFixed(2));
			});
			
		});


function disBtn(){
	var table = document.getElementById("showTotalPriceTable");
	var rowLength = table.rows.length;
	
	if(rowLength > 1){
		
		$('button#submitFormPayment').prop('disabled', false);
	}else{
		$('button#submitFormPayment').prop('disabled', true);
	}
}



	
function findvatAmount(){
	var result = $("#balanceSummary").val();
	var vatRQ = $("#vatrate").val();
	var beforeVat = parseFloat(0);
	var vat = parseFloat(0);
	var summary = parseFloat(0);
	var summaryT = parseFloat(0);
	var vatCo = parseFloat(107);
	var vatRq = parseFloat(0);
	
	summaryT = parseFloat(result * parseFloat(vatRQ));
	vat = parseFloat(summaryT / vatCo);
	
	
	beforeVat = parseFloat(result - vat);
	summary = parseFloat(beforeVat + vat);
	$("#balanceBeforeTax").val(beforeVat.toFixed(2));
	$("#vat").val(vat.toFixed(2));
	$("#balanceOfTax").val(summary.toFixed(2));
	// Summary
};



function vatAmount(){
	var result = $("#balanceSummarys").val();
	var vatRQ = $("#vatrate").val();
	var beforeVat = parseFloat(0);
	var vat = parseFloat(0);
	var summary = parseFloat(0);
	var summaryT = parseFloat(0);
	var vatCo = parseFloat(107);
	var vatRq = parseFloat(0);
	
	summaryT = parseFloat(result * parseFloat(vatRQ));
	vat = parseFloat(summaryT / vatCo);
	
	
	beforeVat = parseFloat(result - vat);
	summary = parseFloat(beforeVat + vat);
	$("#balanceOfTaxs").val(summary.toFixed(2));
	$("#balanceBeforeTaxs").val(beforeVat.toFixed(2));
	$("#vats").val(vat.toFixed(2));
};

function hideShowdat(){
	 $("#sCustName").hide();
	 $("#sCustNo").hide();
	 $("#staxId").hide();
	 $("#scustAddress").hide();
	 $("#scustBrach").hide();
	 $("#suserGroup").hide();
	 $("#sdebtCollection").hide();
	 $("#sinvoiceNo").hide();
	 $("#sserviceNo").hide();
	 $("#sstartupDate").hide();
	 $("#sendDate").hide();
	 $("#sdeadlines").hide();
	 $("#sinvoiceDate").hide(); 
}
function submitForm(){

	hideShowdat();
	var radioButtons = document.getElementsByName("radioDed");
	var radioResult = "";
	var invoiceNo = $("#invoiceNo").val();
	var deductible = [];
	var  resultDeductible = [];
	var totalPrice = [];
	var  resultTotalPrice = [];
	
	// get radio 
	for (var x = 0; x < radioButtons.length; x++) {
		if (radioButtons[x].checked) {
			radioResult = radioButtons[x].value;
		}
	}
//	ภาษี หัก ณ ที่จ่าย
	var table = document.getElementById("sumDeductibleTable");
	var rowLength = table.rows.length;
	
	for (var i = 1; i < rowLength; i++) {
		deductible = [];
		var oCells = table.rows.item(i).cells;
		for (var fs = 0; fs < oCells.length; fs++) {
			
			deductible.push(oCells[fs].innerHTML);
		}
		resultDeductible.push(deductible);

	}
	
	// ตาราง สรุป ยอดเงิน
	var tableTotalPrice = document.getElementById("sumTotalPriceTable");
	var rowLengths = tableTotalPrice.rows.length;
	
	for (var y = 1; y < rowLengths; y++) {
		totalPrice = [];
		var oCells = tableTotalPrice.rows.item(y).cells;
		for (var fs = 0; fs < oCells.length; fs++) {
			
			totalPrice.push(oCells[fs].innerHTML);
		}
		resultTotalPrice.push(totalPrice);

	}
	
	// list ภาษี หัก ณ ที่จ่าย
	var listpaymentTaxQ = [];
	var listpaymentTaxRQ = [];
	
	for (var a = 0; a < resultDeductible.length; a++) {
		listpaymentTaxQ = []
		listpaymentTaxQ = {"invoiceNo" : resultDeductible[a][1],
			"docDed" : resultDeductible[a][2],
			"radioDed" : resultDeductible[a][3],
			"moneyDed" : resultDeductible[a][4]
		}
		listpaymentTaxRQ.push(listpaymentTaxQ);
	}
	
	// list TranPrice
	
	var listpaymentTranPriceQ = [];
	var listpaymentTranPriceRQ = [];
	
	for (var b = 0; b < resultTotalPrice.length; b++) {
		listpaymentTranPriceQ = [];
		if(resultTotalPrice[b][1] == "CC"){
			listpaymentTranPriceQ = {
			"typePayment" : resultTotalPrice[b][1],
			"moneyTran" : resultTotalPrice[b][2]
			}
		}else if (resultTotalPrice[b][1] == "CD"){
			listpaymentTranPriceQ = {
					"typePayment" : resultTotalPrice[b][1],
					"creditType" : resultTotalPrice[b][2],
					"creditNo" : resultTotalPrice[b][3],
					"edcType" : resultTotalPrice[b][4],
					"creditPrice" : resultTotalPrice[b][5]
					}
		}else if (resultTotalPrice[b][1] == "CH"){
			listpaymentTranPriceQ = {
					"typePayment" : resultTotalPrice[b][1],
					"bankNo" : resultTotalPrice[b][2],
					"bankName" : resultTotalPrice[b][3],
					"branchCheck" : resultTotalPrice[b][4],
					"checkNo" : resultTotalPrice[b][5],
					"dateCheck" : resultTotalPrice[b][6],
					"moneyCheck" : resultTotalPrice[b][7]
				}
		}
		
		listpaymentTranPriceRQ.push(listpaymentTranPriceQ);
	}
	
	
	if($("#custName").val() == ""){
		$("#sCustName").show();
		return $("#custName").focus();
	}
	if($("#custNo").val() == ""){
		$("#sCustNo").show();
		return $("#custNo").focus();
	}
	if($("#taxId").val() == ""){
		$("#staxId").show();
		return $("#taxId").focus();
	}
	if($("#custAddress").val() == ""){
		$("#scustAddress").show();
		return $("#custAddress").focus();
	}
	if($("#custBrach").val() == ""){
		$("#scustBrach").show();
		return $("#custBrach").focus();
	}
	if($("#userGroup").val() == ""){
		$("#suserGroup").show();
		return $("#userGroup").focus();
	}
	if($("#typeahead").val() == ""){
		$("#sdebtCollection").show();
		return $("#typeahead").focus();
	}
	if($("#invoiceNo").val() == ""){
		$("#sinvoiceNo").show();
		return $("#invoiceNo").focus();
	}
	if($("#serviceNo").val() == ""){
		$("#sserviceNo").show();
		return $("#serviceNo").focus();
	}
	if($("#startupDate").val() == ""){
		$("#sstartupDate").show();
		return $("#startupDate").focus();
	}
	if($("#endDate").val() == ""){
		$("#sendDate").show();
		return $("#endDate").focus();
	}
	if($("#deadlines").val() == ""){
		$("#sdeadlines").show();
		return $("#deadlines").focus();
	}
	if($("#invoiceDate").val() == ""){
		$("#sinvoiceDate").show();
		return $("#invoiceDate").focus();
	}
	
	var dataSend = {
			 "custName":$("#custName").val() ,
			 "custNo":$("#custNo").val() ,
			 "taxId":$("#taxId").val() ,
			 "documentNo" : $("#docDed").val(),
			 "custAddress":$("#custAddress").val() ,
			 "custBrach":$("#custBrach").val() ,
			 "userGroup":$("#userGroup").val() ,
			 "debtCollection":$("#typeahead").val() ,
			 "invoiceNo":$("#invoiceNo").val() ,
			 "serviceNo":$("#serviceNo").val() ,
			 "startupDate":$("#startupDate").val() ,
			 "endDate":$("#endDate").val() ,
			 "deadlines":$("#deadlines").val() ,
			 "invoiceDate":$("#invoiceDate").val() ,
			 "vatrate":$("#vatrate").val() ,
			 "balanceBeforeTax":$("#balanceBeforeTax").val() ,
			 "vat":$("#vat").val() ,
			 "balanceOfTax":$("#balanceOfTax").val() ,
			 "balanceSummary":$("#balanceSummary").val() ,
			 "balanceBeforeTaxs":$("#balanceBeforeTaxs").val() ,
			 "vats":$("#vats").val() ,
			 "balanceOfTaxs":$("#balanceOfTaxs").val() ,
			 "balanceSummarys":$("#balanceSummarys").val() ,
			 "balanceSum":$("#balanceSum").val() ,
			 "remark":$("#remark").val() ,
			 "summaryTax":$("#summaryTax").val() ,
			 "paymentTax":listpaymentTaxRQ  ,
			 "paymentTranPrice" :listpaymentTranPriceRQ	 
	}
		 
	$.ajax({
        type: "POST",
        url: "paymentService",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	if(res > 0){
        		 window.location.href = "paymentSuccess?idUser=" +res;
        	}
        }
	})
		
};
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

function findBank() {
	var bankNo = document.getElementById("bankNo").value;
	var bankName = document.getElementById("bankName").value;
	if (bankNo == "001") {
		$('#bankName').val("ktb");
	} else if (bankNo == "002") {
		$('#bankName').val("scb");
	} else if (bankNo == "003") {
		$('#bankName').val("kbk");
	}
}

function findBankNo() {
	var bankNo = document.getElementById("bankNo").value;
	var bankName = document.getElementById("bankName").value;
	if (bankName == "ktb") {
		$('#bankNo').val("001");
	} else if (bankName == "scb") {
		$('#bankNo').val("002");
	} else if (bankName == "kbk") {
		$('#bankNo').val("003");
	}
}

function addRow() {
	var table = document.getElementById("deductibleTable").rows.length;
	var radioButtons = document.getElementsByName("radioDed");
	var radioResult = "";
	var invoiceNo = $("#invoiceNo").val();
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
	var markup = "<tr><td>"	+ tdAutoNumber()	+ "</td><td>"+ invoiceNo+ "</td><td hidden>"+ docDed+ "</td><td>"	+ radioResult+ "</td><td>"+ moneyDed+ "</td><td><a onclick='myDeleteFunction("+  tdAutoNumber()+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";

	$("#deductibleTable").find('tbody').append(markup);
	var moneyDed = $("#moneyDed").val("");
};

function myDeleteFunction(count) {
	var table = document.getElementById("deductibleTable");
	if (table.rows.length > 0) {
		for (var i = 1; i <= table.rows.length; i++) {
			if (count == i) {
				table.deleteRow(parseFloat(count));
			}
		}
	}
	tdAutoNumber();

}
function tdAutoNumber() {
    var table = document.getElementById("deductibleTable");
    var txt = "";
    var i;
    for (i = 0; i < table.rows.length;i++) {
        txt = table.rows.length;
    }
    return txt;
}
function myDeleteDed(count) {
	var tableDed = document.getElementById("showDeductibleTable");
	var table = document.getElementById("sumDeductibleTable");
	var summaryTa = parseFloat(0);
	var balance = $("#balanceSummarys").val();

	if (table.rows.length > 0) {
		for (var i = 1; i < tableDed.rows.length; i++) {


			if (count == i) {
				var oCells = table.rows.item(i).cells;
				var total = parseFloat(oCells[4].innerHTML);
				balance =	parseFloat(parseFloat(balance) + parseFloat(total));
				$("#balanceSummarys").val(balance.toFixed(2));
				vatAmount();
				tableDed.deleteRow(count);
				table.deleteRow(count);
				removeTax();
			}
		}
	}

}

function addDataTableDed() {
	var oTable = document.getElementById('deductibleTable');
	var tableDed = document.getElementById("showDeductibleTable");
	var result = [];
	var deduction = $("#deduction").val();
	var rowLength = oTable.rows.length;
	var number = parseFloat(tableDed.rows.length - parseFloat(1));
	var balance = $("#balanceSummarys").val();
	var branSum = $("#balanceSummarys").val();
	var summaTax = $("#summaryTax").val();
	for (var i = parseFloat(1); i < rowLength; i++) {
		var oCells = oTable.rows.item(i).cells;
		result = [];
		for (var fs = 0; fs < oCells.length; fs++) {
			result.push(oCells[fs].innerHTML);
		}
		if(branSum == ""){
			branSum = parseFloat(0);
		}
		if(summaTax == ""){
			summaTax = parseFloat(0);
		}
		var plus = parseFloat(parseFloat(summaTax) + parseFloat(result[4])) ;
		if(plus > parseFloat(branSum)){
			alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
			return ;
		}
		var numberRun = number + i;
		var markup = "<tr><td>"	+ numberRun	+ "</td><td>"+ "ภาษีหัก ณ ที่จ่าย"	+ "</td><td>"+ result[4]+ "</td><td><a onclick='myDeleteDed("+ numberRun+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showDeductibleTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + deduction	+ "</td><td>" + result[2]	+ "</td><td>" + result[3] + "</td><td>" + result[4]	+ "</td></tr>";
		$("#sumDeductibleTable").find('tbody').append(markup1);
		
		balance =	parseFloat(parseFloat(balance) - parseFloat(result[4]));
		
	}
	for (var i = document.getElementById("deductibleTable").rows.length; i > 1; i--) {
		document.getElementById("deductibleTable").deleteRow(i - 1);
	}
	$("#balanceSummarys").val(balance.toFixed(2));
	summaryTax();
	vatAmount();
}
// เงินสด
function addDataTableMoneyTranPrice() {
	var table = document.getElementById("showTotalPriceTable").rows.length;
	var number = parseFloat(table - parseFloat(1));
	var count = parseInt(1);
	var numberRun = count + number;
	
	var money = $("#moneyTran").val();
	var nameMode = "CC";
	var nameMode1 = "เงินสด";
	
	var summaryTax = $("#summaryTax").val();

	var balanceS = $("#balanceSum").val();
	if(balanceS == ""){
		balanceS = parseFloat(0);
	}
	var branSum = $("#balanceSummarys").val();
	var brana = $("#balanceSum").val();
	var summaTax = $("#summaryTax").val();
	if(branSum == ""){
		branSum = parseFloat(0);
	}
	if(brana == ""){
		brana = parseFloat(0);
	}
	var plus =  parseFloat(money) ;

	if(plus > parseFloat(branSum)){
		alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
		return ;
	}
//		var moneyT = parseFloat(money - parseFloat(summaryTax));
		var markup = "<tr><td>"
				+ numberRun
				+ "</td><td>"
				+ nameMode1
				+ "</td><td>"
				+ money
				+ "</td><td><a onclick='myDeleteSumCreditTranPrice("
				+ numberRun
				+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showTotalPriceTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + nameMode	+ "</td><td>" + money + "</td></tr>";
		$("#sumTotalPriceTable").find('tbody').append(markup1);

		$("#moneyTran").val("");
		var balan = $("#balanceSummarys").val(); 
		balan = parseFloat(balan) - parseFloat(money);
		$("#balanceSummarys").val(balan.toFixed(2));
		balanceS = parseFloat(parseFloat(balanceS) + parseFloat(money) );
		$("#balanceSum").val(balanceS.toFixed(2));
		vatAmount();
		disBtn();
}

// add ข้อมูลลง เครดิต
function addDataSumCreditTranPrice() {
	var table = document.getElementById("showTotalPriceTable").rows.length;
	var oTable = document.getElementById('creditTable');
	var result = [];
	var nameMode = "CD";
	var nameMode1 = "บัตรเครดิต";
	var rowLength = oTable.rows.length;
	var count = parseInt(0);
	var number = parseFloat(table - parseFloat(1));
	var balanceS = $("#balanceSum").val();
	if(balanceS == ""){
		balanceS = parseFloat(0);
	}
	for (i = 1; i < rowLength; i++) {
		var oCells = oTable.rows.item(i).cells;
		result = [];
		for (var fs = 0; fs < oCells.length; fs++) {
			result.push(oCells[fs].innerHTML);
		}
		var branSum = $("#balanceSummarys").val();
		var brana = $("#balanceSum").val();
		var summaTax = $("#summaryTax").val();
		if(branSum == ""){
			branSum = parseFloat(0);
		}
		if(brana == ""){
			brana = parseFloat(0);
		}
		var plus = parseFloat(result[4]) ;
		
		if(plus > parseFloat(branSum)){
			alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
			return ;
		}
		var numberRun = number + i;
		var markup = "<tr><td>"
				+ numberRun
				+ "</td><td>"+ nameMode1+ "</td><td>"+ result[4]	+ "</td><td><a onclick='myDeleteSumCreditTranPrice("+ numberRun	+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showTotalPriceTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + nameMode+ "</td><td>" + result[1] + "</td><td>" + result[2] + "</td><td>" + result[3]	+ "</td><td>" + result[4] + "</td></tr>";
		$("#sumTotalPriceTable").find('tbody').append(markup1);
		var balan = $("#balanceSummarys").val(); 
		balan = parseFloat(balan) - parseFloat(result[4]);
		$("#balanceSummarys").val(balan.toFixed(2));
		balanceS = parseFloat(parseFloat(balanceS)+parseFloat(result[4]));
		$("#balanceSum").val(balanceS.toFixed(2));
		vatAmount();
		disBtn();
	}
	for (var i = document.getElementById("creditTable").rows.length; i > 1; i--) {
		document.getElementById("creditTable").deleteRow(i - 1);
	}
	
}
function addDataSumCheckTranPrice() {
	var table = document.getElementById("showTotalPriceTable").rows.length;
	var oTable = document.getElementById('checkTable');
	var result = [];
	var nameMode = "CH";
	var nameMode1 = "เช็ค";
	var rowLength = oTable.rows.length;
	var count = parseInt(0);
	var number = parseFloat(table - parseFloat(1));
	var balanceS = $("#balanceSum").val();
	if(balanceS == ""){
		balanceS = parseFloat(0);
	}
	for (i = 1; i < rowLength; i++) {
		var oCells = oTable.rows.item(i).cells;
		result = [];
		for (var fs = 0; fs < oCells.length; fs++) {
			result.push(oCells[fs].innerHTML);
		}
		var branSum = $("#balanceSummarys").val();
		var brana = $("#balanceSum").val();
		var summaTax = $("#summaryTax").val();
		if(branSum == ""){
			branSum = parseFloat(0);
		}
		if(brana == ""){
			brana = parseFloat(0);
		}
		var plus = parseFloat(result[6]) ;
		if(plus > parseFloat(branSum)){
			alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
			return ;
		}
		var numberRun = number + i;
		var markup = "<tr><td>"	+ numberRun	+ "</td><td>"+ nameMode1	+ "</td><td>"+ result[6]+ "</td><td><a onclick='myDeleteSumCreditTranPrice("+ numberRun	+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showTotalPriceTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + nameMode+ "</td><td>" + result[1] + "</td><td>" + result[2]+ "</td><td>" + result[3] + "</td><td>" + result[4]	+ "</td><td>" + result[5] + "</td><td>" + result[6] + "</td></tr>";
		$("#sumTotalPriceTable").find('tbody').append(markup1);
		var balan = $("#balanceSummarys").val(); 
		balan = parseFloat(balan) - parseFloat(result[6]);
		$("#balanceSummarys").val(balan.toFixed(2));
		balanceS = parseFloat(parseFloat(balanceS)+parseFloat(result[6]));
		$("#balanceSum").val(balanceS.toFixed(2));
		vatAmount();
		disBtn();
	}
	for (var i = document.getElementById("checkTable").rows.length; i > 1; i--) {
		document.getElementById("checkTable").deleteRow(i - 1);
	}
	
}

function addDataTableCheck() {
	var summaryTax = $("#summaryTax").val();
	var table = document.getElementById("checkTable").rows.length;
	var bankNo = document.getElementById("bankNo").value;
	var bankName = document.getElementById("bankName").value;
	var checkNo = $("#checkNo").val();
	var branchCheck = $("#branchCheck").val();
	var moneyCheck = $("#moneyCheck").val();
	var dateCheck = $("#dateCheck").val();
//	var moneyT = parseFloat(moneyCheck - parseFloat(summaryTax));
	var count = parseInt(1);
	for (count; count < table; count++) {
		count
	}
	var markup = "<tr><td>"	+ count	+ "</td><td>"+ bankNo+ "</td><td>"+ bankName+ "</td><td>"+ branchCheck+ "</td><td>"+ checkNo+ "</td><td>"+ dateCheck+ "</td><td>"	+ moneyCheck+ "</td><td><a onclick='myDeleteCheckTranPrice("
			+ count
			+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
	$("#checkTable").find('tbody').append(markup);

	$("#checkNo").val("");
	$("#branchCheck").val("");
	$("#moneyCheck").val("");
	$("#dateCheck").val("");
	$('#bankNo').val("");
	$('#bankName').val("");

}

function addDataTablecreditTranPrice() {
	var table = document.getElementById("creditTable").rows.length;
	var creditType = document.getElementById("creditType").value;
	var edcType = document.getElementById("edcType").value;
	var creditNo = $("#creditNo").val();
	var creditPrice = $("#creditPrice").val();
	var nameMode = "บัตรเครดิต";
	var summaryTax = $("#summaryTax").val();
//	var moneyT = parseFloat(creditPrice - parseFloat(summaryTax));
	var count = parseInt(1);
	for (count; count < table; count++) {
		count
	}

	var markup = "<tr><td>"
			+ count
			+ "</td><td>"
			+ creditType
			+ "</td><td>"
			+ creditNo
			+ "</td><td>"
			+ edcType
			+ "</td><td>"
			+ creditPrice
			+ "</td><td><a onclick='myDeletecreditTranPrice("
			+ count
			+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
	$("#creditTable").find('tbody').append(markup);

	$("#creditNo").val("");
	$("#creditPrice").val("");
	$("#edcType").val("");
	$("#creditType").val("");
}

function sumTranPrice() {
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
	if (tablesumTotal.rows.length > 0) {
		tablesumTotal.deleteRow(count);
		
	}
}
function myDeleteSumCreditTranPrice(numberRun) {
	var tablesumTotals = document.getElementById("showTotalPriceTable");
	var tablesumTotal = document.getElementById("sumTotalPriceTable");
	
	var summaryTa = parseFloat(0);
	var balance = $("#balanceSummarys").val();
	var balanceSum = $("#balanceSum").val();
	if (tablesumTotals.rows.length > 0) {
		for (var i = 1; i < tablesumTotals.rows.length; i++) {
			if (numberRun == i) {
				var oCells = tablesumTotals.rows.item(i).cells;
				var total = parseFloat(oCells[2].innerHTML);
				balance =	parseFloat(parseFloat(balance) + parseFloat(total));
				balanceSum = parseFloat(parseFloat(balanceSum) - parseFloat(total))
				$("#balanceSummarys").val(balance.toFixed(2));
				$("#balanceSum").val(balanceSum.toFixed(2));
				vatAmount();
				
				tablesumTotals.deleteRow(numberRun);
				tablesumTotal.deleteRow(numberRun);
				
			}
		}

	}
}

function myDeleteCheckTranPrice(count) {
	var tablesumTotal = document.getElementById("checkTable");
	if (tablesumTotal.rows.length > 0) {
		tablesumTotal.deleteRow(count);
	}
}

function summaryTax() {
	var table = document.getElementById("showDeductibleTable");
	var rowLength = table.rows.length;
	var summary = parseFloat(0);

	
	for (var i = 1; i < rowLength; i++) {
		var oCells = table.rows.item(i).cells;
		var total = parseFloat(oCells[2].innerHTML);
		summary += total;
		
	}
	if (rowLength <= 0) {
		summary = parseFloat(0);
	}
	if (summary < 0) {
		summary = parseFloat(0);
	}
	$("#summaryTax").val(summary.toFixed(2));
	vatAmount();
}

function removeTax() {
	var table = document.getElementById("showDeductibleTable");
	var rowLength = table.rows.length;
	var summary = parseFloat(0);
	for (var i = 1; i < rowLength; i++) {
		var oCells = table.rows.item(i).cells;
		var total = parseFloat(oCells[2].innerHTML);
		summaryTa = total;
		summary += total;
	}
	if (rowLength <= 0) {
		summary = parseFloat(0);
	}
	if (summary < 0) {
		summary = parseFloat(0);
	}
	$("#summaryTax").val(summary.toFixed(2));
}

