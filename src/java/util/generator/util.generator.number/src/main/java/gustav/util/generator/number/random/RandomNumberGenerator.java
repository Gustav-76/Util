package gustav.util.generator.number.random;

import java.util.Date;
import java.util.Random;

/**
 * Clase que se encarga de generar números aleatorios a 
 * partir de los datos recibidos.
 *
 * @author Gustavo Mejías <gustavo.mejias at kimn-it.cl>
 * @version     %I%, %G%
 * @since       1.0
 */
public class RandomNumberGenerator {
    
    /**
     * Generate random number between <code>minNumber</code> and
     * <code>maxNumnber</code>.
     * 
     * @param minNumber
     * @param maxNumber
     * @return 
     */
    public static int generateRandomNumber(int minNumber, int maxNumber){
        
        int generatedRandomNumner;
        Date actualDate = new Date();
        Random randomGenertor = new Random(actualDate.getTime());
        
        generatedRandomNumner = randomGenertor.nextInt(maxNumber - minNumber) + minNumber;
        
        return generatedRandomNumner;
    }

}
