package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Score;

public interface IScoreDao extends JpaRepository<Score, Long> {

}
