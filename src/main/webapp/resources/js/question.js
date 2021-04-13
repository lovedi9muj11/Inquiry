$(document).ready(function() {

	//	$('#groupType').append('<option value="">' + PLS_SELECT + '</option>');
	//	$('#groupType').append('<option value="1">' + 'ทดสอบ' + '</option>');
	//	$('#groupType').append('<option value="2">' + 'ทดสอบ2' + '</option>');
	getType()

	//	$( "input[type=radio]" ).on( "click", countChecked );

	//	search()
	$("#groupType").on("change", function() {
		search()
	});

	questionList = $('#questionList').DataTable({
		"filter": false,
		"info": false,
		"paging": false,
		"columnDefs": [{
			"searchable": false,
			"orderable": false,
			"targets": 0
		}]
	});
	searchQuestion()
});

var questData
var questDataResList = []
var questDataList = []
var isNum = 0
var isNumGroup = 0

function getType() {
	$.ajax({
		type: "GET",
		//		url: ctx + "/findAllMasterData",
		url: ctx + "/findQuestionTypeByGroup",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			msDataList = res
			for (var i = 0; i < res.length; i++) {
				if (res[i].type != 'Group') {
					$('#groupType').append('<option value="' + (res[i].value) + '">' + (res[i].text) + '</option>');
				}
			}
		}
	})
}

function save() {
	if (validateSave()) {
		setDataSave()

		let type = $('#groupType').val();
		this.questData = {
			"type": type,
			"questList": this.questDataList,
		}
		console.log(this.questData)
		$.ajax({
			type: "POST",
			url: ctx + "/question/save",
			data: JSON.stringify(this.questData),
			dataType: "json",
			async: false,
			contentType: "application/json; charset=utf-8",
			success: function(res) {
				search()
				swal({
					text: "บันทึกสำเร็จ",
					icon: "success",
					buttons: "ตกลง",
				})
			}
		})
	} else {
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
	var n = $("input:checked").length;
	console.log('length : ', n)
}

function validateSave() {
	let point = $("input:checked").length;

	console.log(isNumGroup)
	console.log(point)

	return point == isNumGroup
}

function setDataQuestion(list) {

	//	$("#q15").prop("checked", true);
	let nameQuestion = "";

	for (let i = 0; i < list.length; i++) {
		nameQuestion = "input[name=q" + (i + 1) + "]";

		$(nameQuestion).val([list[i].score]);
	}

}

function setDataQuestionEmpty() {

	let nameQuestion = "";

	for (let i = 0; i < isNumGroup; i++) {
		nameQuestion = "input[name=q" + (i + 1) + "]";

		$(nameQuestion).val(['']);
	}

}

function setDataSave() {
	//	let q1 = document.querySelector('input[name="q1"]:checked').value;
	//	let q2 = document.querySelector('input[name="q2"]:checked').value;
	//	let q3 = document.querySelector('input[name="q3"]:checked').value;
	//	let q4 = document.querySelector('input[name="q4"]:checked').value;
	//	let q5 = document.querySelector('input[name="q5"]:checked').value;
	//	let q6 = document.querySelector('input[name="q6"]:checked').value;
	//	let q7 = document.querySelector('input[name="q7"]:checked').value;
	//	let q8 = document.querySelector('input[name="q8"]:checked').value;
	//
	//	let q9 = document.querySelector('input[name="q9"]:checked').value;
	//	let q10 = document.querySelector('input[name="q10"]:checked').value;
	//	let q11 = document.querySelector('input[name="q11"]:checked').value;
	//	let q12 = document.querySelector('input[name="q12"]:checked').value;
	//	let q13 = document.querySelector('input[name="q13"]:checked').value;
	//
	//	let q14 = document.querySelector('input[name="q14"]:checked').value;
	//	let q15 = document.querySelector('input[name="q15"]:checked').value;
	//	let q16 = document.querySelector('input[name="q16"]:checked').value;
	//	let q17 = document.querySelector('input[name="q17"]:checked').value;
	//
	//	let q18 = document.querySelector('input[name="q18"]:checked').value;
	//	let q19 = document.querySelector('input[name="q19"]:checked').value;
	//	let q20 = document.querySelector('input[name="q20"]:checked').value;
	//	let q21 = document.querySelector('input[name="q21"]:checked').value;
	//
	//	let q22 = document.querySelector('input[name="q22"]:checked').value;
	//	let q23 = document.querySelector('input[name="q23"]:checked').value;
	//	let q24 = document.querySelector('input[name="q24"]:checked').value;
	//	let q25 = document.querySelector('input[name="q25"]:checked').value;
	//	let q26 = document.querySelector('input[name="q26"]:checked').value;

	questDataList = []
	let type = $('#groupType').val();

	if (questDataResList.length > 0 && type == questDataResList[0].type) {
		for (let i = 0; i < questDataResList.length; i++) {
			let question = {}
			let qtion = 'input[name="q' + (i + 1) + '"]:checked';

			question = {
				"id": questDataResList[i].id,
				"seqNo": (i + 1),
				"score": document.querySelector(qtion).value
			}
			questDataList.push(question)
		}
	} else {
		for (let i = 0; i < isNumGroup; i++) {
			let question = {}
			let qtion = 'input[name="q' + (i + 1) + '"]:checked';

			question = {
				"id": "",
				"seqNo": (i + 1),
				"score": document.querySelector(qtion).value
			}
			questDataList.push(question)
		}
	}

}

function search() {
	let type = $('#groupType').val();
	$.ajax({
		type: "GET",
		url: ctx + "/question/findByType/" + type,
		//		data: JSON.stringify(dataSend),
		//		dataType: "json",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			console.log(res)

			if (res.length > 0) {
				questDataResList = res
				setDataQuestion(res)
			} else {
				setDataQuestionEmpty()
			}
		}
	})
}

function searchQuestion() {
	questionList.clear().draw();

	$.ajax({
		type: "GET",
		url: ctx + "/findAllQuestion",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			console.log(res)
			for (var i = 0; i < res.length; i++) {
				createRow(res[i]);
			}
			search()
		}
	})
}

function createRow(data) {
	colCur = data.text;
	isNum++

	var t = $('#questionList').DataTable();
	var rowNode = t.row.add([isNum, colCur, '', '', '', '', '']).draw(true).node();
	$(rowNode).find('td').eq(0).addClass('center').css('color', 'blue');
	$(rowNode).find('td').eq(1).attr('colspan', 7).addClass('left').css('color', 'blue');

	for (let i = 0; i < data.list.length; i++) {
		createRowSub(data.list[i], isNum + '.' + (i + 1))
		isNumGroup++

	}
}

function createRowSub(data, seq) {
	colSeq = (seq);
	colCur2 = data.text;

	colCurIs5 = '<input type="radio" name="' + data.value + '" id="q' + isNum + '" value="5">';
	colCurIs4 = '<input type="radio" name="' + data.value + '" id="q' + isNum + '" value="4">';
	colCurIs3 = '<input type="radio" name="' + data.value + '" id="q' + isNum + '" value="3">';
	colCurIs2 = '<input type="radio" name="' + data.value + '" id="q' + isNum + '" value="2">';
	colCurIs1 = '<input type="radio" name="' + data.value + '" id="q' + isNum + '" value="1">';

	var t = $('#questionList').DataTable();
	var rowNode = t.row.add([colSeq, colCur2, colCurIs5, colCurIs4, colCurIs3, colCurIs2, colCurIs1]).draw(true).node();
	$(rowNode).find('td').eq(0).addClass('center');
	$(rowNode).find('td').eq(1).addClass('left');
	$(rowNode).find('td').eq(2).addClass('center');
	$(rowNode).find('td').eq(3).addClass('center');
	$(rowNode).find('td').eq(4).addClass('center');
	$(rowNode).find('td').eq(5).addClass('center');
	$(rowNode).find('td').eq(6).addClass('center');
}
