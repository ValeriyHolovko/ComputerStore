<%--
  Created by IntelliJ IDEA.
  User: Valeriy Holovko
  Date: 10.04.2016
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>

    <%String errorMessage = (String) request.getAttribute("errMessage");%>

    <h1>Error</h1> <br>
    <h1><%= errorMessage %></h1> <br>


</body>
</html>
