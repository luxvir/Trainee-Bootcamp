package com.ciber.controller;

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

import com.ciber.model.Students;
import com.ciber.service.IStudents;

import io.swagger.annotations.ApiOperation;

@RestController
public class StudentsController {

  @Autowired
  IStudents service;
  
  @ApiOperation(value = "Retorna lista de estudiante")
  @GetMapping(value = "/students")
  public ResponseEntity<List<Students>> listStudents() {
    return new ResponseEntity<List<Students>>(service.findAll(), HttpStatus.OK);
  }
  
  @ApiOperation(value = "Crea a una estudiante")
  @PostMapping(value = "/students", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Students> createStudents(@RequestBody Students stu) {
    return new ResponseEntity<Students>(service.create(stu), HttpStatus.OK);
  }
  
  @ApiOperation(value = "Actualiza  a un estudiante")
  @PutMapping(value = "/students", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Students> actualizar(@RequestBody Students stu) {
    return new ResponseEntity<Students>(service.update(stu), HttpStatus.OK);
  }
  
  @ApiOperation(value = "Elimina  a un estudiante")
  @DeleteMapping(value = "/students", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> eliminar(@RequestBody Students stu) {
    int rpta = 0;

    rpta = service.delete(stu.getStudent_id());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }
}
