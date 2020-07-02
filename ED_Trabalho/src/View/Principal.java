package View;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import Controller.CRUD;
import Controller.Ordenação;
public class Principal{

	public static void main(String[] args) {
	int opt = 0;//Armazena o codigo da função selecionada
	int opt2 = 0;//Armazena o codigo da tabela selecionada
	int cod = 0;//Caso o usuario deseje pesquisar ou alterar um valor, essa variavel vai salvar a posição do registro
	int cont = 0;//Serve para verificar se o usuario deseja sair da aplicação
	long tempInicial = 0;//pega o tempo inicial da execução de uma função
	long tempFinal = 0;;//pega o tempo final da execução de uma função
	CRUD crud = new CRUD();//CRUD é a classe onde todas as funções do software estão
	Ordenação order = new Ordenação();
	//A função 'do while' irá repetir a execução da aplicação até que o usuario deseje sair 	
	do {
			//O try catch irá tratar erros das classe 'Principal' e pegar os throws da classe 'CRUD' 
			try {
				//Vai perguntar ao usuario qual a operação que ele deseja realizar
				opt = Integer.parseInt(JOptionPane.showInputDialog("Selecione a operação desejada:\n1-Inserir dados\n2-Atualizar dados\n3-Excluir dados\n4-Pesquisar dados\n5-Ordenar dados\n6-Ler dados do arquivo\n\n0-para encerrar o programa"));
				switch(opt) {
					case 1://Função de inserir registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							//Vai perguntar ao usuario qual a tabela em que ele deseja fazer a operação
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela você deseja inserir:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							//O if vai checar se o usuario solicitou uma tabela não existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela não existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Você deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a função, é calculado o tempo total para a execução da função
								tempInicial = System.currentTimeMillis();
								crud.Inserir(opt2);
								tempFinal = System.currentTimeMillis();
								//Um pequeno relatório mostrando a função que acabou de ser executada e o tempo que demorou para a execução da mesma
								System.out.println("\n\n____________Relátório______________");
								System.out.println("Função usada: Inserir");
								System.out.println("Tempo de execução:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Você deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 2://Função de alterar registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							//Vai perguntar ao usuario qual a tabela em que ele deseja fazer a operação
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela você deseja alterar:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							System.out.println("____________Antes______________");
							crud.Ler();
							cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do registro que você deseja atualizar"));
							//O if vai checar se o usuario solicitou uma tabela não existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela não existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Você deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a função, é calculado o tempo total para a execução da função
								tempInicial = System.currentTimeMillis();
								crud.Alterar(opt2,cod);
								tempFinal = System.currentTimeMillis();
								//Ira ler o arquivo depois da função ser executada
								System.out.println("\n____________Depois______________");
								crud.Ler();
								//Um pequeno relatório mostrando a função que acabou de ser executada e o tempo que demorou para a execução da mesma
								System.out.println("\n\n____________Relátório______________");
								System.out.println("Função usada: Alterar");
								System.out.println("Tempo de execução:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Você deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 3://Função de excluir registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							//Vai perguntar ao usuario qual a tabela em que ele deseja fazer a operação
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela você deseja excluir:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							//Ira ler o arquivo antes da função ser executada
							System.out.println("____________Antes______________");
							crud.Ler();
							//O if vai checar se o usuario solicitou uma tabela não existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela não existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Você deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a função, é calculado o tempo total para a execução da função
								tempInicial = System.currentTimeMillis();
								crud.Excluir(opt2);
								tempFinal = System.currentTimeMillis();
								//Ira ler o arquivo depois da função ser executada
								System.out.println("\n____________Depois______________");
								crud.Ler();
								//Um pequeno relatório mostrando a função que acabou de ser executada e o tempo que demorou para a execução da mesma
								System.out.println("\n\n____________Relátório______________");
								System.out.println("Função usada: Excluir");
								System.out.println("Tempo de execução:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Você deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 4://Função de consultar registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Em qual tabela você deseja pesquisar um dados:\n1-Colheita\n2-Comprador\n3-Empresa\n4-Insumos\n5-Produto\n6-Produtor\n7-Propriedade\n8-Rotulo\n9-Vendas\n\n0-Para retornar para o menu principal"));
							cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do registro"));
							//O if vai checar se o usuario solicitou uma tabela não existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Tabela não existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Você deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}
							else {
								//Depois de executada a função, é calculado o tempo total para a execução da função
								tempInicial = System.currentTimeMillis();
								crud.Consultar(opt2,cod);
								tempFinal = System.currentTimeMillis();
								//Um pequeno relatório mostrando a função que acabou de ser executada e o tempo que demorou para a execução da mesma
								System.out.println("\n\n____________Relátório______________");
								System.out.println("Função usada: Pesquisar");
								System.out.println("Tempo de execução:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Você deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 5://Função de ordernar registros
						//O try catch vai checar se o usuario colocou lestra em campos onde eram para ter numeros
						try {
							opt2 = Integer.parseInt(JOptionPane.showInputDialog("Selecione um metodo de ordenação de dados:\n1-Hash(Cidades)\n2-Hash(Nomes)\n3-SelectionSort(Z a A|9 a 0)\n4-BubbleSort(A a Z|0 a 9)\n\n0-Para retornar para o menu principal"));
							//O if vai checar se o usuario solicitou uma tabela não existe
							//Ou se ele pediu para retornar ao menu principal
							if(opt2 > 9) {
								JOptionPane.showMessageDialog(null, "Função não existente","Erro",JOptionPane.ERROR_MESSAGE);
								cont = JOptionPane.NO_OPTION;
							}
							else if(opt2 == 0) {
								cont = JOptionPane.showConfirmDialog(null,"Você deseja retornar ao menu principal?","Retornar",JOptionPane.YES_NO_OPTION);
								cont = JOptionPane.NO_OPTION;
							}else {
								//Depois de executada a função, é calculado o tempo total para a execução da função
								tempInicial = System.currentTimeMillis();
								order.sort(opt2);
								tempFinal = System.currentTimeMillis();
								//Um pequeno relatório mostrando a função que acabou de ser executada e o tempo que demorou para a execução da mesma
								System.out.println("\n\n____________Relátório______________");
								System.out.println("Função usada: Ordenar");
								System.out.println("Tempo de execução:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
							}
						}catch(NumberFormatException e6) {
							JOptionPane.showMessageDialog(null, "Você deve utilizar numeros nesse campo" ,"ERRO",JOptionPane.ERROR_MESSAGE);
							cont = JOptionPane.NO_OPTION;
						}
						break;
					case 6://Função de ler todos registros
						//Depois de executada a função, é calculado o tempo total para a execução da função
						tempInicial = System.currentTimeMillis();
						crud.Ler();
						tempFinal = System.currentTimeMillis();
						//Um pequeno relatório mostrando a função que acabou de ser executada e o tempo que demorou para a execução da mesma
						System.out.println("\n\n____________Relátório______________");
						System.out.println("Função usada: Ler");
						System.out.println("Tempo de execução:" + new SimpleDateFormat("mm:ss:SSS").format(new Date(tempFinal - tempInicial)));
						break;
					case 0://Função para sair do programa
						cont = JOptionPane.showConfirmDialog(null,"Você deseja encerrar a aplicação?","Sair",JOptionPane.YES_NO_OPTION);
						break;
					default://Caso o usuario insira um codigo que não corresponde a uma função o sistema manda uma mensagem de erro
						JOptionPane.showMessageDialog(null, "Operação não existente","Erro",JOptionPane.ERROR_MESSAGE);
						cont = JOptionPane.NO_OPTION;
						break;
				}
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage() ,"ERRO",JOptionPane.ERROR_MESSAGE);
				cont = JOptionPane.NO_OPTION;
			}
			catch(NumberFormatException e2) {
				cont = JOptionPane.showConfirmDialog(null,"Você deseja encerrar a aplicação?","Sair",JOptionPane.YES_NO_OPTION);
			}
		}while(cont == JOptionPane.NO_OPTION);
	}
}