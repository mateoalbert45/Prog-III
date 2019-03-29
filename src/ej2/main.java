package ej2;

public class main {

	public static void main(String[] args) {
		lista_vinc l = new lista_vinc();
		l.insertFront(5);
		l.insertFront(8);
		l.insertFront(1);
		l.insertFront(4);
		System.out.println(l.ordenado(12, l.get_first()));
	}

}
