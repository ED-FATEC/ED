package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> citymaps = new HashMap<String, Integer>();
		File arq = new File("C:\\TEMP\\cidades.txt");
		BufferedReader br;
		String[] fields = null;
		try {
			br = new BufferedReader(new FileReader(arq));
			String linha = br.readLine();
			while (linha != null) {

				 fields = linha.split(";");
				 System.out.println(fields.length);
				linha = br.readLine();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0;i < fields.length;i++) {
			
			citymaps.put(fields[i], i);
		}

		long tempInicial = System.currentTimeMillis();
		Map<String, Integer> mapaOrdenado = new TreeMap<String, Integer>(citymaps);
		mapaOrdenado.keySet().forEach(System.out::println);
		Long tempFinal = System.currentTimeMillis();
		long dif = (tempFinal - tempInicial);
		System.out.println(String.format(" %02d segundos e  %02d milisegundos",dif/60,dif%60));

	}

}
