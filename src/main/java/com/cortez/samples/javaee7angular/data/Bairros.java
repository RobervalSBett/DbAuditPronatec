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
@Table(name = "bairros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairros.findAll", query = "SELECT b FROM Bairros b"),
    @NamedQuery(name = "Bairros.findByIdbai", query = "SELECT b FROM Bairros b WHERE b.idbai = :idbai"),
    @NamedQuery(name = "Bairros.findByDescribai", query = "SELECT b FROM Bairros b WHERE b.describai = :describai"),
    @NamedQuery(name = "Bairros.findByStatusbai", query = "SELECT b FROM Bairros b WHERE b.statusbai = :statusbai")})
public class Bairros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idbai")
    @SequenceGenerator(name = "idbai", sequenceName = "seq_bairros", allocationSize = 1)
    @Column(name = "idbai")
    private Long idbai;
    @Size(max = 60)
    @Column(name = "describai")
    private String describai;
    @Size(max = 1)
    @Column(name = "statusbai")
    private String statusbai;
    @OneToMany(mappedBy = "idbai")
    private Collection<Ceps> cepsCollection;

    public Bairros() {
    }

    public Bairros(Long idbai, String describai, String statusbai, Collection<Ceps> cepsCollection) {
        this.idbai = idbai;
        this.describai = describai;
        this.statusbai = statusbai;
        this.cepsCollection = cepsCollection;
    }
    
    
    public Bairros(Long idbai) {
        this.idbai = idbai;
    }

    public Long getIdbai() {
        return idbai;
    }

    public void setIdbai(Long idbai) {
        this.idbai = idbai;
    }

    public String getDescribai() {
        return describai;
    }

    public void setDescribai(String describai) {
        this.describai = describai;
    }

    public String getStatusbai() {
        return statusbai;
    }

    public void setStatusbai(String statusbai) {
        this.statusbai = statusbai;
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
        hash += (idbai != null ? idbai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairros)) {
            return false;
        }
        Bairros other = (Bairros) object;
        if ((this.idbai == null && other.idbai != null) || (this.idbai != null && !this.idbai.equals(other.idbai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Bairros[ idbai=" + idbai + " ]";
    }
    
}
