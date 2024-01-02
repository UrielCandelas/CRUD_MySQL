<%-- 
    Document   : index
    Created on : 30 dic. 2023, 15:51:05
    Author     : urielcandelas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar</title>
    </head>
    <body>
        <div>
            <a href="/CRUD_MySQL/SecondServlet">Consultar Tareas</a>    
        </div>
        <div>
            <h1>Registrar Tarea</h1>
            <form action="/CRUD_MySQL/FirstServlet" method="POST">
                <label>
                    <input type="text" name="title" placeholder="Titulo">
                    <br>
                </label>
                <label>
                    <textarea name="description" rows="5" cols="20" placeholder="Descripción"></textarea>
                    <br>
                </label>
                <label>
                    <input type="date" name="date" placeholder="Fecha">
                    <br>
                </label>
                <label>
                    <input type="submit" value="Enviar">
                    <input type="reset" value="Limpiar Campos">
                </label>
            </form>
        </div>
    </body>
</html>
