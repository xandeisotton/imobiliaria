package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;
import br.com.uniciss.imobiliaria.classes.ValidaCpf;

public class Corretor extends Funcionario{
	
	private int cod;
	
	public String toString() {
		return "Corretor," /* CODIGO AQUI */+ getNome() + "," + getEndereco()
				+ "," + getCpf() + "," + getTelefone();
	}

	//
	// METODO VALIDA TELEFONE
	//
	public boolean isTelefone(String numeroTelefone) {
		return numeroTelefone
				.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}")
				|| numeroTelefone
						.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
	}

	//
	// METODO VALIDA NOME
	//
	public boolean validaNome(String str) {
		return str.matches("[a-zA-Z ]+");
	}

	public void incluirCorretor() {
		//
		// Procedimento para cadastrar Secretario;
		//
		@SuppressWarnings("resource")
		Scanner insere = new Scanner(System.in);

		System.out.println("Insira nome do Corretor:(EX:pedro)");
		String nome = insere.nextLine();

		while (!validaNome(nome)) {
			System.out.println("Apenas letras são válidas.");
			nome = insere.nextLine();
		}

		System.out.println("Insira o endereço:(EX:Rua tal, 49)");
		setEndereco(insere.nextLine());

		System.out.println("Insira o numero do CPF:(Somente números.)");
		setCpf(insere.nextLine());
		
		if (ValidaCpf.isCpf(getCpf())==false){	
			System.out.println("CPF Invalido");
		}
		while (ValidaCpf.isCpf(getCpf())== false){
			System.out.println("Informe o número do CPF do cliente!");
			setCpf(insere.nextLine());		
		}

		System.out.println("Insira o telefone do Corretor:(EX:(00)0000-0000)");
		String numeroTelefone = insere.nextLine();
		while (!isTelefone(numeroTelefone)) {
			System.out.println("Não entendi, repita o numero do telefone");
			numeroTelefone = insere.nextLine();
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("  Sucesso! Seu cadastro esta completo.");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");

		GravaTxt gravaArq = new GravaTxt();

		gravaArq.grava("Corretor.txt", toString());

	}

	public void alterarSecretario() {
		// codificar metodos
	}

	public void removerSecretario() {
		// codificar metodos
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
}
