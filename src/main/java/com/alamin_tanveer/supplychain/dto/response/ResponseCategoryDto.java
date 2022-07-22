package com.alamin_tanveer.supplychain.dto.response;

import lombok.Data;

import java.time.LocalDate;


@Data
public class ResponseCategoryDto {

    private Long id;

    private String name;
    private String description;
    private LocalDate createdAt;
    private LocalDate modifiedAt;
    private LocalDate deletedAt;
    private Boolean active = true;
}
