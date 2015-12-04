/* global angular */

angular.module("app").controller("cadNCsCtrl", function ($scope, NCsAPI, $location,checklists,colaboradores) {	
        
	$scope.checklists    = checklists.data.list;
	$scope.colaboradores = colaboradores.data.list;

	$scope.adicionarNC = function (nc) {	
		NCsAPI.saveNC(nc).success(function (data) {
			delete $scope.nc;
			$scope.NCForm.$setPristine();
			$location.path("/NCs");
		});
	};
});