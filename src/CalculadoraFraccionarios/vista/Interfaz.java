package CalculadoraFraccionarios.vista;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import CalculadoraFraccionarios.controlador.Calculadora;
import CalculadoraFraccionarios.modelo.Fraccion;

/**
 * Interfaz de consola de la calculadora de fraccionarios.
 */
public class Interfaz {

	private static Scanner s = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int opcion;
		do {
			mostrarMenu();
			opcion = leerEntero("Opción: ");
			switch (opcion) {
			case 1:
				sumar();
				break;
			case 2:
				restar();
				break;
			case 3:
				multiplicar();
				break;
			case 4:
				dividir();
				break;
			case 5:
				simplificar();
				break;
			case 6:
				calcularMcd();
				break;
			case 7:
				calcularMcm();
				break;
			case 8:
				mostrarResultadosPruebas();
				break;
			case 0:
				System.out.println("Hasta luego.");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		} while (opcion != 0);

	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("Calculadora de fraccionarios");
		System.out.println("1. Sumar");
		System.out.println("2. Restar");
		System.out.println("3. Multiplicar");
		System.out.println("4. Dividir");
		System.out.println("5. Simplificar");
		System.out.println("6. Máximo común divisor");
		System.out.println("7. Mínimo común múltiplo");
		System.out.println("8. Ver resultados de las pruebas");
		System.out.println("0. Salir");
	}

	private static void sumar() {
		Calculadora c = pedirFraccionarios();
		System.out.println("La suma es: " + c.sumar());
	}

	private static void restar() {
		Calculadora c = pedirFraccionarios();
		System.out.println("La resta es: " + c.restar());
	}

	private static void multiplicar() {
		Calculadora c = pedirFraccionarios();
		System.out.println("La multiplicación es: " + c.multiplicar());
	}

	private static void dividir() {
		Calculadora c = pedirFraccionarios();
		try {
			System.out.println("La división es: " + c.dividir());
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void simplificar() {
		System.out.println("Fraccionario a simplificar");
		int n = leerEntero("Numerador: ");
		int d = leerDenominador("Denominador: ");
		Calculadora c = new Calculadora();
		System.out.println("Simplificado: " + c.simplificar(new Fraccion(n, d)));
	}

	private static void calcularMcd() {
		int a = leerEntero("Primer número: ");
		int b = leerEntero("Segundo número: ");
		Calculadora c = new Calculadora();
		System.out.println("El mcd es: " + c.mcd(a, b));
	}

	private static void calcularMcm() {
		int a = leerEntero("Primer número: ");
		int b = leerEntero("Segundo número: ");
		Calculadora c = new Calculadora();
		System.out.println("El mcm es: " + c.mcm(a, b));
	}

	private static Calculadora pedirFraccionarios() {
		System.out.println("Primer fraccionario");
		int n1 = leerEntero("Numerador: ");
		int d1 = leerDenominador("Denominador: ");
		System.out.println("Segundo fraccionario");
		int n2 = leerEntero("Numerador: ");
		int d2 = leerDenominador("Denominador: ");
		return new Calculadora(n1, d1, n2, d2);
	}

	/**
	 * Pide un entero y repite hasta que el usuario escriba uno válido.
	 */
	private static int leerEntero(String mensaje) {
		while (true) {
			System.out.print(mensaje);
			try {
				int n = s.nextInt();
				s.nextLine();
				return n;
			} catch (InputMismatchException e) {
				System.out.println("Ingrese un número entero.");
				s.nextLine();
			}
		}
	}

	/**
	 * Pide un denominador distinto de cero.
	 */
	private static int leerDenominador(String mensaje) {
		while (true) {
			int d = leerEntero(mensaje);
			if (d != 0)
				return d;
			System.out.println("El denominador no puede ser cero.");
		}
	}

	/**
	 * Ejecuta la suite de pruebas y muestra cuáles pasaron y cuáles fallaron.
	 */
	private static void mostrarResultadosPruebas() {
		LauncherDiscoveryRequest peticion = LauncherDiscoveryRequestBuilder.request()
				.selectors(DiscoverySelectors.selectPackage("CalculadoraFraccionarios"))
				.build();
		Launcher launcher = LauncherFactory.create();
		ResumenPruebas resumen = new ResumenPruebas();

		launcher.execute(peticion, resumen);

		System.out.println();
		System.out.println("Pruebas que pasaron: " + resumen.pasaron);
		System.out.println("Pruebas que fallaron: " + resumen.fallaron);
	}

	/**
	 * Escucha el resultado de cada prueba y lo imprime en consola.
	 */
	private static class ResumenPruebas implements TestExecutionListener {
		int pasaron = 0;
		int fallaron = 0;

		@Override
		public void executionFinished(TestIdentifier prueba, TestExecutionResult resultado) {
			if (!prueba.isTest())
				return;
			if (resultado.getStatus() == TestExecutionResult.Status.SUCCESSFUL) {
				pasaron++;
				System.out.println("PASÓ  " + prueba.getDisplayName());
			} else {
				fallaron++;
				System.out.println("FALLÓ " + prueba.getDisplayName());
				resultado.getThrowable().ifPresent(t -> System.out.println("      " + t.getMessage()));
			}
		}
	}

}
