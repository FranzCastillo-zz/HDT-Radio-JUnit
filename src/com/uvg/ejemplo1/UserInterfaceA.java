/**
 * 
 */
package com.uvg.ejemplo1;

import java.util.Scanner;

/**
 * @author MAAG
 *
 */
public class UserInterfaceA {

	/***
	 * Saves the data into the memory of the calc
	 * @param value
	 * @param actualCalc
	 * @param optmemoria
	 */
	private static void saveData(int value, Calc actualCalc, Scanner optmemoria) {
		System.out.println("Si desea guardar el resultado presione: y");
		
		if ( optmemoria.nextLine().equalsIgnoreCase("y") ) {
			actualCalc.saveValue(value);
		}
		
	}
	
	/***
	 * Select which operator the user needs
	 * @param actualCalc
	 * @param optmemoria
	 * @return
	 */
	private static int inputOperator(Calc actualCalc, Scanner optmemoria) {
		System.out.println("Ingrese el operador o la letra m si desea utilizar el valor almacenado en memoria");
		String inputValue = optmemoria.nextLine();
		
		if ( inputValue.equalsIgnoreCase("m") ) {
			return actualCalc.getValue();
		} else {
			return Integer.parseInt(inputValue);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("*** Bienvenido a Calculadora ***");
		
		int opt = 0;
		Calc calculadora = new Calc();
		
		Scanner in = new Scanner(System.in);
		
		do {
			
			System.out.println("Seleccione su opcion");
			System.out.println("1. Suma");
			System.out.println("2. Resta");
			System.out.println("3. Multiplicacion");
			System.out.println("4. Division");
			System.out.println("5. Residuo");
			System.out.println("6. Salir");
			
			opt = Integer.parseInt(in.nextLine());
			
			switch(opt) {
			case 1: {
				int result = calculadora.addition(
							inputOperator(calculadora, in), 
							inputOperator(calculadora, in)
						);
				
				System.out.println("El total es: " + result);
				saveData(result, calculadora, in);
				} break;
				
			case 2: {
				int operator1 = inputOperator(calculadora, in);
				int operator2 = inputOperator(calculadora, in);
				int result = calculadora.substraction(operator1, operator2);
				System.out.println("La diferencia es: " + result);
				saveData(result, calculadora, in);
			} break;
			
			case 3: {
				int result = calculadora.multiplication(
						inputOperator(calculadora, in), 
						inputOperator(calculadora, in)
					);
				System.out.println("El producto es: " + result);
				saveData(result, calculadora, in);
			} break;
			
			case 4: {
				
				int result = calculadora.div(
						inputOperator(calculadora, in), 
						inputOperator(calculadora, in)
					);
				
				System.out.println("El cociente es: " + result);
				saveData(result, calculadora, in);
			} break;
			
			case 5: {
				
				int result = calculadora.mod(
						inputOperator(calculadora, in), 
						inputOperator(calculadora, in)
					);
				
				System.out.println("El residuo es: " + result);
				saveData(result, calculadora, in);
			} break;
			
			case 6:{
				System.out.print("¡Hasta luego!");
			}
			
			default:{
				System.out.print("Opción no válida");
			}break;
			
			}
			
			
		}while(opt != 6);

	}

}
