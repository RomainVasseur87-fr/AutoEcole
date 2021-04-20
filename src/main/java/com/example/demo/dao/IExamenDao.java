package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Examen;

public interface IExamenDao extends JpaRepository<Examen, Long> {

}
