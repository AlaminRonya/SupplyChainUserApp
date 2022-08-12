package com.alamin_tanveer.supplychain.controller;

import com.alamin_tanveer.supplychain.dto.request.AddCartQuantityDto;
import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.service.order_process.CartItemService;
import com.alamin_tanveer.supplychain.service.product.ProductCategoryService;
import com.alamin_tanveer.supplychain.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/page/v1/dealers/products")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;

//    private final Hashtable<String, List<OrderCartItemDto>> orderCartItems = new Hashtable<>();


    @GetMapping("/cartItem/{id}")
    public String cartItemShow(@PathVariable("id")String id,@ModelAttribute("addCartQuantityDto")AddCartQuantityDto dto, Model model){
        final ResponseProductDto productAddCardItem = cartItemService.getResponseProductById(Long.parseLong(id));
        productAddCardItem.getResponseDiscountDto().getDiscountPercent();
        model.addAttribute("responseProductDto", productAddCardItem);
        return "cart/addToCart";
    }

    @PostMapping("/addCart/{id}")
    public String addToCart(@PathVariable("id") String id, @ModelAttribute("addCartQuantityDto")AddCartQuantityDto dto){
        System.out.println(id + "================"+dto.getQty());
        final Boolean aBoolean = cartItemService.addToCartItem(Long.parseLong(id),
                SecurityContextHolder.getContext().getAuthentication().getName(), dto);
        if (aBoolean){
            System.out.println("Inserted");
        }
        return "redirect:/page/v1/dealer/home";
    }
    @GetMapping("/cartItem/all")
    public String getAllCartItem(Model model){
        model.addAttribute("responseCategoriesDto", productCategoryService.getAllCategory());
//         cartItemService.getAllResponseCartItem().get(0).getProduct().getPhotosAttachmentList().get(0).getId();
        model.addAttribute("responseCartItemsDto", cartItemService.getAllResponseCartItem());
//        cartItemService.getAllCartItem();
        return "cart/cartItem";
    }

    @GetMapping("/order/{id}")
    public String orderCartItemById(@PathVariable("id") String id, Model model, @ModelAttribute("addCartQuantityDto")AddCartQuantityDto dto){
//        final ResponseCartItem cartItemById = cartItemService.getCartItemById(Long.parseLong(id));
        model.addAttribute("responseCartItemDto", cartItemService.getCartItemById(Long.parseLong(id)));
        return "order_item/addOrderItem";

//        return cartItemService.addCartToOrderItem(Long.parseLong(id), dto);




//        Long id1 = Long.parseLong(id);
//        final ResponseCartItem cartItemById = cartItemService.getCartItemById(id1);
//        if (cartItemById == null){
//            return "redirect:/page/v1/dealers/products/cartItem/all";
//        }
//        String username = CurrentUser.getCurrentUserName();
//
//        final OrderCartItemDto cartItemDto = new OrderCartItemDto();
//        cartItemDto.setId(id1);
//        cartItemDto.setProductName(cartItemById.getProduct().getName());
//        cartItemDto.setQty(dto.getQty());
//
//
//        if (orderCartItems.containsKey(username)){
//            final List<OrderCartItemDto> orderCartItemDtos = new ArrayList<>();
//            orderCartItemDtos.addAll(orderCartItems.get(username));
//            for (OrderCartItemDto orderDto :orderCartItemDtos){
//                if (orderDto.getId().equals(id1)){
//                    orderCartItemDtos.remove(orderDto);
//                    break;
//                }
//            }
//
//            final List<OrderCartItemDto> orderCartItemsDto = new ArrayList<>(orderCartItemDtos);
//            orderCartItemsDto.add(cartItemDto);
//            orderCartItems.replace(username, orderCartItemsDto);
//
//        }else {
//            orderCartItems.putIfAbsent(username, List.of(cartItemDto));
//        }
//        System.out.println(username+"\t"+orderCartItems.get(username));
//
//        System.out.println(id+"\t"+dto.getQty());
//        return "redirect:/page/v1/dealers/products/cartItem/all";

    }


    @PostMapping("/order/{id}")
    public String addOrderCartItem(@PathVariable("id") String id, Model model, @ModelAttribute("addCartQuantityDto")AddCartQuantityDto dto){


        return cartItemService.addCartToOrderItem(Long.parseLong(id), dto);



    }
}
