package CalculadoraFraccionarios.controlador;

import CalculadoraFraccionarios.modelo.Fraccion;

/**
 * Fachada o controlador de la calculadora.
 * Recibe los dos fraccionarios, llama al modelo y entrega el resultado.
 */
public class Calculadora {
	Fraccion f1;
	Fraccion f2;

	/**
	 * Constructor para cuando solo se usa una fraccion o dos numeros
	 * (simplificar, mcd y mcm)
	 */
	public Calculadora() {
	}

	public Calculadora(int n1, int d1, int n2, int d2) {
		f1=new Fraccion(n1,d1);
		f2=new Fraccion(n2,d2);
	}

	public Fraccion simplificar(Fraccion f) {
		f.simplificar();
		return f;
	}

	public Fraccion sumar() {
		return f1.sumar(f2);
	}

	public Fraccion restar() {
		return f1.restar(f2);
	}

	public Fraccion multiplicar() {
		return f1.multiplicar(f2);
	}

	/**
	 * @throws ArithmeticException si el segundo fraccionario es 0/1
	 */
	public Fraccion dividir() {
		return f1.dividir(f2);
	}

	public int mcd(int a, int b) {
		Fraccion f=new Fraccion();
		return f.mcd(a, b);
	}

	public int mcm(int a, int b) {
		Fraccion f=new Fraccion();
		return f.mcm(a, b);
	}

}
