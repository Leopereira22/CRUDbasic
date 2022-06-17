package com.example.crud.domain.repository;

import com.example.crud.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contatos extends JpaRepository<Contato, Integer> {
}
