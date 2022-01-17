/**
 * 
 */
package com.uvg.ejemplo1.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.uvg.ejemplo1.Calc;

/**
 * @author MAAG
 *
 */
class CalcTest {

	/**
	 * Test method for {@link com.uvg.ejemplo1.Calc#saveValue(int)}.
	 */
	@Test
	void testSaveValue() {
		Calc miCalc = new Calc();
		miCalc.saveValue(10);
		assertEquals(10, miCalc.getValue());
	}

	/**
	 * Test method for {@link com.uvg.ejemplo1.Calc#getValue()}.
	 */
	@Test
	void testGetValue() {
		Calc miCalc = new Calc();
		miCalc.saveValue(10);
		assertEquals(10, miCalc.getValue());
	}

	/**
	 * Test method for {@link com.uvg.ejemplo1.Calc#addition(int, int)}.
	 */
	@Test
	void testAddition() {
		Calc miCalc = new Calc();
		assertEquals(10, miCalc.addition(5, 5));
	}

	/**
	 * Test method for {@link com.uvg.ejemplo1.Calc#substraction(int, int)}.
	 */
	@Test
	void testSubstraction() {
		Calc miCalc = new Calc();
		assertEquals(10, miCalc.substraction(15, 5));
	}

	/**
	 * Test method for {@link com.uvg.ejemplo1.Calc#multiplication(int, int)}.
	 */
	@Test
	void testMultiplication() {
		Calc miCalc = new Calc();
		assertEquals(20, miCalc.multiplication(5, 4));
	}

	/**
	 * Test method for {@link com.uvg.ejemplo1.Calc#div(int, int)}.
	 */
	@Test
	void testDiv() {
		Calc miCalc = new Calc();
		assertEquals(10, miCalc.div(10, 1));
	}

	/**
	 * Test method for {@link com.uvg.ejemplo1.Calc#mod(int, int)}.
	 */
	@Test
	void testMod() {
		Calc miCalc = new Calc();
		assertEquals(2, miCalc.mod(5, 3));
	}

}
