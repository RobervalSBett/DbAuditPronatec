angular.module("app").controller("editBairrosCtrl", function ($scope, $routeParams, bairro, bairrosAPI, $location) {

	$scope.bairro = bairro.data;

	$scope.adicionarBairro = function (bairro) {	
		bairrosAPI.saveBairro(bairro).success(function (data) {
			delete $scope.bairro;
			$scope.baiForm.$setPristine();
			$location.path("/bairros");
		});
	};
});