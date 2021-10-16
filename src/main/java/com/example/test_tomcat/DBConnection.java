package com.example.test_tomcat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




/**
 * @author Chandan Singh
 */
public class DBConnection
{
    public static Connection getConnection() throws SQLException, ClassNotFoundException, NamingException
    {
        Context ctx = new InitialContext();
        DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/TestDB");
        Connection connection = ds.getConnection();
        System.out.println(connection);

        return connection;
    }

}