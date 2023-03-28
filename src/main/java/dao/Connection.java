/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author willi
 */
public abstract class Connection {

    public static java.sql.Connection getConnetionDataBase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");
        return conn;
    }
}
