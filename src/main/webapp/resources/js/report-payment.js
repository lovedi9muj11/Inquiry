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
	dropdownUser();
	deopdownAccount();

	
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
	$("#authorities").val('');
	$("#serviceType").val('');
	$("#accountId").val('');
	
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
	manualId = seq+1;
	if(data.serviceType = 'IBACSS'){
		serviceType = 'รับชำระค่าใช้บริการ';
	}else if(data.serviceType = 'OTHER'){
		serviceType = 'รับชำระค่าใช้บริการอื่น ๆ';
	}
	receiptNo = data.receiptNoManual;
	accountSubNo = data.accountSubNo;
	customerName = data.customerName;
	department = data.department;
	invoiceNo = data.invoiceNo;
	createBy = data.paymentMethod;
	noRefer = '-';
	beforVat = data.beforVat;
	vatAmount =  formatDouble(data.vatAmount,2);
	amount =  formatDouble(data.amount,2);
	if (data.status == 'C'){
		statusStr = data.statusStr;
		remake = '<a name="invoice" id="invoice" onclick="dialogRemake('+data.manualId+')"><span name="icon" id="icon" class="fa fa-envelope"></a>';
	}else{
		remake = "";
		statusStr = ''
	}
	
	
	
	
    var t = $('#reportPaymentTb').DataTable();
    var rowNode = t.row.add([manualId, serviceType, receiptNo, accountSubNo, customerName, department, invoiceNo, createBy ,noRefer , beforVat, vatAmount, amount, statusStr,remake
    ]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('center');
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
    $(rowNode).find('td').eq(12).addClass('center');
    $(rowNode).find('td').eq(13).addClass('center');
};

function dropdownUser(){
	var dataSend = { "username": "" };
	var userLogin = $("#userLogin").val();
	var supervisor = false;

	$.ajax({
        type: "POST",
        url: "/userManageMent/search",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
	        for(var a = 0, value = res.length; value>a ; a++){
	        	if(userLogin == res[a].userName){
	        		if(res[a].roleCode == 'sup '){
	        			generateDropDown(res);
	        		}else{
	        		  var $el = $("#authorities");
	        	      $el.empty();
	        	      $el.append($("<option>").attr('value',userLogin).text(userLogin));
	        	      $el.prop( "disabled", true );
	        		}
	        		break;
	        	}
	        }
        }
	});
	
};
function deopdownAccount(){
	$.ajax({
        type: "POST",
        url: "/findGL_AccountMaster",
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	var $el = $("#accountId");
            $el.empty();
            $el.append($("<option></option>").attr("value", '').text('ทั้งหมด'));
	        for(var a = 0, s = res.length; s>a ; a++){
	        	$el.append($("<option>").attr('value',res[a].glCode).text(res[a].glCode));
	        }
        }
	});
	
}
function generateDropDown(value){
	var $el = $("#authorities");
    $el.empty();
    $el.append($("<option></option>").attr("value", '').text('ทั้งหมด'));
    for(var a = 0, s = value.length; s>a ; a++){
    	if(value[a].roleCode == 'user '){
    		$el.append($("<option>").attr('value',value[a].userName).text(value[a].userName));
    	}
    }
};

function dialogRemake(value){
	$("#remake_dialog").modal('show');
	var dataSend = {"manualId": value};
	$.ajax({
        type: "POST",
        url: "/histroryPayment/findInvoiceByManualId",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	$("#remake").val(res.remark);
        }
	})
};
function closeDialog(){
	$("#remake_dialog").modal('hide');
}