package com.ironhack.erp.salesservice.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document(collection = "sales")
public class Sale {
    @Id
    private String id;
    private Long author;
    private Long client;
    private List<Long> products;
    private String paymentMethod;
    private BigDecimal deposited;
    private BigDecimal total;
    private BigDecimal remaining;
    private BigDecimal discount;
    private BigDecimal tax;
    private Date createdAt;

    public Sale(){}

    public Sale(Long author, Long client, List<Long> products, String paymentMethod, BigDecimal deposited, BigDecimal total, BigDecimal remaining, BigDecimal discount, BigDecimal tax) {
        this.author = author;
        this.client = client;
        this.products = new ArrayList<>();
        this.paymentMethod = paymentMethod;
        this.deposited = deposited;
        this.total = total;
        this.remaining = remaining;
        this.discount = discount;
        this.tax = tax;
        this.createdAt = new Date();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

    public List<Long> getProducts() {
        return products;
    }

    public void setProducts(List<Long> products) {
        this.products = products;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public BigDecimal getDeposited() {
        return deposited;
    }

    public void setDeposited(BigDecimal deposited) {
        this.deposited = deposited;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getRemaining() {
        return remaining;
    }

    public void setRemaining(BigDecimal remaining) {
        this.remaining = remaining;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
