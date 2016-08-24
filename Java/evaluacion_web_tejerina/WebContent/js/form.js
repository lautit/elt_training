function Form() {
	return {
		nombre: '',
		apellido: '',
		direccion: '',
		localidad: '',
		sexo: '',
		gustos: [],
		notas: ''
	}
}

var form = Form();

function getNewForm(index) {
	var newForm = localStorage.newForm;

	if (newForm != null) {
		var newFormParsed = JSON.parse(newForm);
		
		newFormParsed.index = index;
		
		return newFormParsed;
	}

	return Form();
}

function getForms() {
	var forms = localStorage.userForms;

	if (forms != null)
		return JSON.parse(forms);

	return {
		forms: []
	};
}

function populateStorage() {
	var userForms = getForms();

	userForms.forms.push(form);

	localStorage.newForm = JSON.stringify(form);
	localStorage.userForms = JSON.stringify(userForms);

	form = Form();
}

function parseForm(element, index, array) {
	if (element.name != 'gustos')
		form[element.name] = element.value;
	else
		form[element.name].push(element.value);

	// console.log(form);
}



$(document).ready(function () {

	$('#submitForm').unbind('click').click(function () {
		$('#formRegistro').serializeArray().forEach(parseForm);
		
		populateStorage();
		
		$('#resetForm').trigger('click');
	});

});
