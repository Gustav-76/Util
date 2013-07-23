package gustav.util.validator.person.rut;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase encargada de validar un rut.
 *
 * @author Gustavo Mejías <gustavo.mejias at kimn-it.cl>
 * @version     %I%, %G%
 * @since       1.0
 */
public class RutValidator {
    
    private static final int        DIGITS_AMOUNT       = 11;
    
    /**
     * Return <code>true</code> if rut corresponds with verificationDigit.
     * 
     * <p>The <code>rut</code> String doesn't use dot or dash ('.' or '-').</p>
     * 
     * @param rut
     * @param verificationDigit
     * @return <code>true</code> if rut corresponds with verificationDigit;
     * otherwise <code>false</code>.
     */
    public static boolean validateRut(String rut, String verificationDigit){
        
        boolean isValid = false;
        int obtainedVerificationDigit, recievedVerificationDigit;
        
        if(verificationDigit.equals("K") || verificationDigit.equals("k")){
            recievedVerificationDigit = 10;
        }
        else if(verificationDigit.endsWith("0")){
            recievedVerificationDigit = 11;
        }
        else{
            recievedVerificationDigit = Integer.parseInt(verificationDigit);
        }
        
        obtainedVerificationDigit = getVerificationDigit(rut);
        
        if(obtainedVerificationDigit == recievedVerificationDigit){
            isValid = true;
        }
        
        return isValid;
    }
    
    /**
     * Return <code>true</code> if rut corresponds with verificationDigit.
     * 
     * <p>The <code>rut</code> String format can be:</p>
     * <ul>
     *  <li>"12345678-9"</li>
     *  <li>"12.345.678-9"</li>
     * </ul>
     * 
     * @param rut
     * @return <code>true</code> if rut corresponds with verificationDigit;
     * otherwise <code>false</code>.
     */
    public static boolean validateRut(String rut){
        StringBuilder sb = new StringBuilder();
        
        String verificationDigit = rut.substring(rut.length()-1);
        rut = rut.substring(0, rut.length()-2);
        
        String[] rutAsArray = rut.split("\\.");
        for(int i = 0; i < rutAsArray.length; i++){
            rut = sb.append(rutAsArray[i]).toString();
        }
        
        return validateRut(rut, verificationDigit);
    }

    public static int getVerificationDigit(String rut) {
        
        List<Integer> digits = new ArrayList();
        int beginIndex = rut.length() -1 ;
        int digit, obtainedVerificationDigit;
        int total = 0;
        
        while(rut.length() > 1){
            digit = Integer.parseInt(rut.substring(beginIndex)); 
            digits.add(digit);
            rut = rut.substring(0, beginIndex);
            beginIndex--;
            
        }
        
        digit = Integer.parseInt(rut);
        digits.add(digit);
        
        for(int i = 0; i < digits.size(); i++){
            total += digits.get(i) * ((i%6)+2);
        }
        
        obtainedVerificationDigit = DIGITS_AMOUNT - (total % DIGITS_AMOUNT);
        
        return obtainedVerificationDigit;
    }

}
