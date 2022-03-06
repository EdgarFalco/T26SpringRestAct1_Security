package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Suministra;

public interface ISuministraDao extends JpaRepository<Suministra, Integer> {

}
