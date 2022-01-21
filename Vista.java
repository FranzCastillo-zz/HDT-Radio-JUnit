import java.util.Scanner;
import java.util.InputMismatchException;

public class Vista {
    Scanner scan;
    public Vista(){
        scan = new Scanner(System.in);
    }

    
    /** 
     * Imprime en la consola el texto indicado
     * @param text es el texto que desea que se muestre
     */
    private void prnt(String text){
        System.out.println(text);
    }

    /**
     * Muestra en la consola que el usuario ha ingresado una opcion invalida
     */
    public void invalidOption(){
        prnt("Ingrese una opcion valida.");
    }

    
    /** 
     * Solicita al usuario el ingreso de un numero entero
     * @param lowerLimit es el menor numero que puede ingresar
     * @param higherLimit es el mayor numero que puede ingresar
     * @return int el numero ingresado por el usuario
     */
    private int askInt(int lowerLimit, int upperLimit){
        while(true){
            try{
                int option = scan.nextInt();
                scan.nextLine();
                if(option >= lowerLimit && option <= upperLimit){
                    return option;
                }else{
                    throw new InputMismatchException();
                }
            }catch(InputMismatchException e){
                scan.next();
                invalidOption();
            }
        }
    }

    
    /**
     * Muestra el menu para encender la radio
     * @return true si el usuario desea encenderla, false si no
     */
    public boolean turnOn(){
        while(true){
            prnt("Desea encender la radio? S/N");
            try{
                String option = scan.nextLine().toUpperCase();
                if(option.equals("S")){
                    prnt("*prendiendo radio*\n");
                    return true;
                }else if(option.equals("N")){
                    return false;
                }else{
                    throw new InputMismatchException();
                }    
            }catch(InputMismatchException e){
                invalidOption();
            }
        }
    }

    
    /** 
     * Muestra el menu principal de la radio
     * @param actualFM la frecuencia actual FM
     * @param actualAM la frecuencia actual AM
     * @param actualMode el modo actual de la radio (0 AM || 1 FM)
     * @return int El numero de opcion que desea
     */
    public int menu(double actualFM, int actualAM, int actualMode){
        prnt("\nLa Radio esta encendida!\n");
        prnt("Emisora FM Actual: " + actualFM);
        prnt("Emisora AM Actual: " + actualAM);
        if(actualMode == 0){
            prnt("Modo actual: AM\n");
        }else{
            prnt("Modo actual: FM\n");
        }
        prnt("Que desea hacer?");
        prnt("1. Cambiar modo (AM <--> FM)");
        prnt("2. Avanzar emisora");
        prnt("3. Retroceder emisora");
        prnt("4. Guardar emisora actual");
        prnt("5. Seleccionar emisora guardada");
        prnt("6. Seek");
        prnt("7. Apagar la radio\n");
        return askInt(1, 7);
    }

    
    /** 
     * Pregunta al usuario el numero de boton en el que desea guardar la emisora
     * @return int el numero de boton en un rango de 0 a 11
     */
    public int askSavingSlot(){
        prnt("En que numero de boton desea guardar la emisora? (1-12)");
        return askInt(1, 12) - 1;
    }

    
    /** 
     * Pregunta al usuario el numero de emisora que desea reproducir
     * @return int el numero de boton en un rango de 0 a 11
     */
    public int askPlayingSlot(){
        prnt("Que numero de boton desea reproducir? (1-12)");        
        return askInt(1, 12) - 1;
    }
}
