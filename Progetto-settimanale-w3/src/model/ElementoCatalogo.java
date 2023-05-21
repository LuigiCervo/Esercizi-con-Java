package model;
import java.io.Serializable;
import java.util.*;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tipo")
public abstract class ElementoCatalogo implements Serializable {
	@Id
	protected String isbn;
	protected String titolo;
	protected int annoPubblicazione;
	protected int numeroPagine;
	
	
	public String getIsbn() {
		return this.isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;	
	}
	
	public String getTitolo() {
		return this.titolo;
	}
	
	public void getTitolo(String titolo) {
		this.titolo = titolo;	
	}
	
	public int getAnnoPubblicazione() {
		return this.annoPubblicazione;
	}
	
	public void setAnnoPubblicazione(int annoPubblicazione) {
		this.annoPubblicazione = annoPubblicazione;	
	}
	
	public int getNumeroPagine() {
		return this.numeroPagine;
	}
	
	public void setNumeroPagine( int numeroPagine) {
		this.numeroPagine = numeroPagine;	
	}
	
	@Override
	public String toString() {
		return "ISBN: " + this.isbn + "\nTitolo: " + this.titolo + "\nPubblicato nell'anno: " + this.annoPubblicazione + "\nNumero di pagine: " + this.numeroPagine ;
	}
}
