$(document).ready(function() {
	document.getElementById("showResultTableRQ").style.display ="none" ;
	$("#remove").hide();
	$("#del").hide();
});
function backPayment(){
	window.location.href = "gotoPayment";
}

function openTable(){
	$("#plus").hide();
	$("#remove").show();
	document.getElementById("showResultTableRQ").style.display="table";
}
function removeTable(){
	
	$("#remove").hide();
	$("#plus").show();
	document.getElementById("showResultTableRQ").style.display="none";
}
function openTableSumOther(){
	
	$("#plus").hide();
	$("#del").show();
	document.getElementById("showResultTableRQ").style.display="table";
	//$("#showResultTableRQ").toggle();
}
function closeTableSumOther(){
	
	$("#del").hide();
	$("#plus").show();
	document.getElementById("showResultTableRQ").style.display="none";
	//$("#showResultTableRQ").toggle();
}

function submti(){

		$("#paymentFroms").attr("action", "/previewPaymentEpisOffline.pdf")
		.attr("target", "_blank").submit();
}
function submitTest(){

	$("#paymentFroms").attr("action", "/previewPaymentEpisOfflineByInsale.pdf")
	.attr("target", "_blank").submit();
}

function backPaymentOther(){
	window.location.href = "payOther";
}


//	$.ajax({
//        type: "POST",
//        url: "previewPaymentEpisOffline",
//        data: JSON.stringify(dataSource),
//
//        dataType: "json",
//        async: false,
//        contentType: "application/json; charset=utf-8",
//        success: function (res) {
//        	if(res > 0){
//        		 window.location.href = "paymentSuccess?idUser=" +res;
//        	}
//        }
//	})
