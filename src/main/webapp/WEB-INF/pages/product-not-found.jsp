<%@ include file="include.jsp" %>

<html>
<head>
    <title>Error</title>
</head>
<body>

<%String errorMessage = (String) request.getAttribute("errMessage");%>

<h1>Error</h1> <br>
<p><%= errorMessage %></p> <br>

</body>
</html>
