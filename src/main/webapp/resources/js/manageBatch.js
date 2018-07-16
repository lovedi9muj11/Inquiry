$(document).ready(function() {
	
	$('.groupType').select2({
//	    width: '30%'
	});
	
	$.ajax({
		    type: 'GET',
		    url: "/masterData/masterDataBatch"
		}).then(function (data) {
			for(var i=0; i<data.length; i++) {
				var element = data[i];
				$('#groupType').append('<option value="' + element.value+ '">' + element.name + '</option>');
			}
		});
	
	$('#month').append('<option value="'+'">' + PLS_SELECT + '</option>');
	
	$('#date').append('<option value="'+'">' + PLS_SELECT + '</option>');
	
	$('#hour').append('<option value="'+'">' + PLS_SELECT + '</option>');
	
	$('#minute').append('<option value="'+'">' + PLS_SELECT + '</option>');
	
	$('#groupType').change(function () {
		$('#month').empty();
		setMonth();
		$('#date').empty();
		setDate();
		$('#hour').empty();
		setHour();
		$('#minute').empty();
		setMinute();
	});
	
});

function setMonth() {
	$('#month').append('<option value="'+'">' + PLS_SELECT_ALL_MONTH + '</option>');
	for(var i=0; i<12; i++) {
		$('#month').append('<option value="'+(i+1)+'">' + (i+1) + '</option>');
	}
}

function setDate() {
	$('#date').append('<option value="'+'">' + PLS_SELECT_ALL_DAY + '</option>');
	for(var i=0; i<31; i++) {
		$('#date').append('<option value="'+(i+1)+'">' + (i+1) + '</option>');
	}
}

function setHour() {
	$('#hour').append('<option value="'+'">' + PLS_SELECT_ALL_HOUR + '</option>');
	for(var i=0; i<24; i++) {
		$('#hour').append('<option value="'+(i+1)+'">' + (i+1) + '</option>');
	}
}

function setMinute() {
	$('#minute').append('<option value="'+'">' + PLS_SELECT_ALL_MINUTE + '</option>');
	for(var i=0; i<60; i++) {
		$('#minute').append('<option value="'+(i+1)+'">' + (i+1) + '</option>');
	}
}