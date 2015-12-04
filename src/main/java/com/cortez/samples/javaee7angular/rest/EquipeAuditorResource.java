
package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.EquipeAuditores;
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
public class EquipeAuditorResource 
{
  private final EntityManager entityManager ;

    public EquipeAuditorResource() {
        entityManager  = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }
   
   

    private Integer countEquipeAuditores() {
        Query query = entityManager.createQuery("SELECT COUNT(eqa.id) FROM EquipeAuditores eqa");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<EquipeAuditores> findEquipeAuditores(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT eqa FROM EquipeAuditores eqa ORDER BY eqa." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findEquipeAuditores(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countEquipeAuditores());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findEquipeAuditores(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listEquipeAuditores(@DefaultValue("1")
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
        return findEquipeAuditores(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public EquipeAuditores getEquipeAuditores(@PathParam("id") Long id) {
        return entityManager.find(EquipeAuditores.class, id);
    }

    @POST
    public EquipeAuditores saveEquipeAuditores(EquipeAuditores equipeAuditores) {
           entityManager.getTransaction().begin();
        if (equipeAuditores.getIdequipe()== null) {
            EquipeAuditores equipeAuditoresToSave = new EquipeAuditores();            
            equipeAuditoresToSave.setIdauditor(equipeAuditores.getIdauditor());
             equipeAuditoresToSave.setIdauditor2(equipeAuditores.getIdauditor2());
            equipeAuditoresToSave.setIdaudit(equipeAuditores.getIdaudit());
            equipeAuditoresToSave.setTipoauditor(equipeAuditores.getTipoauditor());
            equipeAuditoresToSave.setDthrincequipe(equipeAuditores.getDthrincequipe());
            equipeAuditoresToSave.setStatusequipe(equipeAuditores.getStatusequipe());
            entityManager.persist(equipeAuditores);
        } else {
            EquipeAuditores equipeAuditoresToUpdate = getEquipeAuditores(equipeAuditores.getIdequipe());
            equipeAuditoresToUpdate.setIdauditor(equipeAuditores.getIdauditor());
            equipeAuditoresToUpdate.setIdauditor2(equipeAuditores.getIdauditor2());
            equipeAuditoresToUpdate.setIdaudit(equipeAuditores.getIdaudit());
            equipeAuditoresToUpdate.setTipoauditor(equipeAuditores.getTipoauditor());
            equipeAuditoresToUpdate.setDthrincequipe(equipeAuditores.getDthrincequipe());
            equipeAuditoresToUpdate.setStatusequipe(equipeAuditores.getStatusequipe());
            equipeAuditores = entityManager.merge(equipeAuditoresToUpdate);
        }
        entityManager.getTransaction().commit();
        return equipeAuditores;
    }

    @DELETE
    @Path("{id}")
    public void deleteEquipeAuditores(@PathParam("id") Long id) {
         entityManager.getTransaction().begin();
        entityManager.remove(getEquipeAuditores(id));
        entityManager.getTransaction().commit();
    }      
    
}
