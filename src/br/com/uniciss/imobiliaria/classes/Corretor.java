package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;
import br.com.uniciss.imobiliaria.classes.ValidaCpf;

public class Corretor extends Funcionario{
	
	private int cod;
	
	public String toString() {
		return "Corretor," /* CODIGO AQUI */+ getNome() + "," + getEndereco()
				+ "," + getCpf() + "," + getTelefone();
	}

	/*
	 *  METODO VALIDA TELEFONE
	 */
	
	public boolean isTelefone(String numeroTelefone) {
		return numeroTelefone
				.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}")
				|| numeroTelefone
						.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
	}

	/*
	 *  METODO VALIDA NOME
	 */
	
	public boolean validaNome(String str) {
		return str.matches("[a-zA-Z ]+");
	}

	public void incluirCorretor() {
		/*
		 *  Procedimento para cadastrar Corretor;
		 */
		
		@SuppressWarnings("resource")
		Scanner insere = new Scanner(System.in);

		System.out.println("Insira nome do Corretor: ");
		setNome(insere.nextLine());

		while (!validaNome(nome)) {
			System.out.println("Apenas letras s�o v�lidas.");
			nome = insere.nextLine();
		}

		System.out.println("Insira o endere�o: ");
		setEndereco(insere.nextLine());

		System.out.println("Insira o numero do CPF(apenas n�meros): ");
		setCpf(insere.nextLine());
		
		// VALIDA CPF
		if (ValidaCpf.isCpf(getCpf()) == false){	
			System.out.println("CPF Invalido,tente novamente:");
		}
		while (ValidaCpf.isCpf(getCpf()) == false){
			System.out.println("Insira o numero do CPF:(Somente n�meros.)");
			setCpf(insere.nextLine());		
		}

		System.out.println("Insira o telefone do Corretor: ");
		String numeroTelefone = insere.nextLine();
		while (!isTelefone(numeroTelefone)) {
			System.out.println("Inv�lido, tente novemente.");
			numeroTelefone = insere.nextLine();
		}
		
		System.out.println("  Sucesso! Seu cadastro esta completo.");
		System.out.println("");
		u.setTipo("1");

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
