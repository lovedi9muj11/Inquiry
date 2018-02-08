$(document).ready(function () {
    $('#histroryPaymentTB').DataTable( {
   	 "searching": false,
   	'ajax': {
           "url": "https://api.myjson.com/bins/16f2wp",
       },  
       "columns": [
       	   { "data": "1", "width": '2%', "className": "dt-center"},
           { "data": "2", 'width': '15%' , "className": "dt-left"},
           { "data": "3"  , 'width': '8%' , "className": "dt-center"},
           { "data": "4"  , 'width': '8%' , "className": "dt-center"},
           { "data": "5"  , 'width': '5%', "className": "dt-center"},
           { "data": "6" , 'width': '10%', "className": "dt-left"},
           { "data": "7"  , 'width': '10%', "className": "dt-center"},
           { "data": "8"  , 'width': '10%', "className": "dt-center"},
           { "data": "9"  , 'width': '10%', "className": "dt-center"},
           { "data": "10"  , 'width': '10%', "className": "dt-center"},
           { "data": "11"  , 'width': '10%', "className": "dt-center"},
           { "data": "12"  , 'width': '10%', "className": "dt-center"},
           { "data": "13"  , 'width': '10%', "className": "dt-center"},
           { "data": "14"  , 'width': '10%', "className": "dt-center"},
           { "data": "15"  , 'width': '10%', "className": "dt-center"}
       ],'order': [1, 'asc']
   } );
});