package auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Vehiculo;

public class Practicas {

	
	
	//************************************************************************************************
	// ******************************SEGUNDA EVALUACION***********************************************
	//************************************************************************************************
	
	
	
	//******************************introLista con ArrayList******************************************

	public ArrayList<Estudiante> introListas() {
		ArrayList<Estudiante> listaE;
		listaE = new ArrayList<Estudiante>();
		Estudiante est1 = new Estudiante(123);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		int tam = listaE.size();
		Estudiante est2 = new Estudiante(321);
		listaE.add(0, est2);
		listaE.remove(listaE.size() - 1);
			// listaE.set(0, est1);
		for (Estudiante estudiante : listaE) {
			// System.out.println(estudiante.getCodGrupo());
		}
		for (int i = 0; i < listaE.size(); i++) {
			// System.out.println(listaE.get(i).getCodGrupo());
		}

			 System.out.println("fin introListas");
		return listaE;

	}

	
	//****************** Leer una matriz de int y devolverla como ArrayList**************************

	public ArrayList<ArrayList<Integer>> convierteMatrizArrayLista(int[][] matriz) {

		ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();
		for (int[] filaMatriz : matriz) {
			// crear alist
			ArrayList<Integer> filaLista = new ArrayList<Integer>();
			for (int numero : filaMatriz)
				filaLista.add(numero);
			resultado.add(filaLista);
		}
		return resultado;
	}
	
	//********************************introMapas Mapas, clase HashMap*******************************

	public HashMap<String, Estudiante> introMapas() {
		// la clave representa el nif del Estudiante
		HashMap<String, Estudiante> resultado = new HashMap<String, Estudiante>();
		Estudiante est = new Estudiante(123, "435G", "Paco", 'M', null, 180, null, null);
		resultado.put(est.getNif(), est);
		Estudiante estudiante = resultado.get("435G");
		Estudiante est2 = new Estudiante(321, "435G", "Carlos", 'M', null, 180, null, null);

		resultado.put("435G", est2);
		resultado.put("123T", new Estudiante(123, "123T", "Pepe", 'M', null, 180, null, null));
		Set<String> claves = resultado.keySet();
		for (String clave : claves) {
			// System.out.println(resultado.get(clave).getNombre());
		}

		return resultado;
	}

	//**********************************leerFicheroTexto*********************************************
	
	public void leerFicheroTexto() {
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/personas.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea; 
			
			int acumulado = 0;
			int contador = 0;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {

				
				//String[] campos = linea.split("&&");
				//String[] campos = linea.split("%");
					//if (resultado.get)
				//System.out.println(linea);
				//System.out.println(calculaEdad(campos[2]));
	
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	//*************************************resumenVentasPorVendedor*********************************
	
	public HashMap<String,Float> resumenVentasPorVendedor( HashMap<String, ArrayList<Float>> ventas){
		HashMap<String, Float> resultado = new HashMap<String,Float>();
		//recorrer hm de entrada creando el de salida.
		
		Set<String> claves = ventas.keySet();
		
		for (String elementoClave : claves) {
			
			// System.out.println(resultado.get(clave).getNombre());
			
			for (Float elementoValor : ventas.get(elementoClave)){
				
				resultado.put(elementoClave, elementoValor);
			}
		}
		
		return resultado;
	}
		
	//******************************************calculaEdad String************************************
	
	public int calculaEdad(String fechaNacimiento) { // ddmmaaaa
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		System.out.printf("Tu edad es: %s años, %s meses y %s días", periodo.getYears(), periodo.getMonths(),
				periodo.getDays());
		return periodo.getYears();
	}
		
	//***********************leer ficheroTexto con ArrayList*****************************************
	
	public ArrayList<String> leerFicheroTextoArrayList(String rutaFichero) {
		ArrayList<String>  resultado = new ArrayList<String>();
			try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				resultado.add(linea);
			}
			fr.close();//cierra el fichero
			br.close();//cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	//******************************leer fichero con HashMap******************************************
	public HashMap<String, String> leerFicheroTextoHashMap(String rutaFichero) {
		HashMap<String, String> resultado = new HashMap<String, String>();//la clave es el dni, el valor es la  linea que coincide con el dni.
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				String[] clave = linea.split("&&");//cuchillo de corte, corta por la cadena &&
				resultado.put(clave[0], linea);
				}
			fr.close();//cierra el fichero
			br.close();//cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	//***********************************EJERCICIO RESUMENVENTAS*************************************************
	
	public HashMap<String,ArrayList<Float>> resumenVentasVendedor(String rutaFichero){
		HashMap<String,ArrayList<Float>> resultado = new HashMap<String,ArrayList<Float>>();
	
		try {
			FileReader fr = new FileReader(rutaFichero);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null) {
				String fechaV = linea.split("%")[0];
				String idV = linea.split("%")[1];
				float importeV = Float.parseFloat(linea.split("%")[2]);
				if (!resultado.containsKey(idV)) { //(resultado.get(idV)== null)
					ArrayList<Float> lista = new ArrayList<Float>();
					lista.add(importeV);
					resultado.put(idV, lista );					
				} else {
					ArrayList<Float> lista = resultado.get(idV);
					lista.add(importeV);
					resultado.put(idV, lista );
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}
	
	//**********************************************************************************************************

	// private static String[] diasSemana = { "lunes", "martes", "miercoles",
	// "jueves", "viernes", "sábado", "domingo" };

	public boolean esPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}

		return true;
	}

	public int[] numerosPrimos(int cuantos) {
		int[] primos = new int[cuantos];
		int i = 0;
		int j = 1;
		while (i < cuantos) {
			if (esPrimo(j))
				primos[i++] = j;
			j++;
		}
		return primos;
	}

	public int[] numerosFibonacci(int cuantos) {
		int[] numeros = new int[cuantos];
		int x = 0;
		int y = 1;
		int z;
		numeros[0] = x;
		numeros[1] = y;
		for (int i = 2; i < cuantos; i++) {
			z = x + y;
			numeros[i] = z;
			x = y;
			y = z;
		}
		return numeros;
	}

	// LIGA: Obtener clasificación a partir de resultados
	public int[] obtenerClasificacion(String[][] goles) {
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int i = 0; i < goles.length; i++)
			for (int j = 0; j < goles[i].length; j++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public int[] obtenerClasificacion2(String[][] goles) {
		// la diferencia con el anterior es que recorre la
		// matriz por columnas
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int j = 0; j < goles[0].length; j++)
			for (int i = 0; i < goles.length; i++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public Equipo[] obtenerClasificacion3(int[][] puntosJornadas) {
		Equipo[] clasificacion = new Equipo[5];
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < puntosJornadas[0].length; j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.length; i++)
				e.setPuntos(e.getPuntos() + puntosJornadas[i][j]);
			clasificacion[j] = e;
		}

		return clasificacion;
	}

	public boolean validarNif(String nif) {
		char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		if (nif.length() != 9)
			return false;
		String numeros = nif.substring(0, 8);
		// System.out.println(numeros);
		int numerosOK;
		try {
			numerosOK = Integer.parseInt(numeros);
		} catch (NumberFormatException e) {
			return false;
		}
		int resto = numerosOK % 23;
		if (letrasValidas[resto] != nif.charAt(8))
			return false;
		return true;
	}

	// ORDENACION
	public void ordenaEnteros(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] > numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
	}

	public void ordenaClasificacion(int[] numeros, String[] equipos) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] < numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
					String aux2 = equipos[i];
					equipos[i] = equipos[j];
					equipos[j] = aux2;
				}
	}
	// mezcla dos arrays ordenados

	public int[] mezclaArrays(int[] l1, int[] l2) {
		int i = 0, j = 0, k = 0;
		int[] resultado = new int[l1.length + l2.length];

		while (l1[i] != Integer.MAX_VALUE || l2[j] != Integer.MAX_VALUE) {
			if (l1[i] < l2[j])
				resultado[k] = l1[i++];
			else
				resultado[k] = l2[j++];
			k++;

			if (i == l1.length)
				l1[--i] = Integer.MAX_VALUE;

			if (j == l2.length)
				l2[--j] = Integer.MAX_VALUE;
		}
		return resultado;
	}

	public void ordenaCadenas(String[] cadenas) {
		for (int i = 0; i < cadenas.length - 1; i++)
			for (int j = i + 1; j < cadenas.length; j++)
				if (cadenas[i].compareTo(cadenas[j]) > 0) {
					String aux = cadenas[i];
					cadenas[i] = cadenas[j];
					cadenas[j] = aux;
				}

	}

	public void ordenaEstudiantes(Estudiante[] estudiantes) {
		// ejemplo de uso de la interfaz Comparable
		// debe implementarse el método compareTo

		for (int i = 0; i < estudiantes.length - 1; i++)
			for (int j = i + 1; j < estudiantes.length; j++)
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					Estudiante aux = estudiantes[i];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}
	}

	public float calculaSaldo(float saldoInicial, float[] movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.length; i++)
			saldoFinal += movimientos[i];
		return saldoFinal;
	}
//*****************************************calculaSaldo ArrayList****************************************************************
	
	public float calculaSaldo( float saldoInicial, ArrayList<Float> movimientos) {
		float saldoFinal = saldoInicial;
		for (Float elemento : movimientos) {
			
			saldoFinal += elemento;
		}
			
		return saldoFinal;
	}
//*************************************Calcula Saldo con lectura de fichero 08/02/2018********************************************************************
	
	public float calculaSaldo(float saldoInicial, String rutaFicheroMovs) {
		float saldoFinal = saldoInicial;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/saldo.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea; 
			
			
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {

				
				String[] campos = linea.split("#");
				saldoFinal += Float.parseFloat(campos[1]);
				
				System.out.println(campos[0] + " " + campos[1]);
				//String[] campos = linea.split("%");
					//if (resultado.get)
				//System.out.println(linea);
				//System.out.println(calculaEdad(campos[2]));
	
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return saldoFinal;
	}
	
	
	
	
	//*********************************************************************************************************
	
	public int[] convierteCadenasANumeros(String[] cadenas) {
		int[] resultado = new int[cadenas.length];
		for (int i = 0; i < resultado.length; i++) {

			try {

				resultado[i] = Integer.parseInt(cadenas[i]);
			} catch (NumberFormatException e) {

				resultado[i] = -1;
			}
		}
		return resultado;
	}

	public ArrayList<Integer> convierteCadenasANumeros(ArrayList<String> cadenas) {
		// int[] resultado = new int[cadenas.length];
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		// for (int i = 0; i < resultado.length; i++) {
		for (String cadena : cadenas) {
			try {

				// resultado[i] = Integer.parseInt(cadenas[i]);
				resultado.add(Integer.parseInt(cadena));
			} catch (NumberFormatException e) {

				// resultado[i] = -1;
				resultado.add(-1);
			}
		}
		return resultado;
	}

	public void muestraNumeros() {

		int x = 0;
		while (x <= 1000) {
			System.out.println("x: " + x);
			x++;
		}
	}

	public void muestraNumeros(int min, int max) {

		if (min <= max) {
			int x = min;
			while (x <= max) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros2(int min, int max) {

		if (min <= max) {
			int x = min;
			do {
				System.out.println("x: " + x);
				x++;
			} while (x <= max);
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros3(int min, int max) {
		int x = min;
		if (min <= max) {
			// for (int x = min; x < max; x++) {
			// for (;;) {
			while (true) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void generaAleatorios(int cuantos, int inferior, int superior) // max 30, min 10
	{

		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + (int) (Math.random() * (superior - inferior + 1)));

	}

	public void generaAleatorios2(int cuantos, int inferior, int superior) // max 30, min 10
	{

		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
	}

	public int[] generaAleatorios3(int cuantos, int inferior, int superior) // max 30, min 10
	{
		int[] resultado = new int[cuantos];
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			// System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
			resultado[i] = inferior + rnd.nextInt(superior - inferior + 1);
		return resultado;
	}
	//*******************************************generaFicheroLanzamiento***********************************
	public void generaFicheroLanzamientoDado(int cuantos) {
		HashMap<Integer,Integer> resultado = new HashMap<Integer,Integer>();
		
		try {
			FileWriter fr = new FileWriter("ficheros/dado.txt");
			BufferedWriter br = new BufferedWriter(fr);
			for (int i = 1; i < cuantos+1; i++) {
				int aleatorio = 1 + (int) (Math.random() * (6 - 1 + 1));
				resultado.put(i, aleatorio);
				br.write(i + " " + aleatorio+ "\n");
				System.out.println(i + " " + aleatorio);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
		
	
	
	
	//********************************************frecuenciaAparicion****************************************

	public int[] frecuenciaAparicion(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamientos = this.generaAleatorios3(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.length; i++) {
			resultado[lanzamientos[i] - 1]++;
		}
		return resultado;

	}

	public void estadisticaCadena(String cadena) {
		int contadorVocales = 0;
		int contadorMayusculas = 0;
		int contadorEspeciales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o'
					|| cadena.charAt(i) == 'u' || cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E'
					|| cadena.charAt(i) == 'I' || cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U')
				contadorVocales++;
			if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z')
				contadorMayusculas++;
			int caracterAscii = cadena.charAt(i);
			if ((caracterAscii >= 0 && caracterAscii <= 47) || (caracterAscii >= 58 && caracterAscii <= 64) ||

					(caracterAscii >= 91) && (caracterAscii <= 96))

				contadorEspeciales++;
		}
		// System.out.println("Hay " + contadorVocales + " vocales en " + cadena);
		System.out.println("Hay " + contadorEspeciales + " caracteres especiales en " + cadena);

	}

	public void listaDiasSemana() {
		Datos datos = new Datos();
		// String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes",
		// "sábado", "domingo" };
		// for (int i = 0; i < datos.getDiasSemana().length; i++)
		for (String dia : datos.getDiasSemana())
			// System.out.println(datos.getDiasSemana()[i]);
			System.out.println(dia);
	}

	public void listaEstudiantes(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public void listaEstudiantes(ArrayList<Estudiante> lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}
	//****************************************************************************************************

	public int visitantesIslaYear(int isla, int[][] v) {
		int acu = 0;
		for (int j = 0; j < v[0].length; j++)
			acu += v[isla][j];
		return acu;
	}
	//****************************************con ArrayList y List**************************************************************
	
		public int visitantesIslaYear(int isla, ArrayList<List<Integer>> v) {

			int acu = 0;
			for (int j = 0; j < v.get(0).size(); j++)
				acu += v.get(isla).get(j);
			return acu;
		}
	//****************************************con  ArrayList  ArrayList*************************************
		
		public int visitantesIslaYear2(int isla, ArrayList<ArrayList<Integer>> v) {
			int acu = 0;
			for (int j = 0; j < v.get(0).size(); j++)
				acu += v.get(isla).get(j);
			return acu;
			
		}
	//*****************************************************************************************************	
		
		public ArrayList<ArrayList<Integer>> convierteMatrizArrayEnMatrizArrayList(int[][] matriz){
			ArrayList<ArrayList<Integer>> resultado = new ArrayList<ArrayList<Integer>>();
			
			for (int i = 0; i < matriz.length; i++) {
				resultado.add(new ArrayList<Integer>());
				for (int j = 0; j < matriz[i].length ; j++) {
					resultado.get(i).add(matriz[i][j]);
				}
			}
			return resultado;
		}
		
		
	//******************************************************************************************************

	public int visitantesMesYear(int mes, int[][] v) {
		int acu = 0;
		for (int i = 0; i < v.length; i++)
			acu += v[i][mes];
		return acu;
	}

	public void recorrerMatrizIrregularPorColumnas(int[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}

			}
		}
	}

	public void recorrerMatrizIrregularPorColumnas2(Integer[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j].byteValue());
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				} catch (NullPointerException e) {
					continue;
				}

			}
		}
	}
	
	//**************************************grabarArrayListEnFichero**************************
	
	public void grabarArrayListEnFichero(String rutaFichero, ArrayList<Object> listaObjetos) {
		try {
			FileOutputStream foS = new FileOutputStream(rutaFichero);
			ObjectOutputStream ooS = new ObjectOutputStream(foS);
			ooS.writeObject(listaObjetos);
			ooS.close();
			foS.close();
			
			
		} catch (FileNotFoundException e) {
			
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
	
	//*************************************************************************************
	
	@SuppressWarnings("unchecked")
	public ArrayList<Object> leerArrayListEnFichero(String rutaFichero){
		
		Object test =null;
		try {
			FileInputStream fis = new FileInputStream(rutaFichero);
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			
				 test = ois.readObject();
				
				System.out.println(test);
			
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		} catch (IOException e) {
			System.out.println("IOException");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException");
		}
		return (ArrayList<Object>)test;
	}
	
	//************************************************************************************************
	public void leerVehiculoTexto() {
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/vehiculos.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea; 
			
			int acumulado = 0;
			int contador = 0;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {

				
				//String[] campos = linea.split("&&");
				//String[] campos = linea.split("%");
					//if (resultado.get)
				//System.out.println(linea);
				//System.out.println(calculaEdad(campos[2]));
	
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	//*************************************************************************************************
	//***leer un fichero de txto con datos y pasarlos a un hasmap he imprimirlos en consola************
	//*************************************************************************************************
	public void inicializaVisitantesIsla(HashMap<Integer,ArrayList<Float>> resultado) {
		ArrayList<Float> visitantesMeses = null;
		
		for (int isla = 0;  isla < 7; isla++) {
			 visitantesMeses = new ArrayList<Float>();
			for (int mes = 0; mes < 12; mes++) {
				visitantesMeses.add(0f);
			}
			
			resultado.put(isla, visitantesMeses);
		}
	}
	
		public HashMap<Integer,ArrayList<Float>> LeerVisitantesIslas(String rutaFicheroVisitantes){
		HashMap<Integer,ArrayList<Float>> resultado = new HashMap<Integer,ArrayList<Float>>();
	
		try {
			// Abrir el fichero
			FileReader fr = new FileReader(rutaFicheroVisitantes);
			BufferedReader br = new BufferedReader(fr);
			String linea; 
			inicializaVisitantesIsla(resultado);
			
			
			while ((linea = br.readLine()) != null) {

				
				String[] campos = linea.split("@");
				int isla = Integer.parseInt(campos[0]);
				int mes = Integer.parseInt(campos[1]);
				float numeroVisitantes = Float.parseFloat(campos[2]);
				resultado.get(isla -1).set(mes -1,numeroVisitantes);
								
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			
			System.out.println(e.getMessage());
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
		return resultado;
	}
		
		public void listadoIslasMeses(String rutaFicheroVisitantes) {
			HashMap<Integer, ArrayList<Float>> hm = LeerVisitantesIslas(rutaFicheroVisitantes);
			// recorrer hm
			String[] islas = {"GRAN CANARIA", "LANZAROTE", "FUERTEVENTURA", "TENERIFE", "LA PALMA", "LA GOMERA", "EL HIERRO"};
			String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
			ArrayList<Float> visitantesIsla = null;
			Float visitantesMesesPorIsla = 0f;
			Float subtotal = 0f;
			Float total = 0f;
			for (int isla = 0;  isla < 7; isla++) {
				 System.out.print(islas[isla]+"\n");
				visitantesIsla = hm.get(isla);
				for (int mes = 0; mes < 12; mes++) {
					 
					 visitantesMesesPorIsla = visitantesIsla.get(mes);
					 System.out.print("\t"+meses[mes] +"= " + visitantesMesesPorIsla);
					 subtotal += visitantesMesesPorIsla;
				}
				System.out.println("subTotal de la isla " + islas[isla] +": "+ subtotal   );
				
				total += subtotal;//tengo que poner el acumulador aqui por que aun tiene que recibir valores.
				subtotal = 0f;
				
				
			}
			System.out.println("Total: " + total );

	}
//************************************************************************************
//************************************************************************************
		public void listadoMesesIslas(String rutaFicheroVisitantes) {
			HashMap<Integer, ArrayList<Float>> hm = LeerVisitantesIslas(rutaFicheroVisitantes);
			// recorrer hm
			String[] islas = {"GRAN CANARIA", "LANZAROTE", "FUERTEVENTURA", "TENERIFE", "LA PALMA", "LA GOMERA", "EL HIERRO"};
			String[] meses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};
			
			Float subtotal = 0f;
			Float total = 0f;
			for (int mes = 0; mes < 12; mes++) {
				
				
				System.out.print("\t"+ meses[mes]);
				
				
				for (int isla = 0;  isla < 7; isla++) {
					
				Float valorIsla = hm.get(isla).get(mes);
				subtotal += valorIsla;
				
					System.out.print("\t"+ islas[isla] +": "+ valorIsla); 
					 
				}
				
				System.out.println("Total de visitantes de " + meses[mes]+ ": " + subtotal);
				total += subtotal;
				subtotal = 0f; 
				
				
				
			}
			System.out.println("Total: " + total );

	}



//************************************************************************************
//************************************************************************************

public String operacionMatematica(String num1, int num2){
	String suma = num1 +num2;
	return suma;
	
}
//************************************************************************************
//************************************************************************************

public float probar(Vehiculo coche, float comision) {//----todas las clases son tipos tambien en este 
													//caso Vehiculo o cualquier clase que yo cree
	
	float suma = coche.getPrecio() + comision;
	
	
	return suma;
}

//************************************************************************************
//************************************************************************************
public void leerFicheroTextoOrdenadoClave(String rutaFichero) {
	try {
		// Abrir el fichero
		FileReader fr = new FileReader(rutaFichero);
		BufferedReader br = new BufferedReader(fr);
		String codigo_leido, codigo_anterior = null;
		int contador_grupo = 0;
		int contador_total = 0;
		String linea;
		// Leer el fichero linea a linea
		while ((linea = br.readLine()) != null) {
			String[] campos = linea.split("&&");
			codigo_leido = campos[0];
			if (codigo_anterior == null) // primer registro
				codigo_anterior = codigo_leido;
			if (!codigo_leido.equals(codigo_anterior)) {
				System.out.println("Hay " + contador_grupo + " alumnos en el grupo " + codigo_anterior);
				contador_total += contador_grupo;
				
				contador_grupo = 0;
				codigo_anterior = codigo_leido;
			}
           contador_grupo ++;
		}
		System.out.println("Hay " + contador_grupo + " alumnos en el grupo " + codigo_anterior);
		contador_total += contador_grupo;
		System.out.println("Hay " + contador_total + " alumnos en total ");
		contador_total += contador_grupo;
		fr.close();
		br.close();
	} catch (FileNotFoundException e) {
		System.out.println(e.getMessage());
	} catch (IOException e) {
		System.out.println(e.getMessage());
	}
}

//********************************************************************************************
//********************************************************************************************
public static void grabarObjetosEnFichero(String fichero) {
	Estudiante est = new Estudiante(10, "111G", "Paco1", 'M', null, 181, null, null);
	Estudiante est1 = new Estudiante(20, "222G", "Paco2", 'M', null, 180, null, null);
	
	ArrayList<Estudiante> lista = new ArrayList<Estudiante>();

	// añadimos los 3 estudiantes a la lista

	lista.add(est);
	lista.add(est1);
	//lista.add(est2);

	// abrir el fichero de objetos...
	try {
		FileOutputStream fIs = new FileOutputStream(fichero);
		ObjectOutputStream fObj = new ObjectOutputStream(fIs);

		// guardar los objetos estudiantes en el fichero...
		fObj.writeObject(lista);
		// fObj.writeObject(est);
		// fObj.writeObject(est1);
		// fObj.writeObject(est2);
		fObj.close();
		fIs.close();
	} catch (FileNotFoundException e) {
		System.out.println("Fichero no encontrado");
	} catch (IOException e) {
		System.out.println("Error IO");

	}
	System.out.println("Fichero creado");
}

//********************************************************************************************
//********************************************************************************************

public Estudiante crearEstudianteLeido(String[] datos) {
		int grupo = Integer.parseInt(datos[0]);
		Estudiante estudiante = new Estudiante(grupo);
		estudiante.setNif(datos[1]);
		estudiante.setNombre(datos[2]);
		estudiante.setSexo(datos[3].charAt(0));
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate fechaNac = LocalDate.parse(datos[4], fmt);
	estudiante.setFecha(fechaNac);
		estudiante.setAltura(Integer.parseInt(datos[5]));
		estudiante.setMadre(null);
		estudiante.setPadre(null);
		return estudiante;

	}

	public void copiaEstudiantesTxtAObjetos(String rutaTxt, String rutaObj) {
		try {
			// Abrir el fichero entrada
			FileReader fr = new FileReader(rutaTxt);
			BufferedReader br = new BufferedReader(fr);
			// Abrir el fichero salida
			FileOutputStream fIs = new FileOutputStream(rutaObj);
			ObjectOutputStream fObj = new ObjectOutputStream(fIs);

			String linea;
			// System.out.println(LocalDate.now());
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				String[] campos = linea.split("#");
				// crear estudiante a partir del registro leido
				Estudiante estudiante = crearEstudianteLeido(campos);
				// grabar objeto estudiante en fichero ..
				fObj.writeObject(estudiante);

			}
			fr.close();
			br.close();
			fIs.close();
			fObj.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	//********************************************************************************************
	
	public String[] leerComunidadesAutonomasTxt() {
		String[] comunidades = new String[19];
		int index = 0;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/comunidades.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				comunidades[index] = linea.split("%")[1];
				index++;
			}
			fr.close();//cierra el fichero
			br.close();//cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}return comunidades;
	}
	public String[] leerComunidadesAutonomasTxt2() {
		String[] comunidades = new String[19];
		int index = 0;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/comunidades.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			// Leer el fichero linea a linea
			linea = br.readLine();
			//Este while sería con la condición tradicional sin usar una vaiarable dentro
			//a la que asignamos el valor de la linea.
			while (linea != null) {
				comunidades[index] = linea.split("%")[1];
				index++;
				linea = br.readLine();
			}
			fr.close();//cierra el fichero
			br.close();//cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}return comunidades;
	}
	
	public String[] leerProvinciasTxt() {
		String[] provincias = new String[52];
		int index = 0;
		try {
			// Abrir el fichero
			FileReader fr = new FileReader("ficheros/provincias.txt");
			BufferedReader br = new BufferedReader(fr);
			String linea;
			
			// Leer el fichero linea a linea
			while ((linea = br.readLine()) != null) {
				/*String provincia = strLine.split("%")[0];
				String comunidadAutonomaDeLaProvincia = strLine.split("%")[1];
				String habitantesDeLaProvincia = strLine.split("%")[2];
				resultado[index] = provincia + "%" + comunidadAutonomaDeLaProvincia + "%" + habitantesDeLaProvincia;*/
				provincias[index] = linea;
				index++;
			}
			fr.close();//cierra el fichero
			br.close();//cierra el buffer
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return provincias;
	}
	
	public void mostrarDatosComAutonomasProvinciasHabitantes(HashMap<Integer,ArrayList<Integer>> habitantes, HashMap<Integer,ArrayList<String>> nombresProvincias, String[] nombreComunidadesAutonomas ) {
		int subTotal = 0;
		int total = 0;
		System.out.println("***************************************************");
		System.out.println("******Comunidades Autónomas y sus Provincias*******");
		System.out.println("***************************************************");
		for (int indexComunidad = 0; indexComunidad < habitantes.size(); indexComunidad++) {
			System.out.println("----  " + nombreComunidadesAutonomas[indexComunidad] + "  ----");
			for (int indexProvincia = 0; indexProvincia < habitantes.get(indexComunidad).size(); indexProvincia++) {			
				System.out.print(nombresProvincias.get(indexComunidad).get(indexProvincia) + ":   \t");
				int numHabitantes = habitantes.get(indexComunidad).get(indexProvincia);
				subTotal += numHabitantes;
				System.out.println(numHabitantes);
					
			}
			System.out.println("TOTAL de habitantes de " + nombreComunidadesAutonomas[indexComunidad] + " = " + subTotal);
			total += subTotal;
			subTotal = 0;
			System.out.println();
		}
		System.out.println("TOTAL de habitantes de España = " + total);
	}
	
	public void mostrarDatosComAutonomasProvinciasHabitantes2(HashMap<Integer,ArrayList<Integer>> habitantes, HashMap<Integer,ArrayList<String>> nombresProvincias, String[] nombreComunidadesAutonomas ) {
		int subTotal = 0;
		int total = 0;
		
		System.out.println("***************************************************");
		System.out.println("******Comunidades Autónomas y sus Provincias*******");
		System.out.println("***************************************************");
		
		for ( Integer indexComunidad : habitantes.keySet()) {
			int indexProvincia =0;
			System.out.println("----  " + nombreComunidadesAutonomas[indexComunidad] + "  ----");
			ArrayList<Integer> provincias = habitantes.get(indexComunidad);
			for (Integer cantidadHabitantes : provincias) {				
				System.out.print(nombresProvincias.get(indexComunidad).get(indexProvincia) + ":   \t");
				subTotal += cantidadHabitantes;
				System.out.println(cantidadHabitantes);
				indexProvincia++;
			}
			System.out.println("TOTAL de habitantes de " + nombreComunidadesAutonomas[indexComunidad] + " = " + subTotal);
			total += subTotal;
			subTotal = 0;
			System.out.println();
		}
		
		System.out.println("TOTAL de habitantes de España = " + total);
	}
	
	
	
	//Leemos dos ficheros de textos llamados provincias.txt y comunidades.txt
	//debemos sacar los datos de los habitantes empadronados de cada provincia pero
	//agrupadas cada una por su comunidad autonoma, con el total de habitantes por
	//Comunidad autonoma
	public void leerFicheroTextoProvinciasComAutoYListarDatos() {
		String[] comunidadesAutonomas = leerComunidadesAutonomasTxt();
		String[] datosTodasLasProvincias = leerProvinciasTxt();
		HashMap<Integer,ArrayList<Integer>> comunidadesProvinciasHabitantes = new HashMap<Integer,ArrayList<Integer>>();
		for (int i = 0; i < comunidadesAutonomas.length; i++) {
				ArrayList<Integer> listadoProvincias = new ArrayList<Integer>();
				comunidadesProvinciasHabitantes.put(i, listadoProvincias);
			
		}

		//El siguiente HashMap llamado nombresProvincias almacena en su clave el indice de la comunidad
		//y en el valor un ArrayList de String donde cada String es el nombre de a provincia
		HashMap<Integer,ArrayList<String>> nombresProvincias = new HashMap<Integer,ArrayList<String>>();
		
			//Recorremos el Array de String que nos devolvió el método leerProvinciasTxt()
			//
			for (String datosUnaProvincia : datosTodasLasProvincias) {
				String[] datosUnaProvinciaSeparados = datosUnaProvincia.split("%");				
				int indiceComunidadAutonoma = Integer.parseInt(datosUnaProvinciaSeparados[2])-1;			
				int habitantesUnaProvincia = Integer.parseInt(datosUnaProvinciaSeparados[3]);				
				//añadimos un condicional que solo cree un ArrayList la primera vez
				//cuando estamos en una comunidad autonoma y no nos cree ninguno mas
				//cuando volvamos a tener que añadir datos a la misma comunidad autonoma.
				if (nombresProvincias.get(indiceComunidadAutonoma) == null) {
					ArrayList<String> provincias = new ArrayList<String>();
					nombresProvincias.put(indiceComunidadAutonoma,provincias);
				}
				//añadimos al HashMap de provincias, el nombre que le corresponde en la comunidad atonoma
				//a la que pertence.
				nombresProvincias.get(indiceComunidadAutonoma).add(datosUnaProvinciaSeparados[1]);				
				//añadimos el número de habitantes a la provincia en la comunidad autonoma que corresponde
				comunidadesProvinciasHabitantes.get(indiceComunidadAutonoma).add(habitantesUnaProvincia);
			}
		//mostrarDatosComAutonomasProvinciasHabitantes(comunidadesProvinciasHabitantes,nombresProvincias, comunidadesAutonomas);	
		mostrarDatosComAutonomasProvinciasHabitantes2(comunidadesProvinciasHabitantes,nombresProvincias, comunidadesAutonomas);
		System.out.println("BreakPoint");
		
	}
	

	
}

