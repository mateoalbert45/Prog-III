package TP_Especial;

import java.util.Vector;

import P3_EJ2.node;

public class Sistema {
	private Vector<Aeropuerto> Aeropuertos = new Vector<>();
	private Vector<Reserva> Reservas = new Vector<>();

	public void setAeropuerto(Aeropuerto a) {
		Aeropuertos.add(a);
	}

	public void setReserva(Reserva a) {
		Reservas.add(a);
	}

	public void dfs(Aeropuerto origen, Aeropuerto destino, Aerolinea aerolinea) {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuertos.elementAt(i).setEstado("Sin Visitar");
		}
		Vector<Aeropuerto> Caminos_Posibles = new Vector<>();
		dfs_visit(origen, destino, Caminos_Posibles,aerolinea,0);
	}

	public int dfs_visit(Aeropuerto actual, Aeropuerto destino, Vector<Aeropuerto> vec, Aerolinea aerolinea, int cantidad_kilometros) {

		for (int i = 0; i < actual.getRutas().size(); i++) {
			Ruta temporal = actual.getRutas().elementAt(i);
			if(temporal.contiene_aerolinea_distinta_a(aerolinea)) {
				Aeropuerto aux = temporal.getDestino();
				vec.add(actual);
				cantidad_kilometros += temporal.getKilometros();
				System.out.println(cantidad_kilometros);

				if (aux.equals(destino)) {
					vec.add(aux);
					System.out.println("Cantidad Kilometros a realizar " + cantidad_kilometros);
					imprimir_vector(vec);
					System.out.println("Camino encontrado \n");
					cantidad_kilometros = 0;
					vec.remove(aux);

				} else if (aux.getEstado().equals("Sin Visitar")) {
					aux.setEstado("Visitado");

					cantidad_kilometros = dfs_visit(aux, destino, vec,aerolinea,cantidad_kilometros);

					aux.setEstado("Sin Visitar");
				}

				vec.remove(actual);
			}
			}
			return cantidad_kilometros;


	}

	public void imprimir_vector(Vector<Aeropuerto> a) {
		System.out.println("Cantidad de escalas a realizar " + a.size());
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.elementAt(i).getNombre());
		}
	}

	public void vuelo_directo(Aeropuerto origen, Aeropuerto destino, String aerolinea) {
		for (int i = 0; i < origen.getRutas().size(); i++) {
			Ruta r = origen.getRutas().elementAt(i);
			if (r.getDestino().equals(destino)) {
				int aux = r.cant_pasajes(aerolinea);
				if (aux >= 0) {
					System.out.println("hola");

					System.out.println(r.getKilometros());
					System.out.println(Cant_Pasajes_Disponibles(r, aerolinea, aux));
				}

			}
		}
	}

	public int Cant_Pasajes_Disponibles(Ruta r, String aerolinea, int cantidad) {
		for (int i = 0; i < Reservas.size(); i++) {
			return Reservas.elementAt(i).es_igual(r.getOrigen(), r.getDestino(), aerolinea, cantidad);
		}

		return cantidad;

	}
}
