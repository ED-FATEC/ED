package Model;

public class Venda {
	private	String	Data;		
	private	int	Nota_F�scal;		
	private	String	Produto;		
	private	int	Lote;		
	private	int	Quantidade;
	
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public int getNota_F�scal() {
		return Nota_F�scal;
	}
	public void setNota_F�scal(int nota_F�scal) {
		Nota_F�scal = nota_F�scal;
	}
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public int getLote() {
		return Lote;
	}
	public void setLote(int lote) {
		Lote = lote;
	}
	public int getQuantidade() {
		return Quantidade;
	}
	public void setQuantidade(int quantidade) {
		Quantidade = quantidade;
	}
}
