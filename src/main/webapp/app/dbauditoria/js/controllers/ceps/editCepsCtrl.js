/* global angular, cepsAPI */

angular.module("app").controller("editCepsCtrl", function ($scope, $routeParams, cep, cidades, bairros, $location,cepsAPI) {

	$scope.cep 	   = cep.data;
	$scope.bairros = bairros.data.list;
	$scope.cidades = cidades.data.list;

	$scope.adicionarCep = function (cep) {	
		cepsAPI.saveCep(cep).success(function (data) {
			delete $scope.cep;
			$scope.cepForm.$setPristine();
			$location.path("/ceps");
		});
	};
});