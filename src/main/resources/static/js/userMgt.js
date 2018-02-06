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
        	console.log(res)
        	for (var i = 0; i < res.length; i++) {
                    createRow(res[i], i);
                }
//        	var setData = $('#uList');
//        	for(var i=0; i<res.length; i++) {
//        		data = "<tr class='row_" + res[i].id + "'>" +
//        		"<td>" + res[i].id + "</td>" +
//        		"<td>" + res[i].userName + "</td>" +
//        		"<td>" + "" + "</td>" +
//        		"<td>" + "" + "</td>" +
//        		"</tr>";
//        		setData.append(data);
//        	}
        }
	})
}

function createRow(data, seq) {
    colSeq = (seq + 1);
    colCurId = data.id;
    colCurName = data.userName;
    colBotton = "<a \href=\"InfoCurriculum?curriculumBean.id=" + data.id + "\"><i class=\"fa fa-fw fa-search \icon-30\"></a></i> ";
    colBotton += " <a \href=\"EditCurriculum?curriculumBean.id=" + data.id + "\"><i class=\"fa fa-pencil-square-o \icon-30\"></a></i> ";
    colBotton += " <a \onClick=\"deleteData("+data.id+")\" ><i class=\"fa fa-trash-o \icon-30\"></a></i>";

    var t = $('#userList').DataTable();
    var rowNode = t.row.add([
        colSeq, colCurId, colCurName,colBotton
    ]).draw(false).node();
}	