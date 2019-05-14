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

import com.ciber.model.FamilyMembers;
import com.ciber.service.IFamilyMembers;

import io.swagger.annotations.ApiOperation;

@RestController
public class FamilyMembersController {

  @Autowired
  IFamilyMembers service;
  
  @ApiOperation(value = "Retorna lista de family Members")
  @GetMapping(value = "/familyMembers")
  public ResponseEntity<List<FamilyMembers>> listfamilyMembers() {
    return new ResponseEntity<List<FamilyMembers>>(service.findAll(), HttpStatus.OK);
  }
  
  @ApiOperation(value = "Crea a una family Members")
  @PostMapping(value = "/familyMembers", consumes = "application/json", produces = "application/json")
  public ResponseEntity<FamilyMembers> createfamilyMembers(@RequestBody FamilyMembers famiMen) {
    return new ResponseEntity<FamilyMembers>(service.create(famiMen), HttpStatus.OK);
  }

  @PutMapping(value = "/familyMembers", consumes = "application/json", produces = "application/json")
  public ResponseEntity<FamilyMembers> updatefamilyMembers(@RequestBody FamilyMembers famiMen) {
    return new ResponseEntity<FamilyMembers>(service.update(famiMen), HttpStatus.OK);
  }
  
  @ApiOperation(value = "Actualiza datos de Family Members")
  @DeleteMapping(value = "/familyMembers", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Integer> deletefamilyMembers(@RequestBody FamilyMembers famiMen) {
    int rpta = 0;

    rpta = service.delete(famiMen.getFamily_member_id());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }
}
