package com.ciber.controller;

import java.util.ArrayList;
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

import com.ciber.model.Families;
import com.ciber.model.Parents;
import com.ciber.service.IFamiliesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "API REST families", description = "Mostar información")
@RestController
public class FamiliesController {

  @Autowired
  private IFamiliesService service;

  @ApiOperation(value = "Retorna lista de families")
  @GetMapping(value = "/families")
  public ResponseEntity<List<Families>> listFamilies() {    
    return new ResponseEntity<List<Families>>(service.findAll(), HttpStatus.OK);
  }
    
  @ApiOperation(value = "Crea a una families")
  @PostMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Families> createfamilies(@RequestBody Families fami) {
	  
	  
	    return new ResponseEntity<Families>(service.create(fami), HttpStatus.OK);
  }
  @ApiOperation(value = "Actualiza a una families")
  @PutMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Families> updatefamilies(@RequestBody Families fami) {
    return new ResponseEntity<Families>(service.update(fami), HttpStatus.OK);
  }
  @ApiOperation(value = "Actualiza datos de una families")
  @DeleteMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deletefamilies(@RequestBody Families fami) {
    int rpta = 0;

    rpta = service.delete(fami.getFamily_id());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }
 
}
