package com.alamin_tanveer.supplychain.service.product;



import com.alamin_tanveer.supplychain.converter.ProductConverter;
import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.entities.product.Product;
import com.alamin_tanveer.supplychain.repositories.product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductConverter productConverter;

    public List<ResponseProductDto> getAllProduct(){

//        List<ResponseProductDto> responseProductsDto = new ArrayList<>();
//        for (var p: productConverter.getAllResponseProductDto(productRepo.findAll())){
//            if (p.getDeletedAt() == null && p.getResponseCategoryDto().getActive()
//                    && p.getResponseInventoryDto().getQuantity() > 0){
//                responseProductsDto.add(p);
//            }
//        }
//        return responseProductsDto;


        final List<Product> all = productRepo.findAll();
        final var products = getProducts();
        if (products != null){
            return List.copyOf(productConverter.getAllResponseProductDto(products));
        }
        return null;

    }

    public List<ResponseProductDto> getAllProductByCategoryName(String categoryName){
        final var products = getProducts().stream().filter(product -> product.getCategory().getName().equals(categoryName)).toList();
        if (products != null){
            return List.copyOf(productConverter.getAllResponseProductDto(products));
        }
        return null;
    }

    private List<Product> getProducts(){
        return productRepo.findAll().stream().filter(p -> p.getDeletedAt() == null && p.getCategory().getActive() && p.getProductInventory().getQuantity() > 0).toList();
    }

    public ResponseProductDto getProductAddCardItem(Long id){
        return productSearch(id) != null ? productConverter.getResponseProductDto(productSearch(id)) : null;
    }
    public Product getProduct(Long id){
        return productSearch(id);
    }


    private Product productSearch(Long id){
        return productRepo.findById(id).orElse(null);
    }


}
