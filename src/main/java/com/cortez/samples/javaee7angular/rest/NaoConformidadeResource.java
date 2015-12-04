package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.NaoConformidades;
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

public class NaoConformidadeResource 
{
 
    private final EntityManager entityManager ;

    public NaoConformidadeResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }
     

    private Integer countNaoConformidades() {
        Query query = entityManager.createQuery("SELECT COUNT(nc.id) FROM NaoConformidades nc");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<NaoConformidades> findNaoConformidades(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT nc FROM NaoConformidades nc ORDER BY nc." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper<NaoConformidades> findNaoConformidades(PaginatedListWrapper<NaoConformidades> wrapper) {
        wrapper.setTotalResults(countNaoConformidades());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findNaoConformidades(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listNaoConformidades(@DefaultValue("1")
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
        return findNaoConformidades(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public NaoConformidades getNaoConformidades(@PathParam("id") Long id) {
        return entityManager.find(NaoConformidades.class,id);
    }

    @POST
    public NaoConformidades saveNaoConformidades(NaoConformidades naoConformidades) {
         entityManager.getTransaction().begin();
        if (naoConformidades.getIdnc()== null) {
            NaoConformidades naoConformidadesToSave = new NaoConformidades();            
            naoConformidadesToSave.setIdcola(naoConformidades.getIdcola());
            naoConformidadesToSave.setIdpontoctrl(naoConformidades.getIdpontoctrl());
            naoConformidadesToSave.setDthrcadnc(naoConformidades.getDthrcadnc());
            naoConformidadesToSave.setDtprevresolnc(naoConformidades.getDtprevresolnc());
            naoConformidadesToSave.setDtatualiza(naoConformidades.getDtatualiza());
            naoConformidadesToSave.setDescrinc(naoConformidades.getDescrinc());
            naoConformidadesToSave.setSugestaonc(naoConformidades.getSugestaonc());
            naoConformidadesToSave.setObsnc(naoConformidades.getObsnc());
            naoConformidadesToSave.setStatusnc(naoConformidades.getStatusnc());
            entityManager.persist(naoConformidades);
        } else {
            NaoConformidades naoConformidadesToUpdate = getNaoConformidades(naoConformidades.getIdnc());
            naoConformidadesToUpdate.setIdcola(naoConformidades.getIdcola());
            naoConformidadesToUpdate.setIdpontoctrl(naoConformidades.getIdpontoctrl());
            naoConformidadesToUpdate.setDthrcadnc(naoConformidades.getDthrcadnc());
            naoConformidadesToUpdate.setDtprevresolnc(naoConformidades.getDtprevresolnc());
            naoConformidadesToUpdate.setDtatualiza(naoConformidades.getDtatualiza());
            naoConformidadesToUpdate.setDescrinc(naoConformidades.getDescrinc());
            naoConformidadesToUpdate.setSugestaonc(naoConformidades.getSugestaonc());
            naoConformidadesToUpdate.setObsnc(naoConformidades.getObsnc());
            naoConformidadesToUpdate.setStatusnc(naoConformidades.getStatusnc());
            naoConformidades = entityManager.merge(naoConformidadesToUpdate);
        }
         entityManager.getTransaction().commit();
        return naoConformidades;
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
         entityManager.getTransaction().begin();
        entityManager.remove(getNaoConformidades(id));
         entityManager.getTransaction().commit();
    }

       
}
