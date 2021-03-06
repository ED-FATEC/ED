package View;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Controller.CRUD;
import Controller.Ordena��o;
public class Principal{

	public static void main(String[] args) {
	int opt = 0;//Armazena o codigo da fun��o selecionada
	int opt2 = 0;//Armazena o codigo da tabela selecionada
	int cod = 0;//Caso o usuario deseje pesquisar ou alterar um valor, essa variavel vai salvar a posi��o do registro
	int cont = 0;//Serve para verificar se o usuario deseja sair da aplica��o
	long tempInicial = 0;//pega o tempo inicial da execu��o de uma fun��o
	long tempFinal = 0;;//pega o tempo final da execu��o de uma fun��o
	CRUD crud = new CRUD();//CRUD � a classe onde todas as fun��es do software est�o
	Ordena��o order = new Ordena��o();
	//A fun��o 'do while' ir� repetir a execu��o da aplica��o at� que o usuario deseje sair 	
	do {
			//O try catch ir� tratar erros das classe 'Principal' e pegar os throws da classe 'CRUD' 
			try {
				//Vai perguntar ao usuario qual a opera��o que ele deseja realizar
				opt = Integer.parseInt(JOptionPane.showInputDialog("Selecione a opera��o desejada:\n1-Inserir dados\n2-Atualizar dados\n3-Excluir dados\n4-Pesquisar dados\n5-Ordenar dados\n6-Ler dados do arquivo\n\n0-para encerrar o programa"));
				switch(opt) {
					case 1://Fun��o de inserir registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							//Vai perguntar ao usuario qual a tabela em que ele deseja fazer a opera��o
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela voc� deseja inserir:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							//O if vai checar se o usuario solicitou uma tabela n�o existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Voc� deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a fun��o, � calculado o tempo total para a execu��o da fun��o
								tempInicial = System.currentTimeMillis();
								crud.Inserir(opt2);
								tempFinal = System.currentTimeMillis();
								//Um pequeno relat�rio mostrando a fun��o que acabou de ser executada e o tempo que demorou para a execu��o da mesma
								System.out.println("\n\n____________Rel�t�rio______________");
								System.out.println("Fun��o usada: Inserir");
								System.out.println("Tempo de execu��o:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Voc� deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 2://Fun��o de alterar registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							//Vai perguntar ao usuario qual a tabela em que ele deseja fazer a opera��o
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela voc� deseja alterar:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							System.out.println("____________Antes______________");
							crud.Ler();
							cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o c�digo do registro que voc� deseja atualizar"));
							//O if vai checar se o usuario solicitou uma tabela n�o existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Voc� deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a fun��o, � calculado o tempo total para a execu��o da fun��o
								tempInicial = System.currentTimeMillis();
								crud.Alterar(opt2,cod);
								tempFinal = System.currentTimeMillis();
								//Ira ler o arquivo depois da fun��o ser executada
								System.out.println("\n____________Depois______________");
								crud.Ler();
								//Um pequeno relat�rio mostrando a fun��o que acabou de ser executada e o tempo que demorou para a execu��o da mesma
								System.out.println("\n\n____________Rel�t�rio______________");
								System.out.println("Fun��o usada: Alterar");
								System.out.println("Tempo de execu��o:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Voc� deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 3://Fun��o de excluir registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							//Vai perguntar ao usuario qual a tabela em que ele deseja fazer a opera��o
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela voc� deseja excluir:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							//Ira ler o arquivo antes da fun��o ser executada
							System.out.println("____________Antes______________");
							crud.Ler();
							//O if vai checar se o usuario solicitou uma tabela n�o existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Voc� deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a fun��o, � calculado o tempo total para a execu��o da fun��o
								tempInicial = System.currentTimeMillis();
								crud.Excluir(opt2);
								tempFinal = System.currentTimeMillis();
								//Ira ler o arquivo depois da fun��o ser executada
								System.out.println("\n____________Depois______________");
								crud.Ler();
								//Um pequeno relat�rio mostrando a fun��o que acabou de ser executada e o tempo que demorou para a execu��o da mesma
								System.out.println("\n\n____________Rel�t�rio______________");
								System.out.println("Fun��o usada: Excluir");
								System.out.println("Tempo de execu��o:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Voc� deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 4://Fun��o de consultar registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela voc� deseja pesquisar um dados:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o c�digo do registro"));
							//O if vai checar se o usuario solicitou uma tabela n�o existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Voc� deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a fun��o, � calculado o tempo total para a execu��o da fun��o
								tempInicial = System.currentTimeMillis();
								crud.Consultar(opt2,cod);
								tempFinal = System.currentTimeMillis();
								//Um pequeno relat�rio mostrando a fun��o que acabou de ser executada e o tempo que demorou para a execu��o da mesma
								System.out.println("\n\n____________Rel�t�rio______________");
								System.out.println("Fun��o usada: Pesquisar");
								System.out.println("Tempo de execu��o:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Voc� deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 5://Fun��o de ordernar registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Selecione um metodo de ordena��o de dados:\n1-Hash(Cidades)\n2-Hash(Nomes)\n3-SelectionSort(Z a A|9 a 0)\n4-BubbleSort(A a Z|0 a 9)\n\n0-Para retornar para o menu principal"));
							//O if vai checar se o usuario solicitou uma tabela n�o existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Fun��o n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Voc� deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}else {
								//Depois de executada a fun��o, � calculado o tempo total para a execu��o da fun��o
								tempInicial = System.currentTimeMillis();
								order.sort(opt2);
								tempFinal = System.currentTimeMillis();
								//Um pequeno relat�rio mostrando a fun��o que acabou de ser executada e o tempo que demorou para a execu��o da mesma
								System.out.println("\n\n____________Rel�t�rio______________");
								System.out.println("Fun��o usada: Ordenar");
								System.out.println("Tempo de execu��o:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Voc� deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 6://Fun��o de ler todos registros
						//Depois de executada a fun��o, � calculado o tempo total para a execu��o da fun��o
						tempInicial = System.currentTimeMillis();
						crud.Ler();
						tempFinal = System.currentTimeMillis();
						//Um pequeno relat�rio mostrando a fun��o que acabou de ser executada e o tempo que demorou para a execu��o da mesma
						System.out.println("\n\n____________Rel�t�rio______________");
						System.out.println("Fun��o usada: Ler");
						System.out.println("Tempo de execu��o:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
						break;
					case 0://Fun��o para sair do programa
						cont = JOptionPane.showConfirmDialog(null,"Voc� deseja encerrar a aplica��o?","Sair",JOptionPane.YES_NO_OPTION);
						break;
					default://Caso o usuario insira um codigo que n�o corresponde a uma fun��o o sistema manda uma mensagem de erro
						JOptionPane.showMessageDialog(null, "Opera��o n�o existente","Erro",JOptionPane.ERROR_MESSAGE);
						cont = JOptionPane.NO_OPTION;
						break;
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage() ,"ERRO",JOptionPane.ERROR_MESSAGE);
				cont = JOptionPane.NO_OPTION;
			}
			catch(NumberFormatException e2) {
				cont = JOptionPane.showConfirmDialog(null,"Voc� deseja encerrar a aplica��o?","Sair",JOptionPane.YES_NO_OPTION);
			}
		}while(cont == JOptionPane.NO_OPTION);
	}
}