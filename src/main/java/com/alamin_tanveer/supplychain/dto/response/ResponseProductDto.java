package com.alamin_tanveer.supplychain.dto.response;


import com.alamin_tanveer.supplychain.entities.Attachment;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class ResponseProductDto {

    private Long id;
    private String name;
    private String description;
    private String SKU;
    private Double price;
    private Date createdAt;
    private Date modifiedAt;
    private Date deletedAt;
    private ResponseCategoryDto responseCategoryDto;
    private ResponseInventoryDto responseInventoryDto;
    private ResponseDiscountDto responseDiscountDto;
    private List<Attachment> photosAttachmentList;

}
