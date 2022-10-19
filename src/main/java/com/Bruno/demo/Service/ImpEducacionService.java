/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Service;

import com.Bruno.demo.Entity.Educacion;

import com.Bruno.demo.Repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpEducacionService {
    
    @Autowired
    IEducacionRepository iEducacionRepository;
    
    public List<Educacion> list() {

        return iEducacionRepository.findAll();
    }

    public Optional<Educacion> getById(int id) {

        return iEducacionRepository.findById(id);

    }

    public Optional<Educacion> getByTitulacion(String titulacion) {

        return iEducacionRepository.findByTitulacion(titulacion);

    }

    public void save(Educacion xp) {

        iEducacionRepository.save(xp);
    }

    public void delete(int id) {

        iEducacionRepository.deleteById(id);
    }

    public boolean existsById(int id) {

        return iEducacionRepository.existsById(id);
    }

    public boolean existsByTitulacion(String titulacion) {

        return iEducacionRepository.existsByTitulacion(titulacion);
    }
    
}
