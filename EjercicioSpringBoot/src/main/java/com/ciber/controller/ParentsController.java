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

import com.ciber.model.Parents;
import com.ciber.service.IParentsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST parientes", description = "Mostar información")
@RestController
public class ParentsController {
  
  @Autowired 
  IParentsService service;
  
  @ApiOperation(value = "Retorna lista de Parents")
  @GetMapping(value = "/parents")
  public ResponseEntity<List<Parents>> listParents() {
    return new ResponseEntity<List<Parents>>(service.findAll(), HttpStatus.OK);
  }
  
  @ApiOperation(value = "Crea a una Parents")
  @PostMapping(value = "/parents", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Parents> createParents(@RequestBody Parents parem) {
    return new ResponseEntity<Parents>(service.create(parem), HttpStatus.OK);    
  }
  
  @ApiOperation(value = "Actualiza a una Parents")
  @PutMapping(value = "/parents", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Parents> updateParents(@RequestBody Parents parem) {
    return new ResponseEntity<Parents>(service.update(parem), HttpStatus.OK);
  }
  
  @ApiOperation(value = "Actualiza datos de una Parents")
  @DeleteMapping(value = "/parents", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deleteParents(@RequestBody Parents parem) {
    int rpta = 0;

    rpta = service.delete(parem.getParent_id());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }
  
  
}
