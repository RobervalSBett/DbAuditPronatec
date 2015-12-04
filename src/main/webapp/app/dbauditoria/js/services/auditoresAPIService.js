/* global angular */

angular.module("app").factory("auditoresAPI", function ($http, config) {
	
	var _getAuditores = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/auditores");
	};

	var _getAuditor = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/auditores/" + id);
	};

	var _saveAuditor= function (auditor) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/auditores", auditor);
	};

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/auditores/" + id);         
	};

	var _deleteAuditor = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/auditores/" + id);
	};

	return {
		
		getAuditores  : _getAuditores,//get
		getAuditor    : _getAuditor,

		saveAuditor   : _saveAuditor,//post

		getDelete 	  : _getDelete,
		deleteAuditor : _deleteAuditor//delete

	};
});