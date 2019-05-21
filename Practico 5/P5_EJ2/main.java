package P5_EJ2;

public class main {

	public static void main(String[] args) {
		direccion d1 = new direccion(6,false,true,true,false);
		direccion d2 = new direccion(2,false,true,true,true);
		direccion d3 = new direccion(3,false,true,false,true);
		direccion d4 = new direccion(7,true,true,true,false);
		direccion d5 = new direccion(8,true,true,true,true);
		direccion d6 = new direccion(1,true,true,false,true);
		direccion d7 = new direccion(4,true,false,true,false);
		direccion d8 = new direccion(5,true,false,true,true);
		direccion d9 = new direccion(9,true,false,false,true);
		laberinto l = new laberinto();
		l.setDireccion(d1);
		l.setDireccion(d2);
		l.setDireccion(d3);
		l.setDireccion(d4);
		l.setDireccion(d5);
		l.setDireccion(d6);
		l.setDireccion(d7);
		l.setDireccion(d8);
		l.setDireccion(d9);	
		l.cargar_matriz();
		l.resolver_tablero(2, 0, 2, 2);
	//l.imprimir_matriz();
	
	}

}
