<%-- 
    Document   : content
    Created on : Mar 22, 2017, 2:16:19 PM
    Author     : IT10
--%>

<%@page pageEncoding="UTF-8"%>

<%
    long bookId = -1;
    if (request.getParameter("index") != null)
        bookId = Long.valueOf(request.getParameter("index"));
    
        
    String referer = request.getHeader("referer");
    
%>
<p><a href="<%=referer%>">< < вернуться</a></p>
<iframe src="<%=request.getContextPath()%>/PdfContent?index=<%=bookId%>" width="100%" height="650" alt="Попробуйте в другом браузере"></iframe>
