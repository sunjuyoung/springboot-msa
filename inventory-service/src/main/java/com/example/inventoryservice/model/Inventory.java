package com.example.inventoryservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory")
@Getter
@AllArgsConstructor
public class Inventory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skuCode;
    private Integer quantity;

    protected Inventory(){}

    public Inventory(String skuCode, Integer quantity) {
        this.skuCode = skuCode;
        this.quantity = quantity;
    }
}
