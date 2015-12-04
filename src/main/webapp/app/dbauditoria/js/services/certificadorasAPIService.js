/* global angular */

angular.module("app").factory("certificadorasAPI", function ($http, config) {
	
	var _getCertificadoras = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/certificadoras");
	};

	var _getCertificadora = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/certificadoras/" + id);
	};

	var _saveCertificadora = function (certificadora) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/certificadoras", certificadora);
	};

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/certificadoras/" + id);         
	};

	var _deleteCertificadora = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/certificadoras/" + id);
	};

	return {

		getCertificadoras   : _getCertificadoras,//get
		getCertificadora    : _getCertificadora,

		saveCertificadora   : _saveCertificadora,//post

		getDelete  			: _getDelete,
		deleteCertificadora : _deleteCertificadora//delete
	};
});