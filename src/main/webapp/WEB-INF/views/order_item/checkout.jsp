<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/10/2022
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Checkout Page</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>

<jsp:include page="../include/navbar_dealer.jsp"/>

<div class="container">

    <!--Section: Block Content-->
    <section class="mt-5 mb-4">

        <!--Grid row-->
        <div class="row">

            <!--Grid column-->
            <div class="col-lg-8 mb-4">

                <!-- Card -->
                <div class="card wish-list pb-1">
                    <div class="card-body">

                        <h5 class="mb-2">Billing details</h5>

                        <%--@elvariable id="checkoutDto" type="com.alamin_tanveer.supplychain.dto.request.CheckoutDto"--%>
                        <form:form action="${pageContext.request.contextPath}/page/v1/dealers/products/checkout" method="post" modelAttribute="checkoutDto" >

                            <!-- Grid row -->
                            <div class="row">

                                <!-- Grid column -->
                                <div class="col-lg-6">

                                    <!-- First name -->
                                    <div class="md-form md-outline mb-0 mb-lg-4">
                                        <label for="firstName">First name</label>
                                        <form:input type="text" id="firstName" path="firstName"  class="form-control mb-0 mb-lg-2"/>
                                        <form:errors path="firstName" cssClass="text-danger"/>
                                    </div>

                                </div>
                                <!-- Grid column -->

                                <!-- Grid column -->
                                <div class="col-lg-6">

                                    <!-- Last name -->
                                    <div class="md-form md-outline">
                                        <label for="lastName">Last name</label>
                                        <form:input type="text" id="lastName" path="lastName" class="form-control"/>
                                        <form:errors path="lastName" cssClass="text-danger"/>
                                    </div>

                                </div>
                                <!-- Grid column -->

                            </div>
                            <!-- Grid row -->



                            <!-- Country -->
                            <div class="d-flex flex-wrap">
                                <div class="select-outline position-relative w-100">
                                    <label>Country - <strong>BANGLADESH</strong></label>
                                </div>
                            </div>

                            <!-- Address Part 1 -->
                            <div class="md-form md-outline mt-2">
                                <label for="form14">Address</label>
                                <form:input type="text"  path="address" id="form14" placeholder="House number and street name" class="form-control"/>
                                <form:errors path="address" cssClass="text-danger"/>
                            </div>


                            <!-- Postcode / ZIP -->
                            <div class="md-form md-outline mt-3">
                                <label for="form16">Postcode / ZIP</label>
                                <form:input type="text" maxlength="6" minlength="6" path="postCodeOrZip" id="form16" class="form-control"/>
                                <form:errors path="postCodeOrZip" cssClass="text-danger"/>
                            </div>

                            <!-- Town / City -->
                            <div class="md-form md-outline mt-2">
                                <label for="form17">Town / City</label>
                                <form:input type="text" path="townOrCity" id="form17" class="form-control"/>
                                <form:errors path="townOrCity" cssClass="text-danger"/>

                            </div>

                            <!-- Phone -->
                            <div class="md-form md-outline mt-2">
                                <label for="form18">Phone</label>
                                <form:input type="number" minlength="11" maxlength="11" path="phoneNumber" id="form18" class="form-control"/>
                                <form:errors path="phoneNumber" cssClass="text-danger"/>
                            </div>

                            <!-- Email address -->
                            <div class="md-form md-outline mt-2">
                                <label for="form19">Email address</label>
                                <form:input type="email" path="username" id="form19" class="form-control"/>
                                <form:errors path="username" cssClass="text-danger"/>
                            </div>

                            <!-- Account Number -->
                            <div class="md-form md-outline mt-2">
                                <label for="form19">Account Number</label>
                                <form:input type="number" path="accountNumber" id="form19" class="form-control"/>
                                <form:errors path="accountNumber" cssClass="text-danger"/>
                            </div>

                            <!-- Address Part 2 -->
                            <div class="md-form md-outline mt-2">
                                <label for="form15">Amount minimum 50%</label>
                                <form:input type="number" id="form15" path="amount" placeholder="Enter your amount minimum half payment"
                                       class="form-control"/>
                                <form:errors path="amount" cssClass="text-danger"/>
                            </div>

                            <!-- Additional information -->
                            <div class="md-form md-outline mt-2">
                                <label for="form76">Additional information</label>
                                <form:textarea path="additionalInfo" id="form76" class="md-textarea form-control" rows="4"/>
                                <form:errors path="additionalInfo" cssClass="text-danger"/>
                            </div>
                            <br/>


                            <button type="submit"  class="btn btn-primary btn-block waves-effect waves-light">Pay Now</button>
                        </form:form>
                    </div>
                </div>
                <!-- Card -->

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




                    </div>
                </div>


            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->

    </section>
    <!--Section: Block Content-->


</div>

</body>
</html>
