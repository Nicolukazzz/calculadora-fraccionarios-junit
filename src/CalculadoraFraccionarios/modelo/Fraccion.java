package CalculadoraFraccionarios.modelo;

/**
 * Fraccionario con numerador y denominador.
 * El denominador siempre queda positivo y nunca puede ser cero.
 */
public class Fraccion {
	private int num;
	private int den;
	/**
	 * Constructor por defecto
	 */
	public Fraccion() {
		den=1;
	}
	/**
	 * @param num
	 * @param den
	 */
	public Fraccion(int num, int den) {

		if (den == 0)
			throw new IllegalArgumentException("El denominador no puede ser cero");
		this.num = num;
		this.den = den;
		if (den < 0) {
			this.num = -num;
			this.den = -den;
		}
	}

	/**
	 * @param f
	 */
	public Fraccion(Fraccion f) {
		this(f.getNum(), f.getDen());
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * @return the den
	 */
	public int getDen() {
		return den;
	}
	/**
	 * @param den the den to set
	 */
	public void setDen(int den) {
		if (den == 0)
			throw new IllegalArgumentException("El denominador no puede ser cero");
		this.den = den;
	}
	@Override
	public String toString() {
		return num + "/" + den;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Fraccion))
			return false;
		Fraccion f=(Fraccion)o;
		if ((num==f.num) && (den==f.den))
			return true;
		return false;
	}


	/**
	 * Método que suma dos fracciones: this y f
	 * @param f: Fraccion a sumar
	 * @return res : suma entre this y f
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion res=new Fraccion();
		res.den=this.getDen()*f.getDen();
		res.num=this.getNum()*f.getDen()+this.getDen()*f.getNum();
		res.simplificar();
		return res;
	}

	/**
	 * Método que resta dos fracciones: this y f
	 * @param f: Fraccion a restar
	 * @return res : resta entre this y f
	 */
	public Fraccion restar(Fraccion f) {
		Fraccion res=new Fraccion();
		res.den=this.getDen()*f.getDen();
		res.num=this.getNum()*f.getDen()-this.getDen()*f.getNum();
		res.simplificar();
		return res;
	}

	/**
	 * Método que multiplica dos fracciones: this y f
	 * @param f: Fraccion a multiplicar
	 * @return res : producto entre this y f
	 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion res=new Fraccion();
		res.den=this.getDen()*f.getDen();
		res.num=this.getNum()*f.getNum();
		res.simplificar();
		return res;
	}

	/**
	 * Método que divide dos fracciones: this y f
	 * @param f: Fraccion divisor
	 * @return res : cociente entre this y f
	 */
	public Fraccion dividir(Fraccion f) {
		if (f.getNum() == 0)
			throw new ArithmeticException("No se puede dividir entre cero");
		Fraccion res=new Fraccion();
		res.den=this.getDen()*f.getNum();
		res.num=this.getNum()*f.getDen();
		res.simplificar();
		return res;
	}

	/**
	 * Reduce la fracción a su forma más simple.
	 * Si el numerador es cero, el resultado es 0/1.
	 */
	public void simplificar() {
		if (num == 0) {
			den = 1;
			return;
		}
		int m=mcd(num, den);
		num=num/m;
		den=den/m;
	}

	/**
	 * Método que calcula el máximo común divisor de dos enteros.
	 * Funciona también con cero y con números negativos.
	 * @param a
	 * @param b
	 * @return mcd de a y b
	 */
	public int mcd(int a, int b) {
		a=Math.abs(a);
		b=Math.abs(b);
		while (b != 0) {
			int aux=b;
			b=a%b;
			a=aux;
		}
		return a;
	}

	public int minimo(int a, int b) {
		if (a<b)
			return a;
		return b;
	}

	/**
	 * Método que calcula el mínimo común múltiplo de dos enteros.
	 * Si alguno es cero, el resultado es cero.
	 * @param a
	 * @param b
	 * @return mcm de a y b
	 */
	public int mcm(int a, int b) {
		if (a == 0 || b == 0)
			return 0;
		return Math.abs(a/mcd(a, b)*b);
	}

}
