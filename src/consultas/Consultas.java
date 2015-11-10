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
public class Consultas {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Tokenizer tokenizer = new Tokenizer("/home/moulay/Escritorio/Consultas/colecciones/quijote");
        
        List<Document> documentos = tokenizer.getTokens();
        
        /* while (tokens.hasMoreTokens())
         System.out.println(tokens.nextToken());*/
        
       Index indice = new Index(documentos);
      
    }

  
    
}
