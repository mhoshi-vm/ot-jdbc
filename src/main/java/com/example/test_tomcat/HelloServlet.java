package com.example.test_tomcat;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanKind;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.extension.annotations.WithSpan;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;


    public void init() {
        message = "";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        DBConnection dbConnection = new DBConnection();
        try {
            message = getAuthors(dbConnection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }



    public String getAuthors(DBConnection dbConnection) throws SQLException {
        Connection connection = null;

        String response = "";
        try {
            connection = dbConnection.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "SELECT * FROM authors";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                response+=rs.getString("name")+ " mail:" + rs.getString("email") +"<br>";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return response;
    }
}