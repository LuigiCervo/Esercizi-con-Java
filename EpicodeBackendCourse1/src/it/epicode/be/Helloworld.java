package it.epicode.be;

import java.util.Scanner;

public class Helloworld {

public static void main (String[] args)
		{
		// Stampa a console  la frase
		System.out.println("This is my first Epicode Java Project!");
		
		//Esercizio 2
		System.out.println(moltiplica(24, 3));
		System.out.println(concatena("Due",2));
		
		
		String[] arr = {"A", "B","C","D","E"};
		
		String[] arr1 = inserisciInArray( arr , "Ciao");
		
		for ( int i = 0 ; i<6 ; i++)
System.out.println(arr1[i]);
		
		//Esercizio 3
		
		Scanner myObj = new Scanner(System.in); 
		    System.out.print("Parola 1 :");
		    String Parola1 = myObj.nextLine(); 
		    System.out.print("Parola 2 :");
		    String Parola2 = myObj.nextLine();
		    System.out.print("Parola 3 :");
		    String Parola3 = myObj.nextLine();
		    System.out.println("Frase Intera: " + Parola1 + Parola2+ Parola3);
		    System.out.println("Frase Inversa: " + Parola3 + Parola2+ Parola1);
		
		    Scanner dati = new Scanner(System.in);
		    System.out.println("Calcola La base del Rettangolo");
		    System.out.print("Base :");
		    double base = dati.nextDouble();
		    System.out.print("Altezza :");
		    double altezza = dati.nextDouble();
		    System.out.println(perimetroRettangolo(base , altezza));
		    }
public static int moltiplica ( int num1 , int num2) {
	return num1 *  num2 ;
	
	
}

public static String concatena (String word, int num){
	return word +' '+ num;
}

public static  String[]  inserisciInArray(String[] arr , String word) {
	String[] arr1 = new String[6];
	arr1[2] = word;
	arr1[4] = arr[3];
	arr1[5] = arr[4];
	return arr1;
	
	
	
}

public static double perimetroRettangolo (double base , double altezza) {
	return base * altezza;
}

}



