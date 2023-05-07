package Multimedia.test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ElementoMultimediale[] media = new ElementoMultimediale[5];
		
		Scanner s = new Scanner(System.in);
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
			}
			while (scelta < 0 || scelta > 2);
			switch (scelta) {
			case 0 : 
				media[i]= new Immagine(titolo, 5);
				break; 
			case 1 :
				media[i]= new Video(titolo , 5 , 5);
				break;
			case 2 :
				media[i]= new Audio(titolo , 5);
				break;
			}
			s.nextLine();
		}
		for (int i=0; i<5; i++) {
			media[i].show();
			System.out.println("\n");}
		System.out.println("Cosa vuoi fare ora?");
		System.out.println(" 0 = Esci dal lettore 1 = Seleziona una traccia");
		int scelta;
		do {
			scelta = s.nextInt();
			if (scelta < 0 || scelta > 1) {
				System.out.println("Inserire un'opzione valida!");
			}
		} while (scelta < 0 || scelta > 1);
		switch (scelta) {
		case 0 : 
		return;
		case 1 :
			System.out.println("Inserisci il numero della tua traccia:");
			if(scelta == 1 ||scelta == 2) {
				media[s.nextInt()].show();
				}
			}
		}
	}
			
	

