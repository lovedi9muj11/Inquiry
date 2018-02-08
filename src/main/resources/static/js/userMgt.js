function search() {
	var data = '';
	var dataSend = {
					"username": $('#name').val()
					};
	$.ajax({
        type: "POST",
        url: "/userManageMent/search",
        data: JSON.stringify(dataSend),
        dataType: "json",
        async: false,
        contentType: "application/json; charset=utf-8",
        success: function (res) {
        	$('#userList').DataTable({
        		"filter" : false,
        		"info" : false,
        		"columnDefs": [ {
        			"searchable": false,
        			"orderable": false,
        			"targets": [1,3]
        		} ]
        		});
        	$('#userList').DataTable().clear().draw();
        	for (var i = 0; i < res.length; i++) {
                    createRow(res[i], i);
                }
        }
	})
}

function createRow(data, seq) {
    colSeq = (seq + 1);
    colCurId = data.userName;
    colCurName = data.roleCode;
    colBotton = "<a \onClick=\"viewData(" + data.id + ")\"><i class=\"fa fa-eye \icon-30\"></a></i> ";
    colBotton += " <a \onClick=\"updateData(" + data.id + ")\"><i class=\"fa fa-wrench \icon-30\"></a></i> ";
    colBotton += " <a \onClick=\"deleteData("+data.id+")\" ><i class=\"fa fa-trash-o \icon-30\"></a></i>";

    var t = $('#userList').DataTable();
    var rowNode = t.row.add([
        colSeq, colCurId, colCurName,colBotton
    ]).draw(true).node();
}

function viewData(id) {
	alert(id);
}

function updateData(id) {
	alert(id);
}

function deleteData(id) {
	alert(id);
}