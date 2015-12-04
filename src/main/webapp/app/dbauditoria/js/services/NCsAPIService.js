/* global angular */

angular.module("app").factory("NCsAPI", function ($http, config) {
	
	var _getNCs = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/naoconformidades");
	};

	var _getNC = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/naoconformidades/" + id);
	};

	var _saveNC = function (nc) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/naoconformidades", nc);
	};

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/naoconformidades/" + id);         
	};

	var _deleteNC = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/naoconformidades/" + id);
	};

	return {

		getNCs    : _getNCs,//get
		getNC     : _getNC,

		saveNC    : _saveNC,//post

		getDelete : _getDelete,
		deleteNC  : _deleteNC//delete
	};
});