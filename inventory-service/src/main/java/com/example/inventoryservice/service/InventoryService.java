package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponse;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStockByList(List<String> skuCode) {
        List<InventoryResponse> result = inventoryRepository.findBySkuCodeIn(skuCode).stream().map(inventory ->
                InventoryResponse.builder()
                        .isInStock(inventory.getQuantity() > 0)
                        .skuCode(inventory.getSkuCode())
                        .quantity(inventory.getQuantity())
                        .build()
        ).collect(Collectors.toList());
        return result;
    }
}
