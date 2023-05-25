package com.CoderYogi.SuperMarket.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {
    //Fields
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
@Column(name="id")
    private int id;
@Column(name="product_code")
    private String code;
    @Column(name="product_name")
    private String name;
    @Column(name="product_brand")
    private String brand;
    @Column(name="product_category")
    private String category;
    @Column(name="product_quantity")
    private int quantity;
    //Contructors
    public Product()
    {

    }

    public Product(String code, String name, String brand, String category, int quantity) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
