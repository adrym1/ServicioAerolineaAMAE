package model;

public class Login {
	private String codLogin;
	private String email;
	private String pass;
	private String idDatCuenCli;
	public Login() {
		
	}
	public String getCodLogin() {
		return codLogin;
	}
	public void setCodLogin(String codLogin) {
		this.codLogin = codLogin;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getIdDatCuenCli() {
		return idDatCuenCli;
	}
	public void setIdDatCuenCli(String idDatCuenCli) {
		this.idDatCuenCli = idDatCuenCli;
	}
	
}
