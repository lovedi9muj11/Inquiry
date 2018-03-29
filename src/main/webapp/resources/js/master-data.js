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