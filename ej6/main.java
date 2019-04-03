package ej6;


public class main {

	public static void main(String[] args) {
		lista l1 = new lista();	
		l1.insert(3);
		l1.insert(5);
		l1.insert(9);
		l1.insert(1);
		l1.insert(7);

		lista l2 = new lista();
		l2.insert(4);
		l2.insert(1);
		l2.insert(5);
		l2.insert(9);

		orden o = new orden();
		o.elementos_dinstintos(l1, l2).print();
		
	}

}
