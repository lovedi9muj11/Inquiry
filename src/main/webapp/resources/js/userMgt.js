var userData;
var userDataList;
var mode = true
var idEdit

$(document).ready(function() {
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
	getRoles()
});

function searchClick() {
	search();
}

function addClick() {
	alert("xxx");
}

let data;
function search() {
	masterList.clear().draw();

	var dataSend = {
		"username": $("#name").val(),
	}

	$.ajax({
		type: "POST",
		url: ctx + "/userManageMent/search",
		data: JSON.stringify(dataSend),
		dataType: "json",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			data = res.userBeans
			for (var i = 0; i < res.userBeans.length; i++) {
				createRow(res.userBeans[i], i);
			}
		}
	})
	userDataList = data;
}

function createRow(data, seq) {
	colSeq = (seq + 1);
	colCur2 = data.name;
	colCur3 = data.surName;
	colCur4 = '<button type="button" class="btn btn-warning" onclick="editData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">แก้ไข</buttona>';
	colCur5 = '<button type="button" class="btn btn-danger" onclick="deleteData(' + data.id + ')"><span name="icon" id="icon" class="fa fa-plus">ลบ</buttona>';

	var t = $('#masterList').DataTable();
	var rowNode = t.row.add([colSeq, colCur2, colCur3, colCur4, colCur5]).draw(true).node();
	$(rowNode).find('td').eq(0).addClass('center');
	$(rowNode).find('td').eq(1).addClass('center');
	$(rowNode).find('td').eq(2).addClass('center');
}

function editData(id) {
	console.log(id)
	mode = false
	idEdit = id
	clearValidate()

	let resObjs = this.userDataList.filter(function(Obj) {
		return Obj.id == id;
	});

	var dataSend = {
		"username": resObjs[0].userName,
	}

	$.ajax({
		type: "POST",
		url: ctx + "/userManageMent/search",
		data: JSON.stringify(dataSend),
		dataType: "json",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			setUser(res.userBeans[0])
			$("#addUser").modal('show');
		}
	})
}

function deleteData(id) {
	console.log(id)

	let resObjs = this.userDataList.filter(function(Obj) {
		return Obj.id == id;
	});

	userData = {
		"id": id,
	}

	swal({
		title: "คุณต้องการลบผู้ใช้งาน " + resObjs[0].name,
		text: "",
		icon: "warning",
		buttons: true,
		successMode: true,
	})
		.then((willDelete) => {
			if (willDelete) {
				$.ajax({
					type: "POST",
					url: ctx + "/userManageMent/delete",
					data: JSON.stringify(userData),
					dataType: "json",
					async: false,
					contentType: "application/json; charset=utf-8",
					success: function(res) {
						search()
						swal('ลบข้อมูลสำเร็จ')
					}
				})
			} else {
				//						  alert('xxx')
			}
		});


}

function addUser() {
	console.log("addUser")
	mode = true
	clearUser()
	clearValidate()
	$("#password1").show();
	$("#cpassword1").show();
	$("#password").show();
	$("#cpassword").show();
	$("#addUser").modal('show');
}

function modalConfirmAddUser(callback) {
	if (callback) {
		//		fname = $('#fname').val()
		//		surname = $('#surname').val()
		//		username = $('#username').val()
		//		password = $('#password').val()
		userData = {
			"id": idEdit,
			"name": $('#fname').val(),
			"surName": $('#surname').val(),
			"userName": $('#username').val(),
			"idRole": $('#roles').val(),
			"password": $('#password').val(),
			"passwordConfirm": $('#cpassword').val(),
		}

		if (validate()) {
			$.ajax({
				type: "POST",
				url: ctx + "/userManageMent/save",
				data: JSON.stringify(this.userData),
				dataType: "json",
				async: false,
				contentType: "application/json; charset=utf-8",
				success: function(res) {
					search()
					$("#addUser").modal('hide');
					swal('บันทึก : ' + res.message)
				}
			})

		}
	} else {
		$("#addUser").modal('hide');
	}
}

function validate() {
	console.log(this.userData)
	clearValidate()

	let chkValid = true
	if (!this.userData.name) {
		$("#sfname").show();
		chkValid = false;
	} else if (!this.userData.surName) {
		$("#ssurname").show();
		chkValid = false;
	} else if (this.userData.idRole == "") {
		$("#sroles").show();
		chkValid = false;
	}

	if (chkValid && mode) {
		if (!this.userData.userName) {
			$("#susername").show();
			chkValid = false;
		} else if (!this.userData.password) {
			$("#spassword").show();
			chkValid = false;
		} else if (!this.userData.passwordConfirm) {
			$("#scpassword").show();
			chkValid = false;
		}
	}

	if (chkValid) {
		if (this.userData.password != this.userData.passwordConfirm) {
			$("#chkPass2").show();
			chkValid = false;
		}
	}

	return chkValid
}

function clearUser() {
	$('#fname').val('')
	$('#surname').val('')
	$('#username').val('')
	$('#password').val('')
	$('#cpassword').val('')
	$('#roles').val(1)
	document.getElementById("username").readOnly = false;
}

function clearValidate() {
	$("#sfname").hide();
	$("#ssurname").hide();
	$("#susername").hide();
	$("#spassword").hide();
	$("#scpassword").hide();
	$("#chkPass2").hide();
	$("#sroles").hide();
}

function setUser(data) {
	$('#fname').val(data.name)
	$('#surname').val(data.surName)
	$('#username').val(data.userName)
	$('#roles').val(data.idRole)
	document.getElementById("username").readOnly = true;
	$("#password1").hide();
	$("#cpassword1").hide();
	$("#password").hide();
	$("#cpassword").hide();
	//	document.getElementById("password").readOnly = true;
	//	document.getElementById("cpassword").readOnly = true;
	//	$('#password').val(data.name)
	//	$('#cpassword').val(data.name)
}

function getRoles() {
	$.ajax({
		type: "GET",
		url: ctx + "/userManageMent/getRole",
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			console.log(res)
			//			$('#roles').append('<option value="">' + PLS_SELECT + '</option>');
			for (var i = 0; i < res.roleList.length; i++) {
				$('#roles').append('<option value="' + (res.roleList[i].key) + '">' + (res.roleList[i].value) + '</option>');
			}
		}
	})
}