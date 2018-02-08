$(document).ready(function () {
    console.log("ready!");
    $("#panel1").hide();
    $("#panel2").hide();
    $("#panel3").hide();
    $("#panel4").hide();
    showPanel('1');
    addCssLi('1');

    var table = $('#example').DataTable( {
    	 "searching": false,
    	'ajax': {
            "url": "https://api.myjson.com/bins/7mhjl",
        },  
        "columns": [
        	{ "data": "id", "width": '2%', "className": "dt-center"},
            { "data": "recNumber", 'width': '15%' , "className": "dt-left"},
            { "data": "billDate"  , 'width': '8%' , "className": "dt-center"},
            { "data": "recDate"  , 'width': '8%' , "className": "dt-center"},
            { "data": "traDate"  , 'width': '5%', "className": "dt-center"},
            { "data": "customer" , 'width': '10%', "className": "dt-left"},
            { "data": "typePayment"  , 'width': '10%', "className": "dt-center"},
            { "data": "payAmount"  , 'width': '10%', "className": "dt-center"},
            { "data": "payPlace"  , 'width': '10%', "className": "dt-center"},
            { "data": "payPayee"  , 'width': '10%', "className": "dt-center"},
            { "data": "payStatus"  , 'width': '10%', "className": "dt-center"},
            {
                "data": null,
                "className": "center",
                "defaultContent": '<button id="btn" name="btn" class="btn btn-info">รายละเอียด</button> <button id="select" name="btn" class="btn btn-success">เลือกรายกายยกเลิก</button>',
                 'width': '100px'
            },
        ],'order': [2, 'asc']
    } );
    
 
    $('#btn').click(function () {
        console.log($('input[name="rxsss"]:checked').val());
        var data = [];
        data.push($('input[name="rxsss"]:checked').val());
        alert($('input[name="rxsss"]:checked').val());
        console.log(data);
    });
    
    $('#example tbody').on('click', '#btn', function () {
        var tr = $(this).closest('tr');
        var row = table.row(tr);

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
    $('#example tbody').on( 'click', '#select', function () {
        var data = table.row( $(this).parents('tr') ).data();
        alert( data.id );
    } );
    
    $('#clear').click(function(){
    	$("#billNumber").val('');
    	$("#receiptNumber").val('');
    });

});




function format(d) {
    return '<table class="table table-bordered" cellspacing="0" width="100%">'+
			    '<thead>'+
			    '<tr>'+
			        '<th style="text-align: left;">รายการ</th>'+
			        '<th style="text-align: right;">จำนวน</th>'+
			        '<th style="text-align: right;">ภาษีมูลค่าเพิ่ม</th>'+
			        '<th style="text-align: right;">ส่วนลด</th>'+
			        '<th style="text-align: right;">จำนวนเงิน</th>'+
			    '</tr>'+
			'</thead>'+
			'<tbody>'+
			    '<tr>'+
			        '<th style="text-align: left;">'+'invoiceNo :'+d.invoiceNo+'</th>'+
			        '<th style="text-align: right;">'+d.amount+'</th>'+
			        '<th style="text-align: right;">'+d.tax+'</th>'+
			        '<th style="text-align: right;">'+d.discount+'</th>'+
			        '<th style="text-align: right;">'+d.allAmount+'</th>'+
			    '</tr>'+
			'</tbody>'
		'</table>';
		}

function addCssLi(select) {
    $("#li" + select).css("color", "red")
};

function showPanel(select) {
    $("#panel" + select).show();
};