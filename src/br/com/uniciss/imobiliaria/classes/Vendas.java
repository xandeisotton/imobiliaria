package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;


public class Vendas {
	private int cod;
	private double valor;
	
	public void vender() {
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);

		System.out.println("Informe o código do imóvel:");
		setCod(s.nextInt());
		
		System.out.println("Infome o código do cliente que esta adquirindo:");
		setCod(s.nextInt());
		// validação do cód
		
		System.out.println("Infome o valor da venda:");
		setValor(s.nextDouble());
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("  Sucesso! Seu cadastro esta completo.");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		
		GravaTxt gravaArq = new GravaTxt();

		gravaArq.grava("Vendas.txt", toString());


	
	}

	@Override
	public String toString() {
		return "Vendas [cod=" + cod + ", valor=" + valor + "]";
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
/*System.out.println("Informe o nome do Paciente");
String nome = teclado.nextLine();
nome = nome.replace(" ", "");
nome = nome.toLowerCase();

for (Cliente paciente : listaPaciente) {
String nomeDaVez = paciente.getNome().replace(" ", "");

if (nomeDaVez.toLowerCase().equals(nome)) {
System.out.println("------- Paciente " + paciente.getNome() */
