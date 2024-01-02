package servlets;

import logic.*;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author urielcandelas
 */
public class SecondServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SQLConnection sql = new SQLConnection();
        try {
            List<Task> tasks = sql.getTasks();
            HttpSession session = request.getSession();
            session.setAttribute("arrayTareas", tasks);

            response.sendRedirect("/CRUD_MySQL/consult.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
