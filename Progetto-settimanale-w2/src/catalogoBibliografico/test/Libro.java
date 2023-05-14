package catalogoBibliografico.test;
import java.util.*;

public class Libro extends ElementoCatalogo {

	protected String autore;
	protected String genere;
	
	public Libro (String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numeroPagine = numeroPagine;
		this.autore = autore;
		this.genere = genere;
	}
	
	public String getAutore() {
		return this.autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String setGenere(){
		return this.genere;
	}
	
	public void setGenere(String genere) {
		this.genere = genere;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nScritto da: " + this.autore + "\nGenere: " + this.genere;
	}
}
