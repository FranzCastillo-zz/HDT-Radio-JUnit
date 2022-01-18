import java.util.Scanner;

public class Radio implements IRadio{
    private boolean status;
    private int mode;
    private int[] freqsAM;
    private double[] freqsFM;
    private int actualFreqAM;
    private double actualFreqFM;
    private static int jumpAM = 10;
    private static double jumpFM = 0.2;
    private Scanner scan;
    
    public Radio(){
        status = false; //TURNED OFF
        mode = 1; // FM MODE
        freqsAM = new int[12];
        freqsFM = new double[12];
        actualFreqAM = 1070;
        actualFreqFM = 97.9;
        scan = new Scanner(System.in);
    }
    private void prnt(String texto){
        System.out.println(texto);
    }
    @Override
    public boolean getStatus() {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void switchButton() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void changeMode() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public int getActualMode() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void saveInAM(int slot, int freq) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public int getSavedFreqAM(int slot) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void saveInFM(int slot, double freq) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public double getSavedFreqFM(int slot) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public int getActualFreqAM() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public double getActualFreqFM() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public void moveForward() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void moveBackward() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void seek() {
        // TODO Auto-generated method stub
        
    }
}
