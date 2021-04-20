var doc
var specialElementHandlers

$(document).ready(function() {
	setHTML()
});

function setHTML() {
	let code = "";
	let id = '';
	
	var rptCode = document.getElementById("rptCode").value;
	$.ajax({
		type: "GET",
		url: ctx + "/findAllReportPage/" + rptCode,
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			code = res.textCode
			id = res.value
		}
	})

	document.getElementById("report").innerHTML = code;
	setData(id)
}

function setData(id) {
	var divElement = document.getElementById(id);
	var vizElement = divElement.getElementsByTagName('object')[0]; vizElement.style.width = '100%';
	vizElement.style.height = (divElement.offsetWidth * 0.75) + 'px';
	var scriptElement = document.createElement('script');
	scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';
	vizElement.parentNode.insertBefore(scriptElement, vizElement)
}

function printReport() {
	doc = new jsPDF();
	specialElementHandlers = {
	    '#editor': function (element, renderer) {
	        return true;
	    }
	};
    
	doc.fromHTML($('#report').html(), {
        'width': 170,
            'elementHandlers': specialElementHandlers
    });
    doc.save('sample-file.pdf');
}