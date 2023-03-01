package com.prueba.KevinMaldonado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prueba.KevinMaldonado.model.Profesor;

public interface ProfesorRepository extends MongoRepository<Profesor, Long>{

}
