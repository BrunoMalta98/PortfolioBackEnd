/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Service;

import com.Bruno.demo.Entity.Proyectos;
import com.Bruno.demo.Repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpProyectoService {
    
    @Autowired
    IProyectoRepository iProyectoRepository;
    
    public List<Proyectos> list(){
        
        return iProyectoRepository.findAll();
    }
    
    public Optional<Proyectos> getOne(int id){
    
        return iProyectoRepository.findById(id);
    }
    
    
    public Optional<Proyectos> getByNombreP(String nombreP){
        return iProyectoRepository.findByNombreP(nombreP);
    }
    
    public void save(Proyectos proyectos){
        
        iProyectoRepository.save(proyectos);
    }
    
    public void delete(int id){
        
        iProyectoRepository.deleteById(id);
        
    }
    
    public boolean existsById(int id){
        return iProyectoRepository.existsById(id);
    }
    
    
    public boolean existsByNombreP(String nombreP){
        return iProyectoRepository.existsByNombreP(nombreP);
    }
}
