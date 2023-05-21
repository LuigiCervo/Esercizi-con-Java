package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Rivista")
public class Rivista extends ElementoCatalogo {

	protected CadenzaRivista periodicita;
	
	public Rivista() {
		super();
	}
	
	public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, CadenzaRivista periodicita) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
		this.periodicita = periodicita;
	}

	public CadenzaRivista getPeriodicita(){
		return this.periodicita;
	}
	
	public void setPeriodicita(CadenzaRivista periodicita){
		this.periodicita = periodicita;
	}
	 @Override
	public String toString() {
		return super.toString() + "\nCadenza rivista: " + this.periodicita;
	}
}
