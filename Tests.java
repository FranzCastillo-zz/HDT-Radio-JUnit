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
    public void testAvanzarEmisoras(){
        /* 
            La prueba tiene que ser para AM y FM
            Probar avanzar normal
            Probar avanzar cuando esta en el limite superior
        */
        Radio radio = new Radio();
        int firstFreqAM = radio.getActualFreqAM();
        
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
}
