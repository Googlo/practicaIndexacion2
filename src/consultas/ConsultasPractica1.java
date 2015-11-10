/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import static java.lang.Math.log;
import java.util.List;
import java.util.Map.Entry;
import java.util.StringTokenizer;


/**
 *
 * @author moulay
 */
public class ConsultasPractica1 {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        TokenizerPractica1 tokenizer = new TokenizerPractica1("/home/moulay/Escritorio/Consultas/colecciones/ParlamentoPDF");
        
        StringTokenizer tokens = tokenizer.getTokens();
        
        /* while (tokens.hasMoreTokens())
         System.out.println(tokens.nextToken());*/
        
       IndexPractica1 indice = new IndexPractica1(tokens);
        
       
        
       // mostrar cuanta veces aparece cada token sin ordenar 
       System.out.println("mostrar sin ordenar:");
       /* for(String token: indice.getTokenList()) {
            System.out.println("El token: '" + token + "' aparece " + indice.getFrequency(token) + " veces");
        }*/
       
        System.out.println("Ordenada por frecuencia:");   
        
       /* for(Entry<String, Integer> freq: indice.getTokenListOrdered()) {
           System.out.println(freq.getKey() + ":" + freq.getValue());
        }*/
        String guardar="/home/moulay/Escritorio/Consultas/parlamentopdf.dat";
         PrintStream out = new PrintStream(new FileOutputStream(guardar));
         System.setOut(out);
        // System.out.println("Ordenada por frecuencia y ranking:");  
        List<Entry<String, Integer>> frecuencias = indice.getTokenListOrdered();
        for(int i = 0; i < frecuencias.size() && frecuencias.get(i).getValue()!=1 ; i++) {
            System.out.println(log(i+1) + " " + log(frecuencias.get(i).getValue()) );
         
        }
        
    
         
        // System.out.println("suma de terminos que hay en don quijote:");  
        /*  List<Entry<String, Integer>> frecuencias = indice.getTokenListOrdered();
          Integer a=0 ;
        for(int i = 0; i < frecuencias.size(); i++) {
            a=a+frecuencias.get(i).getValue();
        }
        System.out.println(a);//379859 terminos don quijote*/
        
       //pdf 549272 sin mas opciones
       // pdf 1915365 con opciones en 36 segundos
      
        
        
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
