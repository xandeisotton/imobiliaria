package br.com.uniciss.imobiliaria.sistema;

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
}
