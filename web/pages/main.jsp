<%-- 
    Document   : newjsp
    Created on : Mar 9, 2017, 5:52:21 PM
    Author     : IT10
--%>

<%@page import="beans.ItemList"%>
<%@page import="beans.Genre"%>
<%@page import="beans.BookList"%>
<%@page import="beans.Book"%>
<%@page import="beans.AuthorList"%>
<%@page import="beans.Author"%>
<%@page import="testjdbc.TestConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="../css/style-main.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <% request.setCharacterEncoding("UTF-8"); %>
        <div class="content">
            <div class="header">
                <p>Логотип</p>
            </div>
            <div class="form-auth">
                <p><%="Привет, " + request.getParameter("username")%></p>
            </div>
            <div class="search">
                <form action="#" method="GET">
                    <img alt="Search" title="Поиск" src="../images/Search.png" width="75px" />
                    <input type="text" name="words" value="search" size="100" />
                    <input type="submit" value="Искать" />
                    <select>
                        <option>Автор</option>
                        <option>Название</option>
                    </select>
                </form>
            </div>
            <div class="center">
                <div class="left">
                    <h3>Список авторов</h3>
                    <ul>
                        <% for (Author author: new AuthorList().getAuthorList()) {%>
                        <li><a href="#"><%=author.getName()%></a></li>
                        <%}%>
                    </ul>
                    <h3>Список книг</h3>
                    <ul>
                        <% for (Book book: new BookList().getBookList()) {%>
                        <li><a href="#"><%=book.getName()%></a></li>
                        <%}%>
                    </ul>
                    <h3>Список жанров</h3>
                    <ul>
                        <% for (Genre genre: new ItemList<Genre>().getItems("genre", "name")) {%>
                        <li><a href="#"><%=genre.getName()%></a></li>
                        <%}%>
                    </ul>
                </div>
                <div class="right">
                    <div class="book-info">
                        <h2>Название книги</h2>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="footer"></div>
        </div>        
        <%
//            TestConnection tc = new TestConnection();
//            tc.check();
        %>
    </body>
</html>
