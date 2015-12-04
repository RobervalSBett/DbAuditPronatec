/* global angular */

angular.module("app").config(function ($routeProvider) {
    
    $routeProvider.when("/", {
        templateUrl: "home.html", 
        controller : "HomeCtrl"		
	}); 
        
   $routeProvider.when("/exemplo", {
        templateUrl: "exemploCliente/clientes.html", 
        controller : "exemploCtrl"		
    });
    
    $routeProvider.when("/settings-pills", {
        templateUrl: "exemploCliente/clientes.html", 
        controller : "cadexemploCtrl"		
    }); 
    
//***********************************************************cidades
    $routeProvider.when("/cidades", {
        templateUrl: "cidades/listCidades.html",
        controller : "listCidadesCtrl",
        resolve    : {
            cidades: function (cidadesAPI){
                return cidadesAPI.getCidades();
            }       
        }
    });
    
    $routeProvider.when("/cadCidades", {
        templateUrl: "cidades/cadCidades.html",
        controller : "cadCidadesCtrl"
    });
        
    $routeProvider.when("/editCidades/:id", {
        templateUrl: "cidades/cadCidades.html",
        controller : "editCidadesCtrl",
        resolve    : {
            cidade : function (cidadesAPI, $route) {
                return cidadesAPI.getCidade($route.current.params.id);
            }
        }
    });
    
    $routeProvider.when("/deleteCidade/:id", {
        templateUrl: "cidades/listCidades.html",
        controller : "listCidadesCtrl",
        resolve    : {
            cidade : function (cidadesAPI, $route) {
                return cidadesAPI.deleteCidade($route.current.params.id);
            },
            cidades : function (cidadesAPI){
                return cidadesAPI.getCidades();
            } 
        }
    });
        
//*****************************************************************Bairros
    $routeProvider.when("/bairros", {
        templateUrl: "bairros/listBairros.html",
        controller : "listBairrosCtrl",
        resolve    : {
            bairros: function (bairrosAPI) {
                return bairrosAPI.getBairros();
            }       
        }
    });
    
    $routeProvider.when("/cadBairros", {
		templateUrl: "bairros/cadBairros.html",
		controller : "cadBairrosCtrl"
	});
        
	$routeProvider.when("/editBairros/:id", {
		templateUrl: "bairros/cadBairros.html",
		controller : "editBairrosCtrl",
		resolve    : {
            bairro : function (bairrosAPI, $route) {
                return bairrosAPI.getBairro($route.current.params.id);
			}
		}
	}); 

    $routeProvider.when("/deleteBairro/:id", {
        templateUrl: "bairros/listBairros.html",
        controller : "listBairrosCtrl",
        resolve    : {
            bairro : function (bairrosAPI, $route) {
                return bairrosAPI.deleteBairro($route.current.params.id);
            },
            bairros: function (bairrosAPI){
                return bairrosAPI.getBairros();
            } 
        }
    });       
        
        
//*****************************************************************Nao Conformidades
    $routeProvider.when("/NCs", {
        templateUrl: "naoConformidades/listNCs.html",
        controller : "listNCsCtrl",
        resolve    : {
            NCs: function (NCsAPI) {
                return NCsAPI.getNCs();
            }       
        }
    });
    
    $routeProvider.when("/cadNCs", {
        templateUrl: "naoConformidades/cadNCs.html",
        controller : "cadNCsCtrl",
        resolve    : {  
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            }
        } 
	});
        
	$routeProvider.when("/editNCs/:id", {
        templateUrl: "naoConformidades/editNCs.html",
        controller : "editNCsCtrl",
        resolve    : {
            nc: function (NCsAPI, $route) {
            return NCsAPI.getNC($route.current.params.id);
            },
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            }
        }
	});
        
    $routeProvider.when("/deleteNC/:id", {
        templateUrl: "naoConformidades/listNCs.html",
        controller : "listNCsCtrl",
        resolve    : {
            nc: function (NCsAPI, $route) {
                return NCsAPI.deleteNC($route.current.params.id);
            } 
        }
    });

//*****************************************************************Auditores
    $routeProvider.when("/auditores", {
        templateUrl: "auditores/listAuditores.html",
        controller : "AuditoresCtrl",
        resolve    : {
            auditores: function (auditoresAPI){
                return auditoresAPI.getAuditores();
            }       
        }
    });    
    
    $routeProvider.when("/cadAuditores", {
        templateUrl: "auditores/cadAuditores.html",
        controller : "cadAuditoresCtrl",
        resolve    : {
            ceps: function (cepsAPI) {
                return cepsAPI.getCeps();
            }       
        }
    });
        
    $routeProvider.when("/editAuditores/:id", {
        templateUrl: "auditores/cadAuditores.html",
        controller : "editAuditoresCtrl",
        resolve    : {
            auditor: function (auditoresAPI, $route) {
                return auditoresAPI.getAuditor($route.current.params.id);
            },
            ceps: function (cepsAPI) {
                return cepsAPI.getCeps();
            }       
        }
    });

    $routeProvider.when("/deleteAuditor/:id", {
        templateUrl: "auditores/listAuditores.html",
        controller : "AuditoresCtrl",
        resolve    : {
            auditor: function (auditoresAPI, $route) {
                return auditoresAPI.deleteAuditor($route.current.params.id);
            },
            auditores: function (auditoresAPI){
                return auditoresAPI.getAuditores();
            } 
        }
    });
        
//**********************************************************Certificadoras
    $routeProvider.when("/certs", {
        templateUrl: "certificadoras/listCerts.html",
        controller : "listCertsCtrl",
        resolve    : {
            certificadoras: function (certificadorasAPI) {
                return certificadorasAPI.getCertificadoras();
            }       
        }
    });

    $routeProvider.when("/cadCerts", {
        templateUrl: "certificadoras/cadCerts.html",
        controller : "cadCertsCtrl",
        resolve    : {
            ceps: function (cepsAPI) {
                return cepsAPI.getCeps();
            }    
        }
    });

    $routeProvider.when("/editCerts/:id", {
        templateUrl: "certificadoras/cadCerts.html",
        controller : "editCertsCtrl",
        resolve    : {
            certificadora: function (certificadorasAPI, $route) {
                return certificadorasAPI.getCertificadora($route.current.params.id);            
            } ,
            ceps: function (cepsAPI) {
                return cepsAPI.getCeps();
            }    
        }
    });

    $routeProvider.when("/deleteCert/:id", {
        templateUrl: "certificadoras/listCerts.html",
        controller : "listCertsCtrl",
        resolve    : {
            certificadora: function (certificadorasAPI, $route) {
                return certificadorasAPI.deleteCertificadora($route.current.params.id);
            },
            certificadoras: function (certificadorasAPI){
                return certificadorasAPI.getCertificadoras();
            } 
        }
    });

//***********************************************************ocorrencias
    $routeProvider.when("/ocorrencias", {
        templateUrl: "ocorrencias/listOcorrencias.html",
        controller : "listOcorrenciasCtrl",
        resolve    : {
            ocorrencias: function (ocorrenciasAPI) {
                return ocorrenciasAPI.getOcorrencias();
            }       
        }
    });
     
    $routeProvider.when("/cadOcorrencias", {
        templateUrl: "ocorrencias/cadOcorrencias.html",
        controller : "cadOcorrenciasCtrl",
        resolve    : {
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            }
        }
     });

    $routeProvider.when("/editOcorrencias/:id", {
        templateUrl: "ocorrencias/cadOcorrencias.html",
        controller : "editOcorrenciasCtrl",
        resolve    : {
            ocorrencia: function (ocorrenciasAPI, $route) {
                return ocorrenciasAPI.getOcorrencia($route.current.params.id);
            },
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            },
            colaboradores: function (colaboradoresAPI){
            return colaboradoresAPI.getColaboradores();
            }
        }
    });

    $routeProvider.when("/deleteOcorrencia/:id", {
        templateUrl: "ocorrencias/listOcorrencias.html",
        controller : "listOcorrenciasCtrl",
        resolve    : {
            ocorrencia: function (ocorrenciasAPI, $route) {
                return ocorrenciasAPI.deleteOcorrencia($route.current.params.id);
            },
            ocorrencias: function (ocorrenciasAPI){
                return ocorrenciasAPI.getOcorrencias();
            } 
        }
    });
     
//***********************************************************Clientes
    $routeProvider.when("/clientes", {
        templateUrl: "clientes/listClientes.html",
        controller : "ClientesCtrl",
        resolve    : {
            clientes: function (clientesAPI) {
                return clientesAPI.getClientes();
            }       
        }
    });
        
    $routeProvider.when("/cadClientes", {
		templateUrl: "clientes/cadClientes.html",
		controller : "cadClientesCtrl",
        resolve    : { 
            ceps: function (cepsAPI) {
                return cepsAPI.getCeps();
            } 
		}
	});
        
	$routeProvider.when("/editClientes/:id", {
	   templateUrl: "clientes/cadClientes.html",
	   controller : "editClientesCtrl",
	   resolve    : {
    		cliente: function (clientesAPI, $route) {
    	        return clientesAPI.getCliente($route.current.params.id);
    		},
            ceps: function (cepsAPI) {
                return cepsAPI.getCeps();
            }   
		}
	});
        
    $routeProvider.when("/deleteCliente/:id", {
        templateUrl: "clientes/listClientes.html",
        controller : "ClientesCtrl",
        resolve    : {
            cliente: function (clientesAPI, $route) {
                return clientesAPI.deleteCliente($route.current.params.id);
            },
            clientes: function (clientesAPI){
                return clientesAPI.getClientes();
            } 
        }
    });


//***********************************************************ceps
    $routeProvider.when("/ceps", {
        templateUrl: "ceps/listCeps.html",
        controller : "listCepsCtrl",
        resolve    : {
            ceps: function (cepsAPI) {
                return cepsAPI.getCeps();
            }       
        }
    });

    $routeProvider.when("/cadCeps", {
		templateUrl: "ceps/cadCeps.html",
		controller : "cadCepsCtrl",
        resolve    : {
            bairros: function (bairrosAPI) {
                return bairrosAPI.getBairros();
            },
            cidades: function (cidadesAPI) {
                return cidadesAPI.getCidades();
            }       
        }
	});
        
	$routeProvider.when("/editCeps/:id", {
		templateUrl: "ceps/cadCeps.html",
		controller : "editCepsCtrl",
		resolve    : {
			cep: function (cepsAPI, $route) {
				return cepsAPI.getCep($route.current.params.id);
			},
            bairros: function (bairrosAPI) {
                return bairrosAPI.getBairros();
            },
            cidades: function (cidadesAPI) {
                return cidadesAPI.getCidades();
            }
		}
	}); 

    $routeProvider.when("/deleteCep/:id", {
        templateUrl: "ceps/listCeps.html",
        controller : "listCepsCtrl",
        resolve    : {
            cep: function (cepsAPI, $route) {
                return cepsAPI.deleteCep($route.current.params.id);
            },
            ceps: function (cepsAPI){
                return cepsAPI.getCeps();
            } 
        }
    });
 
//************************************************************Equipe Auditores
    $routeProvider.when("/eqAudits", {
        templateUrl: "equipeAuditores/listEqAudits.html",
        controller : "listEqAuditsCtrl",
        resolve    : {
            eqAudits: function (eqAuditsAPI){
                return eqAuditsAPI.getEqAudits();
            }       
        }
    });    
    
    $routeProvider.when("/cadEqAudits", {
        templateUrl: "equipeAuditores/cadEqAudits.html",
        controller : "cadEqAuditsCtrl",
        resolve    : {
            auditorias: function (auditoriasAPI){
                return auditoriasAPI.getAuditorias();
            },
            auditores: function (auditoresAPI){
                return auditoresAPI.getAuditores();
            }
        }
    }); 
  
 
    $routeProvider.when("/editEqAudits/:id", {
        templateUrl: "equipeAuditores/cadEqAudits.html",
        controller : "editEqAuditsCtrl",
        resolve    : {
            eqAudit: function (eqAuditsAPI, $route) {
                return eqAuditsAPI.getEqAudit($route.current.params.id);
            },
            auditorias: function (auditoriasAPI){
                return auditoriasAPI.getAuditorias();
            },
            auditores: function (auditoresAPI){
                return auditoresAPI.getAuditores();
            }
        }
    });

    $routeProvider.when("/deleteEqAudit/:id", {
        templateUrl: "equipeAuditores/listEqAudits.html",
        controller : "listEqAuditsCtrl",
        resolve    : {
            eqAudit: function (eqAuditsAPI, $route) {
                return eqAuditsAPI.deleteEqAudit($route.current.params.id);
            },
            eqAudits: function (eqAuditsAPI){
                return eqAuditsAPI.getEqAudits();
            } 
        }
    });
        
        
//*********************************************************************Auditorias
    $routeProvider.when("/auditorias", {
        templateUrl: "auditorias/listAuditorias.html",
        controller : "listAuditoriasCtrl",
        resolve    : {
            auditorias: function (auditoriasAPI){
                return auditoriasAPI.getAuditorias();
            },
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            },
            eqAudits: function (eqAuditsAPI){
                return eqAuditsAPI.getEqAudits();
            },
            NCs: function (NCsAPI) {
                return NCsAPI.getNCs();
            },
            ocorrencias: function (ocorrenciasAPI) {
                return ocorrenciasAPI.getOcorrencias();
            }       
        }
    }); 
   
    $routeProvider.when("/cadAuditorias", {
        templateUrl: "auditorias/cadAuditorias.html",
        controller : "cadAuditoriasCtrl",
        resolve    : {
            certificadoras: function (certificadorasAPI) {
                return certificadorasAPI.getCertificadoras();
            },
            clientes: function (clientesAPI) {
                return clientesAPI.getClientes();
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            },
            eqAudits: function (eqAuditsAPI){
                return eqAuditsAPI.getEqAudits();
            },
            NCs: function (NCsAPI) {
                return NCsAPI.getNCs();
            },
            ocorrencias: function (ocorrenciasAPI) {
                return ocorrenciasAPI.getOcorrencias();
            }
        }
    });
 
    $routeProvider.when("/editAuditorias/:id", {
        templateUrl: "auditorias/cadAuditorias.html",
        controller : "editAuditoriasCtrl",
        resolve    : {
            auditoria: function (auditoriasAPI, $route) {
                return auditoriasAPI.getAuditoria($route.current.params.id);
            }, 
            certificadoras: function (certificadorasAPI) {
                return certificadorasAPI.getCertificadoras();
            },             
            clientes: function (clientesAPI) {
                return clientesAPI.getClientes();
            }
        }
    });

    $routeProvider.when("/auditoria/:id", {
        templateUrl: "auditorias/auditoria.jsp",
        controller : "AuditoriasAndamCtrl",
        resolve    : {
            auditoria: function (auditoriasAPI, $route) {
                return auditoriasAPI.getAuditoria($route.current.params.id);
            },
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            },
            eqAudits: function (eqAuditsAPI){
                return eqAuditsAPI.getEqAudits();
            },
            certificadoras: function (certificadorasAPI) {
                return certificadorasAPI.getCertificadoras();
            },
            clientes: function (clientesAPI) {
                return clientesAPI.getClientes();
            },
            NCs: function (NCsAPI) {
                return NCsAPI.getNCs();
            },
            ocorrencias: function (ocorrenciasAPI) {
                return ocorrenciasAPI.getOcorrencias();
            }
        }
    });
   
    $routeProvider.when("/deleteAuditoria/:id", {
        templateUrl: "auditorias/listAuditorias.html",
        controller : "listAuditoriasCtrl",
        resolve    : {
            auditoria: function (auditoriasAPI, $route) {
                return auditoriasAPI.deleteAuditoria($route.current.params.id);
            } 
        }
    });


//***********************************************************Checklist
    $routeProvider.when("/checklists", {
        templateUrl: "checklists/listChecklists.html",
        controller : "listChecklistsCtrl",
        resolve    : {
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            }       
        }
    });

    $routeProvider.when("/cadChecklists", {
        templateUrl: "checklists/cadChecklists.html",
        controller : "cadChecklistsCtrl",
        resolve    : {
            auditorias: function (auditoriasAPI){
                return auditoriasAPI.getAuditorias();
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            },
            eqAudits: function (eqAuditsAPI){
                return eqAuditsAPI.getEqAudits();
            }       
        }
    });
    
    $routeProvider.when("/CheckPoint/:id", {
        templateUrl: "checklists/CheckPoint.jsp",
        controller : "CheckPointCtrl",
        resolve    : {
            checklist: function (checklistsAPI, $route) {
                return checklistsAPI.getChecklist($route.current.params.id);
            },
            auditorias: function (auditoriasAPI){
                return auditoriasAPI.getAuditorias();
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            },
            eqAudits: function (eqAuditsAPI){
                return eqAuditsAPI.getEqAudits();
            },
            ocorrencias: function (ocorrenciasAPI) {
                return ocorrenciasAPI.getOcorrencias();
            },
            NCs: function (NCsAPI) {
                return NCsAPI.getNCs();
            } 
        }
    });

    $routeProvider.when("/editChecklists/:id", {
        templateUrl: "checklists/cadChecklists.html",
        controller : "editChecklistsCtrl",
        resolve    : {
            checklist: function (checklistsAPI, $route) {
                return checklistsAPI.getChecklist($route.current.params.id);
            }
        }
    });

    $routeProvider.when("/deleteChecklist/:id", {
        templateUrl: "checklists/listChecklists.html",
        controller : "listChecklistsCtrl",
        resolve    : {
            checklist: function (checklistsAPI, $route) {
                return checklistsAPI.deleteChecklist($route.current.params.id);
            },
            checklists: function (checklistsAPI) {
                return checklistsAPI.getChecklists();
            }
        }
    });
       
            
//*****************************************************************Colaboradores
    $routeProvider.when("/colaboradores", {
        templateUrl: "colaboradores/listColaboradores.html",
        controller : "listColaboradoresCtrl",
        resolve    : {
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            }       
        }
    });    
    
    $routeProvider.when("/cadColaboradores", {
        templateUrl: "colaboradores/cadColaboradores.html",
        controller : "cadColaboradoresCtrl"
    });
 
    $routeProvider.when("/editColaboradores/:id", {
        templateUrl: "colaboradores/cadColaboradores.html",
        controller : "editColaboradoresCtrl",
        resolve    : {
            colaborador: function (colaboradoresAPI, $route) {
                return colaboradoresAPI.getColaborador($route.current.params.id);
            }
        }
    });

    $routeProvider.when("/deleteColaborador/:id", {
        templateUrl: "colaboradores/listColaboradores.html",
        controller : "listColaboradoresCtrl",
        resolve    : {
            colaborador: function (colaboradoresAPI, $route) {
                return colaboradoresAPI.deleteColaborador($route.current.params.id);
            },
            colaboradores: function (colaboradoresAPI){
                return colaboradoresAPI.getColaboradores();
            } 
        }
    });
        
        
//********************************************final        
        
$routeProvider.otherwise({redirectTo: "/"});
});
