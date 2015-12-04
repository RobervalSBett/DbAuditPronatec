/* global angular */

angular.module("app").directive("uiCpf", function ($filter) {
	return {
		require: "ngModel",
		link: function (scope, element, attrs, ctrl) {
			var _formatCpf = function (date) {
				date = date.replace(/[^0-9]+/g, "");
				if(date.length > 3) {
					date = date.substring(0,3) + "." + date.substring(3);
				}
                                if(date.length > 7) {
					date = date.substring(0,7) + "." + date.substring(7);
				}
                                if(date.length > 12) {
					date = date.substring(0,11) + "-" + date.substring(11,9);
				}				
				return date;
			};

			element.bind("keyup", function () {
				ctrl.$setViewValue(_formatCpf(ctrl.$viewValue));
				ctrl.$render();
			});
			
		}
	};
});