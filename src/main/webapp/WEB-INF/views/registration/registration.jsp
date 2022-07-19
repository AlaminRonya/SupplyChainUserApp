<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/4/2022
  Time: 12:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<div data-bs-spy="scroll" data-bs-target="#navbar-example2" data-bs-offset="0" class="scrollspy-example" tabindex="0">

    <div class="container-fluid">

        <div class="container">
            <div class="col-sm-6">
                <h3 style="margin-top: 10px">App User Registration</h3>
                <p>Please fill out this to register</p>
                <%--@elvariable id="registrationRequest" type="com.alamin_tanveer.supplychain.registration.RegistrationRequest"--%>
                <form:form action="${pageContext.request.contextPath}/page/v1/registration/add" method="POST" modelAttribute="registrationRequest">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <form:input type="text" name="name" id="name" path="userName"  placeholder="Your Name" class="form-control form-control-lg"/>
                            <%--                    <form:errors path="userName" cssClass="error"/>--%>
                    </div>

                    <div class="form-group">
                        <label for="email">Email address</label>
                        <form:input type="email" class="form-control form-control-lg" path="email" minlength="6" placeholder="Email" name="email" id="email"
                                    aria-describedby="emailHelp"/>
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <form:input type="password" class="form-control form-control-lg" path="password" placeholder="Password" name="password"
                                    id="password"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <form:input type="password" class="form-control form-control-lg" path="confirmedPassword" placeholder="Confirmed Password" name="confirmedPassword"
                                    id="confirmedPassword"/>
                    </div>

                    <button type="submit" class="btn btn-primary">Create</button>
                </form:form>
            </div>
        </div>
    </div>


</div>

</body>
</html>
