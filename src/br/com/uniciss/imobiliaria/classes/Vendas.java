package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;


public class Vendas {
	private int cod;
	private double valor;
	
	public void vender() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.println("Informe o c�digo do im�vel:");
		setCod(s.nextInt());
		// valida��o do c�d

		System.out.println("Infome o valor da venda:");
		setValor(s.nextDouble());

		System.out.println("Infome o c�digo do cliente:");
		setCod(s.nextInt());
		// valida��o do c�d
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
