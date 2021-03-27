<%@page import="javax.swing.text.html.HTML.Tag"%>
<%-- 
    Document   : index
    Created on : 15 feb 2021, 0:52:58
    Author     : rogev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controllers.muestraResultado"%>
<%@page import="controllers.Login"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Cookie ck[] = request.getCookies();
            HttpSession sesion = request.getSession(false);
        %>

        <%if (sesion.getAttribute("usuario") != null) {%>
        
        <h1>Triangulo</h1>
        <h4>Bienvenido <% out.print(sesion.getAttribute("usuario").toString()); %></h4>
        <%
            for(int i=0;i < ck.length;i++){
                if(ck[i].getName().equals("base"))out.println("base: "+ck[i].getValue());
                if(ck[i].getName().equals("altura"))out.println("altura: "+ck[i].getValue());
                if(ck[i].getName().equals("area"))out.println("area: "+ck[i].getValue());
                if(ck[i].getName().equals("perimetro"))out.println("perimetro: "+ck[i].getValue());
            }
        %>
        <form action="muestraResultado" method="post">
            <div>
                <label>Base:</label>
                <input type="number" name="base">
            </div>
            <div>
                <label>Altura: </label>
                <input type="number" name="altura">
            </div>
            <button>
                Calcular
            </button>
        </form>
        <%}else{%>
        <form method="POST" action="login">
            <label>
                Usuario: 
            </label>
            <input name="usuario">
            <button>
                Login
            </button>
        </form>
        <% }%>

    </body>
</html>
