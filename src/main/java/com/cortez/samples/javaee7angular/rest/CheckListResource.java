package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.CheckList;
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
public class CheckListResource 
{
  private final EntityManager entityManager ;

    public CheckListResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }
  

    private Integer  countCheckList()
    {
        Query query = entityManager.createQuery("SELECT COUNT(ck.id) FROM CheckList ck");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<CheckList> findCheckList(int startPosition, int maxResults, String sortFields, String sortDirections)
    {
        Query query =
                entityManager.createQuery("SELECT ck FROM CheckList ck ORDER BY ck." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findCheckList(PaginatedListWrapper wrapper)
    {
        wrapper.setTotalResults(countCheckList());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findCheckList(start,
                                       wrapper.getPageSize(),
                                       wrapper.getSortFields(),
                                       wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listCheckList(@DefaultValue("1")
                                               @QueryParam("page")
                                               Integer page,
                                               @DefaultValue("id")
                                               @QueryParam("sortFields")
                                               String sortFields,
                                               @DefaultValue("asc")
                                               @QueryParam("sortDirections")
                                               String sortDirections)
    {
        PaginatedListWrapper paginatedListWrapper = new PaginatedListWrapper();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(10);
        return findCheckList(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public CheckList getCheckList(@PathParam("id") Long id)
    {
        return entityManager.find(CheckList.class, id);
    }

    @POST
    public CheckList saveCheckList(CheckList checklist)
    {    entityManager.getTransaction().begin();
        if (checklist.getIdpontoctrl()== null)
          {
              CheckList checklistToSave = new CheckList();            
              checklistToSave.setIdpontoctrl(checklist.getIdpontoctrl());                       
              checklistToSave.setDocprocesso(checklist.getDocprocesso());                         
              checklistToSave.setDescrichklist(checklist.getDescrichklist());            
              checklistToSave.setObschklist(checklist.getObschklist());            
              checklistToSave.setDthrrealichklist(checklist.getDthrrealichklist());                      
              checklistToSave.setDtatualiza(checklist.getDtatualiza());                                  
              checklistToSave.setStatuschklist(checklist.getStatuschklist());
              entityManager.persist(checklist);
          } 
        else
          {
              CheckList checklistToUpdate = getCheckList(checklist.getIdpontoctrl());
              checklistToUpdate.setIdpontoctrl(checklist.getIdpontoctrl());                       
              checklistToUpdate.setDocprocesso(checklist.getDocprocesso());                         
              checklistToUpdate.setDescrichklist(checklist.getDescrichklist());            
              checklistToUpdate.setObschklist(checklist.getObschklist());            
              checklistToUpdate.setDthrrealichklist(checklist.getDthrrealichklist());                      
              checklistToUpdate.setDtatualiza(checklist.getDtatualiza());            
              checklistToUpdate.setStatuschklist(checklist.getStatuschklist());                        
              checklist = entityManager.merge(checklistToUpdate);
          }
        entityManager.getTransaction().commit();
        return checklist;
    }

    @DELETE
    @Path("{id}")
    public void deleteCheckList(@PathParam("id") Long id)
    {       
        entityManager.getTransaction().begin();
        entityManager.remove(getCheckList(id));
        entityManager.getTransaction().commit();
    }   
        
}
