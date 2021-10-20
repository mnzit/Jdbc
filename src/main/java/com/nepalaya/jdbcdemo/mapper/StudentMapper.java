package com.nepalaya.jdbcdemo.mapper;

import com.nepalaya.jdbcdemo.db.RowMapper;
import com.nepalaya.jdbcdemo.model.Student;

import java.sql.ResultSet;

public class StudentMapper implements RowMapper<Student> {

    @Override
    public Student map(ResultSet resultSet) throws Exception {
        return Student
                .builder()
                .id(resultSet.getLong("ID"))
                .name(resultSet.getString("NAME"))
                .address(resultSet.getString("ADDRESS"))
                .dob(resultSet.getDate("DOB"))
                .contactNo(resultSet.getString("CONTACT_NO"))
                .createdDate(resultSet.getDate("CREATED_DATE"))
                .status(resultSet.getBoolean("STATUS"))
                .build();
    }
}
