/* global angular */

angular.module("app").controller("cadClientesCtrl", function ($scope, clientesAPI, $location, ceps) {
	
    $scope.ceps = ceps.data.list;

	$scope.adicionarCliente = function (cliente) {	
		clientesAPI.saveCliente(cliente).success(function (data) {
			delete $scope.cliente;
			$scope.clienteForm.$setPristine();
			$location.path("/clientes");
		});
	};
});