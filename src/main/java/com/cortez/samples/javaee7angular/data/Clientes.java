
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdcli", query = "SELECT c FROM Clientes c WHERE c.idcli = :idcli"),
    @NamedQuery(name = "Clientes.findByRazaocli", query = "SELECT c FROM Clientes c WHERE c.razaocli = :razaocli"),
    @NamedQuery(name = "Clientes.findByFantacli", query = "SELECT c FROM Clientes c WHERE c.fantacli = :fantacli"),
    @NamedQuery(name = "Clientes.findByCompleendcli", query = "SELECT c FROM Clientes c WHERE c.compleendcli = :compleendcli"),
    @NamedQuery(name = "Clientes.findByFone1cli", query = "SELECT c FROM Clientes c WHERE c.fone1cli = :fone1cli"),
    @NamedQuery(name = "Clientes.findByFone2cli", query = "SELECT c FROM Clientes c WHERE c.fone2cli = :fone2cli"),
    @NamedQuery(name = "Clientes.findByEmailcli", query = "SELECT c FROM Clientes c WHERE c.emailcli = :emailcli"),
    @NamedQuery(name = "Clientes.findBySitecli", query = "SELECT c FROM Clientes c WHERE c.sitecli = :sitecli"),
    @NamedQuery(name = "Clientes.findByContatocli", query = "SELECT c FROM Clientes c WHERE c.contatocli = :contatocli"),
    @NamedQuery(name = "Clientes.findByEmailcontato", query = "SELECT c FROM Clientes c WHERE c.emailcontato = :emailcontato"),
    @NamedQuery(name = "Clientes.findByCnpjcli", query = "SELECT c FROM Clientes c WHERE c.cnpjcli = :cnpjcli"),
    @NamedQuery(name = "Clientes.findByInscricli", query = "SELECT c FROM Clientes c WHERE c.inscricli = :inscricli"),
    @NamedQuery(name = "Clientes.findByObscli", query = "SELECT c FROM Clientes c WHERE c.obscli = :obscli"),
    @NamedQuery(name = "Clientes.findByStatuscli", query = "SELECT c FROM Clientes c WHERE c.statuscli = :statuscli")})
public class Clientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCLI")
    @SequenceGenerator(name = "IDCLI", sequenceName = "seq_clientes", allocationSize = 1)
    @Column(name = "idcli")
    private Long idcli;
    @Size(max = 254)
    @Column(name = "razaocli")
    private String razaocli;
    @Size(max = 60)
    @Column(name = "fantacli")
    private String fantacli;
    @Size(max = 60)
    @Column(name = "compleendcli")
    private String compleendcli;
    @Size(max = 15)
    @Column(name = "fone1cli")
    private String fone1cli;
    @Size(max = 15)
    @Column(name = "fone2cli")
    private String fone2cli;
    @Size(max = 100)
    @Column(name = "emailcli")
    private String emailcli;
    @Size(max = 100)
    @Column(name = "sitecli")
    private String sitecli;
    @Size(max = 60)
    @Column(name = "contatocli")
    private String contatocli;
    @Size(max = 100)
    @Column(name = "emailcontato")
    private String emailcontato;
    @Size(max = 20)
    @Column(name = "cnpjcli")
    private String cnpjcli;
    @Size(max = 14)
    @Column(name = "inscricli")
    private String inscricli;
    @Size(max = 100)
    @Column(name = "obscli")
    private String obscli;
    @Size(max = 1)
    @Column(name = "statuscli")
    private String statuscli;
    @JoinColumn(name = "idcep", referencedColumnName = "idcep")
    @ManyToOne
    private Ceps idcep;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcli")
    private Collection<Auditorias> auditoriasCollection;

    public Clientes() {
    }

    public Clientes( Long idcli) {
        this.idcli = idcli;
    }

    public  Long getIdcli() {
        return idcli;
    }

    public void setIdcli( Long idcli) {
        this.idcli = idcli;
    }

    public String getRazaocli() {
        return razaocli;
    }

    public void setRazaocli(String razaocli) {
        this.razaocli = razaocli;
    }

    public String getFantacli() {
        return fantacli;
    }

    public void setFantacli(String fantacli) {
        this.fantacli = fantacli;
    }

    public String getCompleendcli() {
        return compleendcli;
    }

    public void setCompleendcli(String compleendcli) {
        this.compleendcli = compleendcli;
    }

    public String getFone1cli() {
        return fone1cli;
    }

    public void setFone1cli(String fone1cli) {
        this.fone1cli = fone1cli;
    }

    public String getFone2cli() {
        return fone2cli;
    }

    public void setFone2cli(String fone2cli) {
        this.fone2cli = fone2cli;
    }

    public String getEmailcli() {
        return emailcli;
    }

    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }

    public String getSitecli() {
        return sitecli;
    }

    public void setSitecli(String sitecli) {
        this.sitecli = sitecli;
    }

    public String getContatocli() {
        return contatocli;
    }

    public void setContatocli(String contatocli) {
        this.contatocli = contatocli;
    }

    public String getEmailcontato() {
        return emailcontato;
    }

    public void setEmailcontato(String emailcontato) {
        this.emailcontato = emailcontato;
    }

    public String getCnpjcli() {
        return cnpjcli;
    }

    public void setCnpjcli(String cnpjcli) {
        this.cnpjcli = cnpjcli;
    }

    public String getInscricli() {
        return inscricli;
    }

    public void setInscricli(String inscricli) {
        this.inscricli = inscricli;
    }

    public String getObscli() {
        return obscli;
    }

    public void setObscli(String obscli) {
        this.obscli = obscli;
    }

    public String getStatuscli() {
        return statuscli;
    }

    public void setStatuscli(String statuscli) {
        this.statuscli = statuscli;
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
        hash += (idcli != null ? idcli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.idcli == null && other.idcli != null) || (this.idcli != null && !this.idcli.equals(other.idcli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Clientes[ idcli=" + idcli + " ]";
    }
    
}
