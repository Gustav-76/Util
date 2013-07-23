package gustav.util.generator.person.rut;

import gustav.util.generator.number.random.RandomNumberGenerator;
import gustav.util.validator.person.rut.RutValidator;

/**
 * Clase encargada de generar ruts.
 *
 * @author Gustavo Mejías <gustavo.mejias at kimn-it.cl>
 * @version     %I%, %G%
 * @since       1.0
 */
public class RutGenerator {
    
    @Deprecated
    public static String generateRutByLength(int length){
        
        String generatedRut = "";
        String verificationDigit;
        String tempRut;
        
//        for(int i = 0; i < length; i++){
//            tempRut = generatedRut;
//            for(int j = 0; j < 11; j++){
//                //generatedRut += j;  //CAMBIAR POR NÚMERO ALEATORIO
//                generatedRut += RandomNumberGenerator.generateRandomNumber(j, 9);
//                verificationDigit = ""+RutValidator.getVerificationDigit(generatedRut);
//                if(RutValidator.validateRut(generatedRut, verificationDigit)){
//                    break;
//                }
//                if(j == 11){
//                    generatedRut = tempRut;
//                }
//            }
//        }
        
        //for(int i = 0; i < length; i++){
            generatedRut += (RandomNumberGenerator.generateRandomNumber(1000000, 99999999));
        //}
        
        verificationDigit = ""+RutValidator.getVerificationDigit(generatedRut);
        
        if(Integer.parseInt(verificationDigit) == 10){
            generatedRut += "-K"; 
        }
        else if(Integer.parseInt(verificationDigit) == 11){
            generatedRut += "-0"; 
        }
        else {
            generatedRut += "-"+verificationDigit; 
        }
        
        return generatedRut;
    }
    
    public static String generateRutByLength(){
        
        String generatedRut = "";
        String verificationDigit;
        
        generatedRut += (RandomNumberGenerator.generateRandomNumber(1000000, 99999999));
        
        verificationDigit = ""+RutValidator.getVerificationDigit(generatedRut);
        
        if(Integer.parseInt(verificationDigit) == 10){
            generatedRut += "-K"; 
        }
        else if(Integer.parseInt(verificationDigit) == 11){
            generatedRut += "-0"; 
        }
        else {
            generatedRut += "-"+verificationDigit; 
        }
        
        return generatedRut;
    }

}
