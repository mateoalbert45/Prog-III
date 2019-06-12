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

	public void setRuta(Ruta r) {
		Ruta Opuesta = new Ruta(r.getDestino(), r.getOrigen(), r.getKilometros(), r.getCabotaje());
		for (int a = 0; a < r.getAerolineas().size(); a++) {
			Aerolinea temporal = r.getAerolineas().elementAt(a);
			Opuesta.setAerolinea(temporal);
		}
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuerto aux = Aeropuertos.elementAt(i);
			if (r.getOrigen().equals(aux)) {
				aux.setRuta(r);
				Aeropuerto destino = r.getDestino();
				destino.setRuta(Opuesta);

			}

		}

	}

	public void impimir_aeropuertos(Vector<Aeropuerto> aeropuertos_visitados) {
		for (int i = 0; i < aeropuertos_visitados.size(); i++) {
			System.out.println("Aeropuerto: " + aeropuertos_visitados.elementAt(i).getNombre());
//			System.out.println("Ciudad: " + aeropuertos_visitados.elementAt(i).getCiudad());
//			System.out.println("Pais: " + aeropuertos_visitados.elementAt(i).getPais());
			System.out.println("-----------------------------");

		}
		System.out.println("---dooooouuuu-----");

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
		Vector<Camino> caminos = new Vector<>();
		Vector<Camino> aux = Buscar_Vuelos(origen, destino, Caminos_Posibles, aerolinea, 0, Rutas, caminos);

		return aux;
	}

	private Vector<Camino> Buscar_Vuelos(Aeropuerto actual, Aeropuerto destino, Vector<Aeropuerto> vec,
			String aerolinea, int cantidad_kilometros, Vector<Ruta> Rutas, Vector<Camino> caminos) {

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

					caminos.addAll(Buscar_Vuelos(aux, destino, vec, aerolinea, cantidad_kilometros, Rutas, caminos));

					aux.setEstado("Sin Visitar");
				}
				cantidad_kilometros -= temporal.getKilometros();
				vec.remove(actual);
				Rutas.remove(temporal);

			}
		}
		return caminos;

	}

	// enunciado 2
	// backtracking

	public void dfs(Aeropuerto destino) {

		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuertos.elementAt(i).setEstado("blanco");
		}
		Vector<Aeropuerto> aeropuertos_visitados = new Vector<>();
		Vector<Aeropuerto> lista_nodos = new Vector<>();

//		for(int i =0;i<Aeropuertos.size();i++) {
//			Aeropuerto n= Aeropuertos.elementAt(i);
		dfs_visit(destino, destino, aeropuertos_visitados);

	}

//	public int dfs_visit(Aeropuerto actual, Aeropuerto destino) {
//		actual.setEstado("amarillo");
//		//for(int i=0;i<actual.getRutas().size();i++) {
//			Aeropuerto aux=actual.getRutas().elementAt(0).getDestino();
//
//			if(aux.getEstado().equals("blanco")) {
//						 dfs_visit(aux,destino);
//			}
//
//		//}		
//		actual.setEstado("negro");
//		
//		System.out.println(actual.getNombre());
//		return 0;
//	}

	public void dfs_visit(Aeropuerto actual, Aeropuerto destino, Vector<Aeropuerto> aeropuertos_visitados) {

		actual.getNombre();
		if (aeropuertos_visitados.size() == 3) { //Aeropuertos.size()-1
			aeropuertos_visitados.add(actual);
			System.out.println("hola");
			impimir_aeropuertos(aeropuertos_visitados);

		} else {

			for (int i = 0; i < actual.getRutas().size(); i++) {
////				Ruta temporal = actual.getRutas().elementAt(i);
				Aeropuerto aux = actual.getRutas().elementAt(i).getDestino();
				aux.getNombre();

				//actual.getRutas().remove(temporal);
				
				if (aux.getEstado().equals("blanco")) {
					if (!aeropuertos_visitados.contains(aux)) {
						aeropuertos_visitados.add(actual);
						actual.setEstado("amarillo");

						dfs_visit(aux, destino, aeropuertos_visitados);
						aeropuertos_visitados.remove(actual);
						actual.setEstado("blanco");


					}
				}
//		//		actual.getRutas().add(temporal);


			}

			// }
			// actual.setEstado("negro");

			// System.out.println(actual.getNombre());
		}

	}

	
	
//	public void dfs_visit(Aeropuerto actual, Aeropuerto destino, Vector<Aeropuerto> aeropuertos_visitados, int hola) {
//		
//		actual.getNombre();
//
//
//			for (int i = 0; i < actual.getRutas().size(); i++) {
//				Aeropuerto aux = actual.getRutas().elementAt(i).getDestino();
//				aeropuertos_visitados.add(actual);
//				System.out.println("hola");
//
//				if (aux.equals(destino) && hola != 0) {
//
//					aeropuertos_visitados.add(aux);
//					System.out.println("hola");
//
//					//imprimir_info_camino(camino);
//
//					aeropuertos_visitados.remove(aux);
//
//				} else if (aux.getEstado().equals("Sin Visitar")) {
//
//					aux.setEstado("Visitado");
//					hola=1;
//					dfs_visit(aux, destino, aeropuertos_visitados,1);
//
//					aux.setEstado("Sin Visitar");
//				}
//				aeropuertos_visitados.remove(actual);
//
//			}
//		//		actual.getRutas().add(temporal);
//
//
//			}

			// }
			// actual.setEstado("negro");

			// System.out.println(actual.getNombre());
		

	
	
	
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
				return Reservas.elementAt(i).calcular_pasajes_disponibles(cantidad);
			}
		}
		return cantidad;

	}

	public void vuelo_directo_pais_a_otro(String pais_origen, String pais_destino) {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuerto a = Aeropuertos.elementAt(i);
			if (a.getPais().equals(pais_origen)) {
				for (int b = 0; b < a.getRutas().size(); b++) {

					Ruta r = a.getRutas().elementAt(b);

					if (r.getDestino().getPais().equals(pais_destino)) {
						for (int c = 0; c < r.getAerolineas().size(); c++) {
							String AeroAux = r.getAerolineas().elementAt(c).GetNombre();
							int aux = r.cant_pasajes(AeroAux);
							int pasajes_disponibles = Cant_Pasajes_Disponibles(r, AeroAux, aux);
							System.out.println("Cantidad de pasajes disponibles " + pasajes_disponibles);

							if (pasajes_disponibles > 0) {
								System.out.println("Aeropuerto origen " + r.getOrigen().getNombre()
										+ " Aeropuerto destino " + r.getDestino().getNombre());
								System.out.println("Aerolinea: " + AeroAux);
							}
							System.out.println("----");
						}
						System.out.println("---------------------------- ");

					}
				}

			}
		}

	}

}
