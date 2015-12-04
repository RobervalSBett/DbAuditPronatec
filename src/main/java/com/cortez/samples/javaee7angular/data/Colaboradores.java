
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
@Table(name = "colaboradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaboradores.findAll", query = "SELECT c FROM Colaboradores c"),
    @NamedQuery(name = "Colaboradores.findByIdcola", query = "SELECT c FROM Colaboradores c WHERE c.idcola = :idcola"),
    @NamedQuery(name = "Colaboradores.findByNomecola", query = "SELECT c FROM Colaboradores c WHERE c.nomecola = :nomecola"),
    @NamedQuery(name = "Colaboradores.findByFone1cola", query = "SELECT c FROM Colaboradores c WHERE c.fone1cola = :fone1cola"),
    @NamedQuery(name = "Colaboradores.findByFone2cola", query = "SELECT c FROM Colaboradores c WHERE c.fone2cola = :fone2cola"),
    @NamedQuery(name = "Colaboradores.findByEmailcola", query = "SELECT c FROM Colaboradores c WHERE c.emailcola = :emailcola"),
    @NamedQuery(name = "Colaboradores.findByObscola", query = "SELECT c FROM Colaboradores c WHERE c.obscola = :obscola"),
    @NamedQuery(name = "Colaboradores.findByStatuscola", query = "SELECT c FROM Colaboradores c WHERE c.statuscola = :statuscola")})
public class Colaboradores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDCOLA")
    @SequenceGenerator(name = "IDCOLA", sequenceName = "seq_colaboradores", allocationSize = 1)
    @Column(name = "idcola")
    private  Long  idcola;
    @Size(max = 60)
    @Column(name = "nomecola")
    private String nomecola;
    @Size(max = 15)
    @Column(name = "fone1cola")
    private String fone1cola;
    @Size(max = 15)
    @Column(name = "fone2cola")
    private String fone2cola;
    @Size(max = 100)
    @Column(name = "emailcola")
    private String emailcola;
    @Size(max = 254)
    @Column(name = "obscola")
    private String obscola;
    @Size(max = 1)
    @Column(name = "statuscola")
    private String statuscola;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcola")
    private Collection<Ocorrencias> ocorrenciasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcola")
    private Collection<CheckList> checklistCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcola")
    private Collection<NaoConformidades> naoconformidadesCollection;

    public Colaboradores() {
    }

    public Colaboradores( Long idcola) {
        this.idcola = idcola;
    }

    public Long  getIdcola() {
        return idcola;
    }

    public void setIdcola( Long idcola) {
        this.idcola = idcola;
    }

    public String getNomecola() {
        return nomecola;
    }

    public void setNomecola(String nomecola) {
        this.nomecola = nomecola;
    }

    public String getFone1cola() {
        return fone1cola;
    }

    public void setFone1cola(String fone1cola) {
        this.fone1cola = fone1cola;
    }

    public String getFone2cola() {
        return fone2cola;
    }

    public void setFone2cola(String fone2cola) {
        this.fone2cola = fone2cola;
    }

    public String getEmailcola() {
        return emailcola;
    }

    public void setEmailcola(String emailcola) {
        this.emailcola = emailcola;
    }

    public String getObscola() {
        return obscola;
    }

    public void setObscola(String obscola) {
        this.obscola = obscola;
    }

    public String getStatuscola() {
        return statuscola;
    }

    public void setStatuscola(String statuscola) {
        this.statuscola = statuscola;
    }

    @XmlTransient
    public Collection<Ocorrencias> getOcorrenciasCollection() {
        return ocorrenciasCollection;
    }

    public void setOcorrenciasCollection(Collection<Ocorrencias> ocorrenciasCollection) {
        this.ocorrenciasCollection = ocorrenciasCollection;
    }

    @XmlTransient
    public Collection<CheckList> getChecklistCollection() {
        return checklistCollection;
    }

    public void setChecklistCollection(Collection<CheckList> checklistCollection) {
        this.checklistCollection = checklistCollection;
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
        hash += (idcola != null ? idcola.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaboradores)) {
            return false;
        }
        Colaboradores other = (Colaboradores) object;
        if ((this.idcola == null && other.idcola != null) || (this.idcola != null && !this.idcola.equals(other.idcola))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Colaboradores[ idcola=" + idcola + " ]";
    }
    
}
