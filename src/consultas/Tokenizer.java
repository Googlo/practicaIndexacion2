/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author moulay
 */
    public class Tokenizer {
    ArrayList<File> listaFicheros = new ArrayList();
    
    public void addFiles(File file) {
        if (!file.exists()){
           System.out.println (file + " no existe."); 
        } else if(file.isDirectory()) {
// Devuelve una matriz de nombres de ruta abstractas que denotan los archivos
//en el directorio indicado por esta ruta abstracto
            for(File f: file.listFiles()){   // para cada fichero que haya en lista de ficheros
                addFiles(f);
            }
        } else {
            listaFicheros.add(file);
        }
    }
    
    public Tokenizer(String ruta) {  
        File directorio = new File(ruta);
        addFiles(directorio);

    }
    
    public String readFile(File f) throws FileNotFoundException {
        String texto = "";
        BufferedReader br = new BufferedReader(new FileReader(f));
        try {
            String line = br.readLine();

            while (line != null) {
                
                texto = texto + line + System.lineSeparator();
                line = br.readLine();
            }
            br.close();
            
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return texto;
    }
    
    String remplazar(String texto) {
        return texto.replaceAll("[\\.,¿?!¡;()'\"«»<>:]", "").toLowerCase();
    }
    
    StringTokenizer getTokens() {
        String texto = "";
        
        
        for(File f: listaFicheros) {
            
            try {
                texto = texto + readFile(f);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        
        StringTokenizer tokens = new StringTokenizer(remplazar(texto));
        return tokens;
    }
}
