import java.util.Random;

public class Radio implements IRadio{
    private boolean status;
    private int mode;
    private int[] freqsAM;
    private double[] freqsFM;
    private int actualFreqAM;
    private double actualFreqFM;
    private static int jumpAM = 10;
    private static double jumpFM = 0.2d;
    private static int[] limitsAM = {530, 1610};
    private static double[] limitsFM = {87.9, 107.9};
    
    public Radio(){
        status = false; //TURNED OFF
        mode = 1; // FM MODE
        freqsAM = new int[12];
        freqsFM = new double[12];
        actualFreqAM = 1610;
        actualFreqFM = 107.9;
    }
    @Override
    public boolean getStatus() {
        return status;
    }

    @Override
    public void switchButton() {
        if (status) {
        	status = false;
        }else {
        	status = true;
        }
        
    }

    @Override
    public void changeMode() {
        if(getActualMode() == 0){
            mode = 1;
        }else{
            mode = 0;
        }
    }

    @Override
    public int getActualMode() {
        return mode;
    }

    @Override
    public void saveInAM(int slot, int freq) {
        freqsAM[slot] = freq;
    }

    @Override
    public int getSavedFreqAM(int slot) {
        return freqsAM[slot];
    }

    @Override
    public void saveInFM(int slot, double freq) {
        freqsFM[slot] = Math.round(freq*10.0)/10.0;
    }

    @Override
    public double getSavedFreqFM(int slot) {
        return  Math.round(freqsFM[slot]*10.0)/10.0;
    }

    @Override
    public int getActualFreqAM() {
        return actualFreqAM;
    }

    @Override
    public double getActualFreqFM() {
        return Math.round(actualFreqFM*10.0)/10.0;
    }

    @Override
    public void moveForward() {
        if(getActualMode() == 0){ //ES AM
            if (actualFreqAM >= limitsAM[1]) { //FINAL DEL DIAL
                actualFreqAM = limitsAM[0];
            }
            else {
                actualFreqAM += jumpAM;
            }
        }else{ //ES FM
            if (actualFreqFM >= limitsFM[1]) { //FINAL DEL DIAL
                actualFreqFM = limitsFM[0];
            }
            else {
                actualFreqFM += jumpFM;
            }
        }
    }

    @Override
    public void moveBackward() {
        if(getActualMode() == 0){ //ES AM
            if (actualFreqAM <= limitsAM[0]) { //INICIO DEL DIAL
                actualFreqAM = limitsAM[1];
            }
            else {
                actualFreqAM -= jumpAM;
            }
        }else{ //ES FM
            if (actualFreqFM <= limitsFM[0]) { //INICIO DEL DIAL
                actualFreqFM = limitsFM[1];
            }
            else {
                actualFreqFM -= jumpFM;
            }
        }
        
    }
    
    @Override
    public void seek() { //Genera un numero random entre el rango de las frecuencias dependiendo el modo
        Random rnd = new Random(); 
        if(getActualMode() == 0) { //ES AM
            actualFreqAM = (int) (530 + (1610 - 530) * rnd.nextDouble()); 
        }
        else { //ES FM
            actualFreqFM = 87.9 + (107.9 - 87.9) * rnd.nextDouble();
        }
        
    }
}
