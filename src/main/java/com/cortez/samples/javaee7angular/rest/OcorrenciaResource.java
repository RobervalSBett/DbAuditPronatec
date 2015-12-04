package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Ocorrencias;
import com.cortez.samples.javaee7angular.pagination.PaginatedListWrapper;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.persistence.Persistence;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OcorrenciaResource 
{
   private final EntityManager entityManager ;

    public OcorrenciaResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }
  
  

    private Integer countOcorrencias() {
        Query query = entityManager.createQuery("SELECT COUNT(ocor.id) FROM Ocorrencias ocor");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Ocorrencias> findOcorrencias(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT ocor FROM Ocorrencias ocor ORDER BY ocor." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findOcorrencias(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countOcorrencias());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findOcorrencias(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listOcorrencias(@DefaultValue("1")
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
        return findOcorrencias(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Ocorrencias getOcorrencias(@PathParam("id") Long id) {
        return entityManager.find(Ocorrencias.class, id);
    }

    @POST
    public Ocorrencias saveOcorrencia(Ocorrencias ocorrencia) {
         entityManager.getTransaction().begin();
        if (ocorrencia.getIdocorre()== null) {
            Ocorrencias ocorrenciaToSave = new Ocorrencias();
            ocorrenciaToSave.setIdocorre(ocorrencia.getIdocorre());
            ocorrenciaToSave.setDtatualiza(ocorrencia.getDtatualiza());
            ocorrenciaToSave.setDthrocorre(ocorrencia.getDthrocorre());
            ocorrenciaToSave.setIdcola(ocorrencia.getIdcola());
            ocorrenciaToSave.setIdpontoctrl(ocorrencia.getIdpontoctrl());
            ocorrenciaToSave.setDescriocorre(ocorrencia.getDescriocorre());
            ocorrenciaToSave.setSugesocorre(ocorrencia.getSugesocorre());
            ocorrenciaToSave.setObsocorre(ocorrencia.getObsocorre());
            ocorrenciaToSave.setStatusocorre(ocorrencia.getStatusocorre());
            entityManager.persist(ocorrencia);
        } else {
            Ocorrencias ocorrenciaToUpdate = getOcorrencias(ocorrencia.getIdocorre());
            ocorrenciaToUpdate.setIdocorre(ocorrencia.getIdocorre());
            ocorrenciaToUpdate.setDtatualiza(ocorrencia.getDtatualiza());
            ocorrenciaToUpdate.setDthrocorre(ocorrencia.getDthrocorre());
            ocorrenciaToUpdate.setIdcola(ocorrencia.getIdcola());
            ocorrenciaToUpdate.setIdpontoctrl(ocorrencia.getIdpontoctrl());
            ocorrenciaToUpdate.setDescriocorre(ocorrencia.getDescriocorre());
            ocorrenciaToUpdate.setSugesocorre(ocorrencia.getSugesocorre());
            ocorrenciaToUpdate.setObsocorre(ocorrencia.getObsocorre());
            ocorrenciaToUpdate.setStatusocorre(ocorrencia.getStatusocorre());
            ocorrencia = entityManager.merge(ocorrenciaToUpdate);
        }
        entityManager.getTransaction().commit();
        return ocorrencia;
    }

    @DELETE
    @Path("{id}")
    public void deleteOcorrencias(@PathParam("id") Long id) {
        entityManager.remove(getOcorrencias(id));
    }   
         
}
