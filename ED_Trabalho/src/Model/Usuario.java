package Model;

public abstract class Usuario {
	private	int	Telefone;		
	private	int	Celular;		
	private	String	Email;	
	private	String	Tipo_de_usuario;
	
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
	public String getTipo_de_usuario() {
		return Tipo_de_usuario;
	}
	public void setTipo_de_usuario(String tipo_de_usuario) {
		Tipo_de_usuario = tipo_de_usuario;
	}
	
}
