package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;

public class Alugar extends Imovel {

	double mensalidade;

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public void alugar() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.println("Informe o c�digo do im�vel");
		setCod(s.nextInt());
		// valida��o do c�d

		System.out.println("Infome o valor da mensalidade");
		setMensalidade(s.nextDouble());

		System.out.println("Infome o c�digo do locat�rio");
		setCod(s.nextInt());
		// valida��o do c�d
	}
}