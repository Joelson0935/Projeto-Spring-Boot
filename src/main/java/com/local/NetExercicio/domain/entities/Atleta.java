package com.local.NetExercicio.domain.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Atleta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 40)
	private String nome;

	@NotBlank
	@Size(max = 14)
	private String cpf;

	@NotBlank
	@Size(max = 10)
	@JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
	private String dtaNascimento;

	@ManyToOne
	@JoinColumn(name = "clube_id")
	private Clube clube;

	private String posicao;

	public Atleta() {

	}

	public Atleta(Long id, @NotBlank String nome, @NotBlank String cpf, @NotBlank String dtaNascimento, Clube clube,
			Posicao posicao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtaNascimento = dtaNascimento;
		this.clube = clube;
		setPosicao(posicao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDtaNascimento() {
		return dtaNascimento;
	}

	public void setDtaNascimento(String dtaNascimento) {
		this.dtaNascimento = dtaNascimento;
	}

	@JsonIgnore
	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {

		this.clube = clube;
	}

	public Posicao getPosicao() {
		return Posicao.Valores(posicao);
	}

	public void setPosicao(Posicao posicao) {
		if (posicao != null) {
			this.posicao = posicao.getNome();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
