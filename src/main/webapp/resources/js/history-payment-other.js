var checkClick = true;
var valueIcon = "";
var IdSelected = "";
var tableInit;

$(document).ready(function () {
//	document.getElementById("showResultTableRQ").style.display = "none";
	
	histroryTB = $('#histroryPaymentTB').DataTable({
		"filter" : false,
		"info" : false,
//		"order": [[ 2, 'asc' ]],
		"columnDefs": [ {
			"searchable": false
//			"orderable": false
//			"targets": [0,2]
		} ]
		});
	
	search();
	
	$('#clearCriteria').click(function(){
		$('#billAccount').val('');
		$('#taxId').val('');
		$('#custName').val('');
		search();
	});
	
	$('#histroryPaymentTB tbody').on('click', '#plus_invoice', function () {
	    var tr = $(this).closest('tr');
	    var row = tableInit.row(tr);

	    if (row.child.isShown()) {
	        row.child.hide();
	        $('#'+valueIcon).addClass('glyphicon-plus').removeClass('glyphicon-minus');
	        tr.removeClass('shown');
	    }
	    else {
	    	var url;
	    	url = ctx +"/payOtherDetail/"+IdSelected;
	     	$.ajax({
			        type: "GET",
			        url: url,
			        dataType: "json",
			        async: false,
			        contentType: "application/json; charset=utf-8",
			        success: function (res) {
						row.child(format(res)).show();
						$('#'+valueIcon).addClass('glyphicon-minus').removeClass('glyphicon-plus');
			        }
	     	});
	    }
	});
});

function search(){
	histroryTB.clear().draw();
	var data = '';
	var dataSend = {"accountNo": $('#billAccount').val(), "taxId": $('#taxId').val(), "custName": $('#custName').val()};
	$.ajax({
        type: "POST",
        url: ctx +"/histroryPaymentByother/find",
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
	paidDate = data.createDateStr;
	createDate = data.createDateStr;
	receiptNoManual = data.receiptNoManual;
	branchCode = data.brancharea;
	createBy = data.createBy;
//	invoiceNo = data.invoiceNo!=null?data.invoiceNo:'-';
//	period = data.period!=null?data.period:'-';
	amount = formatDouble(data.amount,2);
	source = data.paymentMethod;
	paidAmount = formatDouble(data.paidAmount,2);
	vatAmount = formatDouble(data.vatAmount,2);
	discountBeforVat = formatDouble(data.discountBeforVat,2);
	discountSpecial = formatDouble(data.discountSpecial,2);
	if(data.recordStatus == 'A'){
		recordStatus = 'ปกติ';
		if(data.remark != ""){
			remark ='<a name="remark" id="remark" onclick="dialogRemake('+data.manualId+')"><span name="icon" id="icon" class="fa fa-envelope"></a>';
		}else {
			remark = '-';
		}
	}else{
		recordStatus = 'ยกเลิก';
		if(data.remark != ""){
		remark ='<a name="remark" id="remark" onclick="dialogRemake('+data.manualId+')"><span name="icon" id="icon" class="fa fa-envelope"></a>';
		}else {
			remark = '-';
		}
	}
	
	plus_invoice =  '<a name="plus_invoice" id="plus_invoice" onclick="chaengIcon('+data.manualId+')"><span name="icon'+data.manualId+'" id="icon'+data.manualId+'" class="glyphicon glyphicon-plus"></a>'
	
//	actionP = plus+del;
	
	accountNo = data.accountNo;
	custName = data.customerName;
	
    var t = $('#histroryPaymentTB').DataTable();
    tableInit = t;
    var rowNode = t.row.add([plus_invoice, no ,paidDate ,createDate ,receiptNoManual, accountNo, custName, branchCode, createBy , paidAmount, discountBeforVat, discountSpecial, source, amount, recordStatus, remark, accountNo
    ]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('center');
    $(rowNode).find('td').eq(1).addClass('left');
    $(rowNode).find('td').eq(2).addClass('left');
    $(rowNode).find('td').eq(3).addClass('left');
    $(rowNode).find('td').eq(4).addClass('left');
    $(rowNode).find('td').eq(5).addClass('center');
    $(rowNode).find('td').eq(6).addClass('center');
    $(rowNode).find('td').eq(7).addClass('left');
    $(rowNode).find('td').eq(8).addClass('center');
    $(rowNode).find('td').eq(9).addClass('center');
    $(rowNode).find('td').eq(10).addClass('center');
    $(rowNode).find('td').eq(11).addClass('center');
    $(rowNode).find('td').eq(12).addClass('center');
//    $(rowNode).find('td').eq(11).addClass('right');
    $(rowNode).find('td').eq(13).addClass('right');
    $(rowNode).find('td').eq(14).addClass('left');
    $(rowNode).find('td').eq(15).addClass('center');
}

function chaengIcon(value){
	valueIcon= 'icon'+value;
	IdSelected = value;
}

function dialogRemake(value){
	$("#remake_dialog").modal('show');
	var dataSend = {"manualId": value};
	$.ajax({
        type: "POST",
        url: ctx +"/histroryPayment/findInvoiceByManualId",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	$("#remake").text(res.remark);
        }
	})
}

function closeDialog(){
	$("#remake_dialog").modal('hide');
}

function closeTableSumOther() {

	$("#del").hide();
	$("#plus").show();
	document.getElementById("showResultTableRQ").style.display = "none";
	checkClick = true;
}

function format(d) {
	var txt="";
	var i = 0;
	for(i=0; i < d.length; i++){
		txt = txt+ '<tr>'+
			        '<th style="text-align: left;">'+d[i].amountType+'</th>'+
			        '<th style="text-align: left;">'+d[i].serviceName+'</th>'+
			        '<th style="text-align: right;">'+d[i].quantity+'</th>'+
			        '<th style="text-align: right;">'+d[i].beforeVatStr+'</th>'+
			        '<th style="text-align: right;">'+d[i].vatStr+'</th>'+
			        '<th style="text-align: right;">'+d[i].discountStr+'</th>'+
			        '<th style="text-align: right;">'+d[i].discountspacalStr+'</th>'+
			        '<th style="text-align: right;">'+d[i].amountStr+'</th>'+
			    '</tr>'
	}

    return '<table class="table table-bordered" cellspacing="0" width="100%">'+
			    '<thead>'+
			    '<tr>'+
			        '<th style="text-align: center;">ประเภทรายได้</th>'+
			        '<th style="text-align: center;">ชื่อบริการ</th>'+
			        '<th style="text-align: right;">จำนวนรายการ</th>'+
			        '<th style="text-align: right;">จำนวนเงินต่อหน่วย</th>'+
			        '<th style="text-align: right;">ภาษีมูลค่าเพิ่ม</th>'+
			        '<th style="text-align: right;">ส่วนลด</th>'+
			        '<th style="text-align: right;">ส่วนลดพิเศษ</th>'+
			        '<th style="text-align: right;">ยอดเงินรวม</th>'+
			    '</tr>'+
			'</thead>'+
			'<tbody>'+
			txt +
			'</tbody>'
		'</table>';
};
