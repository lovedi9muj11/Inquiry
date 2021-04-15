$(document).ready(function() {
	setHTML()
});

function setHTML() {
	let code = "";
	let id = '';
	$.ajax({
		type: "GET",
		url: ctx + "/findAllReportPage/"+RPT_CODE,
		async: false,
		contentType: "application/json; charset=utf-8",
		success: function(res) {
			code = res.textCode
			id = res.value
		}
	})

	document.getElementById("report").innerHTML = code;
//	$('#report').append("<div class='tableauPlaceholder' id='viz1618389936412' style='position: relative'><noscript><a href='#'><img alt='Sheet 2 ' src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;Bo&#47;Book1_16179876732140&#47;Sheet2&#47;1_rss.png' style='border: none' /></a></noscript><object class='tableauViz'  style='display:none;'><param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F' /> <param name='embed_code_version' value='3' /> <param name='site_root' value='' /><param name='name' value='Book1_16179876732140&#47;Sheet2' /><param name='tabs' value='no' /><param name='toolbar' value='yes' /><param name='static_image' value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;Bo&#47;Book1_16179876732140&#47;Sheet2&#47;1.png' /> <param name='animate_transition' value='yes' /><param name='display_static_image' value='yes' /><param name='display_spinner' value='yes' /><param name='display_overlay' value='yes' /><param name='display_count' value='yes' /><param name='language' value='en' /><param name='filter' value='publish=yes' /></object></div>")
	
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