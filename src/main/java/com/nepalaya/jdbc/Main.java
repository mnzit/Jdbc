package com.nepalaya.jdbc;

import com.nepalaya.jdbc.exception.ExceptionHandler;
import com.nepalaya.jdbc.model.Student;
import com.nepalaya.jdbc.response.Response;
import com.nepalaya.jdbc.service.StudentService;
import com.nepalaya.jdbc.service.impl.StudentServiceImpl;
import com.nepalaya.jdbc.util.DateUtil;
import com.nepalaya.jdbc.util.JacksonUtil;

public class Main {

    public static void main(String[] args) {

        StudentService studentService = new StudentServiceImpl();

//        studentService.add(
//                Student
//                        .builder()
//                        .id(1L)
//                        .name("Rajesh Sanjyal")
//                        .address("Kritipur")
//                        .contactNo("9841567890")
//                        .dob(new Date())
//                        .build()
//        );
//
//        studentService.add(
//                Student
//                        .builder()
//                        .id(2L)
//                        .name("Nawaraj Shrestha")
//                        .address("Mulpani")
//                        .contactNo("9841567891")
//                        .dob(new Date())
//                        .build()
//
//        );
//
//        Response addResponse = studentService.add(
//                Student
//                        .builder()
//                        .id(3L)
//                        .name("Nabin Shrestha")
//                        .address("Balaju")
//                        .contactNo("9841567892")
//                        .dob(new Date())
//                        .build()
//
//        );
//
//        System.out.println(JacksonUtil.toJson(addResponse));
//
//        StudentService studentService2 = new StudentServiceImpl();
//
//        Response updateResponse = studentService2.update(Student
//                .builder()
//                .id(2L)
//                .name("Manjit Shakya")
//                .build());
//        System.out.println(JacksonUtil.toJson(updateResponse));
//
//        Response getByIdResponse = studentService.getById(1L);
//        System.out.println(JacksonUtil.toJson(getByIdResponse));

        Response studentAllResponse = studentService.getAll();
        System.out.println(JacksonUtil.toJson(studentAllResponse));

        ExceptionHandler.handle(() -> {

//            Response studentAddResponse = studentService.add(new Student("Nawaraj Shrestha", DateUtil.formatDate("1998-03-31", "yyyy-MM-dd"), "Biratnagar", "980111111"));
//            System.out.println(JacksonUtil.toJson(studentAddResponse));
//            Response studentOneResponse = studentService.getById(6L);
//            System.out.println(JacksonUtil.toJson(studentOneResponse));

//            new Student(1L, "Nabin Shrestha", DateUtil.formatDate("1998-03-31", "yyyy-MM-dd"), "Birtamod", "9801111111")
//            Student student = Student
//                    .builder()
//                    .id(1L)
//                    .name("Anita Joshi")
//                    .build();
//            Response studentUpdate = studentService.update(student);
//            System.out.println(JacksonUtil.toJson(studentUpdate));

//            Response studentDelete = studentService.delete(2L);
//            System.out.println(JacksonUtil.toJson(studentDelete));
        });
    }
}
