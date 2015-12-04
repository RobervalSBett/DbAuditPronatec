
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
@Table(name = "naoconformidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = " NaoConformidades .findAll", query = "SELECT n FROM  NaoConformidades  n"),
    @NamedQuery(name = " NaoConformidades .findByIdnc", query = "SELECT n FROM  NaoConformidades  n WHERE n.idnc = :idnc"),
    @NamedQuery(name = " NaoConformidades .findByDescrinc", query = "SELECT n FROM  NaoConformidades  n WHERE n.descrinc = :descrinc"),
    @NamedQuery(name = " NaoConformidades .findBySugestaonc", query = "SELECT n FROM  NaoConformidades  n WHERE n.sugestaonc = :sugestaonc"),
    @NamedQuery(name = " NaoConformidades .findByStatusnc", query = "SELECT n FROM  NaoConformidades  n WHERE n.statusnc = :statusnc"),
    @NamedQuery(name = " NaoConformidades .findByObsnc", query = "SELECT n FROM  NaoConformidades  n WHERE n.obsnc = :obsnc"),
    @NamedQuery(name = " NaoConformidades .findByDthrcadnc", query = "SELECT n FROM  NaoConformidades  n WHERE n.dthrcadnc = :dthrcadnc"),
    @NamedQuery(name = " NaoConformidades .findByDtprevresolnc", query = "SELECT n FROM  NaoConformidades  n WHERE n.dtprevresolnc = :dtprevresolnc"),
    @NamedQuery(name = " NaoConformidades .findByDtatualiza", query = "SELECT n FROM  NaoConformidades  n WHERE n.dtatualiza = :dtatualiza")})
public class  NaoConformidades  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull 
    
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "IDNC")
    @SequenceGenerator(name = "IDNC", sequenceName = "seq_naoconformidades",allocationSize = 1)
    @Column(name = "idnc")
    private Long idnc;
    @Size(max = 254)
    @Column(name = "descrinc")
    private String descrinc;
    @Size(max = 254)
    @Column(name = "sugestaonc")
    private String sugestaonc;
    @Size(max = 1)
    @Column(name = "statusnc")
    private String statusnc;
    @Size(max = 254)
    @Column(name = "obsnc")
    private String obsnc;
    @Size(max = 21)
    @Column(name = "dthrcadnc")
    private String dthrcadnc;
    @Size(max = 21)
    @Column(name = "dtprevresolnc")
    private String dtprevresolnc;
    @Size(max = 21)
    @Column(name = "dtatualiza")
    private String dtatualiza;
    @JoinColumn(name = "idpontoctrl", referencedColumnName = "idpontoctrl")
    @ManyToOne(optional = false)
    private CheckList idpontoctrl;
    @JoinColumn(name = "idcola", referencedColumnName = "idcola")
    @ManyToOne(optional = false)
    private Colaboradores idcola;

    public  NaoConformidades () {
    }

    public  NaoConformidades (Long idnc) {
        this.idnc = idnc;
    }

    public Long getIdnc() {
        return idnc;
    }

    public void setIdnc(Long idnc) {
        this.idnc = idnc;
    }

    public String getDescrinc() {
        return descrinc;
    }

    public void setDescrinc(String descrinc) {
        this.descrinc = descrinc;
    }

    public String getSugestaonc() {
        return sugestaonc;
    }

    public void setSugestaonc(String sugestaonc) {
        this.sugestaonc = sugestaonc;
    }

    public String getStatusnc() {
        return statusnc;
    }

    public void setStatusnc(String statusnc) {
        this.statusnc = statusnc;
    }

    public String getObsnc() {
        return obsnc;
    }

    public void setObsnc(String obsnc) {
        this.obsnc = obsnc;
    }

    public String getDthrcadnc() {
        return dthrcadnc;
    }

    public void setDthrcadnc(String dthrcadnc) {
        this.dthrcadnc = dthrcadnc;
    }

    public String getDtprevresolnc() {
        return dtprevresolnc;
    }

    public void setDtprevresolnc(String dtprevresolnc) {
        this.dtprevresolnc = dtprevresolnc;
    }

    public String getDtatualiza() {
        return dtatualiza;
    }

    public void setDtatualiza(String dtatualiza) {
        this.dtatualiza = dtatualiza;
    }

    public CheckList getIdpontoctrl() {
        return idpontoctrl;
    }

    public void setIdpontoctrl(CheckList  idpontoctrl) {
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
        hash += (idnc != null ? idnc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof  NaoConformidades )) {
            return false;
        }
         NaoConformidades  other = ( NaoConformidades ) object;
        if ((this.idnc == null && other.idnc != null) || (this.idnc != null && !this.idnc.equals(other.idnc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste. NaoConformidades [ idnc=" + idnc + " ]";
    }
    
}
