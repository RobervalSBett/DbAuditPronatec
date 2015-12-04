/* global angular */

angular.module("app").directive("uiCnpj", function ($filter) {
	return {
		require: "ngModel",
		link: function (scope, element, attrs, ctrl) {
			var _formatCnpj = function (date) {
				date = date.replace(/[^0-9]+/g, "");
				if(date.length > 3) {
					date = date.substring(0,2) + "." + date.substring(2,5) + "." + date.substring(5,8)+ "/" + date.substring(8,12)+ "-" + date.substring(12,14);
				}
                
				return date;
			};

			element.bind("keyup", function () {
				ctrl.$setViewValue(_formatCnpj(ctrl.$viewValue));
				ctrl.$render();
			});
			
		}
	};
});