package com.orderAPI.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findByIdAddress", query = "SELECT a FROM Address a WHERE a.idAddress = :idAddress"),
    @NamedQuery(name = "Address.findByStreet", query = "SELECT a FROM Address a WHERE a.street = :street"),
    @NamedQuery(name = "Address.findByEstablishmentNumber", query = "SELECT a FROM Address a WHERE a.establishmentNumber = :establishmentNumber"),
    @NamedQuery(name = "Address.findByNeighborhood", query = "SELECT a FROM Address a WHERE a.neighborhood = :neighborhood"),
    @NamedQuery(name = "Address.findByComplement", query = "SELECT a FROM Address a WHERE a.complement = :complement"),
    @NamedQuery(name = "Address.findByZipCode", query = "SELECT a FROM Address a WHERE a.zipCode = :zipCode")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_address")
    private Integer idAddress;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Column(name = "establishment_number")
    private int establishmentNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "neighborhood")
    private String neighborhood;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "complement")
    private String complement;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "zip_code")
    private String zipCode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<Delivery> deliveryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "address")
    private List<OrderData> orderDataList;

    public Address() {
    }

    public Address(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public Address(Integer idAddress, String street, int establishmentNumber, String neighborhood, String complement, String zipCode) {
        this.idAddress = idAddress;
        this.street = street;
        this.establishmentNumber = establishmentNumber;
        this.neighborhood = neighborhood;
        this.complement = complement;
        this.zipCode = zipCode;
    }

    public Integer getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(Integer idAddress) {
        this.idAddress = idAddress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getEstablishmentNumber() {
        return establishmentNumber;
    }

    public void setEstablishmentNumber(int establishmentNumber) {
        this.establishmentNumber = establishmentNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @XmlTransient
    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    @XmlTransient
    public List<OrderData> getOrderDataList() {
        return orderDataList;
    }

    public void setOrderDataList(List<OrderData> orderDataList) {
        this.orderDataList = orderDataList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddress != null ? idAddress.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.idAddress == null && other.idAddress != null) || (this.idAddress != null && !this.idAddress.equals(other.idAddress))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orderAPI.model.Address[ idAddress=" + idAddress + " ]";
    }
    
}
