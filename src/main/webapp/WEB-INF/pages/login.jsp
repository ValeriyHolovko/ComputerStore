<%@include file="include.jsp"%>

<html>
<head>
    <title>Login</title>
</head>
<body>

<div class="row">

    <form action="/${APP_NAME}/login" method="post">

        Login: <input name="login" type="text">
        Password: <input name="password" type="password">

        <input type="submit" value="Enter">

    </form>

</div>

</body>
</html>
