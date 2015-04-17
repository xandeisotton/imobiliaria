package br.com.uniciss.imobiliaria.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Imovel {

	public static List<Cliente> clientes = new ArrayList<Cliente>();
	public static List<Pessoa> pessoas = new ArrayList<Pessoa>();
	public static List<Imovel> listImovel = new ArrayList<Imovel>();

	int cod;
	private String endereco;
	private String tamanhoImovel;
	private String numeroDeComodos;
	private int valorImovel;
	private String tipo;
	private String status;


	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTamanhoImovel() {
		return tamanhoImovel;
	}

	public void setTamanhoImovel(String tamanhoImovel) {
		this.tamanhoImovel = tamanhoImovel;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNumeroDeComodos() {
		return numeroDeComodos;
	}

	public void setNumeroDeComodos(String numeroDeComodos) {
		this.numeroDeComodos = numeroDeComodos;
	}

	public int getValorImovel() {
		return valorImovel;
	}

	public void setValorImovel(int valorImovel) {
		this.valorImovel = valorImovel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isAtivo() {
		return true;
	}

	public String toString() {
		return "Imovel," + cod + "," + getEndereco() + "," + getTamanhoImovel()
				+ "," + getNumeroDeComodos() + "," + getValorImovel() + ","
				+ getTipo() + "," + getStatus();
	}

	public void incluirImovel() {
		// Procedimento para cadastrar Funcionario;

		@SuppressWarnings("resource")
		Scanner insere = new Scanner(System.in);

		System.out.println("Insira o endereço:(EX:Rua tal, 49)");
		setEndereco(insere.next());

		System.out.println("Insira a AREA do Imovel:(EX:M²)");
		setTamanhoImovel(insere.next());

		System.out.println("Insira o numero de comodos do Imovel:(EX:4)");
		setNumeroDeComodos(insere.next());

		System.out.println("Insira o valor do Imovel:(EX:10000)");
		setValorImovel(insere.nextInt());

		System.out.println("Insira o tipo de Imovel:(EX:casa,apartamento..)");
		setTipo(insere.next());
		
		System.out.println("Insira o status do Imovel:(EX:vender,alugar)");
		setStatus(insere.next());

		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("  Sucesso! Seu cadastro esta completo.");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		
		LerBanco ler = new LerBanco();
		Map<Integer, Imovel> listaImovel = new HashMap<Integer, Imovel>();
		List<Imovel>lImovel = new ArrayList<Imovel>();
		
		ler.leituraImovel(listaImovel, lImovel);
		setCod(lImovel.size());
		
		GravaTxt gravaArq = new GravaTxt();
		
		gravaArq.grava("Imoveis.txt", toString());

	}

	public void alterarImovel() {
		// Estou codificando //fabio\\
	}
	public void retirarImovel(){
		// Estou codificando //fabio\\
	}



}
