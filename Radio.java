public class Radio implements IRadio{
    private boolean status;
    private int mode;
    private int[] freqsAM;
    private double[] freqsFM;
    private int actualFreqAM;
    private double actualFreqFM;
    private static int jumpAM = 10;
    private static double jumpFM = 0.2;
    private static int[] limitsAM = {530, 1610};
    private static double[] limitsFM = {87.9, 107.9};
    
    public Radio(){
        status = false; //TURNED OFF
        mode = 1; // FM MODE
        freqsAM = new int[12];
        freqsFM = new double[12];
        actualFreqAM = 1070;
        actualFreqFM = 87.9;
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
        freqsFM[slot] = freq;
    }

    @Override
    public double getSavedFreqFM(int slot) {
        return freqsFM[slot];
    }

    @Override
    public int getActualFreqAM() {
        return actualFreqAM;
    }

    @Override
    public double getActualFreqFM() {
        return actualFreqFM;
    }

    @Override
    public void moveForward() {
        if(getActualMode() == 0){ //ES AM
            if (actualFreqAM == limitsAM[1]) { //FINAL DEL DIAL
                actualFreqAM = limitsAM[0];
            }
            else {
                actualFreqAM += jumpAM;
            }
        }else{ //ES FM
            if (actualFreqFM == limitsFM[1]) { //FINAL DEL DIAL
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
            if (actualFreqAM == limitsAM[0]) { //INICIO DEL DIAL
                actualFreqAM = limitsAM[1];
            }
            else {
                actualFreqAM -= jumpAM;
            }
        }else{ //ES FM
            if (actualFreqFM == limitsFM[0]) { //INICIO DEL DIAL
                actualFreqFM = limitsFM[1];
            }
            else {
                actualFreqFM -= jumpFM;
            }
        }
        
    }
    
    @Override
    public void seek() {
        // TODO Auto-generated method stub
        
    }
}
