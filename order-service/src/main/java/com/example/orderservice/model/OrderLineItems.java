package com.example.orderservice.model;


import com.example.orderservice.dto.OrderLineItemsDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "t_order_line_items")
@Getter
@AllArgsConstructor
public class OrderLineItems {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skuCode;

    private BigDecimal price;

    private Integer quantity;

    protected OrderLineItems(){

    }


    public OrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        this.id = orderLineItemsDto.getId();
        this.skuCode = orderLineItemsDto.getSkuCode();
        this.price = orderLineItemsDto.getPrice();
        this.quantity = orderLineItemsDto.getQuantity();
    }
}
