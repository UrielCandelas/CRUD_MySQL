<%-- 
    Document   : update
    Created on : 30 dic. 2023, 19:37:46
    Author     : urielcandelas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% int id = (int)session.getAttribute("id_task"); %>
        <% String title = (String)session.getAttribute("title_task"); %>
        <% String description = (String)session.getAttribute("description_task"); %>
        
        
        <h1>Editar datos</h1>
        
        <form action="/CRUD_MySQL/ThirdServlet" method="POST">
            <label>
                <input type="text" name="title" placeholder="Titulo" value="<%= title %>">
                <br>
            </label>
            <label>
                <textarea name="description" rows="5" cols="20"><%= description %></textarea>
                <br>
            </label>
            <label>
                <input type="date" name="date" placeholder="Fecha">
                <br>
            </label>
            <label>
                <input type="hidden" name="id" value="<%=id%>">
                <input type="submit" value="Enviar">
            </label>
        </form>
    </body>
</html>
