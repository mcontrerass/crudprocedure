package com.crud.crudprocedure.repository;

import java.util.List;
import java.util.Optional;

import com.crud.crudprocedure.entity.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    @Query(value = "select * from sp_lista_personas()", nativeQuery = true)
    List<Persona> spListaPersonas();
    
    @Query(value = "select * from sp_id_persona(:idIn)", nativeQuery = true)
    Optional<Persona> spIdPersona(@Param("idIn") long idIN);

    @Query(value = "select * from sp_nombre_persona(:nombreIn)", nativeQuery = true)
    List<Persona> spNombrePersona(@Param("nombreIn") String nombreIN);
}
