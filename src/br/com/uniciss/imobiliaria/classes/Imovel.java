package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

		GravaTxt gravaArq = new GravaTxt();

		gravaArq.grava("Imoveis.txt", toString());

	}

	public void alterarImovel() {
		// não tive tempo
	}

	// metodo pra deletar linha inteira 
	
	//USAR ISSO NO MENU PRA CHAMAR 
	
//	Imovel ent= new Imovel();
	
//	@SuppressWarnings("resource")
//	Scanner insere = new  Scanner(System.in);
//	System.out.println("Informe o nome do Funcionário:");
//	ent.setCod(insere.next());
//	ent.delete("PASSAARQUIVO.txt",ent.toString());
	
	
	public void delete(String arquivo, String removerLinhaPara) {
		
	    try {
	      File lerArquivo = new File(arquivo);
	      
	      if (!lerArquivo.isFile()) {
	        System.out.println("Esse arquivo não pode ser lido");
	        return;
	      }
	      
	      BufferedReader br = new BufferedReader(new FileReader(arquivo));
	      
	      List<String> linha = new ArrayList<String>();
	      String aux = br.readLine();
	      
	      while (aux != null) {
	        if (!aux.trim().equals(removerLinhaPara)) {
	        	if(linha.contains(removerLinhaPara)){
	            	linha.add(aux);
	            	linha.add("\r\n");
	        	}
	        }
	        aux = br.readLine();
	      }
	      
	      FileWriter fw = new FileWriter(lerArquivo);
	      BufferedWriter bw = new BufferedWriter(fw);
	      for(String s : linha){
	    	  bw.write(s);
	    	  
	      }
	      bw.close();
	      br.close();
	      
	    }
	    catch (FileNotFoundException ex) {
	      ex.printStackTrace();
	    }
	    catch (IOException ex) {
	      System.out.println("Errooo aaaqui por causa que");
	    }
	}
}
