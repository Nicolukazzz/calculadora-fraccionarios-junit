package CalculadoraFraccionarios.controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import CalculadoraFraccionarios.modelo.Fraccion;

class CalculadoraTest {

   @Test
   void testSumar() {
      Calculadora c = new Calculadora(5, 6, 3, 4);

      assertEquals(new Fraccion(19, 12), c.sumar(), "5/6 + 3/4");
   }

   @Test
   void testSumarConCero() {
      Calculadora c = new Calculadora(0, 1, 3, 4);

      assertEquals(new Fraccion(3, 4), c.sumar(), "0/1 + 3/4");
   }

   @Test
   void testRestar() {
      Calculadora c = new Calculadora(5, 6, 3, 4);

      assertEquals(new Fraccion(1, 12), c.restar(), "5/6 - 3/4");
   }

   @Test
   void testRestarNegativo() {
      Calculadora c = new Calculadora(1, 2, -3, 4);

      assertEquals(new Fraccion(5, 4), c.restar(), "1/2 - (-3/4)");
   }

   @Test
   void testMultiplicar() {
      Calculadora c = new Calculadora(5, 6, 3, 4);

      assertEquals(new Fraccion(5, 8), c.multiplicar(), "5/6 * 3/4");
   }

   @Test
   void testMultiplicarPorCero() {
      Calculadora c = new Calculadora(5, 6, 0, 1);

      assertEquals(new Fraccion(0, 1), c.multiplicar(), "5/6 * 0/1");
   }

   @Test
   void testDividir() {
      Calculadora c = new Calculadora(5, 6, 3, 4);
      

      assertEquals(new Fraccion(10, 9), c.dividir(), "5/6 / 3/4");
   }

   @Test
   void testDividirEntreCero() {
      Calculadora c = new Calculadora(5, 6, 0, 1);

      assertThrows(ArithmeticException.class, () -> c.dividir(), "5/6 / 0/1");
   }

   @Test
   void testMcd() {
      Calculadora c = new Calculadora();

      assertEquals(3, c.mcd(15, 12), "mcd de 15 y 12");
   }

   @Test
   void testMcdConCero() {
      Calculadora c = new Calculadora();

      assertEquals(5, c.mcd(0, 5), "mcd de 0 y 5");
   }

   @Test
   void testMcm() {
      Calculadora c = new Calculadora();

      assertEquals(12, c.mcm(4, 6), "mcm de 4 y 6");
   }

   @Test
   void testMcmConCero() {
      Calculadora c = new Calculadora();

      assertEquals(0, c.mcm(0, 5), "mcm de 0 y 5");
   }

   @Test
   void testSimplificar() {
      Calculadora c = new Calculadora();

      assertEquals(new Fraccion(4, 5), c.simplificar(new Fraccion(12, 15)), "12/15 simplificado");
   }

   @Test
   void testSimplificarCero() {
      Calculadora c = new Calculadora();

      assertEquals(new Fraccion(0, 1), c.simplificar(new Fraccion(0, 5)), "0/5 simplificado");
   }

}
