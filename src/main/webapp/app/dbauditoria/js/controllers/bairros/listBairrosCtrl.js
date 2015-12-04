/* global angular, bairrosAPI */

angular.module("app").controller("listBairrosCtrl", function ($scope, bairros, bairrosAPI, $location) {

	$scope.app     = "DbAuditoria";
	$scope.bairros = bairros.data.list;	

	$scope.adicionarBairro = function (bairro) {		
		bairrosAPI.saveBairro(bairro).success(function (data) {
			delete $scope.bairro;			
		});
	};

	$scope.apagarBairros = function (bairros) {
		$scope.bairros =  bairros.filter(function (bairro) {
			if (!bairro.selecionado) return bairro;
		});
	};

	$scope.isBairroSelecionado = function (bairros) {
		return bairros.some(function (bairro) {
			return bairro.selecionado;
		});
	};
	
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};

	$scope.deleteBairro = function (bairros) {	
		bairrosAPI.getBairros(bairros).success(function (data) {
		$location.path("/bairros");
		});
	};
	
	
});