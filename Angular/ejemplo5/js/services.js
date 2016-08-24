app.factory('PersonasService', function($http) {
	
	return {
		recuperarPersonas : function() {
			return $http.get('../personas_json.php');
		},
		recuperarPersonaPorId : function(idPersona) {
			return $http.get('../persona_json.php?id=' + idPersona);
		}
	}
});