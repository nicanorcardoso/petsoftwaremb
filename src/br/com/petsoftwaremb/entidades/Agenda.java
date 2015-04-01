package br.com.petsoftwaremb.entidades;

import java.io.Serializable;
import java.util.Date;

public class Agenda implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
    private Integer id;
    private String descricao;
    private String executante;
    private Date dataInicio;
    private Cliente cliente;          
    private boolean diaTodo;

	
	
}
