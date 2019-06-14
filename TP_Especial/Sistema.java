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

	public void impimir_aeropuertos() {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			System.out.println("Aeropuerto: " + Aeropuertos.elementAt(i).getNombre());
//			System.out.println("Ciudad: " + aeropuertos_visitados.elementAt(i).getCiudad());
//			System.out.println("Pais: " + aeropuertos_visitados.elementAt(i).getPais());
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

	public Camino camino_corto_backtracking(Aeropuerto actual_destino) {

		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuertos.elementAt(i).setEstado("Sin Visitar");
		}
		Vector<Aeropuerto> aeropuertos_visitados = new Vector<>();
		Vector<Ruta> rutas_visitados = new Vector<>();
		Vector<Camino> caminos = new Vector<>();

		Vector<Camino> caminos_totales = recorrido_backtracking(actual_destino, actual_destino, 0,
				aeropuertos_visitados, rutas_visitados, caminos, 0);

		if (caminos_totales.isEmpty()) {
			System.out.println("No hay una solucion posible");
		}

		return mejor_camino(caminos_totales);// Esto no funciona debido a que no se porque los caminos no guardan el
												// vector
												// de rutas
	}

	private Camino mejor_camino(Vector<Camino> caminos_totales) {
		double cantidad = 10000000.00;
		Camino solucion = null;
		for (int i = 0; i < caminos_totales.size(); i++) {
			if (caminos_totales.elementAt(i).getKilometros() < cantidad) {

				cantidad = caminos_totales.elementAt(i).getKilometros();
				solucion = caminos_totales.elementAt(i);

			}

		}
		return solucion;

	}

	private Vector<Camino> recorrido_backtracking(Aeropuerto actual, Aeropuerto destino, int n,
			Vector<Aeropuerto> aeropuertos_visitados, Vector<Ruta> rutas_visitadas, Vector<Camino> caminos,
			int cantidad_kilometros) {

		if (actual.equals(destino) && n == 1 && aeropuertos_visitados.size() == (Aeropuertos.size())) {

			Camino camino = new Camino(rutas_visitadas, rutas_visitadas.size(), cantidad_kilometros);
			imprimir_info_camino_tpe2parte(camino); // imprimo la informacion aca porque no me guarda el vector de
													// rutas_visitadas cuando lo retorna
			caminos.add(camino);
		} else {

			for (int i = 0; i < actual.getRutas().size(); i++) {
				Ruta temporal = actual.getRutas().elementAt(i);
				Aeropuerto aux = actual.getRutas().elementAt(i).getDestino();

				aeropuertos_visitados.add(actual);
				rutas_visitadas.add(temporal);
				cantidad_kilometros += temporal.getKilometros();

				if (aux.getEstado().equals("Sin Visitar")) {
					if (contiene_menos_2_veces(aeropuertos_visitados, destino)) {

						if (!actual.equals(destino)) {
							actual.setEstado("Visitado");
						}
						recorrido_backtracking(aux, destino, 1, aeropuertos_visitados, rutas_visitadas, caminos,cantidad_kilometros);
						actual.setEstado("Sin Visitar");

					}
				}
				if (actual.equals(destino)) {
					aeropuertos_visitados.remove(aeropuertos_visitados.size() - 1);
					rutas_visitadas.remove(rutas_visitadas.size() - 1);
				} else {
					aeropuertos_visitados.remove(actual);
					rutas_visitadas.remove(temporal);
				}
				cantidad_kilometros -= temporal.getKilometros();
			}
		}
		return caminos;
	}

	private boolean contiene_menos_2_veces(Vector<Aeropuerto> aeropuertos_visitados, Aeropuerto destino) {
		int cantidad = 0;
		for (int i = 0; i < aeropuertos_visitados.size(); i++) {
			if (aeropuertos_visitados.elementAt(i).equals(destino)) {
				cantidad++;
			}
		}
		if (cantidad < 2) {
			return true;
		} else {
			return false;
		}
	}

	// enunciado 2
	// greedy

	public Camino camino_corto_greedy(Aeropuerto actual, Aeropuerto destino) {
		for (int i = 0; i < Aeropuertos.size(); i++) {
			Aeropuertos.elementAt(i).setEstado("Sin Visitar");
		}

		Vector<Aeropuerto> aeropuertos_visitados = new Vector<>();
		Vector<Ruta> rutas_visitadas = new Vector<>();
		double cantidad_kilometros = 0;
		while (aeropuertos_visitados.size() < Aeropuertos.size() && !esNulo(actual.getRutas())) {
			Ruta temporal = getRutaCorta(actual.getRutas());
			Aeropuerto aux = temporal.getDestino();
			cantidad_kilometros += temporal.getKilometros();
			aeropuertos_visitados.add(actual);
			rutas_visitadas.add(temporal);
			actual = aux;
			actual.setEstado("Visitado");

		}

		Camino camino = new Camino(rutas_visitadas, aeropuertos_visitados.size() + 1, cantidad_kilometros);
		imprimir_info_camino_tpe2parte(camino);
		return camino;
	}

	public Ruta getRutaCorta(Vector<Ruta> rutas) {
		double cantidad = 10000000.00;
		Ruta solucion = null;
		for (int i = 0; i < rutas.size(); i++) {
			Ruta temporal = rutas.elementAt(i);
			if (temporal.getKilometros() < cantidad && temporal.getDestino().getEstado() == "Sin Visitar") {
				cantidad = rutas.elementAt(i).getKilometros();
				solucion = rutas.elementAt(i);

			}

		}

		return solucion;
	}

	public boolean esNulo(Vector<Ruta> rutas) {
		double cantidad = 10000000.00;
		int nulo = 0;
		for (int i = 0; i < rutas.size(); i++) {
			Ruta temporal = rutas.elementAt(i);
			if (temporal.getKilometros() < cantidad && temporal.getDestino().getEstado() == "Sin Visitar") {
				cantidad = rutas.elementAt(i).getKilometros();
				nulo = 1;
			}

		}
		if (nulo == 1) {
			return false;
		} else {
			return true;
		}
	}

	public boolean retorna_origen(Vector<Aeropuerto> aeropuertos_visitados) {

		for (int i = 0; i < aeropuertos_visitados.size(); i++) {
			Aeropuerto aux = aeropuertos_visitados.elementAt(0);
			if (aeropuertos_visitados.elementAt(i).equals(aux)) {
				return true;
			}

		}
		return false;
	}

	public void imprimir_info_camino_tpe2parte(Camino c) {
		System.out.println("Camino encontrado ");

		for (int i = 0; i < c.getRutas().size(); i++) {
			Ruta aux = c.getRutas().elementAt(i);
			System.out.println(
					"Este vuelo va desde " + aux.getOrigen().getNombre() + " hasta " + aux.getDestino().getNombre());
		}
		System.out.println("Cantidad de escalas a realizar son " + c.getEscalas());
		System.out.println("Cantidad Kilometros a realizar " + c.getKilometros() + "\n");
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
				return Reservas.elementAt(i).calcular_pasajes_disponibles(cantidad);
			}
		}
		return cantidad;

	}

	public Vector <Camino_servicio3> vuelo_directo_pais_a_otro(String pais_origen, String pais_destino) {
		Vector <Camino_servicio3>  caminos_totales = new Vector<>();
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
								Camino_servicio3 camino = new Camino_servicio3(r,pasajes_disponibles,AeroAux);
								caminos_totales.add(camino);
							}
						}
			

					}
				}

			}
		}
		return caminos_totales;

	}

}
