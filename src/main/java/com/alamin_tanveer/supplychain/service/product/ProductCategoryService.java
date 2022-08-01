package com.alamin_tanveer.supplychain.service.product;


import com.alamin_tanveer.supplychain.converter.CategoryDtoToCategoryPojo;
import com.alamin_tanveer.supplychain.dto.response.ResponseCategoryDto;
import com.alamin_tanveer.supplychain.entities.product.ProductCategory;
import com.alamin_tanveer.supplychain.repositories.product.ProductCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductCategoryService {
    @Autowired
    private ProductCategoryRepo productCategoryRepo;
    @Autowired
    private CategoryDtoToCategoryPojo categoryDtoToCategoryPojo;

    public List<String> getAllCategory(){
        return productCategoryRepo.findAll().stream().map(ProductCategory::getName).toList();
    }

}
