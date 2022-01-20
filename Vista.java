import java.util.Scanner;
import java.util.InputMismatchException;

public class Vista {
    Scanner scan;
    public Vista(){
        scan = new Scanner(System.in);
    }

    private void prnt(String text){
        System.out.println(text);
    }

    private void invalidOption(){
        prnt("Ingrese una opcion valida.");
    }

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
        prnt("1. Cambiar modo (AM a FM a AM)");
        prnt("2. Avanzar emisora");
        prnt("3. Retroceder emisora");
        prnt("4. Guardar emisora actual");
        prnt("5. Seleccionar emisora guardada");
        prnt("6. Seek");
        prnt("7. Apagar la radio\n");
        while(true){
            prnt("Ingrese el numero de opcion deseado: (1-7)");
            try{
                int option = scan.nextInt();
                scan.nextLine();
                if(option >= 1 && option <= 7){
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

    public int askSlot(){ // EN CASO DE QUE SEA AM
        while(true){
            prnt("Que numero de emisora guardada desea reproducir? (1-12");
            try{
                int option = scan.nextInt();
                scan.nextLine();
                if(option >= 1 && option <= 12){
                    return option - 1;
                }else{
                    throw new InputMismatchException();
                }
            }catch(InputMismatchException e){
                scan.next();
                invalidOption();
            }
        }
    }
}
