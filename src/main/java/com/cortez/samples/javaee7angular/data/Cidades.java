package com.cortez.samples.javaee7angular.data;

 

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
@Table(name = "cidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cidades.findAll", query = "SELECT c FROM Cidades c"),
    @NamedQuery(name = "Cidades.findByIdcid", query = "SELECT c FROM Cidades c WHERE c.idcid = :idcid"),
    @NamedQuery(name = "Cidades.findByDescricid", query = "SELECT c FROM Cidades c WHERE c.descricid = :descricid"),
    @NamedQuery(name = "Cidades.findByUfcid", query = "SELECT c FROM Cidades c WHERE c.ufcid = :ufcid"),
    @NamedQuery(name = "Cidades.findByStatuscid", query = "SELECT c FROM Cidades c WHERE c.statuscid = :statuscid")})
public class Cidades implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idcid")
    @SequenceGenerator(name = "idcid", sequenceName = "seq_cidades", allocationSize = 1)
    @Column(name = "idcid")
    private Long idcid;
    @Size(max = 60)
    @Column(name = "descricid")
    private String descricid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "ufcid")
    private String ufcid;
    @Size(max = 1)
    @Column(name = "statuscid")
    private String statuscid;
    @OneToMany(mappedBy = "cidades")
    private Collection<Ceps> cepsCollection;

    public Cidades() {
    }

    public Cidades(Long idcid, String descricid, String ufcid, String statuscid, Collection<Ceps> cepsCollection) {
        this.idcid = idcid;
        this.descricid = descricid;
        this.ufcid = ufcid;
        this.statuscid = statuscid;
        this.cepsCollection = cepsCollection;
    }
    
    

    public Cidades(Long idcid) {
        this.idcid = idcid;
    }

    public Cidades(Long idcid, String ufcid) {
        this.idcid = idcid;
        this.ufcid = ufcid;
    }

    public Long getIdcid() {
        return idcid;
    }

    public void setIdcid(Long idcid) {
        this.idcid = idcid;
    }

    public String getDescricid() {
        return descricid;
    }

    public void setDescricid(String descricid) {
        this.descricid = descricid;
    }

    public String getUfcid() {
        return ufcid;
    }

    public void setUfcid(String ufcid) {
        this.ufcid = ufcid;
    }

    public String getStatuscid() {
        return statuscid;
    }

    public void setStatuscid(String statuscid) {
        this.statuscid = statuscid;
    }

    @XmlTransient
    public Collection<Ceps> getCepsCollection() {
        return cepsCollection;
    }

    public void setCepsCollection(Collection<Ceps> cepsCollection) {
        this.cepsCollection = cepsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcid != null ? idcid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidades)) {
            return false;
        }
        Cidades other = (Cidades) object;
        if ((this.idcid == null && other.idcid != null) || (this.idcid != null && !this.idcid.equals(other.idcid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Cidades[ idcid=" + idcid + " ]";
    }
    
}
