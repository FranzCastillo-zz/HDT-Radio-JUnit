import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
	//Se instancian las clases de Radio y Scanner
	static Radio radio = new Radio();
    static Scanner scan = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        controlador();
    }
    
    private static void prnt(String texto){
        System.out.println(texto);
    }
    

    /**
     * Metodo de donde se controla todo lo que pasa en el programa
     */
    private static void controlador() {
    	if(turnedOffMenu().equals("s")) {
    		radio.switchButton();
    		
	    	while(radio.getStatus()) {	    		
	    		turnedOnRadio(radio.getActualFreqFM(), radio.getActualFreqAM(), radio.getStatus());
	    		turnedOnMenu();
	    		
	    	}
    	}
    }
    
    
    /**
     * Metodo que le despliega la GUI del radio encendido al usuario
     * @param freqFM la emisora actual en FM
     * @param freqAM la emisora actual en AM
     * @param status el estado de la radio, ya sea AM o FM
     */
    private static void turnedOnRadio(double freqFM, int freqAM, boolean status) {
    	String fm = "Emisora: " + freqFM + " FM\n" ;
    	String am = "Emisora: " + freqAM + " AM\n" ;
    	
    	String buttons = "Boton 1 \t" + " Boton 5 \t" + "Boton 9 \n" +
    					 "Boton 2 \t" + " Boton 6  \t" + "Boton 10 \n" +
    					 "Boton 3 \t" + " Boton 7  \t" + "Boton 11 \n" +
    					 "Boton 4 \t" + " Boton 8  \t" + "Boton 12 \n" ;
    	
    	String options = "pulse 'n' para la siguiente emisora o pulse 'p' para  la enterior \n"+
    					 "pulse 's' para iniciar o detener el seek \n" +
    					 "pulse 'e' para apagar la radio";  
    	
    	if(radio.getActualMode() == 0) {
    		prnt(am +  buttons);    		
    	}else {
    		prnt(fm + buttons);
    	}
    }
    
    /**
     * metodo que le prgunta al usario acerca de las opciones desplegadas en la GUI de
     * la radio encendida
     * @return devuelve el dato ingresado por el usuario
     */
    private static String turnedOnMenu(){
    	String option = null;
    	try{
    		prnt("Ingrese una opcion: ");
    		option = scan.nextLine();
    		    		
    		
    	}catch(Exception e) {
    		prnt("Intente de nuevo");
    	}
    	return option;    	
    }
    
    /**
     * Metodo que le pregunta al usuario si desea encender la radio
     * @return
     */
    private static String turnedOffMenu() {
    	prnt("El radio esta apagado, desea encenderlo? (s/n)");
    	
    	String option = null;
    	try {
    		option = scan.nextLine();
    		
    		if((option.equals("s") == false ) && (option.equals("n") == false )) {
    			throw new InputMismatchException();
    		}
    		
    	}catch(InputMismatchException e) {
    		prnt("La opcion que usted ingreso es incorrecta");    		
    		option = turnedOffMenu();    		
    	}
    	
    	return option;
    }
}
