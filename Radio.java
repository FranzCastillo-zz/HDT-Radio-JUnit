
import java.util.HashMap;

public class Radio implements IRadio {

    private int Estacion = 0;
    private boolean EstadoRadio = false;
    private int FrecuenciaAM;
    private double FrecuenciaFM;
    private HashMap<Integer, Integer> RadiosAM = new HashMap<Integer, Integer>();
    private HashMap<Integer, Double> RadiosFM = new HashMap<Integer, Double>();

    @Override
    public boolean getStatus() {
        return EstadoRadio;
    }

    @Override
    public void switchButton() {
       
        if(EstadoRadio == false){

            EstadoRadio = true;
            System.out.println("radio encendida");
        }
        else {
            EstadoRadio = false;
            System.out.println("radio apagada");
        }
        
    }

    @Override
    public void changeMode() {
        
        if(Estacion == 0){

            Estacion = 1; 

        }else{

            Estacion = 0;

        }
        System.out.println("se ha cambiado de estación");
        
    }

    @Override
    public int getActualMode() {
        return Estacion;
    }

    @Override
    public void saveInAM(int slot, int freq) {
        if (RadiosAM.containsKey(slot) ==  false){
            RadiosAM.put(slot, freq);
            System.out.println("Se ha guardado la frecuencia: "+freq+ " en el espacio: "+slot);
        }
        else {
                System.out.println("Ya asignaste una frecuencia a este boton: "+getSavedFreqAM(slot));
        }
    }

    @Override
    public int getSavedFreqAM(int slot) {
        int frecuencia = RadiosAM.get(slot);
        FrecuenciaAM = frecuencia;
        return frecuencia;
    }

    @Override
    public void saveInFM(int slot, double freq) {
        if (RadiosFM.containsKey(slot) == false){
            RadiosFM.put(slot, freq);
            System.out.println("Se ha guardado la frecuencia: "+freq+ " en el espacio: " + slot);        
        }
        else{
            System.out.println("Ya asignaste una frecuencia con este boton: "+ getSavedFreqFM(slot));
        }
    }

    @Override
    public double getSavedFreqFM(int slot) {
        double frecuencia = RadiosFM.get(slot);
        FrecuenciaFM = frecuencia;
        return frecuencia;
    }

    @Override
    public int getActualFreqAM() {
        return FrecuenciaAM;
    }

    @Override
    public double getActualFreqFM() {
        return FrecuenciaFM;
    }

    @Override
    public void moveForward() {
        if(Estacion == 0) {
        	FrecuenciaAM = FrecuenciaAM + 100;
        }else {
        	FrecuenciaFM = FrecuenciaFM + 0.2;
        }
 
    }

    @Override
    public void moveBackward() {
        if(Estacion == 0) {
        	FrecuenciaAM = FrecuenciaAM - 100;
        }else {
        	FrecuenciaFM = FrecuenciaFM - 0.2;
        }
 
    }

    @Override
    public void seek() {
    	boolean busqueda = true;
    	while(busqueda == true) {
    		if(Estacion == 0) {
            	int frecuencia = FrecuenciaAM;
            	int valorBajo = 1166400;
            	for(int i = 0; i<= 11; i++) {
            		int valor = RadiosAM.get(i);
            		int diferencia = valor - frecuencia;
            		int cuadrado = diferencia * diferencia;
            		if(cuadrado < valorBajo) {
            			valorBajo = cuadrado;
            			FrecuenciaAM = valor;
            		}
            	}
            	busqueda = false;
            	
            }else {
            	double Frecuencia = FrecuenciaFM;
    			double valorBajo = 400.0;
            	for(int i = 0; i<= 11; i++) {
            		double valor = RadiosFM.get(i);
            		double diferencia = valor - Frecuencia;
            		double cuadrado = diferencia * diferencia;
            		if(cuadrado < valorBajo) {
            			valorBajo = cuadrado;
            			FrecuenciaFM = valor;
            		}
            	}
            	busqueda = false;
            }
    	}
        
    }
    
}
