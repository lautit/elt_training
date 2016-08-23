var form = {nombre: '', apellido: '', direccion: '', localidad: '', sexo: '', gustos: [], notas: ''};

function populateStorage() {
	localStorage.userForms = JSON.stringify(form);
}

function parseForm(element, index, array) {
	if(element.name != 'gustos')
		form[element.name] = element.value;
	else
		form[element.name].push(element.value);
	
	// console.log(form);
}



$(document).ready(function () {
	
	$('#submitForm').unbind('click').click(function () {
		$('#formRegistro').serializeArray().forEach(parseForm);
		populateStorage;
	});
	
});