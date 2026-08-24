package com.hotcantina.repository;

import com.hotcantina.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancheRepository extends JpaRepository<Lanche,Long> {
    List<Lanche> findByNome(String nome);
}
