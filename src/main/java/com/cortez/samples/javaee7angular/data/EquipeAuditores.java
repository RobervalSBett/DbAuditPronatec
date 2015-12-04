
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
@Table(name = "equipeauditores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EquipeAuditores.findAll", query = "SELECT e FROM EquipeAuditores e"),
    @NamedQuery(name = "EquipeAuditores.findByIdequipe", query = "SELECT e FROM EquipeAuditores e WHERE e.idequipe = :idequipe"),
    @NamedQuery(name = "EquipeAuditores.findByTipoauditor", query = "SELECT e FROM EquipeAuditores e WHERE e.tipoauditor = :tipoauditor"),
    @NamedQuery(name = "EquipeAuditores.findByStatusequipe", query = "SELECT e FROM EquipeAuditores e WHERE e.statusequipe = :statusequipe"),
    @NamedQuery(name = "EquipeAuditores.findByDthrincequipe", query = "SELECT e FROM EquipeAuditores e WHERE e.dthrincequipe = :dthrincequipe")})
public class EquipeAuditores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDEQUIPE")
    @SequenceGenerator(name = "IDEQUIPE", sequenceName = "seq_equipeauditores",allocationSize = 1)
    @Column(name = "idequipe")
    private Long idequipe;
    @Size(max = 7)
    @Column(name = "tipoauditor")
    private String tipoauditor;
    @Size(max =1)
    @Column(name = "statusequipe")
    private String statusequipe;
    @Size(max = 21)
    @Column(name = "dthrincequipe")
    private String dthrincequipe;
    @JoinColumn(name = "idauditor", referencedColumnName = "idauditor")
    @ManyToOne
    private Auditores idauditor;
    @JoinColumn(name = "idauditor2", referencedColumnName = "idauditor")
    @ManyToOne
    private Auditores idauditor2;
    @JoinColumn(name = "idaudit", referencedColumnName = "idaudit")
    @ManyToOne(optional = false)
    private Auditorias idaudit;
     @OneToMany(cascade = CascadeType.ALL, mappedBy = "idequipe")
    private Collection< CheckList > checklistCollection;  

    public EquipeAuditores() {
    }

    public EquipeAuditores(Long idequipe) {
        this.idequipe = idequipe;
    }

    public Long getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Long idequipe) {
        this.idequipe = idequipe;
    }

    public String getTipoauditor() {
        return tipoauditor;
    }

    public void setTipoauditor(String tipoauditor) {
        this.tipoauditor = tipoauditor;
    }

    public String getStatusequipe() {
        return statusequipe;
    }

    public void setStatusequipe(String statusequipe) {
        this.statusequipe = statusequipe;
    }

    public String getDthrincequipe() {
        return dthrincequipe;
    }

    public void setDthrincequipe(String dthrincequipe) {
        this.dthrincequipe = dthrincequipe;
    }

    public Auditores getIdauditor() {
        return idauditor;
    }

    public void setIdauditor(Auditores idauditor) {
        this.idauditor = idauditor;
    }

    public Auditores getIdauditor2() {
        return idauditor2;
    }

    public void setIdauditor2(Auditores idauditor2) {
        this.idauditor2 = idauditor2;
    }

    public Auditorias getIdaudit() {
        return idaudit;
    }

    public void setIdaudit(Auditorias idaudit) {
        this.idaudit = idaudit;
    }
 
    @XmlTransient
    public Collection< CheckList > getChecklistCollection() {
        return checklistCollection;
    }

    public void setChecklistCollection(Collection< CheckList > checklistCollection) {
        this.checklistCollection = checklistCollection;
    }
 
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipe != null ? idequipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EquipeAuditores)) {
            return false;
        }
        EquipeAuditores other = (EquipeAuditores) object;
        if ((this.idequipe == null && other.idequipe != null) || (this.idequipe != null && !this.idequipe.equals(other.idequipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.EquipeAuditores[ idequipe=" + idequipe + " ]";
    }
    
}
