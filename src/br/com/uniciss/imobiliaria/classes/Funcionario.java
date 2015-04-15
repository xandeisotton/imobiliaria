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
		System.out.println("Insira o codigo do funcionario :");
		codigo = scanner.next();
		validaCpf();
		cadastrosList.add(getLogin());
		cadastrosList.add(getSenha());

		FileWriter arq = new FileWriter("Funcionario.txt", true);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf("Nome: " + getLogin() + "; Senha: " + getSenha()
				+ "; Código: " + codigo + "; Cpf: " + cpf + "; Tipo: " + tipo
				+ "\n" + "\n");
		arq.close();
	}
 
	static void validaCpf() throws IOException {
		System.out.println("Insira o CPF :");
		String cpf = scanner.next();
		String validaCpf = String.valueOf(cpf);
		if 	(validaCpf.equals("00000000000") || validaCpf.equals("11111111111")||
			validaCpf.equals("22222222222") || validaCpf.equals("33333333333") ||
			validaCpf.equals("44444444444") || validaCpf.equals("55555555555") ||
			validaCpf.equals("66666666666") ||validaCpf.equals("77777777777") ||
			validaCpf.equals("88888888888") ||validaCpf.equals("99999999999") ||
		   (validaCpf.length() != 11)) {
			throw new IllegalArgumentException("CPF INVALIDO");
		} else {  
			boolean achou = false;
			String linha = "";
			BufferedReader in = new BufferedReader(new FileReader(
					"Funcionario.txt"));
			while ((linha = in.readLine()) != null) {
				if (linha.contains(cpf)) {
					System.out.println("Cpf já está cadastrado");
					achou = true;
					validaCpf();
				}
			}

		}
	}
}