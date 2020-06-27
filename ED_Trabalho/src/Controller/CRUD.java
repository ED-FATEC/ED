package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		File dir = new File("C:\\TEMP");
		File file = new File("C:\\TEMP", "entrada.txt");
		Queue<Object> fila = new LinkedList<Object>();
		if(dir.exists() && dir.isDirectory()) {
			if(file.exists() && file.isFile()) {
				if(opt2 == 1) {
					fila.add(colheita.getCultura());
					fila.add(colheita.getData_de_embalamento());
					fila.add(colheita.getLote());
					fila.add(colheita.getObservações());
					fila.add(colheita.getParcela());
					fila.add(colheita.getQuadra());
					fila.add(colheita.getTalhão());
					fila.add(colheita.getUnidade_Comercializada());
					fila.add(colheita.getVariedade_ou_Cultivar());
				}
				else if(opt2 == 2) {
					fila.add(comprador.getBairro());
					fila.add(comprador.getCelular());
					fila.add(comprador.getCEP());
					fila.add(comprador.getCNPJ());
					fila.add(comprador.getEmail());
					fila.add(comprador.getEndereço());
					fila.add(comprador.getEstado());
					fila.add(comprador.getInscrição_Estadual());
					fila.add(comprador.getMunícipio());
					fila.add(comprador.getNome());
					fila.add(comprador.getRazão_social());
					fila.add(comprador.getTelefone());
				}
				else if(opt2 == 3) {
					fila.add(empresa.getCelular());
					fila.add(empresa.getEmail());
					fila.add(empresa.getRazão_Social());
					fila.add(empresa.getTelefone());
				}
				else if(opt2 == 4) {
					fila.add(insumos.getData_de_aplicação());
					fila.add(insumos.getDose());
					fila.add(insumos.getNome_comercial_do_produto());
					fila.add(insumos.getParcela());
					fila.add(insumos.getPeriodo_de_carência_em_dias());
					fila.add(insumos.getQuadra());
					fila.add(insumos.getTalhão());
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
					fila.add(propriedade.getEndereço());
					fila.add(propriedade.getEstado());
					fila.add(propriedade.getLatitude());
					fila.add(propriedade.getMunícipio());
					fila.add(propriedade.getNome());
					fila.add(propriedade.getLongitude());
				}
				else if(opt2 == 8) {
					fila.add(rotulos.getAltitude());
					fila.add(rotulos.getBaírro());
					fila.add(rotulos.getCEP());
					fila.add(rotulos.getCNPJ());
					fila.add(rotulos.getClassificação());
					fila.add(rotulos.getCodigo_de_barras());
					fila.add(rotulos.getData_de_Embalamento());
					fila.add(rotulos.getEndereço());
					fila.add(rotulos.getEstado());
					fila.add(rotulos.getLatitude());
					fila.add(rotulos.getLongitude());
					fila.add(rotulos.getLote());
					fila.add(rotulos.getMunicípio());
					fila.add(rotulos.getNome_da_propriedade());
					fila.add(rotulos.getNome_do_produtor());
					fila.add(rotulos.getPaís_de_Origem());
					fila.add(rotulos.getPeso_Líquido());
					fila.add(rotulos.getProduto());
					fila.add(rotulos.getVariedade());
				}
				else if(opt2 == 9) {
					fila.add(venda.getData());
					fila.add(venda.getLote());
					fila.add(venda.getNota_Físcal());
					fila.add(venda.getProduto());
					fila.add(venda.getQuantidade());
				} 
			}
			else {
				System.out.println("O arquivo 'entrada.txt' não existe, criando o arquivo...");
				gerarArquivo();
			}
		}
		else {
			System.out.println("O diretório não existe, criando o diretório e arquivo...");
			gerarDiretório();
			gerarArquivo();
		}
	}
	private void gerarArquivo() throws IOException{
		File file = new File("C:\\TEMP", "entrada.txt");
		file.createNewFile();
		FileWriter writer = new FileWriter(file,true);
		BufferedWriter buffer = new BufferedWriter(writer);
		PrintWriter print = new PrintWriter(buffer);
		print.write("Colheita:\n\r(Cultura|Variedade_ou_Cultivar|Quadra|Parcela|Talhão|Lote|Data_de_embalamento|Unidade_Comercializada|Observações)\n\n\r\r" + 
		"Comprador:\n\r(Nome|Razao_social|CNPJ|Inscrição_Estadual|Endereço|Bairro|CEP|Estado|Munícipio|Telefone|Celular|Email)\n\n\r\r"+
		"Empresa:\n\r(Telefone|Celular|Email|Tipo_de_usuario|Razão_Social)\n\n\r\r" +
		"Insumos:\n\r(Quadra|Parcela|Talhão|Data de aplicação|Nome comercial do produto|Periodo de carência em dias|Dose)\n\n\r\r" +
		"Produtos:\n\r(Nome|Tipo|Colheita)\n\n\r\r" +
		"Produtor:\n\r(Telefone|Celular|Email|Tipo_de_usuario|Nome)\n\n\r\r" +
		"Propriedade:\n\r(Nome|Endereço|Bairro|Munícipio|Estado|CEP|Altitude|Longitude|Latitude|CCIR|CNPJ)\n\n\r\r" +
		"Rotulos:\n\r(Produto|Variedade|Classificação|Nome_do_produtor|CNPJ|Nome_da_propriedade|Endereço|Baírro|Município|Estado|País_de_Origem|CEP|Altitude|Latitude|Longitude|Peso_Líquido|Lote|Data_de_Embalamento|Codigo_de_barras)\n\n\r\r" +
		"Venda:\n\r(Data|Nota_Físcal|Produto|Lote|Quantidade)");
		print.flush();
		print.close();
		buffer.close();
		writer.close();
	}
	private void gerarDiretório() throws IOException{
		File dir = new File("C:\\TEMP");
		dir.mkdir();
	}
	public void Alterar() {
		
	}
	public void Ler() {
		
	}
	public void Excluir() {
		
	}
	public void Consultar() {
		
	}
}
