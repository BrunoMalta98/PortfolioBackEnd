/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Bruno.demo.Repository;

import com.Bruno.demo.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author bruno
 */
public interface ISkillsRepository extends JpaRepository<Skills, Integer>{
    
    Optional<Skills> findByNombreS(String nombreS);
    public boolean existsByNombreS(String nombreS);
}
