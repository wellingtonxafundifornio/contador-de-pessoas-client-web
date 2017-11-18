package com.softwareltda.peopleCounter.model;

public class Contador {

	private int quantidadeDePessoas;

	public Contador() {
		this.quantidadeDePessoas = 0;
	}

	public void registraEntrada() {
		quantidadeDePessoas++;
	}

	public void registraSaida() {
		quantidadeDePessoas--;
		if (quantidadeDePessoas < 0) {
			quantidadeDePessoas = 0;
			return;
		}
	}

	public int getQuantidadeDePessoas() {
		return quantidadeDePessoas;
	}

	public void setQuantidadeDePessoas(final int quantidadeDePessoas) {
		this.quantidadeDePessoas = quantidadeDePessoas;
	}

	public void atualizaQuantidadePessoasSala(final String topico) {

		if (topico.equalsIgnoreCase("contadorDePessoas/entrada")) {
			registraEntrada();
		}

		if (topico.equalsIgnoreCase("contadorDePessoas/saida")) {
			registraSaida();
		}
	}

}
