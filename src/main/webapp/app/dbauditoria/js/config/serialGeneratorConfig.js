/* global angular */

angular.module("app").config(function (serialGeneratorProvider) {
	serialGeneratorProvider.setLength(5);
});