/* global angular, auditorias, auditoriasAPI */

angular.module("app").controller("listAuditoriasCtrl", function ($scope, auditorias, ocorrencias, NCs, NCsAPI, checklistsAPI, checklists, $location, auditoriasAPI ,eqAudits, colaboradores) {

	$scope.app = "DbAuditoria";
	$scope.auditorias = auditorias.data.list;
	$scope.checklists = checklists.data.list;
	$scope.eqAudits = eqAudits.data.list;
    $scope.colaboradores = colaboradores.data.list;
    $scope.NCs = NCs.data.list;
    $scope.ocorrencias = ocorrencias.data.list;

        
 
	$scope.adicionarAuditoria= function (auditoria) {		
		auditoriasAPI.saveAuditoria(auditoria).success(function (data) {
                     
			delete $scope.auditoria;
			$scope.auditoriasForm.$setPristine();
			carregarAuditorias();
			
		});
	};	
            
	$scope.apagarAuditorias = function (auditorias) {
		$scope.auditorias =  auditorias.filter(function (auditoria) {
			if (!auditoria.selecionado) return auditoria;
		});
	};

	$scope.apagarChecklists = function (checklists) {
		$scope.checklists =  checklists.filter(function (checklist) {
			if (!checklist.selecionado) return checklist;
		});
	};
    
	$scope.isAuditoriaSelecionado = function (auditorias) {
		return auditorias.some(function (auditoria) {
			return auditoria.selecionado;
		});
	};
    
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
	
	$scope.deleteAuditoria = function (auditorias) {
		auditoriasAPI.getAuditorias(auditorias).success(function (data) {   
			$location.path("/auditorias");
		});
	};	

	$scope.adicionarChecklist = function (checklist) {	
		checklistsAPI.saveChecklist(checklist).success(function (data) {
			delete $scope.checklist;
			$scope.checkForm.$setPristine();			
			$location.path("/auditorias");
		});
		
	};   
});