/* global angular */

angular.module("app").controller("cadCepsCtrl", function ($scope, cepsAPI, cidades, bairros, $location) {	

	$scope.cidades = cidades.data.list;
	$scope.bairros = bairros.data.list;
	
	$scope.adicionarCep = function (cep) {	
		cepsAPI.saveCep(cep).success(function (data) {
			delete $scope.cep;
			$scope.cepForm.$setPristine();
			$location.path("/ceps");
		});
	};
});