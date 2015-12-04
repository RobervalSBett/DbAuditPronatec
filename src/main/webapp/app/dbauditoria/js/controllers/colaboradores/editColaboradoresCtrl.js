/* global angular */

angular.module("app").controller("editColaboradoresCtrl", function ($scope, $routeParams, colaborador, colaboradoresAPI, $location) {

	$scope.colaborador = colaborador.data;

	$scope.adicionarColaborador = function (colaborador) {	
		colaboradoresAPI.saveColaborador(colaborador).success(function (data) {
			delete $scope.colaborador;
			$scope.colaboradorForm.$setPristine();
			$location.path("/colaboradores");
		});
	};
});