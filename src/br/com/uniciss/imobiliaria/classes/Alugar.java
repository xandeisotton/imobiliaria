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

		System.out.println("Informe o código do imóvel");
		setCod(s.nextInt());
		// validação do cód

		System.out.println("Infome o valor da mensalidade");
		setMensalidade(s.nextDouble());

		System.out.println("Infome o código do locatário");
		setCod(s.nextInt());
		// validação do cód
	}
}