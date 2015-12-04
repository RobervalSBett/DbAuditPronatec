/* global angular */

angular.module("app").controller("listCertsCtrl", function ($scope, certificadoras, certificadorasAPI, $location) {

	$scope.app 			  = "DbAuditoria";
	$scope.certificadoras = certificadoras.data.list;
		
	$scope.adicionarCertificadora = function (certificadora) {
		certificadorasAPI.saveCertificadora(certificadora).success(function (data) {
			delete $scope.certificadora;			
		});
	};

	$scope.apagarCertificadoras = function (certificadoras) {
		$scope.certificadoras =  certificadoras.filter(function (certificadora) {
			if (!certificadora.selecionado) return certificadora;
		});
	};

	$scope.isCertificadoraSelecionado = function (certificadoras) {
		return certificadoras.some(function (certificadora) {
			return certificadora.selecionado;
		});
	};

	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};

	$scope.deleteCertificadora = function (certificadoras) {	
		certificadorasAPI.getCertificadoras(certificadoras).success(function (data) {
		$location.path("/certificadoras");
		});
	};

});