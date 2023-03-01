package com.prueba.KevinMaldonado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prueba.KevinMaldonado.model.Curso;

public interface CursoRepository extends MongoRepository<Curso, Long>{

}
