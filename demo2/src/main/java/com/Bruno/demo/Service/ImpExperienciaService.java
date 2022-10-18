/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Bruno.demo.Service;

import com.Bruno.demo.Entity.Experiencia;
import com.Bruno.demo.Repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ImpExperienciaService {

    @Autowired
    IExperienciaRepository iExperienciaRepository;

    public List<Experiencia> list() {

        return iExperienciaRepository.findAll();
    }

    public Optional<Experiencia> getById(int id) {

        return iExperienciaRepository.findById(id);

    }

    public Optional<Experiencia> getByNombreE(String nombreE) {

        return iExperienciaRepository.findByNombreE(nombreE);

    }

    public void save(Experiencia xp) {

        iExperienciaRepository.save(xp);
    }

    public void delete(int id) {

        iExperienciaRepository.deleteById(id);
    }

    public boolean existsById(int id) {

        return iExperienciaRepository.existsById(id);
    }

    public boolean existsByNombreE(String nombreE) {

        return iExperienciaRepository.existsByNombreE(nombreE);
    }

}
