package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Prestito {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Utente utente;
	@ManyToOne
	private ElementoCatalogo elementoPrestato;
	private String dataInizioPrestito;
	private String dataRestituzionePrevista;
	private String dataRestituzioneEffettiva;
	
	public Prestito() {
		
	}
	
	public Prestito(Utente utente , ElementoCatalogo elementoPrestato, int giornoInizioPrestito, int meseInizioPrestito, int annoInizioPrestito) {
		
		this.utente = utente;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = giornoInizioPrestito + "/" + meseInizioPrestito +"/"+ annoInizioPrestito;
		this.dataRestituzionePrevista = giornoInizioPrestito + "/" + (meseInizioPrestito + 1) +"/"+ annoInizioPrestito;
		this.dataRestituzioneEffettiva = null;
		
	}
	
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}
	public ElementoCatalogo getElementoPrestato() {
		return elementoPrestato;
	}
	public void setElementoPrestato(ElementoCatalogo elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}
	public String getDataInizioPrestito() {
		return dataInizioPrestito;
	}
	public void setDataInizioPrestito(String dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}
	public String getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}
	public void setDataRestituzionePrevista(String dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}
	public String getDataRestituzioneEffettiva() {
		return dataRestituzioneEffettiva;
	}
	public void setDataRestituzioneEffettiva(String dataRestituzioneEffettiva) {
		this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
	}
	
	public static Prestito createForNow(Utente utente , ElementoCatalogo elementoPrestato) {
		LocalDate now = LocalDate.now();
		Prestito result = new Prestito();
		result.utente = utente;
		result.elementoPrestato = elementoPrestato;
		result.dataInizioPrestito = now.format(DateTimeFormatter.ISO_DATE);
		result.dataRestituzionePrevista = now.plusDays(30).format(DateTimeFormatter.ISO_DATE);
		result.dataRestituzioneEffettiva = null;
		return result;
	}

}
