/* global angular, auditoriasAPI, $location */
angular.module("app").controller("editAuditoriasCtrl", function ($scope, $routeParams, auditoria,$location,auditoriasAPI,certificadoras, clientes) {

	$scope.auditoria = auditoria.data;
        $scope.certificadoras = certificadoras.data.list;
        $scope.clientes = clientes.data.list;
         
        $scope.adicionarAuditoria = function (auditoria) {
		auditoriasAPI.saveAuditoria(auditoria).success(function (data) {                       
			delete $scope.auditoria;
			$scope.auditoriasForm.$setPristine();
			$location.path("/auditorias");
		});
	};   
});