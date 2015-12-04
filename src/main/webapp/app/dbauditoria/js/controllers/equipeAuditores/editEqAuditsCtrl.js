/* global angular */

angular.module("app").controller("editEqAuditsCtrl", function ($scope, $routeParams, eqAudit, eqAuditsAPI, $location,auditorias,auditores) {

	$scope.eqAudit 	  = eqAudit.data;
    $scope.auditorias = auditorias.data.list;
    $scope.auditores  = auditores.data.list;	

	$scope.adicionarEqAudit = function (eqAudit) {	
		eqAuditsAPI.saveEqAudit(eqAudit).success(function (data) {
			delete $scope.eqAudit;
			$scope.EquipeAuditoresForm.$setPristine();
			$location.path("/eqAudits");
		});
	};
});