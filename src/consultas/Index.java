/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 *
 * @author moulay
 */
public class Index {
    HashMap<String, Integer> frecuencia = new HashMap();
    
    public Index(StringTokenizer tokens) {
        while(tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            //Devuelve el valor al que se asigna la clave especificada, 
            // o null si este mapa contiene ninguna asignación de la clave
            Integer veces = frecuencia.get(token);
            if(veces == null) {
                veces = 1;
            } else {
                veces++;
            }
            
            frecuencia.put(token, veces);
        }
    }
    
    public ArrayList<String> getTokenList() {
        ArrayList<String> listaTokens = new ArrayList(frecuencia.keySet());
        return listaTokens;
    }
    
     public Integer getFrequency(String token) {
        return frecuencia.get(token);
    }
    
   
   
}
