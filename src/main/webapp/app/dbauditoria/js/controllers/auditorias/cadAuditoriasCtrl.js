/* global angular */
angular.module("app").controller("cadAuditoriasCtrl", function ($scope, eqAudits,  colaboradores, auditoriasAPI, certificadoras,clientes,$location) {
    
    $scope.certificadoras = certificadoras.data.list;
    $scope.clientes = clientes.data.list;
    $scope.eqAudits = eqAudits.data.list;
    $scope.colaboradores = colaboradores.data.list;

	$scope.adicionarAuditoria = function (auditoria) {
		auditoriasAPI.saveAuditoria(auditoria).success(function (data) {                       
			delete $scope.auditoria;
			$scope.auditoriasForm.$setPristine();
			$location.path("/auditorias");
		});
	}; 
  
});