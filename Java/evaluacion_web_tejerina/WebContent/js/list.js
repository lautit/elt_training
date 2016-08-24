Handlebars.getTemplate = function (name) {
	if (Handlebars.templates === undefined || Handlebars.templates[name] === undefined) {
		$.ajax({
			url: '../templates/' + name + '.hbs',
			success: function (data) {
				if (Handlebars.templates === undefined) {
					Handlebars.templates = {};
				}
				Handlebars.templates[name] = Handlebars.compile(data);
			},
			async: false
		});
	}
	return Handlebars.templates[name];
};

Handlebars.registerHelper("inc", function(value, options)
{
    return parseInt(value) + 1;
});

function initTable() {

	var rowTemplate = Handlebars.getTemplate('listrow'),
		userForms = getForms(),
		rowsHTML = rowTemplate(userForms);

	$("#tableBody").html(rowsHTML);
	
}

function updateTable(e) {
	if(e.key == "newForm") {
		var rowTemplate = Handlebars.getTemplate('row'),
			tableBody = $("#tableBody"),
			newForm = getNewForm(tableBody.children().length),
			newRowHTML = rowTemplate(newForm);

		tableBody.append(newRowHTML);
	}
}

$(document).ready(function () {

	$(window).bind('storage', updateTable);

	initTable();

});
