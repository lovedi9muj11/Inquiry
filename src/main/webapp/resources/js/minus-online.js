$(document).ready(function () {
	histroryTB = $('#histroryPaymentTB').DataTable({
		"filter" : false,
		"info" : false,
//		"order": [[ 2, 'asc' ]],
		"columnDefs": [ {
			"searchable": false,
//			"orderable": false
//			"targets": [0,2],
//			"checkboxes": {"selectRow": true}
		} ]
		});
	
	search();
	
	$('#clearCriteria').click(function(){
		$('#clearing').val('');
		search();
	});
});

function search(){
	histroryTB.clear().draw();
	var data = '';
	var dataSend = {"clearing": $('#clearing').val()};
	$.ajax({
        type: "POST",
        url: ctx +"/clearing/find",
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
	branchCode = data.brancharea;
	createBy = data.createBy;
	invoiceNo = data.invoiceNo;
	period = data.period;
	amount = formatDouble(data.paidAmount,2);
	source = data.paymentMethod;
	paidAmount = formatDouble(data.amount,2);
	vatAmount = formatDouble(data.vatAmount,2);
	if(data.recordStatus == 'A'){
		recordStatus = 'ปกติ';
		remark = "-"
//		if(data.clearing == "Y"){
//			cearling = '-'
//		}else{
//			cearling = '<a name="cearling" id="cearling" onclick="dialogRemakes('+data.manualId+')"><span name="icon" id="icon" class="fa fa-envelope"></a>';
//		}
		
	}else if(data.recordStatus == 'C'){
		recordStatus = 'ยกเลิก';
		remark ='<a name="invoice" id="invoice" onclick="dialogRemake('+data.manualId+')"><span name="icon" id="icon" class="fa fa-envelope"></a>';
		
	}
	clearing = data.clearing;
	accountNo = data.accountNo;
	
	if(clearing === "Y"){
		clearing = "ส่งหักล้างแล้ว";
	}else{
		clearing = "ยังไม่ส่งหักล้าง";
	}
	
	checkbox = '<input type="checkbox" name="check" value='+data.manualId+'></input>';
	
	
    var t = $('#histroryPaymentTB').DataTable();
    var rowNode = t.row.add([checkbox, no ,paidDate ,createDate ,receiptNoManual, branchCode, createBy ,invoiceNo ,period , amount, source, paidAmount, vatAmount, recordStatus, remark, clearing]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('center');
    $(rowNode).find('td').eq(1).addClass('left');
    $(rowNode).find('td').eq(2).addClass('left');
    $(rowNode).find('td').eq(3).addClass('left');
    $(rowNode).find('td').eq(4).addClass('left');
    $(rowNode).find('td').eq(5).addClass('left');
    $(rowNode).find('td').eq(6).addClass('left');
    $(rowNode).find('td').eq(7).addClass('left');
    $(rowNode).find('td').eq(8).addClass('left');
    $(rowNode).find('td').eq(9).addClass('right');
    $(rowNode).find('td').eq(10).addClass('center');
    $(rowNode).find('td').eq(11).addClass('right');
    $(rowNode).find('td').eq(12).addClass('right');
    $(rowNode).find('td').eq(13).addClass('left');
    $(rowNode).find('td').eq(14).addClass('center');
    $(rowNode).find('td').eq(15).addClass('center');
//    $(rowNode).find('td').eq(16).addClass('center');
    $(rowNode).find('td').eq(16).addClass('center');
};
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
        	$("#remake").val(res.remark);
        }
	})
};

function sendCearling(){
	var clearing = $("#clearing").val();
	if(clearing === "Y"){
		return alert("กรุณาเลือกขอ้มูลให้ถูกต้อง");
	}
	
	var dataSend = {"clearing": $('#clearing').val()};
	$.ajax({
        type: "POST",
        url: ctx +"/clearing/save",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	
        	search();
        }
	})
	
	
}

function dialogRemakes(){
	$("#confrimDialog").modal('show');
};

function closeDialog(){
	$("#remake_dialog").modal('hide');
}
function confirmDialog(){
	var data = [];
	if($('input[name="check"]:checked').length <= 0){
		closeDialogs();
		$("#errorShow").modal('show');
		return;
	}
	var dataSend = {};
	
	for(var i = 0; i < $('input[name="check"]:checked').length; i++){
		var value = $($('input[name="check"]:checked')[i]).val();
		dataSend = {"manualId" : value , "recordStatus":"A"};
		data.push(dataSend);
	}
	$.ajax({
        type: "POST",
        url: ctx +"/histroryPayment/clearing",
        data: JSON.stringify(data),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	if(res.data){
        		
        		$("#confrimDialog").modal('hide');
        		search();
//        		$("#showLogs").val(res.data);
        		$("#showLog").modal('show');
        		getMeassage(res.data);
            	
        	}
        
        	
        }
	})
}

function getMeassage(data){
	var msgS = "Success : ";
	var msgE = "Error :";
	for(var i=0; i< data.length;i++){
		if(data[i].status == "SUCCESS"){
			if(i == 0){
				msgS += data[i].recriptNo
			}else{
				msgS += data[i].recriptNo +"," ;
			}
			
		}else{
			if(i == 0){
				msgE += data[i].recriptNo
			}else{
				msgE += data[i].recriptNo +"," ;
			}
		}
	}
	document.getElementById("showLogs").innerHTML = msgS;
	document.getElementById("showLoge").innerHTML = msgE;
}

function closeDialogs(){
	$("#confrimDialog").modal('hide');
}
function closeLog(){
	$("#showLog").modal('hide');
}
function closeLogError(){
	$("#errorShow").modal('hide');
}

