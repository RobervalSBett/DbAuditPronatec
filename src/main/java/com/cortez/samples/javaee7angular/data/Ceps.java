
package com.cortez.samples.javaee7angular.data;


import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author pedrinho
 */
@Entity
@Table(name = "ceps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ceps.findAll", query = "SELECT c FROM Ceps c"),
    @NamedQuery(name = "Ceps.findByCep", query = "SELECT c FROM Ceps c WHERE c.cep = :cep"),
    @NamedQuery(name = "Ceps.findByLogracep", query = "SELECT c FROM Ceps c WHERE c.logracep = :logracep"),
    @NamedQuery(name = "Ceps.findByObscep", query = "SELECT c FROM Ceps c WHERE c.obscep = :obscep"),
    @NamedQuery(name = "Ceps.findByStatuscep", query = "SELECT c FROM Ceps c WHERE c.statuscep = :statuscep"),
    @NamedQuery(name = "Ceps.findByIdcep", query = "SELECT c FROM Ceps c WHERE c.idcep = :idcep")})
public class Ceps implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "cep")
    private String cep;
    @Size(max = 60)
    @Column(name = "logracep")
    private String logracep;
    @Size(max = 100)
    @Column(name = "obscep")
    private String obscep;
    @Size(max = 1)
    @Column(name = "statuscep")
    private String statuscep;

 
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCEP")
    @SequenceGenerator(name = "IDCEP", sequenceName = "seq_ceps", allocationSize = 1)
    @Column(name = "idcep")
    private Long idcep;
    @OneToMany(mappedBy = "idcep")
    private Collection<Certificadoras> certificadorasCollection;
//    @OneToMany(mappedBy = "idcep")
//    private Collection<Auditores> auditoresCollection;
    @JoinColumn(name = "idbai", referencedColumnName = "idbai")
    @ManyToOne
    private Bairros idbai;
    @JoinColumn(name = "idcid", referencedColumnName = "idcid")
    @ManyToOne
    private Cidades cidades;
    @OneToMany(mappedBy = "idcep")
    private Collection<Clientes> clientesCollection;

    public Ceps() {
    }

    public Ceps(String cep, String logracep, String obscep, String statuscep, Long idcep, Collection<Certificadoras> certificadorasCollection, Collection<Auditores> auditoresCollection, Bairros idbai, Cidades idcid, Collection<Clientes> clientesCollection) {
        this.cep = cep;
        this.logracep = logracep;
        this.obscep = obscep;
        this.statuscep = statuscep;
        this.idcep = idcep;
        this.certificadorasCollection = certificadorasCollection;
//        this.auditoresCollection = auditoresCollection;
        this.idbai = idbai;
        this.cidades = idcid;
        this.clientesCollection = clientesCollection;
    }
    

    public Ceps(Long idcep) {
        this.idcep = idcep;
    }

    public Ceps(Long idcep, String cep) {
        this.idcep = idcep;
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogracep() {
        return logracep;
    }

    public void setLogracep(String logracep) {
        this.logracep = logracep;
    }

    public String getObscep() {
        return obscep;
    }

    public void setObscep(String obscep) {
        this.obscep = obscep;
    }

    public String getStatuscep() {
        return statuscep;
    }

    public void setStatuscep(String statuscep) {
        this.statuscep = statuscep;
    }

    public Long getIdcep() {
        return idcep;
    }

    public void setIdcep(Long idcep) {
        this.idcep = idcep;
    }

    @XmlTransient
    public Collection<Certificadoras> getCertificadorasCollection() {
        return certificadorasCollection;
    }

    public void setCertificadorasCollection(Collection<Certificadoras> certificadorasCollection) {
        this.certificadorasCollection = certificadorasCollection;
    }

//    @XmlTransient
//    public Collection<Auditores> getAuditoresCollection() {
//        return auditoresCollection;
//    }
//
//    public void setAuditoresCollection(Collection<Auditores> auditoresCollection) {
//        this.auditoresCollection = auditoresCollection;
//    }
//
    public Bairros getIdbai() {
        return idbai;
    }

    public void setIdbai(Bairros idbai) {
        this.idbai = idbai;
    }

    public Cidades getCidades() {
        return cidades;
    }

    public void setCidades(Cidades cidades) {
        this.cidades = cidades;
    }

    @XmlTransient
    public Collection<Clientes> getClientesCollection() {
        return clientesCollection;
    }

    public void setClientesCollection(Collection<Clientes> clientesCollection) {
        this.clientesCollection = clientesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcep != null ? idcep.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ceps)) {
            return false;
        }
        Ceps other = (Ceps) object;
        if ((this.idcep == null && other.idcep != null) || (this.idcep != null && !this.idcep.equals(other.idcep))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Ceps[ idcep=" + idcep + " ]";
    }
    
}
