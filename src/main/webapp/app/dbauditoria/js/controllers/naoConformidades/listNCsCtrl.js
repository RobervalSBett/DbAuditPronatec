angular.module("app").controller("listNCsCtrl", function ($scope, NCs,NCsAPI,$location) {

	$scope.app = "DbAuditoria";
	$scope.NCs = NCs.data.list;	

	$scope.adicionarNC= function (nc) {        
		NCsAPI.saveNC(nc).success(function (data) {
			delete $scope.nc;
			$scope.NCForm.$setPristine();
			carregarNCs();
		});
	};
    
	$scope.apagarNCs = function (NCs) {
		$scope.NCs =  NCs.filter(function (nc) {
			if (!nc.selecionado) return nc;
		});
	};
    
	$scope.isNCSelecionado = function (NCs) {
		return NCs.some(function (nc) {
			return nc.selecionado;
		});
	};
    
	$scope.ordenarPor = function (campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};
        $scope.deleteNC = function (NCs) {
		NCsAPI.getNCs (NCs).success(function (data) {
			 
			$location.path("/NCs");
		});
	};
	
});