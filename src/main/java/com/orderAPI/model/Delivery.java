package com.orderAPI.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d"),
    @NamedQuery(name = "Delivery.findByIdDelivery", query = "SELECT d FROM Delivery d WHERE d.idDelivery = :idDelivery")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_delivery")
    private Integer idDelivery;
    @JoinColumn(name = "address", referencedColumnName = "id_address")
    @ManyToOne(optional = false)
    private Address address;
    @JoinColumn(name = "order_data", referencedColumnName = "id_order")
    @ManyToOne(optional = false)
    private OrderData orderData;

    public Delivery() {
    }

    public Delivery(Integer idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Integer getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(Integer idDelivery) {
        this.idDelivery = idDelivery;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDelivery != null ? idDelivery.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.idDelivery == null && other.idDelivery != null) || (this.idDelivery != null && !this.idDelivery.equals(other.idDelivery))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orderAPI.model.Delivery[ idDelivery=" + idDelivery + " ]";
    }
    
}
