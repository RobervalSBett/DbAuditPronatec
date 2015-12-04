
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
@Table(name = "checklist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = " CheckList .findAll", query = "SELECT c FROM  CheckList  c"),
    @NamedQuery(name = " CheckList .findByIdpontoctrl", query = "SELECT c FROM  CheckList  c WHERE c.idpontoctrl = :idpontoctrl"),
    @NamedQuery(name = " CheckList .findByDocprocesso", query = "SELECT c FROM  CheckList  c WHERE c.docprocesso = :docprocesso"),
    @NamedQuery(name = " CheckList .findByDescrichklist", query = "SELECT c FROM  CheckList  c WHERE c.descrichklist = :descrichklist"),
    @NamedQuery(name = " CheckList .findByObschklist", query = "SELECT c FROM  CheckList  c WHERE c.obschklist = :obschklist"),
    @NamedQuery(name = " CheckList .findByStatuschklist", query = "SELECT c FROM  CheckList  c WHERE c.statuschklist = :statuschklist"),
    @NamedQuery(name = " CheckList .findByDthrrealichklist", query = "SELECT c FROM  CheckList  c WHERE c.dthrrealichklist = :dthrrealichklist"),
    @NamedQuery(name = " CheckList .findByDtatualiza", query = "SELECT c FROM  CheckList  c WHERE c.dtatualiza = :dtatualiza")})
public class  CheckList  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDPONTOCTRL")
    @SequenceGenerator(name = "IDPONTOCTRL", sequenceName = "seq_checklist",allocationSize = 1)
    @Column(name = "idpontoctrl")
    private Long idpontoctrl;
    @Size(max = 12)
    @Column(name = "docprocesso")
    private String docprocesso;
    @Size(max = 254)
    @Column(name = "descrichklist")
    private String descrichklist;
    @Size(max = 254)
    @Column(name = "obschklist")
    private String obschklist;
    @Size(max = 1)
    @Column(name = "statuschklist")
    private String statuschklist;
    @Size(max = 21)
    @Column(name = "dthrrealichklist")
    private String dthrrealichklist;
    @Size(max = 21)
    @Column(name = "dtatualiza")
    private String dtatualiza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpontoctrl")
    private Collection<Ocorrencias> ocorrenciasCollection;   
    @JoinColumn(name = "idaudit", referencedColumnName = "idaudit")
    @ManyToOne(optional = false)
    private Auditorias idaudit;
    @JoinColumn(name = "idcola", referencedColumnName = "idcola")
    @ManyToOne(optional = false)
    private Colaboradores idcola;
    @JoinColumn(name = "idequipe", referencedColumnName = "idequipe")
    @ManyToOne(optional = false)
    private EquipeAuditores idequipe;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpontoctrl")
    private Collection<NaoConformidades> naoconformidadesCollection;    

    public  CheckList () {
    }

    public  CheckList (Long idpontoctrl) {
        this.idpontoctrl = idpontoctrl;
    }

    public Long getIdpontoctrl() {
        return idpontoctrl;
    }

    public void setIdpontoctrl(Long idpontoctrl) {
        this.idpontoctrl = idpontoctrl;
    }

    public String getDocprocesso() {
        return docprocesso;
    }

    public void setDocprocesso(String docprocesso) {
        this.docprocesso = docprocesso;
    }

    public String getDescrichklist() {
        return descrichklist;
    }

    public void setDescrichklist(String descrichklist) {
        this.descrichklist = descrichklist;
    }

    public String getObschklist() {
        return obschklist;
    }

    public void setObschklist(String obschklist) {
        this.obschklist = obschklist;
    }

    public String getStatuschklist() {
        return statuschklist;
    }

    public void setStatuschklist(String statuschklist) {
        this.statuschklist = statuschklist;
    }

    public String getDthrrealichklist() {
        return dthrrealichklist;
    }

    public void setDthrrealichklist(String dthrrealichklist) {
        this.dthrrealichklist = dthrrealichklist;
    }

    public String getDtatualiza() {
        return dtatualiza;
    }

    public void setDtatualiza(String dtatualiza) {
        this.dtatualiza = dtatualiza;
    }

      @XmlTransient
    public Collection<Ocorrencias> getOcorrenciasCollection() {
        return ocorrenciasCollection;
    }

    public void setOcorrenciasCollection(Collection<Ocorrencias> ocorrenciasCollection) {
        this.ocorrenciasCollection = ocorrenciasCollection;
    }    

    public Auditorias getIdaudit() {
        return idaudit;
    }

    public void setIdaudit(Auditorias idaudit) {
        this.idaudit = idaudit;
    }

    public Colaboradores getIdcola() {
        return idcola;
    }

    public void setIdcola(Colaboradores idcola) {
        this.idcola = idcola;
    }

    public EquipeAuditores getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(EquipeAuditores idequipe) {
        this.idequipe = idequipe;
    }

    @XmlTransient
    public Collection<NaoConformidades> getNaoconformidadesCollection() {
        return naoconformidadesCollection;
    }

    public void setNaoconformidadesCollection(Collection<NaoConformidades> naoconformidadesCollection) {
        this.naoconformidadesCollection = naoconformidadesCollection;
    }
  
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpontoctrl != null ? idpontoctrl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof  CheckList )) {
            return false;
        }
         CheckList  other = ( CheckList ) object;
        if ((this.idpontoctrl == null && other.idpontoctrl != null) || (this.idpontoctrl != null && !this.idpontoctrl.equals(other.idpontoctrl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste. CheckList [ idpontoctrl=" + idpontoctrl + " ]";
    }
    
}
