import java.io.*;

public class principal {

	private static int numpasswords;
	
	public static void main(String[] args) throws IOException {
		password[] mipass;
		boolean[] fuerte;
		do {
			numpasswords=numpasswords();
		}while(numpasswords<=0);
		mipass= new password[numpasswords];
		fuerte= new boolean[numpasswords];
		mipass=rellenar(fuerte);
		mostrar(mipass,fuerte);
	}

	private static void mostrar(password[] mipass,boolean[] fuerte) {
		for (int i=0;i<fuerte.length;i++) {
			System.out.println(mipass[i].getContrasena()+"  " + fuerte[i]);
		}
		
	}

	private static password[] rellenar(boolean[] fuerte) throws IOException {
		password[] mipass= new password[numpasswords];
		int longitud=0;
		do {
			System.out.println("Indique la longitud, por favor");
			try {
				longitud=Integer.parseInt(introducirdato());
			}catch(NumberFormatException ex) {
				System.out.println("Introduce un número, no un carácter");
				longitud=-1;
			}
		}while(longitud<=0);
		for (int i=0;i<mipass.length;i++) {
			mipass[i]= new password(longitud);
			mipass[i].generarPassword();
			fuerte[i]=mipass[i].esFuerte();
		}
 		return mipass;
	}

	private static String introducirdato() throws IOException {
		String teclado= null;
		BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
		teclado=leer.readLine();
		return teclado;
	}

	private static int numpasswords() throws IOException {
		int numero=0;
		try {
			System.out.println("Indique el número de passwords a introducir");
			numero=Integer.parseInt(introducirdato());
		}catch(NumberFormatException ex) {
			System.out.println("Por favor, introduce un número, no un carácter");
			numero=-1;
		}
		return numero;
	}

}
