<%@include file="include.jsp" %>

<html>
<head>
    <title>Add product</title>
</head>
<body>

<div id="row">

    <form action="/${APP_NAME}/product/add" method="post">

        Brand : <input name="brand" type="text"><br>
        Model : <input name="model" type="text"><br>
        Price : <input name="price" type="text"><br>

        <input type="submit" value="add">

    </form>

</div>

</body>
</html>
