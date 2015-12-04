
package com.cortez.samples.javaee7angular.data;
 

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pedrinho
 */
@Entity
@Table(name = "auditores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditores.findAll", query = "SELECT a FROM Auditores a"),
    @NamedQuery(name = "Auditores.findByIdauditor", query = "SELECT a FROM Auditores a WHERE a.idauditor = :idauditor"),
    @NamedQuery(name = "Auditores.findByNomeaudit", query = "SELECT a FROM Auditores a WHERE a.nomeaudit = :nomeaudit"),
    @NamedQuery(name = "Auditores.findByCpfaudit", query = "SELECT a FROM Auditores a WHERE a.cpfaudit = :cpfaudit"),
    @NamedQuery(name = "Auditores.findByFone1audit", query = "SELECT a FROM Auditores a WHERE a.fone1audit = :fone1audit"),
    @NamedQuery(name = "Auditores.findByFone2audit", query = "SELECT a FROM Auditores a WHERE a.fone2audit = :fone2audit"),
    @NamedQuery(name = "Auditores.findByEmailaudit", query = "SELECT a FROM Auditores a WHERE a.emailaudit = :emailaudit"),
    @NamedQuery(name = "Auditores.findByCompleendaudit", query = "SELECT a FROM Auditores a WHERE a.compleendaudit = :compleendaudit"),
    @NamedQuery(name = "Auditores.findByTipoaudit", query = "SELECT a FROM Auditores a WHERE a.tipoaudit = :tipoaudit"),
    @NamedQuery(name = "Auditores.findByObsaudit", query = "SELECT a FROM Auditores a WHERE a.obsaudit = :obsaudit"),
    @NamedQuery(name = "Auditores.findByUsuaudit", query = "SELECT a FROM Auditores a WHERE a.usuaudit = :usuaudit"),
    @NamedQuery(name = "Auditores.findBySenhaudit", query = "SELECT a FROM Auditores a WHERE a.senhaudit = :senhaudit"),
    @NamedQuery(name = "Auditores.findByStatusauditores", query = "SELECT a FROM Auditores a WHERE a.statusauditores = :statusauditores")})
public class Auditores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDAUDITOR")
    @SequenceGenerator(name = "IDAUDITOR", sequenceName = "seq_auditores",allocationSize = 1)
    @Column(name = "idauditor")
    private Long idauditor;
    @Size(max = 254)
    @Column(name = "nomeaudit")
    private String nomeaudit;
    @Size(max = 14)
    @Column(name = "cpfaudit")
    private String cpfaudit;
    @Size(max = 15)
    @Column(name = "fone1audit")
    private String fone1audit;
    @Size(max = 15)
    @Column(name = "fone2audit")
    private String fone2audit;
    @Size(max = 100)
    @Column(name = "emailaudit")
    private String emailaudit;
    @Size(max = 60)
    @Column(name = "compleendaudit")
    private String compleendaudit;
    @Size(max = 1)
    @Column(name = "tipoaudit")
    private String tipoaudit;
    @Size(max = 100)
    @Column(name = "obsaudit")
    private String obsaudit;
    @Size(max = 10)
    @Column(name = "usuaudit")
    private String usuaudit;
    @Size(max = 20)
    @Column(name = "senhaudit")
    private String senhaudit;
    @Size(max = 1)
    @Column(name = "statusauditores")
    private String statusauditores;
    @OneToMany(mappedBy = "idauditor")
   private Collection<EquipeAuditores> equipeauditoresCollection;
    @OneToMany(mappedBy = "idauditor2")
    private Collection<EquipeAuditores> equipeauditoresCollection1; 
    @JoinColumn(name = "idcep", referencedColumnName = "idcep")
    @ManyToOne
    private Ceps cep;
    //
    public Auditores() {
    }

    public Auditores(Long idauditor) {
        this.idauditor = idauditor;
    }

    public Long getIdauditor() {
        return idauditor;
    }

    public void setIdauditor(Long idauditor) {
        this.idauditor = idauditor;
    }

    public String getNomeaudit() {
        return nomeaudit;
    }

    public void setNomeaudit(String nomeaudit) {
        this.nomeaudit = nomeaudit;
    }

    public String getCpfaudit() {
        return cpfaudit;
    }

    public void setCpfaudit(String cpfaudit) {
        this.cpfaudit = cpfaudit;
    }

    public String getFone1audit() {
        return fone1audit;
    }

    public void setFone1audit(String fone1audit) {
        this.fone1audit = fone1audit;
    }

    public String getFone2audit() {
        return fone2audit;
    }

    public void setFone2audit(String fone2audit) {
        this.fone2audit = fone2audit;
    }

    public String getEmailaudit() {
        return emailaudit;
    }

    public void setEmailaudit(String emailaudit) {
        this.emailaudit = emailaudit;
    }

    public String getCompleendaudit() {
        return compleendaudit;
    }

    public void setCompleendaudit(String compleendaudit) {
        this.compleendaudit = compleendaudit;
    }

    public String getTipoaudit() {
        return tipoaudit;
    }

    public void setTipoaudit(String tipoaudit) {
        this.tipoaudit = tipoaudit;
    }

    public String getObsaudit() {
        return obsaudit;
    }

    public void setObsaudit(String obsaudit) {
        this.obsaudit = obsaudit;
    }

    public String getUsuaudit() {
        return usuaudit;
    }

    public void setUsuaudit(String usuaudit) {
        this.usuaudit = usuaudit;
    }

    public String getSenhaudit() {
        return senhaudit;
    }

    public void setSenhaudit(String senhaudit) {
        this.senhaudit = senhaudit;
    }

    public String getStatusauditores() {
        return statusauditores;
    }

    public void setStatusauditores(String statusauditores) {
        this.statusauditores = statusauditores;
    }

    @XmlTransient
    public Collection<EquipeAuditores> getEquipeauditoresCollection() {
        return equipeauditoresCollection;
    }

    public void setEquipeauditoresCollection(Collection<EquipeAuditores> equipeauditoresCollection) {
        this.equipeauditoresCollection = equipeauditoresCollection;
    }

    @XmlTransient
    public Collection<EquipeAuditores> getEquipeauditoresCollection1() {
        return equipeauditoresCollection1;
    }

    public void setEquipeauditoresCollection1(Collection<EquipeAuditores> equipeauditoresCollection1) {
        this.equipeauditoresCollection1 = equipeauditoresCollection1;
    }   

    public Ceps getCep() {
        return cep;
    }

    public void setCep(Ceps cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauditor != null ? idauditor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditores)) {
            return false;
        }
        Auditores other = (Auditores) object;
        if ((this.idauditor == null && other.idauditor != null) || (this.idauditor != null && !this.idauditor.equals(other.idauditor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Auditores[ idauditor=" + idauditor + " ]";
    }
    
}
