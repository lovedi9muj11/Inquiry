var tableInit;
var tableSelect;
var dataSelect;
$(document).ready(function () {
    console.log("ready!");
    $("#error").hide();
	cancelPaymentTB = $('#cancelPaymentTB').DataTable({
		"filter" : false,
		"info" : false,
		"columnDefs": [ {
			"searchable": false,
			"orderable": false,
//			"targets": [1,12]
		} ]
	});
    hidePanel()
    showPanel('1');
    removeCssLi();
    addCssLi('1');
    search();
    
    $('#cancelPaymentTB tbody').on( 'click', '#btn-confirm', function () {
    	 $("#mi-modal").modal('show');
    	 dataSelect = tableInit.row( $(this).parents('tr') ).data();
        
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

    	modalConfirm(function(confirm){
    	  if(confirm){
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
    		        	if(!res){
    		        		createRowSelectCCPayment(dataSelect);
    		        	}else{
    		        		$("#error").show();
    		        	}
    		        	$('#userName').val('');
    		        	$('#password').val('');
    		        }
    			});
    	  }else{
    	    //Acciones si el usuario no confirma
    		  
    	  }
    	});
    	
   function createRowSelectCCPayment(data) {
    		cancelPaymentTB = $('#selectCancelPaymentTB').DataTable({
    			"filter" : false,
    			"info" : false,
    			"columnDefs": [ {
    				"searchable": false,
    				"orderable": false,
//    				"targets": [1,12]
    			} ]
    		});
    		
    		console.log(data);
    		no = data[0];
    		receiptNoManual = data[1];
    		createDate = data[2];
    		dateMake = data[3];
    		invoiceNo = data[4];
    		customer =data[5];
    		payType = data[6];
    		amount = data[7];
    		branchCode = data[8];
    		createBy = data[9];
    		recordStatus = data[10];
    		colBotton = "<button id='btn2' name='btn2' class='btn btn-info'>รายละเอียด</button>";
    		vatAmount = data[12];
    		sumTotal = data[13];
    		
    		tableSelect = $('#selectCancelPaymentTB').DataTable();
    	    var rowNode = tableSelect.row.add([no, receiptNoManual, createDate, dateMake, invoiceNo, customer, payType, amount, branchCode, createBy, recordStatus, colBotton, vatAmount, sumTotal]).draw(true).node();
    	    $(rowNode).find('td').eq(0).addClass('left');
    	    $(rowNode).find('td').eq(1).addClass('left');
    	    
    	    hidePanel();
    	    showPanel("3");
    	    removeCssLi();
    	    addCssLi('3');

    	};
    
});
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
	var dataSend = { "receiptNoManual": $('#receiptNo').val(), "invoiceNo": $('#invoiceNo').val() };
	$.ajax({
        type: "POST",
        url: "/cancelPayment/find",
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

function createRow(data, seq, table) {
	no = seq + 1
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
	colBotton = "<button id='btn' name='btn' class='btn btn-info'>รายละเอียด</button>   <button class='btn btn-default' id='btn-confirm' name='btn-confirm'>เลือก</button>";
	vatAmount = formatDouble(data.vatAmount,2);
	sumTotal =  data.amount + data.vatAmount;
	
	tableInit = $('#cancelPaymentTB').DataTable();
    var rowNode = tableInit.row.add([no, receiptNoManual, createDate, dateMake, invoiceNo, customer, payType, amount, branchCode, createBy, recordStatus, colBotton, vatAmount, sumTotal]).draw(true).node();
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
			        '<th style="text-align: right;">'+d[0]+'</th>'+
			        '<th style="text-align: right;">'+d[12]+'</th>'+
			        '<th style="text-align: right;">'+d[13]+'</th>'+
			    '</tr>'+
			'</tbody>'
		'</table>';
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





