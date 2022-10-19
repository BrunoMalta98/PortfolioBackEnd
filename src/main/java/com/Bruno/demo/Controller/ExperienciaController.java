/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Controller;

import com.Bruno.demo.Dto.DtoExperiencia;
import com.Bruno.demo.Entity.Experiencia;
import com.Bruno.demo.Security.Controller.Mensaje;
import com.Bruno.demo.Service.ImpExperienciaService;
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
@RequestMapping("experiencia")
@CrossOrigin(origins = "https://mi-portfolio-bruno.web.app")
public class ExperienciaController {

    @Autowired
    ImpExperienciaService impExperienciaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = impExperienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoxp) {

        if (StringUtils.isBlank(dtoxp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impExperienciaService.existsByNombreE(dtoxp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = new Experiencia(dtoxp.getNombreE(), dtoxp.getPuesto(), dtoxp.getDescripcion(),dtoxp.getFechaInicio(), dtoxp.getFechaFin(),
                dtoxp.getImgEmpresa());
        impExperienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia creada con exito"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia dtoxp) {

        if (!impExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impExperienciaService.existsByNombreE(dtoxp.getNombreE()) && impExperienciaService.getByNombreE(dtoxp.getNombreE()).get().getId_experiencia() != id) {
            return new ResponseEntity(new Mensaje("La eperiencia ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtoxp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es onligatorio"), HttpStatus.BAD_REQUEST);
        }

        Experiencia experiencia = impExperienciaService.getById(id).get();
        
        experiencia.setNombreE(dtoxp.getNombreE());
        experiencia.setPuesto(dtoxp.getPuesto());
        experiencia.setDescripcion(dtoxp.getDescripcion());
        experiencia.setFechaInicio(dtoxp.getFechaInicio());
        experiencia.setFechaFin(dtoxp.getFechaFin());
        experiencia.setImgEmpresa(dtoxp.getImgEmpresa());

        impExperienciaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia Actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    
         if (!impExperienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
         
        impExperienciaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    
    }
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") int id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impExperienciaService.getById(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
