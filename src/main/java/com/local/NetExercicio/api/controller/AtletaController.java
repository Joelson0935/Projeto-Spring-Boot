package com.local.NetExercicio.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.local.NetExercicio.domain.entities.Atleta;
import com.local.NetExercicio.repositorio.AtletaRepositorio;
import com.local.NetExercicio.service.AtletaService;

@RestController
@RequestMapping("/Atletas")
public class AtletaController {

	@Autowired
	public AtletaRepositorio atletaRepositorio;

	@Autowired
	public AtletaService atletaService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Atleta Adicionar(@Valid @RequestBody Atleta atleta) {

		return atletaService.Criar(atleta);
	}

	@GetMapping
	public List<Atleta> BuscarTodos() {
		return atletaRepositorio.findAll();
	}

	@GetMapping("/{AtletaId}")
	public ResponseEntity<Atleta> Buscar(@PathVariable Long AtletaId) {
		Optional<Atleta> atleta = atletaRepositorio.findById(AtletaId);
		if (!atleta.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(atleta.get());
	}

	@PutMapping("/{AtletaId}")
	public ResponseEntity<Atleta> Atualizar(@Valid @PathVariable Long AtletaId, @RequestBody Atleta atleta) {

		if (atletaRepositorio.existsById(AtletaId)) {
			atleta.setId(AtletaId);
			atleta = atletaRepositorio.save(atleta);
			return ResponseEntity.ok(atleta);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{AtletaId}")
	public ResponseEntity<Void> deletar(@PathVariable Long AtletaId) {
		if (atletaRepositorio.existsById(AtletaId)) {
			atletaRepositorio.deleteById(AtletaId);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
