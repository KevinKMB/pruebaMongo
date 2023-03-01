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

import com.prueba.KevinMaldonado.model.Profesor;
import com.prueba.KevinMaldonado.service.ProfesorService;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

	@Autowired
    ProfesorService profesorService;

    @GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarProfesor() {
        return new ResponseEntity<>(profesorService.findByAll(), 
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Profesor> crearProfesor(
            @RequestBody Profesor p) {
        return new ResponseEntity<>(profesorService.save(p), 
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Profesor> actualizarProfesor(@PathVariable Long id, @RequestBody Profesor p) {
        Profesor profesorList = profesorService.findById(id);
        if (profesorList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
            	profesorList.setNombre(p.getNombre());
            	profesorList.setDireccion(p.getDireccion());
            	profesorList.setTelefono(p.getTelefono());
                return new ResponseEntity<>(profesorService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Profesor> eliminarProfesor(@PathVariable Long id) {
        profesorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
