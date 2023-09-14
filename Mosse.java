package rubik;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import rubik.Rubik;
import java.util.NoSuchElementException;
abstract public class Mosse extends Rubik{
	
	
	public Mosse(int x){
		super(x);
	}
	
	public Mosse(){
		this(3);
	}
	
	
	private static void ruotaFacciaOrario(char [][] matrice){
		char t = matrice[0][0];
		matrice[0][0] = matrice[2][0];
		matrice[2][0] = matrice[2][2];
		matrice[2][2] = matrice[0][2];
		matrice[0][2] = t;
		t = matrice[0][1];
		matrice[0][1] = matrice[1][0];
		matrice[1][0] = matrice[2][1];
		matrice[2][1] = matrice[1][2];
		matrice[1][2] = t;
	}
	
	
	private static void ruotaFacciaAntiorario(char [][] matrice){
		char t = matrice[0][0];
		matrice[0][0] = matrice[0][2];
		matrice[0][2] = matrice[2][2];
		matrice[2][2] = matrice[2][0];
		matrice[2][0] = t;
		t = matrice[0][1];
		matrice[0][1] = matrice[1][2];
		matrice[1][2] = matrice[2][1];
		matrice[2][1] = matrice[1][0];
		matrice[1][0] = t;
	}
	
	
	
	
	
	
	//RIGHT
	
	public void erre(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaArancione[i][2];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaArancione[i][2] = this.matriceFacciaBianca[i][2];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaBianca[i][2] = this.matriceFacciaRossa[t][0];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaRossa[i][0] = this.matriceFacciaGialla[t][2];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaGialla[i][2] = arrayt[i];
		}
		//Rotazione faccia laterale
		ruotaFacciaOrario(matriceFacciaBlu);
	}
	
	public void erre2(){
		this.erre();
		this.erre();
	}
	
	public void errePrimo(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaArancione[i][2];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaArancione[i][2] = this.matriceFacciaGialla[i][2];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			this.matriceFacciaGialla[i][2]= this.matriceFacciaRossa[t][0];
		}	
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			this.matriceFacciaRossa[t][0] = this.matriceFacciaBianca[i][2];
		}
		for (int i = 0; i < arrayt.length; i++){
			  this.matriceFacciaBianca[i][2] = arrayt[i];
		}
		//Rotazione faccia laterale
		ruotaFacciaAntiorario(matriceFacciaBlu);
	}
	
	
	
	
	
	
	
	
	//UP
	
	public void u(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaArancione[0][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaArancione[0][i] = this.matriceFacciaBlu[0][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaBlu[0][i] = this.matriceFacciaRossa[0][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaRossa[0][i] = this.matriceFacciaVerde[0][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaVerde[0][i] = arrayt[i];
		}
		ruotaFacciaOrario(matriceFacciaGialla);
	}
	
		public void u2(){
		this.u();
		this.u();
	}
	public void uPrimo(){
		this.u2();
		this.u();
	}
	
	
	
	
	
	
	//LEFT
	
	public void ellePrimo(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaArancione[i][0];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaArancione[i][0] = this.matriceFacciaBianca[i][0];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaBianca[i][0] = this.matriceFacciaRossa[t][2];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaRossa[i][2] = this.matriceFacciaGialla[t][0];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaGialla[i][0] = arrayt[i];
		}
		ruotaFacciaAntiorario(matriceFacciaVerde);
	}
	
	public void elle2(){
		this.ellePrimo();
		this.ellePrimo();
	}
	public void elle(){
		this.elle2();
		this.ellePrimo();
	}
	
	
	
	
	//FRONT
	
	public void effe(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaGialla[2][i];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			this.matriceFacciaGialla[2][i] = this.matriceFacciaVerde[t][2];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaVerde[i][2] = this.matriceFacciaBianca[0][i];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaBianca[0][i] = this.matriceFacciaBlu[t][0];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaBlu[i][0] = arrayt[i];
		}
		//Rotazione faccia frontale
		ruotaFacciaOrario(matriceFacciaArancione);
	}
	
	public void effe2(){
		this.effe();
		this.effe();
	}
	
	
	public void effePrimo(){
		this.effe2();
		this.effe();
	}
	
	
	
	
	//BEHIND
	
	public void bi(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaGialla[0][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaGialla[0][i] = this.matriceFacciaBlu[i][2];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaBlu[i][2] = this.matriceFacciaBianca[2][t];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaBianca[2][i] = this.matriceFacciaVerde[i][0];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaVerde[t][0] = arrayt[i];
		}
		//Rotazione faccia opposta
		ruotaFacciaOrario(matriceFacciaRossa);
	}
	
	public void bi2(){
		this.bi();
		this.bi();
	}
	
	
	public void biPrimo(){
		this.bi2();
		this.bi();
	}
	
	
	
	//DOWN
	
	public void downPrimo(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaArancione[2][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaArancione[2][i] = this.matriceFacciaBlu[2][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaBlu[2][i] = this.matriceFacciaRossa[2][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaRossa[2][i] = this.matriceFacciaVerde[2][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaVerde[2][i] = arrayt[i];
		}
		ruotaFacciaAntiorario(matriceFacciaBianca);
	}
	
		public void down2(){
		this.downPrimo();
		this.downPrimo();
	}
	public void down(){
		this.down2();
		this.downPrimo();
	}
	
	
	
	
	
	
	//MIDDLE
	
	
	public void emmePrimo(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaArancione[i][1];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaArancione[i][1] = this.matriceFacciaBianca[i][1];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaBianca[i][1] = this.matriceFacciaRossa[t][1];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaRossa[i][1] = this.matriceFacciaGialla[t][1];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaGialla[i][1] = arrayt[i];
		}
	}
	
	public void emme2(){
		this.emmePrimo();
		this.emmePrimo();
	}
	public void emme(){
		this.emme2();
		this.emmePrimo();
	}
	
	
	
	
	
	
	
	//E
	
	public void ePrimo(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaArancione[1][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			this.matriceFacciaArancione[1][i] = this.matriceFacciaBlu[1][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaBlu[1][i] = this.matriceFacciaRossa[1][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaRossa[1][i] = this.matriceFacciaVerde[1][i];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaVerde[1][i] = arrayt[i];
		}
	}
	
		public void e2(){
		this.ePrimo();
		this.ePrimo();
	}
	public void e(){
		this.e2();
		this.ePrimo();
	}
	
	
	
	
	//ESSE
	public void esse(){
		char[] arrayt = new char[3];
		for (int i = 0; i < arrayt.length; i++){
			arrayt[i] = this.matriceFacciaGialla[1][i];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			this.matriceFacciaGialla[1][i] = this.matriceFacciaVerde[t][1];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaVerde[i][1] = this.matriceFacciaBianca[1][i];
		}
		for (int i = 0, t = 2; i < arrayt.length; i++, t--){
			 this.matriceFacciaBianca[1][i] = this.matriceFacciaBlu[t][1];
		}
		for (int i = 0; i < arrayt.length; i++){
			 this.matriceFacciaBlu[i][1] = arrayt[i];
		}
	}
	
	public void esse2(){
		this.esse();
		this.esse();
	}
	
	
	public void essePrimo(){
		this.esse2();
		this.esse();
	}
	
	
	
	public void sort() throws IOException{ //AGGIORNA
		System.out.println("Inserisci la mossa da effettuare: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		try{
			do{
				switch (st.nextToken().toLowerCase()){
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
			}while (st.hasMoreTokens());
		}
		catch(NoSuchElementException e){
			System.out.println("Mossa non valida\n");
		}
	}
}