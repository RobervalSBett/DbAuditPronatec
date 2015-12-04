package com.cortez.samples.javaee7angular.rest;
import com.cortez.samples.javaee7angular.data.Clientes;
import com.cortez.samples.javaee7angular.pagination.PaginatedListWrapper;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource 
{
  private EntityManager entityManager ;

    public ClienteResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

  
    private Integer countClientes() {
        Query query = entityManager.createQuery("SELECT COUNT(cli.id) FROM Clientes cli");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Clientes> findClientes(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT cli FROM Clientes cli ORDER BY cli." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findClientes(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countClientes());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findClientes(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listClientes(@DefaultValue("1")
                                            @QueryParam("page")
                                            Integer page,
                                            @DefaultValue("id")
                                            @QueryParam("sortFields")
                                            String sortFields,
                                            @DefaultValue("asc")
                                            @QueryParam("sortDirections")
                                            String sortDirections) {
        PaginatedListWrapper paginatedListWrapper = new PaginatedListWrapper();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(10);
        return findClientes(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Clientes getClientes(@PathParam("id") Long id) {
        return entityManager.find(Clientes.class, id);
    }

    @POST
    public Clientes saveClientes(Clientes cliente) {
        entityManager.getTransaction().begin();
        if (cliente.getIdcli()== null) {
            Clientes clienteToSave = new Clientes();            
            clienteToSave.setIdcep(cliente.getIdcep());
            clienteToSave.setRazaocli(cliente.getRazaocli());
            clienteToSave.setFantacli(cliente.getFantacli());
            clienteToSave.setCompleendcli(cliente.getCompleendcli());
            clienteToSave.setFone1cli(cliente.getFone1cli());
            clienteToSave.setFone2cli(cliente.getFone2cli());
            clienteToSave.setEmailcli(cliente.getEmailcli());
            clienteToSave.setSitecli(cliente.getSitecli());
            clienteToSave.setContatocli(cliente.getContatocli());
            clienteToSave.setEmailcontato(cliente.getEmailcontato());
            clienteToSave.setCnpjcli(cliente.getCnpjcli());
            clienteToSave.setInscricli(cliente.getInscricli());
            clienteToSave.setObscli(cliente.getObscli());
            clienteToSave.setStatuscli(cliente.getStatuscli());
            entityManager.persist(cliente);
        } else {
            Clientes clienteToUpdate = getClientes(cliente.getIdcli());
            clienteToUpdate.setIdcep(cliente.getIdcep());
            clienteToUpdate.setRazaocli(cliente.getRazaocli());
            clienteToUpdate.setFantacli(cliente.getFantacli());
            clienteToUpdate.setCompleendcli(cliente.getCompleendcli());
            clienteToUpdate.setFone1cli(cliente.getFone1cli());
            clienteToUpdate.setFone2cli(cliente.getFone2cli());
            clienteToUpdate.setEmailcli(cliente.getEmailcli());
            clienteToUpdate.setSitecli(cliente.getSitecli());
            clienteToUpdate.setContatocli(cliente.getContatocli());
            clienteToUpdate.setEmailcontato(cliente.getEmailcontato());
            clienteToUpdate.setCnpjcli(cliente.getCnpjcli());
            clienteToUpdate.setInscricli(cliente.getInscricli());
            clienteToUpdate.setObscli(cliente.getObscli());
            clienteToUpdate.setStatuscli(cliente.getStatuscli());
            cliente = entityManager.merge(clienteToUpdate);
        }
        entityManager.getTransaction().commit();
        return cliente;
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getClientes(id));
        entityManager.getTransaction().commit();
    }   
      
}

