package com.orderAPI.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "order_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderData.findAll", query = "SELECT o FROM OrderData o"),
    @NamedQuery(name = "OrderData.findByIdOrder", query = "SELECT o FROM OrderData o WHERE o.idOrder = :idOrder"),
    @NamedQuery(name = "OrderData.findByAmount", query = "SELECT o FROM OrderData o WHERE o.amount = :amount")})
public class OrderData implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_order")
    private Integer idOrder;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderData")
    private List<Delivery> deliveryList;
    @JoinColumn(name = "address", referencedColumnName = "id_address")
    @ManyToOne(optional = false)
    private Address address;
    @JoinColumn(name = "client_data", referencedColumnName = "id_client_data")
    @ManyToOne(optional = false)
    private ClientData clientData;
    @JoinColumn(name = "product", referencedColumnName = "id_product")
    @ManyToOne(optional = false)
    private Product product;

    public OrderData() {
    }

    public OrderData(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public OrderData(Integer idOrder, BigDecimal amount) {
        this.idOrder = idOrder;
        this.amount = amount;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @XmlTransient
    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ClientData getClientData() {
        return clientData;
    }

    public void setClientData(ClientData clientData) {
        this.clientData = clientData;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrder != null ? idOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderData)) {
            return false;
        }
        OrderData other = (OrderData) object;
        if ((this.idOrder == null && other.idOrder != null) || (this.idOrder != null && !this.idOrder.equals(other.idOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.orderAPI.model.OrderData[ idOrder=" + idOrder + " ]";
    }
    
}
