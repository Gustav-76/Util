package gustav.util.validator.person.rut;

import org.junit.Assert;
import org.junit.Test;

/**
 * Clase que implementa pruebas unitarias de {@link RutValidator}.
 *
 * @author Gustavo Mejías <gustavo.mejias at kimn-it.cl>
 * @version     %I%, %G%
 * @since       1.0
 */
public class RutValidatorRutTest {
    
    @Test
    public void validateRut_validationTrue(){
        
        Assert.assertTrue(RutValidator.validateRut("1", "9"));
        Assert.assertTrue(RutValidator.validateRut("16609740", "1"));
        Assert.assertTrue(RutValidator.validateRut("17303374", "5"));
        
        Assert.assertTrue(RutValidator.validateRut("1-9"));
        Assert.assertTrue(RutValidator.validateRut("16609740-1"));
        Assert.assertTrue(RutValidator.validateRut("17.303.374-5"));
    
    }
    
    @Test
    public void validateRut_validationFalse(){
        
        Assert.assertFalse(RutValidator.validateRut("1", "8"));
        
        Assert.assertFalse(RutValidator.validateRut("16609740", "2"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "3"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "4"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "5"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "6"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "7"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "8"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "9"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "0"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "k"));
        Assert.assertFalse(RutValidator.validateRut("16609740", "K"));
                
        Assert.assertFalse(RutValidator.validateRut("1-8"));
        Assert.assertFalse(RutValidator.validateRut("16609740-2"));
        Assert.assertFalse(RutValidator.validateRut("17.303.374-4"));
    }

}
