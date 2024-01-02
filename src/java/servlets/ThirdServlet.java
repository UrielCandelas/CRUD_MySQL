/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import logic.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author urielcandelas
 */
public class ThirdServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        int id = Integer.parseInt(request.getParameter("id_jsp"));
        String title = request.getParameter("title_jsp");
        String description = request.getParameter("description_jsp");
        
        session.setAttribute("id_task", id);
        session.setAttribute("title_task", title);
        session.setAttribute("description_task", description);
        
        response.sendRedirect("update.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String date = request.getParameter("date");
        
        Task task = new Task(id,title,description,date);
        
        SQLConnection sql = new SQLConnection();
        
        try {
            sql.updateTask(task);
            response.sendRedirect("/CRUD_MySQL/SecondServlet");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
