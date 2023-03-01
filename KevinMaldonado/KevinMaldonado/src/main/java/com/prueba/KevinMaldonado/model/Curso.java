package com.prueba.KevinMaldonado.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Curso")
@Data
public class Curso {
	
	private Long Curso_ID;
	private Long Prof_ID;
	private String Nombre;
	private String Nivel;
	private String Descripcion;
	
	
}
