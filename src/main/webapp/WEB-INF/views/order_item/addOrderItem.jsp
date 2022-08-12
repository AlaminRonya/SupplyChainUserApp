<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/25/2022
  Time: 9:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Details</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
    <div class="container" style="margin-top: 30px">
        <div class="row">
            <div class="col-sm-9">

                <div class="card" style="margin-top: 20px">
                    <div class="row no-gutters">
                        <div class="col-sm-5 d-flex justify-content-center">
                            <img src="<c:url value="/page/v1/user/image-manual-response/${responseCartItemDto.getProduct().getPhotosAttachmentList().get(0).getId()}"/>" alt="img" class="" height="150px" width="150px" />
                        </div>
                        <div class="col-sm-7 d-flex justify-content-center">
                            <div class="card-body">
                                <h5>Id: <span>${responseCartItemDto.id}</span></h5>
                                <h5>Username: <span>${responseCartItemDto.username}</span></h5>
                                <h5>Qty: <span id="resp_qty">${responseCartItemDto.quantity}</span></h5>
                                <h5>Product Name: <span>${responseCartItemDto.getProduct().getCategory().getName()}</span></h5>
                                <p>TK: <span id="price">${responseCartItemDto.getProduct().getPrice()}</span></p>
                                <p>Discount: <span id="discount">${responseCartItemDto.getProduct().getDiscount().getDiscountPercent()}</span></p>
                                <p>Total TK: <span id="total_price"></span></p>

                                <%--@elvariable id="addCartQuantityDto" type="com.alamin_tanveer.supplychain.dto.request.AddCartQuantityDto"--%>
                                <form:form action="${pageContext.request.contextPath}/page/v1/dealers/products/order/${responseCartItemDto.id}" method="post" modelAttribute="addCartQuantityDto">
                                    <input type="button" onclick="decrementValue()" value="-" />
                                    <form:input type="number" name="quantity" value="${responseCartItemDto.quantity}" maxlength="2" max="10" size="1" id="number"   path="qty"/>
                                    <input type="button" onclick="incrementValue()" value="+" />
                                    <br/>
                                    <br/>
                                    <button type="submit" class="btn btn-primary">Order Item</button>
                                </form:form>
                            </div>

                        </div>

                    </div>
                </div>

            </div>
        </div>
    </div>



</body>
<script type="text/javascript">
    window.onload = function(){
        let qty = parseInt(document.getElementById('resp_qty').textContent);
        calculateValue(qty);
    }
    function incrementValue()
    {


        let qty = parseInt(document.getElementById('number').value, 10);
        qty = isNaN(qty) ? 0 : qty;
        if(qty<10){
            qty++;
            document.getElementById('number').value = qty;
        }
        calculateValue(qty);

    }
    function decrementValue() {
        let qty = parseInt(document.getElementById('number').value, 10);
        qty = isNaN(qty) ? 0 : qty;
        if(qty>1){
            qty--;
            document.getElementById('number').value = qty;
        }
        calculateValue(qty);

    }
    function calculateValue(qty){
        let element = document.getElementById("price");
        let elementDiscount = document.getElementById("discount");
        const priceTxt = element.textContent;
        const discountTxt = elementDiscount.textContent;
        let price = parseFloat(priceTxt);
        console.log(price)
        let discount = parseFloat(discountTxt);
        discount = discount/100;
        console.log(discount)

        let discountPrice = price * 0.1 * qty;
        price = (price * qty) -  discountPrice;
        console.log(price)
        document.getElementById("total_price").innerHTML = price.toString();
    }

</script>
</html>
