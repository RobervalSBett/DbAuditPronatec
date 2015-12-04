/* global angular */

angular.module("app").controller("cadCertsCtrl", function ($scope, certificadorasAPI, ceps,  $location) {

	$scope.ceps = ceps.data.list;
	
	$scope.adicionarCertificadora = function (certificadora) {	
		certificadorasAPI.saveCertificadora(certificadora).success(function (data) {
			delete $scope.certificadora;
			$scope.certForm.$setPristine();
			$location.path("/certs");
		});
	};
});