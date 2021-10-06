package com.nepalaya.jdbc.dao;

import com.nepalaya.jdbc.model.Student;

import java.util.List;

public interface StudentDAO {

    boolean add(Student student) throws Exception; // CREATE

    boolean update(Student student) throws Exception; // UPDATE

    boolean delete(Long id) throws Exception; // DELETE

    List<Student> getAll() throws Exception; // READ

    Student getById(Long id) throws Exception; // READ

}
