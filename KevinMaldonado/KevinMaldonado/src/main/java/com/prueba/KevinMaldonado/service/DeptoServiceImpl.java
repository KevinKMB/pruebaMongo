package com.prueba.KevinMaldonado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.prueba.KevinMaldonado.model.Curso;
import com.prueba.KevinMaldonado.model.Depto;
import com.prueba.KevinMaldonado.repository.CursoRepository;
import com.prueba.KevinMaldonado.repository.DeptoRepository;

@Service
public class DeptoServiceImpl extends GenericServiceImpl<Depto, Long> implements DeptoService{

	@Autowired
    DeptoRepository deptoRepository;
    
    @Override
    public CrudRepository<Depto, Long> getDao() {
        return deptoRepository;
    }  
}
