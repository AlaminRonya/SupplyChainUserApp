package com.alamin_tanveer.supplychain.converter;


import com.alamin_tanveer.supplychain.dto.response.ResponseInventoryDto;
import com.alamin_tanveer.supplychain.entities.product.ProductInventory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InventoryDtoToPojo {

//    public ProductInventory getProductInventory(ProductInventoryDto dto){
//
//        ProductInventory inventory = new ProductInventory();
//        inventory.setQuantity(dto.getQuantity());
//
//        return inventory;
//    }

    public ResponseInventoryDto pojoToDto(ProductInventory inventory){

        ResponseInventoryDto inventoryDto = new ResponseInventoryDto();
        inventoryDto.setId(inventory.getId());
        inventoryDto.setQuantity(inventory.getQuantity());
        inventoryDto.setCreatedAt(inventory.getCreatedAt());
        if (inventory.getModifiedAt() != null){
            inventoryDto.setModifiedAt(inventory.getModifiedAt());
        }
        if (inventory.getDeletedAt() != null){
            inventoryDto.setDeletedAt(inventory.getDeletedAt());
        }

        return inventoryDto;
    }

    public List<ResponseInventoryDto> entitiesToDto(List<ProductInventory> productInventories) {
        return	productInventories.stream().map(this::pojoToDto).collect(Collectors.toList());
    }

}
