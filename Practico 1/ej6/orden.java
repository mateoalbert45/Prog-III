package ej6;

public class orden {

	
	public lista elementos_dinstintos(lista a, lista b) {
		iterador ita = a.getiterador();		
		lista tmp= new lista();	
		
		while(ita.hasNext()){ 
			Object n = ita.next();			
			if (b.pertenece(n)) {
				System.out.println("el numero " + n.toString() + " pertence a ambas listas");
			}else {
				tmp.insert(n);
			}
		}
	return tmp;	
	}
	
	
}
