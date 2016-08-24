var app = angular.module('holaMundoApp', []);
app.controller("HolaMundoController", function ($scope) {

	$scope.numero1 = $scope.numero2 = $scope.resultado = 0;

	$scope.ops = [{
		sym: "+",
		fun: function (n1, n2) {
			return n1+n2;
		}
	}, {
		sym: "-",
		fun: function (n1, n2) {
			return n1-n2;
		}
	}, {
		sym: "x",
		fun: function (n1, n2) {
			return n1*n2;
		}
	}, {
		sym: "/",
		fun: function (n1, n2) {
			return n1/n2;
		}
	}, {
		sym: "^",
		fun: function (n1, n2) {
			return Math.pow(n1,n2);
		}
	}];

	$scope.operar = function () {
		$scope.resultado = $scope.op.fun($scope.numero1, $scope.numero2);
	};
});
