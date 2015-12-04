/* global angular */

angular.module("app").controller("cadChecklistsCtrl", function ($scope, checklistsAPI, $location,auditorias,eqAudits,  colaboradores) {	
	
    $scope.auditorias = auditorias.data.list;
    $scope.eqAudits = eqAudits.data.list;
    $scope.colaboradores = colaboradores.data.list;

	$scope.adicionarChecklist = function (checklist) {	
		checklistsAPI.saveChecklist(checklist).success(function (data) {
			delete $scope.checklist;
			$scope.checkForm.$setPristine();
			$location.path("/checklists");
		});
	};
        
    $scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
});