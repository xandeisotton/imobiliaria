package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;

public class Secretario extends Funcionario {

	private int cod;

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

	public void incluirSecretario() {
		//
		// Procedimento para cadastrar Secretario;
		//
		@SuppressWarnings("resource")
		Scanner insere = new Scanner(System.in);

		System.out.println("Insira nome do secretário:(EX:pedro)");
		String nome = insere.nextLine();

		while (!validaNome(nome)) {
			System.out.println("Apenas letras são válidas.");
			nome = insere.nextLine();
		}

		System.out.println("Insira o endereço:(EX:Rua tal, 49)");
		setEndereco(insere.nextLine());

		System.out.println("Insira o numero do CPF:(EX:000.000.000-69)");
		setCpf(insere.nextLine());

		System.out
				.println("Insira o telefone do secretário:(EX:(00)0000-0000)");
		String numeroTelefone = insere.nextLine();
		while (!isTelefone(numeroTelefone)) {
			System.out.println("repita o numero do telefone");
			numeroTelefone = insere.nextLine();

			System.out.println("Insira o login do funcionario:");
			u.setLogin(scanner.next());

			System.out.println("Insira a senha do funcionario:");
			u.setSenha(scanner.next());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("  Sucesso! Seu cadastro esta completo.");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("1-> Voltar ao menu");
		System.out.println("2-> Cadastrar outro funcionário");
		System.out.println("3-> Log Off");
		GravaTxt gravaArq = new GravaTxt();

	}

	public String toString() {
		return "Funcionario," + getCodigo() + "," + nome + "," + cpf + ","
				+ endereco + "," + u.getTipo();
	}

	public String toStringUsuarios() {
		return "Usuario," + "," + u.getLogin() + "," + u.getSenha() + ","
				+ u.getTipo() + "," + getCodigo();
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
