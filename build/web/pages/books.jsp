<%-- 
    Document   : books
    Created on : Mar 17, 2017, 5:44:26 PM
    Author     : IT10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                
                <%@include file="../WEB-INF/jspf/left-menu.jspf" %>
                
                <%@include file="../WEB-INF/jspf/right-block.jspf" %>
                
                </div>
                <div class="clear"></div>
            </div>
            <div class="footer"></div>
        </div>        
