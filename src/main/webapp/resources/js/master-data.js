$(document).ready(function() {
	
	$('.groupType').select2();
	
	$.ajax({
	    type: 'GET',
	    url: "/masterData/selectAll"
	}).then(function (data) {
		for(var i=0; i<data.length; i++) {
			var element = data[i];
			$('#groupType').append('<option value="' + element.value+ '">' + element.name + '</option>');
		}
	});
	
});

function searchClick() {
	alert("123");
}

function addClick() {
	alert("xxx");
}

function submitMaterdata() {
	
	var dataSend = {
			"value" : $("#value").val(),
			"text" : $("#text").val(),
			"group" : $("#groupType").val()
		}

		$.ajax({
			type : "POST",
			url : "insertMasterdata",
			data : JSON.stringify(dataSend),
			dataType : "json",
			async : false,
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				window.location.href = "masterData";
			}
		})
	
	
	
}

function submitMaterdataGroup() {
	
	var dataSend = {
			"mastergroup" : $("#mastergroup").val()
		}

		$.ajax({
			type : "POST",
			url : "insertMasterdataGroup",
			data : JSON.stringify(dataSend),
			dataType : "json",
			async : false,
			contentType : "application/json; charset=utf-8",
			success : function(res) {
				window.location.href = "masterData";
			}
		})
	
	
	
}