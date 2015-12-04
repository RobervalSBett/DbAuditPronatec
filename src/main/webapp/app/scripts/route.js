
app.config(['$routeProvider', function ($routeProvider) {$routeProvider
    // Home
    .when("/", {
        templateUrl: "views/home.html", 
         controller: "HomeCtrl"})
    // Paginas
    .when("/cidades", {
		templateUrl: "cidade.html",
		controller: "CidadesCtrl",
		resolve: {
			cidades: function (cidadesAPI) {
				return cidadesAPI.getCidades();
			}
		}
	})
  
    .when("/cliente", {
        templateUrl: "views/Cadastro/Clientes.html", 
        controller: "ClienteCtrl"})
    
        .when("/settings-pills", {
        templateUrl: "Clientes.html", 
        controller: "ClienteCtrl"})
    
      .when("/home-pills", {
        templateUrl: "Clientes.html", 
        controller: "ClienteLCtrl"})
    
      .when("/bairro", {
        templateUrl: "views/Cadastro/Bairros.html", 
        controller: "BairroCtrl"})
    
      .when("/settings-pills", {
        templateUrl: "Bairros.html", 
        controller: "BairroCtrl"})
    
      .when("/home-pills", {
        templateUrl: "Bairros.html", 
        controller: "BairroCtrl"})

      .when("/Auditoria", {
        templateUrl: "auditoria/auditoria.html", 
        controller: "AuditoriaCtrl"})

       .when("/ConsultaAuditoria", {
        templateUrl: "auditoria/consultaauditoria.html", 
        controller: "ConsultaAuditoriaCtrl"})

      .when("/cidade", {
        templateUrl: "Cidades/cidade.html", 
        controller: "cidadeCtrl"})
    
      .when("/settings-pills", {
        templateUrl: "cidade.html", 
        controller: "cidadeCtrl"})
    
      .when("/home-pills", {
        templateUrl: "cidade.html", 
        controller: "cidadeCtrl"})
    
        .when("/auditor", {
        templateUrl: "Auditores/auditor.html", 
        controller: "auditorCtrl"})
    
      .when("/settings-pills", {
        templateUrl: "auditor.html", 
        controller: "auditorCtrl"})
    
      .when("/home-pills", {
        templateUrl: "auditor.html", 
        controller: "auditorCtrl"})
    
    .when("/equipeAuditor", {
        templateUrl: "equipeAuditores/equipeAuditor.html", 
        controller: "equipeAuditorCtrl"})
    
      .when("/settings-pills", {
        templateUrl: "equipeAuditor.html", 
        controller: "equipeAuditorCtrl"})
    
      .when("/home-pills", {
        templateUrl: "equipeAuditor.html", 
        controller: "equipeAuditorCtrl"})
    
    .when("/naoConformidade", {
        templateUrl: "naoConformidades/naoConformidade.html", 
        controller: "naoConformidadeCtrl"})
    
      .when("/settings-pills", {
        templateUrl: "naoConformidade.html", 
        controller: "naoConformidadeCtrl"})
    
      .when("/home-pills", {
        templateUrl: "naoConformidade.html", 
        controller: "naoConformidadeCtrl"})
    
   
}]);
