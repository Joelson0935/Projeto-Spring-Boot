package com.local.NetExercicio.domain.entities;

public enum Posicao {

	GOLEIRO("Goleiro"), ZAGUEIRO("Zagueiro"), LATERAL_DIREITO("Lateral Direito"),
	LATERAL_ESQUERDO("Lateral Esquerdo"), VOLANTE("Volante"), PONTA_ESQUERDA("Ponta Esquerda"), 
	PONTA_DIREITA("Ponta Direita"), MEIA_CENTRAL("Meia Central"), MEIA_OFENSIVO("Meia Ofensivo"),
	ATACANTE("Atacante");

	private final String nome;

	Posicao(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	 
	public static Posicao Valores(String nome) {
		
		for(Posicao valor : Posicao.values()) {
			if(valor.getNome() == nome) {
				return valor;
			}
		}
		throw new IllegalArgumentException("Posição inválida!");
	}
}
