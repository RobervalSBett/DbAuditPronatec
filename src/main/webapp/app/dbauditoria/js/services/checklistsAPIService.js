/* global angular */

angular.module("app").factory("checklistsAPI", function ($http, config) {

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/checklist/" + id);         
	};

	var _deleteChecklist = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/checklist/" + id);
	};
	var _getChecklists = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/checklist");
	};

	var _getChecklist = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/checklist/" + id);
	};

	var _saveChecklist = function (checklist) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/checklist", checklist);
	};	

	return {

		getDelete 	 	 : _getDelete,
		deleteChecklist  : _deleteChecklist,//delete

		getChecklists    : _getChecklists,//get
		getChecklist     : _getChecklist,

		saveChecklist 	 : _saveChecklist//post
		
	};	

});