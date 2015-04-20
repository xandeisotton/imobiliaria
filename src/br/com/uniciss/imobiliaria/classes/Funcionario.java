package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	private int codigo;
	static Scanner scanner = new Scanner(System.in);

	Usuario u = new Usuario();

	@SuppressWarnings({ "resource" })
	public void cadastroFuncionario() throws IOException {

		System.out.println("Insira o nome do funcionario :");
		setNome(scanner.nextLine());
		if (validaTexto(nome) == false) {
			do {
				System.out.println("nome deve conter somente letras");
				nome = scanner.nextLine();
			} while (validaTexto(nome) == false);
		}

		System.out.println("Insira o endereço do funcionario :");
		setEndereco(scanner.nextLine());

		System.out.println("Insira o telefone do funcionario :");
		setTelefone(scanner.nextLine());

		if (validaN(telefone) == false) {
			do {
				System.out.println("telefone deve conter somente numeros");
				telefone = scanner.next();
			} while (validaN(telefone) == false);
		}

		// String quantidadeNumeros = String.valueOf(telefone);
		//
		// if (quantidadeNumeros.length() < 8) {
		// do {
		// System.out.println("Telefone deve conter no mínimo 8 digitos");
		// telefone = scanner.next();
		// } while (quantidadeNumeros.length() < 8);
		// }

		System.out
				.println("Insira o tipo funcionario : 1 - Corretor / 2 - Secretario");
		int opcao = scanner.nextInt();

		while (opcao != 1 && opcao != 2) {
			System.out
					.println("Insira o tipo funcionario : 1 - Corretor / 2 - Secretario");
			opcao = scanner.nextInt();
		}
		//
		// if (opcao == 1) {
		// u.setTipo("1");
		// return;
		// } else if (opcao == 2) {
		// u.setTipo("2");
		// return;
		// }

		System.out.println("Insira o numero do CPF:(Somente números.)");
		setCpf(scanner.next());

		if (ValidaCpf.isCpf(getCpf()) == false) {
			System.out.println("CPF Inválido, tente novamente:");
		}
		while (ValidaCpf.isCpf(getCpf()) == false) {
			System.out.println("Insira o número do CPF(Somente números):");
			setCpf(scanner.nextLine());
		}

		@SuppressWarnings("unused")
		boolean achou = false;
		String linha = "";
		BufferedReader in = new BufferedReader(
				new FileReader("Funcionario.txt"));

		do {
			if (linha.contains(cpf)) {
				System.out.println("Cpf já está cadastrado, insira novamente");
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

		System.out.println("cadastrado com sucesso");

		List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
		LerBanco lbanco = new LerBanco();
		lbanco.leituraFuncionario(listaFuncionarios);
		setCodigo(listaFuncionarios.size());

	}

	public String toString() {
		return "Funcionario," + getCodigo() + "," + nome + "," + cpf + ","
				+ endereco + "," + u.getTipo();
	}

	public String toStringUsuarios() {
		return "Usuario," + "," + u.getLogin() + "," + u.getSenha() + ","
				+ u.getTipo() + "," + getCodigo();
	}

	public boolean validaN(String txt) {
		return txt.matches("^[0-9]*$");
	}

	public boolean validaTexto(String texto) {
		return texto.matches("[a-z A-Z]+");

	}

	public int getString() {
		return codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int i) {
		this.codigo = i;
	}

}
