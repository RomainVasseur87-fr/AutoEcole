package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.CdRom;

public interface ICdRomDao extends JpaRepository<CdRom, Long> {

}
