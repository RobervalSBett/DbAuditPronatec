/* global angular, auditoriasAPI, $location */
angular.module("app").controller("AuditoriasAndamCtrl", function ($scope, $routeParams, auditoria,$location,auditoriasAPI,certificadoras, clientes,checklists,eqAudits) {

	$scope.auditoria = auditoria.data;
        $scope.certificadoras = certificadoras.data.list;
        $scope.clientes = clientes.data.list;
        $scope.checklists = checklists.data.list;
        $scope.eqAudits = eqAudits.data.list;
        $scope.adicionarAuditoria = function (auditoria) {
		auditoriasAPI.saveAuditoria(auditoria).success(function (data) {                       
			delete $scope.auditoria;
			$scope.auditoriasForm.$setPristine();
			$location.path("/auditorias");
		});
	};   
});