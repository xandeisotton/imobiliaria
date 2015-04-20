package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;

public class Secretario extends Funcionario {

	private int cod;


	/*
	 *  METODO VALIDA TELEFONE
	 */

	public boolean isTelefone(String numeroTelefone) {
		return numeroTelefone.matches(".((10)|([1-9][1-9]).)\\s9?[6-9][0-9]{3}-[0-9]{4}") || numeroTelefone.matches(".((10)|([1-9][1-9]).)\\s[2-5][0-9]{3}-[0-9]{4}");
	}

	/*
	 *  METODO VALIDA NOME
	 */

	public boolean validaNome(String str) {
		return str.matches("[a-zA-Z ]+");
	}

	/*public void incluirSecretario() {
		/*
		 *  Procedimento para cadastrar Secretario;
		 
		@SuppressWarnings("resource")
		Scanner insere = new Scanner(System.in);

		System.out.println("Insira nome do secretário:(EX:pedro)");
		setNome(insere.nextLine());

		while (!validaNome(nome)) {
			System.out.println("Apenas letras são válidas.");
			setNome(insere.nextLine());
		}

		System.out.println("Insira o endereço:(EX:Rua tal, 49)");
		setEndereco(insere.nextLine());

		System.out.println("Insira o numero do CPF:(Somente números.)");
		setCpf(insere.nextLine());

		//Valida CPF

		if (ValidaCpf.isCpf(getCpf())==false){	
			System.out.println("CPF Inválido,tente novamente:");
		}
		while (ValidaCpf.isCpf(getCpf())== false){
			System.out.println("Insira o número do CPF:(Somente números.)");
			setCpf(insere.nextLine());		
		}

		System.out.println("Insira o telefone do secretário:(EX:(00)0000-0000)");
		setTelefone(insere.nextLine());

		System.out.println("Insira o login do funcionario:");
		u.setLogin(scanner.next());

		System.out.println("Insira a senha do funcionario:");
		u.setSenha(scanner.next());

		System.out.println("  Sucesso! Seu cadastro esta completo.");
		System.out.println("");  
		u.setTipo("2");
		
		GravaTxt gravaArq = new GravaTxt();
		
		gravaArq.grava("Funcionario.txt", toString());
		gravaArq.grava("Usuario.txt", toStringUsuarios());

	}*/

	public String toString() {
		return "Funcionario," + getCod() + "," + nome + "," + cpf + ","
				+ endereco + "," + u.getTipo();
	}

	public String toStringUsuarios() {
		return "Usuario," + "," + u.getLogin() + "," + u.getSenha() + ","
				+ u.getTipo() + "," + getCod();
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
