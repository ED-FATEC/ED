package Controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
public class Ordena��o {
	
	public void sort(int opt2) throws FileNotFoundException, IOException {
		if(opt2 == 1) {
			hash();
		}
		else if(opt2 == 2) {
			hash2();
		}
		else if(opt2 == 3) {
			
		}
		else if(opt2 == 4) {
			
		}
		else if(opt2 == 5) {
			
		}
		else {
			throw new IOException("Fun��o n�o existente");
		}
	}
	
	public void hash() throws IOException, FileNotFoundException {
		HashMap<String, Integer> citymaps = new HashMap<String, Integer>();
		File file = new File("C:\\TEMP","cidades.txt");
		if(verificaDir() == true) {
			FileInputStream arq = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(leitor);
			String[] fields = null;
			String linha = "";
			while ((linha = buffer.readLine()) != null) {
				fields = linha.split(";");
				System.out.println(fields.length);
			}
			for(int i = 0;i < fields.length;i++) {
				citymaps.put(fields[i], i);
			}
			Map<String, Integer> mapaOrdenado = new TreeMap<String, Integer>(citymaps);
			mapaOrdenado.keySet().forEach(System.out::println);
			buffer.close();
			leitor.close();
			arq.close();
		}
		else {
			throw new IOException("A tabela est� vazia");
		}
	}
	
	public void hash2() throws IOException, FileNotFoundException {
		Hashtable<String, LinkedList<String>> citymaps = new Hashtable<String, LinkedList<String>>();
		File file = new File("C:\\TEMP","cidades.txt");
		if(verificaDir() == true) {
			FileInputStream arq = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(leitor);
			String[] campos = null;
			String chaves = "";
			String linha = "";
			while ((linha = buffer.readLine()) != null) {
				campos = linha.split(";");
			}
			for(int x = 0; x < campos.length; x++) {
				LinkedList<String> lista = new LinkedList<String>();
				chaves = campos[x].substring(0,1);
				for(int y = 0;y < campos.length; y++) {
					if(chaves.equals((campos[y].substring(0,1)))) {
						lista.add(campos[y]);
					}
				}
				citymaps.put(campos[x].substring(0,1), lista);
			}
			citymaps.forEach((k, v) -> System.out.println("Chave : " + k + ", Valor : " + v));
			arq.close();
			leitor.close();
			buffer.close();
		}
		else {
			throw new IOException("A tabela est� vazia");
		}
	}
	private void gerarArquivo() throws IOException{
		File file = new File("C:\\TEMP", "cidades.txt");//Busca e armazena o arquivo 'cidades.txt'
		//Cria o arquivo
		file.createNewFile();
		//Depois de criado, o codigo abaixo escreve a estrutura padr�o da tabela
		//Ap�s essas opera��es os escritores de arquivo e o buffer s�o fechados
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter print = new PrintWriter(buffer);
		print.write("S�o Paulo;Guarulhos;Campinas;S�o bernardo do Campo;"
				+ "S�o Jos� dos Campos;Santo Andr�;Ribeir�o Preto;Osasco;Sorocaba;Mau�;"
				+ "S�o Jos� do Rio Preto;Mogi das Cruzes;Santos;Diadema;"
				+ "Jundia�;Piracicaba;Carapicu�ba;Bauru;Itaquaquecetuba;S�o Vicente;Franca;"
				+ "Praia Grande;Guaruj�;Taubat�;Limeira;Suzano;"
				+ "Tabo�o da Serra;Sumar�;Barueri;Embu das Artes;S�o Carlos;Indaiatuba;"
				+ "Cotia;Americana;Mar�lia;Itapevi;Araraquara;Jacare�;Hortol�ndia;Presidente Prudente;");
		print.flush();
		print.close();
		buffer.close();
		writer.close();
	}
	//Caso o diret�rio n�o exista, essa fun��o cria ele
	private void gerarDiret�rio() throws IOException{
		File dir = new File("C:\\TEMP");
		dir.mkdir();
	}
	//Verifica a existencia do arquivo 'entrada.txt' e o diret�rio em que ele fica
	private boolean verificaDir() throws IOException {
		File dir = new File("C:\\TEMP");//Busca e armazena o diretorio 'TEMP'
		File file = new File("C:\\TEMP", "cidades.txt");//Busca e armazena o arquivo 'entrada.txt'
		boolean existe = false;//Caso o diret�rio e o arquivo exista essa variavel fica true
		if(dir.exists() && dir.isDirectory()) {
			if(file.exists() && file.isFile()) {
				existe = true;
			}
			else {
				System.out.println("O arquivo 'cidades.txt' n�o existe, criando o arquivo...");
				gerarArquivo();
			}
		}
		else {
			System.out.println("O diret�rio n�o existe, criando o diret�rio e arquivo...");
			gerarDiret�rio();
			gerarArquivo();	
		}
		return existe;
	}
}
