package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LerBanco {
	public void leituraUsuario(Map<String, Usuario> listaUsuario) {
		try {

			FileReader arq = new FileReader("Usuarios.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");
				// Instanciacao de um novo usuario
				Usuario p = new Usuario();

				// Passa a ordem de cada campo
				p.setLogin(palavras[1]);
				p.setSenha(palavras[2]);
				p.setTipo(palavras[3]);

				listaUsuario.put(p.getLogin(), p);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}
	
	
	public void leituraFuncionario(List<Funcionario>listaFuncionarios) throws IOException {
		try {

			FileReader arq = new FileReader("Corretor.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");
				// Instanciacao de um novo usuario
				Corretor p = new Corretor();

				// Passa a ordem de cada campo
				p.setCodigo(Integer.parseInt(palavras[1]));
				p.setNome(palavras[2]);
				p.setEndereco(palavras[3]);
				p.setCpf(palavras[4]);
				p.setTelefone(palavras[5]);
				listaFuncionarios.add(p);

				// listaCorretor.put(p.getCod(), p);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}

	

	public void leituraImovel(Map<Integer, Imovel> listaImovel) {
		try {

			FileReader arq = new FileReader("Imoveis.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");
				// Instanciacao de um novo usuario
				Imovel p = new Imovel();

				// Passa a ordem de cada campo
				p.setCod(Integer.parseInt(palavras[1]));
				p.setEndereco(palavras[2]);
				p.setTamanhoImovel(palavras[3]);
				p.setNumeroDeComodos(palavras[4]);
				p.setValorImovel(Integer.parseInt(palavras[5]));
				p.setTipo(palavras[6]);
				p.setStatus(palavras[7]);

				listaImovel.put(p.getCod(), p);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}

	public void leituraVisitas(ArrayList<Agendamento> listaVisitas) {
		try {
			FileReader arq = new FileReader("Visitas.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");

				Agendamento a = new Agendamento();

				a.setNome(palavras[1]);
				a.setData(palavras[2]);
				a.setHorario(palavras[3]);
				a.setCorretor(Integer.parseInt(palavras[4]));
				a.setImovel(Integer.parseInt(palavras[5]));
				a.setObservações(palavras[6]);
				
				listaVisitas.add(a);
				
				linha = lerArq.readLine();
			}
			arq.close();
		}catch (IOException e ){
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}
	
	
	
	public void leituraSecretario(Map<Integer, Secretario> listaSecretario) {
		try {

			FileReader arq = new FileReader("Funcionario.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");
				// Instanciacao de um novo usuario
				Secretario p = new Secretario();

				// Passa a ordem de cada campo
				p.setNome(palavras[1]);
				p.setEndereco(palavras[2]);
				p.setCpf(palavras[3]);
				p.setTelefone(palavras[4]);
				
				listaSecretario.put(p.getCod(), p);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
	}
	
	
	public void leituraCorretor(Map<Integer, Corretor> listaCorretor) {
		try {

			FileReader arq = new FileReader("Funcionario.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");
				// Instanciacao de um novo usuario
				Corretor p = new Corretor();

				// Passa a ordem de cada campo
				p.setCod(Integer.parseInt(palavras[1]));
				p.setNome(palavras[2]);
				p.setEndereco(palavras[3]);
				p.setCpf(palavras[4]);
				p.setTelefone(palavras[5]);
				
				listaCorretor.put(p.getCod(), p);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}
}
