<%-- 
    Document   : arithmeticcalculator
    Created on : 19-Sep-2022, 2:53:35 PM
    Author     : pandawr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Arithmetic Calculator</title>
    </head>
    <body>
        <h1>Arithmetic Calculator</h1>
        <form action="arithmetic" method="post">
            First: <input type="text" name="first"><br><br>
            Second: <input type="text" name="second"><br><br>
            <button type="submit" value="add" name="button">+</button>
            <button type="submit" value="subtract" name="button">-</button>
            <button type="submit" value="multiply" name="button">*</button>
            <button type="submit" value="modulus" name="button">%</button>
        </form>
        <p>Result: ${result}</p>
        <a href="http://localhost:8084/Week3Lab_Calculators/">Age Calculator</a>
    </body>
</html>
