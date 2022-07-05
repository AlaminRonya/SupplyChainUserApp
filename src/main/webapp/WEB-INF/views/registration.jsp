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
    <jsp:include page="./include/css.jsp"/>
</head>
<body>
<jsp:include page="./include/navbar.jsp"/>
<div class="container-fluid">

    <div class="container">
        <div class="col-sm-6">
            <h3 style="margin-top: 10px">App User Registration</h3>
            <p>Please fill out this to register</p>
            <%--@elvariable id="registrationRequest" type="com.alamin_tanveer.supplychain.registration.RegistrationRequest"--%>
            <form:form action="${pageContext.request.contextPath}/api/page/v1/user/add" method="POST" modelAttribute="registrationRequest" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="name">Name</label>
                    <form:input type="text" name="name" id="name" path="userName"  placeholder="Your Name" class="form-control form-control-lg"/>
<%--                    <form:errors path="userName" cssClass="error"/>--%>
                </div>
                <div class="form-group">
                    <label for="name">NID</label>
                    <form:input type="number" name="name" id="name" path="userNID"  placeholder="Your NID number" class="form-control form-control-lg"/>
                </div>
                <div class="form-group">
                    <label for="name">Trade License number</label>
                    <form:input type="number" name="name" id="name" path="tradeLicenseNumber"  placeholder="Your Trade License number" class="form-control form-control-lg"/>
                </div>

                <div class="form-group">
                    <label for="name">Trade License Upload file pdf</label>
                    <input type= "file" name="upload_file" multiple="multiple" accept = "application/pdf"/>
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
                    <form:label path="gender">Gender </form:label>
                    <form:radiobutton path="gender" value="Male"/>Male
                    <form:radiobutton path="gender" value="Female"/>Female
                </div>
                <div class="form-group">
                    <label for="name">Trade License Upload file pdf</label>
                    <input type="file" name="profile_image" multiple="multiple" accept="image/*"/>
                </div>


                <button type="submit" class="btn btn-primary">Create</button>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
