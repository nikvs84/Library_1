<%-- 
    Document   : newjsp
    Created on : Mar 9, 2017, 5:52:21 PM
    Author     : IT10
--%>




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
                <div class="clear"></div>
            </div>
            <div class="footer"></div>
        </div>        
        <%
//            TestConnection tc = new TestConnection();
//            tc.check();
        %>

