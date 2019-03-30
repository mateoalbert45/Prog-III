package ej2;

public class array {
	int[] numeros = new int[5];
	
	
	
	
	
	public void  insertar(int n) {
	        int[] newarray = new int[numeros.length];
	        newarray[0] = n;
	        for(int i = 0;i<numeros.length-1;i++){
	        	newarray[i+1] = numeros[i];
	        }
	        numeros = newarray;
	}
	
	public int  buscarpos(int n) {
		return numeros[n];
		
	}
	
	public int  size() {
		return numeros.length;
		
	}
}
