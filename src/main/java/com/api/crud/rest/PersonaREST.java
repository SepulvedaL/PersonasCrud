package com.api.crud.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.model.Persona;
import com.api.crud.service.PersonaService;


@RestController
@RequestMapping("/personas")
public class PersonaREST {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Persona> savePersona(@RequestBody Persona persona) {
        try {
            Persona personaGuardada = personaService.save(persona);
            return ResponseEntity.created(new URI("/personas/" + personaGuardada.getId()))
                                 .body(personaGuardada);
        } catch (URISyntaxException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
