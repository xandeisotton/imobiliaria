package br.com.uniciss.imobiliaria.metodos;

import java.util.Scanner;



public class MetodosCorretor {
	Scanner s = new Scanner(System.in);
//	List<Object> listaClientes = new ArrayList<Object>();
	//public static Map<String, Cliente> mapaDeClientes = new HashMap<String, Cliente>();

	public void vender(){
		
			System.out.println("Informe o código do imóvel:");
			String codImovel = s.next();
			System.out.println("Informe o código do Cliente");
			String codCliente = s.next();
	//falta gravar em um txt as vendas
	}
	public void alugar(){
		System.out.println("Informe o código do imóvel:");
		String codImovel = s.next();
		System.out.println("Informe o código do Cliente");
		String codCliente = s.next();
	//falta gravar em um txt os alugados
	}
}
	