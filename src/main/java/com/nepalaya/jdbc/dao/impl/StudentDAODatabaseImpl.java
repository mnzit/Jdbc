package com.nepalaya.jdbc.dao.impl;

import com.nepalaya.jdbc.dao.StudentDAO;
import com.nepalaya.jdbc.model.Student;
import com.nepalaya.jdbc.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAODatabaseImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "Root@12345");
        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO STUDENTS(NAME,ADDRESS,DOB,CONTACT_NO) VALUES(?,?,?,?)");
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getAddress());
        preparedStatement.setDate(3, DateUtil.convertJavaDateToSQLDate(student.getDob()));
        preparedStatement.setString(4, student.getContactNo());
        int rowAffected = preparedStatement.executeUpdate();

        if (rowAffected > 0) {
            return true;
        } else {
            throw new RuntimeException("Adding Student Failed");
        }
    }


    @Override
    public boolean update(Student student) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "Root@12345");
        final String PARAM_PLACEHOLDER = "{{PARAMS}}";
        String sql = "UPDATE STUDENTS SET " + PARAM_PLACEHOLDER + " WHERE ID=?";

        StringBuilder parameter = new StringBuilder();
        String template = "%s=?";

        Map<String, Object> params = new HashMap<>();

        int index = 1;

        if (student.getName() != null) {
            params.put("NAME", student.getName());
        }
        if (student.getDob() != null) {
            params.put("DOB", student.getDob());
        }
        if (student.getAddress() != null) {
            params.put("ADDRESS", student.getAddress());
        }
        if (student.getContactNo() != null) {
            params.put("CONTACT_NO", student.getContactNo());
        }

        int size = params.size();
        int tracker = 0;

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            parameter.append(String.format(template, entry.getKey()));
            if (size > 1 && tracker + 1 != size) {
                parameter.append(",");
            }
            tracker++;
        }

        if (parameter.toString().isEmpty()) {
            throw new RuntimeException("There is nothing to update (Parameters required)");
        }

        sql = sql.replace(PARAM_PLACEHOLDER, parameter);

        PreparedStatement preparedStatement = con.prepareStatement(sql);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            preparedStatement.setObject(index++, entry.getValue());
        }

        preparedStatement.setLong(index++, student.getId());

        int rowAffected = preparedStatement.executeUpdate();

        if (rowAffected > 0) {
            return true;
        } else {
            throw new RuntimeException("Updating Student Failed");
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        return false;
    }

    // CRUD - READ
    @Override
    public List<Student> getAll() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "Root@12345");
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

        if (!students.isEmpty()) {
            return students;
        } else {
            throw new RuntimeException("There are no students in the system yet");
        }

    }

    // CRUD - READ
    @Override
    public Student getById(Long id) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBC_DEMO", "root", "Root@12345");
        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM STUDENTS WHERE ID = ?");
        preparedStatement.setLong(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            return Student
                    .builder()
                    .id(rs.getLong("ID"))
                    .name(rs.getString("NAME"))
                    .address(rs.getString("ADDRESS"))
                    .dob(rs.getDate("DOB"))
                    .contactNo(rs.getString("CONTACT_NO"))
                    .createdDate(rs.getDate("CREATED_DATE"))
                    .status(rs.getBoolean("STATUS"))
                    .build();

        }
        throw new RuntimeException("Student with id=[" + id + "] is not found in our system");
    }
}
