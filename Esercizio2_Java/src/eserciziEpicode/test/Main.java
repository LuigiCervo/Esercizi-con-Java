package eserciziEpicode.test;

public class Main {

	public static void main(String[] args) {
		
// Esercizio 1
		
Rettangolo r = new Rettangolo (5, 7);

r.stampaAreaEPerimetro();

//Esercizio 2

Call[] lastCalls = {new Call("8131247" , "20:12"), new Call("8131247" , "15:12"), new Call("8131247" , "9:12"), new Call("8131247" , "14:12"), new Call("8131247" , "9:12")};

for(int i=0 ; i<lastCalls.length; i++){
	
	lastCalls[i].stampCall();
}


Sim cellulare = new Sim ("123456789", 2.54 ,lastCalls);

cellulare.stampaSim();


	}

	

}
