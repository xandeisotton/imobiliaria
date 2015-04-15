package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
				p.setEndereco(palavras[1]);
				p.setTamanhoImovel(palavras[2]);
				p.setNumeroDeComodos(palavras[3]);
				p.setValorImovel(Integer.parseInt(palavras[4]));
				p.setTipo(palavras[5]);
				p.setStatus(palavras[6]);

				listaImovel.put(p.getCod(), p);
				linha = lerArq.readLine();
			}
			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					e.getMessage());
		}

	}

}
