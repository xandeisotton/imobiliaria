package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	public void leituraFuncionario(List<Funcionario> listaFuncionarios)
			throws IOException {
		try {

			FileReader arq = new FileReader("Funcionario.txt");
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

				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}

	public void leituraClientes(List<Cliente> listaCliente) throws IOException {
		try {

			FileReader arq = new FileReader("Cliente.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");
				// Instanciacao de um novo usuario
				Cliente p = new Cliente();

				// Passa a ordem de cada campo
				p.setCodigo(Integer.parseInt(palavras[1]));
				p.setNome(palavras[2]);
				p.setEndereco(palavras[3]);
				p.setCpf(palavras[4]);
				p.setTelefone(palavras[5]);
				listaCliente.add(p);
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

	public void leituraVisitas(Map<String, Agendamento> listaVisitas) {
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
				a.setObservações(palavras[4]);
				a.setCorretor(Integer.parseInt(palavras[5]));
				a.setImovel(Integer.parseInt(palavras[6]));

				// listaVisitas.put(contador++, a);

				Set<String> lista = listaVisitas.keySet();
				for (String key : lista) {
					Agendamento agendamento = listaVisitas.get(key);
					agendamento.getCorretor();

				}
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
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
				p.setCod(Integer.parseInt(palavras[1]));
				p.setNome(palavras[2]);
				p.setEndereco(palavras[3]);
				p.setCpf(palavras[4]);
				p.setTelefone(palavras[5]);

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
