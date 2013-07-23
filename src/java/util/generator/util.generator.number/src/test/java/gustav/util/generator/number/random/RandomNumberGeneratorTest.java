package gustav.util.generator.number.random;

import org.junit.Assert;
import org.junit.Test;

/**
 * Clase que implementa pruebas unitarias de {@link RandomNumberGenerator}.
 *
 * @author Gustavo Mejías <gustavo.mejias at kimn-it.cl>
 * @version     %I%, %G%
 * @since       1.0
 */
public class RandomNumberGeneratorTest {
    
    @Test
    public void generateRandomNumber_success(){
        
        //Assert.assertSame(0, RandomNumberGenerator.generateRandomNumber(0, 1));
        Assert.assertNotEquals(1, RandomNumberGenerator.generateRandomNumber(2, 10));
        
    }

}
