<%@include file="WEB-INF/pages/include.jsp"%>

<html>
<head>
    <title>Main</title>
</head>
<body>

<nav>
    <c:if test="${inSystem}">
        <c:out value="Hello, ${currentUserName}!"/>
        <p> <a href=""/>Sign out</p>
    </c:if>

    <ul>

        <c:if test="${!inSystem}">
            <li><a href="login"/>Login</li>
            <li><a href="registration"/>Register</li>
        </c:if>
        <li><a href="product/add"/>Add product</li>

    </ul>
</nav>

</body>
</html>
