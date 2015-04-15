package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



	public abstract class Funcionario1 extends Pessoa {
		protected Login login;
		protected String tipo;
		
		public Login getLogin(){
			return this.login;
		}
		
		public String getTipo(){
			return this.tipo;
		}
		
		public String loginToString(){
			return this.login.getLogin() + " " + this.login.getSenha();
		}
		
		@Override
		public String toString() {
			return "Funcionáririo [tipo=" + this.tipo + ", login="
					+ this.login.getLogin() + ", senha=" + this.login.getSenha()
					+ ", nome=" + nome + ", endereco=" + endereco + ", cpf=" + cpf + ", telefone=" + telefone + "]";
		}
		
	
	Scanner s = new Scanner(System.in);

	// Lista de funcionarios
	List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

	
	// Mapa de funcionarios utilizando login como chave
	public static Map<Login, Funcionario> mapaDeLogins = new HashMap<Login, Funcionario>();

	// Metodo para cadastrar funcionarios
	public void cadastrarFuncionario(int opcao) {
		System.out.println("Nome:");
		String nome = s.next();
		System.out.println("Cpf:");
		String cpf = s.next();
		System.out.println("Endereço:");
		String endereco = s.next();
		System.out.println("Telefone:");
		String telefone = s.next();
		System.out.println("Data de nascimento:");
		String dtNasc = s.next();
		System.out.println("Senha:");
		String senha = s.next();

		File arquivo = new File("Funcionarios.txt");

		// Teste para verificar se o funcionario é dentista ou secretaria
		if (opcao == 1 || opcao == 2) {
			Funcionario f;
			if (opcao == 1) {
				String tipo = "Corretor";
				f = new Corretor();
			} else {
				String tipo = "Secretario";
				f = new Secretário();
			}

			listaFuncionarios.add(f);

			mapaDeLogins.put(f.getLogin(), f);

			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo,
						true));
				if (arquivo.canWrite()) {
					bw.write(f.toString());
					bw.newLine();
					bw.flush();
					bw.close();
					System.out
							.println("\nFuncionario cadastrado com sucesso!\n");
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
