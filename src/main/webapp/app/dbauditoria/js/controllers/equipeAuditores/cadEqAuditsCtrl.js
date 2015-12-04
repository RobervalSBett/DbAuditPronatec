/* global angular, equipeAuditoresAPI */

angular.module("app").controller("cadEqAuditsCtrl", function ($scope, eqAuditsAPI, $location,auditorias,auditores) {	
        
    $scope.auditorias = auditorias.data.list;
    $scope.auditores  = auditores.data.list;

	$scope.adicionarEqAudit = function (eqAudit) {	
		eqAuditsAPI.saveEqAudit(eqAudit).success(function (data) {
			delete $scope.eqAudit;
			$scope.EquipeAuditoresForm.$setPristine();
			$location.path("/eqAudits");
		});
	};        
        
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
});