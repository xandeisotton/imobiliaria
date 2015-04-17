package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	public void leituraImovel(Map<Integer, Imovel> listaImovel, List<Imovel>
	lImovel) {
		try {

			FileReader arq = new FileReader("Imoveis.txt");
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();

			while (linha != null) {

				String palavras[] = linha.split(",");
				// Instanciacao de um novo usuario
				Imovel p = new Imovel();

				// Passa a ordem de cada campo
				p.setEndereco(palavras[1]);
				p.setTamanhoImovel(palavras[2]);
				p.setNumeroDeComodos(palavras[3]);
				p.setValorImovel(Integer.parseInt(palavras[4]));
				p.setTipo(palavras[5]);
				p.setStatus(palavras[6]);

				listaImovel.put(p.getCod(), p);
				lImovel.add(p);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}

	public void leituraFuncionario() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("Funcionario.txt")));

		String linha = br.readLine();

		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
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

				listaVisitas.put(a.getData() + "" + a.getHorario(), a);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}
	}

}
