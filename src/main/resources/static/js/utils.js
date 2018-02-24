$(document).ready(function() {
	$('.format4D').autoNumeric({vMin:'0.0000',vMax:'99999999999.9999'});
	$('.format2D').autoNumeric({vMin:'0.00',vMax:'9999999999999.99'});
	$('.numeric2point').autoNumeric({vMin:'0.00',vMax:'9999999999.99'});
	$('.format2DSib').autoNumeric({vMin:'0.00',vMax:'99.99'});
});

function formatDouble(num, scale) {
	if(scale === undefined) scale = 2;
	if(!$.isNumeric(num)) return num;
	return num.toFixed(scale).toString().replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
}

function changeMoney(changeRQ){
	//var balanceSummary = $("#moneyTran").val();
	 $("#change").val(changeRQ.toFixed(2));
}

function formetMon(value) {
	return parseFloat(value.replace(",", ""));
}