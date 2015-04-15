package br.com.uniciss.imobiliaria.classes;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public abstract class Cliente extends Pessoa {

	protected String banco;
	protected String numConta;
	protected String codigo;
	private Scanner cadastro;

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Cliente," + banco + "," + numConta + "," + codigo + ","
				+ cadastro + "," + nome + "," + endereco + "," + cpf + ","
				+ telefone;
	}

	public void CadastroCliente() throws Exception {
		cadastro = new Scanner(System.in);

		System.out.println("Informe o nome do cliente!");
		setNome(cadastro.nextLine());

		System.out.println("Informe o endereco do cliente!");
		setEndereco(cadastro.nextLine());

		System.out.println("Informe o numero do CPF do cliente!");
		setCpf(cadastro.nextLine());

		System.out.println("Informe o numero do telefone do ciente!");
		setTelefone(cadastro.nextLine());

		System.out.println("Informe o banco em que o cliente tem conta!");
		setBanco(cadastro.nextLine());

		System.out.println("Informe o numero da conta do cliente!");
		setNumConta(cadastro.nextLine());

		System.out.println("Informe o codigo do cliente!");
		setCodigo(cadastro.nextLine());

		GravaTxt g = new GravaTxt();
		g.grava("Cliente.txt", toString());

		Scanner entrada = new Scanner(System.in);
		System.out.println("O que deseja fazer?\n 1-Cadastrar novamente!\n 2-Voltar ao menu!");
		int cont = entrada.nextInt();
		do {
			switch (cont) {

			case 1:
				CadastroCliente();
				break;

			case 2:
				Menu m = new Menu();
				m.menus();
			default:
				System.out.println("Você informou uma opção inválida!");
			}
		} while ((cont != 1) || (cont != 2));
	}

	@SuppressWarnings("resource")
	public void ListaCliente() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("Cliente.txt")));
		String linha = br.readLine();

		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		Scanner entrada = new Scanner(System.in);
		System.out
				.println("O que deseja fazer?\n 1-Voltar ao Menu\n 2-Listar Novamente!");
		int cont = entrada.nextInt();
		switch (cont) {

		case 1:
			Menu menu = new Menu();
			menu.menus();
			break;

		case 2:
			ListaCliente();
			break;

		}
		entrada.close();
		br.close();
	}
}
