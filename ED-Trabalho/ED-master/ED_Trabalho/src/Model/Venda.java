package Model;

public class Venda {
	private	String	Data;		
	private	int	Nota_Físcal;		
	private	String	Produto;		
	private	int	Lote;		
	private	int	Quantidade;
	
	public String getData() {
		return Data;
	}
	public void setData(String data) {
		Data = data;
	}
	public int getNota_Físcal() {
		return Nota_Físcal;
	}
	public void setNota_Físcal(int nota_Físcal) {
		Nota_Físcal = nota_Físcal;
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
