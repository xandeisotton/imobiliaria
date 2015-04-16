package br.com.uniciss.imobiliaria.sistema.executavel;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import br.com.uniciss.imobiliaria.classes.LerBanco;
import br.com.uniciss.imobiliaria.classes.Usuario;

public class Menu {
		
	private Scanner s;
	
	ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
	Map<String, Usuario> mapaUsuario = new HashMap<String, Usuario>();
	
	Usuario u = new Usuario();
	LerBanco ib = new LerBanco();
	
	public void menuAdmin()throws IOException{
		int opc;
		System.out.println("       ADMINISTRADOR");
		System.out.println("------------------------");
		System.out.println("1 - Cadastrar Secretária");
		System.out.println("2 - Cadastrar Corretor");
		System.out.println("3- Sair");
		System.out.println("------------------------");
		s = new Scanner(System.in);
		opc = s.nextInt();
		switch(opc){
		case 1:		
			
			break;
		case 2:
			
			break;
		
		case 3:		
			System.out.println("Deseja voltar ao menu principal?");
			System.out.println("1-Sim");
			System.out.println("2-Não");
			opc = s.nextInt();
			switch(opc){
			case 1:
				Menu m = new Menu();
				m.Login();
					
				break;
			case 2:
				System.exit(0); 
			break;
			
			
			default:
			System.out.println("Opção inválida.");
			}
		}
	}
	
	public void menuCorretor() throws IOException{
			int opc;
			System.out.println("           CORRETOR");
			System.out.println("----------------------------");
			System.out.println("1 - Cadastrar Imóvel Vendido");
			System.out.println("2 - Cadastrar Imóvel Alugado");
			System.out.println("3 - Listar Visitas Agendadas");
			System.out.println("4- Sair");
			System.out.println("----------------------------");
			s = new Scanner(System.in);
			opc = s.nextInt();
			switch(opc){
			case 1:		
				
				break;
			case 2:
				
				break;
			
			case 3:		
				
				break;
			case 4:
				System.out.println("Deseja voltar ao menu principal?");
				System.out.println("1-Sim");
				System.out.println("2-Não");
				opc = s.nextInt();
				switch(opc){
				case 1:
					Menu m = new Menu();
					m.Login();
						
					break;
				case 2:
					System.exit(0); 
				break;
				
				
				default:
				System.out.println("Opção inválida.");
					}
				}
		}
		
	
	public void menuSecretario() throws IOException{
		int opc;
		System.out.println("      Secretário");
		System.out.println("----------------------");
		System.out.println("1 - Cadastrar cliente");
		System.out.println("2 - Cadastrar imóvel");
		System.out.println("3 - Agendar visita");
		System.out.println("4 - Listar visitas");
		System.out.println("5 - Listar Clientes");
		System.out.println("6 - Listar visitas");
		System.out.println("7 - Sair");
		System.out.println("---------------------- ");
		s = new Scanner(System.in);
		opc = s.nextInt();
		switch(opc){
		case 1:		
			
			break;
		case 2:
			
			break;
		case 3:		
			
			break;
		case 4:		
			
			break;
		case 5:		
			
			break;
		case 6:		
	
			break;
		case 7:
			System.out.println("Deseja voltar ao menu principal?");
			System.out.println("1-Sim");
			System.out.println("2-Não");
			opc = s.nextInt();
			switch(opc){
			case 1:
				Menu m = new Menu();
				m.Login();
					
				break;
			case 2:
				System.exit(0); 
			break;
			
			
			default:
			System.out.println("Opção inválida.");
				}
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
