<%@ include file="include.jsp" %>

<html>
<head>
    <title>Registration</title>
</head>
<body>

<div class="row">

    <form action="/${APP_NAME}/registration" method="post">

        Login: <input name="login" type="text"> <br>
        E-mail: <input name="mail" type="text"> <br>
        Password: <input name="password" type="password"> <br>
        Name: <input name="name" type="text"> <br>
        Surname: <input name="surname" type="text"> <br>
        Phone: <input name="phone" type="number"> <br>

        <p><b>Address</b></p>

        City: <input name="city" type="text">
        Street: <input name="street" type="text"> <br>
        Building: <input name="building" type="text">
        Apartment: <input name="apartment" type="number"> <br>

        <p><b>Birthday</b></p>

        Year: <input name="year" type="number">
        Month: <input name="month" type="number">
        Day: <input name="day" type="number"> <br>

        <input type="submit" value="Register">

    </form>

</div>

</body>
</html>
