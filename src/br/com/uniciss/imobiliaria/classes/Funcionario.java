package br.com.uniciss.imobiliaria.classes;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Funcionario extends Cadastros {
	private String codigo;
	private long cpf;
	private String tipo;
	void cadastroFuncionario() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insira o nome do funcionario :");
		setNomeCompleto(scanner.nextLine());
		System.out.println("Insira sua senha :");
		setSenha(scanner.next());
		System.out.println("Insira o codigo do funcionario :");
		codigo = scanner.next();
		System.out.println("Insira o CPF :");
		cpf = scanner.nextLong();
		String validaCpf = String.valueOf(cpf);
		if (validaCpf.length() != 11) {
			throw new IllegalArgumentException("O CPF deve ter 11 caracteres!");
		}
		System.out.println("Insira o tipo do funcionario");
		tipo = scanner.next();

		cadastrosList.add(getNomeCompleto());
		cadastrosList.add(getSenha());

		FileWriter arq = new FileWriter("Funcionario.txt", true);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.printf("Nome: " + getNomeCompleto() + "; Senha: "
				+ getSenha() + "; Código: " + codigo + "; Cpf: " + cpf
				+ "; Tipo: " + tipo + "\n" + "\n");
		arq.close();
	}

}