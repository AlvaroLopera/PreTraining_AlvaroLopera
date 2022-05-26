package com.example.demo.repositories;

import com.example.demo.entities.Nave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface NavesRepository extends JpaRepository<Nave, Long > {
    
    @GetMapping
    public void getAllNaves();

    @GetMapping
    public Nave getNave();

}
