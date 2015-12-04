
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
@Table(name = "auditorias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditorias.findAll", query = "SELECT a FROM Auditorias a"),
    @NamedQuery(name = "Auditorias.findByIdaudit", query = "SELECT a FROM Auditorias a WHERE a.idaudit = :idaudit"),
    @NamedQuery(name = "Auditorias.findByDescriaudit", query = "SELECT a FROM Auditorias a WHERE a.descriaudit = :descriaudit"),
    @NamedQuery(name = "Auditorias.findByDescriobjaudit", query = "SELECT a FROM Auditorias a WHERE a.descriobjaudit = :descriobjaudit"),
    @NamedQuery(name = "Auditorias.findByTipoaudit", query = "SELECT a FROM Auditorias a WHERE a.tipoaudit = :tipoaudit"),
    @NamedQuery(name = "Auditorias.findByObsaudit", query = "SELECT a FROM Auditorias a WHERE a.obsaudit = :obsaudit"),
    @NamedQuery(name = "Auditorias.findByStatusaudit", query = "SELECT a FROM Auditorias a WHERE a.statusaudit = :statusaudit"),
    @NamedQuery(name = "Auditorias.findByDthrcadaudit", query = "SELECT a FROM Auditorias a WHERE a.dthrcadaudit = :dthrcadaudit"),
    @NamedQuery(name = "Auditorias.findByDthriniaudit", query = "SELECT a FROM Auditorias a WHERE a.dthriniaudit = :dthriniaudit"),
    @NamedQuery(name = "Auditorias.findByDthrrealiaudit", query = "SELECT a FROM Auditorias a WHERE a.dthrrealiaudit = :dthrrealiaudit"),
    @NamedQuery(name = "Auditorias.findByDtatualiza", query = "SELECT a FROM Auditorias a WHERE a.dtatualiza = :dtatualiza"),
    @NamedQuery(name = "Auditorias.findByCertificadoras", query = "SELECT a FROM Auditorias a WHERE a.certificadoras = :certificadoras")})
public class Auditorias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDAUDIT")
    @SequenceGenerator(name = "IDAUDIT", sequenceName = "seq_auditorias",allocationSize = 1)
    @Column(name = "idaudit")
    private Long idaudit;
    @Size(max = 254)
    @Column(name = "descriaudit")
    private String descriaudit;
    @Size(max = 254)
    @Column(name = "descriobjaudit")
    private String descriobjaudit;
    @Size(max = 1)
    @Column(name = "tipoaudit")
    private String tipoaudit;
    @Size(max = 100)
    @Column(name = "obsaudit")
    private String obsaudit;
    @Size(max = 1)
    @Column(name = "statusaudit")
    private String statusaudit;
    @Size(max = 21)
    @Column(name = "dthrcadaudit")
    private String dthrcadaudit;
    @Size(max = 21)
    @Column(name = "dthriniaudit")
    private String dthriniaudit;
    @Size(max = 21)
    @Column(name = "dthrrealiaudit")
    private String dthrrealiaudit;
    @Size(max = 21)
    @Column(name = "dtatualiza")
    private String dtatualiza;
    @Size(max = 100)
    @Column(name = "certificadoras")
    private String certificadoras;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaudit")
    private Collection<EquipeAuditores> equipeauditoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaudit")
    private Collection<CheckList> checklistCollection;
    @JoinColumn(name = "idcert", referencedColumnName = "idcert")
    @ManyToOne(optional = false)
    private Certificadoras certificadora;
    @JoinColumn(name = "idcli", referencedColumnName = "idcli")
    @ManyToOne(optional = false)
    private Clientes idcli;

    public Auditorias() {
    }

    public Certificadoras getCertificadora() {
        return certificadora;
    }

    public void setCertificadora(Certificadoras certificadora) {
        this.certificadora = certificadora;
    }
    
    

    public Auditorias(Long idaudit) {
        this.idaudit = idaudit;
    }

    public Long getIdaudit() {
        return idaudit;
    }

    public void setIdaudit(Long idaudit) {
        this.idaudit = idaudit;
    }

    public String getDescriaudit() {
        return descriaudit;
    }

    public void setDescriaudit(String descriaudit) {
        this.descriaudit = descriaudit;
    }

    public String getDescriobjaudit() {
        return descriobjaudit;
    }

    public void setDescriobjaudit(String descriobjaudit) {
        this.descriobjaudit = descriobjaudit;
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

    public String getStatusaudit() {
        return statusaudit;
    }

    public void setStatusaudit(String statusaudit) {
        this.statusaudit = statusaudit;
    }

    public String getDthrcadaudit() {
        return dthrcadaudit;
    }

    public void setDthrcadaudit(String dthrcadaudit) {
        this.dthrcadaudit = dthrcadaudit;
    }

    public String getDthriniaudit() {
        return dthriniaudit;
    }

    public void setDthriniaudit(String dthriniaudit) {
        this.dthriniaudit = dthriniaudit;
    }

    public String getDthrrealiaudit() {
        return dthrrealiaudit;
    }

    public void setDthrrealiaudit(String dthrrealiaudit) {
        this.dthrrealiaudit = dthrrealiaudit;
    }

    public String getDtatualiza() {
        return dtatualiza;
    }

    public void setDtatualiza(String dtatualiza) {
        this.dtatualiza = dtatualiza;
    }

    public String getCertificadoras() {
        return certificadoras;
    }

    public void setCertificadoras(String certificadoras) {
        this.certificadoras = certificadoras;
    }

    @XmlTransient
    public Collection<EquipeAuditores> getEquipeauditoresCollection() {
        return equipeauditoresCollection;
    }

    public void setEquipeauditoresCollection(Collection<EquipeAuditores> equipeauditoresCollection) {
        this.equipeauditoresCollection = equipeauditoresCollection;
    }

    @XmlTransient
    public Collection<CheckList> getChecklistCollection() {
        return checklistCollection;
    }

    public void setChecklistCollection(Collection<CheckList> checklistCollection) {
        this.checklistCollection = checklistCollection;
    }

    /* public Certificadoras getIdcert() {
        return idcert;
    }

    public void setIdcert(Certificadoras idcert) {
        this.idcert = idcert;
    }  */                   

    public Clientes getIdcli() {
        return idcli;
    }

    public void setIdcli(Clientes idcli) {
        this.idcli = idcli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaudit != null ? idaudit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditorias)) {
            return false;
        }
        Auditorias other = (Auditorias) object;
        if ((this.idaudit == null && other.idaudit != null) || (this.idaudit != null && !this.idaudit.equals(other.idaudit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Auditorias[ idaudit=" + idaudit + " ]";
    }
    
}
