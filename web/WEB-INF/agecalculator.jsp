<%-- 
    Document   : agecalculator
    Created on : 19-Sep-2022, 2:52:10 PM
    Author     : pandawr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form action="age" method="post">
            Enter your age: <input type="number" name="age"><br>
            <button type="submit">Calculate</button>
        </form>
        <p>${message}</p>
        <a href="/arithmetic">Arithmetic Calculator</a>
    </body>
</html>
