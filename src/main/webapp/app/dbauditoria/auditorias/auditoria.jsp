<div id="page-wrapper"><br>
	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h4> auditoria <b style="color: red;font-size: 23px;">{{auditoria.idaudit}}</b> em andamento </h4>   
				</div><br>
				<div class="container-fluid" style="text-align: center;">

					<form name="auditoriasForm"  id="formAu">

						<div class="row"><p> 
<!--*************************************************************Certificadoras-->
							<div class="col-md-6"> 
								<div class="panel panel-green">
									<div class="panel-heading">
										empresas certificadoras
									</div>

									<div class="panel-body">
										<div class="col-lg-3"> 
											<label>codigo</label>   
											<input class="form-control" type="number" ng-model="auditoria.certificadora.idcert" name="certi" placeholder="Codigo Certificadora"  ng-required="true" disabled=""/>
										</div>
										<div class="col-lg-9">  
											<label>nome fantasia</label>  
											<input class="form-control" type="text" ng-model="auditoria.certificadora.fantacert" name="certi" placeholder="Nome Certificadora"  ng-required="true" disabled="" /> 
										</div>

										<div ng-show="auditoriasForm.certi.$dirty" ng-messages="auditoriasForm.certi.$error">
											<div ng-message="required" class="alert alert-danger">
												Por favor, preencha o campo codigo da certificadora.
											</div>
										</div>

										<div name="certi" class="col-lg-12">
											<select class="form-control" ng-model="auditoria.certificadora" ng-options="certificadora.fantacert + ' ( ' + (certificadora.idcert) + ' )' for certificadora in certificadoras">
												<option value="">lista de certificadoras</option>
											</select>
										</div><br>
										<div><a class="btn btn-outline btn-success  btn-sm glyphicon glyphicon-pencil" name="salvar" href="#/cadCerts"> nova certificadora</a>
										</div>
									</div><br>
								</div>
							</div> 

<!--*************************************************************Clientes-->
							<div class="col-lg-6"> 
								<div class="panel panel-green">
									<div class="panel-heading">
										empresas clientes
									</div>

									<div class="panel-body">
										<div class="col-lg-3">
											<label>clientes</label>  
											<input class="form-control" type="number" ng-model="auditoria.idcli.idcli" name="clie" placeholder="Codigo Cliente"  ng-required="true"  disabled=""/> 
										</div>
										<div class="col-lg-9">  
											<label>nome fantasia</label> 
											<input class="form-control" type="text" ng-model="auditoria.idcli.fantacli" name="cli" placeholder="Nome"  ng-required="true" disabled=""/> 
										</div>

										<div ng-show="auditoriasForm.clie.$dirty" ng-messages="auditoriasForm.clie.$error">
											<div ng-message="required" class="alert alert-danger">
												Por favor, preencha o campo codigo do(a) cliente.
											</div>                              
										</div>

										<div class="col-lg-12">
											<select  name="clie" class="form-control" ng-model="auditoria.idcli" ng-options="idcli.fantacli + ' ( ' + (idcli.idcli) + ' )' for idcli  in clientes | orderBy:'idcli'">
												<option value="">lista de clientes</option>
											</select>
										</div>   
										<div>
											<a class="btn btn-outline btn-success  btn-sm glyphicon glyphicon-pencil" name="salvar" href="#/CadClientes"> novo cliente</a>
										</div>
									</div><br>
								</div>
							</div><p>
						</div><p> 


<!-- ***************************************************************************dados Auditorias -->            
						<div class="row"><p>       
							<div class="col-lg-12"> 
								<div class="panel panel-green">
									<div class="panel-heading">
										dados da auditoria
									</div>
									<div class="panel-body">
										<div class="panel-collapse">
										<input class="form-control" type="hidden" ng-model="auditoria.descriaudit" id="desc" name="descr" placeholder="Descrição Auditoria" 
											ng-required="true" ng-minlength="1" ng-maxlength="400"/>

											<div  class="col-lg-12"> 
												<label>descrição da auditoria</label>
												<textarea class="form-control" pattern="[A-Za-z]++"  type="text" ng-model="auditoria.descriaudit " name="descr"  placeholder="Descrição....." ng-required="true" required="" ng-minlength="10" ng-maxlength="500"></textarea>
											</div>

<!--************************************************  Validadção dos campos *****************************************-->
											<div ng-show="auditoriasForm.descr.$dirty" ng-messages="auditoriasForm.descr.$error">
												<div ng-message="required" class="alert alert-danger">
													Por favor, preencha o campo descrição.
												</div>
												<div ng-message="minlength" class="alert alert-danger">
													O campo descrição deve ter no minimo 10 caracteres.
												</div>
												<div ng-message="maxlength" class="alert alert-danger">
													O campo descrição deve ter no máximo 500 caracteres.
												</div>
											</div><br>
										</div>
									</div> 

									<div class="panel-body">
										<div class="panel-collapse">
										<input class="form-control" iu-date type="hidden" ng-model="auditoria.descriobjaudit" name="obj"  placeholder="Objetivo...." ng-required="true" ng-minlength="1" ng-maxlength="500"/>
											<div class="col-lg-12">
												<label>objetivo da auditoria</label>
												<textarea class="form-control" iu-date type="text" ng-model="auditoria.descriobjaudit" name="obj"  placeholder="Objetivo Auditoria" ng-required="true" ng-minlength="10" ng-maxlength="400"/></textarea> 
											</div>

<!--************************************************  Validadção dos campos *****************************************-->
											<div ng-show="auditoriasForm.obj.$dirty" ng-messages="auditoriasForm.obj.$error">
												<div ng-message="required" class="alert alert-danger">
													Por favor, preencha o campo objetivo.
												</div>
												<div ng-message="minlength" class="alert alert-danger">
													O campo objetivo deve ter no minimo 10 caracteres.
												</div>
												<div ng-message="maxlength" class="alert alert-danger">
													O campo objetivo deve ter no máximo 500 caracteres.
												</div>
											</div> 
										</div> 
									</div>

									<div class="panel-body">
										<div class="panel-collapse"> 
											<!--<div class="col-lg-4"> 
												<label>tipo auditoria</label> 
												<input class="form-control"  type="text" ng-model="auditoria.tipoaudit" name="tipo"  placeholder="tipo...." ng-required="true" disabled=""/>
											</div>
											<div ng-show="auditoriasForm.tipo.$dirty" ng-messages="auditoriasForm.tipo.$error">
												<div ng-message="required" class="alert alert-danger">
													Por favor, preencha o campo tipo de auditoria
												</div>
											</div>-->
											<div class="col-lg-12"><br>
												<label>tipo auditoria</label> 
												<select class="form-control" ng-model="auditoria.tipoaudit">
													<option>selecione..</option>
													<option value="I">Interno</option>
													<option value="E">Externo</option>
												</select>
											</div><br>
										</div>
									</div><br>
								</div>
							</div>  
						</div><p>


<!-- ***************************************************************************data e hora -->
						<div class="row"><p>
							<div class="col-md-4">
								<div class="panel panel-green">
									<div class="panel-heading">
										Data do cadastro
									</div>
									<div class="panel-body" style="text-align: center;"><p>
										<div class="col-lg-12">
						 				<input class="form-control" placeholder="DD/MM/AAAA HH:MM:SS" type="text" ng-model="auditoria.dthrcadaudit" name="dthrcad" ng-required="true" ng-minlength="19" ng-maxlength="19"/>
										</div>
										<div ng-show="auditoriasForm.dthrcad.$dirty" ng-messages="auditoriasForm.dthrcad.$error">
											<div ng-message="required" class="alert alert-danger">
												Por favor, preencha o campo data / hora do cadastro da auditoria!
											</div>
											<div ng-message="minlength" class="alert alert-danger">
												O formato DD/MM/AAAA HH:MM:SS.
											</div>
											<div ng-message="maxlength" class="alert alert-danger">
												O formato DD/MM/AAAA HH:MM:SS.
											</div>
										</div>   
										<a class="btn btn-outline btn-danger  btn-sm glyphicon glyphicon-calendar" name="salvar"></a>
									</div><br>
								</div>
							</div>

							<div class="col-md-4">
								<div class="panel panel-green">
									<div class="panel-heading">
										data inicial da auditoria
									</div>
									<div class="panel-body" style="text-align: center;"> <p>
										<div class="col-lg-12"> 
										<input class="form-control" placeholder="DD/MM/AAAA HH:MM:SS" type="text" ng-model="auditoria.dthriniaudit" name="dthrinic" ng-minlength="19" ng-maxlength="19"/>
										</div>
										<div ng-show="auditoriasForm.dthrinic.$dirty" ng-messages="auditoriasForm.dthrinic.$error">
											<div ng-message="minlength" class="alert alert-danger">
												O formato DD/MM/AAAA HH:MM:SS.
											</div>
											<div ng-message="maxlength" class="alert alert-danger">
												O formato DD/MM/AAAA HH:MM:SS.
											</div>
										</div>                        
										<a class="btn btn-outline btn-danger  btn-sm glyphicon glyphicon-calendar" name="salvar"> </a>
									</div><br>
								</div>
							</div>

							<div class="col-md-4"> 
								<div class="panel panel-green">
									<div class="panel-heading">
										data da realização 
									</div>
									<div class="panel-body" style="text-align: center;"><p>
										<div class="col-lg-12">
						 				<input class="form-control" placeholder="DD/MM/AAAA HH:MM:SS" type="text" ng-model="auditoria.dthrrealiaudit" name="dthrrealiz" ng-minlength="19" ng-maxlength="19"/>
										</div>
										<div ng-show="auditoriasForm.dthrrealiz.$dirty" ng-messages="auditoriasForm.dthrrealiz.$error">
											<div ng-message="minlength" class="alert alert-danger">
												O formato DD/MM/AAAA HH:MM:SS.
											</div>
											<div ng-message="maxlength" class="alert alert-danger">
												O formato DD/MM/AAAA HH:MM:SS.
											</div>
										</div>     
										<a class="btn btn-outline btn-danger  btn-sm glyphicon glyphicon-calendar" name="salvar"> </a>
									</div><br>
								</div><p>
							</div><p> 

<!--********************************************************************Observação-->            
							<div class="col-lg-12"><p>
								<div class="panel panel-green">
									<div class="panel-heading">
										observação
									</div>
									<div class="panel-body"><p>
										<div class="col-lg-12">
											<textarea  ng-model="auditoria.obsaudit" name="obs" class="form-control" rows="3"></textarea><br>
											<input class="form-control" type="hidden" ng-model="auditoria.statusaudit" name="status" placeholder="Status" />      
										</div>
									</div>
								</div>
							</div>                                   
						</div><p>

<!--************************************************Equipe de Auditores-->
						<div class="row"> <p> 
							<div class="col-md-12"> 
								<div class="panel panel-red">
									<div class="panel-heading">
										auditores
									</div><p>
									<div class="panel-body">    
										<div class="container-fluid">
										<input class="form-control" type="text" ng-model="criterioDeBusca" placeholder="Pesquisar.."/>
											<div class="tab-content">
												<div class="tab-pane fade in active" id="home-pills">
													<div class="panel-body">
														<div class="table-responsive" style="text-align: center;">

															<!--tabela-->
															<table ng-show="eqAudits.length > 0" class="table table-xs btn-xs table-striped table-bordered table-responsive table-hover" style="text-align: center;">
																<tr> 
																	<td><b>equipe</b></td>
																	<td><b>auditoria</b></td>                          
																	<td><b><a href="" ng-click="ordenarPor('tipoauditor')">tipo Auditoria</a> <i class="fa fa-sort"></i></b></td>
																	<td><b>auditor 1</b></td>
																	<td><b>auditor 2</b></td>
																	<td><b>data de formação Equipe</b></td>
																	<td><b><a href="" ng-click="ordenarPor('statusequipe')">status</a> <i class="fa fa-sort"></i></b></td>  
																	<td><b>editar</b></td>
																	<td><b>excluir</b></td>
																</tr>
																<tr ng-class="{'selecionado negrito': eqAudit.selecionado}" ng-repeat="eqAudit in eqAudits | filter:criterioDeBusca | orderBy:criterioDeOrdenacao:direcaoDaOrdenacao">                  
																	<td> {{eqAudit.idequipe }} </td>
																	<td> {{eqAudit.idaudit.idaudit }} </td>
																	<td> {{eqAudit.tipoauditor | uppercase}} </td>
																	<td> {{eqAudit.idauditor.nomeaudit }} </td>
																	<td> {{eqAudit.idauditor2.nomeaudit }} </td>
																	<td> {{eqAudit.dthrincequipe}} </td>   
																	<td> {{eqAudit.statusequipe}} </td>
																	<td> <a href="#/editEqAudits/{{eqAudit.idequipe}}" class="btn btn-outline btn-warning btn-xs glyphicon glyphicon-edit"></a> </td>
																	<td> <a href="#/deleteEqAudit/{{eqAudit.idequipe}}" class="btn btn-outline btn-danger  btn-xs glyphicon glyphicon-remove"></a></td>
																</tr>
															</table>
															<div><a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-plus" name="equipe" href="#/cadEqAudits"> nova equipe</a>
																<a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-search" name="equipe" href="#/eqAudits"> todas equipes</a><br>
															</div><p>
														</div><br>       
													</div>
												</div>
											</div>                    
										</div>
									</div> 
								</div>   
							</div><p>
						</div><p>

<!--************************************************ *CheckPoint-->
						<div class="row"> <p> 
							<div class="col-lg-12"> 
								<div class="panel panel-red">
									<div class="panel-heading">
										checklist
									</div><p>
									<div class="panel-body">
										<div class="container-fluid">
										<input class="form-control" type="text" ng-model="criterioDeBusca" placeholder="Pesquisar.."/>
											<div class="tab-content">
												<div class="tab-pane fade in active">
													<div class="panel-body">
														<div class="table-responsive" style="text-align: center;">

															<!--tabela-->          
															<table ng-show="checklists.length > 0" style="text-align: center;" class="table table-xs btn-xs table-striped table-bordered table-responsive table-hover" id="dataTables-example">  
																<tr>  
																	<td><b>abrir</b></td>
																	<td><b>checkPoint</b></td>
																	<td><b>auditoria</b></td>
																	<td><a href="" ng-click="ordenarPor('descrichklist')"><b>descrição</b> <i class="fa fa-sort"></i></a></td>                     
																	<td><b>data da realização</b></td>   
																	<td><a href="" ng-click="ordenarPor('statuschklist')"><b>status</b> <i class="fa fa-sort"></i></a></td>                                           
																	<td><b>excluir</b></td>
																</tr>
																<tr ng-class="{'selecionado negrito': checklist.selecionado}" ng-repeat="checklist in checklists | filter:criterioDeBusca | orderBy:criterioDeOrdenacao:direcaoDaOrdenacao">
																	<td><a href="#/CheckPoint/{{checklist.idpontoctrl}}"> <i class="btn btn-success btn-outline  btn-xs  fa fa-folder-open" title="Click para abrir CheckPoint"></i></a></td>             
																	<td>{{checklist.idpontoctrl}}</td>
																	<td>{{checklist.idaudit.idaudit}}</td>
																	<td><a href="" title="{{checklist.descrichklist | name}}" style="color: #4cae4c;"> <i class="btn btn-info btn-outline btn-xs fa fa-external-link"></i></a></td>
																	<td>{{checklist.dthrrealichklist}}</td>                      
																	<td>{{checklist.statuschklist}}</td>
																	<td><a href="#/deleteChecklist/{{checklist.idpontoctrl}}" ng-click="deleteChecklist(checklists)" class="btn btn-outline btn-danger btn-xs glyphicon glyphicon-remove"></a></td> 
																</tr>
															</table> 
															<div><a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-plus" name="checkPoint" href="#/cadChecklists"> novo checkpoint</a>
																<a class="btn btn-outline btn-success  btn-xs glyphicon glyphicon-search" name="checkPoints" href="#/checklists"> todos checkpoints</a><br>
															</div><p>                
														</div><p>     
													</div>
												</div>
											</div>                    
										</div>              
									</div>
								</div>
							</div>
						</div><p>

					</form>  

					<hr>

					<!--botoes--> 
					<div>
						<a class="btn btn-outline  btn-lg  btn-primary glyphicon glyphicon-floppy-save" ng-click="(auditoria.statusaudit ='A');adicionarAuditoria(auditoria)" ng-disabled="auditoriasForm.$invalid"> salvar</a>
						<a href="#/auditorias" class="btn btn-lg btn-outline btn-danger glyphicon glyphicon-remove"> cancelar</a>   
					</div> 
				</div><br>
			</div>
		</div>              
		<div ng-include="'footer.html'"></div>            
	</div>         
</div>   