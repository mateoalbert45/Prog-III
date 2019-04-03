package ej6;

public class orden {

	
	public lista elementos_dinstintos(lista a, lista b) {
		iterador m= new iterador(a.first);		
		lista tmp= new lista();	
		
		while(m.hasNext()){ 
			Object n = m.next();			
			if (b.pertenece(n)) {
				System.out.println("el numero " + n.toString() + " pertence a ambas listas");
			}else {
				tmp.insert(n);
			}
		}
	return tmp;	
	}
	
	
}
