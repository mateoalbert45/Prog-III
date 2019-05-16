package progTPE;

import java.util.Vector;

public class Sistema {
	private Vector<Aeropuerto> Aeropuertos = new Vector<>();
	private Vector<Reserva> Reservas = new Vector<>();

	public void setAeropuerto(Aeropuerto a) {
		Aeropuertos.add(a);
	}

	public void setReserva(Reserva a) {
		Reservas.add(a);
	}
	
	
	public void holaxd() {
		System.out.println(Aeropuertos.elementAt(1).getNombre());
	}

	public void dfs(Aeropuerto origen, Aeropuerto destino, Aerolinea aerolinea) {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuertos.elementAt(i).setEstado("Sin Visitar");
		}
		Vector<Aeropuerto> Caminos_Posibles = new Vector<>();
		Vector<Ruta> Rutas = new Vector<>();
		dfs_visit(origen, destino, Caminos_Posibles, aerolinea, 0, Rutas);
	}

	public int dfs_visit(Aeropuerto actual, Aeropuerto destino, Vector<Aeropuerto> vec, Aerolinea aerolinea,
			int cantidad_kilometros, Vector<Ruta> Rutas) {

		for (int i = 0; i < actual.getRutas().size(); i++) {
			Ruta temporal = actual.getRutas().elementAt(i);
			if (temporal.contiene_aerolinea_distinta_a(aerolinea)) {
				Aeropuerto aux = temporal.getDestino();
				vec.add(actual);
				Rutas.add(temporal);

				// System.out.println(temporal.getDestino().getNombre());
				// System.out.println(cantidad_kilometros);
				cantidad_kilometros += temporal.getKilometros();
				if (aux.equals(destino)) {

					vec.add(aux);
					imprimir_vector_rutas(Rutas);

					System.out.println("Cantidad Kilometros a realizar " + cantidad_kilometros);

					imprimir_vector(vec);

					System.out.println("Camino encontrado \n");
					// cantidad_kilometros = 0;
					vec.remove(aux);

				} else if (aux.getEstado().equals("Sin Visitar")) {
					// cantidad_kilometros += temporal.getKilometros();
					// System.out.println("sdfgidsfjoisdfoinsfd "+actual.getNombre());

					aux.setEstado("Visitado");

					cantidad_kilometros = dfs_visit(aux, destino, vec, aerolinea, cantidad_kilometros, Rutas);

					aux.setEstado("Sin Visitar");
				}
				cantidad_kilometros -= temporal.getKilometros();
				vec.remove(actual);
				Rutas.remove(temporal);

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

	public void imprimir_vector_rutas(Vector<Ruta> a) {
		// System.out.println("Cantidad de escalas a realizar " + a.size());
		for (int i = 0; i < a.size(); i++) {
			Ruta aux = a.elementAt(i);
			System.out.println("Las aerolineas disponible para ir desde " + aux.getOrigen().getNombre() + " hasta "
					+ aux.getDestino().getNombre() + " son " + aux.getAerolineas_String());

		}
	}

	public void vuelo_directo(Aeropuerto origen, Aeropuerto destino, String aerolinea) {
		for (int i = 0; i < origen.getRutas().size(); i++) {
			Ruta r = origen.getRutas().elementAt(i);
			if (r.getDestino().equals(destino)) {
				int aux = r.cant_pasajes(aerolinea);
				if (aux > 0) {
					System.out.println("hola");

					System.out.println(r.getKilometros());
					System.out.println(Cant_Pasajes_Disponibles(r, aerolinea, aux));
				}

			}
		}
	}

	public int Cant_Pasajes_Disponibles(Ruta r, String aerolinea, int cantidad) {
		for (int i = 0; i < Reservas.size(); i++) {
			if(Reservas.elementAt(i).es_igual(r.getOrigen(), r.getDestino(), aerolinea, cantidad)){
			//if(aux>=0) {
				//System.out.println("soy i " + i + " de la ruta con  origen " + r.getOrigen().getNombre());
				//System.out.println("soy aux "+aux);
			return Cantidad_pasajes_disponibles(cantidad);
			}
			}
			//else if(aux==Reservas.size) {
			//	return cantidad
			//}
		}
		//System.out.println("asdasdsad");
		return cantidad;

	}

	public void vuelo_directo_pais_a_otro(String pais_origen, String pais_destino) {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuerto a = Aeropuertos.elementAt(i);
			if (a.getPais().equals(pais_origen)) {
				for (int b = 0; b < a.getRutas().size(); b++) {

					Ruta r = a.getRutas().elementAt(b);
					// System.out.println(r.getOrigen().getPais() + " FDFSDF " +
					// r.getDestino().getPais());

					if (r.getDestino().getPais().equals(pais_destino)) {
						for (int c = 0; c < r.getAerolineas().size(); c++) {
							String AeroAux = r.getAerolineas().elementAt(c).GetNombre();
							int aux = r.cant_pasajes(AeroAux);
							//System.out.println("dasdsadsadasdasdasd  "+AeroAux);
							int pasajes_disponibles = Cant_Pasajes_Disponibles(r, AeroAux, aux);
							System.out.println("soy la cantidad de pasajes disponibles " + pasajes_disponibles);

							if (pasajes_disponibles > 0) {
								System.out.println("país origen " + r.getOrigen().getNombre() + " país destino "
										+ r.getDestino().getNombre());
							}
						}
						
							// int aux = r.cant_pasajes(aerolinea);

							// if (aux >= 0) {
							// System.out.println("hola");

							// System.out.println(r.getKilometros());
							// System.out.println(Cant_Pasajes_Disponibles(r, aerolinea, aux));
							// }

						
					}
				}

			}
		}

	}

}
