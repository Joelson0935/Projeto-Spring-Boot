package com.local.NetExercicio.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.local.NetExercicio.domain.entities.Atleta;

@Repository
public interface AtletaRepositorio extends JpaRepository<Atleta, Long>{

	Atleta findByCpf(String cpf);
}
