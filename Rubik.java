package rubik;

abstract public class Rubik {
	private final char COLORE_BIANCO = '+';
	private final char COLORE_GIALLO = '#';
	private final char COLORE_VERDE = 'V';
	private final char COLORE_ROSSO = '&';
	private final char COLORE_ARANCIONE = '?';
	private final char COLORE_BLU = '@';
	
	public char [][] matriceFacciaBianca;
	public char [][] matriceFacciaRossa;
	public char [][] matriceFacciaGialla;
	public char [][] matriceFacciaArancione;
	public char [][] matriceFacciaBlu;
	public char [][] matriceFacciaVerde;
	
	public Rubik(int x){
		matriceFacciaBianca = new char [x][x];
		matriceFacciaRossa = new char [x][x];
		matriceFacciaGialla = new char [x][x];
		matriceFacciaArancione = new char [x][x];
		matriceFacciaBlu = new char [x][x];
		matriceFacciaVerde = new char [x][x];
	}
	
	public char[][] riempi(char[][] matrice, char c){
		for (int i = 0; i < matrice.length; i++){
			for (int j = 0; j < matrice[0].length; j++){
				matrice[i][j] = c;
			}
		}
		return matrice;
	}
	
	public void riempiTuttaCorrettamente(){
		for (int i = 0; i < matriceFacciaBianca.length; i++){
			for (int j = 0; j < matriceFacciaBianca[0].length; j++){
				matriceFacciaBianca[i][j] = COLORE_BIANCO;
				matriceFacciaArancione[i][j] = COLORE_ARANCIONE;
				matriceFacciaBlu[i][j] = COLORE_BLU;
				matriceFacciaGialla[i][j] = COLORE_GIALLO;
				matriceFacciaRossa[i][j] = COLORE_ROSSO;
				matriceFacciaVerde[i][j] = COLORE_VERDE;
			}
		}
	}
	
	public String stampaFacciaSupInf(char[][] matrice){
		String s = new String("        ");
		for (int i = 0; i < matrice.length; i++){
			for (int j = 0; j < matrice[0].length; j++){
				s  = (j == (matrice[0].length - 1))? s + matrice[i][j] +"\n        " : s + matrice[i][j] + " ";
			}
		}
		return s;
	}
	
	
	public String stampaRiga(char [][] matrice, int i){ //Ricorda di stampare per righe, non per matrici
		String s = new String();
		for (int j = 0; j < matriceFacciaArancione[0].length; j++){
			s = (j == (matriceFacciaArancione[i].length -1))? s + matrice[i][j] + "   " : s + matrice[i][j] + " ";
		}
		return s;
	}
	public String stampaCubo(){ 
		return this.stampaFacciaSupInf(matriceFacciaGialla) + "\n" + this.stampaRiga(matriceFacciaVerde, 0) + this.stampaRiga(matriceFacciaArancione, 0) + this.stampaRiga(matriceFacciaBlu, 0) + this.stampaRiga(matriceFacciaRossa, 0) + "\n" +  this.stampaRiga(matriceFacciaVerde, 1) + this.stampaRiga(matriceFacciaArancione, 1) + this.stampaRiga(matriceFacciaBlu, 1) + this.stampaRiga(matriceFacciaRossa, 1) + "\n" + this.stampaRiga(matriceFacciaVerde, 2) + this.stampaRiga(matriceFacciaArancione, 2) + this.stampaRiga(matriceFacciaBlu, 2) + this.stampaRiga(matriceFacciaRossa, 2) + "\n\n" + this.stampaFacciaSupInf(matriceFacciaBianca);
	}
}
