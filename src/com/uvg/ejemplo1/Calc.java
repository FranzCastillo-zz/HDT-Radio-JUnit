/**
 * 
 */
package com.uvg.ejemplo1;

/**
 * @author MAAG
 *
 */
public class Calc implements IBasicArithmetic, IMemory {

	private int memory;
	
	public Calc() {
		memory = 0;
	}
	
	/***
	 * Save the value into the memory
	 * @param value value to be saved, must be a integer
	 */
	@Override
	public void saveValue(int value) {
		memory = value;
	}

	/***
	 * Get the value saved
	 * @return integer value saved previously 
	 */
	@Override
	public int getValue() {
		return memory;
	}

	/***
	 * Adds operator1 and operator2 returns the value 
	 * @param operator1 integer value
	 * @param operator2 integer value
	 * @return total after adds operator 1 and operator2
	 */
	@Override
	public int addition(int operator1, int operator2) {
		return operator1 + operator2;
	}

	/***
	 * Subtracts operator2 from operator1
	 * @param operator1 integer value
	 * @param operator2 integer value
	 * @return difference after substract operator1 from operator2
	 */
	@Override
	public int substraction(int operator1, int operator2) {
		return operator1 - operator2;
	}

	/***
	 * Multiplies operator1 by operator2
	 * @param operator1 integer value
	 * @param operator2 integer value
	 * @return result after multiplication
	 */
	@Override
	public int multiplication(int operator1, int operator2) {
		return operator1 * operator2;
	}

	/***
	 * Divides operator1 by operator2
	 * @param operator1 integer value
	 * @param operator2 integer value cannot be zero
	 * @return integer division
	 */
	@Override
	public int div(int operator1, int operator2) {
		return operator1 / operator2;
	}

	/***
	 * Computes the remainder of dividing operator1 by operator2
	 * @param operator1 integer value
	 * @param operator2 integer value cannot be zero
	 * @return the remainder of the devision
	 */
	@Override
	public int mod(int operator1, int operator2) {
		return operator1 % operator2;
	}

}
