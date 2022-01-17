/**
 * 
 */
package com.uvg.ejemplo1;

/**
 * @author MAAG
 *
 */
public interface IMemory {
	
	/***
	 * Save the value into the memory
	 * @param value value to be saved, must be a integer
	 */
	void saveValue(int value);
	
	/***
	 * Get the value saved
	 * @return integer value saved previously 
	 */
	int getValue();
}
