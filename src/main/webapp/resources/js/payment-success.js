$(document).ready(function() {
	document.getElementById("showResultTableRQ").style.display = "none";
	$("#remove").hide();
	$("#del").hide();
});
function backPayment() {
	window.location.href = "gotoPayment";
}

function openTable(manualId) {
	$("#plus").hide();
	$("#remove").show();
	$("#showResultTableRQ tbody")[0].innerHTML = "";
	$.ajax({
		type : "GET",
		url : "/getDetailBilling/" + manualId,
		dataType : "json",
		async : false,
		contentType : "application/json; charset=utf-8",
		success : function(res) {
			console.log(res);
			var trE = $("<tr align='center' ></tr>");
			var td1 = $("<td align='center' ></td>").text(res.invoiceNo);
			var td2 = $("<td align='center' ></td>").text(res.invoiceDateRS);
			var td3 = $("<td align='center' ></td>").text(res.dateLineRS);
			var td4 = $("<td align='center' ></tr>").text(res.beforeVatStr);
			var td5 = $("<td align='center' ></td>").text(res.vatStr);
			var td6 = $("<td align='center' ></td>").text(res.balanceOfvatStr);
			var td7 = $("<td align='center' ></td>").text(res.discountStr);
			var td8 = $("<td align='center' ></td>").text(res.balanceSummaryStr);
			var td9 = $("<td align='center' ></td>").text(res.deductionStr);
//			var td10 = $("<td align='center' ></td>").text(res.balancePriceStr);
			var td10 = $("<td align='center' ></td>").text(res.period);
			trE.append(td1, td2, td3, td4, td5, td6, td7, td8, td9, td10);
			$("#showResultTableRQ tbody").append(trE);
		}
	});
	document.getElementById("showResultTableRQ").style.display = "table";
}
function removeTable() {

	$("#remove").hide();
	$("#plus").show();

	document.getElementById("showResultTableRQ").style.display = "none";
}
function openTableSumOther(manualId) {

	$("#plus").hide();
	$("#del").show();
	document.getElementById("showResultTableRQ").style.display = "table";
	$("#showResultTableRQ tbody")[0].innerHTML = "";
	var i = 0;
	$.ajax({
		type : "GET",
		url : "/payOtherDetail/" + manualId,
		dataType : "json",
		async : false,
		contentType : "application/json; charset=utf-8",
		success : function(res) {
			console.log(res);
			for(i =0; i < res.length ;i++){
			var trE = $("<tr align='center' ></tr>");
				var td1 = $("<td align='center' ></td>").text(res[i].amountType);
				var td2 = $("<td align='center' ></td>").text(res[i].serviceName);
				var td3 = $("<td align='center' ></td>").text(res[i].quantity);
				var td4 = $("<td align='center' ></td>").text(res[i].beforeVatStr);
				var td5 = $("<td align='center' ></tr>").text(res[i].discountStr);
				var td6 = $("<td align='center' ></td>").text(res[i].vatStr);
				var td7 = $("<td align='center' ></td>").text(res[i].discountspacalStr);
				var td8 = $("<td align='center' ></td>").text(res[i].amountStr);
	//			var td7 = $("<td align='center' ></td>")
	//					.text(res.balanceSummaryStr);
	//			var td8 = $("<td align='center' ></td>").text(res.deductionStr);
	//			var td9 = $("<td align='center' ></td>").text(res.balancePriceStr);
	//			var td10 = $("<td align='center' ></td>").text(res.period);
				trE.append(td1, td2, td3, td4, td5, td6, td7,td8);
				$("#showResultTableRQ tbody").append(trE);	
			}
		}
	});
}
function closeTableSumOther() {

	$("#del").hide();
	$("#plus").show();
	document.getElementById("showResultTableRQ").style.display = "none";
	// $("#showResultTableRQ").toggle();
}

function submti() {

//	$("#paymentFroms").attr("action", "/previewPaymentEpisOffline.pdf").attr(
//			"target", "_blank").submit();
	 window.open("/previewPaymentEpisOffline/"+$('#documentNo').val()+".pdf",  'top=0,left=0,menubar=no,status=yes,scrollbars=yes,resizable=yes,width=1500,height=700');
}
function submitOther() {

//	$("#paymentFroms").attr("action", "/previewPaymentEpisOfflineOther.pdf").attr("target", "_blank").submit();
	
	window.open("/previewPaymentEpisOfflineOther/"+$('#documentNo').val()+".pdf",  'top=0,left=0,menubar=no,status=yes,scrollbars=yes,resizable=yes,width=1500,height=700');
}

function backPaymentOther() {
	window.location.href = "payOther";
}

// $.ajax({
// type: "POST",
// url: "previewPaymentEpisOffline",
// data: JSON.stringify(dataSource),
//
// dataType: "json",
// async: false,
// contentType: "application/json; charset=utf-8",
// success: function (res) {
// if(res > 0){
// window.location.href = "paymentSuccess?idUser=" +res;
// }
// }
// })
