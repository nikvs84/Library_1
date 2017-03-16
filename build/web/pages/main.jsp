<%-- 
    Document   : newjsp
    Created on : Mar 9, 2017, 5:52:21 PM
    Author     : IT10
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="beans.Publisher"%>
<%@page import="java.util.ArrayList"%>
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
                    <hr />
                    
                    <h3>Список авторов</h3>
                    <ul>
                        <jsp:useBean id="authorList" class="beans.AuthorList" scope="application">
                            <c:forEach var="author" items="${authorList.getAuthorList()}">
                                <li><a href="#">${author.name}</a></li>
                            </c:forEach>
                        </jsp:useBean>
                    </ul>
                    <h3>Список книг</h3>
                    <ul>
                        <%  ArrayList<Book> bList = new ItemList().getItems("book", "name", Book.class);
                            request.setAttribute("bookList", bList);
                        %>
                        <c:forEach var="book" items="${bookList}">
                            <li><a href="#">${book.name}</a></li>
                        </c:forEach>
                    </ul>
                    
                    <hr />
                    <h3>Список книг</h3>
                    <ul>
                        <% ArrayList<Book> bookList = new ItemList().getItems("book", "name", Book.class); %>
                        <% for (Book book: bookList) {%>
                        <li><a href="#"><%=book.getName()%></a></li>
                        <%}%>
                    </ul>
                    <h3>Список жанров</h3>
                    <ul>
                        <% ArrayList<Genre> genreList = new ItemList().getItems("genre", "name", Genre.class); %>
                        <% for (Genre genre: genreList) {%>
                        <li><a href="#"><%=genre.getName()%></a></li>
                        <%}%>
                    </ul>
                    <h3>Список издательств</h3>
                    <ul>
                        <% ArrayList<Publisher> publisherList = new ItemList().getItems("publisher", "name", Publisher.class); %>
                        <% for (Publisher publisher: publisherList) {%>
                        <li><a href="#"><%=publisher.getName()%></a></li>
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
