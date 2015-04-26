package br.com.petsoftwaremb.entidades;

public class Usuario {

	private String login;
	private String senha;
	private String email;
	private String perfil;

	public Usuario() {
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "Usuario{" + "login=" + login + ", senha=" + senha + ", email="
				+ email + ", perfil=" + perfil + '}';
	}

}
