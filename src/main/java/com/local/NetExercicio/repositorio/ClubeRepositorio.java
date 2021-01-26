package com.local.NetExercicio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.local.NetExercicio.domain.entities.Clube;

public interface ClubeRepositorio extends JpaRepository<Clube, Long> {

	Clube findByNome(String nome);
}
