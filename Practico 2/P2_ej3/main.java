package P2_ej3;

public class main {

	public static void main(String[] args) {
lista_vinc l = new lista_vinc();
Node a = new Node();
Node b = new Node();

l.insertFront(5);
l.insertFront(6);
l.insertFront(1);
l.insertFront(4);
l.insertFront(3);
l.insertFront(2);
l.print();
l.seleccion(a, b);
l.print();

	}

}
