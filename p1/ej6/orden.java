package ej6;

public class orden {

	
	public lista elementos_dinstintos(lista a, lista b) {
		iterador m= new iterador(a.first);		
		lista tmp= new lista();	
		
		while(m.hasNext()){ 
			Node n = m.next();			
			if (b.pertenece(n.getInfo())) {
				System.out.println("el numero " + n.getInfo() + " pertence a ambas listas");
			}else {
				tmp.insert(n.getInfo());
			}
		}
	return tmp;	
	}
	
	
}
