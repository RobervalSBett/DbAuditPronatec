/* global angular */

angular.module("app").factory("cidadesAPI", function ($http, config) {

	var _getCidades = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/cidades");
	};

	var _getCidade = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/cidades/" + id);
	};
        
    var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/cidades/" + id);         
	};
        
	var _saveCidade= function (cidade) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/cidades", cidade);
	};
        
    var _deleteCidade = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/cidades/" + id);
	};

	return {
		
		getCidades   : _getCidades,
		getCidade    : _getCidade,

        getDelete    : _getDelete,
                
		saveCidade   : _saveCidade,
        deleteCidade : _deleteCidade
	};
});