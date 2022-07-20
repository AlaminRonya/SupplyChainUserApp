<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Md. Al Amin
  Date: 7/20/2022
  Time: 3:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dealer's Registration</title>
    <jsp:include page="../include/css.jsp"/>
</head>
<body>
<div class="container">
    <div class="col-sm-6">
        <h3 style="margin-top: 10px">Dealer's Registration</h3>
        <p>Please fill out this to register</p>
        <%--@elvariable id="dealerDto" type="com.alamin_tanveer.supplychain.dto.request.DealerDto"--%>
        <form:form action="${pageContext.request.contextPath}/page/v1/user/addDealer" method="POST" modelAttribute="dealerDto" enctype="multipart/form-data">
            <div class="form-group">
                <label for="username">App User Name</label>
                <label name="username" id="username" class="form-control form-control-lg">${currentUserEmail}</label>
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
                <form:label path="gender">Gender </form:label>
                <form:radiobutton path="gender" value="Male"/>Male
                <form:radiobutton path="gender" value="Female"/>Female
            </div>
<%--            <div class="form-group">--%>
<%--                <label>Date of Birth</label>--%>
<%--                <input type="date" name="dob" />--%>
<%--            </div>--%>
            <div class="form-group">
                <label for="phoneNumber">Your phone number</label>
                <form:input type="number" name="phoneNumber" path="phoneNumber"/>
            </div>
            <div class="form-group">
                <label for="name">Upload Your Photo</label>
                <input type="file" name="profile_image" multiple="multiple" accept="image/*"/>
            </div>


            <button type="submit" class="btn btn-primary">Create</button>
        </form:form>

    </div>
</div>


</body>
</html>
