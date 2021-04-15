$(document).ready(function() {

	scoreList = $('#scoreList').DataTable({
		"filter": false,
		"info": false,
		"paging": true,
		"columnDefs": [{
			"searchable": false,
			"orderable": false,
			"targets": 0
		}]
	});
	
	getGroups()
	getQuestion()
	
	searchAll()

});

function getGroups() {
	$('#groups').empty();
	$.ajax({
		type: "GET",
		url: ctx + "/findQuestionTypeByGroup",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			console.log(res)
			$('#groups').append('<option value="">' + PLS_SELECT + '</option>');
			for (var i = 0; i < res.length; i++) {
				$('#groups').append('<option value="' + (res[i].value) + '">' + (res[i].text) + '</option>');
			}
		}
	})
}

function getQuestion() {
	$('#questions').empty();
	$.ajax({
		type: "GET",
		url: ctx + "/getQuestion",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			console.log(res)
			$('#questions').append('<option value="">' + PLS_SELECT + '</option>');
			for (var i = 0; i < res.length; i++) {
				$('#questions').append('<option value="' + (res[i].value) + '">' + (res[i].text) + '</option>');
			}
		}
	})
}

function getQuestionByGroup() {
	let group = $('#questions').val()
	$('#questions2').empty();
	$.ajax({
		type: "GET",
		url: ctx + "/masterData/findByGroupKey/"+group,
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			console.log(res)
			$('#questions2').append('<option value="">' + PLS_SELECT + '</option>');
			for (var i = 0; i < res.length; i++) {
				$('#questions2').append('<option value="' + (res[i].value) + '">' + (res[i].text) + '</option>');
			}
		}
	})
}

var mode = true
var questionData
var questionList
var questionDataList
var idEdit
var type

function search() {
	let inum2 = 1
	$.ajax({
		type: "GET",
		url: ctx + "/findAllMasterData",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			if(res.length>0)masterList.clear().draw();
			
			getQuestion()
			for (var i = 0; i < res.length; i++) {
				if(res[i].type=='QuestionType') {
					createRow(res[i], inum2);
					inum2++
				}
			}
		}
	})
}

function searchAll() {
	$.ajax({
		type: "GET",
		url: ctx + "/score/findAll",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			questionList = res
			if(res.length>0)scoreList.clear().draw();
			for (var i = 0; i < res.length; i++) {
				createRow(res[i], (i+1));
			}
		}
	})
}

function createRow(data, seq) {
	colSeq = (seq);
	colCur2 = data.groupName;
	colCur3 = data.questionGroupName;
	colCur4 = data.questionCodeName;
	colCur5 = data.score5;
	colCur6 = data.score4;
	colCur7 = data.score3;
	colCur8 = data.score2;
	colCur9 = data.score1;
	colCur10 = '<button type="button" class="btn btn-warning" onclick="editData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">แก้ไข</buttona>';
	colCur11 = '<button type="button" class="btn btn-danger" onclick="deleteData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">ลบ</buttona>';

	var t = $('#scoreList').DataTable();
	var rowNode = t.row.add([colSeq, colCur2, colCur3, colCur4, colCur5, colCur6, colCur7, colCur8, colCur9, colCur10, colCur11]).draw(true).node();
	$(rowNode).find('td').eq(0).addClass('center');
	$(rowNode).find('td').eq(1).addClass('center');
	$(rowNode).find('td').eq(2).addClass('center');
	$(rowNode).find('td').eq(3).addClass('center');
	$(rowNode).find('td').eq(4).addClass('center');
	$(rowNode).find('td').eq(5).addClass('center');
	$(rowNode).find('td').eq(6).addClass('center');
	$(rowNode).find('td').eq(7).addClass('center');
	$(rowNode).find('td').eq(8).addClass('center');
	$(rowNode).find('td').eq(9).addClass('center');
}

function addScore() {
	console.log("addScore")
	mode = true
	idEdit = 0
	clearScore()
	clearValidate()
	$("#addData").modal('show');
}

function clearScore() {
	$('#groups').val('')
	$('#questions').val('')
	$('#questions2').val('')
	$('#score5').val('')
	$('#score4').val('')
	$('#score3').val('')
	$('#score2').val('')
	$('#score1').val('')
	
	$('#questions2').empty();
	$('#questions2').append('<option value="">' + PLS_SELECT + '</option>');
}

function clearValidate() {
	$("#sgroups").hide();
	$("#squestions").hide();
	$("#squestions2").hide();
	$('#sscore5').hide('')
	$('#sscore4').hide('')
	$('#sscore3').hide('')
	$('#sscore2').hide('')
	$('#sscore1').hide('')
	
	document.getElementById("groups").disabled = false;
	document.getElementById("questions").disabled = false;
	document.getElementById("questions2").disabled = false;
}

function modalConfirmAddScore(callback) {
	if (callback) {
		let scoreData = {
			"id": idEdit,
			"groupCode": $('#groups').val(),
			"questionGroup": $('#questions').val(),
			"questionCode": $('#questions2').val(),
			"score5": $('#score5').val(),
			"score4": $('#score4').val(),
			"score3": $('#score3').val(),
			"score2": $('#score2').val(),
			"score1": $('#score1').val(),
		}

		if (validateData(scoreData)) {
			$.ajax({
				type: "POST",
				url: ctx + "/score/save",
				data: JSON.stringify(scoreData),
				dataType: "json",
				async: false,
				contentType: "application/json; charset=utf-8",
				success: function(res) {
					searchAll()
					$("#addData").modal('hide');
					swal('บันทึก : ' + res.message)
				}
			})

		}
	} else {
		$("#addData").modal('hide');
	}
}

function validateData(data) {
	console.log(data)
	clearValidate()

	let chkValid = true
	if (!data.groupCode) {
		$("#sgroups").show();
		chkValid = false;
	} else if (!data.questionGroup) {
		$("#squestions").show();
		chkValid = false;
	} else if (!data.questionCode) {
		$("#squestions2").show();
		chkValid = false;
	} else if (!data.score5) {
		$("#sscore5").show();
		chkValid = false;
	} else if (!data.score4) {
		$("#sscore4").show();
		chkValid = false;
	} else if (!data.score3) {
		$("#sscore3").show();
		chkValid = false;
	} else if (!data.score2) {
		$("#sscore2").show();
		chkValid = false;
	} else if (!data.score1) {
		$("#sscore1").show();
		chkValid = false;
	}

	return chkValid
}

function editData(id) {
	console.log(id)
	mode = false
	idEdit = id
	clearValidate()
	
	let resObjs = this.questionList.filter(function(Obj) {
		return Obj.id == id;
	});
	
	$.ajax({
		type: "GET",
		url: ctx + "/score/findById/"+resObjs[0].id,
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			setData(res)
			$("#addData").modal('show');
		}
	})
}

function setData(data) {
	$('#groups').val(data.groupCode)
	$('#questions').val(data.questionGroup)
	
	getQuestionByGroup()
	$('#questions2').val(data.questionCode)
	
	//disabled
	document.getElementById("groups").disabled = true;
	document.getElementById("questions").disabled = true;
	document.getElementById("questions2").disabled = true;
	
	$('#score5').val(data.score5)
	$('#score4').val(data.score4)
	$('#score3').val(data.score3)
	$('#score2').val(data.score2)
	$('#score1').val(data.score1)
}

function deleteData(id) {
	console.log(id)
	
	let resObjs = this.questionList.filter(function(Obj) {
		return Obj.id == id;
	});
	
	swal({
		title: "คุณต้องการลบใช่หรือไม่",
		text: "",
		icon: "warning",
		buttons: true,
		successMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					type: "GET",
					url: ctx + "/score/delete/"+resObjs[0].id,
					async: false,
					contentType: "application/json; charset=utf-8",
					success: function(res) {
						console.log(res)
						searchAll()
						swal('ลบข้อมูลสำเร็จ')
					}
				})
			} else {}
		});
}