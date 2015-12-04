
package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Colaboradores;
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
public class ColaboradorResource 
{
    private final EntityManager entityManager ;

    public ColaboradorResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

    
    
    private Integer countColaboradores() {
        Query query = entityManager.createQuery("SELECT COUNT(o.id) FROM Colaboradores o ");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Colaboradores> findColaboradores(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT o FROM Colaboradores  o ORDER BY o." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findColaboradores(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countColaboradores());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findColaboradores(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listColaboradores(@DefaultValue("1")
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
        return findColaboradores(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Colaboradores getColaboradores(@PathParam("id") Long id) {
        return entityManager.find(Colaboradores.class, id);
    }

    @POST
    public Colaboradores saveColaborador(Colaboradores colaborador) {
        entityManager.getTransaction().begin();
        if (colaborador.getIdcola()== null) {
            Colaboradores colaboradorToSave = new Colaboradores();
            colaboradorToSave.setNomecola(colaborador.getNomecola());
            colaboradorToSave.setFone1cola(colaborador.getFone1cola());
            colaboradorToSave.setFone2cola(colaborador.getFone2cola());
            colaboradorToSave.setEmailcola(colaborador.getEmailcola());
            colaboradorToSave.setObscola(colaborador.getObscola());
            colaboradorToSave.setStatuscola(colaborador.getStatuscola());
            entityManager.persist(colaborador);
        } else {
            Colaboradores colaboradorToUpdate = getColaboradores(colaborador.getIdcola());
            colaboradorToUpdate.setNomecola(colaborador.getNomecola());
            colaboradorToUpdate.setFone1cola(colaborador.getFone1cola());
            colaboradorToUpdate.setFone2cola(colaborador.getFone2cola());
            colaboradorToUpdate.setEmailcola(colaborador.getEmailcola());
            colaboradorToUpdate.setObscola(colaborador.getObscola());
            colaboradorToUpdate.setStatuscola(colaborador.getStatuscola());
            colaborador = entityManager.merge(colaboradorToUpdate);
        }
          entityManager.getTransaction().commit();

        return colaborador;
    }

    @DELETE
    @Path("{id}")
    public void deleteColaborador(@PathParam("id") Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getColaboradores(id));
          entityManager.getTransaction().commit();
    }  
    
    
}
