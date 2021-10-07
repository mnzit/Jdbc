package com.nepalaya.jdbc.dao.impl;

import com.nepalaya.jdbc.dao.StudentDAO;
import com.nepalaya.jdbc.model.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAODatabaseImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean update(Student student) throws Exception {
        return false;
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }

    @Override
    public List<Student> getAll() throws Exception {
//        Class.forName("com.mysql.cj.jdbc.Driver");
        Class.forName("org.postgresql.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "Root@12345");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_demo", "manjitshakya", "1218");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM STUDENTS");
        List<Student> students = new ArrayList<>();

        while (rs.next()) {
            Student student = Student
                    .builder()
                    .id(rs.getLong("ID"))
                    .name(rs.getString("NAME"))
                    .address(rs.getString("ADDRESS"))
                    .dob(rs.getDate("DOB"))
                    .contactNo(rs.getString("CONTACT_NO"))
                    .createdDate(rs.getDate("CREATED_DATE"))
                    .status(rs.getBoolean("STATUS"))
                    .build();
            students.add(student);
        }

        if(!students.isEmpty()){
            return students;
        }else{
            throw new RuntimeException("There are no students in the system yet");
        }

    }

    @Override
    public Student getById(Long id) throws Exception {
        return null;
    }
}
