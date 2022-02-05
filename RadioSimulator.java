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
                        int savingSlot = v.askSavingSlot();
                        if(mode == 0){ // AM
                            radio.saveInAM(savingSlot, actualAM);
                        }else{
                            radio.saveInFM(savingSlot, actualFM);
                        }
                    break;
                    case 5: // SELECCIONAR EMISORA
                        int playingSlot = v.askPlayingSlot();
                        if(mode == 0){ // AM
                            int savedSlotAM = radio.getSavedFreqAM(playingSlot);
                            if(savedSlotAM == 0){ // SI NO HAY GUARDADO NADA
                                v.invalidOption();
                            }else{
                                while(radio.getActualFreqAM() != savedSlotAM){
                                    radio.moveForward();
                                }
                            }
                        }else{
                            double savedSlotFM = radio.getSavedFreqFM(playingSlot);
                            if(savedSlotFM == 0){
                                v.invalidOption();
                            }else{
                                while(radio.getActualFreqFM() != savedSlotFM){
                                    radio.moveForward();
                                }
                            }
                        }
                    break;
                    case 6: // SEEK
                        radio.seek();
                    break;
                    case 7:
                        radio.switchButton();
                    break;
                }
            }    
        }        
    }
}
