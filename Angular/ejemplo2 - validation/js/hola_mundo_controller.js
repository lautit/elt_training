var app = angular.module('holaMundoApp', []);
app.controller("HolaMundoController", function($scope) {

	$scope.personas = [{ nombre: 'Juan', apellido: 'Perez'}, { nombre: 'Maria', apellido: 'Lopez'}];
	
	$scope.agregarPersonaClick = function() {
		$scope.personas.push({ nombre: 'Claudio', apellido: 'Mendez'});
	};
	
	$scope.agregarPersonaForm = function() {
		$scope.personas.push({ nombre: $scope.nombre, apellido: $scope.apellido});
		
		$scope.nombre = '';
		$scope.apellido = '';
	};
	
});