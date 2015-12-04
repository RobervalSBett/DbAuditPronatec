package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Auditores;
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
public class AuditorResource {

    private final EntityManager entityManager;

    public AuditorResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }

    private Integer countAuditores() {
        Query query = entityManager.createQuery("SELECT COUNT(au.id) FROM Auditores au");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Auditores> findAuditores(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query
                = entityManager.createQuery("SELECT au FROM Auditores au ORDER BY au." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findAuditores(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countAuditores());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findAuditores(start,
                wrapper.getPageSize(),
                wrapper.getSortFields(),
                wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listAuditores(@DefaultValue("1")
            @QueryParam("page") Integer page,
            @DefaultValue("id")
            @QueryParam("sortFields") String sortFields,
            @DefaultValue("asc")
            @QueryParam("sortDirections") String sortDirections) {
        PaginatedListWrapper paginatedListWrapper = new PaginatedListWrapper();
        paginatedListWrapper.setCurrentPage(page);
        paginatedListWrapper.setSortFields(sortFields);
        paginatedListWrapper.setSortDirections(sortDirections);
        paginatedListWrapper.setPageSize(10);
        return findAuditores(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Auditores getAuditores(@PathParam("id") Long id) {
        return entityManager.find(Auditores.class, id);
    }

    @POST
    public Auditores saveAuditor(Auditores auditor) {
        entityManager.getTransaction().begin();
        if (auditor.getIdauditor()== null) {
            Auditores auditorToSave = new Auditores();
            auditorToSave.setCep(auditor.getCep());
            auditorToSave.setNomeaudit(auditor.getNomeaudit());
            auditorToSave.setCpfaudit(auditor.getCpfaudit());
            auditorToSave.setFone1audit(auditor.getFone1audit());
            auditorToSave.setFone2audit(auditor.getFone2audit());
            auditorToSave.setEmailaudit(auditor.getEmailaudit());
            auditorToSave.setCompleendaudit(auditor.getCompleendaudit());
            auditorToSave.setTipoaudit(auditor.getTipoaudit());
            auditorToSave.setObsaudit(auditor.getObsaudit());
            auditorToSave.setUsuaudit(auditor.getUsuaudit());
            auditorToSave.setSenhaudit(auditor.getSenhaudit());
            auditorToSave.setStatusauditores(auditor.getStatusauditores());
            entityManager.persist(auditor);
        } else {
            Auditores auditorToUpdate = getAuditores(auditor.getIdauditor());
            auditorToUpdate.setCep(auditor.getCep());
            auditorToUpdate.setNomeaudit(auditor.getNomeaudit());
            auditorToUpdate.setCpfaudit(auditor.getCpfaudit());
            auditorToUpdate.setFone1audit(auditor.getFone1audit());
            auditorToUpdate.setFone2audit(auditor.getFone2audit());
            auditorToUpdate.setEmailaudit(auditor.getEmailaudit());
            auditorToUpdate.setCompleendaudit(auditor.getCompleendaudit());
            auditorToUpdate.setTipoaudit(auditor.getTipoaudit());
            auditorToUpdate.setObsaudit(auditor.getObsaudit());
            auditorToUpdate.setUsuaudit(auditor.getUsuaudit());
            auditorToUpdate.setSenhaudit(auditor.getSenhaudit());
            auditorToUpdate.setStatusauditores(auditor.getStatusauditores());
            auditor = entityManager.merge(auditorToUpdate);
        }
           entityManager.getTransaction().commit();
        return auditor;
    }

    @DELETE
    @Path("{id}")
    public void deleteAuditor(@PathParam("id") Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getAuditores(id));
        entityManager.getTransaction().commit();
    }

}
