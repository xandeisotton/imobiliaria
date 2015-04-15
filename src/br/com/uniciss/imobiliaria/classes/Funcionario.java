package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	private String codigo;
	static Scanner scanner = new Scanner(System.in);

	Usuario u = new Usuario();

	@SuppressWarnings({ "resource", "unchecked" })
	public void cadastroFuncionario() throws IOException {

		System.out.println("Insira o nome do funcionario :");
		setNome(scanner.nextLine());

		System.out.println("Insira o endereço do funcionario :");
		setEndereco(scanner.nextLine());

		System.out.println("Insira o telefone do funcionario :");
		setTelefone(scanner.nextLine());

		System.out
				.println("Insira o tipo funcionario : 1 - Corretor / 2 - Secretario");
		u.setTipo(scanner.nextLine());

		System.out.println("Insira o CPF :");
		setCpf(scanner.nextLine());

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