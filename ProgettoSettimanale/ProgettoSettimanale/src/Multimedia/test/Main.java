package Multimedia.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Array dove verranno immagazzinati i dati degli elementi multimediali
		ElementoMultimediale[] media = new ElementoMultimediale[5];
		//Scanner per input da console
		Scanner s = new Scanner(System.in);
		
		//---------------------- Input Elementi ----------------------
		for(int i=0 ; i<5; i++) {
			
			System.out.println(i + "." + " Inserisci il titolo del media:");
			String titolo = s.nextLine();
			System.out.println(i + "." + " Inserisci il tipo di media:");
			System.out.println(" 0 = Immagine 1 = Video 2 = Traccia Audio");
			int scelta;
			do {
				scelta = s.nextInt();
				if (scelta < 0 || scelta > 2) {
					System.out.println("Inserire un'opzione valida!");
				}
			} while (scelta < 0 || scelta > 2);
			switch (scelta) {
			case 0: 
				media[i]= new Immagine(titolo, 5);
				break; 
			case 1:
				media[i]= new Video(titolo , 5 , 5);
				break;
			case 2:
				media[i]= new Audio(titolo , 5);
				break;
			}
			s.nextLine();
		}
		//------------------------
		System.out.println("Menu");
		System.out.println("0) Esci dal lettore");
		System.out.println("1) Seleziona una traccia");
		int scelta;
		do {
			scelta = s.nextInt();
			if (scelta < 0 || scelta > 1) System.out.println("Inserire un'opzione valida!");
		} while (scelta < 0 || scelta > 1);
		switch (scelta) {
		case 0 : 
			return;
		case 1 :
			System.out.print("Inserisci il numero della traccia:\n>");
			
			int tracciaScelta;
			do {
				tracciaScelta = s.nextInt();
				s.nextLine();
				if (tracciaScelta < 0 || tracciaScelta > 4) System.out.println("Inserire una traccia valida!");
			} while (tracciaScelta < 0 || tracciaScelta > 4);
			System.out.println("Cosa vuoi fare ora?");
			System.out.println("0) Alza volume");
			System.out.println("1) Abbassa volume");
			System.out.println("2) Alza luminosità");
			System.out.println("3) Abbassa luminosità");
			System.out.println("4) Riproduci");
			int operazioneScelta;
			do {
				operazioneScelta = s.nextInt();
				s.nextLine();
				if (operazioneScelta < 0 || operazioneScelta > 4) System.out.println("Inserire una operazione valida!");
			} while (operazioneScelta < 0 || operazioneScelta > 4);
			switch (operazioneScelta)  {
			case 0 :
				//Controllare che il tipo supporta i metodi di Riproducibile
				if (media[tracciaScelta] instanceof Riproducibile) {
					Riproducibile r = (Riproducibile) media[tracciaScelta];
					r.alzaVolume();
					media[tracciaScelta].show();
				}else
					System.out.println("Operazione non supportata!");
				//media[tracciaScelta].alzaVolume();
				break;
			case 1 :
				//Controllare che il tipo supporta i metodi di Riproducibile
				if (media[tracciaScelta] instanceof Riproducibile) {
					Riproducibile r = (Riproducibile) media[tracciaScelta];
					r.abbassaVolume();
					media[tracciaScelta].show();
				}else
					System.out.println("Operazione non supportata!");
				//media[tracciaScelta].abbassaVolume();
				break;
			case 2 :
				//Controllare che il tipo supporta i metodi di LuminositaRegolabile
				if (media[tracciaScelta] instanceof LuminositaRegolabile) {
					LuminositaRegolabile r = (LuminositaRegolabile) media[tracciaScelta];
					r.aumentaLuminosita();
					media[tracciaScelta].show();
				}else
					System.out.println("Operazione non supportata!");
				//media[tracciaScelta].alzaLuminosita();
				break;
			case 3 :
				if (media[tracciaScelta] instanceof LuminositaRegolabile) {
					LuminositaRegolabile r = (LuminositaRegolabile) media[tracciaScelta];
					r.abbassaLuminosita();
					media[tracciaScelta].show();
				}else
					System.out.println("Operazione non supportata!");
				//Controllare che il tipo supporta i metodi di LuminositaRegolabile
				//media[tracciaScelta].abbassaLuminosita();
				break;
			case 4:
				media[tracciaScelta].show();
			}
			break;
		}
	}
}
			
	

