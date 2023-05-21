package controller;
import model.*;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Archivio {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Progetto-settimanale-w3");
		EntityManager em= emf.createEntityManager();
	//	em.getTransaction().begin();
	//	Utente u = new Utente ("Luigi", "Cervo","13/09/1999", "79461649");
	//	Prestito p = Prestito.createForNow(u, l);
	//	em.persist(p);
	//	em.getTransaction().commit();
	//	em.close();
	//	emf.close();
		Scanner s = new Scanner(System.in);
		System.out.println("Scegli la tua opzione :\n1-Aggiungi elemento\n2-Rimuovi elemento\n3-Cerca per isbn\n4-Cerca per anno di pubblicazione\n5-Cerca per nome autore"
				+ "\n6-Cerca per titolo\n7-Lista prestiti\n8-Lista prestiti restituiti e non");
		int scelta;
		
		do{
			scelta = s.nextInt();
			s.nextLine();
			if (scelta < 1 || scelta > 8) {
				System.out.println("Inserisci un'opzione valida!");
			}
		}while(scelta < 1 || scelta > 8);
		switch(scelta){
		
		case 1: 
			String isbn;
			String titolo;
			int anno;
			int numeroPagine;
			System.out.println("Compila il seguente modulo;");	
			System.out.println("Codice ISBN;");		
			isbn = s.nextLine();
			System.out.println("Titolo;");	
			titolo = s.nextLine();
			System.out.println("Anno di pubblicazione;");	
			anno = s.nextInt();
			s.nextLine();
			System.out.println("Numero Pagine;");	
			numeroPagine = s.nextInt();
		    s.nextLine();
		    int sceltaTipo;
		    System.out.println("Che tipo di elemento è?\n1-Libro1\n2-Rivista ");
		    do{
				sceltaTipo = s.nextInt();
				s.nextLine();
				if (sceltaTipo < 1 || sceltaTipo > 2) {
					System.out.println("Inserisci un'opzione valida!");
				}
			}while(sceltaTipo < 1 || sceltaTipo > 2);
		    
		    ElementoCatalogo e = null;
		    switch(sceltaTipo) {
		    case 1:
		    	String autore;
		    	String genere;
		    	System.out.println("Autore del libro:");
		    	autore = s.nextLine();
		    	System.out.println("Genere:");
		    	genere = s.nextLine();
		    	e = new Libro(isbn,titolo,anno,numeroPagine,autore,genere);
		    	System.out.println(titolo + "è stato aggiunto all'archivio!");
		    	break;
		    case 2:
		    	int sceltaCadenza;
		    	CadenzaRivista cadenza = CadenzaRivista.SETTIMANALE;
		    	System.out.println("Scegli la cadenza di uscita della tua rivista:\n1-Settimanale\n2-Mensile\n3-Semestrale");
		    	 do{
		    		 sceltaCadenza = s.nextInt();
						s.nextLine();
						if (sceltaCadenza < 1 || sceltaCadenza > 3) {
							System.out.println("Inserisci un'opzione valida!");
						}
					}while(sceltaCadenza < 1 || sceltaCadenza > 3);
		    	 switch(sceltaCadenza) {
		    	 case 1:
		    		 cadenza= CadenzaRivista.SETTIMANALE;
		    		 break;
		    	 case 2:
		    		 cadenza= CadenzaRivista.MENSILE;
		    		 break;
		    	 case 3:
		    		 cadenza= CadenzaRivista.SEMESTRALE;
		    		 break; 
		    	 } 
		    	 e = new Rivista(isbn,titolo,anno,numeroPagine,cadenza);
		    	 break;
		    }
			em.getTransaction().begin();
    		em.persist(e);
			em.getTransaction().commit();

		    break;
		case 2:
			System.out.println("Inserisci il codice Isbn dell'elemento che vuoi cancellare");
			Query q = em.createQuery("DELETE FROM ElementoCatalogo WHERE isbn = :isbn ");
			q.setParameter("isbn", s.nextLine());
			em.getTransaction().begin();
			q.executeUpdate();
			em.getTransaction().commit();
			System.out.println("Elemento eliminato!");
			break;
		case 3:
			System.out.println("Inserisci il codice Isbn dell'elemento che vuoi cercare");
			Query q1 = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE isbn = :isbn ");
			q1.setParameter("isbn", s.nextLine());
			try {
			ElementoCatalogo e1= (ElementoCatalogo)q1.getSingleResult();
				System.out.println(e1);
			} catch (NoResultException exc) {
			System.out.println("Elemento non trovato!");
			}
			break;
		case 4:
			System.out.println("Inserisci l'anno di pubblicazione dell'elemento che vuoi cercare");
			Query q2 = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE annoPubblicazione = :annoPubblicazione ");
			q2.setParameter("annoPubblicazione", s.nextInt());
			s.nextLine();
			try {
			ElementoCatalogo e1= (ElementoCatalogo)q2.getSingleResult();
				System.out.println(e1);
			} catch (NoResultException exc) {
			System.out.println("Elemento non trovato!");
			}
			break;
		case 5:
			System.out.println("Inserisci il nome dell'autore dell'elemento che vuoi cercare");
			Query q3 = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE autore = :autore ");
			q3.setParameter("autore",s.nextLine());
			try {
			ElementoCatalogo e1= (ElementoCatalogo)q3.getSingleResult();
				System.out.println(e1);
			} catch (NoResultException exc) {
			System.out.println("Elemento non trovato!");
			}
			break;
		case 6:
			System.out.println("Inserisci il titolo dell'elemento che vuoi cercare");
			Query q4 = em.createQuery("SELECT e FROM ElementoCatalogo e WHERE titolo = :titolo ");
			q4.setParameter("titolo",s.nextLine());
			try {
			ElementoCatalogo e1= (ElementoCatalogo)q4.getSingleResult();
				System.out.println(e1);
			} catch (NoResultException exc) {
			System.out.println("Elemento non trovato!");
			}
			break;
		case 7:
			System.out.println("Inserisci il titolo dell'elemento che vuoi cercare");
			Query q5 = em.createQuery("SELECT p FROM Prestito p WHERE utente_numeroTessera = :numeroTessera ");
			q5.setParameter("numeroTessera",s.nextLine());
			try {
			List<Prestito> prestiti = (List<Prestito>)q5.getResultList();
			for(Prestito p : prestiti) {
				System.out.println(p.getElementoPrestato());
			}
			} catch (NoResultException exc) {
			}
			break;
		case 8:
			System.out.println("Inserisci il titolo dell'elemento che vuoi cercare");
			Query q6 = em.createQuery("SELECT p FROM Prestito p WHERE datarestituzioneeffettiva <> NULL");
			q6.setParameter("numeroTessera",s.nextLine());
			try {
			List<Prestito> prestiti = (List<Prestito>)q6.getResultList();
			for(Prestito p : prestiti) {
				System.out.println(p.getElementoPrestato());
			}
			} catch (NoResultException exc) {
			}
			break;
		}
	}
}