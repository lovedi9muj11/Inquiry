var tableInit;
var tableSelect;
var dataSelect;
var idRow;
$(document).ready(function () {
    console.log("ready!");

	cancelPaymentTB = $('#cancelPaymentTB').DataTable({
		"filter" : false,
		"info" : false,
		"columnDefs": [ {
			"searchable": false,
			"orderable": false,
//			"targets": [1,12]
		} ]
	});
    $("#error").hide();
    $("#success").hide();
    hidePanel()
    showPanel('1');
    removeCssLi();
    addCssLi('1');
    search();
    
    $('#cancelPaymentTB tbody').on( 'click', '#btn-confirm', function () {
    	 $("#mi-modal").modal('show');
    	 	var data = tableInit.row( $(this).parents('tr') ).data();
    	 	idRow = data[0];
       	 	console.log(idRow);
//    	 dataSelect = tableInit.row( $(this).parents('tr') ).data();
        
    });
    $('#btn2').click(function(){
    	console.log("sssssssssssssssssssssssssss");
    });
    
    $('#cancelPaymentTB tbody').on('click', '#btn', function () {
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
    });
    
    $('#selectCancelPaymentTB tbody').on('click', '#btn2', function () {
        var tr = $(this).closest('tr');
        var row = tableSelect.row(tr);

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
   	
   function createRowSelectCCPayment(data) {
    		no = data[0];
    		receiptNoManual = data[1];
    		createDate = data[2];
    		dateMake = data[3];
    		invoiceNo = data[4];
    		customer =data[5];
    		if(data[6] == 'F'){
    			payType = 'เต็มจำนวน';
    		}else if(data[6] == 'P'){
    			payType = 'บางส่วน';
    		}
    		amount = data[7];
    		branchCode = data[8];
    		createBy = data[9];
    		recordStatus = data[10];
    		colBotton = "<button id='btn2' name='btn2' class='btn btn-info' >รายละเอียด</button>";
    		vatAmount = data[12];
    		sumTotal = data[13];
    		
    		tableSelect = $('#selectCancelPaymentTB').DataTable();
    	    var rowNode = tableSelect.row.add([no, receiptNoManual, createDate, dateMake, invoiceNo, customer, payType, amount, branchCode, createBy, recordStatus, colBotton, vatAmount, sumTotal]).draw(true).node();
    	    $(rowNode).find('td').eq(0).addClass('left');
    	    $(rowNode).find('td').eq(1).addClass('left');
    	    
    	

    	};
    	modalConfirm(function(confirm){
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
      		        	if(res){
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
      		     		        	for (var i = 0; i < res.length; i++) {
      		     		        		createRowSelect(res[i], i, "selectCancelPaymentTB");
      		     		            }
      		     		        }
      		     			});
      		     			showTableSelect();
      		     			$("#addressInput").hide();
      		     			$('#submitCancelPM').prop('disabled', true);
      		        	}else{
      		        		$("#error").show();
      		        	    hidePanel()
      		        	    showPanel('1');
      		        	    removeCssLi();
      		        	    addCssLi('1');
      		        	    search();
      		        	}
      		        	$('#userName').val('');
      		        	$('#password').val('');
      		        }
      			});
      			

      	  }else{
      		  
      	  }           	
      });
    	$("#address" ).change(function() {
    		if($('#address').val() != ''){
    			$('#submitCancelPM').prop('disabled', false);
    		}else{
    			$('#submitCancelPM').prop('disabled', true);
    		}
    	}); 
    	
	$( "#problemCancel" ).change(function() {
		var valueSelect =  $('#problemCancel').val();
		if(valueSelect == "02"){
			$("#addressInput").show();
			$('#submitCancelPM').prop('disabled', true);
		}else if(valueSelect == ''){
			$("#addressInput").hide();
			$('#address').val("");
			$('#submitCancelPM').prop('disabled', true);
		}else if(valueSelect == '01'){
			$("#addressInput").hide();
			$('#address').val("");
			$('#submitCancelPM').prop('disabled', false);
		}
		console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+$('#problemCancel').val());
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
                    createRow(res[i], i, "cancelPaymentTB");
                }
        }
	})
};

function clearCriteria(){
	$('#billNumber').val('');
	$('#receiptNumber').val('');
	search();
};

function createRow(data, seq, table) {
	no = data.manualId
	receiptNoManual = data.receiptNoManual;
	createDate = data.createDateStr;
	dateMake = data.createDateStr;
	invoiceNo = data.invoiceNo;
	customer = data.customerName;
	if(data.payType == 'F'){
		payType = 'เต็มจำนวน';
	}else if(data.payType == 'P'){
		payType = 'บางส่วน';
	}
	amount = formatDouble(data.amount,2);
	branchCode = data.branchCode;
	createBy = data.createBy;
	recordStatus = data.recordStatus;
	colBotton = "<button id='btn' name='btn' class='btn btn-info'>รายละเอียด</button>   <button class='btn btn-default' id='btn-confirm' name='btn-confirm'>เลือก</button>";
	vatAmount = formatDouble(data.vatAmount,2);
	sumTotal =  data.amount + data.vatAmount;
	
	tableInit = $('#'+table).DataTable();
    var rowNode = tableInit.row.add([no, receiptNoManual, createDate, dateMake, invoiceNo, customer, payType, amount, branchCode, createBy, recordStatus, colBotton, vatAmount, sumTotal]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('left');
    $(rowNode).find('td').eq(1).addClass('left');

};

function createRowSelect(data, seq, table) {
	no = data.manualId
	receiptNoManual = data.receiptNoManual;
	createDate = data.createDateStr;
	dateMake = data.createDateStr;
	invoiceNo = data.invoiceNo;
	customer = data.customerName;
	if(data.payType == 'F'){
		payType = 'เต็มจำนวน';
	}else if(data.payType == 'P'){
		payType = 'บางส่วน';
	}
	amount = formatDouble(data.amount,2);
	branchCode = data.branchCode;
	createBy = data.createBy;
	recordStatus = data.recordStatus;
	vatAmount = formatDouble(data.vatAmount,2);
	sumTotal =  data.amount + data.vatAmount;
	tableSelect = $('#'+table).DataTable();
    var rowNode = tableSelect.row.add([no, receiptNoManual, createDate, dateMake, invoiceNo, customer, payType, amount, branchCode, createBy, recordStatus, vatAmount, sumTotal]).draw(true).node();
    $(rowNode).find('td').eq(0).addClass('left');
    $(rowNode).find('td').eq(1).addClass('left');

};



function format(d) {
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
			        '<th style="text-align: left;">'+'invoiceNo :'+d[4]+'</th>'+
			        '<th style="text-align: right;">'+d[7]+'</th>'+
			        '<th style="text-align: right;">'+"-"+'</th>'+
			        '<th style="text-align: right;">'+d[12]+'</th>'+
			        '<th style="text-align: right;">'+d[13]+'</th>'+
			    '</tr>'+
			'</tbody>'
		'</table>';
};

function submitCancelPayment(){
	var dataSet = {
			"manualId" : idRow,
			"statusCancelPayment":$('#problemCancel').val(),
			"addressNewCancelPayment": $('#address').val()
	};
	$.ajax({
	        type: "POST",
	        url: "/cancelPayment/updateStatus",
	        data: JSON.stringify(dataSet),
	        dataType: "json",
	        async: false,
	        contentType: "application/json; charset=utf-8",
	        success: function (res) {
	        	if(res){
	        		$("#success").show();
	        	    hidePanel()
	        	    showPanel('1');
	        	    removeCssLi();
	        	    addCssLi('1');
	        		search();
	        	}else{
	        		$("#error").show();
	        	}
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






