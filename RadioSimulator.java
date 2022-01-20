import javax.lang.model.util.ElementScanner14;

public class RadioSimulator {
    private Radio radio;
    private Vista v;

    public RadioSimulator(){
        radio = new Radio();
        v = new Vista();
    }
    
    /**
     * Metodo de donde se controla todo lo que pasa en el programa
     */
    public void execute(){
        while(true){
            while(!radio.getStatus() && v.turnOn()){ // SOPLO SI ESTA APAGADO Y DESEA PRENDER, ENTRA
                radio.switchButton();
            }
            // EN ESTE PUNTO LA RADIO YA ESTA ENCENDIDA
            while(radio.getStatus()){ // MIENTRAS LA RADIO SE MANTENGA ENCENDIDA
                int actualAM = radio.getActualFreqAM();
                double actualFM = radio.getActualFreqFM();
                int mode = radio.getActualMode();

                int option = v.menu(actualFM, actualAM, mode);
                switch(option){
                    case 1: // CAMBIAR MODO
                        radio.changeMode();
                    break;
                    case 2: // AVANZAR EMISORAS
                        radio.moveForward();
                    break;
                    case 3: // RETROCEDER EMISORAS
                        radio.moveBackward();
                    break;
                    case 4: // GUARDAR EMISORA
                        int slot = v.askSlot();
                        if(mode == 0){ // AM
                            radio.saveInAM(slot, actualAM);
                        }else{
                            radio.saveInFM(slot, actualFM);
                        }
                    break;
                    case 5: // SELECCIONAR EMISORA
                    break;
                    case 6: // SEEK
                        
                    break;
                    case 7:
                        radio.switchButton();
                    break;
                }
            }    
        }        
    }
}
