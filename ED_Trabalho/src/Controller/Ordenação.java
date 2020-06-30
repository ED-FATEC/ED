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
import java.util.function.BiConsumer;
public class Ordenação {
	
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
			throw new IOException("Função não existente");
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
			throw new IOException("A tabela está vazia");
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
			throw new IOException("A tabela está vazia");
		}
	}
	private void gerarArquivo() throws IOException{
		File file = new File("C:\\TEMP", "cidades.txt");//Busca e armazena o arquivo 'cidades.txt'
		//Cria o arquivo
		file.createNewFile();
		//Depois de criado, o codigo abaixo escreve a estrutura padrão da tabela
		//Após essas operações os escritores de arquivo e o buffer são fechados
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter print = new PrintWriter(buffer);
		print.write("Colheita:\n(Cultura|Variedade_ou_Cultivar|Quadra|Parcela|Talhão|Lote|Data_de_embalamento|Unidade_Comercializada|Observações)\nFim_Colheita:\n\r" + 
		"Comprador:\n(Nome|Razao_social|CNPJ|Inscrição_Estadual|Endereço|Bairro|CEP|Estado|Munícipio|Telefone|Celular|Email)\nFim_Comprador:\n\r"+
		"Empresa:\n(Telefone|Celular|Email|Tipo_de_usuario|Razão_Social)\nFim_Empresa:\n\r" +
		"Insumos:\n(Quadra|Parcela|Talhão|Data de aplicação|Nome comercial do produto|Periodo de carência em dias|Dose)\nFim_Insumos:\n\r" +
		"Produtos:\n(Nome|Tipo|Colheita)\nFim_Produtos:\n\r" +
		"Produtor:\n(Telefone|Celular|Email|Tipo_de_usuario|Nome)\nFim_Produtor:\n\r" +
		"Propriedade:\n(Nome|Endereço|Bairro|Munícipio|Estado|CEP|Altitude|Longitude|Latitude|CCIR|CNPJ)\nFim_Propriedade:\n\r" +
		"Rotulos:\n(Produto|Variedade|Classificação|Nome_do_produtor|CNPJ|Nome_da_propriedade|Endereço|Baírro|Município|Estado|País_de_Origem|CEP|Altitude|Latitude|Longitude|Peso_Líquido|Lote|Data_de_Embalamento|Codigo_de_barras)\nFim_Rótulos:\n\r" +
		"Venda:\n(Data|Nota_Físcal|Produto|Lote|Quantidade)\nFim_Venda:\n");
		print.flush();
		print.close();
		buffer.close();
		writer.close();
	}
	//Caso o diretório não exista, essa função cria ele
	private void gerarDiretório() throws IOException{
		File dir = new File("C:\\TEMP");
		dir.mkdir();
	}
	//Verifica a existencia do arquivo 'entrada.txt' e o diretório em que ele fica
	private boolean verificaDir() throws IOException {
		File dir = new File("C:\\TEMP");//Busca e armazena o diretorio 'TEMP'
		File file = new File("C:\\TEMP", "cidades.txt");//Busca e armazena o arquivo 'entrada.txt'
		boolean existe = false;//Caso o diretório e o arquivo exista essa variavel fica true
		if(dir.exists() && dir.isDirectory()) {
			if(file.exists() && file.isFile()) {
				existe = true;
			}
			else {
				System.out.println("O arquivo 'cidades.txt' não existe, criando o arquivo...");
				gerarArquivo();
			}
		}
		else {
			System.out.println("O diretório não existe, criando o diretório e arquivo...");
			gerarDiretório();
			gerarArquivo();	
		}
		return existe;
	}
}
