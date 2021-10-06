package com.nepalaya.jdbc.service.impl;

import com.nepalaya.jdbc.builder.ResponseBuilder;
import com.nepalaya.jdbc.dao.StudentDAO;
import com.nepalaya.jdbc.dao.impl.StudentDAOMemoryImpl;
import com.nepalaya.jdbc.model.Student;
import com.nepalaya.jdbc.response.Response;
import com.nepalaya.jdbc.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO studentDAO = new StudentDAOMemoryImpl();

    @Override
    public Response add(Student student) {
        Response response = null;
        try {
            studentDAO.add(student);
            response = ResponseBuilder.success("Student Added Successfully !");
        } catch (Exception ex) {
            response = ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response update(Student student) {
        Response response = null;
        try {
            studentDAO.update(student);
            response = ResponseBuilder.success("Student Updated Successfully !");
        } catch (Exception ex) {
            response = ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response delete(Long id) {
        return null;
    }

    @Override
    public Response getAll() {
        Response response = null;
        try {
            List<Student> students = studentDAO.getAll();
            response = ResponseBuilder.success("Student's Fetched Successfully !", students);
        } catch (Exception ex) {
            response = ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }

    @Override
    public Response getById(Long id) {
        Response response = null;
        try {
            Student student = studentDAO.getById(id);
            response = ResponseBuilder.success("Student Fetched Successfully !", student);
        } catch (Exception ex) {
            response = ResponseBuilder.failure(ex.getMessage());
        }
        return response;
    }
}
