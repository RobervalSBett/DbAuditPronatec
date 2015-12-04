/* global angular, cidade, cidadesAPI, $location */
angular.module("app").controller("editCidadesCtrl", function ($scope, $routeParams,cidade,cidadesAPI, $location) {

	$scope.cidade = cidade.data;  

    $scope.adicionarCidade = function (cidade) {	
		cidadesAPI.saveCidade(cidade).success(function (data) {
			delete $scope.cidade;
			$scope.cidForm.$setPristine();
			$location.path("/cidades");
		});
	};  
});