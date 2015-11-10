/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 *
 * @author moulay
 */
public class TokenizerPractica1 {
    private ArrayList<File> listaFicheros = new ArrayList();
    private Tika tika = new Tika();
    
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
    
    public TokenizerPractica1(String ruta) {  
        File directorio = new File(ruta);
        addFiles(directorio);

    }
    
    public String readFile(File f) throws FileNotFoundException {
        String texto = "";
        try {
            //InputStream representa el stream de bytes del que lee el parser
            // el flujo de documento
            InputStream is = new FileInputStream(f);
            // datos de documento
            Metadata metadata = new Metadata();
            //Manejador de contenido
            //writeLimit - número máximo de caracteres para incluir en la cadena
            ContentHandler ch = new BodyContentHandler(10*1024*1024);
            //Contexto de análisis. Se utiliza para pasar información contextual para analizadores Tika
            ParseContext parseContext = new ParseContext();
            //Crea una instancia del analizador automático de detección utilizando la configuración por defecto Tika.
            AutoDetectParser parser = new AutoDetectParser();
            //Analiza una corriente documento en una secuencia de eventos XHTML SAX. Rellena los metadatos de documentos relacionados en el objeto de metadatos dado.
            parser.parse(is,ch,metadata,parseContext);
            
           // con estas lineas de codigo no me lee todo
           /* String type = tika.detect(f);
            System.out.println (f + " : " + type) ;
            
            texto = tika.parseToString(f);*/
            
            // tenemos el texto
            texto = ch.toString();
            
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch (TikaException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
        return texto;
    }
    
    String remplazar(String texto) {
        return texto.replaceAll("[\\.,¿?!¡;()'\"«»<>:`´‘’-]", "").toLowerCase();
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
