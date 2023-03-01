package com.prueba.KevinMaldonado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prueba.KevinMaldonado.model.Depto;

public interface DeptoRepository extends MongoRepository<Depto, Long>{

}
