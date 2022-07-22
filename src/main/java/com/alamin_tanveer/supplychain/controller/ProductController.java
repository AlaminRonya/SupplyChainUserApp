package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/page/v1/dealers/products")
//@RequestMapping("/page/v1/user/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public String getAllProduct(Model model){
        System.out.println(productService.getAllProduct());
//        final List<ResponseProductDto> allProduct = productService.getAllProduct();
//        allProduct.get(0).getPhotosAttachmentList().get(0).getAttachmentPath();
        model.addAttribute("responseProductsDto",productService.getAllProduct());
        return "shop/shop";
    }
}
