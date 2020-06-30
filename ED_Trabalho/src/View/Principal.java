package View;
import java.io.IOException;

import javax.swing.JOptionPane;
import Controller.CRUD;
public class Principal{

	public static void main(String[] args) {
	int opt2 = 0;
	int opt = 0;
	int cod = 0;
	int cont = 0;
	CRUD crud = new CRUD();
		do {
			try {
				crud.verificaDir();
				opt = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opera��o desejada:\n1-Inserir dados\n2-Atualizar dados\n3-Excluir dados\n4-Pesquisar dados\n5-Ordenar dados\n6-Ler dados do arquivo\n\n0-para encerrar o programa"));
				switch(opt) {
					case 1:
						opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela voc� deseja inserir:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
						crud.setAll(opt2);
						crud.Inserir(opt2);
						break;
					case 2:
						opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela voc� deseja alterar:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
						cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o c�digo do registro que voc� deseja atualizar"));
						if(opt2 > 9) {
							JOptionPane.showMessageDialog(null, "Tabela n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
						}else {
							crud.Alterar(opt2,cod);
							System.out.println("____________Antes______________");
							crud.Ler();
							System.out.println("\n____________Depois______________");
							crud.Ler();
						}
						break;
					case 3:
						opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela voc� deseja excluir:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
						cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o c�digo do registro que voc� deseja excluir"));
						if(opt2 > 9) {
							JOptionPane.showMessageDialog(null, "Tabela n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
						}else {
							crud.Excluir(opt2);
							System.out.println("____________Antes______________");
							crud.Ler();
							System.out.println("\n____________Depois______________");
							crud.Ler();
						}
						break;
					case 4:
						break;
					case 5:
						break;
					case 6:
						crud.Ler();
						break;
					case 0:
						cont = JOptionPane.showConfirmDialog(null,"Voc� deseja encerrar a aplica��o?","Sair",JOptionPane.YES_NO_OPTION);
						break;
					default:
						JOptionPane.showMessageDialog(null, "Opera��o n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
						break;
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage() ,"ERRO",JOptionPane.ERROR_MESSAGE);
			}
			catch(NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "At� Mais!!!" ,"Encerrar",JOptionPane.INFORMATION_MESSAGE);
			}
		}while(opt != 0 || cont == JOptionPane.NO_OPTION);
	}
}

