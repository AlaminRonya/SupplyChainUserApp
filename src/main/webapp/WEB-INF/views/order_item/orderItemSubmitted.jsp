<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/7/2022
  Time: 11:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order item</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<jsp:include page="../include/navbar_dealer.jsp"/>

<main>
    <div class="container">

        <!--Section: Block Content-->
        <section class="mt-5 mb-4">

            <!--Grid row-->
            <div class="row">

                <!--Grid column-->
                <div class="col-lg-8">

                    <!-- Card -->
                    <div class="card wish-list mb-4">
                        <div class="card-body">
                            <h5 class="mb-4">Cart (<span>${cartCount}</span> items)</h5>

                            <c:forEach var="responseOrderCartItemDto" items="${responseCartItemsDto}">

                                <div class="row mb-4">
                                    <div class="col-md-5 col-lg-3 col-xl-3">
                                        <div class="mb-3 mb-md-0">
                                            <img class="img-fluid w-100"
                                                 src="<c:url value="/page/v1/user/image-manual-response/${responseOrderCartItemDto.getProduct().getPhotosAttachmentList().get(0).getId()}"/>"
                                            />

                                        </div>
                                    </div>
                                    <div class="col-md-7 col-lg-9 col-xl-9">
                                        <div>
                                            <div class="d-flex justify-content-between">
                                                <div>
                                                    <h5>${responseOrderCartItemDto.getProduct().getName()}</h5>
                                                    <p class="mb-3 text-uppercase small">Quantity: <span>${responseOrderCartItemDto.getQuantity()}</span> cartoon</p>

                                                </div>

                                            </div>
                                            <div class="mt-5 d-flex justify-content-between align-items-center">
                                                <div>
                                                    <a href="${pageContext.request.contextPath}/page/v1/dealers/products/remove/item/${responseOrderCartItemDto.id}"  type="button" class="card-link-secondary small text-uppercase mr-3"><i
                                                            class="fas fa-trash-alt mr-1"></i> Remove item </a>

                                                </div>
                                                <p class="mb-0"><span><strong>TK.<span>${responseOrderCartItemDto.getProduct().getPrice()}</span></strong></span></p>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </c:forEach>




                            <hr class="mb-4">

                            <p class="text-primary mb-0"><i class="fas fa-info-circle mr-1"></i> Do not delay the purchase, adding
                                items to your cart does not mean booking them.</p>

                        </div>
                    </div>




                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-lg-4">

                    <!-- Card -->
                    <div class="card mb-4">
                        <div class="card-body">
                            <h5>${username}</h5>

                            <h5 class="mb-3">The total amount </h5>

                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    Amount Payable
                                    <span>TK.<span>${totalPrice}</span></span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    Total Carton
                                    <span>${carton}</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                    Shipping fee per carton
                                    <span>${shippingFee}</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                    <div>
                                        <strong>The total amount of</strong>
                                        <strong>
                                            <p class="mb-0">(including VAT) <span>${VAT}%</span></p>
                                        </strong>
                                    </div>
                                    <span><strong>TK.<span>${total}</span></strong></span>
                                </li>
                            </ul>

                            <a href="${pageContext.request.contextPath}/page/v1/dealers/products/checkout"  class="btn btn-primary btn-block waves-effect waves-light">go to
                                checkout</a>


                        </div>
                    </div>


<%--                    <div class="card mb-4">--%>
<%--                        <div class="card-body">--%>

<%--                            <h5 class="mb-3">The total amount </h5>--%>

<%--                            <ul class="list-group list-group-flush">--%>
<%--                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">--%>
<%--                                    Amount Payable--%>
<%--                                    <span>TK.<span>${totalPrice}</span></span>--%>
<%--                                </li>--%>
<%--                                <li class="list-group-item d-flex justify-content-between align-items-center px-0">--%>
<%--                                    Shipping--%>
<%--                                    <span>Gratis</span>--%>
<%--                                </li>--%>
<%--                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">--%>
<%--                                    <div>--%>
<%--                                        <strong>The total amount of</strong>--%>
<%--                                        <strong>--%>
<%--                                            <p class="mb-0">(including VAT) <span>${VAT}%</span></p>--%>
<%--                                        </strong>--%>
<%--                                    </div>--%>
<%--                                    <span><strong>TK.<span>${total}</span></strong></span>--%>
<%--                                </li>--%>
<%--                            </ul>--%>

<%--                            <a href="${pageContext.request.contextPath}/page/v1/dealers/products/checkout"  class="btn btn-primary btn-block waves-effect waves-light">go to--%>
<%--                                checkout</a>--%>

<%--                        </div>--%>
<%--                    </div>--%>
                    <!-- Card -->

                    <!-- Card -->
                    <!--                    <div class="card mb-4">-->
                    <!--                        <div class="card-body">-->

                    <!--                            <a class="dark-grey-text d-flex justify-content-between" data-toggle="collapse" href="#collapseExample"-->
                    <!--                               aria-expanded="false" aria-controls="collapseExample">-->
                    <!--                                Add a discount code (optional)-->
                    <!--                                <span><i class="fas fa-chevron-down pt-1"></i></span>-->
                    <!--                            </a>-->

                    <!--                            <div class="collapse" id="collapseExample">-->
                    <!--                                <div class="mt-3">-->
                    <!--                                    <div class="md-form md-outline mb-0">-->
                    <!--                                        <input type="text" id="discount-code" class="form-control font-weight-light"-->
                    <!--                                               placeholder="Enter discount code">-->
                    <!--                                    </div>-->
                    <!--                                </div>-->
                    <!--                            </div>-->
                    <!--                        </div>-->
                    <!--                    </div>-->
                    <!-- Card -->

                </div>
                <!--Grid column-->

            </div>
            <!--Grid row-->

        </section>
        <!--Section: Block Content-->

    </div>
</main>

</body>
</html>
