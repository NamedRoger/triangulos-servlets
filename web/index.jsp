<%-- 
    Document   : index
    Created on : 15 feb 2021, 0:52:58
    Author     : rogev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controllers.muestraResultado"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Triangulo</h1>
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
    </body>
</html>
