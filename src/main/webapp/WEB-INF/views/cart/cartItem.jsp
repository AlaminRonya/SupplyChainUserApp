<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/23/2022
  Time: 11:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart Item</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>

<jsp:include page="../include/navbar_dealer.jsp"/>

<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-sm-3">
            <h4>Categories</h4>
            <ul class="list-group">
                <a href="${pageContext.request.contextPath}/page/v1/dealer/home"><li class="list-group-item">All Products</li></a>
                <c:forEach var="responseDto" items="${responseCategoriesDto}">
                    <a href="${pageContext.request.contextPath}/page/v1/dealer/category/search/${responseDto}">
                        <li class="list-group-item" >
                                ${responseDto}
                        </li>
                    </a>
                </c:forEach>
            </ul>
        </div>

        <div class="col-sm-9">
            <c:forEach var="responseCartItemDto" items="${responseCartItemsDto}">
                <div class="card" style="margin-top: 20px">
                    <div class="row no-gutters">
                        <div class="col-sm-5 d-flex justify-content-center">
                            <img src="<c:url value="/page/v1/user/image-manual-response/${responseCartItemDto.getProduct().getPhotosAttachmentList().get(0).getId()}"/>" alt="img" class="" height="150px" width="150px" />
                        </div>
                        <div class="col-sm-7 d-flex justify-content-center">
                            <div class="card-body">
                                <h5>Id: <span>${responseCartItemDto.id}</span></h5>
                                <h5>Username: <span>${responseCartItemDto.username}</span></h5>
                                <h5>Qty: <span>${responseCartItemDto.quantity}</span></h5>
                                <h5>Product Name: <span>${responseCartItemDto.getProduct().getCategory().getName()}</span></h5>
<%--                                <p id="price">Total TK: <span>${responseCartItemDto.getProduct().getPrice() * responseCartItemDto.quantity}</span></p>--%>
                                <p>TK: <span id="price">${responseCartItemDto.getProduct().getPrice()}</span></p>
                                <p>Discount: <span>${responseCartItemDto.getProduct().getDiscount().getDiscountPercent()}</span></p>
<%--                                <p>Total TK: <span id="total_price"></span></p>--%>

                                <a href="${pageContext.request.contextPath}/page/v1/dealers/products/order/${responseCartItemDto.id}" class="btn btn-warning">Order Item</a>
                            </div>

                        </div>

                    </div>
                </div>
            </c:forEach>
        </div>




    </div>
</div>
</body>

<script type="text/javascript">
    var incrementButton = document.getElementsByName("inc");
    var decrementButton = document.getElementsByName("dec");
    console.log(incrementButton)
    console.log(decrementButton)
    // function incrementValue() {
    //     // let element = document.getElementById("price");
    //     // const result1 = element.textContent;
    //     // let val = parseFloat(result1);
    //     //
    //     // console.log(typeof val);
    //     const elements = document.getElementsByClassName('number');
    //     for (var i = 0; i < elements.length; i++){
    //         var button = elements[i];
    //         button.addEventListener('click', function (event){
    //             var buttonClick = event.target;
    //             var input = buttonClick
    //         });
    //     }
    //
    //     let value = parseInt(document.getElementById('number').value, 10);
    //     value = isNaN(value) ? 0 : value;
    //     if(value<10){
    //         value++;
    //         document.getElementById('number').value = value;
    //     }
    //     // val = val * value;
    //     // document.getElementById("total_price").innerHTML = val.toString();
    // }
    // function decrementValue() {
    //     let value = parseInt(document.getElementById('number').value, 10);
    //     value = isNaN(value) ? 0 : value;
    //     if(value>1){
    //         value--;
    //         document.getElementById('number').value = value;
    //     }
    //
    // }
</script>
</html>
