/* global angular */

angular.module("app").controller("CheckPointCtrl", function ($scope, $routeParams, checklist, checklistsAPI, $location,auditorias,eqAudits,  colaboradores,ocorrencias,NCs) {

	$scope.checklist = checklist.data;
        $scope.auditorias = auditorias.data.list;
        $scope.eqAudits = eqAudits.data.list;
        $scope.colaboradores = colaboradores.data.list;
        $scope.NCs = NCs.data.list;
        $scope.ocorrencias = ocorrencias.data.list;
	
	$scope.adicionarChecklist = function (checklist) {	
		checklistsAPI.saveChecklist(checklist).success(function (data) {
			delete $scope.checklist;
			$scope.checkForm.$setPristine();
			$location.path("/checklists");
		});
	};



});