package com.ciber.controller;

import com.ciber.model.Parents;
import com.ciber.service.IParentsService;

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

@Api(value = "/api/v1/swagger", tags =  "Mostar información")
@RestController
public class ParentsController {

  @Autowired
  IParentsService service;

  /**
   * EL metodo listParents() se encarga de retonar la lista de parientes.
   * 
   * @return list of parents.
   */

  @ApiOperation(value = "Retorna lista de Parents")
  @GetMapping(value = "/api/v1/parents")
  public ResponseEntity<List<Parents>> listParents() {
    return new ResponseEntity<List<Parents>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * El metodo createParents() es responsable de crear a un pariente..
   * 
   * @param parem object parents.
   * @return object parents.
   */

  @ApiOperation(value = "Crea a una Parents")
  @PostMapping(value = "/api/v1/parents", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Parents> createParents(@RequestBody Parents parem) {
    return new ResponseEntity<Parents>(service.create(parem), HttpStatus.CREATED);
  }

  /**
   * El metodo updateParents() se encarga de actualizar a un pariente.
   * 
   * @param parem object parents.
   * @return object parents.
   */
  @ApiOperation(value = "Actualiza a una Parents")
  @PutMapping(value = "/api/v1/parents", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Parents> updateParents(@RequestBody Parents parem) {
    return new ResponseEntity<Parents>(service.update(parem), HttpStatus.OK);
  }

  /**
   * DeleteMapping method deleteParents() that removes an object familparents.
   * 
   * @param parem object parents.
   * @return object parents.
   */
  @ApiOperation(value = "Elimina datos de una Parents")
  @DeleteMapping(value = "/api/v1/parents", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deleteParents(@RequestBody Parents parem) {
    int rpta = 0;

    rpta = service.delete(parem.getParentId());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }

}
