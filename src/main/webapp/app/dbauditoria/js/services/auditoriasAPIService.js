/* global angular */

angular.module("app").factory("auditoriasAPI", function ($http, config) {

	var _getAuditorias = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/auditorias");
	};

	var _getAuditoria = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/auditorias/" + id);
	};

	var _saveAuditoria = function (auditoria) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/auditorias", auditoria);
	};
        
    var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/auditorias/" + id);         
	};	
        
    var _deleteAuditoria = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/auditorias/" + id);
	};

	var _deleteChecklist = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/checklist/" + id);
	};

	return {

		getAuditorias 	: _getAuditorias,
		getAuditoria  	: _getAuditoria,		
		deleteChecklist  : _deleteChecklist,        
                
        saveAuditoria 	: _saveAuditoria,
        
        getDelete 	    : _getDelete,
        deleteAuditoria : _deleteAuditoria
	};
});