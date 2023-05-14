package catalogoBibliografico.test;
import java.io.Serializable;
import java.util.*;

public abstract class ElementoCatalogo implements Serializable {

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
