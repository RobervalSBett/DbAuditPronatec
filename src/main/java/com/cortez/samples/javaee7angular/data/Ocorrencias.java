
package com.cortez.samples.javaee7angular.data;

 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.SequenceGenerator; 
 
   import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pedrinho
 */
@Entity
@Table(name = "ocorrencias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ocorrencias.findAll", query = "SELECT o FROM Ocorrencias o"),
    @NamedQuery(name = "Ocorrencias.findByIdocorre", query = "SELECT o FROM Ocorrencias o WHERE o.idocorre = :idocorre"),
    @NamedQuery(name = "Ocorrencias.findByDescriocorre", query = "SELECT o FROM Ocorrencias o WHERE o.descriocorre = :descriocorre"),
    @NamedQuery(name = "Ocorrencias.findBySugesocorre", query = "SELECT o FROM Ocorrencias o WHERE o.sugesocorre = :sugesocorre"),
    @NamedQuery(name = "Ocorrencias.findByObsocorre", query = "SELECT o FROM Ocorrencias o WHERE o.obsocorre = :obsocorre"),
    @NamedQuery(name = "Ocorrencias.findByStatusocorre", query = "SELECT o FROM Ocorrencias o WHERE o.statusocorre = :statusocorre"),
    @NamedQuery(name = "Ocorrencias.findByDthrocorre", query = "SELECT o FROM Ocorrencias o WHERE o.dthrocorre = :dthrocorre"),
    @NamedQuery(name = "Ocorrencias.findByDtatualiza", query = "SELECT o FROM Ocorrencias o WHERE o.dtatualiza = :dtatualiza")})
public class Ocorrencias implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
       @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDOCORRE")
    @SequenceGenerator(name = "IDOCORRE", sequenceName = "seq_ocorrencias" ,allocationSize = 1)
    @Column(name = "idocorre")
    private Long idocorre;
    @Size(max = 254)
    @Column(name = "descriocorre")
    private String descriocorre;
    @Size(max = 254)
    @Column(name = "sugesocorre")
    private String sugesocorre;
    @Size(max = 254)
    @Column(name = "obsocorre")
    private String obsocorre;
    @Size(max = 1)
    @Column(name = "statusocorre")
    private String statusocorre;
    @Size(max = 21)
    @Column(name = "dthrocorre")
    private String dthrocorre;
    @Size(max = 21)
    @Column(name = "dtatualiza")
    private String dtatualiza;
    @JoinColumn(name = "idpontoctrl", referencedColumnName = "idpontoctrl")
    @ManyToOne(optional = false)
    private  CheckList  idpontoctrl;
    @JoinColumn(name = "idcola", referencedColumnName = "idcola")
    @ManyToOne(optional = false)
    private Colaboradores idcola;

    public Ocorrencias() {
    }

    public Ocorrencias(Long idocorre) {
        this.idocorre = idocorre;
    }

    public Long getIdocorre() {
        return idocorre;
    }

    public void setIdocorre(Long idocorre) {
        this.idocorre = idocorre;
    }

    public String getDescriocorre() {
        return descriocorre;
    }

    public void setDescriocorre(String descriocorre) {
        this.descriocorre = descriocorre;
    }

    public String getSugesocorre() {
        return sugesocorre;
    }

    public void setSugesocorre(String sugesocorre) {
        this.sugesocorre = sugesocorre;
    }

    public String getObsocorre() {
        return obsocorre;
    }

    public void setObsocorre(String obsocorre) {
        this.obsocorre = obsocorre;
    }

    public String getStatusocorre() {
        return statusocorre;
    }

    public void setStatusocorre(String statusocorre) {
        this.statusocorre = statusocorre;
    }

    public String getDthrocorre() {
        return dthrocorre;
    }

    public void setDthrocorre(String dthrocorre) {
        this.dthrocorre = dthrocorre;
    }

    public String getDtatualiza() {
        return dtatualiza;
    }

    public void setDtatualiza(String dtatualiza) {
        this.dtatualiza = dtatualiza;
    }

    public CheckList  getIdpontoctrl() {
        return idpontoctrl;
    }

    public void setIdpontoctrl(  CheckList  idpontoctrl) {
        this.idpontoctrl = idpontoctrl;
    }

    public Colaboradores getIdcola() {
        return idcola;
    }

    public void setIdcola(Colaboradores idcola) {
        this.idcola = idcola;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idocorre != null ? idocorre.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ocorrencias)) {
            return false;
        }
        Ocorrencias other = (Ocorrencias) object;
        if ((this.idocorre == null && other.idocorre != null) || (this.idocorre != null && !this.idocorre.equals(other.idocorre))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Ocorrencias[ idocorre=" + idocorre + " ]";
    }
    
}
