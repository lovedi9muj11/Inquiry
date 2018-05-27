var tableInit;
var tableSelect;
var dataSelect;
var idRow;
var userFullName = '';
var customerAddress = '';
var clearing;
var valueIcon = "";
$(document).ready(function () {
    console.log("ready!");

	cancelPaymentTB = $('#cancelPaymentTB').DataTable({
		"filter" : false,
		"info" : false,
		"order": [[ 2, 'asc' ]],
		"columnDefs": [ {
			"searchable": false,
//			"orderable": false,
//			"targets": [1,12]
		} ]
	});
    $("#error").hide();
    $("#success").hide();
    $("#notClear").hide();
    $("#errorSup").hide();
    hidePanel()
    showPanel('1');
    removeCssLi();
    addCssLi('1');
    search();
    
    $('#cancelPaymentTB tbody').on('change', ':radio', function() {
    	 	$("#mi-modal").modal('show');
            idRow = parseInt($('input[name="select"]:checked').val());
        
    });
    $('#btn2').click(function(){
    	console.log("sssssssssssssssssssssssssss");
    });
    function clickInvoiceDetail(){
        var tr = $(this).closest('tr');
        var row = tableInit.row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
            tr.addClass('shown');
        }
    	
    };
    $('#cancelPaymentTB tbody').on('click', '#invoice', function () {
        var tr = $(this).closest('tr');
        var row = tableInit.row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            $('#'+valueIcon).addClass('glyphicon-plus').removeClass('glyphicon-minus');
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
            $('#'+valueIcon).addClass('glyphicon-minus').removeClass('glyphicon-plus');
            tr.addClass('shown');
        }
    });
    
    $('#selectCancelPaymentTB tbody').on('click', '#btn2', function () {
        var tr = $(this).closest('tr');
        var row = tableSelect.row(tr);

        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            $('#'+valueIcon).addClass('glyphicon-plus').removeClass('glyphicon-minus');
        }
        else {
            // Open this row
            row.child(format(row.data())).show();
            $('#'+valueIcon).addClass('glyphicon-minus').removeClass('glyphicon-plus');
        }
    });  
	  
    var modalConfirm = function(callback){	  

    	  $("#modal-btn-si").on("click", function(){
    	    callback(true);
    	    $("#mi-modal").modal('hide');
    	  });
    	  
    	  $("#modal-btn-no").on("click", function(){
    	    callback(false);
    	    $("#mi-modal").modal('hide');
    	  });
    	};
   	
    	modalConfirm(function(confirm){
    	    $("#error").hide();
    	    $("#success").hide();
    	    $("#notClear").hide();
    	    $("#errorSup").hide();
      	  if(confirm){
      		cancelPaymentTB.clear().draw();
      			var dataSend = { "userName": $('#userName').val(), "password": $('#password').val() };
      			$.ajax({
      		        type: "POST",
      		        url: "/cancelPayment/checkAuthentication",
      		        data: JSON.stringify(dataSend),
      		        dataType: "json",
      		        async: false,
      		        contentType: "application/json; charset=utf-8",
      		        success: function (res) {
      		        	console.log(res);
      		        	if(res == 0){
      		        		$('#selectCancelPaymentTB').DataTable({
      		        			"filter" : false,
      		        			"info" : false,
      		        			"columnDefs": [ {
      		        				"searchable": false,
      		        				"orderable": false,
//      		        				"targets": [1,12]
      		        			} ]
      		        		});
      		        	var dataSend2 = { "manualId": idRow};
      		     			$.ajax({
      		     		        type: "POST",
      		     		        url: "/cancelPayment/findFromId",
      		     		        data: JSON.stringify(dataSend2),
      		     		        dataType: "json",
      		     		        async: false,
      		     		        contentType: "application/json; charset=utf-8",
      		     		        success: function (res) {
      		     		        	if(res.length != 0){
      		     		        		for (var i = 0; i < res.length; i++) {
      		     		        			createRow(res[i], i, "cancelPaymentTB", false);
      		     		        			
          		     		            }
	      		  		     			showTableSelect();
	      		  		     			var $radios = $('input:radio[name=select]');
	      		  		     		 	$radios.filter('[value="'+idRow+'"]').prop('checked', true);
      		     		        	}else{
	      		     		       		$("#notClear").show();
	      		     		      	    hidePanel()
	      		     		      	    showPanel('1');
	      		     		      	    removeCssLi();
	      		     		      	    addCssLi('1');
	      		     		      	    search();
      		     		        	}
      		     		        	
      		     		        }
      		     			});
//      		     			$('#submitCancelPM').prop('disabled', true);
      		        	}else if(res == 2){
      		        		$("#error").show();
      		        	    hidePanel()
      		        	    showPanel('1');
      		        	    removeCssLi();
      		        	    addCssLi('1');
      		        	    search();
      		        	}else if(res == 1){
      		      		$("#errorSup").show();
  		        	    hidePanel()
  		        	    showPanel('1');
  		        	    removeCssLi();
  		        	    addCssLi('1');
  		        	    search();
      		        	}
      		        	
      		        }
      			});
      			

      	  }
      	$('#userName').val('');
      	$('#password').val('');
      }); 
});


function showTableSelect(){
    hidePanel();
    showPanel("2");
    removeCssLi();
    addCssLi('2');
};
//function showDetail(){
//    var tr = $(this).closest('tr');
//    var row = tableSelect.row(tr);
//
//    if (row.child.isShown()) {
//        // This row is already open - close it
//        row.child.hide();
//        tr.removeClass('shown');
//    }
//    else {
//        // Open this row
//        row.child(format(row.data())).show();
//        tr.addClass('shown');
//    }
//};

function search() {
	cancelPaymentTB.clear().draw();
	var data = '';
	var dataSend = { "invoiceNo": $('#billNumber').val(), "receiptNoManual": $('#receiptNumber').val() };
	$.ajax({
        type: "POST",
        url: "/cancelPayment/find",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	for (var i = 0; i < res.length; i++) {
                    createRow(res[i], i, "cancelPaymentTB", true);
                }
        }
	})
	
};

function clearCriteria(){
	$('#billNumber').val('');
	$('#receiptNumber').val('');
	search();
};
function chaengIcon(value){
	valueIcon= 'icon'+value;
}
function createRow(data, seq, table,check) {
	radioSelect =  '<input type="radio" name="select" value="'+data.manualId+'"> <input type="hidden" name="clearing" id="clearing" value="'+data.clearing+'">'
	invoice =  '<a name="invoice" id="invoice" onclick="chaengIcon('+data.manualId+')"><span name="icon'+data.manualId+'" id="icon'+data.manualId+'" class="glyphicon glyphicon-plus"></a>'
	no = seq+1;
	receiptNoManual = data.receiptNoManual;
	createDate = data.createDateStr
	dateMake = data.createDateStr;
	accountNo = data.accountNo;
	customer = data.customerName;
	payType = data.paymentMethod;
	amount = formatDouble(data.amount,2);
	branchCode = data.brancharea;
	createBy = data.createBy;
	if(data.recordStatus == 'A'){
		recordStatus = 'ปกติ';
	}else if(data.recordStatus == 'C'){
		recordStatus = 'ยกเลิก';
	}
	vatAmount = formatDouble(data.vatAmount,2);
	sumTotal =  data.amount + data.vatAmount;
	
	customerAddress = data.customerAddress;
	userFullName = data.customerName;
	
	tableInit = $('#'+table).DataTable();
	var rowNode = tableInit.row.add([invoice,radioSelect, no, receiptNoManual, createDate, dateMake, accountNo, customer, payType, amount, branchCode, createBy, recordStatus, vatAmount, sumTotal]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('center').width('5px');
    $(rowNode).find('td').eq(1).addClass('center').width('5px');
    $(rowNode).find('td').eq(2).addClass('center').width('40px');
    $(rowNode).find('td').eq(3).addClass('center').width('5px');
    $(rowNode).find('td').eq(4).addClass('center').width('5px');
    $(rowNode).find('td').eq(5).addClass('center').width('5px');
    $(rowNode).find('td').eq(6).addClass('center').width('50px');
    $(rowNode).find('td').eq(7).addClass('center').width('5px');
    $(rowNode).find('td').eq(8).addClass('center').width('5px');
    $(rowNode).find('td').eq(9).addClass('center').width('5px');
    $(rowNode).find('td').eq(10).addClass('center').width('10px');
    $(rowNode).find('td').eq(11).addClass('center').width('20px');
    $(rowNode).find('td').eq(12).addClass('center').width('5px');
    $(rowNode).find('td').eq(13).addClass('center').width('5px');

};

function createRowSelect(data, seq, table) {
	customerAddress = data.customerAddress;
	userFullName = data.customerName;
	no = seq+1;
	receiptNoManual = data.receiptNoManual;
	createDate =data.createDateStr;
	dateMake = data.createDateStr;
	accountNo = data.accountNo;
	customer = data.customerName;
	payType = data.paymentMethod;
	amount = formatDouble(data.amount,2);
	branchCode = data.brancharea;
	createBy = data.createBy;
	recordStatus = data.recordStatus;
	vatAmount = formatDouble(data.vatAmount,2);
	sumTotal =  data.amount + data.vatAmount;
	tableSelect = $('#'+table).DataTable();
    var rowNode = tableSelect.row.add([no, receiptNoManual, createDate, dateMake, accountNo, customer, payType, amount, branchCode, createBy, recordStatus, vatAmount, sumTotal]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('center');
    $(rowNode).find('td').eq(1).addClass('center');

};



function format(d) {
	sprintStr =  d[9].split(",");
	invoice = parseFloat(sprintStr[0]+sprintStr[1]) - parseFloat(d[13])
    return '<table class="table table-bordered" cellspacing="0" width="100%">'+
			    '<thead>'+
			    '<tr>'+
			        '<th style="text-align: left;">รายการ</th>'+
			        '<th style="text-align: right;">จำนวน</th>'+
			        '<th style="text-align: right;">ส่วนลด</th>'+
			        '<th style="text-align: right;">ภาษีมูลค่าเพิ่ม</th>'+
			        '<th style="text-align: right;">จำนวนเงิน</th>'+
			    '</tr>'+
			'</thead>'+
			'<tbody>'+
			    '<tr>'+
			        '<th style="text-align: left;">'+'invoiceNo :'+d[6]+'</th>'+
			        '<th style="text-align: right;">'+invoice +'</th>'+
			        '<th style="text-align: right;">'+"-"+'</th>'+
			        '<th style="text-align: right;">'+d[13]+'</th>'+
			        '<th style="text-align: right;">'+d[9]+'</th>'+
			    '</tr>'+
			'</tbody>'
		'</table>';
};

//action Controller
function submitCancelPayment(){
	var dataSet = {
			"manualId" : idRow,
			"statusCancelPayment":$('#problemCancel').val(),
			"addressNewCancelPayment": $('#address').val(),
			"customerName": $('#fullName').val()
	};
	$.ajax({
	        type: "POST",
	        url: "/cancelPayment/updateStatus",
	        data: JSON.stringify(dataSet),
	        dataType: "json",
	        async: false,
	        contentType: "application/json; charset=utf-8",
	        success: function (data) {
	        	if(data != 0){
	        		$('#receiptNo').val(data);
	        		$("#cancelPaymentForm").attr("action", "/reportCancelPaymentPDF").attr("target", "_blank").submit();
	        	}else{
	        		$("#error").show();
	        	}
	        	$("#success").show();
        	    hidePanel()
        	    showPanel('1');
        	    removeCssLi();
        	    addCssLi('1');
        		search();
	        }
		});
};


function addCssLi(select) {
    $("#li" + select).css("color", "red")
};
function removeCssLi(){
	 $("#li1" ).css("color", "black");
	 $("#li2" ).css("color", "black");
	 $("#li3" ).css("color", "black");
	 $("#li4" ).css("color", "black");
};

function showPanel(select) {
    $("#panel" + select).show();
};

function hidePanel(){
    $("#panel1").hide();
    $("#panel2").hide();
    $("#panel3").hide();
    $("#panel4").hide();
};

function showReasonCancel(){
	if($('#problemCancel').val() != ''){
		if($('#problemCancel').val() == '02'){
			 $("#fullName").val(userFullName);
			 $("#address").val(customerAddress);
			$("#reason-cancel").modal('show');
		}else{
			var r = confirm("คุณต้องการยกเลิกรายการหรือไม่ ");
			if(r){
				$("#reason-cancel").modal('hide');
				submitCancelPayment();
			}
			
		}
	}else{
		alert("โปรดระบุตัวเลือก");
	}
};

function modalConfirmReason(callback){
	if(callback){
		var r = confirm("คุณต้องการยกเลิกรายการหรือไม่ ");
		if(r){
			submitCancelPayment();
			$("#reason-cancel").modal('hide');
		}
	}else{
		$("#reason-cancel").modal('hide');
	}

};
function converDateToString(value){
	var d = new Date(value)
    month = '' + (d.getMonth() + 1),
    day = '' + d.getDate(),
    year = d.getFullYear(),
    hours = d.getHours(),
    minutes = d.getMinutes(),
    seconds = d.getSeconds();

	if (month.length < 2) month = '0' + month;
	if (day.length < 2) day = '0' + day;
	
	if (hours.length < 2) hours = '0' + hours;
	if (minutes.length < 2) minutes = '0' + minutes;
	if (seconds.length < 2) seconds = '0' + seconds;

return [day, month, year].join('/')+" "+ [hours,minutes,seconds].join(':');
};








