package P5_EJ2;

public class direccion {
	private Integer numero;
	private boolean norte;
	private boolean sur;
	private boolean este;
	private boolean oeste;


	public direccion(Integer numero, boolean n, boolean s, boolean e, boolean o){
	    this.numero = numero;
	    norte = n;
	    sur = s;
	    este = e;
	    oeste = o;
	}


	public Integer getNumero(){
	    return numero;
	}

	public boolean getNorte(){
	    return norte;
	}public boolean getSur(){
	    return sur;
	}public boolean getEste(){
	    return este;
	}public boolean getOeste(){
	    return oeste;
	}
	
	


}
