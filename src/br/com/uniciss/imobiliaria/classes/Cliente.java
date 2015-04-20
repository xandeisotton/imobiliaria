package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Cliente extends Pessoa {
	List<Object> listaCliente = new ArrayList<Object>();
	public static Map<String, Cliente> mapaDeClientes = new HashMap<String, Cliente>();
	protected String banco;
	protected String numConta;
	protected String codigo;
	private Scanner cadastro;
	private Scanner entrada;
	private BufferedReader in;

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
		if (validaTexto(nome) == false) {
			do {
				System.out.println("nome deve conter somente letras");
				nome = cadastro.nextLine();
			} while (validaTexto(nome) == false);
		}

		System.out.println("Informe o endereco do cliente!");
		setEndereco(cadastro.nextLine());

		System.out.println("Informe o número do CPF do cliente!");
		setCpf(cadastro.nextLine());
		// Validação DE CPF:
		if (ValidaCpf.isCpf(getCpf()) == false) {
			System.out.println("CPF Invalido");
		}
		while (ValidaCpf.isCpf(getCpf()) == false) {
			System.out.println("Informe o número do CPF do cliente!");
			setCpf(cadastro.nextLine());
		}

		System.out.println("Informe o número do telefone do ciente!");
		setTelefone(cadastro.nextLine());
		if (validaN(telefone) == false) {
			do {
				System.out.println("telefone deve conter somente numeros");
				telefone = cadastro.next();
			} while (validaN(telefone) == false);
		}

		System.out.println("Informe o banco em que o cliente tem conta!");
		setBanco(cadastro.nextLine());

		System.out.println("Informe o numero da conta do cliente!");
		setNumConta(cadastro.nextLine());

		GravaTxt g = new GravaTxt();
		g.grava("Cliente.txt", toString());

		entrada = new Scanner(System.in);
	}

	public void pesquisaCliente() throws Exception {

		entrada = new Scanner(System.in);
		boolean achou = false;
		String linha = "";
		@SuppressWarnings("unused")
		String nomeArquivo = "Clientes.txt";

		System.out.println("Informe o código do cliente");
		String codigo = entrada.next();

		in = new BufferedReader(new FileReader("Cliente.txt"));

		try {
			while ((linha = in.readLine()) != null) {
				if (linha.contains(codigo)) {
					System.out.println(linha);
					achou = true;
				}
			}
			if (!achou) {
				System.out.println("Cliente não existente!\n");
			}
		} catch (NullPointerException erro) {
			System.out.println("Código inválido!");
		}
	}

	/*
	 * ISSO É UM TESTE, FAVOR NAO APAGAR
	 * 
	 * public static void preencheMapa() throws IOException { Iterator<Cliente>
	 * i = listaCliente().iterator();
	 * 
	 * while (i.hasNext()) { Cliente c = i.next();
	 * mapaDeClientes.put(c.getNome(), c); } } public static Cliente
	 * buscaPorNome(String nomeBusca) throws IOException { preencheMapa();
	 * Cliente c = mapaDeClientes.get(nomeBusca); try { String nome =
	 * c.getNome(); String cpf = c.getCpf(); String endereco = c.getEndereco();
	 * String telefone = c.getTelefone();
	 * 
	 * 
	 * c = new Cliente(nome, cpf, endereco, telefone); return c;
	 * 
	 * } catch (NullPointerException n) { n.getMessage(); return c; } }
	 */

	public void alteraLinha(String palavraAntiga, String palavraNova)
			throws IOException {

		String arquivo = "ARQUIVO";
		String arquivoTmp = "ARQUIVO=Tmp";

		BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTmp));
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));

		String linha;
		while ((linha = reader.readLine()) != null) {
			if (linha.contains(palavraAntiga)) {
				linha = linha.replace(palavraAntiga, palavraNova);
			}
			writer.write(linha + "\n");
		}
		writer.close();
		reader.close();

		new File(arquivo).delete();
		new File(arquivoTmp).renameTo(new File(arquivo));
	}

	public void exibirClientes() {
		for (Object a : listaCliente) {
			System.out.println(a.toString());
		}
	}

	public boolean validaN(String txt) {
		return txt.matches("^[0-9]*$");
	}

	public boolean validaTexto(String texto) {
		return texto.matches("[a-z A-Z]+");

	}

}
