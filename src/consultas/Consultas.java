/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.util.Map.Entry;
import java.util.StringTokenizer;


/**
 *
 * @author moulay
 */
public class Consultas {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Tokenizer tokenizer = new Tokenizer("/home/moulay/Escritorio/Consultas/colecciones/quijote");
        
        StringTokenizer tokens = tokenizer.getTokens();
        
        /* while (tokens.hasMoreTokens())
         System.out.println(tokens.nextToken());*/
        
        Index indice = new Index(tokens);
        
       
        
        
        for(String token: indice.getTokenList()) {
            System.out.println("El token: '" + token + "' aparece " + indice.getFrequency(token) + " veces");
        }
        
       
      
        
        
        //SnowballStemmer stemmer;
        //stemmer = (SnowballStemmer) new spanishStemmer();
        //while(tokens.hasMoreTokens()) {
        //    System.out.println(tokens.nextToken());
            //stemmer.setCurrent(tokens.nextToken());
            //if(stemmer.stem()) {
            //    System.out.println(stemmer.getCurrent());
            //}
        //}
    }
    
}
