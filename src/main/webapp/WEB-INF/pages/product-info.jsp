<%@ page import="model.ProductEntity" %>
<%@ page import="java.lang.reflect.Field" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product info</title>
</head>
<body>
    <%
        ProductEntity product = (ProductEntity) request.getAttribute("product");
    %>

    <h1>Product</h1>

    brand : <%=product.getBrand()%><br>
    model : <%=product.getModel()%><br>
    price : <%=product.getPrice()%><br>
    product : <%=product%><br>

</body>
</html>
