/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Controller;

import com.Bruno.demo.Dto.DtoExperiencia;
import com.Bruno.demo.Dto.DtoSkills;
import com.Bruno.demo.Entity.Experiencia;
import com.Bruno.demo.Entity.Skills;
import com.Bruno.demo.Security.Controller.Mensaje;
import com.Bruno.demo.Service.ImpSkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://mi-portfolio-bruno.web.app")
@RequestMapping("/skills")
public class SkillsController {

    @Autowired
    ImpSkillsService impSkillsService;

    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list() {
        List<Skills> list = impSkillsService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoSkills dtoSkills) {

        if (StringUtils.isBlank(dtoSkills.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impSkillsService.existsByNombreS(dtoSkills.getNombreS())) {
            return new ResponseEntity(new Mensaje("Esa Skill existe"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = new Skills(dtoSkills.getNombreS(), dtoSkills.getPorcentaje());
        impSkillsService.save(skills);

        return new ResponseEntity(new Mensaje("Skill creada con exito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtoSkills) {

        if (!impSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impSkillsService.existsByNombreS(dtoSkills.getNombreS()) && impSkillsService.getByNombreS(dtoSkills.getNombreS()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoSkills.getNombreS())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Skills skills = impSkillsService.getOne(id).get();

        skills.setNombreS(dtoSkills.getNombreS());
        skills.setPorcentaje(dtoSkills.getPorcentaje());

        impSkillsService.save(skills);

        return new ResponseEntity(new Mensaje("Skill Actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!impSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        impSkillsService.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") int id) {
        if (!impSkillsService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Skills skills = impSkillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }

}
