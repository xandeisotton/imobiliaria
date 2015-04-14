package br.com.uniciss.imobiliaria.sistema.executavel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.imobiliaria.sistema.LerBanco;
import br.com.uniciss.imobiliaria.sistema.Usuario;

public class Menu {
		
	private Scanner s;
	
	ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	Map<String, Usuario> mapaUsuario = new HashMap<String, Usuario>();
	
	Usuario u = new Usuario();
	LerBanco ib = new LerBanco();
	
	public void menuAdmin(){
		
	}
	
	public void menuCorretor(){
		
	}
	
	public void menuSecretario(){
		int opc;
		System.out.println("Secretario");
		
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Cadastrar imóvel");
		System.out.println("3 - Agendar visita");
		System.out.println("4 - Listar visitas");

		s = new Scanner(System.in);
		opc = s.nextInt();
		switch(opc){
		case 1:
			
			break;
		case 2:
			

		default:
			System.out.println("Opção inválida.");
		}
	}
	
	public void Login() throws IOException{
		//Faz a chamada do metodo leituraUsuario
		ib.leituraUsuario(mapaUsuario);
		try{
			BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));    

			System.out.println("Informe o Login:");  
			String usuario = entrada.readLine();  

			System.out.println("Informe a senha:");  
			String senha = entrada.readLine();  

			
			if ((mapaUsuario.containsKey(usuario)) && (mapaUsuario.get(usuario).getSenha().equals(senha))){
				
				if ((mapaUsuario.containsKey(usuario)) && (mapaUsuario.get(usuario).getTipo().equals("0"))){
					menuAdmin();

				}else if ((mapaUsuario.containsKey(usuario)) && (mapaUsuario.get(usuario).getTipo().equals("1"))){
					menuCorretor();

				}else if ((mapaUsuario.containsKey(usuario)) && (mapaUsuario.get(usuario).getTipo().equals("2"))){
					menuSecretario();
				}
			}else{
				
				System.out.println("Usuario e/ou senha invalido(s)!");
				System.out.println("");
				Login();
			}

		}catch(InputMismatchException e ){
			
			s.nextLine();
			System.out.println("Você informou algum caracter inválido(s)! ");

		} catch(NullPointerException b){
			
			System.out.println("Erro!");
		}
	}

}
