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
        <form action="age" method="post">
            First: <input type="number" name="first" value="${first}"><br>
            Second <input type="number" name="second" value="${second}"><br>
            <input type="submit" value="Age next birthday">
        </form>
        <p>Result: --- ${message}</p>
    </body>
</html>
