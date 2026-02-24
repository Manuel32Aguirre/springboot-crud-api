package com.manuel.curso.springboot.app.springboot_crud.entities;

import com.manuel.curso.springboot.app.springboot_crud.validation.IsExistsDb;
import com.manuel.curso.springboot.app.springboot_crud.validation.IsRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @IsExistsDb
    private String sku;
    
    @IsRequired(message = "{IsRequired.Product.name}")
    @Size(min = 3, max = 20, message = "{Size.Product.name}")
    private String name;

    @NotNull(message = "{NotNull.Product.price}")
    @Min(value = 500, message = "{Min.Product.price}")
    private Integer price;

    @IsRequired
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}
