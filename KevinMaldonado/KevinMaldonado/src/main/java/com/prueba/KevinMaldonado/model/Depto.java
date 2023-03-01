package com.prueba.KevinMaldonado.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "Depto")
@Data
public class Depto {

	
	private Long Depto_ID;
	private String Nombre, Director, Descripcion;
}
