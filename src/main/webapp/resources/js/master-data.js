$(document).ready(function() {

	//		$('.groupType').select2();

	masterGroupList = $('#masterGroupList').DataTable({
		"filter": false,
		"info": false,
		"paging": true,
		"columnDefs": [{
			"searchable": false,
			"orderable": false,
			"targets": 0
		}]
	});
	searchGroup()

	masterList = $('#masterList').DataTable({
		"filter": false,
		"info": false,
		"paging": true,
		"columnDefs": [{
			"searchable": false,
			"orderable": false,
			"targets": 0
		}]
	});
	search()
	getGroups()

});

function getGroups() {
	$.ajax({
		type: "GET",
		url: ctx + "/getTypeQuestion",
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

var mode = true
var msDataGroup
var msData
var msDataGroupList
var msDataList
var idEdit
var type

function searchGroup() {
	masterGroupList.clear().draw();
	let inum = 1
	$.ajax({
		type: "GET",
		url: ctx + "/findAllMasterData",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			msDataGroupList = res
			for (var i = 0; i < res.length; i++) {
				if(res[i].type=='Group') {
					createRowGroup(res[i], inum);
					inum++
				}
			}
		}
	})
}

function search() {
	masterList.clear().draw();
	let inum2 = 1
	$.ajax({
		type: "GET",
		url: ctx + "/findAllMasterData",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			msDataList = res
			for (var i = 0; i < res.length; i++) {
				if(res[i].type!='Group') {
					createRow(res[i], inum2);
					inum2++
				}
			}
		}
	})
}

function createRowGroup(data, seq) {
	colSeq = (seq);
	colCur2 = data.value;
	colCur3 = data.text;
	colCur4 = '<button type="button" class="btn btn-warning" onclick="editGroupData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">แก้ไข</buttona>';
	colCur5 = '<button type="button" class="btn btn-danger" onclick="deleteGroupData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">ลบ</buttona>';

	var t = $('#masterGroupList').DataTable();
	var rowNode = t.row.add([colSeq, colCur2, colCur3, colCur4, colCur5]).draw(true).node();
	$(rowNode).find('td').eq(0).addClass('center');
	$(rowNode).find('td').eq(1).addClass('center');
	$(rowNode).find('td').eq(2).addClass('center');
}

function setGroup(data) {
	$('#groupName').val(data.text)
	$('#groupCode').val(data.value)
//	type = data.type
}

function editGroupData(id) {
	console.log(id)
	mode = false
	idEdit = id
	clearValidate()
	
	let resObjs = this.msDataGroupList.filter(function(Obj) {
		return Obj.id == id;
	});
	
	dataSend = {
		"group": resObjs[0].value,
	}

	$.ajax({
		type: "POST",
		url: ctx + "/findGroupTypeByKeyCode",
		data: JSON.stringify(dataSend),
		dataType: "json",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			setGroup(res)
			$("#addDataGroup").modal('show');
		}
	})
}

function deleteGroupData(id) {
	console.log(id)
	
	let resObjs = this.msDataGroupList.filter(function(Obj) {
		return Obj.id == id;
	});
	
	dataSend = {
		"id": resObjs[0].id,
	}

	swal({
		title: "คุณต้องการลบ " + resObjs[0].text,
		text: "",
		icon: "warning",
		buttons: true,
		successMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					type: "POST",
					url: ctx + "/masterData/delete",
					data: JSON.stringify(dataSend),
					dataType: "json",
					async: false,
					contentType: "application/json; charset=utf-8",
					success: function(res) {
						searchGroup()
						swal('ลบข้อมูลสำเร็จ')
					}
				})
			} else {}
		});
}

function createRow(data, seq) {
	colSeq = (seq);
	colCur2 = data.group;
	colCur3 = data.value;
	colCur4 = data.text;
	colCur5 = data.score;
	colCur6 = '<button type="button" class="btn btn-warning" onclick="editData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">แก้ไข</buttona>';
	colCur7 = '<button type="button" class="btn btn-danger" onclick="deleteData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">ลบ</buttona>';

	var t = $('#masterList').DataTable();
	var rowNode = t.row.add([colSeq, colCur2, colCur3, colCur4, colCur5, colCur6, colCur7]).draw(true).node();
	$(rowNode).find('td').eq(0).addClass('center');
	$(rowNode).find('td').eq(1).addClass('center');
	$(rowNode).find('td').eq(2).addClass('center');
	$(rowNode).find('td').eq(3).addClass('center');
	$(rowNode).find('td').eq(4).addClass('center');
}

function addGroup() {
	console.log("addGroup")
	mode = true
	idEdit = 0
	clearUser()
	clearValidate()
	$("#addDataGroup").modal('show');
}

function modalConfirmAddGroup(callback) {
	if (callback) {
		msDataGroup = {
			"id": idEdit,
			"value": $('#groupName').val(),
			"keyCode": $('#groupCode').val(),
			"type": 'Group',
		}

		if (validate()) {
			$.ajax({
				type: "POST",
				url: ctx + "/saveMasterdata",
				data: JSON.stringify(this.msDataGroup),
				dataType: "json",
				async: false,
				contentType: "application/json; charset=utf-8",
				success: function(res) {
					searchGroup()
					$("#addDataGroup").modal('hide');
					swal('บันทึก : ' + res.message)
				}
			})

		}
	} else {
		$("#addDataGroup").modal('hide');
	}
}

function clearUser() {
	$('#groupName').val('')
	$('#groupCode').val('')
}

function clearValidate() {
	$("#sgroupName").hide();
	$("#sgroupCode").hide();
}

function validate() {
	console.log(this.msDataGroup)
	clearValidate()

	let chkValid = true
	if (!this.msDataGroup.value) {
		$("#sgroupName").show();
		chkValid = false;
	} else if (!this.msDataGroup.keyCode) {
		$("#sgroupCode").show();
		chkValid = false;
	}

	return chkValid
}

function addData() {
	console.log("function addData")
	mode = true
	idEdit = 0
	clearData()
	clearMsValidate()
	$("#addData").modal('show');
}

function modalConfirmAdd(callback) {
	if (callback) {
		msData = {
			"id": idEdit,
			"group": $('#groups').val(),
			"keyCode": $('#msCode').val(),
			"value": $('#msName').val(),
			"score": $('#msScore').val(),
			"type": "",
		}

		if (validateData()) {
			$.ajax({
				type: "POST",
				url: ctx + "/saveMasterdata",
				data: JSON.stringify(this.msData),
				dataType: "json",
				async: false,
				contentType: "application/json; charset=utf-8",
				success: function(res) {
					search()
					$("#addData").modal('hide');
					swal('บันทึก : ' + res.message)
				}
			})

		}
	} else {
		$("#addData").modal('hide');
	}
}

function clearData() {
	$('#groups').val('')
	$('#msCode').val('')
	$('#msName').val('')
	$('#msScore').val('')
}

function clearMsValidate() {
	$("#sgroups").hide();
	$("#smsCode").hide();
	$("#smsName").hide();
	$("#smsScore").hide();
}

function validateData() {
	console.log(this.msData)
	clearMsValidate()

	let chkValid = true
	if (!this.msData.group) {
		$("#sgroups").show();
		chkValid = false;
	} else if (!this.msData.keyCode) {
		$("#smsCode").show();
		chkValid = false;
	} else if (!this.msData.value) {
		$("#smsName").show();
		chkValid = false;
	} else if (!this.msData.score) {
		$("#smsScore").show();
		chkValid = false;
	}

	return chkValid
}

function setData(data) {
	$('#groups').val(data.group)
	$('#msCode').val(data.value)
	$('#msName').val(data.text)
	$('#msScore').val(data.score)
//	type = data.type
}

function editData(id) {
	console.log(id)
	mode = false
	idEdit = id
	clearMsValidate()
	
	let resObjs = this.msDataList.filter(function(Obj) {
		return Obj.id == id;
	});
	
	dataSend = {
		"group": resObjs[0].value,
	}

	$.ajax({
		type: "POST",
		url: ctx + "/findGroupTypeByKeyCode",
		data: JSON.stringify(dataSend),
		dataType: "json",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			setData(res)
			$("#addData").modal('show');
		}
	})
}

function deleteData(id) {
	console.log(id)
	
	let resObjs = this.msDataList.filter(function(Obj) {
		return Obj.id == id;
	});
	
	dataSend = {
		"id": resObjs[0].id,
	}

	swal({
		title: "คุณต้องการลบ " + resObjs[0].text,
		text: "",
		icon: "warning",
		buttons: true,
		successMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					type: "POST",
					url: ctx + "/masterData/delete",
					data: JSON.stringify(dataSend),
					dataType: "json",
					async: false,
					contentType: "application/json; charset=utf-8",
					success: function(res) {
						search()
						swal('ลบข้อมูลสำเร็จ')
					}
				})
			} else {}
		});
}