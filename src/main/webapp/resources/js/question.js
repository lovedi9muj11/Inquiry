$(document).ready(function() {

	$('#groupType').append('<option value="">' + PLS_SELECT + '</option>');
	$('#groupType').append('<option value="1">' + 'ทดสอบ' + '</option>');
	$('#groupType').append('<option value="2">' + 'ทดสอบ2' + '</option>');
	
//	$( "input[type=radio]" ).on( "click", countChecked );
});

function getType() {
	$.ajax({
		type: "GET",
		url: ctx + "/xxx/getType",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			for (var i = 0; i < res.roleList.length; i++) {
				$('#groupType').append('<option value="' + (res.roleList[i].key) + '">' + (res.roleList[i].value) + '</option>');
			}
		}
	})
}

function save() {
	if(validateSave()) {
		setDataSave()
	}else {
		swal({
			text: "กรุณาตอบแบบสอบถามให้ครบ",
			icon: "warning",
			buttons: "ตกลง",
		})
	}
}

function cancel() {

}

function countChecked() {
	var n = $( "input:checked" ).length;
  	console.log('length : ', n)
}

function validateSave() {
	let point = $( "input:checked" ).length;
	
	return point==26
}

function setDataSave() {
	let q1 = document.querySelector('input[name="q1"]:checked').value;
	let q2 = document.querySelector('input[name="q2"]:checked').value;
	let q3 = document.querySelector('input[name="q3"]:checked').value;
	let q4 = document.querySelector('input[name="q4"]:checked').value;
	let q5 = document.querySelector('input[name="q5"]:checked').value;
	let q6 = document.querySelector('input[name="q6"]:checked').value;
	let q7 = document.querySelector('input[name="q7"]:checked').value;
	let q8 = document.querySelector('input[name="q8"]:checked').value;
	
	let q9 = document.querySelector('input[name="q9"]:checked').value;
	let q10 = document.querySelector('input[name="q10"]:checked').value;
	let q11 = document.querySelector('input[name="q11"]:checked').value;
	let q12 = document.querySelector('input[name="q12"]:checked').value;
	let q13 = document.querySelector('input[name="q13"]:checked').value;
	
	let q14 = document.querySelector('input[name="q14"]:checked').value;
	let q15 = document.querySelector('input[name="q15"]:checked').value;
	let q16 = document.querySelector('input[name="q16"]:checked').value;
	let q17 = document.querySelector('input[name="q17"]:checked').value;
	
	let q18 = document.querySelector('input[name="q18"]:checked').value;
	let q19 = document.querySelector('input[name="q19"]:checked').value;
	let q20 = document.querySelector('input[name="q20"]:checked').value;
	let q21 = document.querySelector('input[name="q21"]:checked').value;
	
	let q22 = document.querySelector('input[name="q22"]:checked').value;
	let q23 = document.querySelector('input[name="q23"]:checked').value;
	let q24 = document.querySelector('input[name="q24"]:checked').value;
	let q25 = document.querySelector('input[name="q25"]:checked').value;
	let q26 = document.querySelector('input[name="q26"]:checked').value;
}