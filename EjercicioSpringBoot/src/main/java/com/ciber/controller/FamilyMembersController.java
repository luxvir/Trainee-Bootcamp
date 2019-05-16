package com.ciber.controller;

import com.ciber.model.FamilyMembers;
import com.ciber.service.IFamiliesService;
import com.ciber.service.IFamilyMembersService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyMembersController {

  @Autowired
  IFamilyMembersService service;

  @Autowired
  IFamiliesService serviceFam;

  /**
   * El metodo GetMapping  listfamilyMembers() se encarga de retornar 
   * la lista de miembros de familia.
   * 
   * @return list of family members.
   */
  @ApiOperation(value = "Retorna lista de family Members")
  @GetMapping(value = "/familyMembers")
  public ResponseEntity<List<FamilyMembers>> listfamilyMembers() {
    return new ResponseEntity<List<FamilyMembers>>(service.findAll(), HttpStatus.OK);
  }

  /**
   * El metodo PostMapping  createfamilies() es responsable de crear 
   * a un objeto de miembro de familia.
   * 
   * @param famiMen object families.
   * @return famiMen.
   */
  @ApiOperation(value = "Crea a una family Members")
  @PostMapping(value = "/familyMembers", consumes = "application/json", 
          produces = "application/json")
  public ResponseEntity<FamilyMembers> createfamilyMembers(@RequestBody FamilyMembers famiMen) {
    return new ResponseEntity<FamilyMembers>(service.create(famiMen), HttpStatus.CREATED);
  }

  /**
   * El metodo PutMapping  updatefamilies() se encarga de actualizar 
   * a un objeto de miembro de familia.
   * members.
   * 
   * @param famiMen object families.
   * @return famiMen.
   */
  @PutMapping(value = "/familyMembers", consumes = "application/json", 
            produces = "application/json")
  public ResponseEntity<FamilyMembers> updatefamilyMembers(@RequestBody FamilyMembers famiMen) {
    return new ResponseEntity<FamilyMembers>(service.update(famiMen), HttpStatus.OK);
  }

  /**
   * El metodo DeleteMapping  deletefamilyMembers() se encarga de eliminar 
   * a un objeto de miembro de familia.
   * 
   * @param famiMen .
   * @return
   */
  @ApiOperation(value = "Actualiza datos de Family Members")
  @DeleteMapping(value = "/familyMembers", consumes = "application/json", 
            produces = "application/json")
  public ResponseEntity<Integer> deletefamilyMembers(@RequestBody FamilyMembers famiMen) {
    int rpta = 0;

    rpta = service.delete(famiMen.getFamilyMemberId());

    return new ResponseEntity<Integer>(rpta, HttpStatus.OK);
  }

  /**
   * El metodo findByFamilyMembers() se le envia un parametro FamilyId 
   * y retorna a los miembros de familia.
   * 
   * @return list of family members.
   */
  @GetMapping(value = "/familyMembers/{id}/members")
  public ResponseEntity<List<FamilyMembers>> findByFamilyMembers(@PathVariable("id") int id) {
    return new ResponseEntity<List<FamilyMembers>>(serviceFam.findByFamilies(id), HttpStatus.OK);

  }

}
