package eserciziEpicode.test;

public class Sim {
	
	String numero;
	double credito;

Call[] lastCalls;

	public Sim (String numero , double credito , Call[] lastCalls ) {
		
		
		 this.numero = numero;
		 this.credito = credito;
		 this.lastCalls = lastCalls;
		
		
	}
	
	public void stampaSim() {
		System.out.println("Il tuo numero:" + " "+ numero);
		System.out.println("Il tuo credoto residuo è di" + " "+ credito);
		System.out.println("Le tue ultime chiamate:" + " ");
		
		for(int i=0 ; i< lastCalls.length; i++) {
		
		System.out.println(lastCalls[i]);
		}
	}
	
}
