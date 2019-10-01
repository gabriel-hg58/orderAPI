package com.orderAPI.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "client_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientData.findAll", query = "SELECT c FROM ClientData c"),
    @NamedQuery(name = "ClientData.findByIdClientData", query = "SELECT c FROM ClientData c WHERE c.idClientData = :idClientData"),
    @NamedQuery(name = "ClientData.findByClientName", query = "SELECT c FROM ClientData c WHERE c.clientName = :clientName")})
public class ClientData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_client_data")
    private Integer idClientData;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "client_name")
    private String clientName;

    public ClientData() {
    }

    public ClientData(Integer idClientData) {
        this.idClientData = idClientData;
    }

    public ClientData(Integer idClientData, String clientName) {
        this.idClientData = idClientData;
        this.clientName = clientName;
    }

    public Integer getIdClientData() {
        return idClientData;
    }

    public void setIdClientData(Integer idClientData) {
        this.idClientData = idClientData;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClientData != null ? idClientData.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientData)) {
            return false;
        }
        ClientData other = (ClientData) object;
        if ((this.idClientData == null && other.idClientData != null) || (this.idClientData != null && !this.idClientData.equals(other.idClientData))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orderAPI.model.ClientData[ idClientData=" + idClientData + " ]";
    }
    
}
