/* global angular */
 angular.module("app").config(function ($routeProvider) {
     	$routeProvider.when("/", {
        templateUrl: "view/home.html", 
         controller: "HomeCtrl"
		
	});
	$routeProvider.when("/cidades", {
		templateUrl: "cidade.html",
		controller: "CidadesCtrl",
		resolve: {
			cidades: function (cidadesAPI) {
				return cidadesAPI.getCidades();
			},
			ufs: function (ufsAPI) {
				return ufsAPI.getUfs();
			}
		}
	});
	$routeProvider.when("/CadCidades", {
		templateUrl: "view/cadastro.html",
		controller: "cadCidadeCtrl",
		resolve: {
			ufs: function (ufsAPI) {
				return ufsAPI.getUfs();
			}
		}
	});
	$routeProvider.when("/EditarCid/:id", {
		templateUrl: "view/editarCidade.html",
		controller: "EditarCidCtrl",
		resolve: {
			cidade: function (cidadesAPI, $route) {
				return cidadesAPI.getCidade($route.current.params.id);
			}
		}
	});
	$routeProvider.otherwise({redirectTo: "/cidades"});
});