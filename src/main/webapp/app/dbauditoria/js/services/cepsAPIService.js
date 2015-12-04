/* global angular */

angular.module("app").factory("cepsAPI", function ($http, config) {
	
	var _getCeps = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/ceps");
	};

	var _getCep = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/ceps/" + id);
	};

	var _saveCep = function (cep) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/ceps", cep);
	};
        
        var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/ceps/" + id);         
	};

	var _deleteCep = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/ceps/" + id);
	};

	return {

		getCeps   : _getCeps,
		getCep    : _getCep,

		saveCep   : _saveCep,

        getDelete : _getDelete,
		deleteCep : _deleteCep//delete
	};
});