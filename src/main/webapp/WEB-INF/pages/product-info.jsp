<%@ include file="include.jsp" %>


<html>
<head>
    <title>Product info</title>
</head>
<body>
<%-- JSTL--%>
<c:set var="varProduct" value="${product}"></c:set>

<h1>Product</h1>

brand : ${varProduct.brand}<br>
model : ${varProduct.model}<br>
price : ${varProduct.price}<br>

product : ${varProduct}

<%--<%ProductEntity product = (ProductEntity) request.getAttribute("product");%>
<h1>Product</h1>
brand : <%=product.getBrand()%><br>
model : <%=product.getModel()%><br>
price : <%=product.getPrice()%><br>
product : <%=product%><br>--%>

</body>
</html>
