package com.alamin_tanveer.supplychain.dto.response;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;


@Data
@ToString
public class ResponseCategoryDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private LocalDate deletedAt;
    private Boolean active = true;
}
