package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Question;

public interface IQuestionDao extends JpaRepository<Question, Long> {

}
