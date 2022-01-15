package com.crud.crudprocedure.service;

import java.util.List;
import java.util.Optional;

import com.crud.crudprocedure.entity.Persona;
import com.crud.crudprocedure.repository.PersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    public List<Persona> lista() {
        return personaRepository.spListaPersonas();
    }
    
    public Optional<Persona> getById(Long id) {
        return personaRepository.spIdPersona(id);
    }

    public List<Persona> getByNombre(String nombre) {
        return personaRepository.spNombrePersona(nombre);
    }
}
