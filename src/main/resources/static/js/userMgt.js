function search() {
	console.log("Come...")
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
        }
	})
}