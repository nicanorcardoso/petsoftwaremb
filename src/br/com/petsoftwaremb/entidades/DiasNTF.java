package br.com.petsoftwaremb.entidades;

import java.io.Serializable;

	public class DiasNTF implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private int dia;

		public int getDia() {
			return dia;
		}

		public void setDia(int dia) {
			this.dia = dia;
		}

		@Override
		public String toString() {
			return "DiasNTF [dia=" + dia + "]";
		}
		
		
			
	}