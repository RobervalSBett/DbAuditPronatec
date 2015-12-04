/* global angular */

angular.module("app").controller("cadBairrosCtrl", function ($scope, bairrosAPI, $location) {	

	$scope.adicionarBairro = function (bairro) {	
		bairrosAPI.saveBairro(bairro).success(function (data) {
			delete $scope.bairro;
			$scope.baiForm.$setPristine();
			$location.path("/bairros");
		});
	};
});