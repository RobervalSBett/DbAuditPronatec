
package com.cortez.samples.javaee7angular.data;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
 import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

/**
 *
 * @author pedrinho
 */
@Entity
@Table(name = "certificadoras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Certificadoras.findAll", query = "SELECT c FROM Certificadoras c"),
    @NamedQuery(name = "Certificadoras.findByIdcert", query = "SELECT c FROM Certificadoras c WHERE c.idcert = :idcert"),
    @NamedQuery(name = "Certificadoras.findByRazaocert", query = "SELECT c FROM Certificadoras c WHERE c.razaocert = :razaocert"),
    @NamedQuery(name = "Certificadoras.findByFantacert", query = "SELECT c FROM Certificadoras c WHERE c.fantacert = :fantacert"),
    @NamedQuery(name = "Certificadoras.findByCompleendcert", query = "SELECT c FROM Certificadoras c WHERE c.compleendcert = :compleendcert"),
    @NamedQuery(name = "Certificadoras.findByFone1cert", query = "SELECT c FROM Certificadoras c WHERE c.fone1cert = :fone1cert"),
    @NamedQuery(name = "Certificadoras.findByFone2cert", query = "SELECT c FROM Certificadoras c WHERE c.fone2cert = :fone2cert"),
    @NamedQuery(name = "Certificadoras.findByEmailcert", query = "SELECT c FROM Certificadoras c WHERE c.emailcert = :emailcert"),
    @NamedQuery(name = "Certificadoras.findBySitecert", query = "SELECT c FROM Certificadoras c WHERE c.sitecert = :sitecert"),
    @NamedQuery(name = "Certificadoras.findByContatocert", query = "SELECT c FROM Certificadoras c WHERE c.contatocert = :contatocert"),
    @NamedQuery(name = "Certificadoras.findByCnpjcert", query = "SELECT c FROM Certificadoras c WHERE c.cnpjcert = :cnpjcert"),
    @NamedQuery(name = "Certificadoras.findByInscricert", query = "SELECT c FROM Certificadoras c WHERE c.inscricert = :inscricert"),
    @NamedQuery(name = "Certificadoras.findByObscert", query = "SELECT c FROM Certificadoras c WHERE c.obscert = :obscert"),
    @NamedQuery(name = "Certificadoras.findByStatuscert", query = "SELECT c FROM Certificadoras c WHERE c.statuscert = :statuscert")})
public class Certificadoras implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCERT")
    @SequenceGenerator(name = "IDCERT", sequenceName = "seq_certificadoras",allocationSize = 1)
    @Column(name = "idcert")
    private Long idcert;
    @Size(max = 60)
    @Column(name = "razaocert")
    private String razaocert;
    @Size(max = 60)
    @Column(name = "fantacert")
    private String fantacert;
    @Size(max = 60)
    @Column(name = "compleendcert")
    private String compleendcert;
    @Size(max = 15)
    @Column(name = "fone1cert")
    private String fone1cert;
    @Size(max = 15)
    @Column(name = "fone2cert")
    private String fone2cert;
    @Size(max = 100)
    @Column(name = "emailcert")
    private String emailcert;
    @Size(max = 100)
    @Column(name = "sitecert")
    private String sitecert;
    @Size(max = 60)
    @Column(name = "contatocert")
    private String contatocert;
    @Size(max = 20)
    @Column(name = "cnpjcert")
    private String cnpjcert;
    @Size(max = 14)
    @Column(name = "inscricert")
    private String inscricert;
    @Size(max = 100)
    @Column(name = "obscert")
    private String obscert;
    @Size(max = 1)
    @Column(name = "statuscert")
    private String statuscert;
    @JoinColumn(name = "idcep", referencedColumnName = "idcep")
    @ManyToOne
    private Ceps idcep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "certificadora")
    private Collection<Auditorias> auditoriasCollection;

    public Certificadoras() {
    }

    public Certificadoras(Long idcert, String razaocert, String fantacert, String compleendcert, String fone1cert, String fone2cert, String emailcert, String sitecert, String contatocert, String cnpjcert, String inscricert, String obscert, String statuscert, Ceps idcep, Collection<Auditorias> auditoriasCollection) {
        this.idcert = idcert;
        this.razaocert = razaocert;
        this.fantacert = fantacert;
        this.compleendcert = compleendcert;
        this.fone1cert = fone1cert;
        this.fone2cert = fone2cert;
        this.emailcert = emailcert;
        this.sitecert = sitecert;
        this.contatocert = contatocert;
        this.cnpjcert = cnpjcert;
        this.inscricert = inscricert;
        this.obscert = obscert;
        this.statuscert = statuscert;
        this.idcep = idcep;
        this.auditoriasCollection = auditoriasCollection;
    }
    
    

    public Certificadoras(Long idcert) {
        this.idcert = idcert;
    }

    public Long  getIdcert() {
        return idcert;
    }

    public void setIdcert(Long idcert) {
        this.idcert = idcert;
    }

    public String getRazaocert() {
        return razaocert;
    }

    public void setRazaocert(String razaocert) {
        this.razaocert = razaocert;
    }

    public String getFantacert() {
        return fantacert;
    }

    public void setFantacert(String fantacert) {
        this.fantacert = fantacert;
    }

    public String getCompleendcert() {
        return compleendcert;
    }

    public void setCompleendcert(String compleendcert) {
        this.compleendcert = compleendcert;
    }

    public String getFone1cert() {
        return fone1cert;
    }

    public void setFone1cert(String fone1cert) {
        this.fone1cert = fone1cert;
    }

    public String getFone2cert() {
        return fone2cert;
    }

    public void setFone2cert(String fone2cert) {
        this.fone2cert = fone2cert;
    }

    public String getEmailcert() {
        return emailcert;
    }

    public void setEmailcert(String emailcert) {
        this.emailcert = emailcert;
    }

    public String getSitecert() {
        return sitecert;
    }

    public void setSitecert(String sitecert) {
        this.sitecert = sitecert;
    }

    public String getContatocert() {
        return contatocert;
    }

    public void setContatocert(String contatocert) {
        this.contatocert = contatocert;
    }

    public String getCnpjcert() {
        return cnpjcert;
    }

    public void setCnpjcert(String cnpjcert) {
        this.cnpjcert = cnpjcert;
    }

    public String getInscricert() {
        return inscricert;
    }

    public void setInscricert(String inscricert) {
        this.inscricert = inscricert;
    }

    public String getObscert() {
        return obscert;
    }

    public void setObscert(String obscert) {
        this.obscert = obscert;
    }

    public String getStatuscert() {
        return statuscert;
    }

    public void setStatuscert(String statuscert) {
        this.statuscert = statuscert;
    }

    public Ceps getIdcep() {
        return idcep;
    }

    public void setIdcep(Ceps idcep) {
        this.idcep = idcep;
    }

    @XmlTransient
    public Collection<Auditorias> getAuditoriasCollection() {
        return auditoriasCollection;
    }

    public void setAuditoriasCollection(Collection<Auditorias> auditoriasCollection) {
        this.auditoriasCollection = auditoriasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcert != null ? idcert.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificadoras)) {
            return false;
        }
        Certificadoras other = (Certificadoras) object;
        if ((this.idcert == null && other.idcert != null) || (this.idcert != null && !this.idcert.equals(other.idcert))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Certificadoras[ idcert=" + idcert + " ]";
    }
    
}
