package com.alamin_tanveer.supplychain.converter;


import com.alamin_tanveer.supplychain.dto.response.ResponseDiscountDto;
import com.alamin_tanveer.supplychain.entities.product.Discount;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DiscountDtoToPojo {
//    public Discount getProductDiscount(DiscountDto dto){
//
//        Discount discount = new Discount();
//        discount.setName(dto.getName());
//        discount.setDescription(dto.getDescription());
//
//        return discount;
//    }

    public ResponseDiscountDto getResponseDiscountDto(Discount discount){
        ResponseDiscountDto dto = new ResponseDiscountDto();
        dto.setId(discount.getId());
        dto.setName(discount.getName());
        dto.setDescription(discount.getDescription());
        dto.setDiscountPercent(discount.getDiscountPercent());
        dto.setActive(discount.getActive());
        dto.setCreatedAt(discount.getCreatedAt());
        dto.setModifiedAt(discount.getModifiedAt());
        dto.setDeletedAt(discount.getDeletedAt());
        return dto;
    }

    public List<ResponseDiscountDto> entitiesToDto(List<Discount> discounts) {
        return	discounts.stream().map(this::getResponseDiscountDto).collect(Collectors.toList());
    }


}
