package com.api.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.crud.model.Persona;

public interface PersonaRepository extends JpaRepository <Persona, Long>{

}
