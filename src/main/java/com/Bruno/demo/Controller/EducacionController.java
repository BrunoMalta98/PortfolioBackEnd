/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Controller;

import com.Bruno.demo.Dto.DtoEducacion;
import com.Bruno.demo.Entity.Educacion;
import com.Bruno.demo.Security.Controller.Mensaje;
import com.Bruno.demo.Service.ImpEducacionService;
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
@RequestMapping("/educacion")
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "https://mi-portfolio-bruno.web.app")
public class EducacionController {
    
    @Autowired
    ImpEducacionService impEducacionService;

    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = impEducacionService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }
    
     @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    
         if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
         
        impEducacionService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoEducacion dtoeducacion) {

        if (StringUtils.isBlank(dtoeducacion.getTitulacion())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impEducacionService.existsByTitulacion(dtoeducacion.getTitulacion())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = new Educacion(dtoeducacion.getTitulacion(), dtoeducacion.getInstitucion(), dtoeducacion.getDescripcion(),dtoeducacion.getFechaInicio(), dtoeducacion.getFechaFin(),
                dtoeducacion.getImgInsti());
        impEducacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Educacion creada con exito"), HttpStatus.OK);
    }
   
     @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEducacion dtoxp) {

        if (!impEducacionService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impEducacionService.existsByTitulacion(dtoxp.getTitulacion()) && impEducacionService.getByTitulacion(dtoxp.getTitulacion()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La eperiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoxp.getTitulacion())) {
            return new ResponseEntity(new Mensaje("El nombre es onligatorio"), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion = impEducacionService.getById(id).get();
        
        educacion.setTitulacion(dtoxp.getTitulacion());
        educacion.setInstitucion(dtoxp.getInstitucion());
        educacion.setDescripcion(dtoxp.getDescripcion());
        educacion.setFechaInicio(dtoxp.getFechaInicio());
        educacion.setFechaFin(dtoxp.getFechaFin());
        educacion.setImgInsti(dtoxp.getImgInsti());

        impEducacionService.save(educacion);

        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = impEducacionService.getById(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
}
