angular.module("app").controller("editAuditoresCtrl", function ($scope, $routeParams, auditor, ceps, auditoresAPI, $location) {

	$scope.auditor = auditor.data;
    $scope.ceps    = ceps.data.list;

	$scope.adicionarAuditor = function (auditor) {	
		auditoresAPI.saveAuditor(auditor).success(function (data) {
			delete $scope.auditor;
			$scope.auditorForm.$setPristine();
			$location.path("/auditores");
		});
	};

});