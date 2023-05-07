package Multimedia.test;

public class Immagine extends ElementoMultimediale implements LuminositaRegolabile{

	int luminosita;
	
	@Override
	public void aumentaLuminosita() {
		if(luminosita < 10) {
			luminosita++;
		}
		
	}

	@Override
	public void abbassaLuminosita() {
		if(luminosita > 0) {
			luminosita--;
		}
	}
	
	@Override
	public void show() {
		
		System.out.print(titolo);
		
		for(int i=0 ; i< luminosita; i++) {
			System.out.print("*");
			}
		}
	public Immagine (String titolo, int luminosita){
		
		this.titolo = titolo;
		this.luminosita = luminosita;
	}
	}

