package br.com.uniciss.imobiliaria.classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GravaTxt {
	// É utilizada para gravar no arquivo .txt
	
	public void grava(String aonde,String oque){
		File ficheiro = new File(aonde); 
		try { 
			BufferedWriter bw = new BufferedWriter(new FileWriter(ficheiro, true));  
			if(ficheiro.canWrite()){ 
				bw.write(oque); 
				bw.newLine(); 
				bw.flush(); 
				bw.close(); 
			} 
		}catch (IOException e){

		} 
	}
}
