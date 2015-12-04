/* global angular */

angular.module("app").factory("clientesAPI", function ($http, config) {
	
	var _getClientes = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/clientes");
	};

	var _getCliente = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/clientes/" + id);
	};

	var _saveCliente = function (cliente) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/clientes", cliente);
	};
        
        var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/clientes/" + id);         
	};

	var _deleteCliente = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/clientes/" + id);
	};

	return {
		               
            getClientes   : _getClientes,//get
            getCliente    : _getCliente,

            saveCliente   : _saveCliente,//post

            getDelete 	  : _getDelete,
            deleteCliente : _deleteCliente//delete
	};
});