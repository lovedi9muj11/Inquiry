$(document).ready(function (){
	reportTax = $('#reportTax').DataTable({
		"filter" : false,
		"info" : false,
		"columnDefs": [ {
			"searchable": false,
			"orderable": false,
//			"targets": [1,12]
		} ]
	});
	search();
	
});
function search() {
	reportTax.clear().draw();
	var data = '';
	var dataSend = { "receiptNoManual": $('#billNumber').val(), "invoiceNo": $('#receiptNumber').val() };
	$.ajax({
        type: "POST",
        url: "/histroryPayment/payOrder",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	for (var i = 0; i < res.length; i++) {
                    createRow(res[i], i, "reportTax");
                }
        }
	})
};

function createRow(data, seq, table) {
	no = data.manualId
	receiptNoManual = data.receiptNoManual;
	createDate = data.createDateStr;
	dateMake = data.createDateStr;
	invoiceNo = data.invoiceNo;
	customer = data.customerName;
	payType = data.payType;
	amount = formatDouble(data.amount,2);
	branchCode = data.branchCode;
	createBy = data.createBy;
	recordStatus = data.recordStatus;
	vatAmount = formatDouble(data.vatAmount,2);
	sumTotal =  data.amount + data.vatAmount;
	
	tableInit = $('#'+table).DataTable();
    var rowNode = tableInit.row.add([no, receiptNoManual, createDate, dateMake, invoiceNo, customer, payType, amount, branchCode, createBy, recordStatus,  vatAmount, sumTotal]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('left');
    $(rowNode).find('td').eq(1).addClass('left');

};

function report() {
	
//	$('#rptCode').val('RPTxxx');
	$("#reportFrom").attr("action", "/printReport.xls").attr("target", "_blank").submit();
	
}
