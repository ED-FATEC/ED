package Model;

public class Comprador {
	private	String Nome;
	private String Razao_social;
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
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getRazão_social() {
		return Razao_social;
	}
	public void setRazao_social(String Razão_social) {
		Razao_social = Razão_social;
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
