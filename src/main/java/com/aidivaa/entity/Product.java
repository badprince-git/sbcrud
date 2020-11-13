package com.aidivaa.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {
        @Id
        private Integer id;
        private String name;
        private float price;
    @JsonManagedReference
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "product", optional = false)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private ProductOrders orderDetail;

        public Product() {
        }

    public Product(Integer id, String name, float price, ProductOrders orderDetail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderDetail = orderDetail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ProductOrders getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(ProductOrders orderDetail) {
        this.orderDetail = orderDetail;
    }
}
