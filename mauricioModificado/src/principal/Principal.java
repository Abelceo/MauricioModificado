package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import auxiliar.Practicas;
import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Profesor;
import modelo.Vehiculo;

public class Principal {
	// metodo por el que debe empezar la ejecución ..
	public static void main(String[] args) {
		/*
		 * Persona persona; persona = new Persona();
		 * 
		 * persona.setNombre("Manolo"); System.out.println("nif : " + persona.getNif());
		 * System.out.println("nombre : " + persona.getNombre());
		 * System.out.println("altura : " + persona.getAltura());
		 * System.out.println("persona1 creada");
		 */
		/*
		 * Persona padre = new Persona(); padre.setNombre("JorgePadre");
		 * padre.setSexo('M'); Persona madre = new Persona();
		 * madre.setNombre("MariaMadre"); madre.setNif("44567981H"); madre.setSexo('F');
		 */

		/*
		 * Persona persona2 = new Persona("43897124R", "PEPE", 'F', LocalDate.of(1999,
		 * 9, 21), 170, padre, madre); System.out.println("persona2 creada");
		 * System.out.println("Nombre madre : " + persona2.getMadre().getNombre());
		 */
		
		
		// crear un Estudiante
		Estudiante estAnonimo = new Estudiante(123);

		Estudiante estudiante = new Estudiante(111, "44556677G", "Rafael", 'M', LocalDate.now(), 187, estAnonimo, null);
		Estudiante estudiante2 = new Estudiante(111, "44556674T", "Javier", 'M', LocalDate.now(), 187, estAnonimo,
				null);
		Estudiante estudiante3 = new Estudiante(111, "44556672X", "Marcos", 'M', LocalDate.now(), 187, estAnonimo,
				null);

		Estudiante[] listaEstudiantes = { estAnonimo, estudiante, estudiante2, estudiante3 };

		Practicas practicas = new Practicas();
		practicas.ordenaEstudiantes(listaEstudiantes);

		// new Practicas().muestraNumerosDe1A1000();
		// practicas.muestraNumerosDe1A1000();
		// practicas.muestraNumeros3(20, 25);
		// practicas.generaAleatorios2(3,10,11);
		// practicas.estadisticaCadena("Las&%=\" PalmAs\\ de Gran CanarIa");
		// int [] numeros=practicas.generaAleatorios3(100, 1, 6);
		// int[] frecuencia = practicas.frecuenciaAparicion(100, 1, 8);
		// practicas.listaDiasSemana();
		// Estudiante[] lista = new Datos().getEstudiantes();
		// practicas.listaEstudiantes(new Datos().getEstudiantes());
		
		int[][] visitantesYear = { { 2, 4, 5, 1, 3, 2, 1, 1, 1, 3, 5, 1 },
				{ 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13 }, { 23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 12 },
				{ 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13 }, { 23, 4, 56, 12, 32, 23, 17, 12, 11, 34, 45, 10 },
				{ 23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 45 }, { 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 37 }

		};
		
		
		String[] islas = { "GC", "LTE", "FTV", "TFE", "LPA", "GOM", "HIE" };
		String[] meses = { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC" };
		int isla=2; int mes =7; System.out.println("Visitantes en "+ islas[isla]
				 +" : " + practicas.visitantesIslaYear(isla, visitantesYear));
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		
		ArrayList<ArrayList<Integer>> listaMatriz = practicas.convierteMatrizArrayLista(visitantesYear);
	//************************************************************************************************************	
		ArrayList<List<Integer>> visitYear = new ArrayList<List<Integer>>();
		visitYear.add( Arrays.asList(2, 4, 5, 1, 3, 2, 1, 1, 1, 3, 5, 1));
		visitYear.add( Arrays.asList(23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13));
		visitYear.add( Arrays.asList(23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 12));
		visitYear.add( Arrays.asList(23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13));
		visitYear.add( Arrays.asList(23, 4, 56, 12, 32, 23, 17, 12, 11, 34, 45, 10));
		visitYear.add( Arrays.asList(23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 45));
		visitYear.add( Arrays.asList(23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 37));
		
		
		System.out.println("list: " + practicas.visitantesIslaYear(isla, visitYear));
		
		
		
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		
		ArrayList<ArrayList<Integer>> datos2 = practicas.convierteMatrizArrayEnMatrizArrayList(visitantesYear);
		System.out.println("Arraylist: " + practicas.visitantesIslaYear2(isla, datos2));
		
	//*************************************************************************************************************
		
		 
		// System.out.println("Visitantes  en Canarias en el mes " + meses[mes]+ " : " +
		// practicas.visitantesMesYear(mes, visitantesYear));
		 
		 

		/*
		 * String[] misDatos = { "123","abc", "345", "1x2", "990" }; //int[] res =
		 * practicas.convierteCadenasANumeros(misDatos); float saldo= 1000.0f; float[]
		  movimientos= {10.0f, -5.0f,20.5f};
		 * 
		 * float saldoFinal = practicas.calculaSaldo(saldo, movimientos);
		 */
		int[] datos = practicas.generaAleatorios3(500, 1, 500);
		// practicas.ordenaEnteros(datos);
		// Arrays.sort(datos);
		String[] cadenas = { "perro", "gato", "alce" };
		practicas.ordenaCadenas(cadenas);
		int[] array2 = { 3, 6, 9, 9, 9, 15, 29 };
		int[] array1 = { 1, 2, 9, 9, 25, 39, 56, 67, 99 };
		int[] arrayMezclado = practicas.mezclaArrays(array1, array2);
		// liga
		String[][] goles = new Datos().getResultados();

		int[] clasificacion = practicas.obtenerClasificacion2(goles);
		String[] equipos = new Datos().getEquipos();
		practicas.ordenaClasificacion(clasificacion, equipos);
		for (int i = 0; i < equipos.length; i++) {
			//System.out.println(equipos[i] + " \t" + clasificacion[i]);

		}
		int[][] puntosJornadas = new Datos().getPuntosJornada();
		Equipo[] clasi = practicas.obtenerClasificacion3(puntosJornadas);
		String nif = "345239";
	//	System.out.println(practicas.validarNif(nif)?"OK":"KO");
		int x=67;
		//System.out.println("El numero "+ x + (practicas.esPrimo(x)?" ES ":" NO ES ")+ " PRIMO" );
		int[][] matriz = {
				{3,4,8},
				{6},
				{5,9}
		};
		Integer[][] matriz2 = {
				{3,4,null,8,null,12,37,null},
				{6,7,12,null,34,21,null,11},
				{5,null,9}
		};
	//	practicas.recorrerMatrizIrregularPorColumnas(matriz);
		//practicas.recorrerMatrizIrregularPorColumnas2(matriz2);
		//int[] primos = practicas.numerosPrimos(100);
		//int [] fibonacci = practicas.numerosFibonacci(20);
		//ArrayList<Estudiante> lista = practicas.introListas();
		practicas.listaEstudiantes(practicas.introListas());
		ArrayList<String> lista = new ArrayList<String>();
		lista.add("12");
		lista.add("19");
		lista.add("-12");
		lista.add("1x2");
		ArrayList<Integer> numeros = practicas.convierteCadenasANumeros(lista);
		HashMap<String, Estudiante> mapa = practicas.introMapas();
		Estudiante noexisto = mapa.get("noexisto");
		
		practicas.leerFicheroTexto();//este no devolvia
		
		ArrayList<String> recoge = practicas.leerFicheroTextoArrayList("ficheros/personas.txt");
		
		HashMap<String, String> recoge1 = practicas.leerFicheroTextoHashMap("ficheros/personas.txt");
		
		
		HashMap<String,ArrayList<Float>> resultado = practicas.resumenVentasVendedor("ficheros/VentasDeptoAlmacen.txt");
		
		practicas.resumenVentasPorVendedor(resultado);
		
		System.out.println("----------------------------------------------------------------------------");	
		//**********************************************************************	
		ArrayList<Float> movimientos = new ArrayList<Float>();
		movimientos.add(50.5f);
		movimientos.add(60.5f);
		movimientos.add(70.5f);
		float resultadoSaldo = practicas.calculaSaldo(1000.0f, movimientos);
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		float sdFinal = practicas.calculaSaldo(1000.0f, "ficheros/saldo.txt");
		System.out.println("Su Saldo Actual es:" + sdFinal);
		System.out.println("----------------------------------------------------------------------------");	
		practicas.generaFicheroLanzamientoDado(6);
		
		//**********************************************************************
		ArrayList<Object> listaObjetos = new ArrayList<Object>();
		Estudiante est = new Estudiante(10, "111G", "Paco1", 'M', null, 181, null, null);
		Estudiante est1 = new Estudiante(20, "222G", "Paco2", 'M', null, 180, null, null);
		Estudiante est2 = new Estudiante(30, "333G", "Paco3", 'M', null, 180, null, null);
		listaObjetos.add(est);
		listaObjetos.add(est1);
		listaObjetos.add(est2);
		practicas.grabarArrayListEnFichero("ficheros/arraylist.obj", listaObjetos);
		
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		ArrayList<Object> listaObjetos2 = practicas.leerArrayListEnFichero("ficheros/arraylist.obj");	
		System.out.println(listaObjetos2);
		
		
		
		//***leer un fichero de txto con datos y pasarlos a un hasmap he imprimirlos en consola************
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		HashMap<Integer, ArrayList<Float>> resultado1 = practicas.LeerVisitantesIslas("ficheros/DatosIslasMesValor.txt");
		practicas.listadoIslasMeses("ficheros/DatosIslasMesValor.txt");
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		practicas.listadoMesesIslas("ficheros/DatosIslasMesValor.txt");
		
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		Vehiculo coche = new Vehiculo(1, "2332", 125, LocalDate.of(2018, 12, 12), 9800f);
		System.out.println(practicas.probar(coche, 1.5f));
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		System.out.println(practicas.operacionMatematica("3", 6));	
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		practicas.leerFicheroTextoOrdenadoClave("ficheros/grupo_estudiantes.txt");
		//**********************************************************************
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		practicas.copiaEstudiantesTxtAObjetos("ficheros/estudiantes.txt", "ficheros/estudiantes.obj");
		System.out.println("----------------------------------------------------------------------------");
		//**********************************************************************
		practicas.leerFicheroTextoProvinciasComAutoYListarDatos();
		
		
		
		
		System.out.println("fin");
		
		
	}

}
