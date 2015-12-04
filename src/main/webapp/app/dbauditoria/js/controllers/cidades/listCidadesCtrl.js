/* global angular, cidadesAPI */
angular.module("app").controller("listCidadesCtrl", function ($scope, cidades, cidadesAPI, $location) {

	$scope.app 	   = "DbAuditoria";
	$scope.cidades = cidades.data.list;	

	$scope.adicionarCidade = function (cidade) {		
		cidadesAPI.saveCidade(cidade).success(function (data) {
			delete $scope.cidade;			
		});                
	};

	$scope.apagarCidades = function (cidades) {
		$scope.cidades =  cidades.filter(function (cidade) {
			if (!cidade.selecionado) return cidade;
		});
	};

	$scope.isCidadeSelecionado = function (cidades) {
		return cidades.some(function (cidade) {
			return cidade.selecionado;
		});
	};

	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};

	$scope.deleteCidade = function (cidades) {	
		cidadesAPI.getCidades(cidades).success(function (data) {
		$location.path("/cidades");
		});
	};


});