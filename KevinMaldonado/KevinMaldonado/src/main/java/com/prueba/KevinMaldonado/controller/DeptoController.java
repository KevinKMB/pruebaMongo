package com.prueba.KevinMaldonado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.KevinMaldonado.model.Depto;
import com.prueba.KevinMaldonado.model.Profesor;
import com.prueba.KevinMaldonado.service.DeptoService;
import com.prueba.KevinMaldonado.service.ProfesorService;

@RestController
@RequestMapping("/api/depto")
public class DeptoController {

	@Autowired
    DeptoService deptoService;

    @GetMapping("/listar")
    public ResponseEntity<List<Depto>> listarDepto() {
        return new ResponseEntity<>(deptoService.findByAll(), 
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Depto> crearDepto(
            @RequestBody Depto p) {
        return new ResponseEntity<>(deptoService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Depto> actualizarDepto(@PathVariable Long id, @RequestBody Depto p) {
        Depto deptoList = deptoService.findById(id);
        if (deptoList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	deptoList.setNombre(p.getNombre());
            	deptoList.setDirector(p.getDirector());
            	deptoList.setDescripcion(p.getDescripcion());
                return new ResponseEntity<>(deptoService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminarDepto(@PathVariable Long id) {
    	deptoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
