package com.ciber.controller;

import com.ciber.model.Families;
import com.ciber.service.IFamiliesService;

import io.swagger.annotations.Api;
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

@Api(value = "API REST families", description = "Mostar información")
@RestController
public class FamiliesController {

  @Autowired
  private IFamiliesService service;

  /**
   * GetMapping method listFamiliesthat() returns the list of families.
   * 
   * @return list of families.
   */
  @ApiOperation(value = "Retorna lista de families")
  @GetMapping(value = "/families")
  public ResponseEntity<List<Families>> listFamilies() {
    return new ResponseEntity<List<Families>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * PostMapping method createfamilies() that creates an object families.
   * 
   * @param fami object families.
   * @return
   */
  @ApiOperation(value = "Crea a una families")
  @PostMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Families> createfamilies(@RequestBody Families fami) {

    return new ResponseEntity<Families>(service.create(fami), HttpStatus.OK);
  }

  /**
   * PutMapping method updatefamilies() that update an object families.
   * 
   * @param fami object families.
   * @return
   */
  @ApiOperation(value = "Actualiza a una families")
  @PutMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Families> updatefamilies(@RequestBody Families fami) {
    return new ResponseEntity<Families>(service.update(fami), HttpStatus.OK);
  }

  /**
   * DeleteMapping method deletefamilies() that removes an object families by its code.
   * 
   * @param fami Update.
   * @return
   */
  @ApiOperation(value = "Actualiza datos de una families")
  @DeleteMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deletefamilies(@RequestBody Families fami) {
    int rpta = 0;

    rpta = service.delete(fami.getFamilyId());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }

}
