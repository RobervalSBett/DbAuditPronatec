<div id="page-wrapper">     <br>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h4>auditando checkpoint: <b style="color: red;font-size: 23px;">{{checklist.idpontoctrl}}</b> </h4>   
				</div><br>
				<div class="container-fluid" style="text-align: center;">

					<!--formulario-->  
					<form name="checkForm">	

<!--******************************************************************* auditorias-->
						<div class="row"><p>   
							<div class="col-lg-12"> 
								<div class="panel panel-green">
									<div class="panel-heading">
										auditorias
									</div> 
									<div class="panel-body"> 
										<div class="col-lg-4">
											<label>auditoria</label>
											<input class="form-control" type="number" ng-model="checklist.idaudit.idaudit" name="audit" placeholder="Codigo da Auditoria" ng-required="true"/><br>
										</div> 
										<div ng-show="checkForm.audit.$dirty" ng-messages="EquipeAuditoresForm.audit.$error">
											<div ng-message="required" class="alert alert-danger">
												Por favor, preencha o campo codigo da auditoria.
											</div>                              
										</div>  
										<div class="container-fluid">
											<div>
												<input class="form-control fa fa-search" type="text" ng-model="criterioDeBusca" placeholder="Pesquisar.."/>
											</div>
											<div class="tab-content">
												<div class="tab-pane fade in active"> 
													<div class="panel-body">
														<div class="table-responsive" style="text-align: center;">
															<table style="text-align: center;" ng-show="auditorias.length > 0" class="table table-xs btn-xs table-striped table-bordered table-responsive table-hover"  >		
																<tr>   
																	<td><a href="" ng-click="ordenarPor('idaudit')"><b>auditoria</b>  <i class="fa fa-sort"></i></a></td>                        
																	<td><a href="" ng-click="ordenarPor('descriaudit')"><b>descrição</b>  <i class="fa fa-sort"></i></a></td> 
																	<td><a href="" ng-click="ordenarPor('certificadora.fantacert')"><b>certificadora</b> <i class="fa fa-sort"></i></a></td> 
																	<td><a href="" ng-click="ordenarPor('idcli.fantacli')"><b>cliente </b> <i class="fa fa-sort"></i></a></td>
																	<td title="Data e Hora do cadastro da Auditoria"><b>cadastro da auditoria</b></td>  
																	<td><a href="" ng-click="ordenarPor('statusaudit')"><b>status </b> <i class="fa fa-sort"></i></a></td>     
																</tr>
																<tr ng-class="{'selecionado negrito': auditoria.selecionado}" ng-repeat="auditoria in auditorias | filter:criterioDeBusca | orderBy:criterioDeOrdenacao:direcaoDaOrdenacao"> 
																	<td><a href="#/auditoria/{{auditoria.idaudit}}"><b title="Click para Abrir">{{auditoria.idaudit}}</b></a></td>         
																	<td><a href="" title="{{auditoria.descriaudit}}" style="color: #4cae4c;"> <i class="btn btn-info btn-outline btn-xs fa fa-external-link"></i></a></td>
																	<td>{{auditoria.certificadora.fantacert| uppercase }}</td>
																	<td>{{auditoria.idcli.fantacli | uppercase}}</td> 
																	<td>{{auditoria.dthrcadaudit | date:'dd/MM/yyyy HH:mm:ss' }}</td>   
																	<td>{{auditoria.statusaudit}}</td> 
																</tr>                        
															</table> 
														</div><br>       
													</div> 
												</div>
											</div>                    
										</div>       
									</div>
								</div>
							</div>
						</div><p> 

<!-- *************************************************************************** dados auditorias -->            
						<div class="row"><p>       
							<div class="col-lg-12"> 
								<div class="panel panel-green">
									<div class="panel-heading">
										dados da checkpoint
									</div>

									<div class="panel-body">
										<div class="panel-collapse">
										<input class="form-control" type="hidden" ng-model="checklist.descrichklist" id="desc" name="descr" placeholder="Descrição CheckPoint" 
											ng-required="true" ng-minlength="1" ng-maxlength="400"/>

											<div  class="col-lg-12">
												<label>descrição checkpoint</label>  
												<textarea class="form-control" pattern="[A-Za-z]++"  type="text" ng-model="checklist.descrichklist" name="descr"  placeholder="Descrição....." ng-required="true" required="" ng-minlength="10" ng-maxlength="500"></textarea> 
											</div>

<!--************************************************  validadção dos campos *****************************************-->
											<div ng-show="checkForm.descr.$dirty" ng-messages="checkForm.descr.$error">
												<div ng-message="required" class="alert alert-danger">
													Por favor, preencha o campo descrição.
												</div>
												<div ng-message="minlength" class="alert alert-danger">
													O campo Descrição deve ter no minimo 10 caracteres.
												</div>
												<div ng-message="maxlength" class="alert alert-danger">
													O campo Descriçãos deve ter no maximo 500 caracteres.
												</div>
											</div><br>
										</div>
									</div> 

									<div class="panel-body">
										<div class="panel-collapse">
											<div  class="col-lg-12">
												<label>N° do documento do processo</label>
												<input class="form-control"  type="number" ng-model="checklist.docprocesso" name="docP"  placeholder="N° do Documento.... " ng-required="true" ng-minlength="1" ng-maxlength="12"/>
											</div>

<!--**************************** validadção dos campos *****************************************-->
											<div ng-show="checkForm.docP.$dirty" ng-messages="checkForm.docP.$error">
												<div ng-message="required" class="alert alert-danger">
													Por favor, preencha o campo objetivo.
												</div>
												<div ng-message="minlength" class="alert alert-danger">
													O campo Objetivo deve ter no minimo 10 caracteres.
												</div>
												<div ng-message="maxlength" class="alert alert-danger">
													O campo Objetivo deve ter no maximo12 caracteres.
												</div>
											</div><br> 
										</div>
									</div><br>
								</div>
							</div><br>  
						</div><p>


<!--**************************************************************************** equipe de auditores-->
						<div class="row"><p>       
							<div class="col-lg-12"> 
								<div class="panel panel-green">
									<div class="panel-heading">
										equipe de auditores
									</div> 
									<div class="panel-body">
										<div class="col-lg-4"> 
											<label>equipe</label> 
											<input class="form-control"  type="number" ng-model="checklist.idequipe.idequipe" name="equA" placeholder="Codigo Equipe de Auditores" ng-required="true"/><br>
										</div> 
										<div ng-show="checkForm.equA.$dirty" ng-messages="checkForm.equA.$error">
											<div ng-message="required" class="alert alert-danger">
												Por favor, preencha o campo codigo da auditoria.
											</div>                              
										</div>  
										<div class="container-fluid">
											<div>
												<input class="form-control fa fa-search" type="text" ng-model="criterioDeBusca" placeholder="Pesquisar.."/>
											</div>
											<div class="tab-content">
												<div class="tab-pane fade in active" > 
													<div class="panel-body">
														<div class="table-responsive" style="text-align: center;" >
															<table style="text-align: center;" ng-show="eqAudits.length > 0" class="table table-xs btn-xs table-striped table-bordered table-responsive table-hover"  >		
																<tr> 
																	<td><b>equipe</b></td>  
																	<td><b>auditoria</b></td>                          
																	<td><b><a href="" ng-click="ordenarPor('tipoauditor')">tipo equipe''</a> <i class="fa fa-sort"></i></b></td>
																	<td><b>auditor 1</b></td>
																	<td><b>auditor 2</b></td>
																	<td><b>data de formação da equipe</b></td>  
																	<td><b><a href="" ng-click="ordenarPor('statusequipe')">status</a> <i class="fa fa-sort"></i></b></td>  
																	<td><b>editar </b></td>
																	<td><b>excluir </b></td>
																</tr>
																<tr ng-class="{'selecionado negrito': eqAudit.selecionado}" ng-repeat="eqAudit in eqAudits | filter:criterioDeBusca | orderBy:criterioDeOrdenacao:direcaoDaOrdenacao">                  
																	<td> {{eqAudit.idequipe }} </td>
																	<td> {{eqAudit.idaudit.idaudit }} </td>
																	<td> {{eqAudit.tipoauditor | uppercase}} </td>
																	<td> {{eqAudit.idauditor.nomeaudit }} </td>
																	<td> {{eqAudit.idauditor2.nomeaudit }} </td>
																	<td> {{eqAudit.dthrincequipe}} </td> 
																	<td> {{eqAudit.statusequipe}} </td>
																	<td> <a href="#/editEqAudits/{{eqAudit.idequipe}}" class="btn btn-outline btn-warning btn-xs glyphicon glyphicon-edit"></a></td>
																	<td> <a href="#/deleteEqAudit/{{eqAudit.idequipe}}" class="btn btn-outline btn-danger  btn-xs glyphicon glyphicon-remove"></a></td>
																</tr>                      
															</table> 
														</div><br>       
													</div> 
												</div>
											</div>                    
										</div>       
									</div>
								</div>
							</div>
						</div><p>



						<div class="row"><p>
							<div class="col-md-4"><!--***************************** colaboradores --> 
								<div class="panel panel-green">
									<div class="panel-heading">
										colaboradores
									</div>

									<div class="panel-body">
										<div class="col-lg-3">
									    	<label>codigo</label>
									      	<input class="form-control" type="number" ng-model="checklist.idcola.idcola" name="certi" placeholder="Codigo Colaborador"  ng-required="true" disabled=""/> 
									    </div>
										<div class="col-lg-9"> 
									 		<label>nome </label> 
									    	<input class="form-control" type="text" ng-model="checklist.idcola.nomecola" name="certi" placeholder="Nome"  ng-required="true" disabled=""/> 
									  	</div>

										<div ng-show="checkForm.certi.$dirty" ng-messages="auditoriasForm.certi.$error">
											<div ng-message="required" class="alert alert-danger">
												Por favor, preencha o campo.
											</div>
										</div>

										<div class="col-lg-12">
											<select name="certi"  class="form-control" ng-model="checklist.idcola" ng-options="idcola.nomecola + ' ( ' + (idcola.idcola) + ' )' for idcola in colaboradores">
												<option value="">lista de colaboradores</option>
											</select>
										</div>
										<hr>
										<div>
											<a class="btn btn-outline btn-success  btn-sm glyphicon glyphicon-pencil" name="salvar" href="#/cadCerts"> nova certificadora</a>
										</div>
									</div><br>
								</div>
							</div>      

							<div class="col-md-4"> <!--***************************** data realização --> 
								<div class="panel panel-green">
									<div class="panel-heading">
										data da realização 
									</div>
									<div class="panel-body" style="text-align: center;"><p>
										<div class="col-lg-12">
									 		<input class="form-control" placeholder="DD/MM/AAAA HH:MM:SS" type="text" ng-model="checklist.dthrrealichklist" name="dthrrealiz" ng-required="true" ng-minlength="19"/>
										</div>
										<div ng-show="checkForm.dthrrealiz.$dirty" ng-messages="checkForm.dthrrealiz.$error">
											<div ng-message="required" class="alert alert-danger">
												Por favor, preencha o campo data / hora cadastro da auditoria!
											</div>
											<div ng-message="minlength" class="alert alert-danger">
												O formato DD/MM/AAAA HH:MM:SS.
											</div>
										</div>     
										<a class="btn btn-outline btn-danger  btn-sm glyphicon glyphicon-calendar"></a>
									</div><p>
								</div><p>
							</div><p>


							<div  class="col-lg-4">
								<label>N° do documento do processo</label>
								<input class="form-control"  type="number" ng-model="checklist.docprocesso" name="docP"  placeholder="N° do Documento.... " ng-required="true" ng-minlength="1" ng-maxlength="12"/>
							</div>

<!--**************************** validadção dos campos *****************************************-->
							<div ng-show="checkForm.docP.$dirty" ng-messages="checkForm.docP.$error">
								<div ng-message="required" class="alert alert-danger">
									Por favor, preencha o campo objetivo.
								</div>
								<div ng-message="minlength" class="alert alert-danger">
									O campo Objetivo deve ter no minimo 10 caracteres.
								</div>
								<div ng-message="maxlength" class="alert alert-danger">
									O campo Objetivo deve ter no maximo12 caracteres.
								</div>
							</div><br> 
								

							<div class="col-lg-12"><p><!--***************************** observação --> 
								<div class="panel panel-green">
									<div class="panel-heading">
										observação
									</div>
									<div class="panel-body"> <p>
										<div class="col-lg-12"> 
											<textarea  ng-model="checklist.obschklist" name="obs" class="form-control" rows="3"></textarea><br>
										</div>
									</div>
								</div><br>
							</div>          
						</div><p>


	<!--**************************************************************************** ocorrencias-->
						<div class="row"> <p> 
							<div class="col-lg-12"> 
								<div class="panel panel-red">
									<div class="panel-heading">
										ocorrencias
									</div><p>
									<div class="panel-body">
										<div class="container-fluid">
										<input class="form-control" type="text" ng-model="criterioDeBusca" placeholder="Pesquisar por ocorrencia.."/>
											<div class="tab-content">
												<div class="tab-pane fade in active"  >
													<div class="panel-body">
														<div class="table-responsive" style="text-align: center;">

															<!--tabela-->    
															<table ng-show="ocorrencias.length > 0" class="table table-xs btn-xs table-striped table-bordered table-responsive table-hover" style="text-align: center;">
																<tr> 
																	<td><b>Abrir</b></td> 
																	<td><b>Ocorrencia</b></td>
																	<td><b><a href="" ng-click="ordenarPor('idpontoctrl.idpontoctrl')">checkPoint <i class="fa fa-sort"></i></a></b></td>
																	<td><b><a href="" ng-click="ordenarPor('descriocorre')">descrição <i class="fa fa-sort"></i></a></b></td>
																	<td><b>Colaboradores</b></td>
																	<td><b>Data da Ocorrecia</b></td>			
																	<td><b><a href="" ng-click="ordenarPor('statusocorre')">status <i class="fa fa-sort"></i></a></b></td>
																	<td><b>excluir</b></td>
																</tr>
																<tr ng-class="{'selecionado negrito': ocorrencia.selecionado}" ng-repeat="ocorrencia in ocorrencias | filter:criterioDeBusca | orderBy:criterioDeOrdenacao:direcaoDaOrdenacao">           
																	<td><a href="#/editOcorrencias/{{ocorrencia.idocorre}}"> <i  class="btn btn-success btn-outline  btn-xs  fa fa-folder-open " title="Click para abrir Ocorrencia"></i></a></td>             
																	<td>{{ocorrencia.idocorre}}</td>  
																	<td>{{ocorrencia.idpontoctrl.idpontoctrl}}</td>
																	<td>{{ocorrencia.descriocorre | uppercase}}</td> 
																	<td>{{ocorrencia.idcola.nomecola}}</td>
																	<td>{{ocorrencia.dthrocorre  |  date:'dd/MM/yyyy HH:mm:ss'}}</td>			
																	<td>{{ocorrencia.statusocorre | uppercase}}</td>
																<td style="text-align: center;"><a href="#/deleteOcorrencia/{{ocorrencia.idocorre}}" class="btn btn-outline btn-danger  btn-xs glyphicon glyphicon-remove"></a></td>
																</tr>
															</table><br>
															<div>
																<a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-plus" name="ocorrencia" href="#/cadOcorrencias"> nova ocorrencia</a>
																<a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-search" name="ocorrencia" href="#/ocorrencias"> todas ocorrencias</a><br>
															</div><p> 
														</div>       
													</div><br> 
												</div>
											</div>                    
										</div>   
									</div>
								</div>
							</div>
						</div><p>


	<!--********************************************************** nao conformidades*****-->
						<div class="row"><p>  
							<div class="col-lg-12"> 
								<div class="panel panel-red">
									<div class="panel-heading">
										não conformidades
									</div><p>
									<div class="panel-body">
										<div class="container-fluid"> 
										<input class="form-control" type="text" ng-model="criterioDeBusca" placeholder="Pesquisar por Descrição da nc.."/>
											<div class="tab-content">
												<div class="tab-pane fade in active">
													<div class="panel-body">
														<div class="table-responsive" style="text-align: center;"> 

															<!--tabela-->
															<table ng-show="NCs.length > 0" style="text-align: center;" class="table table-xs btn-xs table-striped table-bordered table-responsive table-hover">
																<tr>
																	<td><b>abrir</b></td>
																	<td><b>não confor.</b></td>
																	<td><b>checkpoints</b></td>
																	<td><b><a href="" ng-click="ordenarPor('descrinc')"><b>descrição</b> <i class="fa fa-sort"></i></a></td>
																	<td><b>colaborador</b></td> 
																	<td><b>dt/hr do cadastro</b></td>  
																	<td><a href="" ng-click="ordenarPor('statusNc')"><b>status</b> <i class="fa fa-sort"></i></a></td>
																	<td><b>excluir</b></td>
																</tr>
																<tr ng-class="{'Selecionado negrito': nc.selecionado}" ng-repeat="nc in NCs | filter:criterioDeBusca | orderBy:criterioDeOrdenacao:direcaoDaOrdenacao">
																	<td><a href="#/editNCs/{{nc.idnc}}"> <i class="btn btn-success btn-outline  btn-xs  fa fa-folder-open " title="Click para abrir Não Conformidade"></i></a></td>                                           
																	<td>{{nc.idnc}}</td>
																	<td>{{nc.idpontoctrl.idpontoctrl}}</td>
																	<td>{{nc.descrinc | uppercase}}</td>
																	<td>{{nc.idcola.nomecola}}</td> 
																	<td>{{nc.dthrcadnc | date:'dd/MM/yyyy HH:mm'}}</td>  
																	<td>{{nc.statusnc}}</td> 
																	<td><a href="#/deleteNC/{{nc.idnc}}" ng-click="deleteNC (NCs)" class="btn btn-outline btn-danger  btn-xs glyphicon glyphicon-remove"></a></td>
																</tr>
															</table><br>
															<div>
																<a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-plus" name="cadNC" href="#/cadNCs"> nova não conformidade</a>
																<a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-search" name="NCs" href="#/NCs"> todas não conformidade</a><br>
															</div><p> 
														</div>        
													</div><br> 
												</div>
											</div>                    
										</div>   
									</div>
								</div>
							</div>
						</div><p>
					</form>             

					<!--botoes-->
					<div>
						<a class="btn btn-outline  btn-lg  btn-primary glyphicon glyphicon-floppy-save" ng-click="adicionarChecklist(checklist)" ng-disabled="checkForm.$invalid"> salvar</a>
						<a href="#/checklists" class="btn btn-lg btn-outline btn-danger glyphicon glyphicon-remove"> cancelar</a>
					</div> 
				</div><br><br>
			</div><br>
			<div ng-include="'footer.html'"></div>
		</div>
	</div>
</div> 