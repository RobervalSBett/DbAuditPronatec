/* global angular, cepsAPI*/

angular.module("app").controller("listCepsCtrl", function ($scope, ceps, cepsAPI, $location) {

	$scope.app  = "DbAuditoria";
	$scope.ceps = ceps.data.list;
	
	$scope.adicionarCep = function (cep) {		
		cepsAPI.saveCep(cep).success(function (data) {
			delete $scope.cep;			
		});
	};
    
	$scope.apagarCeps = function (ceps) {
		$scope.ceps =  ceps.filter(function (cep) {
			if (!cep.selecionado) return cep;
		});
	};
    
	$scope.isCepSelecionado = function (ceps) {
		return ceps.some(function (cep) {
			return cep.selecionado;
		});
	};
    
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};

	$scope.deleteCep = function (ceps) {	
		cepsAPI.getCeps(ceps).success(function (data) {
		$location.path("/ceps");
		});
	};
	
	
});