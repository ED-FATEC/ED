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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
public class Ordenação {
	//Metodo que vai ler o codigo alocado pelo usuario, e vai o redirecionar para a função solicitada
	public void sort(int opt2) throws FileNotFoundException, IOException {
		ArrayList<Object> lista = new ArrayList<Object>();
		lista.addAll(gerarLista());
		if(opt2 == 1) {
			hash();
		}
		else if(opt2 == 2) {
			hash2();
		}
		else if(opt2 == 3) {
			selectionSort(lista);
		}
		else if(opt2 == 4) {
			bubbleSort(lista);
		}
		else {
			throw new IOException("Função não existente");
		}
	}
	//Metodo para ordenação com a logica de tabela hash
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
	//Metodo para ordenação com a logica de tabela hash e com a alocação de listas ligadas aos valores
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
	//Metodo de ordenação selectionSort
	public void selectionSort(ArrayList<Object> lista) throws IOException {
		int opt2 = 1;
		File file = new File("C:\\TEMP", "selectionSort.txt");
		while(opt2 < 10) {
			String tabela[] = selecionaTabela(opt2);
			int inicio = lista.indexOf(tabela[1]);
			int fim = lista.indexOf(tabela[0]);
			Object sub_lista[] = lista.subList(inicio + 1, fim).toArray();
			lista.subList(inicio + 1, fim).clear();
		  for (int x = 0; x < sub_lista.length; x++) {
		  int menor = x;
			    for (int y = menor + 1; y < sub_lista.length; y++) {
			       if (sub_lista[y].toString().trim().compareTo(sub_lista[menor].toString().trim()) < 0 && sub_lista[y].toString().length() < sub_lista[menor].toString().length()) {
			          menor = y;
			       }
			    }
	      String t = sub_lista[x].toString();
	      sub_lista[x] = sub_lista[menor];
	      sub_lista[menor] = t;
		    lista.add(inicio + 1,sub_lista[x]);
		  }
		  opt2++;
		}
		FileWriter writer = new FileWriter(file,false);
		BufferedWriter bufferW = new BufferedWriter(writer);
		PrintWriter print = new PrintWriter(bufferW);
		for(int x = 0; x <= lista.size() - 1; x++) {
			print.println(String.valueOf(lista.get(x)));
		}
		print.flush();
		print.close();
		bufferW.close();
		writer.close();
	}
	 
	 private ArrayList<Object> gerarLista() throws IOException {
		//Vai verificar a existencia do arquivo 'entrada.txt' e o diretório em que ele fica
		if(verificaDir() == true) {
			File file = new File("C:\\TEMP", "entrada.txt");//Busca e armazena o arquivo 'entrada.txt'
			ArrayList<Object> lista = new ArrayList<Object>();//Vai armazenar todo o conteudo do arquivo 'entrada.txt'
			String linha = "";//Vai receber o conteudo do arquivo 'entrada.txt' linha por linha
			//Abaixo o arquivo vai ser lido e alocado linha por linha na variavel linha
			//Depois a mesma variavel linha vai ser alocada na lista
			//E por fim os leitores e o buffer vai ser fechados
			FileInputStream arq = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(leitor);
			while ((linha = buffer.readLine()) != null) {
				lista.add(linha);
			}
			buffer.close();
			leitor.close();
			arq.close();
			//Ira procurar na lista e vai criar um vetor contendo somente os registros da tabela escolhida pelo usuario
			return lista;
		}
		else {
				throw new IOException("O arquivo entrada.txt não existe");
		}
	 }
	 
	 //Ira sortear os dados do arquivo, usando o metodo bubbleSort
	 private void bubbleSort(ArrayList<Object> lista) throws IOException{
        if(verificaDir() == true) {
			String aux;
	        int opt2 = 1;
	        File file = new File("C:\\TEMP", "bubblesort.txt");
			while(opt2 < 10) {
				String tabela[] = selecionaTabela(opt2);
				int inicio = lista.indexOf(tabela[1]);
				int fim = lista.indexOf(tabela[0]);
				Object sub_lista[] = lista.subList(inicio + 1, fim).toArray();
				lista.subList(inicio + 1, fim).clear();
				for (int x = 0; x < sub_lista.length; x++) {
		             for (int y = x + 1; y < sub_lista.length; y++) {
	            		 if (sub_lista[y].toString().trim().compareToIgnoreCase(sub_lista[x].toString().trim()) > 0 || sub_lista[y].toString().length() > sub_lista[x].toString().length()) {
			                 aux = sub_lista[x].toString();
			                 sub_lista[x] = sub_lista[y];
			                 sub_lista[y] = aux;
		            	 }
		             }
		             lista.add(inicio + 1,sub_lista[x]);
		         }
				opt2++;
			}
			//Depois da lista estar com os novos dados, o arquivo 'entrada.txt' é reescrito com os novos dados
			//Após essas operações os escritores de arquivo e o buffer são fechados
			FileWriter writer = new FileWriter(file,false);
			BufferedWriter bufferW = new BufferedWriter(writer);
			PrintWriter print = new PrintWriter(bufferW);
			for(int x = 0; x <= lista.size() - 1; x++) {
				print.println(String.valueOf(lista.get(x)));
			}
			print.flush();
			print.close();
			bufferW.close();
			writer.close();
        }
        else {
        	throw new IOException("O arquivo entrada.txt não existe");
        }
	}
	//Verifica a existencia dos arquivos 'entrada.txt' e 'cidades.txt' e o diretório em que ele fica
	private void gerarArquivo(boolean existe) throws IOException{
		File file = new File("C:\\TEMP", "cidades.txt");//Busca e armazena o arquivo 'cidades.txt'
		//Cria o arquivo
		file.createNewFile();
		//Depois de criado, o codigo abaixo escreve a estrutura padrão da tabela
		//Após essas operações os escritores de arquivo e o buffer são fechados
		FileWriter writer = new FileWriter(file,existe);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter print = new PrintWriter(buffer);
		print.write("São Paulo;Guarulhos;Campinas;São bernardo do Campo;"
				+ "São José dos Campos;Santo André;Ribeirão Preto;Osasco;Sorocaba;Mauá;"
				+ "São José do Rio Preto;Mogi das Cruzes;Santos;Diadema;"
				+ "Jundiaí;Piracicaba;Carapicuíba;Bauru;Itaquaquecetuba;São Vicente;Franca;"
				+ "Praia Grande;Guarujá;Taubaté;Limeira;Suzano;"
				+ "Taboão da Serra;Sumaré;Barueri;Embu das Artes;São Carlos;Indaiatuba;"
				+ "Cotia;Americana;Marília;Itapevi;Araraquara;Jacareí;Hortolândia;Presidente Prudente;");
		print.flush();
		print.close();
		buffer.close();
		writer.close();
		
		File file2 = new File("C:\\TEMP", "entrada.txt");//Busca e armazena o arquivo 'entrada.txt'
		//Cria o arquivo
		file.createNewFile();
		//Depois de criado, o codigo abaixo escreve a estrutura padrão da tabela
		//Após essas operações os escritores de arquivo e o buffer são fechados
		FileWriter writer2 = new FileWriter(file2,existe);
		BufferedWriter buffer2 = new BufferedWriter(writer2);
		PrintWriter print2 = new PrintWriter(buffer2);
		print2.write("Colheita:\n(Cultura|Variedade_ou_Cultivar|Quadra|Parcela|Talhão|Lote|Data_de_embalamento|Unidade_Comercializada|Observações)\nFim_Colheita:\n\r" + 
		"Comprador:\n(Nome|Razao_social|CNPJ|Inscrição_Estadual|Endereço|Bairro|CEP|Estado|Munícipio|Telefone|Celular|Email)\nFim_Comprador:\n\r"+
		"Empresa:\n(Telefone|Celular|Email|Tipo_de_usuario|Razão_Social)\nFim_Empresa:\n\r" +
		"Insumos:\n(Quadra|Parcela|Talhão|Data de aplicação|Nome comercial do produto|Periodo de carência em dias|Dose)\nFim_Insumos:\n\r" +
		"Produtos:\n(Nome|Tipo|Colheita)\nFim_Produtos:\n\r" +
		"Produtor:\n(Telefone|Celular|Email|Tipo_de_usuario|Nome)\nFim_Produtor:\n\r" +
		"Propriedade:\n(Nome|Endereço|Bairro|Munícipio|Estado|CEP|Altitude|Longitude|Latitude|CCIR|CNPJ)\nFim_Propriedade:\n\r" +
		"Rotulos:\n(Produto|Variedade|Classificação|Nome_do_produtor|CNPJ|Nome_da_propriedade|Endereço|Baírro|Município|Estado|País_de_Origem|CEP|Altitude|Latitude|Longitude|Peso_Líquido|Lote|Data_de_Embalamento|Codigo_de_barras)\nFim_Rótulos:\n\r" +
		"Venda:\n(Data|Nota_Físcal|Produto|Lote|Quantidade)\nFim_Venda:\n");
		print2.flush();
		print2.close();
		buffer2.close();
		writer2.close();
	}
	
	//Caso o diretório não exista, essa função cria ele
	private void gerarDiretório() throws IOException{
		File dir = new File("C:\\TEMP");
		dir.mkdir();
	}
	//Verifica a existencia do arquivo 'entrada.txt' e o diretório em que ele fica
	private boolean verificaDir() throws IOException {
		File dir = new File("C:\\TEMP");//Busca e armazena o diretorio 'TEMP'
		File file = new File("C:\\TEMP", "cidades.txt");//Busca e armazena o arquivo 'cidades.txt'
		boolean existe = false;//Caso o diretório e o arquivo exista essa variavel fica true
		if(dir.exists() && dir.isDirectory()) {
			if(file.exists() && file.isFile()) {
				existe = true;
			}
			else {
				System.out.println("O arquivo 'cidades.txt' não existe, criando o arquivo...");
				gerarArquivo(existe);
			}
		}
		else {
			System.out.println("O diretório não existe, criando o diretório e arquivo...");
			gerarDiretório();
			gerarArquivo(existe);	
		}
		return existe;
	}
	
	//Quando chamada, ela verifica a tabela selecionada pelo usuario e retorna o topo e o fim da area de registros
		private String[] selecionaTabela(int opt2) {
			String tabela[] = new String[2];
			if(opt2 == 1) {
				tabela[0] = "Fim_Colheita:";
				tabela[1] = "(Cultura|Variedade_ou_Cultivar|Quadra|Parcela|Talhão|Lote|Data_de_embalamento|Unidade_Comercializada|Observações)";
			}
			else if(opt2 == 2) {
				tabela[0] = "Fim_Comprador:";
				tabela[1] = "(Nome|Razao_social|CNPJ|Inscrição_Estadual|Endereço|Bairro|CEP|Estado|Munícipio|Telefone|Celular|Email)";
			}
			else if(opt2 == 3) {
				tabela[0] = "Fim_Empresa:";
				tabela[1] = "(Telefone|Celular|Email|Tipo_de_usuario|Razão_Social)";
			}
			else if(opt2 == 4) {
				tabela[0] = "Fim_Insumos:";
				tabela[1] = "(Quadra|Parcela|Talhão|Data de aplicação|Nome comercial do produto|Periodo de carência em dias|Dose)";
			}
			else if(opt2 == 5) {
				tabela[0] = "Fim_Produtos:";
				tabela[1] = "(Nome|Tipo|Colheita)";
			}
			else if(opt2 == 6) {
				tabela[0] = "Fim_Produtor:";
				tabela[1] = "(Telefone|Celular|Email|Tipo_de_usuario|Nome)";
			}
			else if(opt2 == 7) {
				tabela[0] = "Fim_Propriedade:";
				tabela[1] = "(Nome|Endereço|Bairro|Munícipio|Estado|CEP|Altitude|Longitude|Latitude|CCIR|CNPJ)";
			}
			else if(opt2 == 8) {
				tabela[0] = "Fim_Rótulos:";
				tabela[1] = "(Produto|Variedade|Classificação|Nome_do_produtor|CNPJ|Nome_da_propriedade|Endereço|Baírro|Município|Estado|País_de_Origem|CEP|Altitude|Latitude|Longitude|Peso_Líquido|Lote|Data_de_Embalamento|Codigo_de_barras)";
			}
			else if(opt2 == 9) {
				tabela[0] = "Fim_Venda:";
				tabela[1] = "(Data|Nota_Físcal|Produto|Lote|Quantidade)";
			}
			return tabela;
		}
}
