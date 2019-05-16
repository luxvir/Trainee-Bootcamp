package com.ciber.controller;

import com.ciber.model.Families;
import com.ciber.service.IFamiliesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
  Logger log = LoggerFactory.getLogger(this.getClass());
  @Autowired
  private IFamiliesService service;

  /**
   * El metodo GetMapping listFamiliesthat() retorna la lista de familiass.
   * 
   * @return list of families.
   */
  @ApiOperation(value = "Retorna lista de families")
  @GetMapping(value = "/families")
  public ResponseEntity<List<Families>> listFamilies() {
    return new ResponseEntity<List<Families>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * El metodo PostMapping createfamilies() se encarga de registrar a un objeto
   * familia.
   * 
   * @param fami object families.
   * @return object families.
   */
  @ApiOperation(value = "Crea a una families")
  @PostMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Families> createfamilies(@RequestBody Families fami) {

    return new ResponseEntity<Families>(service.create(fami), HttpStatus.CREATED);
  }

  /**
   * El metodo PutMapping updatefamilies() se encarga de actualizar a un objeto
   * familia.
   * 
   * @param fami object families.
   * @return object families.
   */
  @ApiOperation(value = "Actualiza a una families")
  @PutMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Families> updatefamilies(@RequestBody Families fami) {
    return new ResponseEntity<Families>(service.update(fami), HttpStatus.OK);
  }

  /**
   * El metodo DeleteMapping deletefamilies() se encarga de remover a un objeto
   * famila por su código.
   * 
   * @param fami Update.
   * @return object families delete.
   */
  @ApiOperation(value = "Actualiza datos de una families")
  @DeleteMapping(value = "/families", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deletefamilies(@RequestBody Families fami) {
    int rpta = 0;
    try {
      rpta = service.delete(fami.getFamilyId());
    } catch (Exception e) {
      log.info("error" + e);
      return new ResponseEntity<Integer>(rpta, HttpStatus.BAD_REQUEST);
    }
    log.info("Termino proceso");
    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }

}
