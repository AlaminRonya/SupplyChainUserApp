package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page/v1/user/category")
public class CategoryController {
    @Autowired
    private ProductService productService;

    @GetMapping("/search/{category_name}")
    public String searchCategory(@PathVariable("category_name") String categoryName, Model model){
        final List<ResponseProductDto> allProductByCategoryName = productService.getAllProductByCategoryName(categoryName);
        model.addAttribute("responseProductsDto", allProductByCategoryName);
        System.out.println(categoryName);
        return "";
    }
}
