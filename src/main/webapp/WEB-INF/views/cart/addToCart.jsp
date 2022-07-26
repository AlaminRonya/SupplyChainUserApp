<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                <a href="${pageContext.request.contextPath}/page/v1/dealers/products/addCart/${responseProductDto.id}" class="btn btn-warning">Add Cart</a>
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
