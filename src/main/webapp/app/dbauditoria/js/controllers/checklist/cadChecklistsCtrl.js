/* global angular */

angular.module("app").controller("cadChecklistsCtrl", function ($scope, checklistsAPI, $location) {
	

	$scope.adicionarChecklist = function (checklist) {	
		checklistsAPI.saveChecklist(checklist).success(function (data) {
			delete $scope.checklist;
			$scope.checkForm.$setPristine();
			$location.path("/checklists");
		});
	};
});