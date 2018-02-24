$(document).ready(function() {		
			findTypePayment();
			findBank();
			findBankNo();
			summaryTax();
			hideShowdat();
			disBtn();
			document.getElementById("radioButton").disabled = true;
			document.getElementById("radioButton1").disabled = true;
			document.getElementById("radioButton2").disabled = true;
			document.getElementById("radioButton3").disabled = true;
			document.getElementById("radioButtons").disabled = true;
			$("#change").val(parseFloat(0).toFixed(2));
			$("#balanceSummary").keyup(function() {
			    // keydown code
				var bal = $("#balanceSummary").val();
				var result = parseFloat(bal.replace(",", ""));
				var vatq = $("#vatrate").val();
				var vatRQ = parseFloat(parseFloat(vatq).toFixed(2).replace(",", ""));
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
				$("#moneyTran").val( parseFloat(result).toFixed(2));
//				$("#balanceBeforeTaxs").val(beforeVat.toFixed(2));
//				$("#vats").val(vat.toFixed(2));
//				$("#balanceOfTaxs").val(summary.toFixed(2));
				
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
	var bal = $("#balanceSummary").val();
	var result = parseFloat(bal.replace(",", ""));
	var vatq = $("#vatrate").val();
	var vatRQ = parseFloat(parseFloat(vatq).toFixed(2).replace(",", ""));
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
	var result = $("#balanceSum").val();
	if($("#balanceSum").val() !== ''){
		result = parseFloat($("#balanceSum").val().replace(",", ""));
	}
	var vaq = $("#vatrate").val();
	var vatRQ = parseFloat(parseFloat(vaq).toFixed(2).replace(",", ""));
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
	$("#beforeSale").val(beforeVat.toFixed(2));
	
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
	if($("#debtCollection").val() == ""){
		$("#sdebtCollection").show();
		return $("#debtCollection").focus();
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
			 "debtCollection":$("#debtCollection").val() ,
			 "invoiceNo":$("#invoiceNo").val() ,
			 "serviceNo":$("#serviceNo").val() ,
			 "startupDate":$("#startupDate").val() ,
			 "endDate":$("#endDate").val() ,
			 "deadlines":$("#deadlines").val() ,
			 "invoiceDate":$("#invoiceDate").val() ,
			 "vatrate":$("#vatrate").val() ,
			 "balanceBeforeTax": parseFloat($("#balanceBeforeTax").val().replace(",", "")) ,
			 "vat": parseFloat($("#vat").val().replace(",", "")) ,
			 "balanceOfTax": parseFloat($("#balanceOfTax").val().replace(",", "")) ,
			 "balanceSummary": parseFloat($("#balanceSummary").val().replace(",", "")),
			 "balanceBeforeTaxs":  parseFloat($("#balanceBeforeTaxs").val().replace(",", ""))  ,
			 "vats": parseFloat($("#vats").val().replace(",", ""))  ,
			 "balanceOfTaxs": parseFloat($("#balanceOfTaxs").val().replace(",", "")) ,
			 "balanceSummarys": parseFloat($("#balanceSummarys").val().replace(",", "")) ,
			 "balanceSum": parseFloat($("#balanceSum").val().replace(",", "")) ,
			 "remark":$("#remark").val() ,
			 "summaryTax": parseFloat($("#summaryTax").val().replace(",", "")) ,
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
			
			if(radioResult == "01"){
				radioResult = "69 ทวิ";
			}else if(radioResult =="02"){
				radioResult = "3 เตรส";
			}else if(radioResult == "03"){
				radioResult = "69 ดริ";
			}
		}
	}
	var docDed = $("#docDed").val();
	var dmoney = $("#moneyDed").val();
	if(dmoney == ""){
		alert("กรุณากรอกใหม่ !");
		return $("#moneyDed").focus();
	}
	
	var moneyDed = parseFloat(dmoney.replace(",", ""));
	var count = 1;
	
	for (count; count < table; count++) {
		count + table;
	}
	
	if(parseFloat(moneyDed) < 0){
		alert("กรุณากรอกจำนวนเงิน  กรุณากรอกใหม่ !");
		return  $("#moneyDed").focus();
	}
	if(moneyDed == ""){
		alert("กรุณากรอกจำนวนเงิน  กรุณากรอกใหม่ !");
		return  $("#moneyDed").focus();
	}
	var markup = "<tr><td>"	+ tdAutoNumber()	+ "</td><td>"+ invoiceNo+ "</td><td hidden>"+ docDed+ "</td><td>"	+ radioResult+ "</td><td>"+ parseFloat(moneyDed).toFixed(2) + "</td><td><a onclick='myDeleteFunction("+  tdAutoNumber()+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";

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
	var erq = $("#balanceSummary").val();
	var result = parseFloat(erq.replace(",", ""));
	var st = $("#summaryTax").val();
	var summaryTax = parseFloat(st.replace(",", ""));
	var summaryTa = parseFloat(0);
	var bas = $("#balanceSummarys").val();
	var balance = parseFloat(bas.replace(",", ""));

	if (table.rows.length > 0) {
		for (var i = 1; i < tableDed.rows.length; i++) {


			if (count == i) {
				var oCells = table.rows.item(i).cells;
				var total = parseFloat(oCells[4].innerHTML);
				balance =	parseFloat(parseFloat(balance) + parseFloat(total));
				if(balance > result){
					balance = result;
					$("#change").val(parseFloat(0).toFixed(2));
				}
				
				
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
//	var deq = $("#deduction").val();
//	var deduction = parseFloat(deq.replace(",", ""));
	var rowLength = oTable.rows.length;
	var number = parseFloat(tableDed.rows.length - parseFloat(1));
	var bas = $("#balanceSummarys").val();
	var balance = parseFloat(bas.replace(",", ""));
	var basu = $("#balanceSummarys").val();
	var branSum = parseFloat(basu.replace(",", ""));
	var sq = $("#summaryTax").val();
	var summaTax = parseFloat(sq.replace(",", ""));
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
		var markup = "<tr><td>"	+ numberRun	+ "</td><td>"+ "ภาษีหัก ณ ที่จ่าย"	+ "</td><td>"+ parseFloat(result[4]).toFixed(2) + "</td><td><a onclick='myDeleteDed("+ numberRun+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showDeductibleTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + "ภาษีหัก ณ ที่จ่าย"	+ "</td><td>" + result[2]	+ "</td><td>" + result[3] + "</td><td>" + result[4]	+ "</td></tr>";
		$("#sumDeductibleTable").find('tbody').append(markup1);
		
		balance =	parseFloat(parseFloat(balance) - parseFloat(result[4]).toFixed(2).replace(",", ""));
		
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
	
	var moneyss = $("#moneyTran").val();
	if(moneyss == ""){
		moneyss = parseFloat(0).toFixed(2);
	}
	var money = parseFloat(moneyss.replace(",", ""));
	
	if(money == ""){
		alert("กรุณากรอกจำนวนเงิน กรุณากรอกใหม่ !");
		return $("#moneyTran").focus();
	}
	if(money < 0){
		alert("กรุณากรอกจำนวนเงิน กรุณากรอกใหม่ !");
		return $("#moneyTran").focus();
	}
	var nameMode = "CC";
	var nameMode1 = "เงินสด";
	
	var sumx = $("#summaryTax").val();
	if(sumx == ""){
		sumx = parseFloat(0).toFixed(2);
	}
	var summaryTax = parseFloat(sumx.replace(",", ""));

	var ba2 = $("#balanceSum").val();
	if(ba2 == ""){
		ba2 = parseFloat(0).toFixed(2);
	}
	var balanceS = parseFloat(ba2.replace(",", ""));
	if(balanceS == ""){
		balanceS = parseFloat(0);
	}
	var bag2 = $("#balanceSummarys").val();
	if(bag2 == ""){
		bag2 = parseFloat(0).toFixed(2);
	}
	var branSum = parseFloat(bag2.replace(",", ""));

		var markup = "<tr><td>"
				+ numberRun
				+ "</td><td>"
				+ nameMode1
				+ "</td><td>"
				+ parseFloat(money).toFixed(2)
				+ "</td><td><a onclick='myDeleteSumCreditTranPrice("
				+ numberRun
				+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showTotalPriceTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + nameMode	+ "</td><td>" + money + "</td></tr>";
		$("#sumTotalPriceTable").find('tbody').append(markup1);

		$("#moneyTran").val("");
		var beq = $("#balanceSummarys").val(); 
		var balan = parseFloat(beq.replace(",", ""));
		var ceq = $("#balanceSummarys").val(); 
		var changeRQ = parseFloat(ceq.replace(",", ""));
		
		
		changeRQ = parseFloat(money) -  parseFloat(balan);
		balan = parseFloat(balan) - parseFloat(money);
		if(balan < 0){
			balan = parseFloat(0);
		}
		if(changeRQ < 0){
			changeRQ = parseFloat(0);
		}
		
		var sop = $("#balanceSummary").val();
		var sumPrice = parseFloat(sop.replace(",", ""));
		
		$("#balanceSummarys").val(balan.toFixed(2));
		
		balanceS = parseFloat(balanceS + money +summaryTax);
		if(parseFloat(sumPrice) < parseFloat(balanceS)){
			$("#balanceSum").val(parseFloat(sumPrice).toFixed(2));
		}else{
			$("#balanceSum").val(parseFloat(money).toFixed(2));
		}
		
		
		vatAmount();
		disBtn();
		changeMoney(changeRQ);
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
	var bas2 = $("#balanceSum").val();
	var balanceS = parseFloat(bas2.replace(",", ""));
	
	if(balanceS == ""){
		balanceS = parseFloat(0);
	}
	for (i = 1; i < rowLength; i++) {
		var oCells = oTable.rows.item(i).cells;
		result = [];
		for (var fs = 0; fs < oCells.length; fs++) {
			result.push(oCells[fs].innerHTML);
		}
		var ba23 = $("#balanceSummarys").val();
		var branSum = parseFloat(ba23.replace(",", ""));
		
		var bard = $("#balanceSum").val();
		var brana = parseFloat(bard.replace(",", ""));
		
		var stc = $("#summaryTax").val();
		var summaTax = parseFloat(stc.replace(",", ""));
		
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
				+ "</td><td>"+ nameMode1+ "</td><td>"+ parseFloat(result[4]).toFixed(2)	+ "</td><td><a onclick='myDeleteSumCreditTranPrice("+ numberRun	+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showTotalPriceTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + nameMode+ "</td><td>" + result[1] + "</td><td>" + result[2] + "</td><td>" + result[3]	+ "</td><td>" + result[4] + "</td></tr>";
		$("#sumTotalPriceTable").find('tbody').append(markup1);
		
		
		var ba3a = $("#balanceSummarys").val(); 
		var balan = parseFloat(ba3a.replace(",", ""));
		
		
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
	var ba3d = $("#balanceSum").val();
	var balanceS = parseFloat(ba3d.replace(",", ""));
	if(balanceS == ""){
		balanceS = parseFloat(0);
	}
	for (i = 1; i < rowLength; i++) {
		var oCells = oTable.rows.item(i).cells;
		result = [];
		for (var fs = 0; fs < oCells.length; fs++) {
			result.push(oCells[fs].innerHTML);
		}
		var banSu = $("#balanceSummarys").val();
		var branSum = parseFloat(banSu.replace(",", ""));
		var ssq = $("#balanceSum").val();
		var brana = parseFloat(ssq.replace(",", ""));
		var sumTax = $("#summaryTax").val();
		var summaTax = parseFloat(sumTax.replace(",", ""));
		
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
		var markup = "<tr><td>"	+ numberRun	+ "</td><td>"+ nameMode1	+ "</td><td>"+ parseFloat(result[6]).toFixed(2) + "</td><td><a onclick='myDeleteSumCreditTranPrice("+ numberRun	+ ")'><span class='glyphicon glyphicon-trash'></span></a></td></tr>";
		$("#showTotalPriceTable").find('tbody').append(markup);
		var markup1 = "<tr><td>" + numberRun + "</td><td>" + nameMode+ "</td><td>" + result[1] + "</td><td>" + result[2]+ "</td><td>" + result[3] + "</td><td>" + result[4]	+ "</td><td>" + result[5] + "</td><td>" + result[6] + "</td></tr>";
		$("#sumTotalPriceTable").find('tbody').append(markup1);
		var balans = $("#balanceSummarys").val(); 
		var balan = parseFloat(balans.replace(",", ""));
		
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
	var moneyCa = $("#moneyCheck").val();
	var dateCheck = $("#dateCheck").val();
	var date =dateCheck.split("-");
	var dateChek = date[2] +"/" + date[1] + "/" + date[0]

	
	if(moneyCa == ""){
		moneyCa = parseFloat(0).toFixed(2);
	}
	var moneyCheck = parseFloat(moneyCa.replace(",", ""));
	var count = parseInt(1);
	for (count; count < table; count++) {
		count
	}
	if(parseFloat(moneyCheck) < parseFloat(0)){
		alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
		return $("#moneyCheck").focus();
	}
	if(checkNo == ""){
		alert("กรุณากรอกใหม่ !");
		return $("#checkNo").focus();
	}
	
	if(bankNo == "001"){
		bankName = "ธนาคารกรุงไทย";
	}else if(bankNo == "002"){
		bankName = "ธนาคารไทยพานิชย์";
	}else if(bankNo == "003"){
		bankName = "ธนาคารกสิกรไทย";
	}
	
	if(parseFloat(moneyCheck) < parseFloat(0)){
		alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
		return $("#moneyCheck").focus();
	}
	if(moneyCheck == ""){
		alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
		return $("#moneyCheck").focus();
	}

	
	var markup = "<tr><td>"	+ count	+ "</td><td>"+ bankNo+ "</td><td>"+ bankName+ "</td><td>"+ branchCheck+ "</td><td>"+ checkNo+ "</td><td>"+ dateChek + "</td><td>"	+ parseFloat(moneyCheck).toFixed(2)+ "</td><td><a onclick='myDeleteCheckTranPrice("
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
	var crepi = $("#creditPrice").val();
	if(crepi == ""){
		crepi = parseFloat(0).toFixed(2);
	}
	var creditPrice = parseFloat(crepi.replace(",", ""));
	var nameMode = "บัตรเครดิต";
	var sumTax = $("#summaryTax").val();
	var summaryTax = parseFloat(sumTax.replace(",", ""));
//	var moneyT = parseFloat(creditPrice - parseFloat(summaryTax));
	var count = parseInt(1);
	for (count; count < table; count++) {
		count
	}

	if(parseFloat(creditPrice) < parseFloat(0)){
		alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
		return $("#creditPrice").focus();
	}
	if(creditPrice == ""){
		alert("จำนวนเงินเกิน กรุณากรอกใหม่ !");
		return $("#creditPrice").focus();
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
			+ parseFloat(creditPrice).toFixed(2)
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
	var banol = $("#balanceSummarys").val();
	var balance = parseFloat(banol.replace(",", ""));
	var sump = $("#balanceSummary").val();
	var sumPrice = parseFloat(sump.replace(",", ""));
	var bansum = $("#balanceSum").val();
	var balanceSum = parseFloat(bansum.replace(",", ""));
	var sumTax = $("#summaryTax").val();
	var summaryTax = parseFloat(sumTax.replace(",", ""));
	var res = parseFloat(0);
	var chen = $("#change").val();
	if (tablesumTotals.rows.length > 0) {
		for (var i = 1; i < tablesumTotals.rows.length; i++) {
			if (numberRun == i) {
				var oCells = tablesumTotals.rows.item(i).cells;
				var total = parseFloat(oCells[2].innerHTML);
				balance =	parseFloat(parseFloat(balance) + parseFloat(total));
				balanceSum = parseFloat(parseFloat(balanceSum) - parseFloat(total))
				if(parseFloat(balanceSum) <0){
					balanceSum = parseFloat(0);
				}
				if(parseFloat(sumPrice) < parseFloat(balance)){
					balance = parseFloat(sumPrice);
					$("#change").val(parseFloat(0).toFixed(2));
				}
				balance = parseFloat(balance) - parseFloat(summaryTax);
				res = parseFloat(balance) + parseFloat(chen);
				if(parseFloat(res) >= parseFloat(sumPrice)  ){
					$("#change").val(parseFloat(0).toFixed(2));
				}
				
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

