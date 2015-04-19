package br.com.petsoftwaremb.entidades;

import java.io.Serializable;

public class Configuracoes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String diaIniciaNT;
	private String horaRepeteNT;
	public String getDiaIniciaNT() {
		return diaIniciaNT;
	}
	public void setDiaIniciaNT(String diaIniciaNT) {
		this.diaIniciaNT = diaIniciaNT;
	}
	public String getHoraRepeteNT() {
		return horaRepeteNT;
	}
	public void setHoraRepeteNT(String horaRepeteNT) {
		this.horaRepeteNT = horaRepeteNT;
	}
	@Override
	public String toString() {
		return this.diaIniciaNT;
	}
	
	

}
