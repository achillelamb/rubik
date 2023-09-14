package rubik;
import java.io.IOException;

import rubik.Cubo;

public class Main {
	public static void main(String[] args) throws IOException{
		Cubo cubo = new Cubo();
		cubo.riempiTuttaCorrettamente();
		cubo.scombina();
		System.out.println(cubo.stampaCubo());
		while (!cubo.haiVinto()){
			cubo.sort();
			System.out.println(cubo.stampaCubo());
		}
		System.out.println("LO HAI RISOLTO!!!!");
	}

}
