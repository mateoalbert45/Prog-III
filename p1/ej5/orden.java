package ej5;

public class orden {

	
	public lista lista_desordenada(lista a, lista b) {
			iterador m= new iterador(a.first);		
			lista tmp= new lista();	
	while(m.hasNext()){ 
		 Node n = m.next();
			//System.out.print(n.getInfo());
			iterador l= new iterador(b.first);
		while(l.hasNext()){
			Node aux2 = l.next();

			if(n.getInfo()==aux2.getInfo()){
				tmp.insert(n.getInfo());
				}
		}
	}
	
	
	tmp.ordenar();
		return tmp;	
		
		
	}
	
	public lista lista_ordenada(lista a, lista b) {
		iterador m= new iterador(a.first);		
		lista tmp= new lista();	
while(m.hasNext()){
	boolean encontro = false;
	 Node n = m.next();
		//System.out.print(n.getInfo());
		iterador l= new iterador(b.first);
		Node aux2 = l.next();
	while(l.hasNext() && encontro==false){

		if(n.getInfo()==aux2.getInfo()){
			System.out.print("B");
			tmp.insert(n.getInfo());
			encontro=true;
			}
		 aux2 = l.next();

	}
}


tmp.ordenar();
	return tmp;	
	
	
}
	
}
