/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Controller;

import com.Bruno.demo.Dto.DtoProyecto;
import com.Bruno.demo.Entity.Proyectos;
import com.Bruno.demo.Security.Controller.Mensaje;
import com.Bruno.demo.Service.ImpProyectoService;
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
@RequestMapping("/proyectos")
public class ProyectosController {
    
    @Autowired
    ImpProyectoService impProyectoService;
    
     @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list() {
        List<Proyectos> list = impProyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtoProyecto) {

        if (StringUtils.isBlank(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impProyectoService.existsByNombreP(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("Esa Skill existe"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = new Proyectos(dtoProyecto.getNombreP(), dtoProyecto.getLenguajes(), dtoProyecto.getLink(), dtoProyecto.getDescripcion(), dtoProyecto.getImgP());
        impProyectoService.save(proyectos);

        return new ResponseEntity(new Mensaje("Skill creada con exito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtoProyecto) {

        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impProyectoService.existsByNombreP(dtoProyecto.getNombreP()) && impProyectoService.getByNombreP(dtoProyecto.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La Skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoProyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyectos proyectos = impProyectoService.getOne(id).get();

        proyectos.setNombreP(dtoProyecto.getNombreP());
        proyectos.setLenguajes(dtoProyecto.getLenguajes());
        proyectos.setLink(dtoProyecto.getLink());
        proyectos.setDescripcion(dtoProyecto.getDescripcion());
        proyectos.setImgP(dtoProyecto.getImgP());

        impProyectoService.save(proyectos);

        return new ResponseEntity(new Mensaje("Skill Actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {

        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }

        impProyectoService.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id") int id) {
        if (!impProyectoService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyectos proyectos = impProyectoService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
}
