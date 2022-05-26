package com.example.demo.entities;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Anotaciones
@Entity
@Table
public class Nave {
    
    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private int health;


    public Nave ( ) {
        this.health = 0;
    }

    public Nave (int vida) {
        this.health = vida;
    }

    public int getHealth ( ) {
        return health;
    }

    public void setHealth ( int vida ) {
        this.health = vida;
    }

}
