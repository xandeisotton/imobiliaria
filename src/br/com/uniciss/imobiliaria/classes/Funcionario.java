package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Funcionario extends Cadastros {
	private String codigo;
	private static String cpf;
	private String tipo;
	private String NomeCompleto;
	static Scanner scanner = new Scanner(System.in);

	@SuppressWarnings({ "resource", "unchecked" })
	public void cadastroFuncionario() throws IOException {

		System.out.println("Insira o nome do funcionario :");
		setLogin(scanner.nextLine());
		System.out.println("Insira sua senha :");
		setSenha(scanner.next());
		System.out.println("Insira o tipo funcionario :");
		tipo = scanner.next();
		System.out.println("Insira o CPF :");
		String cpf = scanner.next();
		String quantidadeCpf = String.valueOf(cpf);
		if (quantidadeCpf.length() != 11) {
			System.out.println("O CPF deve ter 11 caracteres!");

			boolean achou = false;
			String linha = "";
			BufferedReader in = new BufferedReader(new FileReader(
					"Funcionario.txt"));
			while ((linha = in.readLine()) != null) {
				if (linha.contains(cpf)) {
					System.out.println("Cpf já está cadastrado");
					achou = true;
					break;

				}

				GravaTxt grava = new GravaTxt();
				grava.toString();
			}
		}
	}

	@Override
	public String toString() {
		return "Funcionario [codigo=" + codigo + ", tipo=" + tipo
				+ ", NomeCompleto=" + NomeCompleto + ", login=" + login
				+ ", senha=" + senha + "]";
	}
}