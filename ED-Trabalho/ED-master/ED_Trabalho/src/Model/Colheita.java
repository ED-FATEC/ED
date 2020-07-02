package Model;

public class Colheita {
	private	int	Cultura;		
	private	int	Variedade_ou_Cultivar;		
	private	int	Quadra;		
	private	int	Parcela;		
	private	int	Talhão;		
	private	int	Lote;		
	private	String Data_de_embalamento;		
	private	int	Unidade_Comercializada;	
	private	String	Observações;
	
	public int getCultura() {
		return Cultura;
	}
	public void setCultura(int cultura) {
		Cultura = cultura;
	}
	public int getVariedade_ou_Cultivar() {
		return Variedade_ou_Cultivar;
	}
	public void setVariedade_ou_Cultivar(int variedade_ou_Cultivar) {
		Variedade_ou_Cultivar = variedade_ou_Cultivar;
	}
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
	public int getLote() {
		return Lote;
	}
	public void setLote(int lote) {
		Lote = lote;
	}
	public String getData_de_embalamento() {
		return Data_de_embalamento;
	}
	public void setData_de_embalamento(String data_de_embalamento) {
		Data_de_embalamento = data_de_embalamento;
	}
	public int getUnidade_Comercializada() {
		return Unidade_Comercializada;
	}
	public void setUnidade_Comercializada(int unidade_Comercializada) {
		Unidade_Comercializada = unidade_Comercializada;
	}
	public String getObservações() {
		return Observações;
	}
	public void setObservações(String observações) {
		Observações = observações;
	}		
}
