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
        	var setData = $('#uList');
        	for(var i=0; i<res.length; i++) {
        		data = "<tr class='row_" + res[i].id + "'>" +
        		"<td>" + res[i].id + "</td>" +
        		"<td>" + res[i].userName + "</td>" +
        		"<td>" + "" + "</td>" +
        		"<td>" + "" + "</td>" +
        		"</tr>";
        		setData.append(data);
        	}
        }
	})
}