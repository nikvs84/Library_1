<%-- 
    Document   : index
    Created on : Mar 9, 2017, 5:50:06 PM
    Author     : IT10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/style-index.css"/>
        <title>Онлайн Библиотека</title>
    </head>
    <body>
        <div class="content">
                <img alt="main-logo" src="./images/main-logo.gif" />

                <h1>Онлайн Библиотека</h1>
                <div>Рыба</div>
                <hr/>
                <div class="form-auth">
                    <form name="username" action="LogIn" method="POST">
                        <input type="text" name="username" value="" />
                        <br/>
                        <br/>
                        <!--<input type="password" name="password" value="" />-->
                        <input type="submit" value="Войти" />
                    </form>
                </div>
        </div>
    </body>
</html>
