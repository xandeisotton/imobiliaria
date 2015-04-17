package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	private String codigo;
	static Scanner scanner = new Scanner(System.in);

	//
	// METODO VALIDA NOME
	//
	public boolean validaNome(String str) {
		return str.matches("[a-zA-Z ]+");
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

	Usuario u = new Usuario();

	@SuppressWarnings({ "resource" })
	public void cadastroFuncionario() throws IOException {

		System.out.println("Insira nome do Funcionario:(EX:pedro)");
		String nome = scanner.nextLine();

		while (!validaNome(nome)) {
			System.out.println("Apenas letras são válidas.");
			nome = scanner.nextLine();
		}

		System.out.println("Insira o endereço:(EX:Rua tal, 49)");
		setEndereco(scanner.nextLine());

		System.out
				.println("Insira o telefone do Funcionário:(EX:(00)0000-0000)");
		String numeroTelefone = scanner.nextLine();
		while (!isTelefone(numeroTelefone)) {
			System.out.println("Não entendi, repita o numero do telefone");
			numeroTelefone = scanner.nextLine();
		}

		System.out
				.println("Insira o tipo funcionario : 1 - Corretor / 2 - Secretario");
		u.setTipo(scanner.nextLine());

		System.out.println("Insira o CPF :");
		setCpf(scanner.nextLine());
		//
		// VALIDAR CPF
		//
		String quantidadeCpf;
		String cpf;
		int cont = 0;

		do {
			if (cont != 0) {
				System.out.println("cpf deve conter 11 digitos");
			}

			cpf = scanner.next();
			quantidadeCpf = String.valueOf(cpf);
			cont++;
		} while (quantidadeCpf.length() != 11);

		@SuppressWarnings("unused")
		boolean achou = false;
		String linha = "";
		BufferedReader in = new BufferedReader(
				new FileReader("Funcionario.txt"));
		while ((linha = in.readLine()) != null) {
			if (linha.contains(cpf)) {
				System.out.println("Cpf já está cadastrado");
				achou = true;
				break;

			}
		}
		System.out.println("Insira o login do funcionario:");
		u.setSenha(scanner.next());

		System.out.println("Insira a senha do funcionario:");
		u.setSenha(scanner.next());

		GravaTxt grava = new GravaTxt();
		grava.grava("Funcionario.txt", toString());
		grava.grava("Usuarios.txt", toStringUsuarios());
	}

	public String toString() {
		return "Funcionario," + codigo + "," + nome + "," + cpf + ","
				+ endereco + "," + u.getTipo();
	}

	public String toStringUsuarios() {
		return "Usuario," + "," + u.getLogin() + "," + u.getSenha() + ","
				+ u.getTipo() + "," + codigo;
	}
}