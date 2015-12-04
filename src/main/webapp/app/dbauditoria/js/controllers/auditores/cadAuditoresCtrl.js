/* global angular */

angular.module("app").controller("cadAuditoresCtrl", function ($scope, auditoresAPI, ceps, $location) {	

    $scope.ceps = ceps.data.list;
    
	$scope.adicionarAuditor = function (auditor) {	
		auditoresAPI.saveAuditor(auditor).success(function (data) {
			delete $scope.auditor;
			$scope.auditorForm.$setPristine();
			$location.path("/auditores");
		});
	};
});