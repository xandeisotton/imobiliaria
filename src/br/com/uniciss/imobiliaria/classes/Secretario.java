package br.com.uniciss.imobiliaria.classes;

import java.util.Scanner;

public abstract class Secretario extends Funcionario{

private Scanner s;
	
	public void cadastrarSecretario(){
		s = new Scanner(System.in);
		System.out.println("Informe qual ser� o Login:");
		setLogin(s.nextLine());
		System.out.println("Informe qual ser� a Senha:");
		setSenha(s.nextLine());
	//tipo, c�d
	}
}



