package View;
import java.io.IOException;

import javax.swing.JOptionPane;
import Model.*;
import Controller.CRUD;
public class Principal{

	public static void main(String[] args) {
	int opt2 = 0;
	int Sair = 0;
	CRUD crud = new CRUD();
	Colheita colheita = new Colheita();	
	Comprador comprador =  new Comprador();
	Empresa empresa =  new Empresa();
	Insumos insumos =  new Insumos();
	Produto produto =  new Produto();
	Produtor produtor =  new Produtor();
	Propriedade propriedade =  new Propriedade();
	Rotulos rotulos =  new Rotulos();
	Venda venda =  new Venda();
		do {
			int opt = Integer.parseInt(JOptionPane.showInputDialog("Selecione a operação desejada:\n1-Inserir dados\n2-Atualizar dados\n3-Excluir dados\n4-Pesquisar dados\n5-Ordenar dados\n6-Ler dados do arquivo\n\n0-para encerrar o programa"));
			switch(opt) {
				case 1:
					opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela você deseja inserir:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
					if(opt2 == 1) {
						colheita.setCultura(Integer.parseInt(JOptionPane.showInputDialog("Insira a cultura:")));
						colheita.setData_de_embalamento(String.valueOf(JOptionPane.showInputDialog("Insira a data de embalamento:")));
						colheita.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o lote:")));
						colheita.setParcela(Integer.parseInt(JOptionPane.showInputDialog("Insira a parcela:")));
						colheita.setQuadra(Integer.parseInt(JOptionPane.showInputDialog("Insira a quadra:")));
						colheita.setTalhão(Integer.parseInt(JOptionPane.showInputDialog("Insira o talhão:")));
						colheita.setUnidade_Comercializada(Integer.parseInt(JOptionPane.showInputDialog("Insira a unidade comercializada:")));
						colheita.setVariedade_ou_Cultivar(Integer.parseInt(JOptionPane.showInputDialog("Insira a variedade/cultivar:")));
						colheita.setObservações(String.valueOf(JOptionPane.showInputDialog("Insira alguma obsevação:")));
					}
					else if(opt2 == 2) {
						comprador.setBairro(String.valueOf(JOptionPane.showInputDialog("Insira o bairro:")));
						comprador.setCelular(Integer.parseInt(JOptionPane.showInputDialog("Insira o Celular:")));
						comprador.setCEP(Integer.parseInt(JOptionPane.showInputDialog("Insira o CEP:")));
						comprador.setCNPJ(Integer.parseInt(JOptionPane.showInputDialog("Insira o CNPJ:")));
						comprador.setEmail(String.valueOf(JOptionPane.showInputDialog("Insira o email")));
						comprador.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o estado")));
						comprador.setInscrição_Estadual(Integer.parseInt(JOptionPane.showInputDialog("Insira a inscrição estadual:")));
						comprador.setMunícipio(String.valueOf(JOptionPane.showInputDialog("Insira o município")));
						comprador.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome do dono:")));
						comprador.setNome(String.valueOf(JOptionPane.showInputDialog("Insira a razão social:")));
						comprador.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
					}
					else if(opt2 == 3) {
						empresa.setCelular(Integer.parseInt(JOptionPane.showInputDialog("Insira o Celular:")));
						empresa.setEmail(String.valueOf(JOptionPane.showInputDialog("Insira a email:")));
						empresa.setRazão_Social(String.valueOf(JOptionPane.showInputDialog("Insira a razão social:")));
						empresa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
					}
					else if(opt2 == 4) {
						insumos.setTalhão(Integer.parseInt(JOptionPane.showInputDialog("Insira o talhão:")));
						insumos.setData_de_aplicação(String.valueOf(JOptionPane.showInputDialog("Insira a data de aplicação:")));
						insumos.setNome_comercial_do_produto(String.valueOf(JOptionPane.showInputDialog("Insira a nome comercial:")));
						insumos.setParcela(Integer.parseInt(JOptionPane.showInputDialog("Insira o parcela:")));
						insumos.setPeriodo_de_carência_em_dias(Integer.parseInt(JOptionPane.showInputDialog("Insira o periodo de carencia(Dias):")));
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
						propriedade.setEndereço(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setLatitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setLongitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setMunícipio(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
					}
					else if(opt2 == 8) {
						rotulos.setAltitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setVariedade(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setProduto(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setPeso_Líquido(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setNome_do_produtor(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setNome_da_propriedade(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setCodigo_de_barras(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setPaís_de_Origem(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setCEP(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setCNPJ(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setEndereço(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setLatitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setLongitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setData_de_Embalamento(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setClassificação(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
					}
					else if(opt2 == 9) {
						venda.setData(String.valueOf(JOptionPane.showInputDialog("Insira a data de venda:")));
						venda.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o lote:")));
						venda.setNota_Físcal(Integer.parseInt(JOptionPane.showInputDialog("Insira a nota físcal:")));
						venda.setProduto(String.valueOf(JOptionPane.showInputDialog("Insira o nome do produto:")));
						venda.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade vendida:")));
					} 
					else {
						JOptionPane.showMessageDialog(null, "Função tabela não existente","Erro",JOptionPane.ERROR_MESSAGE);
						break;
					}
					try {
						crud.Inserir(opt2);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case 2:
					opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela você deseja alterar:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
					if(opt2 == 1) {
						colheita.setCultura(Integer.parseInt(JOptionPane.showInputDialog("Insira a cultura:")));
						colheita.setData_de_embalamento(String.valueOf(JOptionPane.showInputDialog("Insira a data de embalamento:")));
						colheita.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o lote:")));
						colheita.setParcela(Integer.parseInt(JOptionPane.showInputDialog("Insira a parcela:")));
						colheita.setQuadra(Integer.parseInt(JOptionPane.showInputDialog("Insira a quadra:")));
						colheita.setTalhão(Integer.parseInt(JOptionPane.showInputDialog("Insira o talhão:")));
						colheita.setUnidade_Comercializada(Integer.parseInt(JOptionPane.showInputDialog("Insira a unidade comercializada:")));
						colheita.setVariedade_ou_Cultivar(Integer.parseInt(JOptionPane.showInputDialog("Insira a variedade/cultivar:")));
						colheita.setObservações(String.valueOf(JOptionPane.showInputDialog("Insira alguma obsevação:")));
					}
					else if(opt2 == 2) {
						comprador.setBairro(String.valueOf(JOptionPane.showInputDialog("Insira o bairro:")));
						comprador.setCelular(Integer.parseInt(JOptionPane.showInputDialog("Insira o Celular:")));
						comprador.setCEP(Integer.parseInt(JOptionPane.showInputDialog("Insira o CEP:")));
						comprador.setCNPJ(Integer.parseInt(JOptionPane.showInputDialog("Insira o CNPJ:")));
						comprador.setEmail(String.valueOf(JOptionPane.showInputDialog("Insira o email")));
						comprador.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o estado")));
						comprador.setInscrição_Estadual(Integer.parseInt(JOptionPane.showInputDialog("Insira a inscrição estadual:")));
						comprador.setMunícipio(String.valueOf(JOptionPane.showInputDialog("Insira o município")));
						comprador.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome do dono:")));
						comprador.setNome(String.valueOf(JOptionPane.showInputDialog("Insira a razão social:")));
						comprador.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
					}
					else if(opt2 == 3) {
						empresa.setCelular(Integer.parseInt(JOptionPane.showInputDialog("Insira o Celular:")));
						empresa.setEmail(String.valueOf(JOptionPane.showInputDialog("Insira a email:")));
						empresa.setRazão_Social(String.valueOf(JOptionPane.showInputDialog("Insira a razão social:")));
						empresa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
					}
					else if(opt2 == 4) {
						insumos.setTalhão(Integer.parseInt(JOptionPane.showInputDialog("Insira o talhão:")));
						insumos.setData_de_aplicação(String.valueOf(JOptionPane.showInputDialog("Insira a data de aplicação:")));
						insumos.setNome_comercial_do_produto(String.valueOf(JOptionPane.showInputDialog("Insira a nome comercial:")));
						insumos.setParcela(Integer.parseInt(JOptionPane.showInputDialog("Insira o parcela:")));
						insumos.setPeriodo_de_carência_em_dias(Integer.parseInt(JOptionPane.showInputDialog("Insira o periodo de carencia(Dias):")));
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
						propriedade.setEndereço(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setLatitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setLongitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setMunícipio(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						propriedade.setNome(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
					}
					else if(opt2 == 8) {
						rotulos.setAltitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setVariedade(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setProduto(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setPeso_Líquido(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setNome_do_produtor(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setNome_da_propriedade(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setCodigo_de_barras(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setPaís_de_Origem(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setCEP(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setCNPJ(Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone:")));
						rotulos.setEndereço(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setEstado(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setLatitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setLongitude(Double.parseDouble(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setData_de_Embalamento(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
						rotulos.setClassificação(String.valueOf(JOptionPane.showInputDialog("Insira o nome:")));
					}
					else if(opt2 == 9) {
						venda.setData(String.valueOf(JOptionPane.showInputDialog("Insira a data de venda:")));
						venda.setLote(Integer.parseInt(JOptionPane.showInputDialog("Insira o lote:")));
						venda.setNota_Físcal(Integer.parseInt(JOptionPane.showInputDialog("Insira a nota físcal:")));
						venda.setProduto(String.valueOf(JOptionPane.showInputDialog("Insira o nome do produto:")));
						venda.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Insira a quantidade vendida:")));
					} else {
						JOptionPane.showMessageDialog(null, "Função tabela não existente","Erro",JOptionPane.ERROR_MESSAGE);
					}
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
				try {
					crud.Ler();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					break;
				case 0:
					Sair = JOptionPane.showConfirmDialog(null,"Você deseja encerrar a aplicação?","Sair",JOptionPane.YES_NO_OPTION);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Operação não existente","Erro",JOptionPane.ERROR_MESSAGE);
					break;
			}
			
		}while(Sair != JOptionPane.YES_OPTION);
	}
}
