/* global angular */

angular.module("app").directive("uiCep", function ($filter) {
	return {
		require: "ngModel",
		link: function (scope, element, attrs, ctrl) {
			var _formatCep = function (date) {
				date = date.replace(/[^0-9]+/g, "");
				if(date.length > 5) {
					date = date.substring(0,5) + "-" + date.substring(5,8);
				}				
				
				return date;
			};

			element.bind("keyup", function () {
				ctrl.$setViewValue(_formatCep(ctrl.$viewValue));
				ctrl.$render();
			});
		}
	};
});