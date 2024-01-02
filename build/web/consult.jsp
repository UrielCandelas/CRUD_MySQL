<%-- 
    Document   : consult
    Created on : 30 dic. 2023, 16:49:09
    Author     : urielcandelas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="logic.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar</title>
    </head>
    <body>
        <div>
            <a href="index.jsp">Regresar</a>
        </div>
        <h1>Tareas Registradas</h1>
        <table border = 1>
            <tr>
                <th>ID</th>
                <th>Titulo</th>
                <th>Descripción</th>
                <th>Fecha</th>
                <th>Opciones</th>
            </tr>
            <% List<Task> tasks = (List<Task>) session.getAttribute("arrayTareas"); %>
            <%for(Task task : tasks) { %>
                <tr>
                    <td><%=task.getId()%></td>
                    <td><%=task.getTitle()%></td>
                    <td><%=task.getDescription()%></td>
                    <td><%=task.getDate()%></td>
                    <td>
                        <form action="/CRUD_MySQL/ThirdServlet" method="GET">
                            <input type="hidden" name="id_jsp" value="<%=task.getId()%>">
                            <input type="hidden" name="title_jsp" value="<%=task.getTitle()%>">
                            <input type="hidden" name="description_jsp" value="<%=task.getDescription()%>">
                            <input type="submit" value="Editar">
                        </form>
                        <form action="/CRUD_MySQL/FourthServlet" method="POST">
                            <input type="hidden" name="id_jsp" value="<%=task.getId()%>">
                            <input type="submit" value="Eliminar">
                        </form>
                    </td>
                </tr>
            <%}%>


        </table>
    </body>
</html>
