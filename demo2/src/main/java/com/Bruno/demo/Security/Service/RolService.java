package com.Bruno.demo.Security.Service;

import com.Bruno.demo.Security.Entity.Rol;
import com.Bruno.demo.Security.Enums.RolNombre;
import com.Bruno.demo.Security.Repository.IRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    IRolRepository irolRepository;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){

        return  irolRepository.findByRolNombre(rolNombre);

    }

    public void save(Rol rol){

        irolRepository.save(rol);

    }

}
