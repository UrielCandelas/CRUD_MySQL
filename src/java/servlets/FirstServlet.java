/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import logic.SQLConnection;
import logic.Task;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author urielcandelas
 */
public class FirstServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        
        Task task = new Task();
        task.setDate(date);
        task.setDescription(description);
        task.setTitle(title);
        SQLConnection sql = new SQLConnection();
        try {
            sql.addTask(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("index.jsp");
        
    }

}
