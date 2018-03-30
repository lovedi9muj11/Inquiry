var dateFromGlobal = "";
var dateToGlobal = "";
$(document).ready(function (){
	var userName = $('#userName').val();
	console.log("======================= Start report payment ======================");
	reportPaymentTb = $('#reportPaymentTb').DataTable({
		"filter" : false,
		"info" : false,
		"columnDefs": [ {
			"searchable": false,
			"orderable": false,
//			"targets": [1,12]
		} ]
	});
	initCriteria();
	search();

	
});
function initCriteria(){
	
	var now = new Date();
	var day = ("0" + now.getDate()).slice(-2);
	var month = ("0" + (now.getMonth() + 1)).slice(-2);
	var today = now.getFullYear()+"-"+(month)+"-"+(day);
	
	$('#dateFrom').val(today);
	$('#dateTo').val(today);
	$('#dateFromHour').val('00');
	$('#dateFromMinute').val('00');
	$('#dateToHour').val('23');
	$('#dateToMinute').val('59');
	$('#vat').val('');
	$('#categoryPayment').val('');
};

function search(){
	reportPaymentTb.clear().draw();
	var dateFrom = $('#dateFrom').val() +" "+ $('#dateFromHour').val() +":"+ $('#dateFromMinute').val()+":00";
	var dateTo =$('#dateTo').val() +" "+ $('#dateToHour').val() +":"+ $('#dateToMinute').val()+":00";
	dateFromGlobal = dateFrom;
	dateToGlobal = dateTo;
	var data = '';
	var dataCritaria = {
			"dateFrom": dateFrom,
			"dateTo": dateTo,
			"vatRate": $('#vat').val(),
			"user":  $('#authorities').val(),
			"serviceType": $('#serviceType').val(),
			"accountId": $('#accountId').val()
		};
	$.ajax({
        type: "POST",
        url: "/reportPayment",
        data: JSON.stringify(dataCritaria),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
	    	for (var i = 0; i < res.length; i++) {
	                createRow(res[i], i);
	            }
        }
	})
};

function clearCriteria(){
	initCriteria();
	search();
};

function printReport(){
	$('#dateFromHidden').val(dateFromGlobal);
	$('#dateToHidden').val(dateToGlobal);
	$('#machinePaymentNameHidden').val($('#machinePaymentName').val());
	$('#accountIdHidden').val($('#accountId').val());
	$('#authoritiesHidden').val($('#authorities').val());
	$("#paymentFrom").attr("action", "/reportPaymentExcel").attr("target", "_blank").submit();
};

function printReportPDF(){
	$('#dateFromHidden').val(dateFromGlobal);
	$('#dateToHidden').val(dateToGlobal);
	$('#machinePaymentNameHidden').val($('#machinePaymentName').val());
	$('#accountIdHidden').val($('#accountId').val());
	$('#authoritiesHidden').val($('#authorities').val());
	$("#paymentFrom").attr("action", "/reportPaymentPDF").attr("target", "_blank").submit();
};

function createRow(data, seq) {
	manualId = data.manualId
	serviceType = data.serviceType;
	receiptNo = data.receiptNoManual;
	accountSubNo = data.accountSubNo;
	customerName = data.customerName;
	department = data.department;
	invoiceNo = data.invoiceNo;
	createBy = data.createBy;
	noRefer = '-';
	beforVat = data.beforVat;
	vatAmount =  formatDouble(data.vatAmount,2);
	amount =  formatDouble(data.amount,2);
	if (data.status == 'C'){
		statusStr = data.statusStr;
	}else{
		statusStr = ''
	}
	
	
    var t = $('#reportPaymentTb').DataTable();
    var rowNode = t.row.add([manualId, serviceType, receiptNo, accountSubNo, customerName, department, invoiceNo, createBy ,noRefer , beforVat, vatAmount, amount, statusStr
    ]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('left');
    $(rowNode).find('td').eq(1).addClass('left');
    $(rowNode).find('td').eq(2).addClass('left');
    $(rowNode).find('td').eq(3).addClass('left');
    $(rowNode).find('td').eq(4).addClass('left');
    $(rowNode).find('td').eq(5).addClass('left');
    $(rowNode).find('td').eq(6).addClass('left');
    $(rowNode).find('td').eq(7).addClass('left');
    $(rowNode).find('td').eq(8).addClass('right');
    $(rowNode).find('td').eq(9).addClass('center');
    $(rowNode).find('td').eq(10).addClass('right');
    $(rowNode).find('td').eq(11).addClass('right');
    $(rowNode).find('td').eq(12).addClass('left');
};