import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests {
    @Test
    public void testPrenderRadio(){
        /*
            Probar Prender cuando
                esta prendido
                esta apagado
        */
    }

    @Test
    public void testApagarRadio(){
        /*
            Probar apagar cuando
                esta prendido
                esta apagado
        */
    }

    @Test
    public void testCambiarAMaFM(){

    }

    @Test
    public void testCambiarFMaAM(){
        
    }

    @Test
    public void testAvanzarEmisorasAM(){
        Radio radio = new Radio();
        int testFreq = radio.getActualFreqAM() + 10;
        radio.changeMode(); //se cambia a AM
        radio.moveForward();
        assertEquals(testFreq, radio.getActualFreqAM());
    }

    @Test
    public void testAvanzarEmisorasFM(){
        Radio radio = new Radio();
        double testFreq = radio.getActualFreqFM() + 0.2;
        testFreq = Math.round(testFreq*10.0)/10.0; //redondear
        radio.moveForward();
        assertEquals(testFreq, radio.getActualFreqFM(), 0d);
    }

    @Test
    public void testGuardarEmisoraAM(){
        Radio radio = new Radio();
        int testFreq = radio.getActualFreqAM();
        radio.saveInAM(1, testFreq);
        assertEquals(testFreq, radio.getSavedFreqAM(1));
    }
    @Test
    public void testGuardarEmisoraFM(){
        Radio radio = new Radio();
        double testFreq = radio.getActualFreqFM();
        radio.saveInFM(1, testFreq);
        assertEquals(testFreq, radio.getSavedFreqFM(1), 0d);
    }
    @Test
    public void testReproducirEmisoraGuardadaAM(){
        Radio radio = new Radio();
        radio.changeMode();
        int savedFreq = radio.getActualFreqAM();
        radio.saveInAM(1, savedFreq);
        radio.moveForward();
        while(radio.getActualFreqAM() != radio.getSavedFreqAM(1)){
            radio.moveForward();
        }
        assertEquals(savedFreq, radio.getActualFreqAM());
    }
    @Test
    public void testReproducirEmisoraGuardadaFM(){
        Radio radio = new Radio();
        double savedFreq = radio.getActualFreqFM();
        radio.saveInFM(1, savedFreq);
        radio.moveForward();
        while(radio.getActualFreqFM() != radio.getSavedFreqFM(1)){
            radio.moveForward();
        }
        assertEquals(savedFreq, radio.getActualFreqFM(), 0.1);
    }
}
