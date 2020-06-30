package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import Model.Colheita;
import Model.Comprador;
import Model.Empresa;
import Model.Insumos;
import Model.Produto;
import Model.Produtor;
import Model.Propriedade;
import Model.Rotulos;
import Model.Venda;

public class CRUD {
	Colheita colheita = new Colheita();	
	Comprador comprador =  new Comprador();
	Empresa empresa =  new Empresa();
	Insumos insumos =  new Insumos();
	Produto produto =  new Produto();
	Produtor produtor =  new Produtor();
	Propriedade propriedade =  new Propriedade();
	Rotulos rotulos =  new Rotulos();
	Venda venda =  new Venda();
	
	public void Inserir(int opt2) throws IOException {
		File file = new File("C:\\TEMP", "entrada.txt");
		Queue<Object> fila = new LinkedList<Object>();
		int index = 0;
		if(verificaDir() == true) {
			fila.addAll(getAll(opt2));
			FileInputStream arq = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(leitor);
			ArrayList<Object> lista = new ArrayList<Object>();
			String linha = "";
			while ((linha = buffer.readLine()) != null) {
				lista.add(linha);
			}
			buffer.close();
			leitor.close();
			arq.close();
			String tabela[] = selecionaTabela(opt2);
			index = lista.indexOf(tabela[0]);
			String dados = "";
			while(!fila.isEmpty()) {
				dados += fila.poll() + " ";
			}
			lista.add(index, dados);
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
	}
	private String[] selecionaTabela(int opt2) {
		String tabela[] = new String[2];
		if(opt2 == 1) {
			tabela[0] = "Fim_Colheita:";
			tabela[1] = "(Cultura|Variedade_ou_Cultivar|Quadra|Parcela|Talh�o|Lote|Data_de_embalamento|Unidade_Comercializada|Observa��es)";
		}
		else if(opt2 == 2) {
			tabela[0] = "Fim_Comprador:";
			tabela[1] = "(Nome|Razao_social|CNPJ|Inscri��o_Estadual|Endere�o|Bairro|CEP|Estado|Mun�cipio|Telefone|Celular|Email)";
		}
		else if(opt2 == 3) {
			tabela[0] = "Fim_Empresa:";
			tabela[1] = "(Telefone|Celular|Email|Tipo_de_usuario|Raz�o_Social)";
		}
		else if(opt2 == 4) {
			tabela[0] = "Fim_Insumos:";
			tabela[1] = "(Quadra|Parcela|Talh�o|Data de aplica��o|Nome comercial do produto|Periodo de car�ncia em dias|Dose)";
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
			tabela[1] = "(Nome|Endere�o|Bairro|Mun�cipio|Estado|CEP|Altitude|Longitude|Latitude|CCIR|CNPJ)";
		}
		else if(opt2 == 8) {
			tabela[0] = "Fim_R�tulos:";
			tabela[1] = "(Produto|Variedade|Classifica��o|Nome_do_produtor|CNPJ|Nome_da_propriedade|Endere�o|Ba�rro|Munic�pio|Estado|Pa�s_de_Origem|CEP|Altitude|Latitude|Longitude|Peso_L�quido|Lote|Data_de_Embalamento|Codigo_de_barras)";
		}
		else if(opt2 == 9) {
			tabela[0] = "Fim_Venda:";
			tabela[1] = "(Data|Nota_F�scal|Produto|Lote|Quantidade)";
		}
		return tabela;
	}
	//Caso o diret�rio exista, mas o arquivo n�o, essa fun��o cria ele
	private void gerarArquivo() throws IOException{
		File file = new File("C:\\TEMP", "entrada.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter print = new PrintWriter(buffer);
		print.write("Colheita:\n(Cultura|Variedade_ou_Cultivar|Quadra|Parcela|Talh�o|Lote|Data_de_embalamento|Unidade_Comercializada|Observa��es)\nFim_Colheita:\n\r" + 
		"Comprador:\n(Nome|Razao_social|CNPJ|Inscri��o_Estadual|Endere�o|Bairro|CEP|Estado|Mun�cipio|Telefone|Celular|Email)\nFim_Comprador:\n\r"+
		"Empresa:\n(Telefone|Celular|Email|Tipo_de_usuario|Raz�o_Social)\nFim_Empresa:\n\r" +
		"Insumos:\n(Quadra|Parcela|Talh�o|Data de aplica��o|Nome comercial do produto|Periodo de car�ncia em dias|Dose)\nFim_Insumos:\n\r" +
		"Produtos:\n(Nome|Tipo|Colheita)\nFim_Produtos:\n\r" +
		"Produtor:\n(Telefone|Celular|Email|Tipo_de_usuario|Nome)\nFim_Produtor:\n\r" +
		"Propriedade:\n(Nome|Endere�o|Bairro|Mun�cipio|Estado|CEP|Altitude|Longitude|Latitude|CCIR|CNPJ)\nFim_Propriedade:\n\r" +
		"Rotulos:\n(Produto|Variedade|Classifica��o|Nome_do_produtor|CNPJ|Nome_da_propriedade|Endere�o|Ba�rro|Munic�pio|Estado|Pa�s_de_Origem|CEP|Altitude|Latitude|Longitude|Peso_L�quido|Lote|Data_de_Embalamento|Codigo_de_barras)\nFim_R�tulos:\n\r" +
		"Venda:\n(Data|Nota_F�scal|Produto|Lote|Quantidade)\nFim_Venda:\n");
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
	public boolean verificaDir() throws IOException {
		File dir = new File("C:\\TEMP");
		File file = new File("C:\\TEMP", "entrada.txt");
		boolean existe = false;
		if(dir.exists() && dir.isDirectory()) {
			if(file.exists() && file.isFile()) {
				existe = true;
			}
			else {
				System.out.println("O arquivo 'entrada.txt' n�o existe, criando o arquivo...");
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
	
	public void Alterar(int opt2,int cod) throws IOException {
		File file = new File("C:\\TEMP", "entrada.txt");
		if(verificaDir() == true) {
			Queue<Object> fila = new LinkedList<Object>();
			int cont = 0;
			FileInputStream arq = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(leitor);
			LinkedList<Object> lista = new LinkedList<Object>();
			String linha = "";
			String valores[][];
			int inicio = 0, fim = 0;
			String tabela[] = selecionaTabela(opt2);
			Object sub_lista[];
			while ((linha = buffer.readLine()) != null) {
				lista.add(linha);
			}
			buffer.close();
			leitor.close();
			arq.close();
			inicio = lista.indexOf(tabela[1]);
			fim = lista.indexOf(tabela[0]);
			String c = "";
			String aux[];
			sub_lista = lista.subList(inicio + 1, fim).toArray();
			if(sub_lista.length != 0) {
				setAll(opt2);
				fila.addAll(getAll(opt2));
				c = sub_lista[0].toString();
				aux = c.split(" ");
				valores = new String[sub_lista.length][aux.length];
				for(int x = 0; x < sub_lista.length; x++) {
					c = sub_lista[x].toString();
					aux = c.split(" ");
					for(int y = 0; y < aux.length; y++) {
						valores[x][y] = aux[y];
					}
				}
				String dados = "";
				while(!fila.isEmpty()) {
					valores[cod][cont] = fila.poll().toString();
					dados += valores[cod][cont] + " ";
					cont++;
				}
				lista.set(inicio + cod, dados);
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
				throw new IOException("A tabela est� vazia");
			}
		}
	}
	public void Excluir(int opt2) throws FileNotFoundException, IOException {
		File file = new File("C:\\TEMP", "entrada.txt");
		if(verificaDir() == true) {
			Queue<Object> fila = new LinkedList<Object>();
			FileInputStream arq = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(arq);
			BufferedReader buffer = new BufferedReader(leitor);
			LinkedList<Object> lista = new LinkedList<Object>();
			String linha = "";
			Object sub_lista[];
			int inicio = 0, fim = 0;
			String tabela[] = selecionaTabela(opt2);
			while ((linha = buffer.readLine()) != null) {
				fila.add(linha);
				lista.add(linha);
			}
			buffer.close();
			leitor.close();
			arq.close();
			inicio = lista.indexOf(tabela[1]);
			fim = lista.indexOf(tabela[0]);
			sub_lista = lista.subList(inicio + 1, fim).toArray();
			if(sub_lista.length != 0) {
				lista.remove(inicio + 1);
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
				throw new IOException("A tabela est� vazia");
			}
		}
	}
	public void Ler() throws IOException {
		File file = new File("C:\\TEMP", "entrada.txt");
		if(verificaDir() == true) {
			FileReader leitor = new FileReader(file);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = "";
			while ((linha = buffer.readLine()) != null) {
	           System.out.println(linha);
			}
			buffer.close();
			leitor.close();
		}
	}
	public void Consultar() {
		
	}
	private Queue<Object> getAll(int opt2) {
		Queue<Object> fila = new LinkedList<Object>();
		if(opt2 == 1) {
			fila.add(colheita.getCultura());
			fila.add(colheita.getData_de_embalamento());
			fila.add(colheita.getLote());
			fila.add(colheita.getObserva��es());
			fila.add(colheita.getParcela());
			fila.add(colheita.getQuadra());
			fila.add(colheita.getTalh�o());
			fila.add(colheita.getUnidade_Comercializada());
			fila.add(colheita.getVariedade_ou_Cultivar());
		}
		else if(opt2 == 2) {
			fila.add(comprador.getBairro());
			fila.add(comprador.getCelular());
			fila.add(comprador.getCEP());
			fila.add(comprador.getCNPJ());
			fila.add(comprador.getEmail());
			fila.add(comprador.getEndere�o());
			fila.add(comprador.getEstado());
			fila.add(comprador.getInscri��o_Estadual());
			fila.add(comprador.getMun�cipio());
			fila.add(comprador.getNome());
			fila.add(comprador.getRaz�o_social());
			fila.add(comprador.getTelefone());
		}
		else if(opt2 == 3) {
			fila.add(empresa.getCelular());
			fila.add(empresa.getEmail());
			fila.add(empresa.getRaz�o_Social());
			fila.add(empresa.getTelefone());
		}
		else if(opt2 == 4) {
			fila.add(insumos.getData_de_aplica��o());
			fila.add(insumos.getDose());
			fila.add(insumos.getNome_comercial_do_produto());
			fila.add(insumos.getParcela());
			fila.add(insumos.getPeriodo_de_car�ncia_em_dias());
			fila.add(insumos.getQuadra());
			fila.add(insumos.getTalh�o());
		}
		else if(opt2 == 5) {
			fila.add(produto.getColheita());
			fila.add(produto.getNome());
			fila.add(produto.getTipo());
		}
		else if(opt2 == 6) {
			fila.add(produtor.getCelular());
			fila.add(produtor.getEmail());
			fila.add(produtor.getNome());
			fila.add(produtor.getTelefone());
		}
		else if(opt2 == 7) {
			fila.add(propriedade.getBairro());
			fila.add(propriedade.getAltitude());
			fila.add(propriedade.getCEP());
			fila.add(propriedade.getCNPJ());
			fila.add(propriedade.getCCIR());
			fila.add(propriedade.getEndere�o());
			fila.add(propriedade.getEstado());
			fila.add(propriedade.getLatitude());
			fila.add(propriedade.getMun�cipio());
			fila.add(propriedade.getNome());
			fila.add(propriedade.getLongitude());
		}
		else if(opt2 == 8) {
			fila.add(rotulos.getAltitude());
			fila.add(rotulos.getBa�rro());
			fila.add(rotulos.getCEP());
			fila.add(rotulos.getCNPJ());
			fila.add(rotulos.getClassifica��o());
			fila.add(rotulos.getCodigo_de_barras());
			fila.add(rotulos.getData_de_Embalamento());
			fila.add(rotulos.getEndere�o());
			fila.add(rotulos.getEstado());
			fila.add(rotulos.getLatitude());
			fila.add(rotulos.getLongitude());
			fila.add(rotulos.getLote());
			fila.add(rotulos.getMunic�pio());
			fila.add(rotulos.getNome_da_propriedade());
			fila.add(rotulos.getNome_do_produtor());
			fila.add(rotulos.getPa�s_de_Origem());
			fila.add(rotulos.getPeso_L�quido());
			fila.add(rotulos.getProduto());
			fila.add(rotulos.getVariedade());
		}
		else if(opt2 == 9) {
			fila.add(venda.getData());
			fila.add(venda.getLote());
			fila.add(venda.getNota_F�scal());
			fila.add(venda.getProduto());
			fila.add(venda.getQuantidade());
		}
		return fila;
	}
	public void setAll(int opt2) {
		if(opt2 == 1) {
			colheita.setCultura(Integer.parseInt(JOptionPane.showInputDialog("Insira a cultura:")));
			colheita.setData_de_embalamento(String.valueOf(JOptionPane.showInputDialog("Insira a data de embalamento:")));
			colheita.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o lote:")));
			colheita.setParcela(Integer.parseInt(JOptionPane.showInputDialog("Insira a parcela:")));
			colheita.setQuadra(Integer.parseInt(JOptionPane.showInputDialog("Insira a quadra:")));
			colheita.setTalh�o(Integer.parseInt(JOptionPane.showInputDialog("Insira o talh�o:")));
			colheita.setUnidade_Comercializada(Integer.parseInt(JOptionPane.showInputDialog("Insira a unidade comercializada:")));
			colheita.setVariedade_ou_Cultivar(Integer.parseInt(JOptionPane.showInputDialog("Insira a variedade/cultivar:")));
			colheita.setObserva��es(String.valueOf(JOptionPane.showInputDialog("Insira alguma obseva��o:")));
		}
		else if(opt2 == 2) {
			comprador.setBairro(String.valueOf(JOptionPane.showInputDialog("Insira o bairro:")));
			comprador.setCelular(Integer.parseInt(JOptionPane.showInputDialog("Insira o Celular:")));
			comprador.setCEP(Integer.parseInt(JOptionPane.showInputDialog("Insira o CEP:")));
			comprador.setCNPJ(Integer.parseInt(JOptionPane.showInputDialog("Insira o CNPJ:")));
			comprador.setEmail(String.valueOf(JOptionPane.showInputDialog("Insira o email")));
			comprador.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o estado")));
			comprador.setInscri��o_Estadual(Integer.parseInt(JOptionPane.showInputDialog("Insira a inscri��o estadual:")));
			comprador.setMun�cipio(String.valueOf(JOptionPane.showInputDialog("Insira o munic�pio")));
			comprador.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome do dono:")));
			comprador.setNome(String.valueOf(JOptionPane.showInputDialog("Insira a raz�o social:")));
			comprador.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
		}
		else if(opt2 == 3) {
			empresa.setCelular(Integer.parseInt(JOptionPane.showInputDialog("Insira o Celular:")));
			empresa.setEmail(String.valueOf(JOptionPane.showInputDialog("Insira a email:")));
			empresa.setRaz�o_Social(String.valueOf(JOptionPane.showInputDialog("Insira a raz�o social:")));
			empresa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
		}
		else if(opt2 == 4) {
			insumos.setTalh�o(Integer.parseInt(JOptionPane.showInputDialog("Insira o talh�o:")));
			insumos.setData_de_aplica��o(String.valueOf(JOptionPane.showInputDialog("Insira a data de aplica��o:")));
			insumos.setNome_comercial_do_produto(String.valueOf(JOptionPane.showInputDialog("Insira a nome comercial:")));
			insumos.setParcela(Integer.parseInt(JOptionPane.showInputDialog("Insira o parcela:")));
			insumos.setPeriodo_de_car�ncia_em_dias(Integer.parseInt(JOptionPane.showInputDialog("Insira o periodo de carencia(Dias):")));
			insumos.setQuadra(Integer.parseInt(JOptionPane.showInputDialog("Insira o Quadra:")));
			insumos.setDose(Integer.parseInt(JOptionPane.showInputDialog("Insira o Dose:")));
		}
		else if(opt2 == 5) {
			produto.setColheita(String.valueOf(JOptionPane.showInputDialog("Insira Colheita:")));
			produto.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			produto.setTipo(String.valueOf(JOptionPane.showInputDialog("Insira o tipo do produto:")));
		}
		else if(opt2 == 6) {
			produtor.setCelular(Integer.parseInt(JOptionPane.showInputDialog("Insira o Celular:")));
			produtor.setEmail(String.valueOf(JOptionPane.showInputDialog("Insira o email:")));
			produtor.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			produtor.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
		}
		else if(opt2 == 7) {
			propriedade.setAltitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
			propriedade.setBairro(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			propriedade.setCCIR(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			propriedade.setCEP(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			propriedade.setCNPJ(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			propriedade.setEndere�o(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			propriedade.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			propriedade.setLatitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
			propriedade.setLongitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
			propriedade.setMun�cipio(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			propriedade.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
		}
		else if(opt2 == 8) {
			rotulos.setAltitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setVariedade(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setProduto(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setPeso_L�quido(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			rotulos.setNome_do_produtor(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setNome_da_propriedade(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setCodigo_de_barras(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			rotulos.setPa�s_de_Origem(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			rotulos.setCEP(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			rotulos.setCNPJ(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
			rotulos.setEndere�o(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setLatitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setLongitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setData_de_Embalamento(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
			rotulos.setClassifica��o(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
		}
		else if(opt2 == 9) {
			venda.setData(String.valueOf(JOptionPane.showInputDialog("Insira a data de venda:")));
			venda.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o lote:")));
			venda.setNota_F�scal(Integer.parseInt(JOptionPane.showInputDialog("Insira a nota f�scal:")));
			venda.setProduto(String.valueOf(JOptionPane.showInputDialog("Insira o nome do produto:")));
			venda.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade vendida:")));
		} 
		else {
			JOptionPane.showMessageDialog(null, "Fun��o tabela n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
		}
	}
}
