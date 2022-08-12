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
                            <img src="<c:url value="/page/v1/user/image-manual-response/${responseProductDto.getPhotosAttachmentList().get(0).getId()}"/>" alt="img" class="" height="150px" width="150px" />
                        </div>
                        <div class="col-sm-7 d-flex justify-content-center">
                            <div class="card-body">
                                <h5>Product Name: <span>${responseProductDto.name}</span></h5>
                                <p>TK: <span>${responseProductDto.price}</span></p>
                                <p>Product Description: <span>${responseProductDto.description}</span></p>
                                <p>Product SKU: <span>${responseProductDto.SKU}</span></p>
                                <p>Discount: <span>${responseProductDto.responseDiscountDto.discountPercent}</span></p>


                                <%--@elvariable id="addCartQuantityDto" type="com.alamin_tanveer.supplychain.dto.request.AddCartQuantityDto"--%>
                                <form:form action="${pageContext.request.contextPath}/page/v1/dealers/products/addCart/${responseProductDto.id}" method="post" modelAttribute="addCartQuantityDto">
                                    <input type="button" onclick="decrementValue()" value="-" />
                                    <form:input type="number" name="quantity" value="1" maxlength="2" max="10" size="1" id="number"   path="qty"/>
                                    <input type="button" onclick="incrementValue()" value="+" />
                                    <br/>
                                    <br/>
                                    <button type="submit" class="btn btn-primary">Add Cart</button>
                                </form:form>



<%--                                <a href="${pageContext.request.contextPath}/page/v1/dealers/products/addCart/${responseProductDto.id}" class="btn btn-warning">Add Cart</a>--%>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>



</body>
<script type="text/javascript">
    function incrementValue()
    {
        let value = parseInt(document.getElementById('number').value, 10);
        value = isNaN(value) ? 0 : value;
        if(value<10){
            value++;
            document.getElementById('number').value = value;
        }
    }
    function decrementValue()
    {
        let value = parseInt(document.getElementById('number').value, 10);
        value = isNaN(value) ? 0 : value;
        if(value>1){
            value--;
            document.getElementById('number').value = value;
        }

    }
</script>
</html>
