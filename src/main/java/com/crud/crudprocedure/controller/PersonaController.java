package com.crud.crudprocedure.controller;

import java.util.List;
import java.util.Optional;

import com.crud.crudprocedure.entity.Persona;
import com.crud.crudprocedure.service.PersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/persona")
public class PersonaController {
    
    @Autowired
    PersonaService personaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Persona>> lista() {
        List<Persona> lista = personaService.lista();
        return new ResponseEntity(lista, HttpStatus.OK);
    }

    @GetMapping("/verid/{id}")
    public ResponseEntity<Persona> verId(@PathVariable("id") long id) {
        Optional<Persona> persona = personaService.getById(id);
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    @GetMapping("/vernombre/{nombre}")
    public ResponseEntity<List<Persona>> verNombre(@PathVariable("nombre") String nombre) {
        List<Persona> persona = personaService.getByNombre(nombre);
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
