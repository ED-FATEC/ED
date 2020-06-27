package Model;

public class Propriedade {
	private	String	Nome;		
	private	String	Endereço;		
	private	String	Bairro;		
	private	String	Munícipio;		
	private	String	Estado;		
	private	int	CEP;		
	private	double	Altitude;		
	private	double	Longitude;		
	private	double	Latitude;		
	private	int	CCIR;		
	private	int	CNPJ;
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getEndereço() {
		return Endereço;
	}
	public void setEndereço(String endereço) {
		Endereço = endereço;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public String getMunícipio() {
		return Munícipio;
	}
	public void setMunícipio(String munícipio) {
		Munícipio = munícipio;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	public double getAltitude() {
		return Altitude;
	}
	public void setAltitude(double altitude) {
		Altitude = altitude;
	}
	public double getLongitude() {
		return Longitude;
	}
	public void setLongitude(double longitude) {
		Longitude = longitude;
	}
	public double getLatitude() {
		return Latitude;
	}
	public void setLatitude(double latitude) {
		Latitude = latitude;
	}
	public int getCCIR() {
		return CCIR;
	}
	public void setCCIR(int cCIR) {
		CCIR = cCIR;
	}
	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
}
