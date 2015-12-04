/* global angular */

angular.module("app").directive("uiFone", function ($filter) {
	return {
		require: "ngModel",
		link: function (scope, element, attrs, ctrl) {
			var _formatFone = function (dados) {
				dados = dados.replace(/[^0-9]+/g, "");
				if(dados.length > 1) {
					if(dados.length <= 14){
						dados = "(" + dados.substring(0,2) + ")" +" " + dados.substring(2,6) +"-" + dados.substring(6,10);
					}else{
						dados = "(" + dados.substring(0,2) + ")" +" " + dados.substring(2,7) +"-" + dados.substring(7,11);
					}	
				}	
				
				return dados;
			};

			element.bind("keyup", function () {
				ctrl.$setViewValue(_formatFone(ctrl.$viewValue));
				ctrl.$render();
			});					
		}
	};
});