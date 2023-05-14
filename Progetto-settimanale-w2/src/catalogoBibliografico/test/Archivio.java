package catalogoBibliografico.test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.*;


public class Archivio {

	private static List<ElementoCatalogo> list = new ArrayList<ElementoCatalogo>();
	
	public static void main(String[] args) {
		caricaArchivio("Archivio");
		System.out.println(list);
		Scanner s = new Scanner(System.in);
		System.out.println("Scegli la tua opzione :\n1-Aggiungi elemento\n2-Rimuovi elemento\n3-Cerca isbn\n4-Cerca anno di pubblicazione\n5-Cerca autore\n6-Salva Archivio");
		int scelta;
		
		do{
			scelta = s.nextInt();
			s.nextLine();
			if (scelta < 1 || scelta > 6) {
				System.out.println("Inserisci un'opzione valida!");
			}
		}while(scelta < 1 || scelta > 6);
		switch (scelta) {
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
		    switch(sceltaTipo) {
		    case 1:
		    	String autore;
		    	String genere;
		    	System.out.println("Autore del libro:");
		    	autore = s.nextLine();
		    	System.out.println("Genere:");
		    	genere = s.nextLine();
		    	aggiuntaElemento(new Libro(isbn,titolo,anno,numeroPagine,autore,genere));
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
		    	 aggiuntaElemento(new Rivista(isbn,titolo,anno,numeroPagine,cadenza));
		    	 break;
		    }
		case 2:
			System.out.println("Inserisci il codice Isbn dell'elemento che vuoi cancellare" + "\n"+ list);
			eliminazioneElemento(s.nextLine());
			break;
		case 3:
			System.out.println("Inserisci il codice Isbn:");
			cercaIsbn(s.nextLine());
			break;
		case 4:
			System.out.println("Inserisci l'anno di pubblicazione:");
			cercaAnno(s.nextInt());
			s.nextLine();
			break;
		case 5:
			System.out.println("Inserisci il nome dell'autore:");
			cercaAutore(s.nextLine());
			break;
		case 6:
			System.out.println("Inserisci il nome del file dove vuoi salvare il tuo archivio:");
			salvaArchivio(s.nextLine());
		}
		
	}
	
	public static boolean aggiuntaElemento(ElementoCatalogo elemento) {
		list.add(elemento);
		System.out.println("Elemento aggiunto:" + elemento);
		salvaArchivio("Archivio");
		return true;
	}
	public static boolean eliminazioneElemento(String isbn) {
		ElementoCatalogo e = list.stream()
				.filter(l-> l.isbn.equals(isbn))
				.findFirst()
				.orElse(null);
		if (e == null) {
			System.out.println("Elemento non trovato!");
			return false;
		}
		list.remove(e);
		System.out.println("Elemento eliminato!");
		System.out.println(list);
		salvaArchivio("Archivio");
		return true;
	}
	public static List<ElementoCatalogo> cercaIsbn(String codice){
		return list.stream()
				.filter(e ->e.isbn.startsWith(codice))
				.toList();
	}
	public static List<ElementoCatalogo> cercaAnno(int anno){
		return list.stream()
				.filter(e ->e.annoPubblicazione == anno)
				.toList();
	}
	public static List<ElementoCatalogo> cercaAutore(String autore){
		return list.stream()
				.filter(e -> e instanceof Libro)
				.filter(e ->((Libro)e).autore.startsWith(autore))
				.toList();
	}
	public static boolean salvaArchivio(String nomeFile){
		try {
			FileOutputStream f = new FileOutputStream(nomeFile + "bin");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(list);
			o.close();
			f.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean caricaArchivio(String nomeFile){
		try {
			FileInputStream f = new FileInputStream(nomeFile + ".bin");
			ObjectInputStream o =new ObjectInputStream(f);
			list = (List<ElementoCatalogo>)o.readObject();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
