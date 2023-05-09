package com.EsercizioEpicode.test;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MainProject3 {
	
	 private static Scanner sc = new Scanner(System.in);
	 
	 
	public static void main(String[] args) {
	
		ListaParola();
		
		}	
			
	public static void ListaParola() {
		
		Logger log = LoggerFactory.getLogger(MainProject3.class);
		
	 Set<String> s = new HashSet<String>();
	 Set<String> s2 = new HashSet<String>();
	 
	 System.out.println("Inserisci la grandezza del tuo set;");
	 int Lista;
	 do{
		 Lista = sc.nextInt();
		 sc.nextLine();
		  if(Lista == 0) {
				 System.out.println("0 non è una grandezza valida!");
			 }
	 } while(Lista <= 0);
	
	 for(int i = 0; i < Lista ; i++) {
		 System.out.println("Inserisci la parola;");
		 String parola = sc.nextLine();
		 boolean paroleRipetute = s.contains(parola);
		 if (paroleRipetute){
			System.out.println("la parola è già stata utilizzata!");
			s2.add(parola);
		 }
		 s.add(parola);	
	 	}
	  s.forEach(e -> System.out.println("Parole distinte:" + e));
	  s2.forEach(e -> System.out.println("Parole ripetute:"+ e));
	}
}



