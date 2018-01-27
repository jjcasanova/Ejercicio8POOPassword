
public class password {

	private int longitud;
	private String contrasena;
	
	public password() {
		longitud=8;
	}

	public password(int longitud) {
		this.longitud=longitud;
	}
	
	protected boolean esFuerte() {
		int numMays=0,numMin=0,num=0;
		for (int i=0;i<contrasena.length();i++) {
			if (((int)contrasena.charAt(i))>=65 && ((int)contrasena.charAt(i))<=90) numMays++;
			else if (((int)contrasena.charAt(i))>=97 && ((int)contrasena.charAt(i))<=122) numMin++;
			else num++;
		}
		if (numMays>2 && numMin>1 && num>5) {
			return true;
		}else return false;
	}
	
	protected void generarPassword() {
		contrasena="";
		int[] aleatorio= new int[longitud];
		for (int i=0;i<longitud;i++) {
			do {
				aleatorio[i]=(int)Math.floor(Math.random()*(122-48+1)+48);
			}while((aleatorio[i]>=58 && aleatorio[i]<=64) || (aleatorio[i]>=91 && aleatorio[i]<=96));
			contrasena+=Character.toString((char)aleatorio[i]);
		}
	}

	protected int getLongitud() {
		return longitud;
	}

	protected String getContrasena() {
		return contrasena;
	}
	
	protected void setLongitud(int longitud) {
		this.longitud=longitud;
	}
}
