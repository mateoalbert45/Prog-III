package P5_EJ6;

public class main {

	public static void main(String[] args) {
		posicion pos1 = new posicion(1, "libre");
		posicion pos2 = new posicion(2, "pisado");
		posicion pos3 = new posicion(3, "pisado");
		posicion pos4 = new posicion(4, "pisado");
		posicion pos5 = new posicion(5, "pisado");
		posicion pos6 = new posicion(6, "libre");
		posicion pos7 = new posicion(7, "pisado");
		posicion pos8 = new posicion(8, "libre");
		posicion pos9 = new posicion(9, "libre");
		posicion pos10 = new posicion(10, "pisado");
		posicion pos11 = new posicion(11, "libre");
		posicion pos12 = new posicion(12, "pisado");
		posicion pos13 = new posicion(13, "pisado");
		posicion pos14 = new posicion(14, "libre");
		posicion pos15 = new posicion(15, "pisado");
		posicion pos16 = new posicion(16, "libre");
		posicion pos17 = new posicion(17, "libre");
		posicion pos18 = new posicion(18, "pisado");
		posicion pos19 = new posicion(19, "pisado");
		posicion pos20 = new posicion(20, "pisado");
		posicion pos21 = new posicion(21, "libre");
		posicion pos22 = new posicion(22, "libre");
		posicion pos23 = new posicion(23, "libre");
		posicion pos24 = new posicion(24, "libre");
		posicion pos25 = new posicion(25, "libre");

		patio p = new patio();
		p.setPosicion(pos1);
		p.setPosicion(pos2);
		p.setPosicion(pos3);
		p.setPosicion(pos4);
		p.setPosicion(pos5);
		p.setPosicion(pos6);
		p.setPosicion(pos7);
		p.setPosicion(pos8);
		p.setPosicion(pos9);
		p.setPosicion(pos10);
		p.setPosicion(pos11);
		p.setPosicion(pos12);
		p.setPosicion(pos13);
		p.setPosicion(pos14);
		p.setPosicion(pos15);
		p.setPosicion(pos16);
		p.setPosicion(pos17);
		p.setPosicion(pos18);
		p.setPosicion(pos19);
		p.setPosicion(pos20);
		p.setPosicion(pos21);
		p.setPosicion(pos22);
		p.setPosicion(pos23);
		p.setPosicion(pos24);
		p.setPosicion(pos25);
		

		p.cargar_matriz();
		//p.imprimir_matriz();
		p.resolver_juego_caballo(0, 3, 0, 3);
		System.out.println(p.getTodoslosresultados());
		// p.imprimir_matriz();
	}

}
