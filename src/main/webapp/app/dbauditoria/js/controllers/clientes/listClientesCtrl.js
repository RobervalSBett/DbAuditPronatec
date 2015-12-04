/* global angular */

angular.module("app").controller("ClientesCtrl", function ($scope, clientes, clientesAPI, $location) {

	$scope.app 		= "DbAuditoria";
	$scope.clientes = clientes.data.list;


	$scope.adicionarCliente = function (cliente) {		
		clientesAPI.saveCliente(cliente).success(function (data) {
			delete $scope.cliente;			
		});
	};

	$scope.apagarClientes = function (clientes) {
		$scope.clientes =  clientes.filter(function (cliente) {
			if (!cliente.selecionado) return cliente;
		});
	};
	
	$scope.isClienteSelecionado = function (clientes) {
		return clientes.some(function (cliente) {
			return cliente.selecionado;
		});
	};
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};

	$scope.deleteCliente = function (clientes) {	
		clientesAPI.getClientes(clientes).success(function (data) {
		$location.path("/clientes");
		});
	};
	
	
});