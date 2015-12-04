/* global angular */

angular.module("app").factory("eqAuditsAPI", function ($http, config) {

	var _getEqAudits = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/equipeauditores");
	};

	var _getEqAudit = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/equipeauditores/" + id);
	};

	var _saveEqAudit = function (eqAudit) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/equipeauditores", eqAudit);
	};

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/equipeauditores/" + id);         
	};

	var _deleteEqAudit = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/equipeauditores/" + id);
	};

	return {

		getEqAudits   : _getEqAudits,//get
		getEqAudit    : _getEqAudit,

		saveEqAudit   : _saveEqAudit,//post		

		getDelete 	  : _getDelete,
		deleteEqAudit : _deleteEqAudit//delete
	};
});