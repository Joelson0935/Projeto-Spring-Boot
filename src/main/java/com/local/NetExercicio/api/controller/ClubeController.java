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

import com.local.NetExercicio.domain.entities.Clube;
import com.local.NetExercicio.repositorio.ClubeRepositorio;
import com.local.NetExercicio.service.ClubeService;

@RestController
@RequestMapping("/Clubes")
public class ClubeController {

	@Autowired
	private ClubeRepositorio clubeRepositorio;

	@Autowired
	private ClubeService clubeService;

	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Clube Adicionar(@Valid @RequestBody Clube clube) {
		clube.getAtletas();
		return clubeService.Criar(clube);
	}

	@GetMapping
	public List<Clube> BuscarTodos() {
		return clubeRepositorio.findAll();

	}

	@GetMapping("/{ClubeId}")
	public ResponseEntity<Clube> Buscar(@PathVariable Long ClubeId) {
		Optional<Clube> clube = clubeRepositorio.findById(ClubeId);
		if (clube.isPresent()) {
			return ResponseEntity.ok(clube.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{ClubeId}")
	public ResponseEntity<Clube> Atualizar(@Valid @PathVariable Long ClubeId, @RequestBody Clube clube) {

		if (!clubeRepositorio.existsById(ClubeId)) {

			return ResponseEntity.notFound().build();
		}
		clube.setId(ClubeId);
		clube = clubeRepositorio.save(clube);
		return ResponseEntity.ok(clube);
	}

	@DeleteMapping("/{ClubeId}")
	public ResponseEntity<Void> Deletar(@PathVariable Long ClubeId) {
		if (!clubeRepositorio.existsById(ClubeId)) {
			ResponseEntity.notFound().build();
		}
		clubeService.excluir(ClubeId);
		return ResponseEntity.noContent().build();
	}
}
