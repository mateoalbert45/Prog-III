package P5_EJ3;

public class main {

	public static void main(String[] args) {
		suma s = new suma();
		s.setnumero(1);
		s.setnumero(2);
		s.setnumero(3);
		s.setnumero(4);
		s.setnumero(5);
		//s.setnumero(6);
		//s.setnumero(7);
	//	s.setnumero(8);
		s.encontrar_numero();
		System.out.print(s.gettotal());
	}

}
