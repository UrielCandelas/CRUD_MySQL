/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author urielcandelas
 */
public class SQLConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/tasksCRUD";
    private static final String USER = "root";
    private static final String PASSWORD = "n0m3l0S@";

    List<Task> tasks;

    public SQLConnection() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) throws SQLException,ClassNotFoundException {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        String SQLQuery = "INSERT INTO tasks (title,description,date) VALUES (?,?,?)";

        PreparedStatement ps = con.prepareStatement(SQLQuery);

        ps.setString(1, task.getTitle());
        ps.setString(2, task.getDescription());
        ps.setString(3, task.getDate());

        int filasAfectadas = ps.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("Datos insertados exitosamente");
        } else {
            System.out.println("No se pudo insertar datos.");
        }

    }

    public void updateTask(Task task) throws SQLException, ClassNotFoundException{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String SQLQuery = "UPDATE tasks SET title=?, description=?, date=? WHERE id=?";
        
        PreparedStatement ps = con.prepareStatement(SQLQuery);

        ps.setString(1, task.getTitle());
        ps.setString(2, task.getDescription());
        ps.setString(3, task.getDate());
        ps.setInt(4, task.getId());

        int filasAfectadas = ps.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("Datos modificados exitosamente");
        } else {
            System.out.println("No se pudo modificar datos.");
        }
        

    }

    public void deleteTask(int id) throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
        String SQLQuery = "DELETE  FROM tasks WHERE id  = ?";
        
        PreparedStatement ps = con.prepareStatement(SQLQuery);
        ps.setInt(1, id);

        int filasAfectadas = ps.executeUpdate();
        
        if (filasAfectadas > 0) {
            System.out.println("Datos eliminados exitosamente");
        } else {
            System.out.println("No se pudo eliminar datos.");
        }
    }

    public List<Task> getTasks()throws SQLException,ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

        String SQLQuery = "SELECT * FROM tasks";
        
        PreparedStatement ps = con.prepareStatement(SQLQuery);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Task task = new Task(rs.getInt("id"),rs.getString("title"), rs.getString("description"), rs.getString("date"));
            tasks.add(task);
        }
        
        return tasks;
    }

}
