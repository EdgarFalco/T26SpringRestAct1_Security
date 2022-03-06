package main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import main.dto.Pieza;

public interface IPiezaDao extends JpaRepository<Pieza, Integer> {

}
