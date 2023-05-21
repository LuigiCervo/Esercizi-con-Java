package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Utente {

	private String nome;
	private String cognome;
	private String dataDiNascita;
	@Id
	private String numeroTessera;
	
	public Utente(){
		super();
	}
	
	public Utente(String nome, String cognome, String dataDiNascita, String numeroTessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.numeroTessera = numeroTessera;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getNumeroTessera() {
		return numeroTessera;
	}
	public void setNumeroTessera(String numeroTessera) {
		this.numeroTessera = numeroTessera;
	}

}
