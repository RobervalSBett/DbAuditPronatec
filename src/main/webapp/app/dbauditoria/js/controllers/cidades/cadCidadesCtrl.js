/* global angular */
angular.module("app").controller("cadCidadesCtrl", function ($scope, cidadesAPI, $location) {
    
	$scope.adicionarCidade = function (cidade) {	
		cidadesAPI.saveCidade(cidade).success(function (data) {
			delete $scope.cidade;
			$scope.cidForm.$setPristine();
			$location.path("/cidades");
		});
	};
});