/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class StudentDAO {

    private static java.sql.Connection conn = null;
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    public static Integer insertStudent(Student student) throws SQLException, ClassNotFoundException {
        try {
            Integer status;
            conn = Connection.getConnetionDataBase();
            pst = conn.prepareStatement("insert into records (name, course, fee) values (?,?,?)");
            pst.setString(1, student.getName());
            pst.setString(2, student.getCourse());
            pst.setString(3, student.getFee());
            status = pst.executeUpdate();
            return status;
        } finally {
            closeConnection(conn, pst, rs);
        }
    }

    public static Integer updateStudent(Student student) throws SQLException, ClassNotFoundException {
        try {
            Integer status;
            conn = Connection.getConnetionDataBase();
            pst = conn.prepareStatement("update records set name=?, course=?, fee=? where id=?");
            pst.setString(1, student.getName());
            pst.setString(2, student.getCourse());
            pst.setString(3, student.getFee());
            pst.setInt(4, student.getId());
            status = pst.executeUpdate();
            return status;
        } finally {
            closeConnection(conn, pst, rs);
        }
    }

    public static List<Student> getStudents() throws SQLException, ClassNotFoundException {
        try {
            Student std;
            List<Student> listStudents = new ArrayList<>();

            conn = Connection.getConnetionDataBase();
            pst = conn.prepareStatement("select * from records");
            rs = pst.executeQuery();

            while (rs.next()) {
                std = new Student(rs.getInt("id"), rs.getString("name"),
                        rs.getString("course"), rs.getString("fee"));
                listStudents.add(std);
            }

            return listStudents;
        } finally {
            closeConnection(conn, pst, rs);
        }
    }

    public static void deleteStudent(Integer id) throws SQLException, ClassNotFoundException {
        try {
            conn = Connection.getConnetionDataBase();
            pst = conn.prepareStatement("delete from records where id=?");
            pst.setInt(1, id);
            pst.executeUpdate();
        } finally {
            closeConnection(conn, pst, rs);
        }
    }

    private static void closeConnection(java.sql.Connection conn, PreparedStatement pst, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, "closeConnection", ex);
        }
    }
}
