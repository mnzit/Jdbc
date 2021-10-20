package com.nepalaya.jdbc;

import com.nepalaya.jdbc.exception.Ex;
import com.nepalaya.jdbc.model.Student;
import com.nepalaya.jdbc.response.Response;
import com.nepalaya.jdbc.service.StudentService;
import com.nepalaya.jdbc.service.impl.StudentServiceImpl;
import com.nepalaya.jdbc.util.DateUtil;
import com.nepalaya.jdbc.util.JacksonUtil;

public class StudentController {

    private final static StudentService studentService = new StudentServiceImpl();

    public static void main(String[] args) {
        Ex.caught(() -> {

//            add();
//            update();
            delete();
            getAll();
//            getOne();
        });
    }

    public static void getAll() throws Exception {
        Response studentAllResponse = studentService.getAll();
        System.out.println(JacksonUtil.toJson(studentAllResponse));
    }

    public static void getOne() throws Exception {
        Response getByIdResponse = studentService.getById(5L);
        System.out.println(JacksonUtil.toJson(getByIdResponse));
    }

    public static void add() throws Exception {
        Student student = Student
                .builder()
                .name("Maniraj Joshi")
                .dob(DateUtil.formatDate("1998-03-31", "yyyy-MM-dd"))
                .address("Lalitpur")
                .contactNo("9841494167")
                .build();

        Response studentAddResponse = studentService.add(student);
        System.out.println(JacksonUtil.toJson(studentAddResponse));
    }

    public static void update() throws Exception {
        Student student = Student
                .builder()
                .id(7L)
                .name("Maniraj Maharjan")
                .dob(DateUtil.formatDate("1998-03-31", "yyyy-MM-dd"))
                .address("Lalitpur")
                .contactNo("9841494167")
                .build();
        Response studentUpdate = studentService.update(student);
        System.out.println(JacksonUtil.toJson(studentUpdate));
    }

    public static void delete() throws Exception {
        Response studentDelete = studentService.delete(7L);
        System.out.println(JacksonUtil.toJson(studentDelete));
    }
}
