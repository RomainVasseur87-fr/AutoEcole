package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Client;

public interface IClientDao extends JpaRepository<Client, Long> {

}
