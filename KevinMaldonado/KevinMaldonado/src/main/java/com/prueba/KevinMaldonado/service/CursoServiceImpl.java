package com.prueba.KevinMaldonado.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.prueba.KevinMaldonado.model.Curso;
import com.prueba.KevinMaldonado.repository.CursoRepository;

@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Long> implements CursoService{

	@Autowired
    CursoRepository cursoRepository;
    
    @Override
    public CrudRepository<Curso, Long> getDao() {
        return cursoRepository;
    }  
}
