package com.ciber.controller;

import com.ciber.model.Students;
import com.ciber.service.IStudentsService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentsController {

  @Autowired
  IStudentsService service;
  /**
   * Method listStudents() returns the list of students.
   * 
   * @return list of students.
   */
  
  @ApiOperation(value = "Retorna lista de estudiante")
  @GetMapping(value = "/students")
  public ResponseEntity<List<Students>> listStudents() {
    return new ResponseEntity<List<Students>>(service.findAll(), HttpStatus.OK);
  }
  /**
   * Method createStudents() that creates an object students.
   * 
   * @param stu object students.
   * @return stu.
   */
  
  @ApiOperation(value = "Crea a una estudiante")
  @PostMapping(value = "/students", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Students> createStudents(@RequestBody Students stu) {
    return new ResponseEntity<Students>(service.create(stu), HttpStatus.OK);
  }
  /**
   * Method updateStudents() that update an object students.
   * 
   * @param stu object students.
   * @return stu.
   */
  
  @ApiOperation(value = "Actualiza  a un estudiante")
  @PutMapping(value = "/students", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Students> updateStudents(@RequestBody Students stu) {
    return new ResponseEntity<Students>(service.update(stu), HttpStatus.OK);
  }

  /**
   * Method deleteStudents() that removes an object students.
   * 
   * @param stu Update.
   * @return stu.
   */
  
  @ApiOperation(value = "Elimina  a estudiante")
  @DeleteMapping(value = "/students", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deleteStudents(@RequestBody Students stu) {
    int rpta = 0;

    rpta = service.delete(stu.getStudentId());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }
}
