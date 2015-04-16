package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import br.com.uniciss.imobiliaria.classes.ValidaCpf;
import br.com.uniciss.imobiliaria.sistema.executavel.Menu;

public class Cliente extends Pessoa {
	List<Object> listaPacientes = new ArrayList<Object>();
	public static Map<String, Cliente> mapaDeClientes = new HashMap<String, Cliente>();
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

	@SuppressWarnings("resource")
	public void CadastroCliente() throws Exception {
		cadastro = new Scanner(System.in);

		System.out.println("Informe o nome do cliente!");
		setNome(cadastro.nextLine());

		System.out.println("Informe o endereco do cliente!");
		setEndereco(cadastro.nextLine());

		System.out.println("Informe o número do CPF do cliente!");
		setCpf(cadastro.nextLine());
		//        Validação DE CPF:
		/*if (ValidaCpf.isCpf(getCpf())==false){	
			System.out.println("CPF Invalido");
		while (ValidaCpf.isCpf(getCpf())== false){
			System.out.println("Informe o número do CPF do cliente!");
			setCpf(cadastro.nextLine());			
		}
		 }
		*/

		System.out.println("Informe o número do telefone do ciente!");
		setTelefone(cadastro.nextLine());

		System.out.println("Informe o banco em que o cliente tem conta!");
		setBanco(cadastro.nextLine());

		System.out.println("Informe o numero da conta do cliente!");
		setNumConta(cadastro.nextLine());

		System.out.println("Informe o codigo do cliente!");
		setCodigo(cadastro.nextLine());

		//TESTE
		//Cliente c = new Cliente(nome, cpf, endereco, telefone);
		//ListaCliente.add(c);
		//mapaDeClientes.put(c.getNome(), c);
		
		GravaTxt g = new GravaTxt();
		g.grava("Cliente.txt", toString());

		Scanner entrada = new Scanner(System.in);
		System.out.println("O que deseja fazer?\n 1-Cadastrar novamente. \n 2-Voltar ao Menu.");
		int cont = entrada.nextInt();
		do {
			switch (cont) {

			case 1:
				CadastroCliente();
				break;

			case 2:
				Menu m = new Menu();
				m.Login();
				break;
			default:
				System.out.println("Você informou uma opção inválida!");
			}
		} while ((cont != 1) || (cont != 2));
	}

	public void listaCliente() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("Cliente.txt")));
		String linha = br.readLine();

		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		Scanner entrada = new Scanner(System.in);
		System.out.println("O que deseja fazer?\n 1-Voltar ao Menu. \n 2-Listar Novamente.");
		int cont = entrada.nextInt();
		do{
		switch (cont) {

		case 1:
			Menu m = new Menu();
			m.Login();
			break;

		case 2:
			listaCliente();
			break;
		default:
			System.out.println("você informou uma opcao inválida!");
		}
		}while((cont != 1)||(cont != 2));
		entrada.close();
		br.close();
	}
	//esse é onde eu comecei com meu arquivo de pesquisa
	//@SuppressWarnings("unused")
	public void pesquisaCliente() throws Exception {
		Scanner entrada = new Scanner(System.in);
		boolean achou = false;
		String linha = "";
		String nomeArquivo = "Cliente.txt";
		System.out.println("Informe o código do cliente");
		String codigo = entrada.next();
		BufferedReader in = new BufferedReader(new FileReader("Cliente.txt"));
		try{
			while((linha = in.readLine())!=null){
				if(linha.contains(codigo)){
					System.out.println(linha);
					achou = true;
				}
			}
			if(!achou){
				System.out.println("Arquivo não existente!\n");
				
			}
		}catch (NullPointerException erro) {
		}
		System.out.println("Qual ação deseja realizar?");
		System.out.println("1 - Pesquisar");
		System.out.println("2 - Retornar ao menu principal");
		int cont = entrada.nextInt();
		switch(cont){
		case 1:
			pesquisaCliente();
			break;
			
		case 2:
			Menu m = new Menu();
			m.menuSecretario();
		}
		in.close();
		entrada.close();
	}
	
/*	ISSO É UM TESTE, FAVOR NAO APAGAR 
 * 
 * public static void preencheMapa() throws IOException {
		Iterator<Cliente> i = listaCliente().iterator();

		while (i.hasNext()) {
			Cliente c = i.next();
			mapaDeClientes.put(c.getNome(), c);
		}
	}
	public static Cliente buscaPorNome(String nomeBusca) throws IOException {
		preencheMapa();
		Cliente c = mapaDeClientes.get(nomeBusca);
		try {
			String nome = c.getNome();
			String cpf = c.getCpf();
			String endereco = c.getEndereco();
			String telefone = c.getTelefone();
		

			c = new Cliente(nome, cpf, endereco, telefone);
			return c;
			
		} catch (NullPointerException n) {
			n.getMessage();
			return c;
		}
	}*/


}
