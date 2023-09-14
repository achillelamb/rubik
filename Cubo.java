package rubik;

import java.util.Random;
import java.util.StringTokenizer;

public class Cubo extends Mosse {
	
	public void scombina(){
		String s = new String("r r l l l' l' l r r' u u u' u' l l l' b b b' b' d d s d u u u' u' b b b' b' b' d s' d' d' d' d' m m m' m' e e e' e' r r' s r' r'");
		StringTokenizer st = new StringTokenizer(s, " ");
		boolean[] caso = new boolean[st.countTokens()];
		String[] sel = new String[st.countTokens()];
		Random r = new Random();
		int count = 0;
		for (int i = 0; i < caso.length; i++){
			caso[i] = r.nextBoolean();
			sel[i] = st.nextToken();
			if (caso[i]){
				count++;	
			}
		}
		String[] effettivo = new String[count];
		int x = 0;
		for (int i = 0; i < caso.length; i++){
			if (caso[i]){ 
				effettivo[x++] = sel[i];
			}
		}
		for (int i = 0; i < effettivo.length; i++){
			switch (effettivo[i]){
				case "risolvi" : this.riempiTuttaCorrettamente();
				break;
				case "r" : this.erre();
				break;
				case "r2" : this.erre2();
				break;
				case "r'" : this.errePrimo();
				break;
				case "u" : this.u();
				break;
				case "u2" : this.u2();
				break;
				case "u'" : this.uPrimo();
				break;
				case "l" : this.elle();
				break;
				case "l2" : this.elle2();
				break;
				case "l'" : this.ellePrimo();
				break;
				case "f" : this.effe();
				break;
				case "f2" : this.effe2();
				break;
				case "f'" : this.effePrimo();
				break;
				case "b" : this.bi();
				break;
				case "b2" : this.bi2();
				break;
				case "b'" : this.biPrimo();
				break;
				case "d" : this.down();
				break;
				case "d2" : this.down2();
				break;
				case "d'" : this.downPrimo();
				break;
				case "m" : this.emme();
				break;
				case "m2" : this.emme2();
				break;
				case "m'" : this.emmePrimo();
				break;
				case "e" : this.e();
				break;
				case "e2" : this.e2();
				break;
				case "e'" : this.ePrimo();
				break;
				case "s" : this.esse();
				break;
				case "s2" : this.esse2();
				break;
				case "s'" : this.essePrimo();
				break;
				default: System.out.println("Mossa non valida");
			}
		}
	}


	public boolean equals(Object o){
		if (o instanceof Cubo){
			boolean[] b;
			int c = 0, count = 0; 
			for (int i = 0; i < this.matriceFacciaBianca.length; i++){
				for (int j = 0; j < this.matriceFacciaBianca[0].length; j++){
					count++;
				}
			}
			b = new boolean[count];
			for (int i = 0; i < this.matriceFacciaBianca.length; i++){
				for (int j = 0; j < this.matriceFacciaBianca[0].length; j++, c++){
					b[c] = ((this.matriceFacciaBianca[i][j] == ((Cubo) o).matriceFacciaBianca[i][j]) && (this.matriceFacciaRossa[i][j] == ((Cubo) o).matriceFacciaRossa[i][j]) && (this.matriceFacciaArancione[i][j] == ((Cubo) o).matriceFacciaArancione[i][j]) && (this.matriceFacciaGialla[i][j] == ((Cubo) o).matriceFacciaGialla[i][j]) && (this.matriceFacciaVerde[i][j] == ((Cubo) o).matriceFacciaVerde[i][j]) && (this.matriceFacciaBlu[i][j] == ((Cubo) o).matriceFacciaBlu[i][j]));
				}
			}
			

			return (b[0] && b[1] && b[2] && b[3] && b[4] && b[5] && b[6] && b[7] && b[8]);
		}
		else {
			return false;
		}
	}
	
	
	public boolean equals(Cubo c){
		return this.equals((Object)c);
	}
	
	
	public static boolean facciaOmogenea(char[][] matrice){
		boolean b = true;
		for (int i = 0; i < matrice.length; i++){
			for (int j = 0; j < matrice[0].length; j++){
				if (matrice[i][j] != matrice[1][1]){
					b = b && false;				
				}
				else 
					b = b && true;
			}
		}
		return b;
	}
	
	
	public boolean haiVinto(){
		return (facciaOmogenea(this.matriceFacciaBianca) && facciaOmogenea(this.matriceFacciaGialla) && facciaOmogenea(this.matriceFacciaRossa) && facciaOmogenea(this.matriceFacciaArancione) && facciaOmogenea(this.matriceFacciaBlu) && facciaOmogenea(this.matriceFacciaVerde));
	}
	

}
