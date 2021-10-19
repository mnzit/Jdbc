package com.nepalaya.jdbc.dao.impl;

import com.nepalaya.jdbc.dao.StudentDAO;
import com.nepalaya.jdbc.db.DatabaseHelper;
import com.nepalaya.jdbc.model.Student;
import com.nepalaya.jdbc.util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDAODatabaseImpl implements StudentDAO {

    DatabaseHelper databaseHelper = new DatabaseHelper();

    // CREATE
    @Override
    public boolean add(Student student) throws Exception {
        try {
            databaseHelper.connect();
            PreparedStatement preparedStatement = databaseHelper.initialize("INSERT INTO STUDENTS(NAME,ADDRESS,DOB,CONTACT_NO) VALUES(?,?,?,?)");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setDate(3, DateUtil.convertJavaDateToSQLDate(student.getDob()));
            preparedStatement.setString(4, student.getContactNo());
            int rowAffected = databaseHelper.update();

            if (rowAffected > 0) {
                return true;
            } else {
                throw new RuntimeException("Adding Student Failed");
            }

        } finally {
            databaseHelper.close();
        }
    }

    // UPDATE
    @Override
    public boolean update(Student student) throws Exception {
        try {
            databaseHelper.connect();
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

            PreparedStatement preparedStatement = databaseHelper.initialize(sql);

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                preparedStatement.setObject(index++, entry.getValue());
            }

            preparedStatement.setLong(index++, student.getId());

            int rowAffected = databaseHelper.update();

            if (rowAffected > 0) {
                return true;
            } else {
                throw new RuntimeException("Updating Student Failed");
            }

        } finally {
            databaseHelper.close();
        }
    }

    // DELETE
    @Override
    public boolean delete(Long id) throws Exception {
        try {
            databaseHelper.connect();
            PreparedStatement preparedStatement = databaseHelper.initialize("UPDATE STUDENTS SET STATUS = FALSE WHERE ID = ?");
            preparedStatement.setLong(1, id);
            int rowAffected = databaseHelper.update();

            if (rowAffected > 0) {
                return true;
            } else {
                throw new RuntimeException("Deleting Student Failed");
            }
        } finally {
            databaseHelper.close();
        }
    }

    // READ
    @Override
    public List<Student> getAll() throws Exception {
        try {
            databaseHelper.connect();
            databaseHelper.initialize("SELECT * FROM STUDENTS WHERE STATUS = TRUE");
            ResultSet rs = databaseHelper.execute();
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
        } finally {
            databaseHelper.close();
        }
    }

    // READ
    @Override
    public Student getById(Long id) throws Exception {
        try {
            databaseHelper.connect();
            PreparedStatement preparedStatement = databaseHelper.initialize("SELECT * FROM STUDENTS WHERE ID = ? AND STATUS = TRUE");
            preparedStatement.setLong(1, id);
            ResultSet rs = databaseHelper.execute();
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
        } finally {
            databaseHelper.close();
        }
    }
}
