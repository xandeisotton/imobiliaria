package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Funcionario extends Pessoa {
	private String codigo;
	static Scanner scanner = new Scanner(System.in);

	Usuario u = new Usuario();

	@SuppressWarnings({ "resource", "unchecked" })
	public void cadastroFuncionario() throws IOException {

		System.out.println("Insira o nome do funcionario :");
		setNome(scanner.nextLine());
		if (validaTexto(nome) == false) {
			do {
				System.out.println("nome deve conter somente letras");
				nome = scanner.nextLine();
			} while (validaTexto(nome) == false);
		}

		System.out.println("Insira o endere�o do funcionario :");
		setEndereco(scanner.nextLine());

		System.out.println("Insira o telefone do funcionario :");
		setTelefone(scanner.nextLine());
		if (validaN(telefone) == false) {
			do {
				System.out.println("telefone deve conter somente numeros");
				telefone = scanner.next();
			} while (validaN(telefone) == false);
		}

		System.out
				.println("Insira o tipo funcionario : 1 - Corretor / 2 - Secretario");
		u.setTipo(scanner.next());

		System.out.println("Insira o CPF :");
		setCpf(scanner.next());
		if (validaCpf(cpf) == false) {
			do {
				System.out.println("Cpf deve conter somente numeros");
				cpf = scanner.next();
			} while (validaCpf(cpf) == false);
		}

		String quantidadeCpf;
		String cpf;

		do {
			System.out.println("cpf deve conter 11 digitos");
			cpf = scanner.next();
			quantidadeCpf = String.valueOf(cpf);
		} while (quantidadeCpf.length() != 11);

		boolean achou = false;
		String linha = "";
		BufferedReader in = new BufferedReader(
				new FileReader("Funcionario.txt"));

		do {
			if (linha.contains(cpf)) {
				System.out
						.println("Cpf j� est� cadastrado,\n insira novamente");
				cpf = scanner.next();
				achou = true;

			}
		} while ((linha = in.readLine()) != null);

		System.out.println("Insira o login do funcionario:");
		u.setLogin(scanner.next());

		System.out.println("Insira a senha do funcionario:");
		u.setSenha(scanner.next());

		GravaTxt grava = new GravaTxt();
		grava.grava("Funcionario.txt", toString());
		grava.grava("Usuarios.txt", toStringUsuarios());

		codigo = codigo + 1;
		System.out.println("cadastrado com sucesso");
	}

	public String toString() {
		return "Funcionario," + codigo + "," + nome + "," + cpf + ","
				+ endereco + "," + u.getTipo();
	}

	public String toStringUsuarios() {
		return "Usuario," + "," + u.getLogin() + "," + u.getSenha() + ","
				+ u.getTipo() + "," + codigo;
	}

	public boolean validaN(String txt) {
		return txt.matches("^[0-9]*$");
	}

	public boolean validaTexto(String texto) {
		return texto.matches("[a-z A-Z]+");

	}

	public boolean validaCpf(String vcpf) {
		return vcpf.matches("^[0-9]*$");
	}

}