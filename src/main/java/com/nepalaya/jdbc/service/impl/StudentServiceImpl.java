package com.nepalaya.jdbc.service.impl;

import com.nepalaya.jdbc.builder.ResponseBuilder;
import com.nepalaya.jdbc.builder.ResponseProcessor;
import com.nepalaya.jdbc.dao.StudentDAO;
import com.nepalaya.jdbc.dao.impl.StudentDAODatabaseImpl;
import com.nepalaya.jdbc.model.Student;
import com.nepalaya.jdbc.response.Response;
import com.nepalaya.jdbc.service.StudentService;

public class StudentServiceImpl implements StudentService {

    private final StudentDAO studentDAO = new StudentDAODatabaseImpl();

    @Override
    public Response add(Student student) {
        return ResponseProcessor
                .process(() -> {
                            studentDAO.add(student);
                            return ResponseBuilder.success("Student Added Successfully !");
                        }
                );
    }

    @Override
    public Response update(Student student) {
        return ResponseProcessor
                .process(() -> {
                            studentDAO.update(student);
                            return ResponseBuilder.success("Student Updated Successfully !");
                        }
                );
    }

    @Override
    public Response delete(Long id) {
        return ResponseProcessor
                .process(() -> {
                    studentDAO.delete(id);
                    return ResponseBuilder.success("Student's Deleted Successfully !");
                });
    }

    @Override
    public Response getAll() {
        return ResponseProcessor
                .process(() -> ResponseBuilder.success("Student's Fetched Successfully !", studentDAO.getAll()));
    }

    @Override
    public Response getById(Long id) {
        return ResponseProcessor
                .process(() -> ResponseBuilder.success("Student Fetched Successfully !", studentDAO.getById(id)));
    }
}
