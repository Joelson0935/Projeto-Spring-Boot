package com.local.NetExercicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.local.NetExercicio.domain.entities.Clube;
import com.local.NetExercicio.domain.exception.NegocioException;
import com.local.NetExercicio.repositorio.ClubeRepositorio;

@Service
public class ClubeService {

	@Autowired
	private ClubeRepositorio clubeRepositorio;

	public Clube Criar(Clube clube) {

		Clube clubeExistente = clubeRepositorio.findByNome(clube.getNome());
		if (clubeExistente != null && !clubeExistente.equals(clube)) {
			throw new NegocioException("Este Clube já existe, Favor inserir um clube novo.");
		}
		return clubeRepositorio.save(clube);
	}

	public void excluir(Long id) {
		clubeRepositorio.deleteById(id);
	}

}
