$(document).ready(function () {
	histroryTB = $('#histroryPaymentTB').DataTable({
		"filter" : false,
		"info" : false,
		"columnDefs": [ {
			"searchable": false,
			"orderable": false
//			"targets": [0,2]
		} ]
		});
	
	search();
	
	$('#clearCriteria').click(function(){
		$('#billAccount').val('');
		search();
	});
});

function search(){
	histroryTB.clear().draw();
	var data = '';
	var dataSend = {"accountNo": $('#billAccount').val()};
	$.ajax({
        type: "POST",
        url: "/histroryPayment/find",
        data: JSON.stringify(dataSend),
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

function createRow(data, seq) {

	no = seq + 1
	paidDate = data.paidDateStr;
	createDate = data.createDateStr;
	receiptNoManual = data.receiptNoManual;
	branchCode = data.branchCode;
	createBy = data.createBy;
	invoiceNo = data.invoiceNo;
	period = data.period;
	amount = data.amount;
	source = data.source;
	paidAmount = data.paidAmount;
	vatAmount = data.vatAmount;
	recordStatus = data.recordStatus;

	if(data.remark == null){
		remark = "-"
	}else{
		remark = data.remark;
	}
	accountNo = data.accountNo;
	
    var t = $('#histroryPaymentTB').DataTable();
    var rowNode = t.row.add([no, paidDate, createDate, receiptNoManual, branchCode, createBy, invoiceNo, period, amount, source, paidAmount, vatAmount, recordStatus, remark, accountNo
    ]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('center');
    $(rowNode).find('td').eq(3).addClass('center');
};





