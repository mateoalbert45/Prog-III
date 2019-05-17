package progTPE;

import java.util.Vector;

public class Sistema {
	private Vector<Aeropuerto> Aeropuertos = new Vector<>();
	private Vector<Reserva> Reservas = new Vector<>();
	// private Vector<Ruta> Rutas = new Vector<>();

	public void setAeropuerto(Aeropuerto a) {
		Aeropuertos.add(a);
	}

	public void setReserva(Reserva a) {
		Reservas.add(a);
	}

	public void setRuta(Ruta r) {
		Ruta Opuesta = new Ruta(r.getDestino(), r.getOrigen(), r.getKilometros(), r.getCabotaje());
		for(int a = 0; a< r.getAerolineas().size();a++) {
			Aerolinea temporal = r.getAerolineas().elementAt(a);
			Opuesta.setAerolinea(temporal);
		}
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuerto aux = Aeropuertos.elementAt(i);
			if (r.getOrigen().equals(aux)) {
				aux.setRuta(r);
				Aeropuerto destino = r.getDestino();
				destino.setRuta(Opuesta);
				// System.out.println("dasdsadsadsadasd");

			}

		}
		
		

	}

	public void impimir_aeropuertos() {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			System.out.println("Aeropuerto: " + Aeropuertos.elementAt(i).getNombre());
			System.out.println("Ciudad: " + Aeropuertos.elementAt(i).getCiudad());
			System.out.println("Pais: " + Aeropuertos.elementAt(i).getPais());
			System.out.println("-----------------------------");

		}
	}

	public void imprimir_reservas() {
		for (int i = 0; i < Reservas.size(); i++) {
			Reserva aux = Reservas.elementAt(i);
			System.out.println("Aeropuerto origen: " + aux.getOrigen().getNombre());
			System.out.println("Aeropuerto Destino: " + aux.getDestino().getNombre());
			System.out.println("Nombre de la Aerolinea: " + aux.getNombreAerolinea());
			System.out.println("Cantidad de Asientos Reservados: " + aux.getAsientos());
			System.out.println("-----------------------------");

		}
	}


	public Aeropuerto Buscar_Aeropuerto(String s) {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			if (Aeropuertos.elementAt(i).getNombre().equals(s)) {
				return Aeropuertos.elementAt(i);
			}
		}
		return null;

	}

	public Vector<Camino> Vuelos_Disponibles(Aeropuerto origen, Aeropuerto destino, String aerolinea) {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuertos.elementAt(i).setEstado("Sin Visitar");
		}
		Vector<Aeropuerto> Caminos_Posibles = new Vector<>();
		Vector<Ruta> Rutas = new Vector<>();
		Vector<Camino> caminos = new  Vector<>();
		Vector<Camino> aux = Buscar_Vuelos(origen, destino, Caminos_Posibles, aerolinea, 0, Rutas,caminos);
		
		return aux;
	}

	private Vector<Camino> Buscar_Vuelos(Aeropuerto actual, Aeropuerto destino, Vector<Aeropuerto> vec, String aerolinea,	
			int cantidad_kilometros, Vector<Ruta> Rutas, Vector<Camino> caminos) {

		
		for (int i = 0; i < actual.getRutas().size(); i++) {
			Ruta temporal = actual.getRutas().elementAt(i);
			if (temporal.contiene_aerolinea_distinta_a(aerolinea)) {
				Aeropuerto aux = temporal.getDestino();
				vec.add(actual);
				Rutas.add(temporal);

				cantidad_kilometros += temporal.getKilometros();
				if (aux.equals(destino)) {

					vec.add(aux);
					
					Camino camino = new Camino(Rutas, Rutas.size(), cantidad_kilometros);
					caminos.add(camino);
					imprimir_info_camino(camino);
				
					vec.remove(aux);

				} else if (aux.getEstado().equals("Sin Visitar")) {

					aux.setEstado("Visitado");

					caminos.addAll(Buscar_Vuelos(aux, destino, vec, aerolinea, cantidad_kilometros, Rutas,caminos)) ;

					aux.setEstado("Sin Visitar");
				}
				cantidad_kilometros -= temporal.getKilometros();
				vec.remove(actual);
				Rutas.remove(temporal);

			}
		}
		return caminos;

	}

	public void imprimir_info_camino(Camino c) {
		System.out.println("Camino encontrado ");
		for (int i = 0; i < c.getRutas().size(); i++) {
			Ruta aux = c.getRutas().elementAt(i);
			System.out.println("Las aerolineas disponible para ir desde " + aux.getOrigen().getNombre() + " hasta "
					+ aux.getDestino().getNombre() + " son " + aux.getAerolineas_String());
		}
		System.out.println("Cantidad de escalas a realizar son " + c.getEscalas());
		System.out.println("Cantidad Kilometros a realizar " + c.getKilometros() + "\n");
	}

	public Vector<Object> vuelo_directo(Aeropuerto origen, Aeropuerto destino, String aerolinea) {
		Vector<Object> info = new Vector<Object>(); 
		for (int i = 0; i < origen.getRutas().size(); i++) {
			Ruta r = origen.getRutas().elementAt(i);
			if (r.getDestino().equals(destino)) {
				int aux = r.cant_pasajes(aerolinea);
				if (aux > 0) {
					info.add(r.getKilometros());
					info.add(Cant_Pasajes_Disponibles(r, aerolinea, aux));
					System.out.println();
				}

			}
		}
		return info;
	}

	public int Cant_Pasajes_Disponibles(Ruta r, String aerolinea, int cantidad) {
		for (int i = 0; i < Reservas.size(); i++) {
			if (Reservas.elementAt(i).es_igual(r.getOrigen(), r.getDestino(), aerolinea)) {
				// if(aux>=0) {
				// System.out.println("soy i " + i + " de la ruta con origen " +
				// r.getOrigen().getNombre());
				// System.out.println("soy aux "+aux);
				return Reservas.elementAt(i).calcular_pasajes_disponibles(cantidad);
			}
		}
		// else if(aux==Reservas.size) {
		// return cantidad
		// }

		// System.out.println("asdasdsad");
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
							// System.out.println("dasdsadsadasdasdasd "+AeroAux);
							int pasajes_disponibles = Cant_Pasajes_Disponibles(r, AeroAux, aux);
							System.out.println("Cantidad de pasajes disponibles " + pasajes_disponibles);

							if (pasajes_disponibles > 0) {
								System.out.println("Aeropuerto origen " + r.getOrigen().getNombre() + " Aeropuerto destino "
										+ r.getDestino().getNombre());
								System.out.println("Aerolinea: " + AeroAux);
							}
							System.out.println("----");
						}
						System.out.println("---------------------------- ");

						

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
