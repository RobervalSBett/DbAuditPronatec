
package com.cortez.samples.javaee7angular.rest;
import com.cortez.samples.javaee7angular.data.Auditorias;
import com.cortez.samples.javaee7angular.data.Certificadoras;
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
public class AuditoriaResource 
{
   private final EntityManager entityManager ;

    public AuditoriaResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

  
    private Integer countAuditorias()
    {
        Query query = entityManager.createQuery("SELECT COUNT(aud.id) FROM Auditorias aud");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Auditorias> findAuditorias(int startPosition, int maxResults, String sortFields, String sortDirections)
    {
        Query query =
                entityManager.createQuery("SELECT aud FROM Auditorias aud ORDER BY aud." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findAuditorias(PaginatedListWrapper wrapper)
    {
        wrapper.setTotalResults(countAuditorias());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findAuditorias(start,
                                       wrapper.getPageSize(),
                                       wrapper.getSortFields(),
                                       wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listAuditorias(@DefaultValue("1")
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
        return findAuditorias(paginatedListWrapper);
    }
    /*
     @GET
    @Path("{id}")
     public Auditorias getAuditorias_cert(@PathParam("id") Long id)
          //   private List<Auditorias> findAuditorias()
    {
        Query query;
       query = entityManager.createQuery("SELECT aud FROM Auditorias aud ORDER BY aud." );
        
             return entityManager.find(Auditorias.class, id);

    }
    */

    @GET
    @Path("{id}")
    public Auditorias getAuditorias(@PathParam("id") Long id)
    {
        return entityManager.find(Auditorias.class, id);
    }
    
  /*  @GET
    @Path("{id}")
    public Certificadoras getCertificadoras(@PathParam("id") Long id) {
        return entityManager.find(Certificadoras.class, id);
    }
    */
    
    @POST
    public Auditorias saveAuditoria(Auditorias auditoria)
    {
         entityManager.getTransaction().begin();
        if (auditoria.getIdaudit()== null)
          {             
              Auditorias auditoriaToSave = new Auditorias();            
              auditoriaToSave.setIdaudit(auditoria.getIdaudit());                       
              auditoriaToSave.setDescriaudit(auditoria.getDescriaudit());                         
              auditoriaToSave.setDescriobjaudit(auditoria.getDescriobjaudit());            
              auditoriaToSave.setDthrcadaudit(auditoria.getDthrcadaudit());            
              auditoriaToSave.setDthriniaudit(auditoria.getDthriniaudit());            
              auditoriaToSave.setDthrrealiaudit(auditoria.getDthrrealiaudit());            
              auditoriaToSave.setDtatualiza(auditoria.getDtatualiza());            
              auditoriaToSave.setObsaudit(auditoria.getObsaudit());                        
              auditoriaToSave.setCertificadora(auditoria.getCertificadora());
              auditoriaToSave.setIdcli(auditoria.getIdcli());
              auditoriaToSave.setStatusaudit(auditoria.getStatusaudit());
              entityManager.persist(auditoria);
          } 
        else  
          {
              Auditorias auditoriaToUpdate = getAuditorias(auditoria.getIdaudit());
              auditoriaToUpdate.setIdaudit(auditoria.getIdaudit());                       
              auditoriaToUpdate.setDescriaudit(auditoria.getDescriaudit());                         
              auditoriaToUpdate.setDescriobjaudit(auditoria.getDescriobjaudit());            
              auditoriaToUpdate.setDthrcadaudit(auditoria.getDthrcadaudit());            
              auditoriaToUpdate.setDthriniaudit(auditoria.getDthriniaudit());            
              auditoriaToUpdate.setDthrrealiaudit(auditoria.getDthrrealiaudit());            
              auditoriaToUpdate.setDtatualiza(auditoria.getDtatualiza());            
              auditoriaToUpdate.setObsaudit(auditoria.getObsaudit());                        
              auditoriaToUpdate.setCertificadora(auditoria.getCertificadora());
              auditoriaToUpdate.setIdcli(auditoria.getIdcli());
              auditoriaToUpdate.setStatusaudit(auditoria.getStatusaudit());                        
              auditoria = entityManager.merge(auditoriaToUpdate);
          }
        entityManager.getTransaction().commit();
        return auditoria;
    }

    @DELETE
    @Path("{id}")
    public void deleteAuditoria(@PathParam("id") Long id)
    {
          entityManager.getTransaction().begin();
        entityManager.remove(getAuditorias(id));
        entityManager.getTransaction().commit();
    }    
}
