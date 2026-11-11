package CalculadoraFraccionarios.modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class FraccionTest {

   @Test
   void testMcm() {
      Fraccion f = new Fraccion(3, 4);

      assertEquals(12, f.mcm(4, 6), "mcm de 4 y 6");
   }

   @Test
   void testMcmConCero() {
      Fraccion f = new Fraccion(3, 4);

      assertEquals(0, f.mcm(0, 5), "mcm de 0 y 5");
   }

   @Test
   void testMcmIguales() {
      Fraccion f = new Fraccion(3, 4);

      assertEquals(7, f.mcm(7, 7), "mcm de 7 y 7");
   }

   @Test
   void testMcd() {
      Fraccion f = new Fraccion(3, 4);

      assertEquals(3, f.mcd(15, 12), "mcd de 15 y 12");
   }

   @Test
   void testMcdConCero() {
      Fraccion f = new Fraccion(3, 4);

      assertEquals(5, f.mcd(0, 5), "mcd de 0 y 5");
   }

   @Test
   void testMcdPrimosRelativos() {
      Fraccion f = new Fraccion(3, 4);

      assertEquals(1, f.mcd(7, 13), "mcd de 7 y 13");
   }

   @Test
   void testSumar() {
	
    	Fraccion f = new Fraccion(3, 4);
    	Fraccion g = new Fraccion(5, 6);

		assertAll(
			() -> assertEquals(19, f.sumar(g).getNum(), "numerador de 3/4 + 5/6"),
        	() -> assertEquals(12, f.sumar(g).getDen(), "denominador de 3/4 + 5/6")
		);
   }

   @Test
   void testSumarConCero() {
      Fraccion cero = new Fraccion(0, 1);
      Fraccion f = new Fraccion(3, 4);

      assertEquals(new Fraccion(3, 4), cero.sumar(f), "0/1 + 3/4");
   }

   @Test
   void testSumarConNegativo() {
      Fraccion f = new Fraccion(1, 2);
      Fraccion g = new Fraccion(-3, 4);

      assertEquals(new Fraccion(-1, 4), f.sumar(g), "1/2 + (-3/4)");
   }

   @Test
   void testRestar() {
      Fraccion f = new Fraccion(3, 4);
      Fraccion g = new Fraccion(5, 6);

      assertEquals(new Fraccion(1, 12), g.restar(f), "5/6 - 3/4");
   }

   @Test
   void testRestarHastaCero() {
      Fraccion f = new Fraccion(1, 2);

      assertEquals(new Fraccion(0, 1), f.restar(f), "1/2 - 1/2");
   }

   @Test
   void testMultiplicar() {
      Fraccion f = new Fraccion(3, 4);
      Fraccion g = new Fraccion(5, 6);

      assertEquals(new Fraccion(5, 8), f.multiplicar(g), "3/4 * 5/6");
   }

   @Test
   void testMultiplicarPorCero() {
      Fraccion f = new Fraccion(3, 4);
      Fraccion cero = new Fraccion(0, 1);

      assertEquals(new Fraccion(0, 1), f.multiplicar(cero), "3/4 * 0/1");
   }

   @Test
   void testMultiplicarNegativo() {
      Fraccion f = new Fraccion(-2, 3);
      Fraccion g = new Fraccion(3, 4);

      assertEquals(new Fraccion(-1, 2), f.multiplicar(g), "-2/3 * 3/4");
   }

   @Test
   void testDividir() {
      Fraccion f = new Fraccion(3, 4);
      Fraccion g = new Fraccion(5, 6);

      assertEquals(new Fraccion(9, 10), f.dividir(g), "3/4 / 5/6");
   }

   @Test
   void testDividirEntreCero() {
      Fraccion f = new Fraccion(3, 4);
      Fraccion cero = new Fraccion(0, 1);

      assertThrows(ArithmeticException.class, () -> f.dividir(cero), "3/4 / 0/1");
   }

   @Test
   void testSimplificar() {
      Fraccion f = new Fraccion(12, 15);
      f.simplificar();

      assertEquals(new Fraccion(4, 5), f, "12/15 simplificado");
   }

   @Test
   void testSimplificarCero() {
      Fraccion f = new Fraccion(0, 5);
      f.simplificar();

      assertEquals(new Fraccion(0, 1), f, "0/5 simplificado");
   }

   @Test
   void testSimplificarNegativo() {
      Fraccion f = new Fraccion(-4, 6);
      f.simplificar();

      assertEquals(new Fraccion(-2, 3), f, "-4/6 simplificado");
   }

   @Test
   void testSimplificarIrreducible() {
      Fraccion f = new Fraccion(7, 13);
      f.simplificar();

      assertEquals(new Fraccion(7, 13), f, "7/13 ya está simplificado");
   }

   @Test
   void testDenominadorCero() {
      assertThrows(IllegalArgumentException.class, () -> new Fraccion(1, 0), "1/0 no es válido");
   }

   @Test
   void testDenominadorNegativo() {
      Fraccion f = new Fraccion(3, -6);

      assertAll(
         () -> assertEquals(-3, f.getNum(), "el signo pasa al numerador"),
         () -> assertEquals(6, f.getDen(), "el denominador queda positivo")
      );
   }
}
