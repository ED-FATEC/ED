package Model;

public class Comprador {
	private	String Nome_ou_Raz�o_social;		
	private	int	CNPJ;		
	private	int	Inscri��o_Estadual;		
	private	String	Endere�o;		
	private	String	Bairro;		
	private	int	CEP;		
	private	String	Estado;		
	private	String	Mun�cipio;		
	private	int	Telefone;		
	private	int	Celular;	
	private	String	Email;
	
	public String getNome_ou_Raz�o_social() {
		return Nome_ou_Raz�o_social;
	}
	public void setNome_ou_Raz�o_social(String nome_ou_Raz�o_social) {
		Nome_ou_Raz�o_social = nome_ou_Raz�o_social;
	}
	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
	public int getInscri��o_Estadual() {
		return Inscri��o_Estadual;
	}
	public void setInscri��o_Estadual(int inscri��o_Estadual) {
		Inscri��o_Estadual = inscri��o_Estadual;
	}
	public String getEndere�o() {
		return Endere�o;
	}
	public void setEndere�o(String endere�o) {
		Endere�o = endere�o;
	}
	public String getBairro() {
		return Bairro;
	}
	public void setBairro(String bairro) {
		Bairro = bairro;
	}
	public int getCEP() {
		return CEP;
	}
	public void setCEP(int cEP) {
		CEP = cEP;
	}
	public String getEstado() {
		return Estado;
	}
	public void setEstado(String estado) {
		Estado = estado;
	}
	public String getMun�cipio() {
		return Mun�cipio;
	}
	public void setMun�cipio(String mun�cipio) {
		Mun�cipio = mun�cipio;
	}
	public int getTelefone() {
		return Telefone;
	}
	public void setTelefone(int telefone) {
		Telefone = telefone;
	}
	public int getCelular() {
		return Celular;
	}
	public void setCelular(int celular) {
		Celular = celular;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
