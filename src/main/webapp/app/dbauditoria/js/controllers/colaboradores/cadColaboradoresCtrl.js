/* global angular */

angular.module("app").controller("cadColaboradoresCtrl", function ($scope, colaboradoresAPI, $location) {
	

	$scope.adicionarColaborador = function (colaborador) {	
		colaboradoresAPI.saveColaborador(colaborador).success(function (data) {
			delete $scope.colaborador;
			$scope.colaboradorForm.$setPristine();
			$location.path("/colaboradores");
		});
	};
});