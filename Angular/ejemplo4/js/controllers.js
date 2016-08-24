app.controller("ListadoPersonasController", function ($scope, $http, $routeParams) {
	$scope.personas = [];
	
	$http.get('../personas_json.php').success(function(data){
        $scope.personas = data;
    });
	
	$scope.agregarPersonaForm = function() {
		$scope.personas.push({ nombre: $scope.nombre, apellido: $scope.apellido});
		
		$scope.nombre = '';
		$scope.apellido = '';
	};
	
})
.controller("PersonaController", function($scope, $http, $routeParams) {
	$scope.idPersona = $routeParams.idPersona;
	
	$http.get('../persona_json.php?id=' + $scope.idPersona).success(function(data){
        $scope.persona = data;
    });
});