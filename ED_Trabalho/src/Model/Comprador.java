package Model;

public class Comprador {
	private	String Nome_ou_Razão_social;		
	private	int	CNPJ;		
	private	int	Inscrição_Estadual;		
	private	String	Endereço;		
	private	String	Bairro;		
	private	int	CEP;		
	private	String	Estado;		
	private	String	Munícipio;		
	private	int	Telefone;		
	private	int	Celular;	
	private	String	Email;
	
	public String getNome_ou_Razão_social() {
		return Nome_ou_Razão_social;
	}
	public void setNome_ou_Razão_social(String nome_ou_Razão_social) {
		Nome_ou_Razão_social = nome_ou_Razão_social;
	}
	public int getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(int cNPJ) {
		CNPJ = cNPJ;
	}
	public int getInscrição_Estadual() {
		return Inscrição_Estadual;
	}
	public void setInscrição_Estadual(int inscrição_Estadual) {
		Inscrição_Estadual = inscrição_Estadual;
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
	public String getMunícipio() {
		return Munícipio;
	}
	public void setMunícipio(String munícipio) {
		Munícipio = munícipio;
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
