package com.alamin_tanveer.supplychain.service.order_process;

import com.alamin_tanveer.supplychain.converter.CartItemConverter;
import com.alamin_tanveer.supplychain.dto.request.AddCartQuantityDto;
import com.alamin_tanveer.supplychain.dto.request.CheckoutDto;
import com.alamin_tanveer.supplychain.dto.request.OrderCartItemDto;
import com.alamin_tanveer.supplychain.dto.response.ResponseCartItem;
import com.alamin_tanveer.supplychain.dto.response.ResponseProductDto;
import com.alamin_tanveer.supplychain.entities.order_process.CartItem;
import com.alamin_tanveer.supplychain.entities.product.Product;
import com.alamin_tanveer.supplychain.repositories.order_process.CartItemRepo;
import com.alamin_tanveer.supplychain.service.product.ProductService;
import com.alamin_tanveer.supplychain.utils.Constant;
import com.alamin_tanveer.supplychain.utils.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class CartItemService {
    @Autowired
    private CartItemRepo cartItemRepo;
    @Autowired
    private ProductService productService;
    @Autowired
    private CartItemConverter cartItemConverter;

    private final LocalDate localDate = LocalDate.now();

    private final Hashtable<String, List<OrderCartItemDto>> orderCartItems = new Hashtable<>();


    public Boolean addToCartItem(Long productId, String username, AddCartQuantityDto dto){
        System.out.println(productId+" : "+username);
        final CartItem search = search(productId, username);
        System.out.println(search);
        final Product productAddCardItem = productService.getProduct(productId);

        if (search == null && productAddCardItem != null){
            CartItem cartItem = new CartItem();
            cartItem.setCreatedAt(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            cartItem.setUsername(username);
            cartItem.setProduct(productAddCardItem);
            cartItem.setQuantity(dto.getQty());

            cartItemRepo.save(cartItem);
            return true;
        }
        System.out.println("All ready exist");
        return false;

    }

    public ResponseProductDto getResponseProductById(Long id){
        return productService.getProductAddCardItem(id);
    }

    public List<ResponseCartItem> getAllResponseCartItem(){
        final List<CartItem> allCartItem = getAllCartItem();
        if (allCartItem != null){
            return cartItemConverter.getAllResponseCartItem(allCartItem);
        }
        return null;
    }

    private List<CartItem> getAllCartItem(){
        return cartItemRepo.getCartByProductUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElse(null);
    }


    private CartItem search(Long productId, String username){
        return cartItemRepo.getCartByProductIdAndUsername(productId, username).orElse(null);
    }

    public ResponseCartItem getCartItemById(Long id) {
        final CartItem cartItem = cartItemRepo.findById(id).orElse(null);
        if (cartItem != null){
            return cartItemConverter.getResponseCartItem(cartItem);
        }
        return null;
    }



    public String addCartToOrderItem(Long id, AddCartQuantityDto dto) {

        final ResponseCartItem cartItemById = getCartItemById(id);
        if (cartItemById == null){
            return "redirect:/page/v1/dealers/products/cartItem/all";
        }


        final OrderCartItemDto cartItemDto = new OrderCartItemDto();
        cartItemDto.setCartId(id);
        cartItemDto.setProductName(cartItemById.getProduct().getName());
        cartItemDto.setQty(dto.getQty());


        String username = CurrentUser.getCurrentUserName();
        if (orderCartItems.containsKey(username)){
            final List<OrderCartItemDto> orderCartItemDtos = removedItemByUsername(username, id);

            final List<OrderCartItemDto> orderCartItemsDto = new ArrayList<>(orderCartItemDtos);
            orderCartItemsDto.add(cartItemDto);
            orderCartItems.replace(username, orderCartItemsDto);

        }else {
            orderCartItems.putIfAbsent(username, List.of(cartItemDto));
        }
        System.out.println(username+"\t"+orderCartItems.get(username));

        System.out.println(id+"\t"+dto.getQty());

        return "redirect:/page/v1/dealers/products/cartItem/all";

    }


    public List<ResponseCartItem> getOrderItems(){
//        for (String k: orderCartItems.keySet()){
//            System.out.println(k.hashCode()%10+"\t"+k+"\t"+orderCartItems.get(k));
//
//        }

        final List<OrderCartItemDto> orderCartItemDtos = orderCartItemByUser();
        List<ResponseCartItem> responseCartItems = new ArrayList<>();
        if (orderCartItemDtos != null){
            for (OrderCartItemDto dto: orderCartItemDtos){
                final ResponseCartItem cartItemById = getCartItemById(dto.getCartId());
                cartItemById.setQuantity(dto.getQty());
                responseCartItems.add(cartItemById);
            }
        }


//        responseCartItems.get(0).getQuantity();


        return responseCartItems;
    }
    private synchronized List<OrderCartItemDto> orderCartItemByUser(){
        String username = CurrentUser.getCurrentUserName();
        if (orderCartItems.containsKey(username)){
            return orderCartItems.get(username);
        }
        return null;
    }

    public Boolean removeOrderItemById(Long id){
        String username = CurrentUser.getCurrentUserName();
        if (orderCartItems.containsKey(username)) {
            removedItemByUsername(username, id);
            return true;
        }

        return false;

    }

    public Double getTotalPrice(){
        final List<ResponseCartItem> orderItems = getOrderItems();
        if (orderItems != null){
            return getOrderItems().stream().map(p -> (p.getProduct().getPrice() * p.getQuantity()) -
                    ((p.getProduct().getDiscount().getDiscountPercent() / 100) * (p.getProduct().getPrice() * p.getQuantity()))).reduce(0.0, Double::sum);

        }
        return 0.0;
    }
    public Double getTotalPriceAndOthers(){
        return getTotalPrice() + (getTotalPrice() * (Constant.VAT/100))+(getTotalCarton()*Constant.SHIPPING_FEE);
    }
    public Integer getTotalCarton(){
        final List<OrderCartItemDto> orderCartItemDtos = orderCartItemByUser();
        if (orderCartItemDtos != null){
            return orderCartItemDtos.stream().map(OrderCartItemDto::getQty).reduce(0, Integer::sum);
        }
        return 0;
    }

    private synchronized List<OrderCartItemDto> removedItemByUsername(String username, Long id){
        final List<OrderCartItemDto> orderCartItemDtos = new ArrayList<>(orderCartItems.get(username));
        for (OrderCartItemDto orderDto :orderCartItemDtos){
            if (orderDto.getCartId().equals(id)){
                orderCartItemDtos.remove(orderDto);
                break;
            }
        }
        orderCartItems.replace(username, orderCartItemDtos);

        return orderCartItemByUser();
    }

    public synchronized List<OrderCartItemDto> orderDealer(String username) {
        if (orderCartItems.containsKey(username)){
            return orderCartItems.get(username);


        }
        return null;
    }
}
