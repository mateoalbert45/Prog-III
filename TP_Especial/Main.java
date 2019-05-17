package progTPE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class Main {

	public static void main(String[] args) {
		Sistema s = new Sistema();
		CargarArchivos(s);
		opciones(s);
	}
	
	public static void opciones(Sistema s) {
		System.out.println("Ingresa 0 para salir");
		System.out.println("Ingresa 1 para listar todos los aeropuertos");
		System.out.println("Ingresa 2 para listar todos las reservas");
		System.out.println("Ingresa 3 para realizar servicio 1");
		System.out.println("Ingresa 4 para realizar servicio 2");
		System.out.println("Ingresa 5 para realizar servicio 3");

		

		int num = -1;
		
		while(num!=0) {
			num = cargar_numero();
			if(num == 1) {
				s.impimir_aeropuertos();
			}
			else if (num == 2) {
				s.imprimir_reservas();
			}
			else if (num == 3) {
				System.out.println("Ingresa el nombre del aeropuerto origen");
				Aeropuerto origen = s.Buscar_Aeropuerto(cargar_palabra());
				System.out.println("Ingresa el nombre del aeropuerto origen");
				Aeropuerto destino = s.Buscar_Aeropuerto(cargar_palabra());
				System.out.println("Ingresa la aerolinea deseada");
				String aerolinea = cargar_palabra();
				Vector <Object> info = s.vuelo_directo(origen, destino, aerolinea);
				escribir_archivo_servicio1(info);
			}
			else if (num ==4) {
				System.out.println("Ingresa el nombre del aeropuerto origen");
				Aeropuerto origen = s.Buscar_Aeropuerto(cargar_palabra());
				System.out.println("Ingresa el nombre del aeropuerto origen");
				Aeropuerto destino = s.Buscar_Aeropuerto(cargar_palabra());
				System.out.println("Ingresa el nombre de la aerolinea que NO deseea utilizar");
				String aerolinea = cargar_palabra();
				Vector<Camino> info = s.Vuelos_Disponibles(origen, destino, aerolinea);
				escribir_archivo_servicio2(info);
			}
			else if (num == 5) {
				System.out.println("Ingresa el nombre del pais origen");
				String origen = cargar_palabra();
				System.out.println("Ingresa el nombre del pais destino");
				String destino = cargar_palabra();
				s.vuelo_directo_pais_a_otro(origen, destino);

			}
		}

		
		
	}
	
	
	public static int cargar_numero() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		int num;
		try {
			num = new Integer(entrada.readLine());
		} catch (Exception exc) {
			num = 0;
		}
		return num;
	}
	
	public static String cargar_palabra() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String palabra;
		try {
			palabra = new String(entrada.readLine());
		} catch (Exception exc) {
			System.out.println( exc );
			palabra = "hola";
		}
		return palabra;
	}
	

	public static void CargarArchivos(Sistema s) {

		String Archivo_Aeropuertos = "src/progTPE/Informacion para setear/Aeropuertos.csv";
		String Archivo_Rutas = "src/progTPE/Informacion para setear/Rutas.csv";
		String Archivo_Reservas = "src/progTPE/Informacion para setear/Reservas.csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(Archivo_Aeropuertos))) {

			while ((line = br.readLine()) != null) {

				String[] aeropuertos = line.split(cvsSplitBy);

				Aeropuerto aeropuerto = new Aeropuerto(aeropuertos[0], aeropuertos[1], aeropuertos[2]);
				s.setAeropuerto(aeropuerto);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedReader br = new BufferedReader(new FileReader(Archivo_Rutas))) {

			while ((line = br.readLine()) != null) {

				String[] rutas = line.split(cvsSplitBy);

				Vector<Aerolinea> aux = new Vector<>();

				Aeropuerto origen = s.Buscar_Aeropuerto(rutas[0]);
				Aeropuerto destino = s.Buscar_Aeropuerto(rutas[1]);
				Double km = Double.parseDouble(rutas[2]);
				boolean cabotaje = Boolean.parseBoolean(rutas[3]);
				Ruta ruta = new Ruta(origen, destino, km, cabotaje);

				if (rutas[3].equals("1")) {
					rutas[3] = "false";
				} else {
					rutas[3] = "true";
				}
				

				String[] aerolineas = rutas[4].split(",");
				for (int i = 0; i < aerolineas.length; i++) {
					aerolineas[i] = aerolineas[i].replaceAll("\\}", "");
					aerolineas[i] = aerolineas[i].replaceAll("\\{", "");
					String[] aerolineasAux = aerolineas[i].split("-");
		
					int numero = Integer.parseInt(aerolineasAux[1]);
					Aerolinea AeroAux = new Aerolinea(aerolineasAux[0], numero);
					ruta.setAerolinea(AeroAux);
				}
				s.setRuta(ruta);

			}
			
			
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(Archivo_Reservas))) {

			while ((line = br.readLine()) != null) {

				String[] reservas = line.split(cvsSplitBy);
				Aeropuerto origen = s.Buscar_Aeropuerto(reservas[0]);
				Aeropuerto destino = s.Buscar_Aeropuerto(reservas[1]);
				int cant = Integer.parseInt(reservas[3]);
				Reserva reserva = new Reserva(origen, destino, reservas[2], cant);
				s.setReserva(reserva);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void escribir_archivo_servicio1(Vector<Object> ruta_info) {
		
		BufferedWriter bw = null;
		try {
			File file = new File("src/progTPE/Informacion salida/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			Object km = ruta_info.elementAt(0);
			Object asientos_disponibles = ruta_info.elementAt(1);
			String contenidoLinea1 = km + ";"+ asientos_disponibles;
			bw.write(contenidoLinea1);
			bw.newLine();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}
	public static void escribir_archivo_servicio2(Vector<Camino> caminos) {
		
		BufferedWriter bw = null;
		try {
			File file = new File("src/progTPE/Informacion salida/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			
			for(int i =0;i<caminos.size();i++) {
				Camino aux = caminos.elementAt(i);
				String contenidoLinea1 = aux.getKilometros() + ";"+ aux.getRutas();
				bw.write(contenidoLinea1);
				bw.newLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}
	
	
	
	
}
