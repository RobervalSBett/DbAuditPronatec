/* global angular */

angular.module("app").factory("ocorrenciasAPI", function ($http, config) {

	var _getOcorrencias = function () {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/ocorrencias");
	};

	var _getOcorrencia = function (id) {
		return $http.get(config.baseUrl + "DbAuditPronatec-3.2/api/ocorrencias/" + id);
	};

	var _saveOcorrencia= function (ocorrencia) {
		return $http.post(config.baseUrl + "DbAuditPronatec-3.2/api/ocorrencias", ocorrencia);
	};

	var _getDelete = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/ocorrencias/" + id);         
	};

	var _deleteOcorrencia = function (id) {
		return $http.delete(config.baseUrl + "DbAuditPronatec-3.2/api/ocorrencias/" + id);
	};

	return {

		getOcorrencias   : _getOcorrencias,//get
		getOcorrencia    : _getOcorrencia,

		saveOcorrencia   : _saveOcorrencia,//post

		getDelete 	  	 : _getDelete,
		deleteOcorrencia : _deleteOcorrencia//delete

	};
        
       //  this.getToday = function(){
        // return new Date();
         // };
});