/* global angular */

angular.module("app").controller("cadOcorrenciasCtrl", function ($scope, ocorrenciasAPI, colaboradores,checklists, $location ) {
 
    $scope.checklists    = checklists.data.list;
    $scope.colaboradores = colaboradores.data.list;

	$scope.adicionarOcorrencia = function (ocorrencia) {	
		ocorrenciasAPI.saveOcorrencia(ocorrencia).success(function (data) {
			delete $scope.ocorrencia;
			$scope.ocorrenciaForm.$setPristine();
			$location.path("/ocorrencias");
		});
	};      
       
});