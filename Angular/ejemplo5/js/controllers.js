app.controller("ListadoPersonasController", function($scope, $http, $routeParams, PersonasService) {
	$scope.personas = [];
	
	PersonasService.recuperarPersonas().success(function(data){
        $scope.personas = data;
    });
	
	$scope.agregarPersonaForm = function() {
		$scope.personas.push({ nombre: $scope.nombre, apellido: $scope.apellido});
		
		$scope.nombre = '';
		$scope.apellido = '';
	};
	
})
.controller("PersonaController", function($scope, $http, $routeParams, PersonasService) {
	$scope.idPersona = $routeParams.idPersona;

	PersonasService.recuperarPersonaPorId($scope.idPersona).success(function(data){
        $scope.persona = data;
    });

});

