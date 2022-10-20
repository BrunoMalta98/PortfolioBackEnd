
package com.Bruno.demo.Service;

import com.Bruno.demo.Entity.Skills;
import com.Bruno.demo.Repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class ImpSkillsService {
    
    @Autowired
    ISkillsRepository ISkillsRepo;
    
    
    public List<Skills> list(){
        
        return ISkillsRepo.findAll();
    }
    
    public Optional<Skills> getOne(int id){
    
        return ISkillsRepo.findById(id);
    }
    
    
    public Optional<Skills> getByNombreS(String nombreS){
        return ISkillsRepo.findByNombreS(nombreS);
    }
    
    public void save(Skills skills){
        
        ISkillsRepo.save(skills);
    }
    
    public void delete(int id){
        
        ISkillsRepo.deleteById(id);
        
    }
    
    public boolean existsById(int id){
        return ISkillsRepo.existsById(id);
    }
    
    
    public boolean existsByNombreS(String nombreS){
        return ISkillsRepo.existsByNombreS(nombreS);
    }
    
}
