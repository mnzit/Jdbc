package com.nepalaya.jdbcdemo.service;

import com.nepalaya.jdbcdemo.model.Student;
import com.nepalaya.jdbcdemo.response.Response;

public interface StudentService {

    Response add(Student student); // CREATE

    Response update(Student student); // UPDATE

    Response delete(Long id); // DELETE

    Response getAll(); // READ

    Response getById(Long id); // READ
}
