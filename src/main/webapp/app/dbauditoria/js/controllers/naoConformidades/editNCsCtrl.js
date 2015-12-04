/* global angular */

angular.module("app").controller("editNCsCtrl", function ($scope, $routeParams, nc, NCsAPI, $location,colaboradores,checklists) {

	$scope.nc 			 = nc.data;
    $scope.colaboradores = colaboradores.data.list;
	$scope.checklists    = checklists.data.list;

	$scope.adicionarNC = function (nc) {	
		NCsAPI.saveNC(nc).success(function (data) {
			delete $scope.nc;
			$scope.NCForm.$setPristine();
			$location.path("/NCs");
		});
	};
});