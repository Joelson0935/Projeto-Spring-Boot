package com.local.NetExercicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.local.NetExercicio.domain.entities.Atleta;
import com.local.NetExercicio.domain.exception.NegocioException;
import com.local.NetExercicio.repositorio.AtletaRepositorio;

@Service
public class AtletaService {

	@Autowired
	private AtletaRepositorio atletaRepositorio;

	public Atleta Criar(@RequestBody Atleta atleta) {
		Atleta atletaExistente = atletaRepositorio.findByCpf(atleta.getCpf());
		if (atletaExistente!= null && !atletaExistente.equals(atleta)) {
			throw new NegocioException("Este Cpf já está cadastrado em nosso Banco de dados.");
		}

		return atletaRepositorio.save(atleta);
	}
}
