package ej1;

import ej2.Node;

public class lista {
 int[] hola = new int[9];
 
 
 public void insertar() {
	 hola[0]= 0;
	 hola[1]= 1;
	 hola[2]= 2;
	 hola[3]= 3;
	 hola[4]= 4;
	 hola[5]= 5;
	 hola[6]= 6;
	 hola[7]= 7;
	 hola[8]= 8;
	 
 }
 
 public int get( int i) {
	 return hola[i];
 }
 
 public boolean ordenado(int a, int b) {
	 if(b==hola.length) {
		 return true;
	 }else {
		 if(hola[a]<hola[b]) {
			 return ordenado(a+1,b+1); 
		 }
		 else {
				 return false;
			 }
		 }
	 }
 
	 
	 
	 
 
 
 
 public boolean ordenado(Object a, Node b) {
	 if(b==null) {
		 return false;
	 }else {
		 if(a.equals(b.getInfo())) {
			 return true;
		 }else {
			 return ordenado(a,b.getNext());
		 }
		 
	 }		 
 }
 
 
}
