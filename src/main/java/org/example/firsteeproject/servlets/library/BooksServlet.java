package org.example.firsteeproject.servlets.library;

import org.postgresql.Driver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "booksServlet", value = "/booksServlet")
public class BooksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=UTF-8");

        PrintWriter pw = resp.getWriter();

        //пример создания нового подключения к базе данных Java_EE_Database для каждого пользователя по GET запросу /booksServlet
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());

            Connection connection = DriverManager.getConnection(
                            "jdbc:postgresql://localhost:5432/Java_EE_Database",
                            "postgres",
                            "22585822");


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select title from books");

            while (resultSet.next()) {
                pw.println(resultSet.getString("title"));
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}