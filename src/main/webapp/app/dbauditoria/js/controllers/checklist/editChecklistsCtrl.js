angular.module("app").controller("editChecklistsCtrl", function ($scope, $routeParams, checklist) {

	$scope.checklist = checklist.data.list;
});