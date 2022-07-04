<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 6/9/2022
  Time: 12:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Location: ${attachment.getAttachmentPath()}<br>
<%--<img src="<c:url value="/api/page/v1/image-manual-response/${attachment.getAttachmentName()}"/>" alt="img" width="300" height="auto"/>--%>
</body>
</html>
