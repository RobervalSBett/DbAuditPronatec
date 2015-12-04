package com.cortez.samples.javaee7angular.rest;

import com.cortez.samples.javaee7angular.data.Certificadoras;
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
public class CertificadoraResource 
{
      private final EntityManager entityManager ;

    public CertificadoraResource() {
        entityManager = Persistence.createEntityManagerFactory("localPU").createEntityManager();
    }
    

    private Integer countCertificadoras() {
        Query query = entityManager.createQuery("SELECT COUNT(cert.id) FROM Certificadoras cert");
        return ((Long) query.getSingleResult()).intValue();
    }

    @SuppressWarnings("unchecked")
    private List<Certificadoras> findCertificadoras(int startPosition, int maxResults, String sortFields, String sortDirections) {
        Query query =
                entityManager.createQuery("SELECT cert FROM Certificadoras cert ORDER BY cert." + sortFields + " " + sortDirections);
        query.setFirstResult(startPosition);
        query.setMaxResults(maxResults);
        return query.getResultList();
    }

    private PaginatedListWrapper findCertificadoras(PaginatedListWrapper wrapper) {
        wrapper.setTotalResults(countCertificadoras());
        int start = (wrapper.getCurrentPage() - 1) * wrapper.getPageSize();
        wrapper.setList(findCertificadoras(start,
                                    wrapper.getPageSize(),
                                    wrapper.getSortFields(),
                                    wrapper.getSortDirections()));
        return wrapper;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PaginatedListWrapper listCertificadoras(@DefaultValue("1")
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
        return findCertificadoras(paginatedListWrapper);
    }

    @GET
    @Path("{id}")
    public Certificadoras getCertificadoras(@PathParam("id") Long id) {
        return entityManager.find(Certificadoras.class, id);
    }

    @POST
    public Certificadoras saveCertificadoras(Certificadoras certificadora) {
        entityManager.getTransaction().begin();
        if (certificadora.getIdcert()== null) {
            Certificadoras certificadoraToSave = new Certificadoras();            
            certificadoraToSave.setIdcert(certificadora.getIdcert());
            certificadoraToSave.setIdcep(certificadora.getIdcep());
            certificadoraToSave.setFantacert(certificadora.getFantacert());
            certificadoraToSave.setCompleendcert(certificadora.getCompleendcert());
            certificadoraToSave.setFone1cert(certificadora.getFone1cert());
            certificadoraToSave.setFone2cert(certificadora.getFone2cert());
            certificadoraToSave.setEmailcert(certificadora.getEmailcert());
            certificadoraToSave.setSitecert(certificadora.getSitecert());
            certificadoraToSave.setContatocert(certificadora.getContatocert());
            certificadoraToSave.setRazaocert(certificadora.getRazaocert());
            certificadoraToSave.setCnpjcert(certificadora.getCnpjcert());
            certificadoraToSave.setInscricert(certificadora.getInscricert());
            certificadoraToSave.setObscert(certificadora.getObscert());
            certificadoraToSave.setStatuscert(certificadora.getStatuscert());
            entityManager.persist(certificadora);
        } else {
            Certificadoras certificadoraToUpdate = getCertificadoras(certificadora.getIdcert());
            certificadoraToUpdate.setIdcep(certificadora.getIdcep());
            certificadoraToUpdate.setFantacert(certificadora.getFantacert());
            certificadoraToUpdate.setCompleendcert(certificadora.getCompleendcert());
            certificadoraToUpdate.setFone1cert(certificadora.getFone1cert());
            certificadoraToUpdate.setFone2cert(certificadora.getFone2cert());
            certificadoraToUpdate.setEmailcert(certificadora.getEmailcert());
            certificadoraToUpdate.setSitecert(certificadora.getSitecert());
            certificadoraToUpdate.setContatocert(certificadora.getContatocert());
            certificadoraToUpdate.setRazaocert(certificadora.getRazaocert());
            certificadoraToUpdate.setCnpjcert(certificadora.getCnpjcert());
            certificadoraToUpdate.setInscricert(certificadora.getInscricert());
            certificadoraToUpdate.setObscert(certificadora.getObscert());
            certificadoraToUpdate.setStatuscert(certificadora.getStatuscert());
            certificadora = entityManager.merge(certificadoraToUpdate);
        }
         entityManager.getTransaction().commit();
        return certificadora;
    }

    @DELETE
    @Path("{id}")
    public void deleteCliente(@PathParam("id") Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(getCertificadoras(id));
         entityManager.getTransaction().commit();
    } 
}
