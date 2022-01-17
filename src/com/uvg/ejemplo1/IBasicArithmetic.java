/**
 * 
 */
package com.uvg.ejemplo1;

/**
 * @author MAAG
 *
 */
public interface IBasicArithmetic {
	
	/***
	 * Adds operator1 and operator2 returns the value 
	 * @param operator1 integer value
	 * @param operator2 integer value
	 * @return total after adds operator 1 and operator2
	 */
	int addition(int operator1, int operator2);
	
	/***
	 * Subtracts operator2 from operator1
	 * @param operator1 integer value
	 * @param operator2 integer value
	 * @return difference after substract operator1 from operator2
	 */
	int substraction(int operator1, int operator2);
	
	/***
	 * Multiplies operator1 by operator2
	 * @param operator1 integer value
	 * @param operator2 integer value
	 * @return result after multiplication
	 */
	int multiplication(int operator1, int operator2);
	
	/***
	 * Divides operator1 by operator2
	 * @param operator1 integer value
	 * @param operator2 integer value cannot be zero
	 * @return integer division
	 */
	int div(int operator1, int operator2);
	
	/***
	 * Computes the remainder of dividing operator1 by operator2
	 * @param operator1 integer value
	 * @param operator2 integer value cannot be zero
	 * @return the remainder of the devision
	 */
	int mod(int operator1, int operator2);
}
