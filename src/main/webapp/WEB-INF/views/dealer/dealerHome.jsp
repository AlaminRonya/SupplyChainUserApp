<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 7/30/2022
  Time: 11:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dealer's Home Page</title>
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
                <c:forEach var="responseProductDto" items="${responseProductsDto}">
                    <div class="card" style="margin-top: 20px">
                        <div class="row no-gutters">
                            <div class="col-sm-5 d-flex justify-content-center">

                                <img src="<c:url value="/page/v1/user/image-manual-response/${responseProductDto.getPhotosAttachmentList().get(0).getId()}"/>" alt="img" class="" height="150px" width="150px" />

                            </div>
                            <div class="col-sm-7 d-flex justify-content-center">
                                <div class="card-body">
                                        <%--                                    <h5 class="card-title">Product ID: ${responseProductDto.id}</h5>--%>
                                    <h5>Name: <span>${responseProductDto.name}</span></h5>
                                    <p>TK: <span>${responseProductDto.price}</span></p>
                                    <p>Description: <span>${responseProductDto.description}</span></p>
                                    <p>SKU: <span>${responseProductDto.SKU}</span></p>
                                    <a href="${pageContext.request.contextPath}/page/v1/dealers/products/cartItem/${responseProductDto.id}" class="btn btn-warning">View Product</a>
                                </div>

                            </div>

                        </div>
                    </div>
                </c:forEach>
            </div>




        </div>
    </div>

</body>
</html>
