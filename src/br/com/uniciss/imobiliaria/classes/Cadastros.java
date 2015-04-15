package br.com.uniciss.imobiliaria.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Cadastros extends Usuario {
	public static Map<String, String> cadastrosMap = new HashMap<String, String>();

	@SuppressWarnings("rawtypes")
	public static List cadastrosList = new ArrayList();

}
