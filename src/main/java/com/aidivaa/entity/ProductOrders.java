package com.aidivaa.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity(name= "prod_orders")
public class ProductOrders {
    @Id
    private int orderId;
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Product product;
    private String orderDesc;

    public ProductOrders() {
    }

    public ProductOrders(int orderId, Product product, String orderDesc) {
        this.orderId = orderId;
        this.product = product;
        this.orderDesc = orderDesc;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
