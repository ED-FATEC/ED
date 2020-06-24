package Model;

public class Insumos {
	private	int	Quadra;		
	private	int	Parcela;		
	private	int	Talhão;		
	private	int	Data_de_aplicação;	
	private	String	Nome_comercial_do_produto;	
	private	int	Periodo_de_carência_em_dias;		
	private	int	Dose;
	
	public int getQuadra() {
		return Quadra;
	}
	public void setQuadra(int quadra) {
		Quadra = quadra;
	}
	public int getParcela() {
		return Parcela;
	}
	public void setParcela(int parcela) {
		Parcela = parcela;
	}
	public int getTalhão() {
		return Talhão;
	}
	public void setTalhão(int talhão) {
		Talhão = talhão;
	}
	public int getData_de_aplicação() {
		return Data_de_aplicação;
	}
	public void setData_de_aplicação(int data_de_aplicação) {
		Data_de_aplicação = data_de_aplicação;
	}
	public String getNome_comercial_do_produto() {
		return Nome_comercial_do_produto;
	}
	public void setNome_comercial_do_produto(String nome_comercial_do_produto) {
		Nome_comercial_do_produto = nome_comercial_do_produto;
	}
	public int getPeriodo_de_carência_em_dias() {
		return Periodo_de_carência_em_dias;
	}
	public void setPeriodo_de_carência_em_dias(int periodo_de_carência_em_dias) {
		Periodo_de_carência_em_dias = periodo_de_carência_em_dias;
	}
	public int getDose() {
		return Dose;
	}
	public void setDose(int dose) {
		Dose = dose;
	}
	
}
