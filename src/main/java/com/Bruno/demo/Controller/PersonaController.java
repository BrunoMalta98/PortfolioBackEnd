
package com.Bruno.demo.Controller;


import com.Bruno.demo.Dto.DtoPersona;
import com.Bruno.demo.Entity.Persona;
import com.Bruno.demo.Security.Controller.Mensaje;
import com.Bruno.demo.Service.ImpPersonaService;


import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "https://mi-portfolio-bruno.web.app")
public class PersonaController {
  
     @Autowired
    ImpPersonaService impPersonaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> list() {
        List<Persona> list = impPersonaService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    /*@PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoxp) {

        if (StringUtils.isBlank(dtoxp.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (impPersonaService.existsByNombreE(dtoxp.getNombreE())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Persona experiencia = new Experiencia(dtoxp.getNombreE(), dtoxp.getPuesto(), dtoxp.getDescripcion(),dtoxp.getFechaInicio(), dtoxp.getFechaFin(),
                dtoxp.getImgEmpresa());
        impPersonaService.save(experiencia);

        return new ResponseEntity(new Mensaje("Experiencia creada con exito"), HttpStatus.OK);
    }*/

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtopersona) {

        if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        if (impPersonaService.existsByNombre(dtopersona.getNombre()) && impPersonaService.getByNombre(dtopersona.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("La persona ya existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(dtopersona.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Persona persona = impPersonaService.getById(id).get();
        
        persona.setNombre(dtopersona.getNombre());
        persona.setApellido(dtopersona.getApellido());
        persona.setTitulo(dtopersona.getTitulo());
        persona.setUniversidades(dtopersona.getUniversidades());
        persona.setDescripcion(dtopersona.getDescripcion());
        persona.setImg(dtopersona.getImg());

        impPersonaService.save(persona);

        return new ResponseEntity(new Mensaje("Persona Actualizada"), HttpStatus.OK);
    }

   /* @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
    
         if (!impPersonaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
         
        impPersonaService.delete(id);
        
        return new ResponseEntity(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    
    }*/
    
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") int id){
        if(!impPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = impPersonaService.getById(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    
    
}
