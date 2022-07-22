package com.alamin_tanveer.supplychain.converter;


import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.entities.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductConverter {
    @Autowired
    private InventoryDtoToPojo inventoryDtoToPojo;
    @Autowired
    private CategoryDtoToCategoryPojo categoryDtoToCategoryPojo;
    @Autowired
    private DiscountDtoToPojo discountDtoToPojo;




    public ResponseProductDto getResponseProductDto(Product product){

        ResponseProductDto dto = new ResponseProductDto();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setSKU(product.getSKU());
        dto.setPrice(product.getPrice());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setModifiedAt(product.getModifiedAt());
        dto.setDeletedAt(product.getDeletedAt());
        dto.setPhotosAttachmentList(product.getPhotosAttachmentList());
        dto.setResponseInventoryDto(inventoryDtoToPojo.pojoToDto(product.getProductInventory()));
        dto.setResponseCategoryDto(categoryDtoToCategoryPojo.pojoToDto(product.getCategory()));
        dto.setResponseDiscountDto(discountDtoToPojo.getResponseDiscountDto(product.getDiscount()));

        return dto;
    }

    public List<ResponseProductDto> getAllResponseProductDto(List<Product> products){
        return products.stream().map(this::getResponseProductDto).collect(Collectors.toList());
    }


}
