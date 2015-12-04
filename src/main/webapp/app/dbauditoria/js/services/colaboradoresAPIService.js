/* global angular */

angular.module("app").factory("colaboradoresAPI", function ($http, config) {

	var _getColaboradores = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/colaboradores");
	};

	var _getColaborador = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/colaboradores/" + id);
	};

	var _saveColaborador= function (colaborador) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/colaboradores", colaborador);
	};

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/colaboradores/" + id);         
	};

	var _deleteColaborador = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/colaboradores/" + id);
	};

	return {

		getColaboradores  : _getColaboradores,//get
		getColaborador    : _getColaborador,

		saveColaborador   : _saveColaborador,//post

		getDelete 	      : _getDelete,
		deleteColaborador : _deleteColaborador//delete
	};
});