<%-- 
    Document   : resultado
    Created on : 15 feb 2021, 0:55:16
    Author     : rogev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Triangulo" %>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Triangulo triangulo = (Triangulo)request.getAttribute("triangulo");
        %>
        
        <h1>Resultado</h1>
        <h3>Área:</h3>
        <p><%=triangulo.getArea()%></p>
        
        <h3>Perimetro:</h3>
        <p><%=triangulo.getPerimetro()%></p>
        <a href="index.jsp">Regresar</a>
    </body>
</html>
