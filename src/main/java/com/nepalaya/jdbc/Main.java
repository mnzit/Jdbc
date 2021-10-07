package com.nepalaya.jdbc;

import com.nepalaya.jdbc.response.Response;
import com.nepalaya.jdbc.service.StudentService;
import com.nepalaya.jdbc.service.impl.StudentServiceImpl;
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
    }
}
