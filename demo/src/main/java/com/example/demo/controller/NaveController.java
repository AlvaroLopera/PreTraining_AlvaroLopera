package com.example.demo.controller;

import java.util.List;

import com.example.demo.entities.Nave;
import com.example.demo.repositories.NavesRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaveController {
    
    private NavesRepository naves;

    public NaveController ( NavesRepository naves ) {
        this.naves = naves;
    } 

    @GetMapping
    public List<Nave> getAllNaves() {
        return naves.findAll();
    }

    @PostMapping
    public List<Nave> createNave ( @RequestBody Nave nuevo ) {
        naves.save(nuevo);
        return naves.findAll();
    }

    @PostMapping
    public void ataque ( @RequestBody Nave n1, @RequestBody Nave n2) {
        
        // Comprobamos que la nave atacante no haya sido destruida previamete

        if ( n1.getHealth() <= 0 ) {
            throw new RuntimeException();
        }


        // El primer parametro es el atacante y suponemos que cada ataque quita 1hp 
        if ( n2.getHealth() > 1 ) {

            n2.setHealth(n2.getHealth() -1 );
            System.out.println("La nave ha perdido: 1hp");

        } else {

            // Se lanza error 

        }

    }




}
