/* global angular, checklistsAPI */

angular.module("app").controller("listChecklistsCtrl", function ($scope, checklists) {
	$scope.app = "DbAuditoria";
	$scope.checklists = checklists.data.list;
	

	$scope.adicionarChecklist= function (checklist) {		
		checklistsAPI.saveChecklist(checklist).success(function (data) {
			delete $scope.checklist;
			$scope.checkForm.$setPristine();
			carregarChecklists();
		});
	};

	$scope.apagarChecklists = function (checklists) {
		$scope.checklists =  checklists.filter(function (checklist) {
			if (!checklist.selecionado) return checklist;
		});
	};

	$scope.isChecklistSelecionado = function (checklists) {
		return checklists.some(function (checklist) {
			return checklist.selecionado;
		});
	};

	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
	
	
});