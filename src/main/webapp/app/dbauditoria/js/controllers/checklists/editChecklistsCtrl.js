/* global angular */

angular.module("app").controller("editChecklistsCtrl", function ($scope, $routeParams, checklist, checklistsAPI, $location) {

	$scope.checklist = checklist.data;
	
	$scope.adicionarChecklist = function (checklist) {	
		checklistsAPI.saveChecklist(checklist).success(function (data) {
			delete $scope.checklist;
			$scope.checkForm.$setPristine();
			$location.path("/checklists");
		});
	};



});