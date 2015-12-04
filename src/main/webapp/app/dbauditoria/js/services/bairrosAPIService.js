/* global angular */

angular.module("app").factory("bairrosAPI", function ($http, config) {

	var _getBairros = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/bairros");
	};

	var _getBairro = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/bairros/" + id);
	};

	var _saveBairro = function (bairro) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/bairros", bairro);
	};

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/bairros/" + id);         
	};

	var _deleteBairro = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/bairros/" + id);
	};

	return {		

		getBairros   : _getBairros,//get
		getBairro    : _getBairro,

		saveBairro   : _saveBairro,//post

		getDelete 	 : _getDelete,
		deleteBairro : _deleteBairro//delete

	};
});