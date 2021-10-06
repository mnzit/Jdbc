package com.nepalaya.jdbc.service;

import com.nepalaya.jdbc.model.Student;
import com.nepalaya.jdbc.response.Response;

public interface StudentService {

    Response add(Student student); // CREATE

    Response update(Student student); // UPDATE

    Response delete(Long id); // DELETE

    Response getAll(); // READ

    Response getById(Long id); // READ
}
