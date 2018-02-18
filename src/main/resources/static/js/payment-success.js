$(document).ready(function() {
	document.getElementById("showResultTableRQ").style.display ="none" ;
});
function backPayment(){
	window.location.href = "gotoPayment";
}

function openTable(){
	document.getElementById("showResultTableRQ").style.display="table";
}

function printReportPDF(){
	
	$.ajax({
        type: "POST",
        url: "previewPaymentEpisOffline",
        data: JSON.stringify({"documentNo="+ $("#docNos").val()}),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	if(res > 0){
        		 window.location.href = "paymentSuccess?idUser=" +res;
        	}
        }
	})
	
	
	
	
	
	
	$("#documentReportForm")
    .attr("action", "previewPaymentEpisOffline?)
    .attr("target", "_blank").submit();	
}