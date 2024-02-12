package br.com.dio.desafio.dominio;

import java.util.ArrayList;

public class TesteConhecimento {
	protected static final double XP_TESTE = 5d; 
	private final int NUMERO_PERGUNTAS = 5;
	private ArrayList<String> perguntas;
	private final int ACERTOS = 3;
	private String situação;
	private ArrayList<String> respostas;
	
	public TesteConhecimento(ArrayList<String> perguntas, ArrayList<String> respostas) {
		this.respostas = respostas;
		this.perguntas = perguntas;
		this.situação = "";
	}

	public int getNumeroPerguntas() {
		return NUMERO_PERGUNTAS;
	}


	public ArrayList<String> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(ArrayList<String> perguntas) {
		this.perguntas = perguntas;
	}

	public int getAcertos() {
		return this.ACERTOS;
	}

	public String getSituação() {
		return situação;
	}

	public void setSituação(String situação) {
		this.situação = situação;
	}

	public ArrayList<String> getRespostas() {
		return respostas;
	}

	public void setRespostas(ArrayList<String> respostas) {
		this.respostas = respostas;
	}

	public static double getXpTeste() {
		return XP_TESTE;
	}
	
	
	
	
	
}
