function formatDouble(num, scale) {
	if(scale === undefined) scale = 2;
	if(!$.isNumeric(num)) return num;
	return num.toFixed(scale).toString().replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
}