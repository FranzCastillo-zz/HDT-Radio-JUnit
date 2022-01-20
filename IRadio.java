/**
 * @author MAAG
 *
 */
public interface IRadio {
	
	/***
	 * Obtiene el estado del radio si esta encendio o apagado
	 * @return Devuelve true si esta encendido y false si esta apagado
	 */
	boolean getStatus();
	
	/***
	 * Metodo que sirve para apagar o encender el radio, si esta apagado lo enciendo
	 * si esta encendido lo apaga.
	 */
	void switchButton();
	
	/***
	 * Al mandar a llamar a este metodo se cambia el modo del radio si esta en AM lo cambia
	 * a FM y viceversa o cualquier otro estado actual
	 */
	void changeMode();
	
	/***
	 * Obtiene el modo actual del radio, teniendo los siguientes codigos
	 * 0 -> AM
	 * 1 -> FM
	 * @return devuelve 0 si esta en AM o 1 si esta en FM
	 */
	int getActualMode();
	
	/***
	 * Guarda una emisora AM en el slot indicado
	 * @param slot es un numero del 1 al 12 en donde se guardara la emisora
	 * @param freq Es la emisora que se desea guardar las cuales van desde la 530 a 1610 en multiplos de 10
	 */
	void saveInAM(int slot, int freq);
	
	/***
	 * Devuelve la emisora que fue guardad en el determinado slot
	 * @param slot el slot en donde se guardo la emisora
	 * @return la frequencia de la emisora guardada
	 */
	int getSavedFreqAM(int slot);
	
	/***
	 * Guarda una emisora en FM en el slot indicado
	 * @param slot es un numero del 1 al 12 en donde se guardara la emisora
	 * @param freq Es la emisora que se desa guardar las cuales van desde la 87.9 hasta la 107.9 en valores de 0.2
	 */
	void saveInFM(int slot, double freq);
	
	/***
	 * Devuelve la emisora que fue guardad en el determinado slot
	 * @param slot el slot en donde se guardo la emisora
	 * @return la frequencia de la emisora guardada
	 */
	double getSavedFreqFM(int slot);
	
	/***
	 * Devuelve la frecuencia actual en AM
	 * @return Frecuencia actual en AM
	 */
	int getActualFreqAM();
	
	/***
	 * Devuelve la frecuencia atual en FM
	 * @return Frecuencia actual en FM
	 */
	double getActualFreqFM();
	
	/***
	 * Avanza las emisoras hacia adelante en los multiplos definidos para AM y FM
	 */
	void moveForward();
	
	/***
	 * Regresa las emisoras hacia atras en los multiplos definidos para AM y FM
	 */
	void moveBackward();
	
	/***
	 * Busca automaticamente hacia adelante las emisoras
	 */
	void seek();
}