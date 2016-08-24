var app = angular.module('holaMundoApp', []);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider.
	when('/personas', {templateUrl: 'partials/listado_personas.html', controller: 'ListadoPersonasController'}).
	when('/personas/:idPersona', {templateUrl: 'partials/ver_persona.html', controller: 'PersonaController'}).
	otherwise({redirectTo: '/personas'});
}]);