<%-- 
    Document   : Login
    Created on : Jun 13, 2022, 2:16:55 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="Login" method ="POST">
            UserName: <input type="text" name="name"/> <br>
            Password: <input type="password" name="pass"/> <br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
