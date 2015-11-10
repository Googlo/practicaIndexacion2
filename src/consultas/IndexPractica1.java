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
public class IndexPractica1 {
    HashMap<String, Integer> frecuencia = new HashMap();
    
    public IndexPractica1(StringTokenizer tokens) {
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
        ArrayList<String> listaTokens = new ArrayList(frecuencia.keySet());//devuelve claves
        return listaTokens;
    }
    
     public Integer getFrequency(String token) {
        return frecuencia.get(token);// devuelve valor
    }
    
   public class MayorFrecuencia implements Comparator {
        @Override
    //Compara sus dos argumentos para la orden. Devuelve un entero negativo, cero o un número entero positivo
    //como el primer argumento es menor que, igual a, o mayor que el segundo.
        public int compare(Object o1, Object o2) {
            HashMap.Entry<String,Integer> e1 = (HashMap.Entry<String, Integer>)o1;
            HashMap.Entry<String,Integer> e2 = (HashMap.Entry<String,Integer>)o2;
            Integer v1 = e1.getValue();
            Integer v2 = e2.getValue();
            return v2.compareTo(v1);
        }
    }
    
    public List<HashMap.Entry<String,Integer>> getTokenListOrdered() {
        List<HashMap.Entry<String,Integer>> listaTokens = new LinkedList(frecuencia.entrySet());
        Collections.sort(listaTokens, new MayorFrecuencia());
        return listaTokens;
    } 
}
